/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.components;

// Start of user code for imports
import java.util.List;

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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectStrictFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.parts.CategoryPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class CategoryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String CATEGORY_PART = "Category"; //$NON-NLS-1$

	
	/**
	 * Settings for requirements ReferencesTable
	 */
	protected ReferencesTableSettings requirementsSettings;
	
	/**
	 * Settings for subCategories ReferencesTable
	 */
	protected ReferencesTableSettings subCategoriesSettings;
	
	/**
	 * Settings for referencedObject ReferencesTable
	 */
	private ReferencesTableSettings referencedObjectSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public CategoryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject category, String editing_mode) {
		super(editingContext, category, editing_mode);
		parts = new String[] { CATEGORY_PART };
		repositoryKey = RequirementViewsRepository.class;
		partKey = RequirementViewsRepository.Category.class;
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
			final Category category = (Category)elt;
			final CategoryPropertiesEditionPart categoryPart = (CategoryPropertiesEditionPart)editingPart;
			// init values
			if (category.getId() != null && isAccessible(RequirementViewsRepository.Category.Category_.id))
				categoryPart.setId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, category.getId()));
			
			if (category.getName() != null && isAccessible(RequirementViewsRepository.Category.Category_.name))
				categoryPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, category.getName()));
			
			if (isAccessible(RequirementViewsRepository.Category.Category_.requirements)) {
				requirementsSettings = new ReferencesTableSettings(category, RequirementPackage.eINSTANCE.getCategory_Requirements());
				categoryPart.initRequirements(requirementsSettings);
			}
			if (isAccessible(RequirementViewsRepository.Category.Category_.subCategories)) {
				subCategoriesSettings = new ReferencesTableSettings(category, RequirementPackage.eINSTANCE.getCategory_SubCategories());
				categoryPart.initSubCategories(subCategoriesSettings);
			}
			if (isAccessible(RequirementViewsRepository.Category.Category_.referencedObject)) {
				referencedObjectSettings = new ReferencesTableSettings(category, RequirementPackage.eINSTANCE.getCategory_ReferencedObject());
				categoryPart.initReferencedObject(referencedObjectSettings);
			}
			// init filters
			
			
			if (isAccessible(RequirementViewsRepository.Category.Category_.requirements)) {
				categoryPart.addFilterToRequirements(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Requirement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for requirements
				// End of user code
			}
			if (isAccessible(RequirementViewsRepository.Category.Category_.subCategories)) {
				categoryPart.addFilterToSubCategories(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Category); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for subCategories
				// End of user code
			}
			if (isAccessible(RequirementViewsRepository.Category.Category_.referencedObject)) {
				categoryPart.addFilterToReferencedObject(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!categoryPart.isContainedInReferencedObjectTable((EObject)element));
						return element instanceof String && element.equals("");
					}
				
				});
				categoryPart.addFilterToReferencedObject(new EObjectStrictFilter(EcorePackage.Literals.EOBJECT));
				// Start of user code for additional businessfilters for referencedObject
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
		if (editorKey == RequirementViewsRepository.Category.Category_.id) {
			return RequirementPackage.eINSTANCE.getCategory_Id();
		}
		if (editorKey == RequirementViewsRepository.Category.Category_.name) {
			return RequirementPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == RequirementViewsRepository.Category.Category_.requirements) {
			return RequirementPackage.eINSTANCE.getCategory_Requirements();
		}
		if (editorKey == RequirementViewsRepository.Category.Category_.subCategories) {
			return RequirementPackage.eINSTANCE.getCategory_SubCategories();
		}
		if (editorKey == RequirementViewsRepository.Category.Category_.referencedObject) {
			return RequirementPackage.eINSTANCE.getCategory_ReferencedObject();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Category category = (Category)semanticObject;
		if (RequirementViewsRepository.Category.Category_.id == event.getAffectedEditor()) {
			category.setId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Category.Category_.name == event.getAffectedEditor()) {
			category.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (RequirementViewsRepository.Category.Category_.requirements == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, requirementsSettings, editingContext.getAdapterFactory());
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
				requirementsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				requirementsSettings.move(event.getNewIndex(), (Requirement) event.getNewValue());
			}
		}
		if (RequirementViewsRepository.Category.Category_.subCategories == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, subCategoriesSettings, editingContext.getAdapterFactory());
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
				subCategoriesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				subCategoriesSettings.move(event.getNewIndex(), (Category) event.getNewValue());
			}
		}
		if (RequirementViewsRepository.Category.Category_.referencedObject == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET)
				referencedObjectSettings.setToReference((List<EObject>) event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			CategoryPropertiesEditionPart categoryPart = (CategoryPropertiesEditionPart)editingPart;
			if (RequirementPackage.eINSTANCE.getCategory_Id().equals(msg.getFeature()) && categoryPart != null && isAccessible(RequirementViewsRepository.Category.Category_.id)) {
				if (msg.getNewValue() != null) {
					categoryPart.setId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					categoryPart.setId("");
				}
			}
			if (RequirementPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && categoryPart != null && isAccessible(RequirementViewsRepository.Category.Category_.name)) {
				if (msg.getNewValue() != null) {
					categoryPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					categoryPart.setName("");
				}
			}
			if (RequirementPackage.eINSTANCE.getCategory_Requirements().equals(msg.getFeature()) && isAccessible(RequirementViewsRepository.Category.Category_.requirements))
				categoryPart.updateRequirements();
			if (RequirementPackage.eINSTANCE.getCategory_SubCategories().equals(msg.getFeature()) && isAccessible(RequirementViewsRepository.Category.Category_.subCategories))
				categoryPart.updateSubCategories();
			if (RequirementPackage.eINSTANCE.getCategory_ReferencedObject().equals(msg.getFeature()) && isAccessible(RequirementViewsRepository.Category.Category_.referencedObject))
				categoryPart.updateReferencedObject();
			
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
				if (RequirementViewsRepository.Category.Category_.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getCategory_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getCategory_Id().getEAttributeType(), newValue);
				}
				if (RequirementViewsRepository.Category.Category_.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(RequirementPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
