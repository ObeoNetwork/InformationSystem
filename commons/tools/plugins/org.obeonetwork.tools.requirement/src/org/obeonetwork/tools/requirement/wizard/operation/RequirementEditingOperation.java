/**
 * 
 */
package org.obeonetwork.tools.requirement.wizard.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.EEFWizardDialog;
import org.eclipse.jface.window.Window;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.wizard.RequirementEditingWizard;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RequirementEditingOperation extends WizardEditingOperation {

	/**
	 * @param editingContext
	 */
	public RequirementEditingOperation(DomainPropertiesEditionContext editingContext) {
		super(editingContext);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//		editingContext.initializeRecorder();
		RequirementEditingWizard wizard = new RequirementEditingWizard(editingContext, editingContext.getAdapterFactory(), editingContext.getEObject());
		EEFWizardDialog wDialog = new EEFWizardDialog(EditingUtils.getShell(), wizard);
		int open = wDialog.open();
		ChangeDescription description = editingContext.getChangeRecorder().endRecording();
		if (open == Window.OK) {
			if (wizard.getOwningCategory() != null) {
				Category category = wizard.getOwningCategory();
				if (editingContext.getEObject().eContainer() != category) {
					category.getRequirements().add((Requirement) editingContext.getEObject());
				}
			}
			return Status.OK_STATUS;
		} else {
			description.applyAndReverse();
			return Status.CANCEL_STATUS;
		}
	}
	
	

}
