package org.obeonetwork.dsl.entityrelation.spec;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Cardinality;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationFactory;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.Identifier;
import org.obeonetwork.dsl.entityrelation.RelationElement;
import org.obeonetwork.dsl.entityrelation.impl.RelationImpl;

public class RelationSpec extends RelationImpl {
	@Override
	public void setSourceCardinality(Cardinality newSourceCardinality) {		
		Cardinality oldSourceCardinality = getSourceCardinality();
		// TODO fix this
		super.setSourceCardinality(newSourceCardinality == null ? Cardinality.ZERO_STAR : newSourceCardinality);
		if (newSourceCardinality != oldSourceCardinality) {
			// Cardinality has changed
			if (oldSourceCardinality.isStarCardinality() == false && newSourceCardinality.isStarCardinality() == true) {
				// Cardinality was 0.1 or 1..1 and now is 0..* or 1..*
				
				// Then the source can not be set as composite
				setSourceIsComposite(false);
				// And the other side can not be 0..* or 1..*
				if (getTargetCardinality() == Cardinality.ZERO_STAR) {
					setTargetCardinality(Cardinality.ZERO_ONE);
				} else if (getTargetCardinality() == Cardinality.ONE_STAR) {
					setTargetCardinality(Cardinality.ONE_ONE);
				}
			} else if (oldSourceCardinality.isStarCardinality() == true && newSourceCardinality.isStarCardinality() == false) {
				// Cardinality was 0.* or 1..* and now is 0..1 or 1..1
				
				// Checks if the identifier is still consistent with the cardinality
				if (getTargetCardinality().isStarCardinality() == true) {
					// the previous identifier can not be used anymore
					setIdentifier(pickBestIdentifier(getTarget()));
				}
			}
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityRelationPackage.RELATION__SOURCE_CARDINALITY, oldSourceCardinality, newSourceCardinality));
	
	}
	
	@Override
	public void setSourceIsComposite(boolean newSourceIsComposite) {
		if (newSourceIsComposite == true && getSourceCardinality() != Cardinality.ONE_ONE && getSourceCardinality() != Cardinality.ZERO_ONE) {
			// Only roles with 1 as upper cardinality can be set as composite 
			return;
		}
		boolean oldSourceIsComposite = isSourceIsComposite();
		super.setSourceIsComposite(newSourceIsComposite);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE, oldSourceIsComposite, newSourceIsComposite));
		if (newSourceIsComposite == true && isTargetIsComposite() == true) {
			// Only one role can be set as composite
			setTargetIsComposite(false);
		}
	}
	
	@Override
	public void setTargetCardinality(Cardinality newTargetCardinality) {

		Cardinality oldTargetCardinality = getTargetCardinality();
		// TODO fix this code
		super.setTargetCardinality(newTargetCardinality == null ? Cardinality.ZERO_ONE : newTargetCardinality);
		if (newTargetCardinality != oldTargetCardinality) {
			// Cardinality has changed
			if (oldTargetCardinality.isStarCardinality() == false && newTargetCardinality.isStarCardinality() == true) {
				// Cardinality was 0.1 or 1..1 and now is 0..* or 1..*
				
				// Then the target can not be set as composite
				setTargetIsComposite(false);
				// And the other side can not be 0..* or 1..*
				if (getSourceCardinality() == Cardinality.ZERO_STAR) {
					setSourceCardinality(Cardinality.ZERO_ONE);
				} else if (getSourceCardinality() == Cardinality.ONE_STAR) {
					setSourceCardinality(Cardinality.ONE_ONE);
				}
			} else if (oldTargetCardinality.isStarCardinality() == true && newTargetCardinality.isStarCardinality() == false) {
				// Cardinality was 0.* or 1..* and now is 0..1 or 1..1
				
				// Checks if the identifier is still consistent with the cardinality
				if (getSourceCardinality().isStarCardinality() == true) {
					// the previous identifier can not be used anymore
					setIdentifier(pickBestIdentifier(getSource()));
				}
			}
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityRelationPackage.RELATION__TARGET_CARDINALITY, oldTargetCardinality, newTargetCardinality));
	
	}
	
	@Override
	public void setTargetIsComposite(boolean newTargetIsComposite) {
		if (newTargetIsComposite == true && getTargetCardinality() != Cardinality.ONE_ONE && getTargetCardinality() != Cardinality.ZERO_ONE) {
			// Only roles with 1 as upper cardinality can be set as composite 
			return;
		}
		boolean oldTargetIsComposite = isTargetIsComposite();
		super.setTargetIsComposite(newTargetIsComposite);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE, oldTargetIsComposite, newTargetIsComposite));
		if (isTargetIsComposite() == true && isSourceIsComposite() == true) {
			// Only one role can be set as composite
			setSourceIsComposite(false);
		}
	}
	
	@Override
	public void setIdentifier(Identifier newIdentifier) {
		Identifier oldIdentifier = getIdentifier();
		super.setIdentifier(newIdentifier);
		
		// We may have to delete and recreate RelationElement instances
		if ((newIdentifier == null && oldIdentifier != null)
				|| (newIdentifier != null && oldIdentifier == null)
				|| (newIdentifier.equals(oldIdentifier) == false)) {
			
			// Delete existing RelationElement instances
			Collection<RelationElement> relationsElements = new ArrayList<RelationElement>(getElements());
			for (RelationElement relationElement : relationsElements) {
				EcoreUtil.delete(relationElement);
			}
			
			// Create new RelationElement instances
			if (newIdentifier != null) {
				if (getSource().equals(newIdentifier.eContainer())) {
					// Identifier is attached to the source
					for (Attribute identifierAttribute : newIdentifier.getAttributes()) {
						Attribute otherAttribute = getOrCreateCorrespondingAttribute(getTarget(), identifierAttribute);
						RelationElement relationElt = EntityRelationFactory.eINSTANCE.createRelationElement();
						relationElt.setSourceAttribute(identifierAttribute);
						relationElt.setTargetAttribute(otherAttribute);
						getElements().add(relationElt);
					}
				} else if (getTarget().equals(newIdentifier.eContainer())) {
					// Identifier is attached to the target
					for (Attribute identifierAttribute : newIdentifier.getAttributes()) {
						Attribute otherAttribute = getOrCreateCorrespondingAttribute(getSource(), identifierAttribute);
						RelationElement relationElt = EntityRelationFactory.eINSTANCE.createRelationElement();
						relationElt.setSourceAttribute(otherAttribute);
						relationElt.setTargetAttribute(identifierAttribute);
						getElements().add(relationElt);
					}
				}
			}
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityRelationPackage.RELATION__IDENTIFIER, oldIdentifier, newIdentifier));
	}
	
	

	private Attribute getOrCreateCorrespondingAttribute(Entity entity, Attribute reference) {
		if (reference.getName() != null) {
			for (Attribute attribute : entity.getAttributes()) {
				if (reference.getName().equalsIgnoreCase(attribute.getName())) {
					return attribute;
				}
			}
		}
		if (entity != null) {
			// No attribute found, we have to create a new one
			Attribute newAttribute = EntityRelationFactory.eINSTANCE.createAttribute();
			entity.getAttributes().add(newAttribute);
			newAttribute.setName(reference.getName());
			newAttribute.setType(EcoreUtil.copy(reference.getType()));
			return newAttribute;
		}
		
		return null;
	}

	
	private Identifier pickBestIdentifier(Entity entity) {
		if (entity != null) {
			if (entity.getPrimaryIdentifier() != null) {
				return entity.getPrimaryIdentifier();
			}
			if (entity.getIdentifiers().isEmpty() == false) {
				return entity.getIdentifiers().get(0); 
			}
		}
		return null;
	}

}
