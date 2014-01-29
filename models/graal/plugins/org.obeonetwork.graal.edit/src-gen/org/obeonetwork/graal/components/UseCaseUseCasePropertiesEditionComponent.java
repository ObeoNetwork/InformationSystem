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
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.UseCasePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class UseCaseUseCasePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String USECASE_PART = "UseCase"; //$NON-NLS-1$

	
	/**
	 * Settings for tasks ReferencesTable
	 */
	private ReferencesTableSettings tasksSettings;
	
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
	public UseCaseUseCasePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject useCase, String editing_mode) {
		super(editingContext, useCase, editing_mode);
		parts = new String[] { USECASE_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.UseCase.class;
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
			
			final UseCase useCase = (UseCase)elt;
			final UseCasePropertiesEditionPart useCasePart = (UseCasePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.UseCase.Properties.description))
				useCasePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, useCase.getDescription()));
			if (isAccessible(GraalViewsRepository.UseCase.Properties.tasks)) {
				tasksSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getUseCase_Tasks());
				useCasePart.initTasks(tasksSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.name))
				useCasePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, useCase.getName()));
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.dtoCategories)) {
				dtoCategoriesSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories());
				useCasePart.initDtoCategories(dtoCategoriesSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.dtos)) {
				dtosSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos());
				useCasePart.initDtos(dtosSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.entityBlocks)) {
				entityBlocksSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks());
				useCasePart.initEntityBlocks(entityBlocksSettings);
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.entities)) {
				entitiesSettings = new ReferencesTableSettings(useCase, GraalPackage.eINSTANCE.getDomainModelRegistry_Entities());
				useCasePart.initEntities(entitiesSettings);
			}
			// init filters
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.tasks)) {
				useCasePart.addFilterToTasks(new EObjectFilter(GraalPackage.Literals.ABSTRACT_TASK));
				// Start of user code for additional businessfilters for tasks
				// End of user code
			}
			
			if (isAccessible(GraalViewsRepository.UseCase.Properties.dtoCategories)) {
				useCasePart.addFilterToDtoCategories(new EObjectFilter(SoaPackage.Literals.CATEGORY));
				// Start of user code for additional businessfilters for dtoCategories
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.dtos)) {
				useCasePart.addFilterToDtos(new EObjectFilter(SoaPackage.Literals.SERVICE_DTO));
				// Start of user code for additional businessfilters for dtos
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.entityBlocks)) {
				useCasePart.addFilterToEntityBlocks(new EObjectFilter(EntityPackage.Literals.BLOCK));
				// Start of user code for additional businessfilters for entityBlocks
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.UseCase.Properties.entities)) {
				useCasePart.addFilterToEntities(new EObjectFilter(EntityPackage.Literals.ENTITY));
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
		if (editorKey == GraalViewsRepository.UseCase.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.tasks) {
			return GraalPackage.eINSTANCE.getUseCase_Tasks();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.dtoCategories) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.dtos) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.entityBlocks) {
			return GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks();
		}
		if (editorKey == GraalViewsRepository.UseCase.Properties.entities) {
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
		UseCase useCase = (UseCase)semanticObject;
		if (GraalViewsRepository.UseCase.Properties.description == event.getAffectedEditor()) {
			useCase.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.UseCase.Properties.tasks == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof AbstractTask) {
					tasksSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				tasksSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				tasksSettings.move(event.getNewIndex(), (AbstractTask) event.getNewValue());
			}
		}
		if (GraalViewsRepository.UseCase.Properties.name == event.getAffectedEditor()) {
			useCase.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.UseCase.Properties.dtoCategories == event.getAffectedEditor()) {
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
		if (GraalViewsRepository.UseCase.Properties.dtos == event.getAffectedEditor()) {
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
		if (GraalViewsRepository.UseCase.Properties.entityBlocks == event.getAffectedEditor()) {
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
		if (GraalViewsRepository.UseCase.Properties.entities == event.getAffectedEditor()) {
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
			UseCasePropertiesEditionPart useCasePart = (UseCasePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && useCasePart != null && isAccessible(GraalViewsRepository.UseCase.Properties.description)){
				if (msg.getNewValue() != null) {
					useCasePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					useCasePart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getUseCase_Tasks().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.tasks))
				useCasePart.updateTasks();
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && useCasePart != null && isAccessible(GraalViewsRepository.UseCase.Properties.name)) {
				if (msg.getNewValue() != null) {
					useCasePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					useCasePart.setName("");
				}
			}
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_DtoCategories().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.dtoCategories))
				useCasePart.updateDtoCategories();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Dtos().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.dtos))
				useCasePart.updateDtos();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_EntityBlocks().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.entityBlocks))
				useCasePart.updateEntityBlocks();
			if (GraalPackage.eINSTANCE.getDomainModelRegistry_Entities().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.UseCase.Properties.entities))
				useCasePart.updateEntities();
			
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
			GraalPackage.eINSTANCE.getUseCase_Tasks(),
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
				if (GraalViewsRepository.UseCase.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.UseCase.Properties.name == event.getAffectedEditor()) {
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
