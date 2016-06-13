/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.tools.requirement.ui.dialog;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;
import org.obeonetwork.tools.requirement.wizard.util.RequirementsRepositoriesContentProvider;

import org.eclipse.sirius.ui.tools.api.views.ViewHelper;

public class LinkRequirementsDialog extends TitleAreaDialog {

	private AdapterFactory adapterFactory;

	private CheckboxTreeViewer checkboxTreeViewer;
	
	private EObject selectedObject;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public LinkRequirementsDialog(Shell parentShell, EObject selectedObject) {
		super(parentShell);
		setShellStyle(SWT.TITLE|SWT.APPLICATION_MODAL);
		this.selectedObject=selectedObject;
		this.adapterFactory = ViewHelper.INSTANCE.createAdapterFactory();
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	protected Control createDialogArea(Composite parent) {
		setTitle(RequirementLinkerPlugin.getInstance().getString("LinkRequirementsDialog_title")); //$NON-NLS-1$
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.marginHeight = 1;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;

		createRequirementsTreeViewer(container);

		
		return container;
	}

	protected void okPressed() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedObject);
		RecordingCommand cmd = new RecordingCommand(editingDomain, "Link Requirements") { //$NON-NLS-1$
			protected void doExecute() {
				//clear all requirements links
				for(Requirement requirement : RequirementService.getLinkedRequirements(selectedObject)){
					requirement.getReferencedObject().remove(selectedObject);
				}
				
				//add new requirements links
				for(Object o : checkboxTreeViewer.getCheckedElements()){
					if(o instanceof Requirement){
						Requirement requirement = (Requirement)o;
						requirement.getReferencedObject().add(selectedObject);
					}
				}
			}
		};
		editingDomain.getCommandStack().execute(cmd);
		super.okPressed();
	}
	
	private void createRequirementsTreeViewer(Composite parent) {
		this.checkboxTreeViewer = new CheckboxTreeViewer(parent, /* SWT.BORDER */SWT.MULTI);
		Tree tree = checkboxTreeViewer.getTree();
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_tree.heightHint = 208;
		tree.setLayoutData(gd_tree);
		this.checkboxTreeViewer.setLabelProvider(getLabelProvider());
		this.checkboxTreeViewer.setContentProvider(getContentProvider());
		setInput(checkboxTreeViewer);		
		setCheckedElements(checkboxTreeViewer);
		setGrayedElements(checkboxTreeViewer);
		this.checkboxTreeViewer.expandToLevel(4);
	}
	
	private void setInput(CheckboxTreeViewer viewer){
		Collection<Resource> requirementsRepositories = RequirementService.findRequirementsRepositories(selectedObject);
		viewer.setInput(requirementsRepositories);		
	}

	private void setCheckedElements(CheckboxTreeViewer viewer){		
		Requirement[] linkedRequirements = RequirementService.getLinkedRequirements(selectedObject);
		viewer.setCheckedElements(linkedRequirements);
	}
	
	private void setGrayedElements(CheckboxTreeViewer viewer){
		Collection<Resource> requirementsRepositories = RequirementService.findRequirementsRepositories(selectedObject);
		ArrayList<Object> grayedElements = new ArrayList<Object>();
		for(Resource resource : requirementsRepositories){
			grayedElements.add(resource);
			TreeIterator<EObject> it = resource.getAllContents();
			while(it.hasNext()){
				EObject eObject = it.next();
				if(!(eObject instanceof Requirement)){
					grayedElements.add(eObject);		
				}
			}			
		}		
		Object[] grayedElementsArray = grayedElements.toArray(new Object[grayedElements.size()]);	
		viewer.setGrayedElements(grayedElementsArray);		
	}
	
	private ILabelProvider labelProvider;

	private ILabelProvider getLabelProvider() {
		if (labelProvider == null) {
			this.labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		}
		return this.labelProvider;
	}

	private IContentProvider contentProvider;

	private IContentProvider getContentProvider() {
		if (contentProvider == null) {
			contentProvider = new RequirementsRepositoriesContentProvider(adapterFactory);
		}
		return contentProvider;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	protected Point getInitialSize() {
		return new Point(486, 469);
	}

}
