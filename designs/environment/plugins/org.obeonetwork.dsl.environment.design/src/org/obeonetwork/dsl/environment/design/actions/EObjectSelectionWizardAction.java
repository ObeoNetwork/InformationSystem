/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.actions;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.TreeItemWrapper;
import org.eclipse.sirius.common.ui.tools.api.selection.EObjectSelectionWizard;
import org.eclipse.sirius.common.ui.tools.api.selection.WizardDialogClosableByWizard;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class EObjectSelectionWizardAction implements IExternalJavaAction {

	// Input variables
    private static final String PARAMETER_WINDOW_TITLE = "windowTitle";
    private static final String PARAMETER_ICON_PATH = "iconPath";
    private static final String PARAMETER_MESSAGE = "message";
    private static final String PARAMETER_MULTIPLE = "multiple";
    private static final String PARAMETER_ROOTS = "roots";
    private static final String PARAMETER_CHILDREN_EXPRESSION = "childrenExpression";
    
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
        
        String childrenExpression = "";
        if(parameters.get(PARAMETER_CHILDREN_EXPRESSION) instanceof String) {
        	childrenExpression = "aql:" + parameters.get(PARAMETER_CHILDREN_EXPRESSION);
        }
        
        TreeItemWrapper input = new TreeItemWrapper(null, null);
        for(EObject root : roots) {
            TreeItemWrapper rootItem = new TreeItemWrapper(root, input);
            input.getChildren().add(rootItem);
        }
        
        if(!childrenExpression.isEmpty()) {
            for(TreeItemWrapper rootItem : input.getChildren()) {
            	computeInputChildren(rootItem, childrenExpression, interpreter);
            }
        }
        	
        final EObjectSelectionWizard wizard = new EObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		image, 
        		input,
        		DiagramUIPlugin.getPlugin().getItemProvidersAdapterFactory());
        
        wizard.setMany(multiple);
        
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        final WizardDialogClosableByWizard dlg = new WizardDialogClosableByWizard(shell, wizard);
        dlg.setMinimumPageSize(200, 360);
        wizard.setDialog(dlg);
        
        final int result = dlg.open();
        if (result == Window.OK) {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "OK");
    		interpreter.setVariable(OUTPUT_SELECTED_ELEMENTS, wizard.getSelectedEObjects());
        } else {
    		interpreter.setVariable(OUTPUT_RETURN_CODE, "CANCEL");
        }
	}
	
	private void computeInputChildren(TreeItemWrapper treeItem, String childrenExpression, IInterpreter interpreter) {
		
		EObject wrappedEObject = null;
		if(treeItem.getWrappedObject() instanceof EObject) {
			wrappedEObject = (EObject) treeItem.getWrappedObject();
		}
		
		if(wrappedEObject != null) {
			Object evaluation = null;
			try {
				evaluation = interpreter.evaluate(wrappedEObject, childrenExpression);
			} catch (EvaluationException e) {
				e.printStackTrace();
				// Too bad
			}
			List<EObject> children = toEObjectList(evaluation);
			for(EObject child : children) {
				if(!treeItem.knownThisAsAncestor(child)) {
		            TreeItemWrapper childItem = new TreeItemWrapper(child, treeItem);
		            treeItem.getChildren().add(childItem);
		            computeInputChildren(childItem, childrenExpression, interpreter);
				}
			}
		}
		
	}

	private List<EObject> toEObjectList(Object object) {
		
		List<EObject> list = null;
		if(object instanceof List) {
			list = ((List<?>)object).stream().filter(EObject.class::isInstance).map(EObject.class::cast).collect(toList());
		} else if(object instanceof EObject) {
			list = Collections.singletonList((EObject)object);
		} else {
			list = Collections.emptyList();
		}
		
		return list;
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
