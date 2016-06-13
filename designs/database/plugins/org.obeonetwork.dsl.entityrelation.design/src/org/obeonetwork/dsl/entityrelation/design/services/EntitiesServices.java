/**
 * 
 */
package org.obeonetwork.dsl.entityrelation.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.LogicalModel;
import org.obeonetwork.dsl.entityrelation.Relation;

/**
 * Class with the entities services
 * 
 * @author jdupont
 * 
 */
public class EntitiesServices {

	/**
	 * Retrieve All Non Referenced External Entities
	 * 
	 * @param context
	 *            Logical Model
	 * @return the list of all non referenced External entities
	 */
	public List<Entity> allNonReferencedExternalEntities(LogicalModel context) {
		// Retrieve all External Entities in Logical Model
		List<Entity> allExternalEntities = allExternalEntities(context);
		// Remove from all External entities, all referenced Entities
		allExternalEntities.removeAll(allReferencedEntities(context));
		return allExternalEntities;
	}
	
	/**
	 * Retrieve all Referenced External Entities
	 * @param context Logical Model
	 * @return the list of all Referenced External Entities
	 */
	public List<Entity> allReferencedExternalEntities(LogicalModel context){
		//<%script type="LogicalModel" name="allReferencedExternalEntities"%>
		//<%allReferencedEntities - entities%>
		// Retrieve all External Entities in Logical Model
		List<Entity> allReferencedEntities = allReferencedEntities(context);
		// Remove from all Referenced entities, all Entities
		allReferencedEntities.removeAll(context.getEntities());
		return allReferencedEntities;
	}
	
	/**
	 * Retrieve all non referenced external entities excluding those already displayed on the diagram
	 * @param context the Logical Model
	 * @param diagram the Diagram
	 * @return the List of all Selectable external Entities
	 */
	public List<Entity> allSelectableExternalEntities (LogicalModel context, DSemanticDiagram diagram){	
		// Retrieve all non Referenced External Entities
		List<Entity> allNonReferencedExternalEntities = allNonReferencedExternalEntities(context);
		List<Entity> entitiesInDiagram = new ArrayList<Entity>();
		// Retrieve all AbstracteDNode contained in diagram.
		List<EObject> allDNodes = EcoreServices.eAllContents(diagram, AbstractDNode.class);
		for (EObject node : allDNodes){
			// Retrieve all entities contained in AbstractDNode
			if (((AbstractDNode)node).getTarget() instanceof Entity){				
				entitiesInDiagram.add((Entity)((AbstractDNode)node).getTarget());
			}
		}
		// Remove all entities contained in AbstractDNode present in allNonReferencedExternalEntities
		allNonReferencedExternalEntities.removeAll(entitiesInDiagram);
		return allNonReferencedExternalEntities;
	}

	/**
	 * Retrieve all External Entities
	 * 
	 * @param context
	 *            the Logical Model
	 * @return the list of all External Entities
	 */
	public List<Entity> allExternalEntities(LogicalModel context) {
		// Retrieve all Entities in Logical Model
		List<Entity> allEntities = allEntities(context);
		// Remove all entities from logical Model present in all entities
		allEntities.removeAll(context.getEntities());
		return allEntities;
	}

	/**
	 * Retrieve all referenced Entities
	 * 
	 * @param context
	 *            the Logical Model
	 * @return the list of all referenced Entities
	 */
	public List<Entity> allReferencedEntities(LogicalModel context) {
		List<Entity> sourcesAndTarget = new ArrayList<Entity>();
		// Retrieve all sources and all target contained in the relations of
		// context
		for (Relation relation : context.getRelations()) {
			sourcesAndTarget.add(relation.getSource());
			sourcesAndTarget.add(relation.getTarget());
		}
		Set<Entity> allReferencedEntities = new HashSet<Entity>();
		// Remove duplicates
		allReferencedEntities.addAll(sourcesAndTarget);
		return new ArrayList<Entity>(allReferencedEntities);
	}

	/**
	 * Retrieve all Entities
	 * 
	 * @param context
	 *            the Logical Model
	 * @return All entities contained in the context
	 */
	public List<Entity> allEntities(LogicalModel context) {
		EcoreServices ecoreService = new EcoreServices();
		// Retrieve all roots contained in the context
		Collection<EObject> allRoots = ecoreService.allRoots(context);
		List<Entity> entities = new ArrayList<Entity>();
		// Retrieve all entities containers in all roots
		for (EObject object : allRoots) {
			List<Entity> allContainedEntities = new ArrayList<Entity>();
			for (EObject obj : EcoreServices.eAllContents(object, Entity.class)) {
				allContainedEntities.add((Entity) obj);
			}
			entities.addAll(allContainedEntities);
		}
		return entities;
	}

}
