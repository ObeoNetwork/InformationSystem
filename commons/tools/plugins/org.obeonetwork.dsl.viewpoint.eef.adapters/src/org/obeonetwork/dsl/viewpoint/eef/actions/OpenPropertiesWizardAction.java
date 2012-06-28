/**
 * 
 */
package org.obeonetwork.dsl.viewpoint.eef.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.obeonetwork.dsl.viewpoint.eef.util.VPDecoratorHelper;

import fr.obeo.dsl.viewpoint.business.api.action.AbstractExternalJavaAction;
import fr.obeo.dsl.viewpoint.diagram.part.ViewpointDiagramEditorPlugin;

/**
 * @author glefur
 *
 */
public class OpenPropertiesWizardAction extends AbstractExternalJavaAction {

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.viewpoint.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		if (selections.size() > 0) {
			try {
				EObject eObject = (EObject) selections.toArray()[0];
				VPDecoratorHelper helper = new VPDecoratorHelper(eObject);
				if (helper.canAdapt()) {
					TransactionalEditingDomain editingDomain = org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(eObject);
					DomainPropertiesEditionContext propertiesEditionContext = new DomainPropertiesEditionContext(null, null, editingDomain, ViewpointDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory(), helper.createSemanticAdapterFromDSemanticDecorator().getEObject());
					WizardEditingOperation wizardEditingCommand = new WizardEditingOperation(propertiesEditionContext);
					wizardEditingCommand.execute(new NullProgressMonitor(), null);
					propertiesEditionContext.dispose();
				}
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
