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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.TaskPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TaskTaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String TASK_PART = "Task"; //$NON-NLS-1$

	
	/**
	 * Settings for subActivities ReferencesTable
	 */
	protected ReferencesTableSettings subActivitiesSettings;
	
	/**
	 * Settings for actors ReferencesTable
	 */
	private ReferencesTableSettings actorsSettings;
	
	/**
	 * Settings for uses ReferencesTable
	 */
	private ReferencesTableSettings usesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TaskTaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject task, String editing_mode) {
		super(editingContext, task, editing_mode);
		parts = new String[] { TASK_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.Task.class;
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
			
			final Task task = (Task)elt;
			final TaskPropertiesEditionPart taskPart = (TaskPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.Task.Properties.description))
				taskPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, task.getDescription()));
			if (isAccessible(GraalViewsRepository.Task.Properties.subActivities)) {
				subActivitiesSettings = new ReferencesTableSettings(task, GraalPackage.eINSTANCE.getActivity_SubActivities());
				taskPart.initSubActivities(subActivitiesSettings);
			}
			if (isAccessible(GraalViewsRepository.Task.Properties.actors)) {
				actorsSettings = new ReferencesTableSettings(task, GraalPackage.eINSTANCE.getTask_Actors());
				taskPart.initActors(actorsSettings);
			}
			if (isAccessible(GraalViewsRepository.Task.Properties.id))
				taskPart.setId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getId()));
			
			if (isAccessible(GraalViewsRepository.Task.Properties.name))
				taskPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getName()));
			
			if (isAccessible(GraalViewsRepository.Task.Properties.uses)) {
				usesSettings = new ReferencesTableSettings(task, GraalPackage.eINSTANCE.getTask_Uses());
				taskPart.initUses(usesSettings);
			}
			if (isAccessible(GraalViewsRepository.Task.Properties.preconditions))
				taskPart.setPreconditions(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, task.getPreconditions()));
			if (isAccessible(GraalViewsRepository.Task.Properties.postconditions))
				taskPart.setPostconditions(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, task.getPostconditions()));
			// init filters
			
			if (isAccessible(GraalViewsRepository.Task.Properties.subActivities)) {
				taskPart.addFilterToSubActivities(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Activity); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for subActivities
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.Task.Properties.actors)) {
				taskPart.addFilterToActors(new EObjectFilter(GraalPackage.Literals.ACTOR));
				// Start of user code for additional businessfilters for actors
				// End of user code
			}
			
			
			if (isAccessible(GraalViewsRepository.Task.Properties.uses)) {
				taskPart.addFilterToUses(new EObjectFilter(GraalPackage.Literals.TASK));
				// Start of user code for additional businessfilters for uses
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
		if (editorKey == GraalViewsRepository.Task.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.subActivities) {
			return GraalPackage.eINSTANCE.getActivity_SubActivities();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.actors) {
			return GraalPackage.eINSTANCE.getTask_Actors();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.id) {
			return GraalPackage.eINSTANCE.getAbstractTask_Id();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.name) {
			return GraalPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.uses) {
			return GraalPackage.eINSTANCE.getTask_Uses();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.preconditions) {
			return GraalPackage.eINSTANCE.getTask_Preconditions();
		}
		if (editorKey == GraalViewsRepository.Task.Properties.postconditions) {
			return GraalPackage.eINSTANCE.getTask_Postconditions();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Task task = (Task)semanticObject;
		if (GraalViewsRepository.Task.Properties.description == event.getAffectedEditor()) {
			task.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Task.Properties.subActivities == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, subActivitiesSettings, editingContext.getAdapterFactory());
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
				subActivitiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				subActivitiesSettings.move(event.getNewIndex(), (Activity) event.getNewValue());
			}
		}
		if (GraalViewsRepository.Task.Properties.actors == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Actor) {
					actorsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				actorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				actorsSettings.move(event.getNewIndex(), (Actor) event.getNewValue());
			}
		}
		if (GraalViewsRepository.Task.Properties.id == event.getAffectedEditor()) {
			task.setId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Task.Properties.name == event.getAffectedEditor()) {
			task.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Task.Properties.uses == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Task) {
					usesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				usesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				usesSettings.move(event.getNewIndex(), (Task) event.getNewValue());
			}
		}
		if (GraalViewsRepository.Task.Properties.preconditions == event.getAffectedEditor()) {
			task.setPreconditions((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.Task.Properties.postconditions == event.getAffectedEditor()) {
			task.setPostconditions((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			TaskPropertiesEditionPart taskPart = (TaskPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && taskPart != null && isAccessible(GraalViewsRepository.Task.Properties.description)){
				if (msg.getNewValue() != null) {
					taskPart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					taskPart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getActivity_SubActivities().equals(msg.getFeature()) && isAccessible(GraalViewsRepository.Task.Properties.subActivities))
				taskPart.updateSubActivities();
			if (GraalPackage.eINSTANCE.getTask_Actors().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.Task.Properties.actors))
				taskPart.updateActors();
			if (GraalPackage.eINSTANCE.getAbstractTask_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && taskPart != null && isAccessible(GraalViewsRepository.Task.Properties.id)) {
				if (msg.getNewValue() != null) {
					taskPart.setId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					taskPart.setId("");
				}
			}
			if (GraalPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && taskPart != null && isAccessible(GraalViewsRepository.Task.Properties.name)) {
				if (msg.getNewValue() != null) {
					taskPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					taskPart.setName("");
				}
			}
			if (GraalPackage.eINSTANCE.getTask_Uses().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.Task.Properties.uses))
				taskPart.updateUses();
			if (GraalPackage.eINSTANCE.getTask_Preconditions().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && taskPart != null && isAccessible(GraalViewsRepository.Task.Properties.preconditions)){
				if (msg.getNewValue() != null) {
					taskPart.setPreconditions(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					taskPart.setPreconditions("");
				}
			}
			if (GraalPackage.eINSTANCE.getTask_Postconditions().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && taskPart != null && isAccessible(GraalViewsRepository.Task.Properties.postconditions)){
				if (msg.getNewValue() != null) {
					taskPart.setPostconditions(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					taskPart.setPostconditions("");
				}
			}
			
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
			GraalPackage.eINSTANCE.getActivity_SubActivities(),
			GraalPackage.eINSTANCE.getTask_Actors(),
			GraalPackage.eINSTANCE.getAbstractTask_Id(),
			GraalPackage.eINSTANCE.getNamedElement_Name(),
			GraalPackage.eINSTANCE.getTask_Uses(),
			GraalPackage.eINSTANCE.getTask_Preconditions(),
			GraalPackage.eINSTANCE.getTask_Postconditions()		);
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
				if (GraalViewsRepository.Task.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Task.Properties.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getAbstractTask_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getAbstractTask_Id().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Task.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Task.Properties.preconditions == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getTask_Preconditions().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getTask_Preconditions().getEAttributeType(), newValue);
				}
				if (GraalViewsRepository.Task.Properties.postconditions == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(GraalPackage.eINSTANCE.getTask_Postconditions().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(GraalPackage.eINSTANCE.getTask_Postconditions().getEAttributeType(), newValue);
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
