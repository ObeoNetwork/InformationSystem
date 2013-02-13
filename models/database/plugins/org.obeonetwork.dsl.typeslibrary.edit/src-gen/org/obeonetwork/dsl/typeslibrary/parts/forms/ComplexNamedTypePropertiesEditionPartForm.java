/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class ComplexNamedTypePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ComplexNamedTypePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable types;
	protected List<ViewerFilter> typesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> typesFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ComplexNamedTypePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ComplexNamedTypePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence complexNamedTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = complexNamedTypeStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.name);
		propertiesStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.types);
		
		
		composer = new PartComposer(complexNamedTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.types) {
					return createTypesTableComposition(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.ComplexNamedType.Properties.name, TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ComplexNamedTypePropertiesEditionPartForm.this,
							TypeslibraryViewsRepository.ComplexNamedType.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ComplexNamedTypePropertiesEditionPartForm.this,
									TypeslibraryViewsRepository.ComplexNamedType.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ComplexNamedTypePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, TypeslibraryViewsRepository.ComplexNamedType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.ComplexNamedType.Properties.name, TypeslibraryViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTypesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.types = new ReferencesTable(getDescription(TypeslibraryViewsRepository.ComplexNamedType.Properties.types, TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_TypesLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				types.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				types.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				types.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				types.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.typesFilters) {
			this.types.addFilter(filter);
		}
		this.types.setHelpText(propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.ComplexNamedType.Properties.types, TypeslibraryViewsRepository.FORM_KIND));
		this.types.createControls(parent, widgetFactory);
		this.types.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartForm.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData typesData = new GridData(GridData.FILL_HORIZONTAL);
		typesData.horizontalSpan = 3;
		this.types.setLayoutData(typesData);
		this.types.setLowerBound(0);
		this.types.setUpperBound(-1);
		types.setID(TypeslibraryViewsRepository.ComplexNamedType.Properties.types);
		types.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(TypeslibraryViewsRepository.ComplexNamedType.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(TypeslibraryMessages.ComplexNamedType_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#initTypes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		types.setContentProvider(contentProvider);
		types.setInput(settings);
		boolean readOnly = isReadOnly(TypeslibraryViewsRepository.ComplexNamedType.Properties.types);
		if (readOnly && types.isEnabled()) {
			types.setEnabled(false);
			types.setToolTipText(TypeslibraryMessages.ComplexNamedType_ReadOnly);
		} else if (!readOnly && !types.isEnabled()) {
			types.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#updateTypes()
	 * 
	 */
	public void updateTypes() {
	types.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#addFilterTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTypes(ViewerFilter filter) {
		typesFilters.add(filter);
		if (this.types != null) {
			this.types.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#addBusinessFilterTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTypes(ViewerFilter filter) {
		typesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart#isContainedInTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInTypesTable(EObject element) {
		return ((ReferencesTableSettings)types.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TypeslibraryMessages.ComplexNamedType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
