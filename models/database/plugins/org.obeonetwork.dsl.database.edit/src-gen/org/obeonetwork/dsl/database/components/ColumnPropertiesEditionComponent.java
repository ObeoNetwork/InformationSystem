/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
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
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.parts.ColumnPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;


// End of user code

/**
 * 
 * 
 */
public class ColumnPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String COLUMN_PART = "Column"; //$NON-NLS-1$

	
	/**
	 * Settings for sequence EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sequenceSettings;
	
	
	/**
	 * Settings for type editor
	 */
	protected EEFEditorSettingsImpl typeSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for length editor
	 */
	protected EEFEditorSettingsImpl lengthSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Length())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for precision editor
	 */
	protected EEFEditorSettingsImpl precisionSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Settings for literals editor
	 */
	protected EEFEditorSettingsImpl literalsSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals())
	.nextStep(NavigationStepBuilder.create(DatabasePackage.eINSTANCE.getColumn_Type())
	.index(0)
	.discriminator(TypesLibraryPackage.Literals.TYPE_INSTANCE).build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public ColumnPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject column, String editing_mode) {
		super(editingContext, column, editing_mode);
		parts = new String[] { COLUMN_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.Column.class;
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
			final Column column = (Column)elt;
			final ColumnPropertiesEditionPart columnPart = (ColumnPropertiesEditionPart)editingPart;
			// init values
			if (column.getName() != null && isAccessible(DatabaseViewsRepository.Column.Properties.name))
				columnPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, column.getName()));
			
			if (isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable)) {
				columnPart.setNullable(column.isNullable());
			}
			if (isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey)) {
				columnPart.setPrimaryKey(column.isInPrimaryKey());
			}
			if (isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique)) {
				columnPart.setUnique(column.isUnique());
			}
			if (isAccessible(DatabaseViewsRepository.Column.Properties.Sequence.autoincrement)) {
				columnPart.setAutoincrement(column.isAutoincrement());
			}
			if (isAccessible(DatabaseViewsRepository.Column.Properties.Sequence.sequence_)) {
				// init part
				sequenceSettings = new EObjectFlatComboSettings(column, DatabasePackage.eINSTANCE.getColumn_Sequence());
				columnPart.initSequence(sequenceSettings);
				// set the button mode
				columnPart.setSequenceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (column.getDefaultValue() != null && isAccessible(DatabaseViewsRepository.Column.Properties.defaultValue))
				columnPart.setDefaultValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, column.getDefaultValue()));
			
			if (column.getComments() != null && isAccessible(DatabaseViewsRepository.Column.Properties.comments))
				columnPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, column.getComments()));
			if (typeSettings.getSignificantObject() != null && isAccessible(DatabaseViewsRepository.Column.Properties.type)) {
				columnPart.initType(EEFUtils.choiceOfValues(typeSettings.getSignificantObject(), TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType()), typeSettings.getValue());
			}
			if (isAccessible(DatabaseViewsRepository.Column.Properties.TypeAttributes.length)) {
				columnPart.setLength(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, lengthSettings.getValue()));
			}
			
			if (isAccessible(DatabaseViewsRepository.Column.Properties.TypeAttributes.precision)) {
				columnPart.setPrecision(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, precisionSettings.getValue()));
			}
			
			if (literalsSettings.getSignificantObject() != null && isAccessible(DatabaseViewsRepository.Column.Properties.literals)) {
				columnPart.setLiterals((EList)literalsSettings.getValue());
			}
			// init filters
			
			
			
			
			
			if (isAccessible(DatabaseViewsRepository.Column.Properties.Sequence.sequence_)) {
				columnPart.addFilterToSequence(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Sequence); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for sequence
				// End of user code
			}
			
			
			// Start of user code for additional businessfilters for type
			// End of user code
			
			
			
			
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
		if (event.getAffectedEditor() == DatabaseViewsRepository.Column.Properties.type) {
			return (typeSettings.getValue() == null) ? (event.getNewValue() != null) : (!typeSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == DatabaseViewsRepository.Column.Properties.TypeAttributes.length) {
			return (lengthSettings.getValue() == null) ? (event.getNewValue() != null) : (!lengthSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == DatabaseViewsRepository.Column.Properties.TypeAttributes.precision) {
			return (precisionSettings.getValue() == null) ? (event.getNewValue() != null) : (!precisionSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == DatabaseViewsRepository.Column.Properties.literals) {
			return (literalsSettings.getValue() == null) ? (event.getNewValue() != null) : (!literalsSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == DatabaseViewsRepository.Column.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable) {
			return DatabasePackage.eINSTANCE.getColumn_Nullable();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey) {
			return DatabasePackage.eINSTANCE.getColumn_InPrimaryKey();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique) {
			return DatabasePackage.eINSTANCE.getColumn_Unique();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.Sequence.autoincrement) {
			return DatabasePackage.eINSTANCE.getColumn_Autoincrement();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.Sequence.sequence_) {
			return DatabasePackage.eINSTANCE.getColumn_Sequence();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.defaultValue) {
			return DatabasePackage.eINSTANCE.getColumn_DefaultValue();
		}
		if (editorKey == DatabaseViewsRepository.Column.Properties.comments) {
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
		Column column = (Column)semanticObject;
		if (DatabaseViewsRepository.Column.Properties.name == event.getAffectedEditor()) {
			column.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable == event.getAffectedEditor()) {
			column.setNullable((Boolean)event.getNewValue());
		}
		if (DatabaseViewsRepository.Column.Properties.Sequence.autoincrement == event.getAffectedEditor()) {
			column.setAutoincrement((Boolean)event.getNewValue());
		}
		if (DatabaseViewsRepository.Column.Properties.Sequence.sequence_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sequenceSettings.setToReference((Sequence)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Sequence eObject = DatabaseFactory.eINSTANCE.createSequence();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				sequenceSettings.setToReference(eObject);
			}
		}
		if (DatabaseViewsRepository.Column.Properties.defaultValue == event.getAffectedEditor()) {
			column.setDefaultValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Column.Properties.comments == event.getAffectedEditor()) {
			column.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Column.Properties.type == event.getAffectedEditor()) {
			typeSettings.setValue(!"".equals(event.getNewValue()) ? (NativeType) event.getNewValue() : null);
		}
		if (DatabaseViewsRepository.Column.Properties.TypeAttributes.length == event.getAffectedEditor()) {
			lengthSettings.setValue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (DatabaseViewsRepository.Column.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
			precisionSettings.setValue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (DatabaseViewsRepository.Column.Properties.literals == event.getAffectedEditor()) {
			literalsSettings.setValue((List)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ColumnPropertiesEditionPart columnPart = (ColumnPropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.name)) {
				if (msg.getNewValue() != null) {
					columnPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					columnPart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getColumn_Nullable().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable))
				columnPart.setNullable((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getColumn_InPrimaryKey().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey))
				columnPart.setPrimaryKey((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getColumn_Unique().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique))
				columnPart.setUnique((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getColumn_Autoincrement().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.Sequence.autoincrement))
				columnPart.setAutoincrement((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getColumn_Sequence().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.Sequence.sequence_))
				columnPart.setSequence((EObject)msg.getNewValue());
			if (DatabasePackage.eINSTANCE.getColumn_DefaultValue().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.defaultValue)) {
				if (msg.getNewValue() != null) {
					columnPart.setDefaultValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					columnPart.setDefaultValue("");
				}
			}
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.comments)){
				if (msg.getNewValue() != null) {
					columnPart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					columnPart.setComments("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.type))
				columnPart.setType((Object)msg.getNewValue());
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.TypeAttributes.length)) {
				if (msg.getNewValue() != null) {
					columnPart.setLength(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					columnPart.setLength("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.TypeAttributes.precision)) {
				if (msg.getNewValue() != null) {
					columnPart.setPrecision(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					columnPart.setPrecision("");
				}
			}
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().equals(msg.getFeature()) && columnPart != null && isAccessible(DatabaseViewsRepository.Column.Properties.literals)) {
				columnPart.setLiterals((EList)msg.getNewValue());
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
		return key == DatabaseViewsRepository.Column.Properties.name || key == DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable || key == DatabaseViewsRepository.Column.Properties.type;
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
				if (DatabaseViewsRepository.Column.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.nullable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getColumn_Nullable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getColumn_Nullable().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.primaryKey == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getColumn_InPrimaryKey().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getColumn_InPrimaryKey().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.NullablePkAndUnique.unique == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getColumn_Unique().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getColumn_Unique().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.Sequence.autoincrement == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getColumn_Autoincrement().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getColumn_Autoincrement().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.defaultValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getColumn_DefaultValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getColumn_DefaultValue().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.comments == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getDatabaseElement_Comments().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.TypeAttributes.length == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Length().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.TypeAttributes.precision == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Column.Properties.literals == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals().getEAttributeType(), iterator.next()));
					}
					ret = chain;
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
