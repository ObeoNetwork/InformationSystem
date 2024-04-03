/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.actions;

import static org.obeonetwork.utils.common.EObjectUtils.toEObjectList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.utils.common.SiriusInterpreterUtils;

public class ISObjectSelectionWizardAction implements IExternalJavaAction {

	// Input variables
    private static final String PARAMETER_WINDOW_TITLE = "windowTitle";
    private static final String PARAMETER_ICON_PATH = "iconPath";
    private static final String PARAMETER_MESSAGE = "message";
    private static final String PARAMETER_MULTIPLE = "multiple";
    private static final String PARAMETER_ROOTS = "roots";
    private static final String PARAMETER_CHILDREN_EXPRESSION = "childrenExpression";
    private static final String PARAMETER_PRE_SELECTION = "preSelection";
    private static final String PARAMETER_SELECTABLE_CONDITION = "selectableCondition";
    
    // Output variables
    private static final String OUTPUT_RETURN_CODE = "returnCode";
    private static final String OUTPUT_SELECTED_ELEMENTS = "selectedElements";

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		
		EObject context = selections.iterator().next();
        
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(context);
		
    	String windowTitle = Optional.ofNullable((String) parameters.get(PARAMETER_WINDOW_TITLE)).orElse("");
        
        ImageDescriptor image = Optional.ofNullable((String) parameters.get(PARAMETER_ICON_PATH))
        		.map(path -> DiagramUIPlugin.Implementation.findImageDescriptor(path)).orElse(null);
        
        String message = Optional.ofNullable((String) parameters.get(PARAMETER_MESSAGE)).orElse("");
        
        Boolean multiple = Optional.ofNullable((Boolean) parameters.get(PARAMETER_MULTIPLE)).orElse(false);
        
        List<EObject> roots = toEObjectList(parameters.get(PARAMETER_ROOTS));
        
        final String childrenExpression;
        if(parameters.get(PARAMETER_CHILDREN_EXPRESSION) instanceof String) {
        	childrenExpression = "aql:" + parameters.get(PARAMETER_CHILDREN_EXPRESSION);
        } else {
        	childrenExpression = "aql:Sequence{}";
        }
        
        final String selectableCondition;
        if(parameters.get(PARAMETER_SELECTABLE_CONDITION) instanceof String) {
        	selectableCondition = "aql:" + parameters.get(PARAMETER_SELECTABLE_CONDITION);
        } else {
        	selectableCondition = "aql:true";
        }
        
		ISObjectTreeItemWrapper input = new ISObjectTreeItemWrapper(
				(wrappedEObject) -> SiriusInterpreterUtils.evaluateToEObjectList(interpreter, (EObject) wrappedEObject, childrenExpression), 
				(wrappedEObject) -> SiriusInterpreterUtils.evaluateToBoolean(interpreter, (EObject) wrappedEObject, selectableCondition, true));
        for(EObject root : roots) {
        	new ISObjectTreeItemWrapper(input, root);
        }
        
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		image, 
        		input,
        		multiple);
        
        List<EObject> preSelection = toEObjectList(parameters.get(PARAMETER_PRE_SELECTION));
        wizard.setPreSelectedObjects(preSelection);
        
        final int result = wizard.open();
        if (result == Window.OK) {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "OK");
    		interpreter.setVariable(OUTPUT_SELECTED_ELEMENTS, new ArrayList<>(wizard.getSelectedObjects())); // Sirius don't like Sets
        } else {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "CANCEL");
        }
        
        interpreter.unSetVariable(PARAMETER_WINDOW_TITLE);
        interpreter.unSetVariable(PARAMETER_ICON_PATH);
        interpreter.unSetVariable(PARAMETER_MESSAGE);
        interpreter.unSetVariable(PARAMETER_MULTIPLE);
        interpreter.unSetVariable(PARAMETER_ROOTS);
        interpreter.unSetVariable(PARAMETER_CHILDREN_EXPRESSION);
        interpreter.unSetVariable(PARAMETER_PRE_SELECTION);
        interpreter.unSetVariable(PARAMETER_SELECTABLE_CONDITION);
	}
	
	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
