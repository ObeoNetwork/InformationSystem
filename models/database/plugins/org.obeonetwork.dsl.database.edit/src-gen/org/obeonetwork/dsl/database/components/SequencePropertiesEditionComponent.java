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
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.SequencePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SequencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SEQUENCE_PART = "Sequence"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public SequencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sequence, String editing_mode) {
		super(editingContext, sequence, editing_mode);
		parts = new String[] { SEQUENCE_PART };
		repositoryKey = DatabaseViewsRepository.class;
		partKey = DatabaseViewsRepository.Sequence.class;
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
			
			final Sequence sequence = (Sequence)elt;
			final SequencePropertiesEditionPart sequencePart = (SequencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.name))
				sequencePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequence.getName()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.StartIncrement.start))
				sequencePart.setStart(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, sequence.getStart()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment))
				sequencePart.setIncrement(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, sequence.getIncrement()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.MinMax.minValue))
				sequencePart.setMinValue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, sequence.getMinValue()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue))
				sequencePart.setMaxValue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, sequence.getMaxValue()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle)) {
				sequencePart.setCycle(sequence.isCycle());
			}
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize))
				sequencePart.setCacheSize(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, sequence.getCacheSize()));
			
			if (isAccessible(DatabaseViewsRepository.Sequence.Properties.comments))
				sequencePart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, sequence.getComments()));
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
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.name) {
			return DatabasePackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.StartIncrement.start) {
			return DatabasePackage.eINSTANCE.getSequence_Start();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment) {
			return DatabasePackage.eINSTANCE.getSequence_Increment();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.MinMax.minValue) {
			return DatabasePackage.eINSTANCE.getSequence_MinValue();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue) {
			return DatabasePackage.eINSTANCE.getSequence_MaxValue();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle) {
			return DatabasePackage.eINSTANCE.getSequence_Cycle();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize) {
			return DatabasePackage.eINSTANCE.getSequence_CacheSize();
		}
		if (editorKey == DatabaseViewsRepository.Sequence.Properties.comments) {
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
		Sequence sequence = (Sequence)semanticObject;
		if (DatabaseViewsRepository.Sequence.Properties.name == event.getAffectedEditor()) {
			sequence.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.StartIncrement.start == event.getAffectedEditor()) {
			sequence.setStart((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment == event.getAffectedEditor()) {
			sequence.setIncrement((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.MinMax.minValue == event.getAffectedEditor()) {
			sequence.setMinValue((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue == event.getAffectedEditor()) {
			sequence.setMaxValue((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle == event.getAffectedEditor()) {
			sequence.setCycle((Boolean)event.getNewValue());
		}
		if (DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize == event.getAffectedEditor()) {
			sequence.setCacheSize((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
		if (DatabaseViewsRepository.Sequence.Properties.comments == event.getAffectedEditor()) {
			sequence.setComments((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SequencePropertiesEditionPart sequencePart = (SequencePropertiesEditionPart)editingPart;
			if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.name)) {
				if (msg.getNewValue() != null) {
					sequencePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					sequencePart.setName("");
				}
			}
			if (DatabasePackage.eINSTANCE.getSequence_Start().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.StartIncrement.start)) {
				if (msg.getNewValue() != null) {
					sequencePart.setStart(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					sequencePart.setStart("");
				}
			}
			if (DatabasePackage.eINSTANCE.getSequence_Increment().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment)) {
				if (msg.getNewValue() != null) {
					sequencePart.setIncrement(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					sequencePart.setIncrement("");
				}
			}
			if (DatabasePackage.eINSTANCE.getSequence_MinValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.MinMax.minValue)) {
				if (msg.getNewValue() != null) {
					sequencePart.setMinValue(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					sequencePart.setMinValue("");
				}
			}
			if (DatabasePackage.eINSTANCE.getSequence_MaxValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue)) {
				if (msg.getNewValue() != null) {
					sequencePart.setMaxValue(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					sequencePart.setMaxValue("");
				}
			}
			if (DatabasePackage.eINSTANCE.getSequence_Cycle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle))
				sequencePart.setCycle((Boolean)msg.getNewValue());
			
			if (DatabasePackage.eINSTANCE.getSequence_CacheSize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize)) {
				if (msg.getNewValue() != null) {
					sequencePart.setCacheSize(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					sequencePart.setCacheSize("");
				}
			}
			if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && sequencePart != null && isAccessible(DatabaseViewsRepository.Sequence.Properties.comments)){
				if (msg.getNewValue() != null) {
					sequencePart.setComments(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					sequencePart.setComments("");
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
			DatabasePackage.eINSTANCE.getNamedElement_Name(),
			DatabasePackage.eINSTANCE.getSequence_Start(),
			DatabasePackage.eINSTANCE.getSequence_Increment(),
			DatabasePackage.eINSTANCE.getSequence_MinValue(),
			DatabasePackage.eINSTANCE.getSequence_MaxValue(),
			DatabasePackage.eINSTANCE.getSequence_Cycle(),
			DatabasePackage.eINSTANCE.getSequence_CacheSize(),
			DatabasePackage.eINSTANCE.getDatabaseElement_Comments()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == DatabaseViewsRepository.Sequence.Properties.name;
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
				if (DatabaseViewsRepository.Sequence.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.StartIncrement.start == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_Start().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_Start().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.StartIncrement.increment == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_Increment().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_Increment().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.MinMax.minValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_MinValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_MinValue().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.MinMax.maxValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_MaxValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_MaxValue().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cycle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_Cycle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_Cycle().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.CycleCacheSize.cacheSize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(DatabasePackage.eINSTANCE.getSequence_CacheSize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(DatabasePackage.eINSTANCE.getSequence_CacheSize().getEAttributeType(), newValue);
				}
				if (DatabaseViewsRepository.Sequence.Properties.comments == event.getAffectedEditor()) {
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
