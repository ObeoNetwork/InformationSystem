package fr.gouv.mindef.safran.database.transfo.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;

public class EntityUtils {

	public static Collection<Entity> getEntitiesInNamespace(Namespace namespace) {
		Collection<Entity> entities = new ArrayList<Entity>();
		for (Type type : namespace.getTypes()) {
			if (type instanceof Entity) {
				entities.add((Entity)type);
			}
		}
		return entities;
	}
	
	public static Collection<Reference> getEntitiesReferences(Entity entity) {
		Collection<Reference> references = new ArrayList<Reference>();
		for (Reference reference : entity.getReferences()) {
			if (reference.getReferencedType() instanceof Entity) {
				references.add(reference);
			}
		}
		return references;
	}
	
	public static Collection<Reference> getOwnedEntitiesReferences(Entity entity) {
		Collection<Reference> references = new ArrayList<Reference>();
		for (Reference reference : entity.getOwnedReferences()) {
			if (reference.getReferencedType() instanceof Entity) {
				references.add(reference);
			}
		}
		return references;
	}
	
	public static Entity getContainingEntity(Reference reference) {
		StructuredType containingType = reference.getContainingType();
		if (containingType instanceof Entity) {
			return (Entity)containingType;
		}
		return null;
	}
	
	public static Entity getReferencedEntity(Reference reference) {
		StructuredType referencedType = reference.getReferencedType();
		if (referencedType instanceof Entity) {
			return (Entity)referencedType;
		}
		return null;
	}
	
	public static Namespace getContainingNamespace(Entity entity) {
		EObject eContainer = entity.eContainer();
		if (eContainer instanceof Namespace) {
			return (Namespace)eContainer;
		}
		return null;
	}
}
