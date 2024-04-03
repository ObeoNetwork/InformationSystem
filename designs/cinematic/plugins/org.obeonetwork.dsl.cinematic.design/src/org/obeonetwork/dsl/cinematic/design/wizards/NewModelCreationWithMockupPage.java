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
package org.obeonetwork.dsl.cinematic.design.wizards;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.util.ToolkitsProvider;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.StringUtils;
import org.osgi.framework.Bundle;

/**
 * Defines the main {@link ViewContainer} of a Cinematic model, creates and
 * opens its representations.
 * 
 * @author Obeo
 */
public class NewModelCreationWithMockupPage extends WizardPage {
	private Toolkit toolkit;
	private Widget widgetContainer;

	private List<Toolkit> toolkits = new ArrayList<>();
	private List<Widget> widgetContainers;
	private Text containerName;
	private Text flowName;
	protected boolean createsMockupRepresentation;
	protected boolean createsFlowRepresentation;

	public NewModelCreationWithMockupPage(String pageName) {
		super(pageName);

		setTitle("Create a new Cinematic model");
		setDescription("Choose Mockup and Flow settings");
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL fullPathString = bundle.getEntry("icons/full/wizban/NewMockup.gif");
		setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));
	};

	@Override
	public void createControl(Composite parent) {
		Composite compositeMockup = new Composite(parent, SWT.NONE);
		setControl(compositeMockup);

		compositeMockup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 4));
		GridLayout gl_compositeMockup = new GridLayout(1, false);
		gl_compositeMockup.marginHeight = 10;
		gl_compositeMockup.marginWidth = 0;
		gl_compositeMockup.verticalSpacing = 0;
		gl_compositeMockup.horizontalSpacing = 0;
		compositeMockup.setLayout(gl_compositeMockup);

		Composite composite = new Composite(compositeMockup, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label toolkitLabel = new Label(composite, NONE);
		GridData gd_toolkitLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_toolkitLabel.widthHint = 130;
		toolkitLabel.setLayoutData(gd_toolkitLabel);
		toolkitLabel.setText("Toolkit:");

		Combo toolkitCombo = new Combo(composite, SWT.READ_ONLY);
		toolkitCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Group grpMockupSettings = new Group(compositeMockup, SWT.NONE);
		grpMockupSettings.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		grpMockupSettings.setText("Mockup settings");
		GridLayout gl_grpMockupSettings = new GridLayout(2, false);
		grpMockupSettings.setLayout(gl_grpMockupSettings);

		Button initializeWithMockup = new Button(grpMockupSettings, SWT.CHECK);
		initializeWithMockup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		initializeWithMockup.setText("Create mockup diagram");
		initializeWithMockup.setSelection(false);

		Label vcLabel = new Label(grpMockupSettings, NONE);
		GridData gd_vcLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_vcLabel.widthHint = 130;
		vcLabel.setLayoutData(gd_vcLabel);
		vcLabel.setText("Main container:");

		Combo vcContainerCombo = new Combo(grpMockupSettings, SWT.READ_ONLY);
		vcContainerCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		vcContainerCombo.setEnabled(false);

		Label lblWidgetName = new Label(grpMockupSettings, SWT.NONE);
		GridData gd_lblWidgetName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWidgetName.widthHint = 130;
		lblWidgetName.setLayoutData(gd_lblWidgetName);
		lblWidgetName.setText("Container name:");

		containerName = new Text(grpMockupSettings, SWT.BORDER);
		containerName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		containerName.addModifyListener(event -> getContainer().updateButtons());
		containerName.setEnabled(false);

		Group grpFlowSettings = new Group(compositeMockup, SWT.SHADOW_ETCHED_IN);
		grpFlowSettings.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		grpFlowSettings.setLayout(new GridLayout(2, false));
		grpFlowSettings.setText("Flow settings");

		Button initializeWithFlow = new Button(grpFlowSettings, SWT.CHECK);
		initializeWithFlow.setText("Create flow diagram");
		new Label(grpFlowSettings, SWT.NONE);

		Label lblNewLabel = new Label(grpFlowSettings, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 130;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("Flow name:");

		flowName = new Text(grpFlowSettings, SWT.BORDER | SWT.WRAP);
		flowName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		flowName.addModifyListener(event -> getContainer().updateButtons());
		flowName.setEnabled(false);

		initializeWithFlow.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				createsFlowRepresentation = ((Button) e.getSource()).getSelection();
				flowName.setEnabled(createsFlowRepresentation);

				if (createsFlowRepresentation) {
					flowName.setText("Flow");
				} else {
					flowName.setText("");
				}
			}

		});

		toolkitCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				toolkit = toolkits.get(toolkitCombo.getSelectionIndex());
				initializeWithMockup.notifyListeners(SWT.Selection, null);
			}

		});

		vcContainerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (vcContainerCombo.getSelectionIndex() != -1) {
					widgetContainer = widgetContainers.get(vcContainerCombo.getSelectionIndex());
					containerName.setText(String.format("%s%s", toolkit.getName(), widgetContainer.getName()));
				}
			}
		});

		initializeWithMockup.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {

				Button btn = (Button) event.getSource();
				createsMockupRepresentation = btn.getSelection();
				containerName.setEnabled(createsMockupRepresentation);

				if (createsMockupRepresentation && toolkit != null) {
					widgetContainers = toolkit.getWidgets().stream().filter(Widget::isIsContainer)
							.collect(Collectors.toList());
					widgetContainers.sort((w1, w2) -> {
						// sorting the containers from the largest to the smallest.
						int areaStyle1 = w1.getStyle() == null ? 0
								: w1.getStyle().getDefaultHeight() * w1.getStyle().getDefaultWidth();
						int areaStyle2 = w2.getStyle() == null ? 0
								: w2.getStyle().getDefaultHeight() * w2.getStyle().getDefaultWidth();

						return areaStyle2 - areaStyle1;
					});

					vcContainerCombo.setEnabled(true);
					vcContainerCombo.setItems((String[]) widgetContainers.stream().map(Widget::getName)
							.collect(Collectors.toList()).toArray(new String[widgetContainers.size()]));
					vcContainerCombo.select(0);
					vcContainerCombo.notifyListeners(SWT.Selection, null);

				} else {
					vcContainerCombo.setItems();
					vcContainerCombo.setEnabled(false);
					containerName.setText("");
				}

				getContainer().updateButtons();
			}
		});

		toolkits = getToolkits(); // Get toolkits provided using the extension point
		toolkits.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
		toolkitCombo.setItems(toolkits.stream().map(t -> t.getName()).distinct().collect(Collectors.toList())
				.toArray(new String[toolkits.size()]));

		Composite composite_1 = new Composite(compositeMockup, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.heightHint = 34;
		composite_1.setLayoutData(gd_composite_1);
		toolkitCombo.redraw();
	}

	public List<Toolkit> getToolkits() {
		Collection<URI> providedToolkitsURI = ToolkitsProvider.getProvidedToolkits();
		List<Toolkit> toolkitsCollection = new ArrayList<>();

		for (URI uri : providedToolkitsURI) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(uri, true);
			if (resource != null && resource.getContents() != null) {
				for (EObject root : resource.getContents()) {
					if (root instanceof Toolkit) {
						Toolkit toolkit = (Toolkit) root;
						toolkitsCollection.add(toolkit);
					}
				}
			}
		}

		return toolkitsCollection;
	}

	public Toolkit getToolkit() {
		return toolkit;
	}

	public Widget getWidgetContainer() {
		return widgetContainer;
	}

	public String getViewContainerName() {
		return containerName.getText();
	}

	public String getFlowName() {
		return flowName.getText();
	}

	public boolean isCreatesMockupRepresentation() {
		return createsMockupRepresentation;
	}

	public boolean isCreatesFlowRepresentation() {
		return createsFlowRepresentation;
	}

	@Override
	public boolean isPageComplete() {

		boolean isMockupValid = !createsMockupRepresentation
				|| (toolkit != null && widgetContainer != null && (!StringUtils.isNullOrWhite(getViewContainerName())));

		boolean isFlowValid = !createsFlowRepresentation || !StringUtils.isNullOrWhite(getFlowName());

		return isMockupValid && isFlowValid;
	}
}
