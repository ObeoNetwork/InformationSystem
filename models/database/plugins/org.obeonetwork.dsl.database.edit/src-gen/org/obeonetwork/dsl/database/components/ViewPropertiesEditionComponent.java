/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ViewPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ViewPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String VIEW_PART = "View"; //$NON-NLS-1$

	
	/**
	 * Settings for columns ReferencesTable
	 */
	protected ReferencesTableSettings columnsSettings;
	
	/**
	 * Settings for tables ReferencesTable
	 */
	protected ReferencesTableSettings tablesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ViewPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject view, String editing_mode) {
		super(editingContext, view, editing_mode);
		parts = new String[] { VIEW_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.View.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final View view = (View)elt;
			final ViewPropertiesEditionPart viewPart = (ViewPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(DatabaseViewsRepository.View.Properties.name))
				viewPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, view.getName()));
			
			if (isAccessible(DatabaseViewsRepository.View.Properties.query))
				viewPart.setQuery(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, view.getQuery()));
			if (isAccessible(DatabaseViewsRepository.View.Properties.comments))
				viewPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, view.getComments()));
			if (isAccessible(DatabaseViewsRepository.View.Properties.columns)) {
				columnsSettings = new ReferencesTableSettings(view, DatabasePackage.eINSTANCE.getView_Columns());
				viewPart.initColumns(columnsSettings);
			}
			if (isAccessible(DatabaseViewsRepository.View.Properties.tables)) {
				tablesSettings = new ReferencesTableSettings(view, DatabasePackage.eINSTANCE.getView_Tables());
				viewPart.initTables(tablesSettings);
			}
			// init filters
			
			
			
			if (isAccessible(DatabaseViewsRepository.View.Properties.columns)) {
				viewPart.addFilterToColumns(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ViewElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for columns
				// End of user code
			}
			if (isAccessible(DatabaseViewsRepository.View.Properties.tables)) {
				viewPart.addFilterToTables(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ViewElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for tables
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}








	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == DatabaseViewsRepository.View.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.View.Properties.query) {
			return DatabasePackage.eINSTANCE.getView_Query();
		}
		if (editorKey == DatabaseViewsRepository.View.Properties.comments) {
			return DatabasePackage.eINSTANCE.getDatabaseElement_Comments();
		}
		if (editorKey == DatabaseViewsRepository.View.Properties.columns) {
			return DatabasePackage.eINSTANCE.getView_Columns();
		}
		if (editorKey == DatabaseViewsRepository.View.Properties.tables) {
			return DatabasePackage.eINSTANCE.getView_Tables();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		View view = (View)semanticObject;
		if (DatabaseViewsRepository.View.Properties.name == event.getAffectedEditor()) {
			view.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.View.Properties.query == event.getAffectedEditor()) {
			view.setQuery((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.View.Properties.comments == event.getAffectedEditor()) {
			view.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ViewPropertiesEditionPart viewPart = (ViewPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewPart != null && isAccessible(DatabaseViewsRepository.View.Properties.name)) {
				if (msg.getNewValue() != null) {
					viewPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewPart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getView_Query().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewPart != null && isAccessible(DatabaseViewsRepository.View.Properties.query)){
				if (msg.getNewValue() != null) {
					viewPart.setQuery(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewPart.setQuery("");
				}
			}
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && viewPart != null && isAccessible(DatabaseViewsRepository.View.Properties.comments)){
				if (msg.getNewValue() != null) {
					viewPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					viewPart.setComments("");
				}
			}
			if (DatabasePackage.eINSTANCE.getView_Columns().equals(msg.getFeature()) && isAccessible(DatabaseViewsRepository.View.Properties.columns))
				viewPart.updateColumns();
			if (DatabasePackage.eINSTANCE.getView_Tables().equals(msg.getFeature()) && isAccessible(DatabaseViewsRepository.View.Properties.tables))
				viewPart.updateTables();
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			DatabasePackage.eINSTANCE.getNamedElement_Name(),
			DatabasePackage.eINSTANCE.getView_Query(),
			DatabasePackage.eINSTANCE.getDatabaseElement_Comments(),
			DatabasePackage.eINSTANCE.getView_Columns(),
			DatabasePackage.eINSTANCE.getView_Tables()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == DatabaseViewsRepository.View.Properties.name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (DatabaseViewsRepository.View.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.View.Properties.query == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getView_Query().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getView_Query().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.View.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
