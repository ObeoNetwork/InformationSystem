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

import java.util.stream.Stream;

import org.eclipse.elk.alg.layered.options.LayerConstraint;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.elk.GmfLayoutCommand;
import org.eclipse.sirius.diagram.elk.IELKLayoutExtension;
import org.eclipse.sirius.diagram.model.business.internal.spec.DNodeSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeEditPart;
import org.obeonetwork.dsl.cinematic.flow.FinalState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.utils.common.ui.services.ElkUtils;

/**
 * @author Vincent BOUSSAUD
 *
 */
public class CinematicElkExtension implements IELKLayoutExtension {

	/**
	 * 
	 */
	public CinematicElkExtension() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Add specific constraints to cinematic element for their layout
	 */
	@Override
	public void beforeELKLayout(LayoutMapping layoutMapping) {
		final Stream<ElkNode> initialNodes = ElkUtils
				.streamAllNodes(layoutMapping.getLayoutGraph(), ElkNode.class::isInstance)
				.filter(eNode -> (layoutMapping.getGraphMap().get(eNode) instanceof GraphicalEditPart)
						? ((DDiagramElement) ((View)((GraphicalEditPart) layoutMapping.getGraphMap().get(eNode))
								.getModel()).getElement()).getTarget() instanceof InitialState
						: false);
		initialNodes.findFirst().ifPresent(node -> node.setProperty(LayeredMetaDataProvider.LAYERING_LAYER_CONSTRAINT,
				LayerConstraint.FIRST_SEPARATE));
		final Stream<ElkNode> finalNodes = ElkUtils
				.streamAllNodes(layoutMapping.getLayoutGraph(), ElkNode.class::isInstance)
				.filter(eNode -> (layoutMapping.getGraphMap().get(eNode) instanceof GraphicalEditPart)
						? ((DDiagramElement) ((View)((GraphicalEditPart) layoutMapping.getGraphMap().get(eNode))
								.getModel()).getElement()).getTarget() instanceof FinalState
								: false);
		finalNodes.findFirst().ifPresent(node -> node.setProperty(LayeredMetaDataProvider.LAYERING_LAYER_CONSTRAINT,
				LayerConstraint.LAST_SEPARATE));
	}

	@Override
	public void afterELKLayout(LayoutMapping layoutMapping) {
		// nothing to do
		
	}

	@Override
	public void afterGMFCommandApplied(GmfLayoutCommand gmfLayoutCommand, LayoutMapping layoutMapping) {
		// nothing to do
		
	}

}
