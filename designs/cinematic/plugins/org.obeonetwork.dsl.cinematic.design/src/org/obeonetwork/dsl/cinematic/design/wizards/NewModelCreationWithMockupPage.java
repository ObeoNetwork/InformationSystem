package org.obeonetwork.dsl.cinematic.design.wizards;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.util.ToolkitsProvider;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * Defines the main {@link ViewContainer} of a Cinematic model, creates and opens its representation.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class NewModelCreationWithMockupPage extends WizardPage {
	private Toolkit toolkit;
	private Widget widgetContainer;
	
	private List<Toolkit> toolkits;
	private List<Widget> widgetContainers;
	private Text text;
	
	public NewModelCreationWithMockupPage(String pageName) {
		super(pageName);
		setTitle("Create a new mockup");
		setDescription("Choose the main element and the name of for the mockup");
	}

	@Override
	public void createControl(Composite parent) {
		Composite compositeMockup = new Composite(parent, SWT.NONE);
		
		setControl(compositeMockup);
		compositeMockup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 4));
		compositeMockup.setLayout(new GridLayout(2, false));
		
	
		Label toolkitLabel = new Label(compositeMockup, NONE);
		toolkitLabel.setText("Toolkit:");
				
		toolkits = new ArrayList<>();
		
		// Get toolkits provided using the extension point
		Collection<URI> providedToolkitsURI = ToolkitsProvider.getProvidedToolkits();
		for (URI uri : providedToolkitsURI) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(uri, true);
			if (resource != null && resource.getContents() != null) {
				for (EObject root : resource.getContents()) {
					if (root instanceof Toolkit) {
						Toolkit toolkit = (Toolkit)root;
						toolkits.add(toolkit);
					}
				}
			}
		}
		
		Combo toolkitCombo = new Combo(compositeMockup, SWT.READ_ONLY);
		GridData gd_toolkitCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_toolkitCombo.widthHint = 220;
		toolkitCombo.setLayoutData(gd_toolkitCombo);
		toolkitCombo.setItems(toolkits.stream().map(t -> t.getName()).collect(Collectors.toList()).toArray(new String[toolkits.size()]));

		new Label(compositeMockup, SWT.NONE);
		new Label(compositeMockup, SWT.NONE);
		
		Label vcLabel = new Label(compositeMockup, NONE);
		vcLabel.setText("Main widget:");
		Combo vcContainerCombo = new Combo(compositeMockup, SWT.READ_ONLY);
		GridData gd_vcContainerCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_vcContainerCombo.widthHint = 220;
		vcContainerCombo.setLayoutData(gd_vcContainerCombo);
		
		toolkitCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				toolkit = toolkits.get(toolkitCombo.getSelectionIndex());
				widgetContainers = toolkit.getWidgets().stream().filter(Widget::isIsContainer).collect(Collectors.toList());
				vcContainerCombo.setItems((String[]) widgetContainers.stream().map(Widget::getName).collect(Collectors.toList()).toArray(new String[widgetContainers.size()]));
			}
			
		});
		
		vcContainerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (vcContainerCombo.getSelectionIndex() != -1) {
					widgetContainer = widgetContainers.get(vcContainerCombo.getSelectionIndex());
				}	
			}
		});
		
		new Label(compositeMockup, SWT.NONE);
		new Label(compositeMockup, SWT.NONE);
		
		Label lblWidgetName = new Label(compositeMockup, SWT.NONE);
		lblWidgetName.setText("Widget name:");
		text = new Text(compositeMockup, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.heightHint = 20;
		gd_text.widthHint = 233;
		text.setLayoutData(gd_text);		
	}

	public Toolkit getToolkit() {
		return toolkit;
	}

	public Widget getWidgetContainer() {
		return widgetContainer;
	}

	public String getViewContainerName() {
		return text.getText();
	}		
	
}
 