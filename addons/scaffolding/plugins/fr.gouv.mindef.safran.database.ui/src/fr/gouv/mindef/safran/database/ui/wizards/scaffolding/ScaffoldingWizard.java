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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public class ScaffoldingWizard extends Wizard implements IImportWizard {
	
	private ScaffoldType scaffoldType;
	private EObject source;
	private EObject target;
	
	private SpecifyAdditionalObjectsPage additionalResourcesPage;
	
	public ScaffoldingWizard(ScaffoldType scaffoldType) {
		super();
		this.scaffoldType = scaffoldType;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		ScaffoldingOperation op = new ScaffoldingOperation(
										scaffoldType,
										source,
										target,
										additionalResourcesPage.getAdditionalObjects());
		ScaffoldingUtils.executeScaffolding(op, getShell());
		return true;
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Scaffolding"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		initSourceAndTarget(selection);
		additionalResourcesPage = new SpecifyAdditionalObjectsPage(getSessionfromSelection(selection), scaffoldType, target);
	}
	
	private void initSourceAndTarget(IStructuredSelection selection) {
		if (selection.size() == 2) {
			Iterator<?> iterator = selection.iterator();
			Object first = iterator.next();
			Object second = iterator.next();
			switch (scaffoldType) {
			case ENTITY_TO_MLD:
				if (ScaffoldingUtils.isValidInputForEntity(first)) {
					source = (EObject)first;
					target = (EObject)second;
				} else {
					source = (EObject)second;
					target = (EObject)first;
				}
				break;
			case MLD_TO_ENTITY:
			case MLD_TO_MPD:
				if (ScaffoldingUtils.isValidInputForMld(first)) {
					source = (EObject)first;
					target = (EObject)second;
				} else {
					source = (EObject)second;
					target = (EObject)first;
				}
				break;
			case MPD_TO_MLD:
				if (ScaffoldingUtils.isValidInputForMpd(first)) {
					source = (EObject)first;
					target = (EObject)second;
				} else {
					source = (EObject)second;
					target = (EObject)first;
				}
				break;
			default:
				break;
			}
		} else {
			throw new IllegalArgumentException("Scaffolding wizard should be executed with exactly 2 selected objects.");
		}
	}
	
	private Session getSessionfromSelection(IStructuredSelection selection) {
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof EObject) {
			return SessionManager.INSTANCE.getSession((EObject)firstElement);
		}
		return null;
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
