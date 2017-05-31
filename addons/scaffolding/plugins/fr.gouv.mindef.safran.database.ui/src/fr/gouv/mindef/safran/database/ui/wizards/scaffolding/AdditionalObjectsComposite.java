/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.Activator;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public class AdditionalObjectsComposite extends Composite {
	private Session session;
	private ScaffoldType scaffoldType;
	private EObject target;
	private ListViewer listAdditionalObjects;
	private Collection<EObject> additionalObjects;
	private final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	private final AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

	public AdditionalObjectsComposite(Composite parent, Session session, ScaffoldType scaffoldType, EObject target) {
		this(parent, session, scaffoldType, target, new ArrayList<EObject>());
	}
	
	public AdditionalObjectsComposite(Composite parent, Session session, ScaffoldType scaffoldType, EObject target, Collection<EObject> additionalObjects) {
		super(parent, SWT.NONE);
		this.session = session;
		this.scaffoldType = scaffoldType;
		this.target = target;
		this.additionalObjects = additionalObjects;
		createControls();
	}
	
	public Collection<EObject> getAdditionalObjects() {
		return additionalObjects;
	}
	
	public void createControls() {
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		
		listAdditionalObjects = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
		listAdditionalObjects.setLabelProvider(labelProvider);
		listAdditionalObjects.setContentProvider(new ArrayContentProvider());
		List list = listAdditionalObjects.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		listAdditionalObjects.setInput(additionalObjects);
		
		Button btnAdd = new Button(this, SWT.NONE);
		GridData gd_btnAdd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnAdd.widthHint = 60;
		btnAdd.setLayoutData(gd_btnAdd);
		btnAdd.setText("Add...");
		btnAdd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory) {
					@Override
					public Object[] getElements(Object object) {
						if (object instanceof Collection<?>) {
							return ((Collection<?>)object).toArray();
						}
						return super.getElements(object);
					}
				};
				
				Collection<Resource> resources = new ArrayList<Resource>();
				for (Resource semanticResource : session.getSemanticResources()) {
					for (EObject eObject : semanticResource.getContents()) {
						if (isValidAsAdditionalObject(eObject)) {
							resources.add(semanticResource);
							break;
						}
					}
				}
				
				ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(getShell(), labelProvider, contentProvider);
				dlg.setValidator(new ISelectionStatusValidator() {
					@Override
					public IStatus validate(Object[] selection) {
						if (selection.length > 0) {
							Object object = selection[0];
							if (!(object instanceof EObject) || !isValidAsAdditionalObject((EObject)object)) {
								return new Status(IStatus.ERROR, Activator.PLUGIN_ID, getMessageForAdditionalObject());
							}
						}
						return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
					}
				});
				dlg.setAllowMultiple(false);
				dlg.setBlockOnOpen(true);
				dlg.setInput(resources);
				int btn = dlg.open();
				if (btn == Window.OK) {
					Object firstResult = dlg.getFirstResult();
					if (firstResult instanceof EObject && !additionalObjects.contains(firstResult)) {
						additionalObjects.add((EObject)firstResult);
						listAdditionalObjects.refresh();
					}
				}
			}
		});
		
		Button btnRemove = new Button(this, SWT.NONE);
		GridData gd_btnRemove = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_btnRemove.widthHint = 60;
		btnRemove.setLayoutData(gd_btnRemove);
		btnRemove.setText("Remove");
		btnRemove.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = listAdditionalObjects.getSelection();
				if (selection instanceof StructuredSelection) {
					Object firstElement = ((StructuredSelection) selection).getFirstElement();
					additionalObjects.remove(firstElement);
					listAdditionalObjects.refresh();
				}
			}
		});
	}
	
	private boolean isValidAsAdditionalObject(EObject object) {
		if (!EcoreUtil.equals(object, target)) {
			switch (scaffoldType) {
			case MLD_TO_MPD:
				return ScaffoldingUtils.isValidInputForMpd(object);
			case MPD_TO_MLD:
			case ENTITY_TO_MLD:
				return ScaffoldingUtils.isValidInputForMld(object);
			case MLD_TO_ENTITY:
				return ScaffoldingUtils.isValidInputForEntity(object);
			}
		}
		return false;
	}
	
	private String getMessageForAdditionalObject() {
		switch (scaffoldType) {
		case MLD_TO_MPD:
			return "Select a Database or Schema from a physical database model";
		case MPD_TO_MLD:
		case ENTITY_TO_MLD:
			return "Select a Database or Schema from a logical database model";
		case MLD_TO_ENTITY:
			return "Select a Root or Block";
		}
		return "";
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
