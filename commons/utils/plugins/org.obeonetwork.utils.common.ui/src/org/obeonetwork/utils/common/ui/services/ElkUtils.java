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

import com.google.common.collect.BiMap;
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
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.elk.ElkDiagramLayoutConnector;
import org.eclipse.sirius.ext.gmf.runtime.editparts.GraphicalHelper;

/**
 * Common methods for ELK layout extension.
 *
 * @author Nicolas Peransin
 */
public final class ElkUtils {

	/**
	 * Description of an edge.
	 * <p>
	 * This description is used to restore extracted edge. It must be regular.
	 * </p>
	 * 
	 * @param element   the edge
	 * @param source    element the edge comes from
	 * @param target    element the edge goes to
	 * @param container element containing the edge
	 * @param part      mapping of this edge
	 */
	public record EdgeDescription(ElkEdge element, Object part, ElkNode container,
			// ends
			ElkConnectableShape source, ElkConnectableShape target) {

		/**
		 * Constructor.
		 * 
		 * @param element       edge to describe
		 * @param layoutMapping
		 */
		EdgeDescription(ElkEdge element, LayoutMapping layoutMapping) {
			this(element, layoutMapping.getGraphMap().get(element), element.getContainingNode(),
					// ends
					element.getSources().get(0), element.getTargets().get(0));
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
	 * This method can only be used for port with one label. It has no effect in
	 * other case.
	 *
	 * @param port     The port for which to set the label location.
	 * @param portSide The side where setting the label
	 */
	public static void alignPortLabel(ElkPort port, PortSide portSide) {
		if (port.getLabels().size() != 1) {
			// Cannot deal with multi-label. Not in Sirius 6.4x.
			return;
		}
		ElkLabel label = port.getLabels().get(0);

		// By default, we have the center

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
	 * This method inverses the source and the target of the edge.
	 * <p>
	 * The source and target coordinates are also inverted (and the sections if
	 * any).
	 * </p>
	 *
	 * @param elkEdge The edge to reverse.
	 * @throws IllegalArgumentException In case of the <code>elkEdge</code> is an
	 *                                  hyperedge.
	 */
	public static void reverseEdge(ElkEdge elkEdge) throws IllegalArgumentException {
		if (isRegular(elkEdge)) { //
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
	 * Evaluates if the description of a diagram is provided by a plugin with
	 * provided ID.
	 * 
	 * @param pluginId the ID of plugin
	 * @param diagram  the diagram to evaluate
	 * @return true if description is provided by plugin
	 */
	public static boolean isDescriptionFromPlugin(String pluginId, DDiagram diagram) {
		String path = diagram.getDescription().eResource().getURI().toString();
		String pluginBase = "platform:/plugin/" + pluginId + '/'; //$NON-NLS-1$
		if (path.startsWith(pluginBase)) {
			return true;
		}
		String resBase = "platform:/resource/" + pluginId + '/'; //$NON-NLS-1$
		return path.startsWith(resBase);
	}

	/**
	 * Evaluates if an edge is not hyper edge and well-formed.
	 * 
	 * @param edge ELK element
	 * @return true if source size is 1 and target size is 1
	 */
	public static boolean isRegular(ElkEdge edge) {
		return edge.getSources().size() == 1 && edge.getTargets().size() == 1;
	}

	/**
	 * Creates a stream of all ports in this node and inside it.
	 * 
	 * @param root   the node to explore
	 * @param filter the predicate to select port
	 * @return a stream of port
	 */
	public static Stream<ElkPort> streamAllPorts(ElkNode root, Predicate<? super ElkPort> filter) {
		return streamAllElements(root, ElkNode::getPorts, filter);
	}

	/**
	 * Creates a stream of all edges in this node and inside it.
	 * 
	 * @param root   the node to explore
	 * @param filter the predicate to select edge
	 * @return a stream of edge
	 */
	public static Stream<ElkEdge> streamAllEdges(ElkNode root, Predicate<? super ElkEdge> filter) {
		return streamAllElements(root, ElkNode::getContainedEdges, filter);
	}

	/**
	 * Creates a stream of all nodes in this node and inside it.
	 * 
	 * @param root   the node to explore
	 * @param filter the predicate to select node
	 * @return a stream of node
	 */
	public static Stream<ElkNode> streamAllNodes(ElkNode root, Predicate<? super ElkNode> filter) {
		return streamAllElements(root, ElkNode::getChildren, filter);
	}

	private static <T extends ElkGraphElement> Stream<T> streamAllElements(ElkNode root,
			Function<ElkNode, List<T>> property, Predicate<? super T> filter) {
		// We collect contained edges with source port and target port with the same
		// parent.
		Stream<T> nodes = property.apply(root).stream().filter(filter);

		// We recursively collect them for each child
		Stream<T> childrenNodes = root.getChildren().stream()
				.flatMap(child -> streamAllElements(child, property, filter));
		return Stream.concat(nodes, childrenNodes);
	}

	/**
	 * Recreates an edge using it description.
	 * 
	 * @param description   description of an edge
	 * @param layoutMapping mapping using the edge
	 * @return edge
	 */
	public static ElkEdge createEdge(EdgeDescription description, LayoutMapping layoutMapping) {
		ElkEdge edge = description.element;

		// Restore edge properties
		edge.getSources().add(description.source);
		edge.getTargets().add(description.target);
		description.container.getContainedEdges().add(edge);

		// Compute ends location
		KVector sourceKVector = getParentRelativeVector(description.source, description.container);
		KVector targetKVector = getParentRelativeVector(description.target, description.container);

		ElkEdgeSection section = edge.getSections().get(0);

		Rectangle sourceArea = createAreaAtPoint(sourceKVector, description.source);
		Rectangle targetArea = createAreaAtPoint(targetKVector, description.target);

		computeSectionEnd(section, true, sourceArea, targetArea, sourceKVector);
		computeSectionEnd(section, false, sourceArea, targetArea, targetKVector);

		// Remove potential bendpoints to have a straight edge
		section.getBendPoints().clear();

		// Add the edge in the mapping to be considered in the next steps (apply ELK
		// layout to Sirius)
		layoutMapping.getGraphMap().put(edge, description.part);

		return edge;
	}

	/**
	 * Returns the relative vector of provided shape.
	 * 
	 * @param element   the graphical element
	 * @param container the container to be relative to
	 * @return the vector
	 */
	private static KVector getParentRelativeVector(ElkConnectableShape it, ElkNode container) {
		KVector point = new KVector(it.getX(), it.getY());
		return ElkUtil.toRelative(ElkUtil.toAbsolute(point, container), ElkGraphUtil.connectableShapeToNode(it));
	}

	private static PrecisionRectangle createAreaAtPoint(KVector point, ElkConnectableShape shape) {
		return new PrecisionRectangle(point.x, point.y, shape.getWidth(), shape.getHeight());
	}

	private static void computeSectionEnd(ElkEdgeSection section, boolean forSource, Rectangle sourceArea,
			Rectangle targetArea, KVector byDefault) {
		Rectangle containingArea = forSource ? sourceArea : targetArea;

		Point intersection = GraphicalHelper
				.getIntersection(sourceArea.getCenter(), targetArea.getCenter(), containingArea, forSource) // default
																											// should be
																											// the same
																											// place.
				.orElse(new PrecisionPoint(byDefault.x, byDefault.y));

		if (forSource) {
			section.setStartLocation(intersection.preciseX(), intersection.preciseY());
		} else {
			section.setEndLocation(intersection.preciseX(), intersection.preciseY());
		}
	}

	/**
	 * Forces the side of the port.
	 * 
	 * @param port the port to hint
	 * @param side the expected side
	 */
	public static void forceSide(ElkPort port, PortSide side) {
		port.setProperty(CoreOptions.PORT_SIDE, side);
		port.getParent().setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_SIDE);
	}
	
	/**
	 * Return the {@link DDiagram} concerned by this {@link LayoutMapping}.
	 *
	 * @param layoutMapping The ELK layout mapping
	 * @return the {@link DiagramDescription} name of the {@link DDiagram} concerned
	 *         by this {@link LayoutMapping}.
	 */
	public static DDiagram getDDiagram(LayoutMapping layoutMapping) {
		// Retrieve the root diagram editPart
		DiagramEditPart diagramEditPart = layoutMapping.getProperty(ElkDiagramLayoutConnector.DIAGRAM_EDIT_PART);

		// Retrieve the GMF diagram
		Diagram gmfDiagram = diagramEditPart.getDiagramView();
		return gmfDiagram.getElement() instanceof DDiagram ? (DDiagram) gmfDiagram.getElement() : null;
	}
}

