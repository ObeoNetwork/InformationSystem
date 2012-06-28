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
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.UserDefinedType;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.parts.UserDefinedTypesLibraryPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class UserDefinedTypesLibraryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String USERDEFINEDTYPESLIBRARY_PART = "UserDefinedTypesLibrary"; //$NON-NLS-1$

	
	/**
	 * Settings for userDefinedTypes ReferencesTable
	 */
	protected ReferencesTableSettings userDefinedTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public UserDefinedTypesLibraryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject userDefinedTypesLibrary, String editing_mode) {
		super(editingContext, userDefinedTypesLibrary, editing_mode);
		parts = new String[] { USERDEFINEDTYPESLIBRARY_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.UserDefinedTypesLibrary.class;
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
			final UserDefinedTypesLibrary userDefinedTypesLibrary = (UserDefinedTypesLibrary)elt;
			final UserDefinedTypesLibraryPropertiesEditionPart userDefinedTypesLibraryPart = (UserDefinedTypesLibraryPropertiesEditionPart)editingPart;
			// init values
			if (userDefinedTypesLibrary.getName() != null && isAccessible(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name))
				userDefinedTypesLibraryPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, userDefinedTypesLibrary.getName()));
			
			if (isAccessible(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes)) {
				userDefinedTypesSettings = new ReferencesTableSettings(userDefinedTypesLibrary, TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_UserDefinedTypes());
				userDefinedTypesLibraryPart.initUserDefinedTypes(userDefinedTypesSettings);
			}
			// init filters
			
			if (isAccessible(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes)) {
				userDefinedTypesLibraryPart.addFilterToUserDefinedTypes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof UserDefinedType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for userDefinedTypes
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
		if (editorKey == TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name) {
			return TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_Name();
		}
		if (editorKey == TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes) {
			return TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_UserDefinedTypes();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		UserDefinedTypesLibrary userDefinedTypesLibrary = (UserDefinedTypesLibrary)semanticObject;
		if (TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name == event.getAffectedEditor()) {
			userDefinedTypesLibrary.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, userDefinedTypesSettings, editingContext.getAdapterFactory());
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
				userDefinedTypesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				userDefinedTypesSettings.move(event.getNewIndex(), (UserDefinedType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			UserDefinedTypesLibraryPropertiesEditionPart userDefinedTypesLibraryPart = (UserDefinedTypesLibraryPropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_Name().equals(msg.getFeature()) && userDefinedTypesLibraryPart != null && isAccessible(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name)) {
				if (msg.getNewValue() != null) {
					userDefinedTypesLibraryPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					userDefinedTypesLibraryPart.setName("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_UserDefinedTypes().equals(msg.getFeature()) && isAccessible(TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.userDefinedTypes))
				userDefinedTypesLibraryPart.updateUserDefinedTypes();
			
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
				if (TypeslibraryViewsRepository.UserDefinedTypesLibrary.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getUserDefinedTypesLibrary_Name().getEAttributeType(), newValue);
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
