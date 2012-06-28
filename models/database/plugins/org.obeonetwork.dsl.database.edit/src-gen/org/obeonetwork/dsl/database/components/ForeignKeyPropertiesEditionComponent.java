/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.components;

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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ForeignKeyPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ForeignKeyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FOREIGNKEY_PART = "Foreign Key"; //$NON-NLS-1$

	
	/**
	 * Settings for target EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings targetSettings;
	
	/**
	 * Settings for elements ReferencesTable
	 */
	protected ReferencesTableSettings elementsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ForeignKeyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject foreignKey, String editing_mode) {
		super(editingContext, foreignKey, editing_mode);
		parts = new String[] { FOREIGNKEY_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.ForeignKey.class;
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
			final ForeignKey foreignKey = (ForeignKey)elt;
			final ForeignKeyPropertiesEditionPart foreignKeyPart = (ForeignKeyPropertiesEditionPart)editingPart;
			// init values
			if (foreignKey.getName() != null && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.name))
				foreignKeyPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, foreignKey.getName()));
			
			if (isAccessible(DatabaseViewsRepository.ForeignKey.Properties.target)) {
				// init part
				targetSettings = new EObjectFlatComboSettings(foreignKey, DatabasePackage.eINSTANCE.getForeignKey_Target());
				foreignKeyPart.initTarget(targetSettings);
				// set the button mode
				foreignKeyPart.setTargetButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(DatabaseViewsRepository.ForeignKey.Properties.elements)) {
				elementsSettings = new ReferencesTableSettings(foreignKey, DatabasePackage.eINSTANCE.getForeignKey_Elements());
				foreignKeyPart.initElements(elementsSettings);
			}
			if (foreignKey.getComments() != null && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.comments))
				foreignKeyPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, foreignKey.getComments()));
			// init filters
			
			if (isAccessible(DatabaseViewsRepository.ForeignKey.Properties.target)) {
				foreignKeyPart.addFilterToTarget(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Table); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for target
				// End of user code
			}
			if (isAccessible(DatabaseViewsRepository.ForeignKey.Properties.elements)) {
				foreignKeyPart.addFilterToElements(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ForeignKeyElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for elements
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
		if (editorKey == DatabaseViewsRepository.ForeignKey.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.ForeignKey.Properties.target) {
			return DatabasePackage.eINSTANCE.getForeignKey_Target();
		}
		if (editorKey == DatabaseViewsRepository.ForeignKey.Properties.elements) {
			return DatabasePackage.eINSTANCE.getForeignKey_Elements();
		}
		if (editorKey == DatabaseViewsRepository.ForeignKey.Properties.comments) {
			return DatabasePackage.eINSTANCE.getDatabaseElement_Comments();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ForeignKey foreignKey = (ForeignKey)semanticObject;
		if (DatabaseViewsRepository.ForeignKey.Properties.name == event.getAffectedEditor()) {
			foreignKey.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.ForeignKey.Properties.target == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				targetSettings.setToReference((Table)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Table eObject = DatabaseFactory.eINSTANCE.createTable();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				targetSettings.setToReference(eObject);
			}
		}
		if (DatabaseViewsRepository.ForeignKey.Properties.elements == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, elementsSettings, editingContext.getAdapterFactory());
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
				elementsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				elementsSettings.move(event.getNewIndex(), (ForeignKeyElement) event.getNewValue());
			}
		}
		if (DatabaseViewsRepository.ForeignKey.Properties.comments == event.getAffectedEditor()) {
			foreignKey.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ForeignKeyPropertiesEditionPart foreignKeyPart = (ForeignKeyPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && foreignKeyPart != null && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.name)) {
				if (msg.getNewValue() != null) {
					foreignKeyPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					foreignKeyPart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getForeignKey_Target().equals(msg.getFeature()) && foreignKeyPart != null && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.target))
				foreignKeyPart.setTarget((EObject)msg.getNewValue());
			if (DatabasePackage.eINSTANCE.getForeignKey_Elements().equals(msg.getFeature()) && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.elements))
				foreignKeyPart.updateElements();
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && foreignKeyPart != null && isAccessible(DatabaseViewsRepository.ForeignKey.Properties.comments)){
				if (msg.getNewValue() != null) {
					foreignKeyPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					foreignKeyPart.setComments("");
				}
			}
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == DatabaseViewsRepository.ForeignKey.Properties.name;
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
				if (DatabaseViewsRepository.ForeignKey.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.ForeignKey.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), newValue);
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
