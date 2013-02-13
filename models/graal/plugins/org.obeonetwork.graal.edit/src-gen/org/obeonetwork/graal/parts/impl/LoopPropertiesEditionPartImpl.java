/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.parts.impl;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.LoopPropertiesEditionPart;
import org.obeonetwork.graal.providers.GraalMessages;

// End of user code

/**
 * 
 * 
 */
public class LoopPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LoopPropertiesEditionPart {

	protected Text lowerBound;
	protected Text upperBound;
	protected Text description;
	protected ReferencesTable subActivities;
	protected List<ViewerFilter> subActivitiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> subActivitiesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LoopPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence loopStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = loopStep.addStep(GraalViewsRepository.Loop.Properties.class);
		propertiesStep.addStep(GraalViewsRepository.Loop.Properties.lowerBound);
		propertiesStep.addStep(GraalViewsRepository.Loop.Properties.upperBound);
		propertiesStep.addStep(GraalViewsRepository.Loop.Properties.description);
		propertiesStep.addStep(GraalViewsRepository.Loop.Properties.subActivities);
		
		
		composer = new PartComposer(loopStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalViewsRepository.Loop.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == GraalViewsRepository.Loop.Properties.lowerBound) {
					return createLowerBoundText(parent);
				}
				if (key == GraalViewsRepository.Loop.Properties.upperBound) {
					return createUpperBoundText(parent);
				}
				if (key == GraalViewsRepository.Loop.Properties.description) {
					return createDescriptionTextarea(parent);
				}
				if (key == GraalViewsRepository.Loop.Properties.subActivities) {
					return createSubActivitiesAdvancedTableComposition(parent);
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
		propertiesGroup.setText(GraalMessages.LoopPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createLowerBoundText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Loop.Properties.lowerBound, GraalMessages.LoopPropertiesEditionPart_LowerBoundLabel);
		lowerBound = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData lowerBoundData = new GridData(GridData.FILL_HORIZONTAL);
		lowerBound.setLayoutData(lowerBoundData);
		lowerBound.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
			}

		});
		lowerBound.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
				}
			}

		});
		EditingUtils.setID(lowerBound, GraalViewsRepository.Loop.Properties.lowerBound);
		EditingUtils.setEEFtype(lowerBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Loop.Properties.lowerBound, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperBoundText(Composite parent) {
		createDescription(parent, GraalViewsRepository.Loop.Properties.upperBound, GraalMessages.LoopPropertiesEditionPart_UpperBoundLabel);
		upperBound = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData upperBoundData = new GridData(GridData.FILL_HORIZONTAL);
		upperBound.setLayoutData(upperBoundData);
		upperBound.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
			}

		});
		upperBound.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
				}
			}

		});
		EditingUtils.setID(upperBound, GraalViewsRepository.Loop.Properties.upperBound);
		EditingUtils.setEEFtype(upperBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Loop.Properties.upperBound, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionTextarea(Composite parent) {
		Label descriptionLabel = createDescription(parent, GraalViewsRepository.Loop.Properties.description, GraalMessages.LoopPropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionData.horizontalSpan = 2;
		descriptionData.heightHint = 80;
		descriptionData.widthHint = 200;
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		EditingUtils.setID(description, GraalViewsRepository.Loop.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalViewsRepository.Loop.Properties.description, GraalViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createSubActivitiesAdvancedTableComposition(Composite parent) {
		this.subActivities = new ReferencesTable(getDescription(GraalViewsRepository.Loop.Properties.subActivities, GraalMessages.LoopPropertiesEditionPart_SubActivitiesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				subActivities.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				subActivities.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				subActivities.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.subActivities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				subActivities.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.subActivitiesFilters) {
			this.subActivities.addFilter(filter);
		}
		this.subActivities.setHelpText(propertiesEditionComponent.getHelpContent(GraalViewsRepository.Loop.Properties.subActivities, GraalViewsRepository.SWT_KIND));
		this.subActivities.createControls(parent);
		this.subActivities.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoopPropertiesEditionPartImpl.this, GraalViewsRepository.Loop.Properties.subActivities, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData subActivitiesData = new GridData(GridData.FILL_HORIZONTAL);
		subActivitiesData.horizontalSpan = 3;
		this.subActivities.setLayoutData(subActivitiesData);
		this.subActivities.setLowerBound(0);
		this.subActivities.setUpperBound(-1);
		subActivities.setID(GraalViewsRepository.Loop.Properties.subActivities);
		subActivities.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#getLowerBound()
	 * 
	 */
	public String getLowerBound() {
		return lowerBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#setLowerBound(String newValue)
	 * 
	 */
	public void setLowerBound(String newValue) {
		if (newValue != null) {
			lowerBound.setText(newValue);
		} else {
			lowerBound.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(GraalViewsRepository.Loop.Properties.lowerBound);
		if (readOnly && lowerBound.isEnabled()) {
			lowerBound.setEnabled(false);
			lowerBound.setToolTipText(GraalMessages.Loop_ReadOnly);
		} else if (!readOnly && !lowerBound.isEnabled()) {
			lowerBound.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#getUpperBound()
	 * 
	 */
	public String getUpperBound() {
		return upperBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#setUpperBound(String newValue)
	 * 
	 */
	public void setUpperBound(String newValue) {
		if (newValue != null) {
			upperBound.setText(newValue);
		} else {
			upperBound.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(GraalViewsRepository.Loop.Properties.upperBound);
		if (readOnly && upperBound.isEnabled()) {
			upperBound.setEnabled(false);
			upperBound.setToolTipText(GraalMessages.Loop_ReadOnly);
		} else if (!readOnly && !upperBound.isEnabled()) {
			upperBound.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(GraalViewsRepository.Loop.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(GraalMessages.Loop_ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#initSubActivities(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSubActivities(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		subActivities.setContentProvider(contentProvider);
		subActivities.setInput(settings);
		boolean readOnly = isReadOnly(GraalViewsRepository.Loop.Properties.subActivities);
		if (readOnly && subActivities.isEnabled()) {
			subActivities.setEnabled(false);
			subActivities.setToolTipText(GraalMessages.Loop_ReadOnly);
		} else if (!readOnly && !subActivities.isEnabled()) {
			subActivities.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#updateSubActivities()
	 * 
	 */
	public void updateSubActivities() {
	subActivities.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#addFilterSubActivities(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSubActivities(ViewerFilter filter) {
		subActivitiesFilters.add(filter);
		if (this.subActivities != null) {
			this.subActivities.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#addBusinessFilterSubActivities(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSubActivities(ViewerFilter filter) {
		subActivitiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.graal.parts.LoopPropertiesEditionPart#isContainedInSubActivitiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSubActivitiesTable(EObject element) {
		return ((ReferencesTableSettings)subActivities.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return GraalMessages.Loop_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
