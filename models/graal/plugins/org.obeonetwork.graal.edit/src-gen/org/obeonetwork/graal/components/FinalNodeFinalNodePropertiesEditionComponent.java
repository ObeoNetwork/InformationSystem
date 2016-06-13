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
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.graal.FinalNode;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.parts.FinalNodePropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class FinalNodeFinalNodePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FINALNODE_PART = "FinalNode"; //$NON-NLS-1$

	
	/**
	 * Settings for outgoingTransitions ReferencesTable
	 */
	private ReferencesTableSettings outgoingTransitionsSettings;
	
	/**
	 * Settings for incomingTransitions ReferencesTable
	 */
	private ReferencesTableSettings incomingTransitionsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public FinalNodeFinalNodePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject finalNode, String editing_mode) {
		super(editingContext, finalNode, editing_mode);
		parts = new String[] { FINALNODE_PART };
		repositoryKey = GraalViewsRepository.class;
		partKey = GraalViewsRepository.FinalNode.class;
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
			
			final FinalNode finalNode = (FinalNode)elt;
			final FinalNodePropertiesEditionPart finalNodePart = (FinalNodePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(GraalViewsRepository.FinalNode.Properties.description))
				finalNodePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, finalNode.getDescription()));
			if (isAccessible(GraalViewsRepository.FinalNode.Properties.outgoingTransitions)) {
				outgoingTransitionsSettings = new ReferencesTableSettings(finalNode, GraalPackage.eINSTANCE.getNode_OutgoingTransitions());
				finalNodePart.initOutgoingTransitions(outgoingTransitionsSettings);
			}
			if (isAccessible(GraalViewsRepository.FinalNode.Properties.incomingTransitions)) {
				incomingTransitionsSettings = new ReferencesTableSettings(finalNode, GraalPackage.eINSTANCE.getNode_IncomingTransitions());
				finalNodePart.initIncomingTransitions(incomingTransitionsSettings);
			}
			// init filters
			
			if (isAccessible(GraalViewsRepository.FinalNode.Properties.outgoingTransitions)) {
				finalNodePart.addFilterToOutgoingTransitions(new EObjectFilter(GraalPackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for outgoingTransitions
				// End of user code
			}
			if (isAccessible(GraalViewsRepository.FinalNode.Properties.incomingTransitions)) {
				finalNodePart.addFilterToIncomingTransitions(new EObjectFilter(GraalPackage.Literals.TRANSITION));
				// Start of user code for additional businessfilters for incomingTransitions
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
		if (editorKey == GraalViewsRepository.FinalNode.Properties.description) {
			return EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description();
		}
		if (editorKey == GraalViewsRepository.FinalNode.Properties.outgoingTransitions) {
			return GraalPackage.eINSTANCE.getNode_OutgoingTransitions();
		}
		if (editorKey == GraalViewsRepository.FinalNode.Properties.incomingTransitions) {
			return GraalPackage.eINSTANCE.getNode_IncomingTransitions();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		FinalNode finalNode = (FinalNode)semanticObject;
		if (GraalViewsRepository.FinalNode.Properties.description == event.getAffectedEditor()) {
			finalNode.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (GraalViewsRepository.FinalNode.Properties.outgoingTransitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Transition) {
					outgoingTransitionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				outgoingTransitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outgoingTransitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
			}
		}
		if (GraalViewsRepository.FinalNode.Properties.incomingTransitions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Transition) {
					incomingTransitionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				incomingTransitionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				incomingTransitionsSettings.move(event.getNewIndex(), (Transition) event.getNewValue());
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
			FinalNodePropertiesEditionPart finalNodePart = (FinalNodePropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getObeoDSMObject_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && finalNodePart != null && isAccessible(GraalViewsRepository.FinalNode.Properties.description)){
				if (msg.getNewValue() != null) {
					finalNodePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					finalNodePart.setDescription("");
				}
			}
			if (GraalPackage.eINSTANCE.getNode_OutgoingTransitions().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.FinalNode.Properties.outgoingTransitions))
				finalNodePart.updateOutgoingTransitions();
			if (GraalPackage.eINSTANCE.getNode_IncomingTransitions().equals(msg.getFeature())  && isAccessible(GraalViewsRepository.FinalNode.Properties.incomingTransitions))
				finalNodePart.updateIncomingTransitions();
			
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
			GraalPackage.eINSTANCE.getNode_OutgoingTransitions(),
			GraalPackage.eINSTANCE.getNode_IncomingTransitions()		);
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
				if (GraalViewsRepository.FinalNode.Properties.description == event.getAffectedEditor()) {
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
