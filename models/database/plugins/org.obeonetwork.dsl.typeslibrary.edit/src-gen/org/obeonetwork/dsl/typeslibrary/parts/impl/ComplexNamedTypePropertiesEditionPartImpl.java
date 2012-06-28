/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class ComplexNamedTypePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ComplexNamedTypePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable types;
	protected List<ViewerFilter> typesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> typesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ComplexNamedTypePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence complexNamedTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = complexNamedTypeStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.name);
		propertiesStep.addStep(TypeslibraryViewsRepository.ComplexNamedType.Properties.types);
		
		
		composer = new PartComposer(complexNamedTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.name) {
					return createNameText(parent);
				}
				if (key == TypeslibraryViewsRepository.ComplexNamedType.Properties.types) {
					return createTypesAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.ComplexNamedType.Properties.name, TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, TypeslibraryViewsRepository.ComplexNamedType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.ComplexNamedType.Properties.name, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTypesAdvancedTableComposition(Composite parent) {
		this.types = new ReferencesTable(getDescription(TypeslibraryViewsRepository.ComplexNamedType.Properties.types, TypeslibraryMessages.ComplexNamedTypePropertiesEditionPart_TypesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				types.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				types.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				types.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				types.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.typesFilters) {
			this.types.addFilter(filter);
		}
		this.types.setHelpText(propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.ComplexNamedType.Properties.types, TypeslibraryViewsRepository.SWT_KIND));
		this.types.createControls(parent);
		this.types.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComplexNamedTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.ComplexNamedType.Properties.types, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
