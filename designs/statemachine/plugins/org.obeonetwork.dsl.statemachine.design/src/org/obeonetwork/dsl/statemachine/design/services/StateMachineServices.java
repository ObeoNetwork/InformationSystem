package org.obeonetwork.dsl.statemachine.design.services;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.statemachine.AbstractState;
import org.obeonetwork.dsl.statemachine.Region;
import org.obeonetwork.dsl.statemachine.State;
import org.obeonetwork.dsl.statemachine.StateMachine;
import org.obeonetwork.dsl.statemachine.design.Activator;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineParentSelectionContentProvider;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineParentSelectionLabelProvider;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;
import org.eclipse.sirius.ecore.extender.business.api.permission.LockStatus;
import org.eclipse.sirius.ecore.extender.business.api.permission.PermissionAuthorityRegistry;

/**
 * Java services for the Statemachine diagram.
 * 
 * @author sthibaudeau
 */
public class StateMachineServices {

    /**
     * Change the parent of an interaction with the 
     * @param stateMachine
     * @return
     */
    public StateMachine changeParentForStateMachine(EObject context) {
    	StateMachine stateMachine = null;    
    	if (context instanceof StateMachine){
    		stateMachine = (StateMachine)context;
    	}else{
    		EObject container = context.eContainer();
    		while (!(container instanceof StateMachine) && container.eContainer() != null){
    			container = container.eContainer();    			
    		}
    		stateMachine = (StateMachine)container;
    	}
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	
    	AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    	StateMachineParentSelectionLabelProvider labelProvider = new StateMachineParentSelectionLabelProvider(adapterFactory);
    	StateMachineParentSelectionContentProvider contentProvider = new StateMachineParentSelectionContentProvider(adapterFactory);
    	ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(shell, labelProvider, contentProvider);
    	dlg.setHelpAvailable(false);
    	dlg.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length > 0) {
					Object selectedObject = selection[0];
					if (selectedObject instanceof EObject) {
						IPermissionAuthority authority = PermissionAuthorityRegistry.getDefault().getPermissionAuthority((EObject)selectedObject);
						if (authority != null) {
							LockStatus lockStatus = authority.getLockStatus((EObject)selectedObject);
							if (LockStatus.LOCKED_BY_OTHER.equals(lockStatus)) {
								return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "This element is locked by another user");
							}
						}
					}
				}
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
			}
		});
    	
    	dlg.setTitle("Change statemachine's parent");
    	dlg.setMessage("Select the new parent for the statemachine");
    	
    	Session session = SessionManager.INSTANCE.getSession(stateMachine);
		if (session == null) {
			return stateMachine;
		}
		dlg.setInput(session.getSemanticResources().toArray());
		dlg.setInitialSelection(stateMachine.eContainer());
    	
    	int btn = dlg.open();
    	if (btn == Dialog.OK) {
    		Object selectedElement = dlg.getFirstResult();
    		if (selectedElement instanceof ObeoDSMObject && selectedElement != stateMachine.eContainer()) {
    			// Change the parent
    			((ObeoDSMObject)selectedElement).getBehaviours().add(stateMachine);
    		}
    	}
    	
    	return stateMachine;
    }
    
    public String evaluateLabel(EObject context){
    	//['State_' + container.oclAsType(statemachine::StateMachine).states->filter(statemachine::State)->size()/]
    	String label = "State_";
    	List<AbstractState> abstractStates = null;
    	if (context.eContainer() instanceof StateMachine){
    		abstractStates = ((StateMachine)context.eContainer()).getStates();    		
    	}else if (context.eContainer() instanceof Region){
    		abstractStates = ((Region)context.eContainer()).getStates();  
    	}
    	List<State> states = new ArrayList<State>();
		for (AbstractState absState : abstractStates){
			if (absState instanceof State){
				states.add((State)absState);
			}
		}
		return label + states.size();
    }
}
