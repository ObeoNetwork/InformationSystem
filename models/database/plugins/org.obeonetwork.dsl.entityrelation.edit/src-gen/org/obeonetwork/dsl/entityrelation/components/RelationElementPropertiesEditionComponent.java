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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.EntityRelationFactory;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.RelationElement;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class RelationElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String RELATIONELEMENT_PART = "Relation Element"; //$NON-NLS-1$

	
	/**
	 * Settings for sourceAttribute EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sourceAttributeSettings;
	
	/**
	 * Settings for targetAttribute EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings targetAttributeSettings;
	
	
	/**
	 * Settings for sourceEntity editor
	 */
	protected EEFEditorSettingsImpl sourceEntitySettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EntityRelationPackage.eINSTANCE.getNamedElement_Name())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getRelationElement_SourceAttribute())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Owner())
	.index(0).build())
	.build();
	
	/**
	 * Settings for targetEntity editor
	 */
	protected EEFEditorSettingsImpl targetEntitySettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EntityRelationPackage.eINSTANCE.getNamedElement_Name())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getRelationElement_SourceAttribute())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(EntityRelationPackage.eINSTANCE.getAttribute_Owner())
	.index(0).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public RelationElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject relationElement, String editing_mode) {
		super(editingContext, relationElement, editing_mode);
		parts = new String[] { RELATIONELEMENT_PART };
		repositoryKey = EntityrelationViewsRepository.class;
		partKey = EntityrelationViewsRepository.RelationElement.class;
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
			final RelationElement relationElement = (RelationElement)elt;
			final RelationElementPropertiesEditionPart relationElementPart = (RelationElementPropertiesEditionPart)editingPart;
			// init values
			if (sourceEntitySettings.getValue() != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.sourceEntity))
				relationElementPart.setSourceEntity(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sourceEntitySettings.getValue()));
			
			if (isAccessible(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute)) {
				// init part
				sourceAttributeSettings = new EObjectFlatComboSettings(relationElement, EntityRelationPackage.eINSTANCE.getRelationElement_SourceAttribute());
				relationElementPart.initSourceAttribute(sourceAttributeSettings);
				// set the button mode
				relationElementPart.setSourceAttributeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (targetEntitySettings.getValue() != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.targetEntity))
				relationElementPart.setTargetEntity(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, targetEntitySettings.getValue()));
			
			if (isAccessible(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute)) {
				// init part
				targetAttributeSettings = new EObjectFlatComboSettings(relationElement, EntityRelationPackage.eINSTANCE.getRelationElement_TargetAttribute());
				relationElementPart.initTargetAttribute(targetAttributeSettings);
				// set the button mode
				relationElementPart.setTargetAttributeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (relationElement.getComments() != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.comments))
				relationElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, relationElement.getComments()));
			// init filters
			
			if (isAccessible(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute)) {
				relationElementPart.addFilterToSourceAttribute(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Attribute); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for sourceAttribute
				// End of user code
			}
			
			if (isAccessible(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute)) {
				relationElementPart.addFilterToTargetAttribute(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Attribute); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for targetAttribute
				// End of user code
			}
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}







	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == EntityrelationViewsRepository.RelationElement.Properties.sourceEntity) {
			return (sourceEntitySettings.getValue() == null) ? (event.getNewValue() != null) : (!sourceEntitySettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == EntityrelationViewsRepository.RelationElement.Properties.targetEntity) {
			return (targetEntitySettings.getValue() == null) ? (event.getNewValue() != null) : (!targetEntitySettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute) {
			return EntityRelationPackage.eINSTANCE.getRelationElement_SourceAttribute();
		}
		if (editorKey == EntityrelationViewsRepository.RelationElement.Properties.targetAttribute) {
			return EntityRelationPackage.eINSTANCE.getRelationElement_TargetAttribute();
		}
		if (editorKey == EntityrelationViewsRepository.RelationElement.Properties.comments) {
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
		RelationElement relationElement = (RelationElement)semanticObject;
		if (EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sourceAttributeSettings.setToReference((Attribute)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Attribute eObject = EntityRelationFactory.eINSTANCE.createAttribute();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				sourceAttributeSettings.setToReference(eObject);
			}
		}
		if (EntityrelationViewsRepository.RelationElement.Properties.targetAttribute == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				targetAttributeSettings.setToReference((Attribute)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Attribute eObject = EntityRelationFactory.eINSTANCE.createAttribute();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				targetAttributeSettings.setToReference(eObject);
			}
		}
		if (EntityrelationViewsRepository.RelationElement.Properties.comments == event.getAffectedEditor()) {
			relationElement.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			RelationElementPropertiesEditionPart relationElementPart = (RelationElementPropertiesEditionPart)editingPart;
			if (EntityRelationPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && relationElementPart != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.sourceEntity)) {
				if (msg.getNewValue() != null) {
					relationElementPart.setSourceEntity(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					relationElementPart.setSourceEntity("");
				}
			}
			if (EntityRelationPackage.eINSTANCE.getRelationElement_SourceAttribute().equals(msg.getFeature()) && relationElementPart != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute))
				relationElementPart.setSourceAttribute((EObject)msg.getNewValue());
			if (EntityRelationPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && relationElementPart != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.targetEntity)) {
				if (msg.getNewValue() != null) {
					relationElementPart.setTargetEntity(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					relationElementPart.setTargetEntity("");
				}
			}
			if (EntityRelationPackage.eINSTANCE.getRelationElement_TargetAttribute().equals(msg.getFeature()) && relationElementPart != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute))
				relationElementPart.setTargetAttribute((EObject)msg.getNewValue());
			if (EntityRelationPackage.eINSTANCE.getLogicalElement_Comments().equals(msg.getFeature()) && relationElementPart != null && isAccessible(EntityrelationViewsRepository.RelationElement.Properties.comments)){
				if (msg.getNewValue() != null) {
					relationElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					relationElementPart.setComments("");
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
				if (EntityrelationViewsRepository.RelationElement.Properties.sourceEntity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.RelationElement.Properties.targetEntity == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EntityRelationPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (EntityrelationViewsRepository.RelationElement.Properties.comments == event.getAffectedEditor()) {
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
