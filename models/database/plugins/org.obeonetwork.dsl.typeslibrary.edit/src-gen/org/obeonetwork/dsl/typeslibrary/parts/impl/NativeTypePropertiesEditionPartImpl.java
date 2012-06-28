/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.providers.TypeslibraryMessages;

// End of user code

/**
 * 
 * 
 */
public class NativeTypePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NativeTypePropertiesEditionPart {

	protected Text name;
	protected EMFComboViewer spec;
	protected EObjectFlatComboViewer mapsTo;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public NativeTypePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence nativeTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = nativeTypeStep.addStep(TypeslibraryViewsRepository.NativeType.Properties.class);
		propertiesStep.addStep(TypeslibraryViewsRepository.NativeType.Properties.name);
		propertiesStep.addStep(TypeslibraryViewsRepository.NativeType.Properties.spec);
		propertiesStep.addStep(TypeslibraryViewsRepository.NativeType.Properties.mapsTo);
		
		
		composer = new PartComposer(nativeTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == TypeslibraryViewsRepository.NativeType.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == TypeslibraryViewsRepository.NativeType.Properties.name) {
					return createNameText(parent);
				}
				if (key == TypeslibraryViewsRepository.NativeType.Properties.spec) {
					return createSpecEMFComboViewer(parent);
				}
				if (key == TypeslibraryViewsRepository.NativeType.Properties.mapsTo) {
					return createMapsToFlatComboViewer(parent);
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
		propertiesGroup.setText(TypeslibraryMessages.NativeTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.NativeType.Properties.name, TypeslibraryMessages.NativeTypePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, TypeslibraryViewsRepository.NativeType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.NativeType.Properties.name, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSpecEMFComboViewer(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.NativeType.Properties.spec, TypeslibraryMessages.NativeTypePropertiesEditionPart_SpecLabel);
		spec = new EMFComboViewer(parent);
		spec.setContentProvider(new ArrayContentProvider());
		spec.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData specData = new GridData(GridData.FILL_HORIZONTAL);
		spec.getCombo().setLayoutData(specData);
		spec.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeType.Properties.spec, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSpec()));
			}

		});
		spec.setID(TypeslibraryViewsRepository.NativeType.Properties.spec);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.NativeType.Properties.spec, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createMapsToFlatComboViewer(Composite parent) {
		createDescription(parent, TypeslibraryViewsRepository.NativeType.Properties.mapsTo, TypeslibraryMessages.NativeTypePropertiesEditionPart_MapsToLabel);
		mapsTo = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(TypeslibraryViewsRepository.NativeType.Properties.mapsTo, TypeslibraryViewsRepository.SWT_KIND));
		mapsTo.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		mapsTo.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NativeTypePropertiesEditionPartImpl.this, TypeslibraryViewsRepository.NativeType.Properties.mapsTo, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getMapsTo()));
			}

		});
		GridData mapsToData = new GridData(GridData.FILL_HORIZONTAL);
		mapsTo.setLayoutData(mapsToData);
		mapsTo.setID(TypeslibraryViewsRepository.NativeType.Properties.mapsTo);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TypeslibraryViewsRepository.NativeType.Properties.mapsTo, TypeslibraryViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#getSpec()
	 * 
	 */
	public Enumerator getSpec() {
		Enumerator selection = (Enumerator) ((StructuredSelection) spec.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#initSpec(Object input, Enumerator current)
	 */
	public void initSpec(Object input, Enumerator current) {
		spec.setInput(input);
		spec.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#setSpec(Enumerator newValue)
	 * 
	 */
	public void setSpec(Enumerator newValue) {
		spec.modelUpdating(new StructuredSelection(newValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#getMapsTo()
	 * 
	 */
	public EObject getMapsTo() {
		if (mapsTo.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) mapsTo.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#initMapsTo(EObjectFlatComboSettings)
	 */
	public void initMapsTo(EObjectFlatComboSettings settings) {
		mapsTo.setInput(settings);
		if (current != null) {
			mapsTo.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#setMapsTo(EObject newValue)
	 * 
	 */
	public void setMapsTo(EObject newValue) {
		if (newValue != null) {
			mapsTo.setSelection(new StructuredSelection(newValue));
		} else {
			mapsTo.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#setMapsToButtonMode(ButtonsModeEnum newValue)
	 */
	public void setMapsToButtonMode(ButtonsModeEnum newValue) {
		mapsTo.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#addFilterMapsTo(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMapsTo(ViewerFilter filter) {
		mapsTo.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.typeslibrary.parts.NativeTypePropertiesEditionPart#addBusinessFilterMapsTo(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMapsTo(ViewerFilter filter) {
		mapsTo.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TypeslibraryMessages.NativeType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
