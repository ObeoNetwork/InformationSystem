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
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class UserDefinedTypesLibraryPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, UserDefinedTypesLibraryPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable userDefinedTypes;
	protected List<ViewerFilter> userDefinedTypesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> userDefinedTypesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public UserDefinedTypesLibraryPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence userDefinedTypesLibraryStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = userDefinedTypesLibraryStep.addStep(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name);
		propertiesStep.addStep(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes);
		
		
		composer = new PartComposer(userDefinedTypesLibraryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name) {
					return createNameText(parent);
				}
				if (key == TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes) {
					return createUserDefinedTypesAdvancedTableComposition(parent);
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
		propertiesGroup.setText(TypeslibraryMessages.UserDefinedTypesLibraryPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name, TypeslibraryMessages.UserDefinedTypesLibraryPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createUserDefinedTypesAdvancedTableComposition(Composite parent) {
		this.userDefinedTypes = new ReferencesTable(getDescription(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, TypeslibraryMessages.UserDefinedTypesLibraryPropertiesEditionPart_UserDefinedTypesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				userDefinedTypes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				userDefinedTypes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				userDefinedTypes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				userDefinedTypes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.userDefinedTypesFilters) {
			this.userDefinedTypes.addFilter(filter);
		}
		this.userDefinedTypes.setHelpText(propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, TypeslibraryViewsRepository.SWT_KIND));
		this.userDefinedTypes.createControls(parent);
		this.userDefinedTypes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(UserDefinedTypesLibraryPropertiesEditionPartImpl.this, TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData userDefinedTypesData = new GridData(GridData.FILL_HORIZONTAL);
		userDefinedTypesData.horizontalSpan = 3;
		this.userDefinedTypes.setLayoutData(userDefinedTypesData);
		this.userDefinedTypes.setLowerBound(0);
		this.userDefinedTypes.setUpperBound(-1);
		userDefinedTypes.setID(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes);
		userDefinedTypes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#initUserDefinedTypes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initUserDefinedTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		userDefinedTypes.setContentProvider(contentProvider);
		userDefinedTypes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#updateUserDefinedTypes()
	 * 
	 */
	public void updateUserDefinedTypes() {
	userDefinedTypes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#addFilterUserDefinedTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUserDefinedTypes(ViewerFilter filter) {
		userDefinedTypesFilters.add(filter);
		if (this.userDefinedTypes != null) {
			this.userDefinedTypes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#addBusinessFilterUserDefinedTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUserDefinedTypes(ViewerFilter filter) {
		userDefinedTypesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart#isContainedInUserDefinedTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUserDefinedTypesTable(EObject element) {
		return ((ReferencesTableSettings)userDefinedTypes.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TypeslibraryMessages.UserDefinedTypesLibrary_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
