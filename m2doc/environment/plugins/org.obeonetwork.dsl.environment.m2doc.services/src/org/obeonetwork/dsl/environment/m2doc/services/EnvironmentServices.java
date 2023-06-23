/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.m2doc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;

/**
 * AQL Services for Entity's concepts.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public class EnvironmentServices {

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespacesContainer.getAllNamespaces()}",
		    value = "Returns the list of Namespace directly and indireclty contained in the given NamespacesContainer.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespacesContainer.getAllNamespaces().name->sep(',')}", 
		    				result = "A comma separated list of the given  NamespacesContainer's Namespaces name.")
		    }
		)
	// @formatter:on	
	public List<Namespace> getAllNamespaces(NamespacesContainer root) {
		final List<Namespace> result = new ArrayList<>();

		for (Namespace namespace : root.getOwnedNamespaces()) {
			result.add(namespace);
			result.addAll(getAllNamespaces(namespace));
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespacesContainer.hasAllNamespaces()}",
		    value = "Returns true if the given NamespacesContainer contains at least one Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespacesContainer.hasAllNamespaces()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasAllNamespaces(NamespacesContainer root) {
		return !getAllNamespaces(root).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespaceContainer.qualifiedName()}",
		    value = "Returns the qualifiedname of the given NamespaceContainer.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.qualifiedName()}", 
		    				result = "a.b.mynamespacecontainer")
		    }
		)
	// @formatter:on	
	public String qualifiedName(NamespacesContainer namespacesContainer) {
		if (namespacesContainer instanceof Namespace) {
			final StringBuilder result = new StringBuilder();
			EObject current = namespacesContainer;
			while (current != null && current.eClass() == EnvironmentPackage.eINSTANCE.getNamespace()) {
				if (current instanceof Namespace) {
					result.insert(0, ((Namespace) current).getName());
					result.insert(0, ".");
					current = current.eContainer();
				} else {
					current = null;
				}
			}
			return result.substring(1);
		} else {
			return "";
		}
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myStructuredType.qualifiedName()}",
		    value = "Returns the qualifiedname of the given StructuredType.",
		    examples = {
		    		@Example(
		    				expression = "{m:myStructuredType.qualifiedName()}", 
		    				result = "a.b.MyStructuredType")
		    }
		)
	// @formatter:on	
	public String qualifiedName(StructuredType structuredType) {
		final String result;

		final EObject container = structuredType.eContainer();
		if (container instanceof Namespace) {
			result = qualifiedName((Namespace) container) + "." + structuredType.getName();
		} else {
			result = structuredType.getName();
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myStructuredType.getAllAttributes()}",
		    value = "Returns the List of all Attribute (owned, inherited, and associated) for the given StructuredType.",
		    examples = {
		    		@Example(
		    				expression = "{m:myStructuredType.getAllAttributes().name->sep(',')}", 
		    				result = "the names of all Attribute (owned, inherited, and associated) names separeted by a coma.")
		    }
		)
	// @formatter:on	
	public List<Attribute> getAllAttributes(StructuredType type) {
		final List<Attribute> result = new ArrayList<>();

		result.addAll(type.getOwnedAttributes());
		if (type.getSupertype() != null) {
			result.addAll(getAllAttributes(type.getSupertype()));
		}
		for (StructuredType associatedType : type.getAssociatedTypes()) {
			result.addAll(getAllAttributes(associatedType));
		}

		Collections.sort(result, new Comparator<Attribute>() {

			@Override
			public int compare(Attribute o1, Attribute o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myStructuredType.hasAllAttributes()}",
		    value = "Returns true if there is at least one attribut even from a DTO or inherited.",
		    examples = {
		    		@Example(
		    				expression = "{m:myStructuredType.hasAllAttributes()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasAllAttributes(StructuredType type) {
		return !getAllAttributes(type).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myAttribute.typeName()}",
		    value = "Returns the String representation of the type of the given Attribute.",
		    examples = {
		    		@Example(
		    				expression = "{m:myAttribute.typeName()}", 
		    				result = "String[1]")
		    }
		)
	// @formatter:on	
	public String typeName(Attribute attribute) {
		return attribute.getType().getName() + "[" + attribute.getMultiplicity() + "]";
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myProperty.getOriginTypeIfDifferent(someStructuredType)}",
		    value = "Returns a String representing the origin StructuredType of the given Property if its differente from the given context StructuredType.",
		    examples = {
		    		@Example(
		    				expression = "{m:myProperty.getOriginTypeIfDifferent(someStructuredType)}", 
		    				result = "'From supertype namespace1.someDTO' or 'From Entity namespace1.someEntity' or 'From DTO namespace1.someDTO' or ''.")
		    }
		)
	// @formatter:on	
	public String getOriginTypeIfDifferent(Property property, StructuredType context) {
		final String result;

		final EObject container = property.eContainer();
		if (container instanceof StructuredType) {
			final StructuredType attributeOwnerType;
			if (container == context) {
				attributeOwnerType = null;
			} else {
				attributeOwnerType = (StructuredType) container;
			}

			if (attributeOwnerType != null) {
				final Set<StructuredType> superTypes = getAllSuperTypes(context);
				if (superTypes.contains(attributeOwnerType)) {
					result = "From supertype " + qualifiedName(attributeOwnerType);
				} else {
					result = "From " + attributeOwnerType.eClass().getName() + " " + qualifiedName(attributeOwnerType);
				}
			} else {
				result = "";
			}
		} else {
			result = "";
		}

		return result;
	}

	private Set<StructuredType> getAllSuperTypes(StructuredType type) {
		final Set<StructuredType> res = new HashSet<>();

		if (type != null) {
			StructuredType current = type.getSupertype();
			while (current != null) {
				res.add(current);
				current = current.getSupertype();
			}
		}

		return res;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myReference.getReferencedTypeName()}",
		    value = "Returns the qualifiedname of the StructuredType referenced by the given Reference.",
		    examples = {
		    		@Example(
		    				expression = "{m:myReference.getReferencedTypeName()}", 
		    				result = "a.b.MyStructuredType")
		    }
		)
	// @formatter:on	
	public String getReferencedTypeName(Reference reference) {
		final String result;

		if (reference.getReferencedType() != null) {
			result = qualifiedName(reference.getReferencedType());
		} else {
			result = "";
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myReference.opositeOfName()}",
		    value = "Returns the name of the oposite Reference if any, an empty String otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myReference.opositeOfName()}", 
		    				result = "myReferenceOposite")
		    }
		)
	// @formatter:on	
	public String opositeOfName(Reference reference) {
		final String result;

		if (reference.getOppositeOf() != null) {
			result = reference.getOppositeOf().getName();
		} else {
			result = "";
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedEnumerations()}",
		    value = "Returns the list of Enumeration directly contained in the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedEnumerations().name->sep(',')}", 
		    				result = "The list of Enumration directly contained in the given Namespace names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<Enumeration> getOwnedEnumerations(Namespace namespace) {
		final List<Enumeration> result = new ArrayList<>();

		for (Type type : namespace.getTypes()) {
			if (type instanceof Enumeration) {
				result.add((Enumeration) type);
			}
		}

		Collections.sort(result, new Comparator<Enumeration>() {

			@Override
			public int compare(Enumeration o1, Enumeration o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedEnumerations()}",
		    value = "Returns true if there is at least one Enumeration directly contained in the given Namespace, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedEnumerations()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedEnumerations(Namespace namespace) {
		return !getOwnedEnumerations(namespace).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedDTO()}",
		    value = "Returns the list of DTO directly contained in the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedDTO().name->sep(',')}", 
		    				result = "The list of DTO directly contained in the given Namespace names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<DTO> getOwnedDTO(Namespace namespace) {
		final List<DTO> result = new ArrayList<>();

		for (Type type : namespace.getTypes()) {
			if (type instanceof DTO) {
				result.add((DTO) type);
			}
		}

		Collections.sort(result, new Comparator<DTO>() {

			@Override
			public int compare(DTO o1, DTO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedDTO()}",
		    value = "Returns true if there is at least one DTO directly contained in the given Namespace, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedDTO()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedDTO(Namespace namespace) {
		return !getOwnedDTO(namespace).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedReferences()}",
		    value = "Returns the list of Reference directly contained in the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedEnumerations().name->sep(',')}", 
		    				result = "The list of Reference directly contained in the given Namespace names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<Reference> getOwnedReferences(Namespace namespace) {
		final List<Reference> result = new ArrayList<>();

		for (Type type : namespace.getTypes()) {
			if (type instanceof StructuredType) {
				result.addAll(((StructuredType) type).getOwnedReferences());
			}
		}

		Collections.sort(result, new Comparator<Reference>() {

			@Override
			public int compare(Reference o1, Reference o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedReferences()}",
		    value = "Returns  true if there is at least one Reference directly contained in the given Namespace, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedEnumerations()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on
	public boolean hasOwnedReferences(Namespace namespace) {
		return !getOwnedReferences(namespace).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myType.getName()}",
		    value = "Returns a string representation of the given StructuredType with its super type if any.",
		    examples = {
		    		@Example(
		    				expression = "{m:myType.getName()}", 
		    				result = "SomeEntity \u2192 SuperEntity")
		    }
		)
	// @formatter:on
	public String getName(StructuredType type) {
		final String res;

		if (type.getSupertype() != null) {
			res = type.getName() + " \u2192 " + type.getSupertype().getName();
		} else {
			res = type.getName();
		}

		return res;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myProperty.getName()}",
		    value = "Returns the name of the given Property.",
		    examples = {
		    		@Example(
		    				expression = "{m:myProperty.getName()}", 
		    				result = "'myReference' or 'myAttribute'")
		    }
		)
	// @formatter:on
	public String getName(Property property) {
		return property.getName();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myEnumeration.getName()}",
		    value = "Returns the name of the given Enumeration.",
		    examples = {
		    		@Example(
		    				expression = "{m:myEnumeration.getName()}", 
		    				result = "'myEnumeration'")
		    }
		)
	// @formatter:on
	public String getName(Enumeration enumeration) {
		return enumeration.getName();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getName()}",
		    value = "Returns the name of the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getName()}", 
		    				result = "'mynamespace'")
		    }
		)
	// @formatter:on
	public String getName(Namespace namespace) {
		return namespace.getName();
	}
	
}
