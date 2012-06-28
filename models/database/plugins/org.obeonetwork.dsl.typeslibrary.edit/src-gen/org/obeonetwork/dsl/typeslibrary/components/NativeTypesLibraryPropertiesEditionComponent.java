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
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.NativeTypesLibraryPropertiesEditionPart;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class NativeTypesLibraryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String NATIVETYPESLIBRARY_PART = "NativeTypesLibrary"; //$NON-NLS-1$

	
	/**
	 * Settings for nativeTypes ReferencesTable
	 */
	protected ReferencesTableSettings nativeTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public NativeTypesLibraryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject nativeTypesLibrary, String editing_mode) {
		super(editingContext, nativeTypesLibrary, editing_mode);
		parts = new String[] { NATIVETYPESLIBRARY_PART };
		repositoryKey = TypeslibraryViewsRepository.class;
		partKey = TypeslibraryViewsRepository.NativeTypesLibrary.class;
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
			final NativeTypesLibrary nativeTypesLibrary = (NativeTypesLibrary)elt;
			final NativeTypesLibraryPropertiesEditionPart nativeTypesLibraryPart = (NativeTypesLibraryPropertiesEditionPart)editingPart;
			// init values
			if (nativeTypesLibrary.getName() != null && isAccessible(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name))
				nativeTypesLibraryPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nativeTypesLibrary.getName()));
			
			if (isAccessible(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes)) {
				nativeTypesSettings = new ReferencesTableSettings(nativeTypesLibrary, TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_NativeTypes());
				nativeTypesLibraryPart.initNativeTypes(nativeTypesSettings);
			}
			// init filters
			
			if (isAccessible(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes)) {
				nativeTypesLibraryPart.addFilterToNativeTypes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof NativeType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for nativeTypes
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
		if (editorKey == TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name) {
			return TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_Name();
		}
		if (editorKey == TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes) {
			return TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_NativeTypes();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NativeTypesLibrary nativeTypesLibrary = (NativeTypesLibrary)semanticObject;
		if (TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name == event.getAffectedEditor()) {
			nativeTypesLibrary.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, nativeTypesSettings, editingContext.getAdapterFactory());
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
				nativeTypesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				nativeTypesSettings.move(event.getNewIndex(), (NativeType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			NativeTypesLibraryPropertiesEditionPart nativeTypesLibraryPart = (NativeTypesLibraryPropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_Name().equals(msg.getFeature()) && nativeTypesLibraryPart != null && isAccessible(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name)) {
				if (msg.getNewValue() != null) {
					nativeTypesLibraryPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					nativeTypesLibraryPart.setName("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_NativeTypes().equals(msg.getFeature()) && isAccessible(TypeslibraryViewsRepository.NativeTypesLibrary.Properties.nativeTypes))
				nativeTypesLibraryPart.updateNativeTypes();
			
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
				if (TypeslibraryViewsRepository.NativeTypesLibrary.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getNativeTypesLibrary_Name().getEAttributeType(), newValue);
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
