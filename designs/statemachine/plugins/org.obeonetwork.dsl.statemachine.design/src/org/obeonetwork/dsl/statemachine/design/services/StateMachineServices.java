package org.obeonetwork.dsl.statemachine.design.services;


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
import org.obeonetwork.dsl.statemachine.StateMachine;
import org.obeonetwork.dsl.statemachine.design.Activator;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineParentSelectionContentProvider;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineParentSelectionLabelProvider;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.mda.ecore.extender.business.api.permission.IPermissionAuthority;
import fr.obeo.mda.ecore.extender.business.api.permission.LockStatus;
import fr.obeo.mda.ecore.extender.business.api.permission.PermissionAuthorityRegistry;

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
    public StateMachine changeParentForStateMachine(final StateMachine stateMachine) {
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	
    	AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    	StateMachineParentSelectionLabelProvider labelProvider = new StateMachineParentSelectionLabelProvider(adapterFactory);
    	StateMachineParentSelectionContentProvider contentProvider = new StateMachineParentSelectionContentProvider(adapterFactory);
    	ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(shell, labelProvider, contentProvider);
    	dlg.setHelpAvailable(false);
    	dlg.setValidator(new ISelectionStatusValidator() {
			@Override
			public IStatus validate(Object[] selection) {
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
}
