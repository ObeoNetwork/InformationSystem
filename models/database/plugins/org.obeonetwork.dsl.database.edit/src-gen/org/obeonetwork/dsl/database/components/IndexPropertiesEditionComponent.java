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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.IndexPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class IndexPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INDEX_PART = "Index"; //$NON-NLS-1$

	
	/**
	 * Settings for elements ReferencesTable
	 */
	protected ReferencesTableSettings elementsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public IndexPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject index, String editing_mode) {
		super(editingContext, index, editing_mode);
		parts = new String[] { INDEX_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.Index.class;
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
			final Index index = (Index)elt;
			final IndexPropertiesEditionPart indexPart = (IndexPropertiesEditionPart)editingPart;
			// init values
			if (index.getName() != null && isAccessible(DatabaseViewsRepository.Index.Properties.name))
				indexPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, index.getName()));
			
			if (index.getQualifier() != null && isAccessible(DatabaseViewsRepository.Index.Properties.qualifier))
				indexPart.setQualifier(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, index.getQualifier()));
			
			if (isAccessible(DatabaseViewsRepository.Index.Properties.unique)) {
				indexPart.setUnique(index.isUnique());
			}
			if (isAccessible(DatabaseViewsRepository.Index.Properties.cardinality)) {
				indexPart.setCardinality(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, index.getCardinality()));
			}
			
			if (index.getIndexType() != null && isAccessible(DatabaseViewsRepository.Index.Properties.indexType))
				indexPart.setIndexType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, index.getIndexType()));
			
			if (index.getComments() != null && isAccessible(DatabaseViewsRepository.Index.Properties.comments))
				indexPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, index.getComments()));
			if (isAccessible(DatabaseViewsRepository.Index.Properties.elements)) {
				elementsSettings = new ReferencesTableSettings(index, DatabasePackage.eINSTANCE.getIndex_Elements());
				indexPart.initElements(elementsSettings);
			}
			// init filters
			
			
			
			
			
			
			if (isAccessible(DatabaseViewsRepository.Index.Properties.elements)) {
				indexPart.addFilterToElements(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof IndexElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for elements
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
		if (editorKey == DatabaseViewsRepository.Index.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.qualifier) {
			return DatabasePackage.eINSTANCE.getIndex_Qualifier();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.unique) {
			return DatabasePackage.eINSTANCE.getIndex_Unique();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.cardinality) {
			return DatabasePackage.eINSTANCE.getIndex_Cardinality();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.indexType) {
			return DatabasePackage.eINSTANCE.getIndex_IndexType();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.comments) {
			return DatabasePackage.eINSTANCE.getDatabaseElement_Comments();
		}
		if (editorKey == DatabaseViewsRepository.Index.Properties.elements) {
			return DatabasePackage.eINSTANCE.getIndex_Elements();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Index index = (Index)semanticObject;
		if (DatabaseViewsRepository.Index.Properties.name == event.getAffectedEditor()) {
			index.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Index.Properties.qualifier == event.getAffectedEditor()) {
			index.setQualifier((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Index.Properties.unique == event.getAffectedEditor()) {
			index.setUnique((Boolean)event.getNewValue());
		}
		if (DatabaseViewsRepository.Index.Properties.cardinality == event.getAffectedEditor()) {
			index.setCardinality((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (DatabaseViewsRepository.Index.Properties.indexType == event.getAffectedEditor()) {
			index.setIndexType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Index.Properties.comments == event.getAffectedEditor()) {
			index.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Index.Properties.elements == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, elementsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				elementsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				elementsSettings.move(event.getNewIndex(), (IndexElement) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			IndexPropertiesEditionPart indexPart = (IndexPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.name)) {
				if (msg.getNewValue() != null) {
					indexPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					indexPart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getIndex_Qualifier().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.qualifier)) {
				if (msg.getNewValue() != null) {
					indexPart.setQualifier(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					indexPart.setQualifier("");
				}
			}
			if (DatabasePackage.eINSTANCE.getIndex_Unique().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.unique))
				indexPart.setUnique((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getIndex_Cardinality().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.cardinality)) {
				if (msg.getNewValue() != null) {
					indexPart.setCardinality(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					indexPart.setCardinality("");
				}
			}
			if (DatabasePackage.eINSTANCE.getIndex_IndexType().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.indexType)) {
				if (msg.getNewValue() != null) {
					indexPart.setIndexType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					indexPart.setIndexType("");
				}
			}
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && indexPart != null && isAccessible(DatabaseViewsRepository.Index.Properties.comments)){
				if (msg.getNewValue() != null) {
					indexPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					indexPart.setComments("");
				}
			}
			if (DatabasePackage.eINSTANCE.getIndex_Elements().equals(msg.getFeature()) && isAccessible(DatabaseViewsRepository.Index.Properties.elements))
				indexPart.updateElements();
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == DatabaseViewsRepository.Index.Properties.name;
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
				if (DatabaseViewsRepository.Index.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Index.Properties.qualifier == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getIndex_Qualifier().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getIndex_Qualifier().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Index.Properties.unique == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getIndex_Unique().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getIndex_Unique().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Index.Properties.cardinality == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getIndex_Cardinality().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getIndex_Cardinality().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Index.Properties.indexType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getIndex_IndexType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getIndex_IndexType().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Index.Properties.comments == event.getAffectedEditor()) {
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
