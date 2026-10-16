/* ************************************************************************* *
 * Copyright (c) 2026 Obeo.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Obeo - initial API and implementation.
 *
 * ************************************************************************* */
package org.obeonetwork.utils.common.ui.services;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.core.util.ElkUtil;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkEdgeSection;
import org.eclipse.elk.graph.ElkGraphElement;
import org.eclipse.elk.graph.ElkLabel;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.elk.ElkDiagramLayoutConnector;
import org.eclipse.sirius.ext.gmf.runtime.editparts.GraphicalHelper;

/**
 * Utilities for traversing ELK graphs and adapting their layout to Sirius diagrams.
 *
 * @author Obeo
 */
public final class ElkUtils {

	/**
	 * Stores an edge, its endpoints, its container and its mapped graphical object.
	 * <p>
	 * Used to restore an edge removed from the layout graph. The edge is expected
	 * to have exactly one source and one target.
	 * </p>
	 * <p>
	 * Intended use: capture these references, temporarily remove the edge so it
	 * does not influence node layout, then restore it with {@link ElkUtils#createEdge}
	 * using the new node positions. The edge itself is retained, not copied.
	 * </p>
	 *
	 * @param edge      the edge
	 * @param part      graphical object associated with the edge in the layout mapping
	 * @param container node containing the edge
	 * @param source    source node or port
	 * @param target    target node or port
	 */
	public record EdgeDescription(
			ElkEdge edge,
			Object part,
			ElkNode container,
			ElkConnectableShape source,
			ElkConnectableShape target) {

		/**
		 * Captures the current endpoints, container and graphical mapping of an edge.
		 * The source and target lists must both be non-empty.
		 *
		 * @param edge          edge to describe
		 * @param layoutMapping mapping from ELK elements to graphical objects
		 */
		EdgeDescription(ElkEdge edge, LayoutMapping layoutMapping) {
			this(
					edge,
					layoutMapping.getGraphMap().get(edge),
					edge.getContainingNode(),
					edge.getSources().get(0),
					edge.getTargets().get(0));
		}
	}

	/**
	 * Private constructor to avoid instantiation.
	 */
	private ElkUtils() {
	}

	/**
	 * Set the port label next to the port, on its {@code portSide} side, and
	 * centered on the other axis:
	 * <UL>
	 * <LI>West: On the left of the port, vertically centered,</LI>
	 * <LI>East: On the right of the port, vertically centered,</LI>
	 * <LI>South: Under the port, horizontally centered,</LI>
	 * <LI>North: Above the port, horizontally centered.</LI>
	 * </UL>
	 * Only ports with exactly one label are updated. Other ports and unsupported
	 * sides are left unchanged.
	 *
	 * @param port     The port for which to set the label location.
	 * @param portSide The side where setting the label
	 */
	public static void alignPortLabel(ElkPort port, PortSide portSide) {
		if (port.getLabels().size() != 1) {
			// Only a single label can be positioned by this method.
			return;
		}
		ElkLabel label = port.getLabels().get(0);

		// Start with the label centered on both axes, then offset it on the chosen side.
		double x = (port.getWidth() - label.getWidth()) / 2;
		double y = (port.getHeight() - label.getHeight()) / 2;

		switch (portSide) {
		case WEST:
			x = -label.getWidth() - 1;
			break;
		case EAST:
			x = port.getWidth() + 1;
			break;
		case SOUTH:
			y = port.getHeight() + 1;
			break;
		case NORTH:
			y = -label.getHeight() - 1;
			break;

		default:
			// no change
			return;
		}
		label.setLocation(x, y);
	}

	/**
	 * Reverses the edge endpoints, section endpoints and bend point order.
	 * <p>
	 * The edge must have exactly one source and one target.
	 * </p>
	 *
	 * @param elkEdge The edge to reverse.
	 * @throws IllegalArgumentException if the edge does not have exactly one source
	 *                                  and one target
	 */
	public static void reverseEdge(ElkEdge elkEdge) throws IllegalArgumentException {
		if (!isRegular(elkEdge)) {
			throw new IllegalArgumentException("Cannot reverse \"hyper\" edge"); //$NON-NLS-1$
		}
		ElkConnectableShape source = elkEdge.getSources().remove(0);
		ElkConnectableShape target = elkEdge.getTargets().remove(0);

		elkEdge.getSources().add(target);
		elkEdge.getTargets().add(source);

		for (ElkEdgeSection section : elkEdge.getSections()) {
			double oldStartX = section.getStartX();
			double oldStartY = section.getStartY();
			section.setStartX(section.getEndX());
			section.setStartY(section.getEndY());
			section.setEndX(oldStartX);
			section.setEndY(oldStartY);

			ECollections.reverse(section.getBendPoints());
		}
	}

	/**
	 * Checks whether the diagram description URI belongs to the given plugin.
	 * Both installed plugin URIs and workspace project URIs are accepted.
	 * The description must be attached to a resource.
	 *
	 * @param pluginId the ID of plugin
	 * @param diagram  the diagram to evaluate
	 * @return true if description is provided by plugin
	 */
	public static boolean isDescriptionFromPlugin(String pluginId, DDiagram diagram) {
		String descriptionUri = diagram.getDescription().eResource().getURI().toString();
		String pluginUriPrefix = "platform:/plugin/" + pluginId + '/'; //$NON-NLS-1$
		if (descriptionUri.startsWith(pluginUriPrefix)) {
			return true;
		}
		String workspaceUriPrefix = "platform:/resource/" + pluginId + '/'; //$NON-NLS-1$
		return descriptionUri.startsWith(workspaceUriPrefix);
	}

	/**
	 * Checks whether an edge has exactly one source and exactly one target.
	 *
	 * @param edge ELK element
	 * @return true if source size is 1 and target size is 1
	 */
	public static boolean isRegular(ElkEdge edge) {
		return edge.getSources().size() == 1 && edge.getTargets().size() == 1;
	}

	/**
	 * Streams matching ports of the root node and all its descendants.
	 * The filter selects ports without preventing traversal of child nodes.
	 *
	 * @param root   the node to explore
	 * @param filter the predicate to select port
	 * @return a stream of port
	 */
	public static Stream<ElkPort> streamAllPorts(ElkNode root, Predicate<? super ElkPort> filter) {
		return streamAllElements(root, ElkNode::getPorts, filter);
	}

	/**
	 * Streams matching edges contained by the root node and all its descendants.
	 * The filter selects edges without preventing traversal of child nodes.
	 *
	 * @param root   the node to explore
	 * @param filter the predicate to select edge
	 * @return a stream of edge
	 */
	public static Stream<ElkEdge> streamAllEdges(ElkNode root, Predicate<? super ElkEdge> filter) {
		return streamAllElements(root, ElkNode::getContainedEdges, filter);
	}

	/**
	 * Streams all descendant nodes, excluding the root node itself.
	 *
	 * @param root the node to explore
	 * @return a stream of descendant nodes
	 */
	public static Stream<ElkNode> streamAllNodes(ElkNode root) {
		return streamAllNodes(root, node -> true);
	}

	/**
	 * Streams matching descendant nodes, excluding the root node itself.
	 * The filter selects nodes without preventing traversal of their children.
	 *
	 * @param root   the node to explore
	 * @param filter the predicate to select node
	 * @return a stream of node
	 */
	public static Stream<ElkNode> streamAllNodes(ElkNode root, Predicate<? super ElkNode> filter) {
		return streamAllElements(root, ElkNode::getChildren, filter);
	}

	/**
	 * Collects matching elements from each node in the subtree rooted at {@code root}.
	 * The accessor selects the collection to visit (children, ports or contained edges).
	 * All child nodes are traversed, regardless of the filter results.
	 */
	private static <T extends ElkGraphElement> Stream<T> streamAllElements(ElkNode root,
			Function<ElkNode, List<T>> getElements, Predicate<? super T> filter) {
		Stream<T> elements = getElements.apply(root).stream().filter(filter);

		Stream<T> descendantElements = root.getChildren().stream()
				.flatMap(child -> streamAllElements(child, getElements, filter));
		return Stream.concat(elements, descendantElements);
	}

	/**
	 * Restores an existing edge using its captured description.
	 * Its source and target lists are expected to have been cleared beforehand,
	 * and it must already have at least one section. The first section endpoints
	 * are recomputed and its bend points are cleared.
	 *
	 * @param description   description of an edge
	 * @param layoutMapping mapping using the edge
	 * @return edge
	 */
	public static ElkEdge createEdge(EdgeDescription description, LayoutMapping layoutMapping) {
		ElkEdge edge = description.edge;

		// Restore the endpoints and containment of the existing edge.
		edge.getSources().add(description.source);
		edge.getTargets().add(description.target);
		description.container.getContainedEdges().add(edge);

		// Compute the coordinates used to position the first edge section.
		KVector sourcePosition = getParentRelativeVector(description.source, description.container);
		KVector targetPosition = getParentRelativeVector(description.target, description.container);

		ElkEdgeSection section = edge.getSections().get(0);

		Rectangle sourceArea = createAreaAtPoint(sourcePosition, description.source);
		Rectangle targetArea = createAreaAtPoint(targetPosition, description.target);

		computeSectionEnd(section, true, sourceArea, targetArea, sourcePosition);
		computeSectionEnd(section, false, sourceArea, targetArea, targetPosition);

		// Clear bend points on the first section to make it straight.
		section.getBendPoints().clear();

		// Restore the graphical mapping so the edge participates in layout application.
		layoutMapping.getGraphMap().put(edge, description.part);

		return edge;
	}

	/**
	 * Converts the stored shape position to absolute coordinates using the container,
	 * then to coordinates relative to the node associated with the shape.
	 *
	 * @param shape     the node or port whose position is converted
	 * @param container the container to be relative to
	 * @return the vector
	 */
	private static KVector getParentRelativeVector(ElkConnectableShape shape, ElkNode container) {
		KVector point = new KVector(shape.getX(), shape.getY());
		return ElkUtil.toRelative(ElkUtil.toAbsolute(point, container), ElkGraphUtil.connectableShapeToNode(shape));
	}

	/**
	 * Builds a rectangle at the given position, using the shape dimensions.
	 */
	private static PrecisionRectangle createAreaAtPoint(KVector point, ElkConnectableShape shape) {
		return new PrecisionRectangle(point.x, point.y, shape.getWidth(), shape.getHeight());
	}

	/**
	 * Places one section endpoint at the intersection of the center-to-center line
	 * with the corresponding shape rectangle, or at the fallback position.
	 */
	private static void computeSectionEnd(ElkEdgeSection section, boolean sourceEnd, Rectangle sourceArea,
			Rectangle targetArea, KVector fallbackPosition) {
		Rectangle endpointArea = sourceEnd ? sourceArea : targetArea;

		Point intersection = GraphicalHelper
				.getIntersection(sourceArea.getCenter(), targetArea.getCenter(), endpointArea, sourceEnd)
				.orElse(new PrecisionPoint(fallbackPosition.x, fallbackPosition.y));

		if (sourceEnd) {
			section.setStartLocation(intersection.preciseX(), intersection.preciseY());
		} else {
			section.setEndLocation(intersection.preciseX(), intersection.preciseY());
		}
	}

	/**
	 * Assigns a side to the port and fixes the sides of all ports on its parent node.
	 *
	 * @param port the port to position
	 * @param side the expected side
	 */
	public static void forceSide(ElkPort port, PortSide side) {
		port.setProperty(CoreOptions.PORT_SIDE, side);
		port.getParent().setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE);
	}

	/**
	 * Returns the Sirius diagram associated with the layout mapping.
	 * The mapping must provide a diagram edit part.
	 *
	 * @param layoutMapping The ELK layout mapping
	 * @return the semantic diagram, or {@code null} if the GMF diagram element is
	 *         not a {@link DDiagram}
	 */
	public static DDiagram getDDiagram(LayoutMapping layoutMapping) {
		// Retrieve the root diagram editPart
		DiagramEditPart diagramEditPart = layoutMapping.getProperty(ElkDiagramLayoutConnector.DIAGRAM_EDIT_PART);

		// Retrieve the GMF diagram
		Diagram gmfDiagram = diagramEditPart.getDiagramView();
		return gmfDiagram.getElement() instanceof DDiagram ? (DDiagram) gmfDiagram.getElement() : null;
	}
}
