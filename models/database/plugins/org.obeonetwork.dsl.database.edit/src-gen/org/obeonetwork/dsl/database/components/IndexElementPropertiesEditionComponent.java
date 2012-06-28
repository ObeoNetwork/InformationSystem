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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.IndexElementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class IndexElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INDEXELEMENT_PART = "Index Element"; //$NON-NLS-1$

	
	/**
	 * Settings for column EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings columnSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public IndexElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject indexElement, String editing_mode) {
		super(editingContext, indexElement, editing_mode);
		parts = new String[] { INDEXELEMENT_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.IndexElement.class;
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
			final IndexElement indexElement = (IndexElement)elt;
			final IndexElementPropertiesEditionPart indexElementPart = (IndexElementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(DatabaseViewsRepository.IndexElement.Properties.column)) {
				// init part
				columnSettings = new EObjectFlatComboSettings(indexElement, DatabasePackage.eINSTANCE.getIndexElement_Column());
				indexElementPart.initColumn(columnSettings);
				// set the button mode
				indexElementPart.setColumnButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(DatabaseViewsRepository.IndexElement.Properties.asc)) {
				indexElementPart.setAsc(indexElement.isAsc());
			}
			if (indexElement.getComments() != null && isAccessible(DatabaseViewsRepository.IndexElement.Properties.comments))
				indexElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, indexElement.getComments()));
			// init filters
			if (isAccessible(DatabaseViewsRepository.IndexElement.Properties.column)) {
				indexElementPart.addFilterToColumn(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Column); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for column
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
		if (editorKey == DatabaseViewsRepository.IndexElement.Properties.column) {
			return DatabasePackage.eINSTANCE.getIndexElement_Column();
		}
		if (editorKey == DatabaseViewsRepository.IndexElement.Properties.asc) {
			return DatabasePackage.eINSTANCE.getIndexElement_Asc();
		}
		if (editorKey == DatabaseViewsRepository.IndexElement.Properties.comments) {
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
		IndexElement indexElement = (IndexElement)semanticObject;
		if (DatabaseViewsRepository.IndexElement.Properties.column == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				columnSettings.setToReference((Column)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Column eObject = DatabaseFactory.eINSTANCE.createColumn();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				columnSettings.setToReference(eObject);
			}
		}
		if (DatabaseViewsRepository.IndexElement.Properties.asc == event.getAffectedEditor()) {
			indexElement.setAsc((Boolean)event.getNewValue());
		}
		if (DatabaseViewsRepository.IndexElement.Properties.comments == event.getAffectedEditor()) {
			indexElement.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			IndexElementPropertiesEditionPart indexElementPart = (IndexElementPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getIndexElement_Column().equals(msg.getFeature()) && indexElementPart != null && isAccessible(DatabaseViewsRepository.IndexElement.Properties.column))
				indexElementPart.setColumn((EObject)msg.getNewValue());
			if (DatabasePackage.eINSTANCE.getIndexElement_Asc().equals(msg.getFeature()) && indexElementPart != null && isAccessible(DatabaseViewsRepository.IndexElement.Properties.asc))
				indexElementPart.setAsc((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && indexElementPart != null && isAccessible(DatabaseViewsRepository.IndexElement.Properties.comments)){
				if (msg.getNewValue() != null) {
					indexElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					indexElementPart.setComments("");
				}
			}
			
		}
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
				if (DatabaseViewsRepository.IndexElement.Properties.asc == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getIndexElement_Asc().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getIndexElement_Asc().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.IndexElement.Properties.comments == event.getAffectedEditor()) {
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
