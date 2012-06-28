/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.FlatReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;

import org.obeonetwork.dsl.database.providers.DatabaseMessages;

// End of user code

/**
 * 
 * 
 */
public class DataBasePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DataBasePropertiesEditionPart {

	protected Text name;
	protected Text url;
	protected FlatReferencesTable usedLibraries;
	protected Text comments;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataBasePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dataBase_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataBase_Step.addStep(DatabaseViewsRepository.DataBase_.Properties.class);
		propertiesStep.addStep(DatabaseViewsRepository.DataBase_.Properties.name);
		propertiesStep.addStep(DatabaseViewsRepository.DataBase_.Properties.url);
		propertiesStep.addStep(DatabaseViewsRepository.DataBase_.Properties.usedLibraries);
		propertiesStep.addStep(DatabaseViewsRepository.DataBase_.Properties.comments);
		
		
		composer = new PartComposer(dataBase_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == DatabaseViewsRepository.DataBase_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == DatabaseViewsRepository.DataBase_.Properties.name) {
					return createNameText(parent);
				}
				if (key == DatabaseViewsRepository.DataBase_.Properties.url) {
					return createUrlText(parent);
				}
				if (key == DatabaseViewsRepository.DataBase_.Properties.usedLibraries) {
					return createUsedLibrariesFlatReferencesTable(parent);
				}
				if (key == DatabaseViewsRepository.DataBase_.Properties.comments) {
					return createCommentsTextarea(parent);
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
		propertiesGroup.setText(DatabaseMessages.DataBasePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.DataBase_.Properties.name, DatabaseMessages.DataBasePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, DatabaseViewsRepository.DataBase_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.DataBase_.Properties.name, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUrlText(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.DataBase_.Properties.url, DatabaseMessages.DataBasePropertiesEditionPart_UrlLabel);
		url = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData urlData = new GridData(GridData.FILL_HORIZONTAL);
		url.setLayoutData(urlData);
		url.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.url, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, url.getText()));
			}

		});
		url.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.url, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, url.getText()));
				}
			}

		});
		EditingUtils.setID(url, DatabaseViewsRepository.DataBase_.Properties.url);
		EditingUtils.setEEFtype(url, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.DataBase_.Properties.url, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent
	 * 
	 */
	protected Composite createUsedLibrariesFlatReferencesTable(Composite parent) {
		createDescription(parent, DatabaseViewsRepository.DataBase_.Properties.usedLibraries, DatabaseMessages.DataBasePropertiesEditionPart_UsedLibrariesLabel);
		usedLibraries = new FlatReferencesTable(parent);
		usedLibraries.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		usedLibraries.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) 
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.usedLibraries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ((StructuredSelection)event.getSelection()).toList()));
			}

		});
		GridData usedLibrariesData = new GridData(GridData.FILL_HORIZONTAL);
		usedLibraries.setLayoutData(usedLibrariesData);
		usedLibraries.setID(DatabaseViewsRepository.DataBase_.Properties.usedLibraries);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.DataBase_.Properties.usedLibraries, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}


	
	protected Composite createCommentsTextarea(Composite parent) {
		Label commentsLabel = createDescription(parent, DatabaseViewsRepository.DataBase_.Properties.comments, DatabaseMessages.DataBasePropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData commentsData = new GridData(GridData.FILL_HORIZONTAL);
		commentsData.horizontalSpan = 2;
		commentsData.heightHint = 80;
		commentsData.widthHint = 200;
		comments.setLayoutData(commentsData);
		comments.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataBasePropertiesEditionPartImpl.this, DatabaseViewsRepository.DataBase_.Properties.comments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
			}

		});
		EditingUtils.setID(comments, DatabaseViewsRepository.DataBase_.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(DatabaseViewsRepository.DataBase_.Properties.comments, DatabaseViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#getUrl()
	 * 
	 */
	public String getUrl() {
		return url.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#setUrl(String newValue)
	 * 
	 */
	public void setUrl(String newValue) {
		if (newValue != null) {
			url.setText(newValue);
		} else {
			url.setText(""); //$NON-NLS-1$
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#initUsedLibraries(ReferencesTableSettings)
	 */
	public void initUsedLibraries(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		usedLibraries.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#updateUsedLibraries()
	 * 
	 */
	public void updateUsedLibraries() {
	usedLibraries.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#addFilterUsedLibraries(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUsedLibraries(ViewerFilter filter) {
		usedLibraries.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#addBusinessFilterUsedLibraries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUsedLibraries(ViewerFilter filter) {
		usedLibraries.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#isContainedInUsedLibrariesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUsedLibrariesTable(EObject element) {
		return ((ReferencesTableSettings)usedLibraries.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.database.parts.DataBasePropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return DatabaseMessages.DataBase_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
