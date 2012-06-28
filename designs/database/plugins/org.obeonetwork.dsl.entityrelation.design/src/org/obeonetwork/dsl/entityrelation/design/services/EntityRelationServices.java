package org.obeonetwork.dsl.entityrelation.design.services;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Cardinality;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationFactory;
import org.obeonetwork.dsl.entityrelation.LogicalModel;
import org.obeonetwork.dsl.entityrelation.Relation;
import org.obeonetwork.dsl.entityrelation.RelationElement;

public class EntityRelationServices {

	public Relation createRelation(Entity source, Entity target) {
		Relation relation = EntityRelationFactory.eINSTANCE.createRelation();
		LogicalModel model = (LogicalModel)source.eContainer();
		model.getRelations().add(relation);
	
		// Set ends
		relation.setSource(source);
		relation.setSourceCardinality(Cardinality.ZERO_STAR);
		relation.setTarget(target);
		relation.setTargetCardinality(Cardinality.ZERO_ONE);
		
		// Set identifier
		if (source.getPrimaryIdentifier() != null) {
			relation.setIdentifier(source.getPrimaryIdentifier());
		} else if (source.getIdentifiers().isEmpty() == false) {
			relation.setIdentifier(source.getIdentifiers().get(0));
		}
		
		// Initialize with attributes
		if (relation.getIdentifier() != null) {
			for (Attribute pkAttribute : relation.getIdentifier().getAttributes()) {
				Attribute fkAttribute = getOrCreateAttribute(target, pkAttribute);
				if (pkAttribute!= null && fkAttribute != null) {
					RelationElement relationElt = EntityRelationFactory.eINSTANCE.createRelationElement();
					relationElt.setSourceAttribute(pkAttribute);
					relationElt.setTargetAttribute(fkAttribute);
					relation.getElements().add(relationElt);
				}
			}
		}
		
		return relation;
	}
	
	private Attribute getOrCreateAttribute(Entity entity, Attribute referenceAttribute) {
		
		// Check if an attribute with the same name already exists
		if (referenceAttribute.getName() != null) {
			for (Attribute attribute : entity.getAttributes()) {
				if (referenceAttribute.getName().equalsIgnoreCase(attribute.getName())) {
					return attribute;
				}
			}
		}
		
			// No Attribute found, we have to create a new one
		Attribute newAttribute = EntityRelationFactory.eINSTANCE.createAttribute();
		entity.getAttributes().add(newAttribute);
		newAttribute.setName(referenceAttribute.getName());
		newAttribute.setType(EcoreUtil.copy(referenceAttribute.getType()));
		return newAttribute;
	}
}
