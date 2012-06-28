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
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectStrictFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.PrimaryKeyPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class PrimaryKeyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String PRIMARYKEY_PART = "Primary Key"; //$NON-NLS-1$

	
	/**
	 * Settings for columns ReferencesTable
	 */
	private ReferencesTableSettings columnsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public PrimaryKeyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject primaryKey, String editing_mode) {
		super(editingContext, primaryKey, editing_mode);
		parts = new String[] { PRIMARYKEY_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.PrimaryKey.class;
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
			final PrimaryKey primaryKey = (PrimaryKey)elt;
			final PrimaryKeyPropertiesEditionPart primaryKeyPart = (PrimaryKeyPropertiesEditionPart)editingPart;
			// init values
			if (primaryKey.getName() != null && isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.name))
				primaryKeyPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, primaryKey.getName()));
			
			if (isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.columns)) {
				columnsSettings = new ReferencesTableSettings(primaryKey, DatabasePackage.eINSTANCE.getPrimaryKey_Columns());
				primaryKeyPart.initColumns(columnsSettings);
			}
			if (primaryKey.getComments() != null && isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.comments))
				primaryKeyPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, primaryKey.getComments()));
			// init filters
			
			if (isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.columns)) {
				primaryKeyPart.addFilterToColumns(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!primaryKeyPart.isContainedInColumnsTable((EObject)element));
						return element instanceof String && element.equals("");
					}
				
				});
				primaryKeyPart.addFilterToColumns(new EObjectStrictFilter(DatabasePackage.Literals.COLUMN));
				// Start of user code for additional businessfilters for columns
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
		if (editorKey == DatabaseViewsRepository.PrimaryKey.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.PrimaryKey.Properties.columns) {
			return DatabasePackage.eINSTANCE.getPrimaryKey_Columns();
		}
		if (editorKey == DatabaseViewsRepository.PrimaryKey.Properties.comments) {
			return DatabasePackage.eINSTANCE.getDatabaseElement_Comments();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PrimaryKey primaryKey = (PrimaryKey)semanticObject;
		if (DatabaseViewsRepository.PrimaryKey.Properties.name == event.getAffectedEditor()) {
			primaryKey.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.PrimaryKey.Properties.columns == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Column) {
					columnsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				columnsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				columnsSettings.move(event.getNewIndex(), (Column) event.getNewValue());
			}
		}
		if (DatabaseViewsRepository.PrimaryKey.Properties.comments == event.getAffectedEditor()) {
			primaryKey.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			PrimaryKeyPropertiesEditionPart primaryKeyPart = (PrimaryKeyPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && primaryKeyPart != null && isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.name)) {
				if (msg.getNewValue() != null) {
					primaryKeyPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					primaryKeyPart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getPrimaryKey_Columns().equals(msg.getFeature())  && isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.columns))
				primaryKeyPart.updateColumns();
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && primaryKeyPart != null && isAccessible(DatabaseViewsRepository.PrimaryKey.Properties.comments)){
				if (msg.getNewValue() != null) {
					primaryKeyPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					primaryKeyPart.setComments("");
				}
			}
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == DatabaseViewsRepository.PrimaryKey.Properties.name;
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
				if (DatabaseViewsRepository.PrimaryKey.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.PrimaryKey.Properties.comments == event.getAffectedEditor()) {
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
