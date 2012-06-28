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
import org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class NativeTypesLibraryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NativeTypesLibraryPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable nativeTypes;
	protected List<ViewerFilter> nativeTypesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> nativeTypesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public NativeTypesLibraryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence nativeTypesLibraryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = nativeTypesLibraryStep.addStep(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name);
		propertiesStep.addStep(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes);
		
		
		composer = new PartComposer(nativeTypesLibraryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.NativeTypesLibrary.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name) {
					return createNameText(parent);
				}
				if (key == TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes) {
					return createNativeTypesAdvancedTableComposition(parent);
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
		propertiesGroup.setText(TypeslibraryMessages.NativeTypesLibraryPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name, TypeslibraryMessages.NativeTypesLibraryPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createNativeTypesAdvancedTableComposition(Composite parent) {
		this.nativeTypes = new ReferencesTable(getDescription(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, TypeslibraryMessages.NativeTypesLibraryPropertiesEditionPart_NativeTypesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				nativeTypes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				nativeTypes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				nativeTypes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				nativeTypes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.nativeTypesFilters) {
			this.nativeTypes.addFilter(filter);
		}
		this.nativeTypes.setHelpText(propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, TypeslibraryViewsRepository.SWT_KIND));
		this.nativeTypes.createControls(parent);
		this.nativeTypes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData nativeTypesData = new GridData(GridData.FILL_HORIZONTAL);
		nativeTypesData.horizontalSpan = 3;
		this.nativeTypes.setLayoutData(nativeTypesData);
		this.nativeTypes.setLowerBound(0);
		this.nativeTypes.setUpperBound(-1);
		nativeTypes.setID(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes);
		nativeTypes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#initNativeTypes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initNativeTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		nativeTypes.setContentProvider(contentProvider);
		nativeTypes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#updateNativeTypes()
	 * 
	 */
	public void updateNativeTypes() {
	nativeTypes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#addFilterNativeTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToNativeTypes(ViewerFilter filter) {
		nativeTypesFilters.add(filter);
		if (this.nativeTypes != null) {
			this.nativeTypes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#addBusinessFilterNativeTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToNativeTypes(ViewerFilter filter) {
		nativeTypesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart#isContainedInNativeTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInNativeTypesTable(EObject element) {
		return ((ReferencesTableSettings)nativeTypes.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TypeslibraryMessages.NativeTypesLibrary_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
