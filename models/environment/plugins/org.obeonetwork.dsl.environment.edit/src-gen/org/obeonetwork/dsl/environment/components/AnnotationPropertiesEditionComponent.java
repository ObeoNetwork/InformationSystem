/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.components;

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
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class AnnotationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String ANNOTATION_PART = "Annotation"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public AnnotationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject annotation, String editing_mode) {
		super(editingContext, annotation, editing_mode);
		parts = new String[] { ANNOTATION_PART };
		repositoryKey = EnvironmentViewsRepository.class;
		partKey = EnvironmentViewsRepository.Annotation.class;
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
			
			final Annotation annotation = (Annotation)elt;
			final AnnotationPropertiesEditionPart annotationPart = (AnnotationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EnvironmentViewsRepository.Annotation.Properties.title_))
				annotationPart.setTitle_(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, annotation.getTitle()));
			
			if (isAccessible(EnvironmentViewsRepository.Annotation.Properties.body))
				annotationPart.setBody(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, annotation.getBody()));
			// init filters
			
			
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
		if (editorKey == EnvironmentViewsRepository.Annotation.Properties.title_) {
			return EnvironmentPackage.eINSTANCE.getAnnotation_Title();
		}
		if (editorKey == EnvironmentViewsRepository.Annotation.Properties.body) {
			return EnvironmentPackage.eINSTANCE.getAnnotation_Body();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Annotation annotation = (Annotation)semanticObject;
		if (EnvironmentViewsRepository.Annotation.Properties.title_ == event.getAffectedEditor()) {
			annotation.setTitle((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EnvironmentViewsRepository.Annotation.Properties.body == event.getAffectedEditor()) {
			annotation.setBody((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AnnotationPropertiesEditionPart annotationPart = (AnnotationPropertiesEditionPart)editingPart;
			if (EnvironmentPackage.eINSTANCE.getAnnotation_Title().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && annotationPart != null && isAccessible(EnvironmentViewsRepository.Annotation.Properties.title_)) {
				if (msg.getNewValue() != null) {
					annotationPart.setTitle_(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					annotationPart.setTitle_("");
				}
			}
			if (EnvironmentPackage.eINSTANCE.getAnnotation_Body().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && annotationPart != null && isAccessible(EnvironmentViewsRepository.Annotation.Properties.body)){
				if (msg.getNewValue() != null) {
					annotationPart.setBody(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					annotationPart.setBody("");
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
			EnvironmentPackage.eINSTANCE.getAnnotation_Title(),
			EnvironmentPackage.eINSTANCE.getAnnotation_Body()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EnvironmentViewsRepository.Annotation.Properties.title_;
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
				if (EnvironmentViewsRepository.Annotation.Properties.title_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getAnnotation_Title().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getAnnotation_Title().getEAttributeType(), newValue);
				}
				if (EnvironmentViewsRepository.Annotation.Properties.body == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EnvironmentPackage.eINSTANCE.getAnnotation_Body().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EnvironmentPackage.eINSTANCE.getAnnotation_Body().getEAttributeType(), newValue);
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
