/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.components;

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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowFactory;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.SubflowStatePropertiesEditionPart;
import org.obeonetwork.dsl.environment.EnvironmentPackage;


// End of user code

/**
 * 
 * 
 */
public class SubflowStateSubflowStatePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SUBFLOWSTATE_PART = "SubflowState"; //$NON-NLS-1$

	
	/**
	 * Settings for actions ReferencesTable
	 */
	protected ReferencesTableSettings actionsSettings;
	
	/**
	 * Settings for subflow EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings subflowSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SubflowStateSubflowStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject subflowState, String editing_mode) {
		super(editingContext, subflowState, editing_mode);
		parts = new String[] { SUBFLOWSTATE_PART };
		repositoryKey = FlowViewsRepository.class;
		partKey = FlowViewsRepository.SubflowState.class;
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
			
			final SubflowState subflowState = (SubflowState)elt;
			final SubflowStatePropertiesEditionPart subflowStatePart = (SubflowStatePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(FlowViewsRepository.SubflowState.Properties.description))
				subflowStatePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, subflowState.getDescription()));
			
			if (isAccessible(FlowViewsRepository.SubflowState.Properties.actions)) {
				actionsSettings = new ReferencesTableSettings(subflowState, FlowPackage.eINSTANCE.getFlowState_Actions());
				subflowStatePart.initActions(actionsSettings);
			}
			if (isAccessible(FlowViewsRepository.SubflowState.Properties.subflow)) {
				// init part
				subflowSettings = new EObjectFlatComboSettings(subflowState, FlowPackage.eINSTANCE.getSubflowState_Subflow());
				subflowStatePart.initSubflow(subflowSettings);
				// set the button mode
				subflowStatePart.setSubflowButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			if (isAccessible(FlowViewsRepository.SubflowState.Properties.actions)) {
				subflowStatePart.addFilterToActions(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof FlowAction); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for actions
				// End of user code
			}
			if (isAccessible(FlowViewsRepository.SubflowState.Properties.subflow)) {
				subflowStatePart.addFilterToSubflow(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Flow);
					}
					
				});
				// Start of user code for additional businessfilters for subflow
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
		if (editorKey == FlowViewsRepository.SubflowState.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == FlowViewsRepository.SubflowState.Properties.actions) {
			return FlowPackage.eINSTANCE.getFlowState_Actions();
		}
		if (editorKey == FlowViewsRepository.SubflowState.Properties.subflow) {
			return FlowPackage.eINSTANCE.getSubflowState_Subflow();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SubflowState subflowState = (SubflowState)semanticObject;
		if (FlowViewsRepository.SubflowState.Properties.description == event.getAffectedEditor()) {
			subflowState.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (FlowViewsRepository.SubflowState.Properties.actions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, actionsSettings, editingContext.getAdapterFactory());
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
				actionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				actionsSettings.move(event.getNewIndex(), (FlowAction) event.getNewValue());
			}
		}
		if (FlowViewsRepository.SubflowState.Properties.subflow == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				subflowSettings.setToReference((Flow)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Flow eObject = FlowFactory.eINSTANCE.createFlow();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				subflowSettings.setToReference(eObject);
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
			SubflowStatePropertiesEditionPart subflowStatePart = (SubflowStatePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && subflowStatePart != null && isAccessible(FlowViewsRepository.SubflowState.Properties.description)) {
				if (msg.getNewValue() != null) {
					subflowStatePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					subflowStatePart.setDescription("");
				}
			}
			if (FlowPackage.eINSTANCE.getFlowState_Actions().equals(msg.getFeature()) && isAccessible(FlowViewsRepository.SubflowState.Properties.actions))
				subflowStatePart.updateActions();
			if (FlowPackage.eINSTANCE.getSubflowState_Subflow().equals(msg.getFeature()) && subflowStatePart != null && isAccessible(FlowViewsRepository.SubflowState.Properties.subflow))
				subflowStatePart.setSubflow((EObject)msg.getNewValue());
			
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
			FlowPackage.eINSTANCE.getFlowState_Actions(),
			FlowPackage.eINSTANCE.getSubflowState_Subflow()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == FlowViewsRepository.SubflowState.Properties.subflow;
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
				if (FlowViewsRepository.SubflowState.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().getEAttributeType(), newValue);
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
