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
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.ForeignKeyElementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ForeignKeyElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String FOREIGNKEYELEMENT_PART = "Foreign Key Element"; //$NON-NLS-1$

	
	/**
	 * Settings for fkColumn EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings fkColumnSettings;
	
	/**
	 * Settings for pkColumn EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings pkColumnSettings;
	
	
	/**
	 * Settings for sourceTable editor
	 */
	protected EEFEditorSettingsImpl sourceTableSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, DatabasePackage.eINSTANCE.getNamedElement_Name())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getForeignKeyElement_FkColumn())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Owner())
	.index(0).build())
	.build();
	
	/**
	 * Settings for targetTable editor
	 */
	protected EEFEditorSettingsImpl targetTableSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, DatabasePackage.eINSTANCE.getNamedElement_Name())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getForeignKeyElement_PkColumn())
	.index(0).build())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Owner())
	.index(0).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public ForeignKeyElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject foreignKeyElement, String editing_mode) {
		super(editingContext, foreignKeyElement, editing_mode);
		parts = new String[] { FOREIGNKEYELEMENT_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.ForeignKeyElement.class;
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
			final ForeignKeyElement foreignKeyElement = (ForeignKeyElement)elt;
			final ForeignKeyElementPropertiesEditionPart foreignKeyElementPart = (ForeignKeyElementPropertiesEditionPart)editingPart;
			// init values
			if (foreignKeyElement.getComments() != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.comments))
				foreignKeyElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, foreignKeyElement.getComments()));
			if (isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn)) {
				// init part
				fkColumnSettings = new EObjectFlatComboSettings(foreignKeyElement, DatabasePackage.eINSTANCE.getForeignKeyElement_FkColumn());
				foreignKeyElementPart.initFKColumn(fkColumnSettings);
				// set the button mode
				foreignKeyElementPart.setFKColumnButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn)) {
				// init part
				pkColumnSettings = new EObjectFlatComboSettings(foreignKeyElement, DatabasePackage.eINSTANCE.getForeignKeyElement_PkColumn());
				foreignKeyElementPart.initPKColumn(pkColumnSettings);
				// set the button mode
				foreignKeyElementPart.setPKColumnButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (sourceTableSettings.getValue() != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable))
				foreignKeyElementPart.setSourceTable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sourceTableSettings.getValue()));
			
			if (targetTableSettings.getValue() != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable))
				foreignKeyElementPart.setTargetTable(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, targetTableSettings.getValue()));
			
			// init filters
			
			if (isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn)) {
				foreignKeyElementPart.addFilterToFKColumn(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Column); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for fkColumn
				// End of user code
			}
			if (isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn)) {
				foreignKeyElementPart.addFilterToPKColumn(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Column); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for pkColumn
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
		if (event.getAffectedEditor() == DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable) {
			return (sourceTableSettings.getValue() == null) ? (event.getNewValue() != null) : (!sourceTableSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable) {
			return (targetTableSettings.getValue() == null) ? (event.getNewValue() != null) : (!targetTableSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == DatabaseViewsRepository.ForeignKeyElement.Properties.comments) {
			return DatabasePackage.eINSTANCE.getDatabaseElement_Comments();
		}
		if (editorKey == DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn) {
			return DatabasePackage.eINSTANCE.getForeignKeyElement_FkColumn();
		}
		if (editorKey == DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn) {
			return DatabasePackage.eINSTANCE.getForeignKeyElement_PkColumn();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ForeignKeyElement foreignKeyElement = (ForeignKeyElement)semanticObject;
		if (DatabaseViewsRepository.ForeignKeyElement.Properties.comments == event.getAffectedEditor()) {
			foreignKeyElement.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				fkColumnSettings.setToReference((Column)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Column eObject = DatabaseFactory.eINSTANCE.createColumn();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				fkColumnSettings.setToReference(eObject);
			}
		}
		if (DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				pkColumnSettings.setToReference((Column)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Column eObject = DatabaseFactory.eINSTANCE.createColumn();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				pkColumnSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ForeignKeyElementPropertiesEditionPart foreignKeyElementPart = (ForeignKeyElementPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && foreignKeyElementPart != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.comments)){
				if (msg.getNewValue() != null) {
					foreignKeyElementPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					foreignKeyElementPart.setComments("");
				}
			}
			if (DatabasePackage.eINSTANCE.getForeignKeyElement_FkColumn().equals(msg.getFeature()) && foreignKeyElementPart != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.fKColumn))
				foreignKeyElementPart.setFKColumn((EObject)msg.getNewValue());
			if (DatabasePackage.eINSTANCE.getForeignKeyElement_PkColumn().equals(msg.getFeature()) && foreignKeyElementPart != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.pKColumn))
				foreignKeyElementPart.setPKColumn((EObject)msg.getNewValue());
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && foreignKeyElementPart != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable)) {
				if (msg.getNewValue() != null) {
					foreignKeyElementPart.setSourceTable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					foreignKeyElementPart.setSourceTable("");
				}
			}
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && foreignKeyElementPart != null && isAccessible(DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable)) {
				if (msg.getNewValue() != null) {
					foreignKeyElementPart.setTargetTable(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					foreignKeyElementPart.setTargetTable("");
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
		return key == DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable || key == DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable;
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
				if (DatabaseViewsRepository.ForeignKeyElement.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.ForeignKeyElement.Properties.sourceTable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.ForeignKeyElement.Properties.targetTable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
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
