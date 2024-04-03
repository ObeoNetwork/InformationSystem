/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.wb.swt.SWTResourceManager;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.design.services.ReferencesService;
import org.obeonetwork.dsl.environment.design.services.TypesServices;
import org.obeonetwork.dsl.environment.design.ui.providers.ArrayTreeContentProvider;
import org.obeonetwork.dsl.environment.design.ui.providers.ReferenceLabelProvider;
import org.obeonetwork.dsl.environment.design.ui.providers.StructuredTypesContentProvider;

public class ChooseTypesAndReferencesPage extends WizardPage {

	private AdapterFactoryLabelProvider labelProvider;
	
	private TypesServices typesServices = new TypesServices();
	private ReferencesService referencesServices = new ReferencesService();
	
	private Namespace namespace;
	private String sourceTypeName;

	private CheckboxTreeViewer typesTreeViewer;

	private CheckboxTreeViewer referencesTreeViewer;

	private ReferenceLabelProvider referenceLabelProvider = null;

	/**
	 * Create the wizard.
	 */
	public ChooseTypesAndReferencesPage(Namespace namespace, String sourceTypeName) {
		super("ChooseTypesAndReferencesPage");
		this.namespace = namespace;
		this.sourceTypeName = sourceTypeName;
		setTitle("Select " + sourceTypeName + " and references");
		setDescription("Select one or more types and the related references to create new elements");
		
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, true));
		
		Label lblTypes = new Label(container, SWT.NONE);
		lblTypes.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblTypes.setText("Types :");
		
		Label lblReferences = new Label(container, SWT.NONE);
		lblReferences.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblReferences.setText("References :");
		
		typesTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		typesTreeViewer.setUseHashlookup(true);
		final Tree typesTree = typesTreeViewer.getTree();
		typesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		typesTreeViewer.setContentProvider(new StructuredTypesContentProvider(sourceTypeName));
		typesTreeViewer.setLabelProvider(labelProvider);
		typesTreeViewer.setSorter(new ViewerSorter());
		
		referencesTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		referencesTreeViewer.setUseHashlookup(true);
		Tree referencesTree = referencesTreeViewer.getTree();
		referencesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		referencesTreeViewer.setContentProvider(new ArrayTreeContentProvider());
		referenceLabelProvider = new ReferenceLabelProvider();
		referencesTreeViewer.setLabelProvider(referenceLabelProvider);
		referencesTreeViewer.setSorter(new ViewerSorter());
		
		typesTreeViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				// Check/uncheck all subtree
				typesTreeViewer.setSubtreeChecked(event.getElement(), event.getChecked());
				
				Collection<StructuredType> checkedTypes = getCheckedTypes();
				setPageComplete(!checkedTypes.isEmpty());
				List<Reference> references = referencesServices.getReferencesBetweenTypes(checkedTypes);
				referencesTreeViewer.setInput(references);
			}
		});
		
		initContents();
	}
	
	public Collection<StructuredType> getCheckedTypes() {
		Collection<StructuredType> checkedTypes = new ArrayList<StructuredType>();
		for (Object checkedElement : typesTreeViewer.getCheckedElements()) {
			if (checkedElement instanceof StructuredType) {
				checkedTypes.add((StructuredType)checkedElement);
			}
		}
		return checkedTypes;
	}
	
	public Collection<Reference> getCheckedReferences() {
		Collection<Reference> checkedReferences = new ArrayList<Reference>();
		for (Object checkedElement : referencesTreeViewer.getCheckedElements()) {
			if (checkedElement instanceof Reference) {
				checkedReferences.add((Reference)checkedElement);
			}
		}
		return checkedReferences;
	}

	private void initContents() {
		Collection<StructuredType> allStructuredTypes = typesServices.getAllStructuredTypes(namespace, sourceTypeName);
		Collection<ObeoDSMObject> rootElements = typesServices.getRootNamespaceContainersOrTypesDefinition(allStructuredTypes);
		typesTreeViewer.setInput(rootElements);
	}
}
