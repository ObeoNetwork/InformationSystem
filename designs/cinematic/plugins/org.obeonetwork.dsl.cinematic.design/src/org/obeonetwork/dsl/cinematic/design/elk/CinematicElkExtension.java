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
package org.obeonetwork.dsl.cinematic.design.elk;

import static org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint.FLOW_DIAGRAM_ID;

import java.util.stream.Stream;

import org.eclipse.elk.alg.layered.options.LayerConstraint;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.elk.GmfLayoutCommand;
import org.eclipse.sirius.diagram.elk.IELKLayoutExtension;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.flow.FinalState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.utils.common.ui.services.ElkUtils;

/**
 * Adds ELK Layered constraints to the first initial and final states of Cinematic
 * Flow Diagrams. Other diagram descriptions are left unchanged.
 *
 * @author Obeo
 */
public class CinematicElkExtension implements IELKLayoutExtension {

	/**
	 * Places the first initial state in a separate first layer and the first final
	 * state in a separate last layer, only for Cinematic Flow Diagrams. Other states
	 * keep their existing constraints.
	 */
	@Override
	public void beforeELKLayout(LayoutMapping layoutMapping) {
		if (!isFlowDiagram(ElkUtils.getDDiagram(layoutMapping))) {
			return;
		}

		final Stream<ElkNode> initialStateNodes = ElkUtils
				.streamAllNodes(layoutMapping.getLayoutGraph())
				.filter(node -> getSemanticTarget(node, layoutMapping) instanceof InitialState);
		initialStateNodes.findFirst().ifPresent(node -> node.setProperty(
				LayeredMetaDataProvider.LAYERING_LAYER_CONSTRAINT, LayerConstraint.FIRST_SEPARATE));

		final Stream<ElkNode> finalStateNodes = ElkUtils
				.streamAllNodes(layoutMapping.getLayoutGraph())
				.filter(node -> getSemanticTarget(node, layoutMapping) instanceof FinalState);
		finalStateNodes.findFirst().ifPresent(node -> node.setProperty(
				LayeredMetaDataProvider.LAYERING_LAYER_CONSTRAINT, LayerConstraint.LAST_SEPARATE));
	}

	/**
	 * Checks the description name and its origin to identify a Cinematic Flow Diagram.
	 * Both installed plugin and workspace project descriptions are supported.
	 */
	private boolean isFlowDiagram(DDiagram diagram) {
		if (diagram == null) {
			return false;
		}
		DiagramDescription description = diagram.getDescription();
		return description != null
				&& FLOW_DIAGRAM_ID.equals(description.getName())
				&& description.eResource() != null
				&& ElkUtils.isDescriptionFromPlugin(Activator.PLUGIN_ID, diagram);
	}

	/**
	 * Resolves the semantic target through the node's graphical edit part and GMF view.
	 * Nodes without a graphical edit part, a GMF view or a Sirius diagram element
	 * have no semantic target here and are ignored by the state filters.
	 *
	 * @param node the ELK node to resolve
	 * @param layoutMapping mapping from ELK elements to graphical objects
	 * @return the semantic target, or null if any intermediate object has an unexpected type
	 *         or the Sirius element has no target
	 */
	private EObject getSemanticTarget(ElkNode node, LayoutMapping layoutMapping) {
		Object mappedObject = layoutMapping.getGraphMap().get(node);
		if (!(mappedObject instanceof GraphicalEditPart editPart)) {
			return null;
		}
		if (!(editPart.getModel() instanceof View view)) {
			return null;
		}
		if (!(view.getElement() instanceof DDiagramElement diagramElement)) {
			return null;
		}
		return diagramElement.getTarget();
	}

	@Override
	public void afterELKLayout(LayoutMapping layoutMapping) {
		// No post-processing of the computed layout is needed.
	}

	@Override
	public void afterGMFCommandApplied(GmfLayoutCommand gmfLayoutCommand, LayoutMapping layoutMapping) {
		// No additional changes are needed after applying the layout to GMF.
	}
}
