/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.components;

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
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class EntityEntityPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String ENTITY_PART = "Entity"; //$NON-NLS-1$

	
	/**
	 * Settings for attributes ReferencesTable
	 */
	protected ReferencesTableSettings attributesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EntityEntityPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entity, String editing_mode) {
		super(editingContext, entity, editing_mode);
		parts = new String[] { ENTITY_PART };
		repositoryKey = EntityrelationViewsRepository.class;
		partKey = EntityrelationViewsRepository.Entity.class;
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
			final Entity entity = (Entity)elt;
			final EntityPropertiesEditionPart entityPart = (EntityPropertiesEditionPart)editingPart;
			// init values
			if (entity.getName() != null && isAccessible(EntityrelationViewsRepository.Entity.Properties.name))
				entityPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, entity.getName()));
			
			if (isAccessible(EntityrelationViewsRepository.Entity.Properties.attributes)) {
				attributesSettings = new ReferencesTableSettings(entity, EntityRelationPackage.eINSTANCE.getEntity_Attributes());
				entityPart.initAttributes(attributesSettings);
			}
			if (entity.getComments() != null && isAccessible(EntityrelationViewsRepository.Entity.Properties.comments))
				entityPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, entity.getComments()));
			// init filters
			
			if (isAccessible(EntityrelationViewsRepository.Entity.Properties.attributes)) {
				entityPart.addFilterToAttributes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Attribute); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for attributes
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
		if (editorKey == EntityrelationViewsRepository.Entity.Properties.name) {
			return EntityRelationPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == EntityrelationViewsRepository.Entity.Properties.attributes) {
			return EntityRelationPackage.eINSTANCE.getEntity_Attributes();
		}
		if (editorKey == EntityrelationViewsRepository.Entity.Properties.comments) {
			return EntityRelationPackage.eINSTANCE.getLogicalElement_Comments();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Entity entity = (Entity)semanticObject;
		if (EntityrelationViewsRepository.Entity.Properties.name == event.getAffectedEditor()) {
			entity.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EntityrelationViewsRepository.Entity.Properties.attributes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, attributesSettings, editingContext.getAdapterFactory());
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
				attributesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				attributesSettings.move(event.getNewIndex(), (Attribute) event.getNewValue());
			}
		}
		if (EntityrelationViewsRepository.Entity.Properties.comments == event.getAffectedEditor()) {
			entity.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EntityPropertiesEditionPart entityPart = (EntityPropertiesEditionPart)editingPart;
			if (EntityRelationPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && entityPart != null && isAccessible(EntityrelationViewsRepository.Entity.Properties.name)) {
				if (msg.getNewValue() != null) {
					entityPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					entityPart.setName("");
				}
			}
			if (EntityRelationPackage.eINSTANCE.getEntity_Attributes().equals(msg.getFeature()) && isAccessible(EntityrelationViewsRepository.Entity.Properties.attributes))
				entityPart.updateAttributes();
			if (EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().equals(msg.getFeature()) && entityPart != null && isAccessible(EntityrelationViewsRepository.Entity.Properties.comments)){
				if (msg.getNewValue() != null) {
					entityPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					entityPart.setComments("");
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
				if (EntityrelationViewsRepository.Entity.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.Entity.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().getEAttributeType(), newValue);
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
