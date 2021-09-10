/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.sirius.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.ISiriusEditPart;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.utils.sirius.services.EObjectUtils;

public class SiriusEditPartPropertyTester extends PropertyTester {

	private final static String PROP_VIEWPOINT_ID = "viewpointId";
	private final static String PROP_DIAGRAM_NAME = "diagramName";
	private final static String PROP_MAPPING_NAME = "mappingName";
	
	public SiriusEditPartPropertyTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		ISiriusEditPart siriusEditPart = (ISiriusEditPart) receiver;
		
		if(PROP_VIEWPOINT_ID.equals(property)) {
			return testViewpointId(siriusEditPart, (String)expectedValue);
		} else if(PROP_DIAGRAM_NAME.equals(property)) {
			return testDiagramName(siriusEditPart, (String)expectedValue);
		} else if(PROP_MAPPING_NAME.equals(property)) {
			return testMappingName(siriusEditPart, (String)expectedValue);
		} 
		
		return false;
	}


	private boolean testDiagramName(ISiriusEditPart siriusEditPart, String expectedDiagramName) {
		DDiagram dDiagram = getDDiagram(siriusEditPart);
		if(dDiagram != null) {
			DiagramDescription description = dDiagram.getDescription();
			return description.getName().equals(expectedDiagramName);
		}
		
		return false;
	}

	private boolean testViewpointId(ISiriusEditPart siriusEditPart, String expectedViewpointId) {
		DDiagram dDiagram = getDDiagram(siriusEditPart);
		if(dDiagram != null) {
			DiagramDescription description = dDiagram.getDescription();
			Viewpoint viewpoint = EObjectUtils.getContainerOrSelf(description, Viewpoint.class);
			return viewpoint.getName().equals(expectedViewpointId);
		}
		
		return false;
	}

	private boolean testMappingName(ISiriusEditPart siriusEditPart, String expectedMappingName) {
		if(siriusEditPart instanceof IDDiagramEditPart) {
			return testDiagramName(siriusEditPart, expectedMappingName);
		} else if(siriusEditPart instanceof IDiagramElementEditPart) {
			IDiagramElementEditPart diagramElementEditPart = (IDiagramElementEditPart) siriusEditPart;
			DDiagramElement diagramElement = diagramElementEditPart.resolveDiagramElement();
			return expectedMappingName.equals(diagramElement.getMapping().getName());
		}
		return false;
	}

	private DDiagram getDDiagram(ISiriusEditPart siriusEditPart) {
		DDiagram dDiagram = null;
		try {
			if(siriusEditPart instanceof IDDiagramEditPart) {
				IDDiagramEditPart dDiagramEditPart = (IDDiagramEditPart) siriusEditPart;
				dDiagram = dDiagramEditPart.resolveDDiagram().get();
			} else if(siriusEditPart instanceof IDiagramElementEditPart) {
				IDiagramElementEditPart diagramElementEditPart = (IDiagramElementEditPart) siriusEditPart;
				DDiagramElement diagramElement = diagramElementEditPart.resolveDiagramElement();
				dDiagram = diagramElement.getParentDiagram();
			}
		} catch(LifecycleException e) {
			// So what ?
		}
		
		return dDiagram;
	}
}
