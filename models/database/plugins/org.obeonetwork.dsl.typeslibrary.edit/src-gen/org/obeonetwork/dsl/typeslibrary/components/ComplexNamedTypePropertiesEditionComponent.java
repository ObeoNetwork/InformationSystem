/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.components;

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
import org.obeonetwork.dsl.typeslibrary.ComplexNamedType;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.UserDefinedType;
import org.obeonetwork.dsl.typeslibrary.parts.ComplexNamedTypePropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class ComplexNamedTypePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String COMPLEXNAMEDTYPE_PART = "ComplexNamedType"; //$NON-NLS-1$

	
	/**
	 * Settings for types ReferencesTable
	 */
	protected ReferencesTableSettings typesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ComplexNamedTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject complexNamedType, String editing_mode) {
		super(editingContext, complexNamedType, editing_mode);
		parts = new String[] { COMPLEXNAMEDTYPE_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.ComplexNamedType.class;
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
			final ComplexNamedType complexNamedType = (ComplexNamedType)elt;
			final ComplexNamedTypePropertiesEditionPart complexNamedTypePart = (ComplexNamedTypePropertiesEditionPart)editingPart;
			// init values
			if (complexNamedType.getName() != null && isAccessible(TypeslibraryViewsRepository.ComplexNamedType.Properties.name))
				complexNamedTypePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, complexNamedType.getName()));
			
			if (isAccessible(TypeslibraryViewsRepository.ComplexNamedType.Properties.types)) {
				typesSettings = new ReferencesTableSettings(complexNamedType, TypesLibraryPackage.eINSTANCE.getComplexNamedType_Types());
				complexNamedTypePart.initTypes(typesSettings);
			}
			// init filters
			
			if (isAccessible(TypeslibraryViewsRepository.ComplexNamedType.Properties.types)) {
				complexNamedTypePart.addFilterToTypes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof UserDefinedType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for types
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
		if (editorKey == TypeslibraryViewsRepository.ComplexNamedType.Properties.name) {
			return TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name();
		}
		if (editorKey == TypeslibraryViewsRepository.ComplexNamedType.Properties.types) {
			return TypesLibraryPackage.eINSTANCE.getComplexNamedType_Types();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ComplexNamedType complexNamedType = (ComplexNamedType)semanticObject;
		if (TypeslibraryViewsRepository.ComplexNamedType.Properties.name == event.getAffectedEditor()) {
			complexNamedType.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.ComplexNamedType.Properties.types == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, typesSettings, editingContext.getAdapterFactory());
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
				typesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				typesSettings.move(event.getNewIndex(), (UserDefinedType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ComplexNamedTypePropertiesEditionPart complexNamedTypePart = (ComplexNamedTypePropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().equals(msg.getFeature()) && complexNamedTypePart != null && isAccessible(TypeslibraryViewsRepository.ComplexNamedType.Properties.name)) {
				if (msg.getNewValue() != null) {
					complexNamedTypePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					complexNamedTypePart.setName("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getComplexNamedType_Types().equals(msg.getFeature()) && isAccessible(TypeslibraryViewsRepository.ComplexNamedType.Properties.types))
				complexNamedTypePart.updateTypes();
			
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
				if (TypeslibraryViewsRepository.ComplexNamedType.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getUserDefinedType_Name().getEAttributeType(), newValue);
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
