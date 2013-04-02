/**
 * Generated with Acceleo
 */
package org.obeonetwork.graal.components;

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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.SystemPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SystemSystemPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SYSTEM_PART = "System"; //$NON-NLS-1$

	
	/**
	 * Settings for dtoCategories ReferencesTable
	 */
	private ReferencesTableSettings dtoCategoriesSettings;
	
	/**
	 * Settings for dtos ReferencesTable
	 */
	private ReferencesTableSettings dtosSettings;
	
	/**
	 * Settings for entityBlocks ReferencesTable
	 */
	private ReferencesTableSettings entityBlocksSettings;
	
	/**
	 * Settings for entities ReferencesTable
	 */
	private ReferencesTableSettings entitiesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SystemSystemPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject system, String editing_mode) {
		super(editingContext, system, editing_mode);
		parts = new String[] { SYSTEM_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.System.class;
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
			
			final System system = (System)elt;
			final SystemPropertiesEditionPart systemPart = (SystemPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.System.Properties.description))
				systemPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, system.getDescription()));
			if (isAccessible(GraalViewsRepository.System.Properties.name))
				systemPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, system.getName()));
			
			if (isAccessible(GraalViewsRepository.System.Properties.dtoCategories)) {
				dtoCategoriesSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories());
				systemPart.initDtoCategories(dtoCategoriesSettings);
			}
			if (isAccessible(GraalViewsRepository.System.Properties.dtos)) {
				dtosSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos());
				systemPart.initDtos(dtosSettings);
			}
			if (isAccessible(GraalViewsRepository.System.Properties.entityBlocks)) {
				entityBlocksSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks());
				systemPart.initEntityBlocks(entityBlocksSettings);
			}
			if (isAccessible(GraalViewsRepository.System.Properties.entities)) {
				entitiesSettings = new ReferencesTableSettings(system, GraalPackage.eINSTANCE.getDomainModelRegistry_Entities());
				systemPart.initEntities(entitiesSettings);
			}
			// init filters
			
			
			if (isAccessible(GraalViewsRepository.System.Properties.dtoCategories)) {
				systemPart.addFilterToDtoCategories(new EObjectFilter(SoaPackage.Literals.CATEGORY));
				// Start of user code for additional businessfilters for dtoCategories
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.System.Properties.dtos)) {
				systemPart.addFilterToDtos(new EObjectFilter(SoaPackage.Literals.SERVICE_DTO));
				// Start of user code for additional businessfilters for dtos
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.System.Properties.entityBlocks)) {
				systemPart.addFilterToEntityBlocks(new EObjectFilter(EntityPackage.Literals.BLOCK));
				// Start of user code for additional businessfilters for entityBlocks
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.System.Properties.entities)) {
				systemPart.addFilterToEntities(new EObjectFilter(EntityPackage.Literals.ENTITY));
				// Start of user code for additional businessfilters for entities
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
		if (editorKey == GraalViewsRepository.System.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.System.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == GraalViewsRepository.System.Properties.dtoCategories) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories();
		}
		if (editorKey == GraalViewsRepository.System.Properties.dtos) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos();
		}
		if (editorKey == GraalViewsRepository.System.Properties.entityBlocks) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks();
		}
		if (editorKey == GraalViewsRepository.System.Properties.entities) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Entities();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		System system = (System)semanticObject;
		if (GraalViewsRepository.System.Properties.description == event.getAffectedEditor()) {
			system.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.System.Properties.name == event.getAffectedEditor()) {
			system.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.System.Properties.dtoCategories == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Category) {
					dtoCategoriesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				dtoCategoriesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				dtoCategoriesSettings.move(event.getNewIndex(), (Category) event.getNewValue());
			}
		}
		if (GraalViewsRepository.System.Properties.dtos == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof ServiceDTO) {
					dtosSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				dtosSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				dtosSettings.move(event.getNewIndex(), (ServiceDTO) event.getNewValue());
			}
		}
		if (GraalViewsRepository.System.Properties.entityBlocks == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Block) {
					entityBlocksSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				entityBlocksSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				entityBlocksSettings.move(event.getNewIndex(), (Block) event.getNewValue());
			}
		}
		if (GraalViewsRepository.System.Properties.entities == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Entity) {
					entitiesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				entitiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				entitiesSettings.move(event.getNewIndex(), (Entity) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SystemPropertiesEditionPart systemPart = (SystemPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && systemPart != null && isAccessible(GraalViewsRepository.System.Properties.description)){
				if (msg.getNewValue() != null) {
					systemPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					systemPart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && systemPart != null && isAccessible(GraalViewsRepository.System.Properties.name)) {
				if (msg.getNewValue() != null) {
					systemPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					systemPart.setName("");
				}
			}
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.dtoCategories))
				systemPart.updateDtoCategories();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.dtos))
				systemPart.updateDtos();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.entityBlocks))
				systemPart.updateEntityBlocks();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Entities().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.System.Properties.entities))
				systemPart.updateEntities();
			
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
			EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description(),
			GraalPackage.eINSTANCE.getNamedElement_Name(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks(),
			GraalPackage.eINSTANCE.getDomainModelRegistry_Entities()		);
		return new NotificationFilter[] {filter,};
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
				if (GraalViewsRepository.System.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.System.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
