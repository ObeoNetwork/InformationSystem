/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public class AddAdditionalObjectsWizard extends Wizard implements IImportWizard {
	
	private SpecifyAdditionalObjects2WaysPage additionalResourcesPage;
	private ScaffoldInfo scaffoldInfo;
	
	public AddAdditionalObjectsWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		
		final Collection<EObject> newAdditionalObjects1 = additionalResourcesPage.getAdditionalObjects1();
		final Collection<EObject> newAdditionalObjects2 = additionalResourcesPage.getAdditionalObjects2();
		final boolean hasBeenModified1 = hasBeenModified(scaffoldInfo.getLeftToRightAdditionalObjects(), newAdditionalObjects1);
		final boolean hasBeenModified2 = hasBeenModified(scaffoldInfo.getRightToLeftAdditionalObjects(), newAdditionalObjects2);
		
		if (hasBeenModified1 || hasBeenModified2) {
			Session session = SessionManager.INSTANCE.getSession(scaffoldInfo);
			TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
			RecordingCommand updatingCmd = new RecordingCommand(editingDomain, "Updating additional objects") {
				
				@Override
				protected void doExecute() {
					if (hasBeenModified1) {
						ScaffoldType leftToRightScaffoldType = scaffoldInfo.getLeftToRightTransformationType();
						scaffoldInfo.clearAdditionalObjectsForTransformation(leftToRightScaffoldType);
						for (EObject newObject : newAdditionalObjects1) {
							scaffoldInfo.addAdditionalObjectsForTransformation(newObject, leftToRightScaffoldType);
						}
					}
					if (hasBeenModified2) {
						ScaffoldType rightToleftScaffoldType = scaffoldInfo.getRightToLeftTransformationType();
						scaffoldInfo.clearAdditionalObjectsForTransformation(rightToleftScaffoldType);
						for (EObject newObject : newAdditionalObjects2) {
							scaffoldInfo.addAdditionalObjectsForTransformation(newObject, rightToleftScaffoldType);
						}
					}
				}
			};
			editingDomain.getCommandStack().execute(updatingCmd);
		}
		
		return true;
	}
	
	private boolean hasBeenModified(Collection<EObject> list1, Collection<EObject> list2) {
		if (list1.size() != list2.size()) {
			return true;
		}
		for (EObject eltInList2 : list2) {
			if (list1.contains(eltInList2) == false) {
				return true;
			}
		}
		return false;
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Scaffolding"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		scaffoldInfo = ScaffoldingUtils.getScaffoldInfoFromSelection(selection.getFirstElement());
		additionalResourcesPage = new SpecifyAdditionalObjects2WaysPage(scaffoldInfo);
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(additionalResourcesPage);
    }

	@Override
	public boolean canFinish() {
		return true;
	}
	
}
