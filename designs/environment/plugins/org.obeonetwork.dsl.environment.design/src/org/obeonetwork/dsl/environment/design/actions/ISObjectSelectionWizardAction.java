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
import org.eclipse.sirius.common.ui.tools.api.selection.WizardDialogClosableByWizard;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.TreeItemWrapper;

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
        
        String childrenExpression = null;
        if(parameters.get(PARAMETER_CHILDREN_EXPRESSION) instanceof String) {
        	childrenExpression = "aql:" + parameters.get(PARAMETER_CHILDREN_EXPRESSION);
        }
        
        List<EObject> preSelection = toEObjectList(parameters.get(PARAMETER_PRE_SELECTION));
        
        String selectableCondition = null;
        if(parameters.get(PARAMETER_SELECTABLE_CONDITION) instanceof String) {
        	selectableCondition = "aql:" + parameters.get(PARAMETER_SELECTABLE_CONDITION);
        }
        
        TreeItemWrapper input = new TreeItemWrapper(null, null);
        for(EObject root : roots) {
            TreeItemWrapper treeRoot = new TreeItemWrapper(root, input);
            if(selectableCondition != null) {
                try {
                	treeRoot.setSelectable(interpreter.evaluateBoolean(root, selectableCondition));
    			} catch (EvaluationException e) {
    				e.printStackTrace();
    				// Bad luck
    			}
            }
        }
        
        if(childrenExpression != null) {
            for(TreeItemWrapper rootItem : input.getChildren()) {
            	computeInputChildren(rootItem, childrenExpression, selectableCondition, interpreter);
            }
        }
        	
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		image, 
        		input,
        		multiple,
        		preSelection,
        		DiagramUIPlugin.getPlugin().getItemProvidersAdapterFactory());
        
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
	
	private void computeInputChildren(TreeItemWrapper treeItem, String childrenExpression, String selectableCondition, IInterpreter interpreter) {
		
		EObject wrappedEObject = null;
		if(treeItem.getWrappedObject() instanceof EObject) {
			wrappedEObject = (EObject) treeItem.getWrappedObject();
		}
		
		if(wrappedEObject != null) {
			List<EObject> children = null;
			try {
				children = toEObjectList(interpreter.evaluate(wrappedEObject, childrenExpression));
			} catch (EvaluationException e) {
				e.printStackTrace();
				// Bad luck
			}
			if(children != null) {
				for(EObject child : children) {
					if(!treeItem.knownAsAncestor(child)) {
			            TreeItemWrapper childItem = new TreeItemWrapper(child, treeItem);
			            if(selectableCondition != null) {
				            try {
				            	childItem.setSelectable(interpreter.evaluateBoolean(child, selectableCondition));
							} catch (EvaluationException e) {
								e.printStackTrace();
								// Bad luck
							}
			            }

			            computeInputChildren(childItem, childrenExpression, selectableCondition, interpreter);
					}
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
