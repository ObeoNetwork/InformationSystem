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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.util.ToolkitsProvider;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.StringUtils;

/**
 * Defines the main {@link ViewContainer} of a Cinematic model, creates and opens its representation.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class NewModelCreationWithMockupPage extends WizardPage {
	private Toolkit toolkit;
	private Widget widgetContainer;
	
	private List<Toolkit> toolkits = new ArrayList<>();
	private List<Widget> widgetContainers;
	private Text text;
	protected boolean createsMockupRepresentation;
	
	public NewModelCreationWithMockupPage(String pageName) {
		super(pageName);
		setTitle("Create a new mockup");
		setDescription("Choose the main container and its name");
	}

	@Override
	public void createControl(Composite parent) {
		Composite compositeMockup = new Composite(parent, SWT.NONE);		
		setControl(compositeMockup);
		
		compositeMockup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 4));
		compositeMockup.setLayout(new GridLayout(2, false));		
	
		Label toolkitLabel = new Label(compositeMockup, NONE);
		toolkitLabel.setText("Toolkit:");				
		
		Combo toolkitCombo = new Combo(compositeMockup, SWT.READ_ONLY);
		GridData gd_toolkitCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_toolkitCombo.widthHint = 220;
		toolkitCombo.setLayoutData(gd_toolkitCombo);					
		
		new Label(compositeMockup, SWT.NONE);
		new Label(compositeMockup, SWT.NONE);
		
		Label vcLabel = new Label(compositeMockup, NONE);
		vcLabel.setText("Main container:");
		Combo vcContainerCombo = new Combo(compositeMockup, SWT.READ_ONLY);
		GridData gd_vcContainerCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_vcContainerCombo.widthHint = 220;
		vcContainerCombo.setLayoutData(gd_vcContainerCombo);					
		
		new Label(compositeMockup, SWT.NONE);
		new Label(compositeMockup, SWT.NONE);
		
		Label lblWidgetName = new Label(compositeMockup, SWT.NONE);
		lblWidgetName.setText("Container name:");
		text = new Text(compositeMockup, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.heightHint = 20;
		gd_text.widthHint = 233;
		text.setLayoutData(gd_text);		
		
		
		toolkitCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				toolkit = toolkits.get(toolkitCombo.getSelectionIndex());
				widgetContainers = toolkit.getWidgets().stream().filter(Widget::isIsContainer).collect(Collectors.toList());
				
				// sorting the containers from the largest to the smallest.
				widgetContainers.sort((w1, w2) -> {
					
					int areaStyle1 = w1.getStyle() == null ? 0 : w1.getStyle().getDefaultHeight() * w1.getStyle().getDefaultWidth();
					int areaStyle2 = w2.getStyle() == null ? 0 : w2.getStyle().getDefaultHeight() * w2.getStyle().getDefaultWidth();
					
					return areaStyle2 - areaStyle1;	
				}); 
				
				vcContainerCombo.setItems((String[]) widgetContainers.stream().map(Widget::getName).collect(Collectors.toList()).toArray(new String[widgetContainers.size()]));
				vcContainerCombo.select(0);
				vcContainerCombo.notifyListeners(SWT.Selection, null);				
			}
			
		});
		
		vcContainerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (vcContainerCombo.getSelectionIndex() != -1) {
					widgetContainer = widgetContainers.get(vcContainerCombo.getSelectionIndex());
					text.setText(String.format("%s%s", toolkit.getName(), widgetContainer.getName()));
				}	
			}
		});
		
		text.addModifyListener( event -> getContainer().updateButtons());
		toolkits = getToolkits(); // Get toolkits provided using the extension point
		toolkits.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
		
		new Label(compositeMockup, SWT.NONE);
		new Label(compositeMockup, SWT.NONE);
		
		Button initializeWithMockup = new Button(compositeMockup, SWT.CHECK);
		initializeWithMockup.setText("Create layout for mockup");
		initializeWithMockup.setSelection(false);
		initializeWithMockup.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent event) {
				
	            Button btn = (Button) event.getSource();
	            createsMockupRepresentation = btn.getSelection();
	            if (createsMockupRepresentation) {
	        		
	        		toolkitCombo.setItems(toolkits.stream().map(t -> t.getName()).collect(Collectors.toList()).toArray(new String[toolkits.size()]));		
	        		toolkitCombo.select(0); 
	        		toolkitCombo.notifyListeners(SWT.Selection, null);
	            } else {
	            	toolkitCombo.setItems();
	            	vcContainerCombo.setItems();
	            	text.setText("");
	            }
	            
	            getContainer().updateButtons();
			}
		});
		
		new Label(compositeMockup, SWT.NONE);
		
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
						Toolkit toolkit = (Toolkit)root;
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
		return text.getText();
	}

	
	public boolean isCreatesMockupRepresentation() {
		return createsMockupRepresentation;
	}

	@Override
	public boolean isPageComplete() {			
		return !createsMockupRepresentation || 
				(createsMockupRepresentation 
					&& toolkit != null 
					&& widgetContainer != null 
					&& (!StringUtils.isNullOrWhite(getViewContainerName())));
	}
	
	
	
}
 