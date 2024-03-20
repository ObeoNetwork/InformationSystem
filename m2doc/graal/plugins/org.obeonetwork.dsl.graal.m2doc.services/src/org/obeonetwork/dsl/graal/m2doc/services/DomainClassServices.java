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
package org.obeonetwork.dsl.graal.m2doc.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractServiceProvider;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.tools.doc.core.DocumentationLink;

@SuppressWarnings("restriction")
public class DomainClassServices extends AbstractServiceProvider {

	private static class GetOwnedElementsService extends JavaMethodService {

		/**
		 * Constructor.
		 * 
		 * @param publicMethod    the {@link Method}
		 * @param serviceInstance the instance
		 */
		GetOwnedElementsService(Method publicMethod, Object serviceInstance) {
			super(publicMethod, serviceInstance);
		}

		@Override
		public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult,
				IReadOnlyQueryEnvironment environment, List<IType> argTypes) {
			final Set<IType> result = new LinkedHashSet<>();

			result.add(new SequenceType(environment,
					new EClassifierType(environment, EnvironmentPackage.eINSTANCE.getDTO())));
			result.add(new SequenceType(environment,
					new EClassifierType(environment, EntityPackage.eINSTANCE.getEntity())));
			result.add(new SequenceType(environment,
					new EClassifierType(environment, GraalPackage.eINSTANCE.getDomainClass())));
			result.add(new SequenceType(environment,
					new EClassifierType(environment, EnvironmentPackage.eINSTANCE.getEnumeration())));
			result.add(new SequenceType(environment,
					new EClassifierType(environment, EnvironmentPackage.eINSTANCE.getNamespace())));

			return result;
		}

		@Override
		public Set<IType> validateAllType(ValidationServices services, IReadOnlyQueryEnvironment queryEnvironment,
				Map<List<IType>, Set<IType>> allTypes) {
			final Set<IType> res = new LinkedHashSet<>();

			for (Set<IType> types : allTypes.values()) {
				res.addAll(types);
			}

			return res;
		}
	}

	@Override
	protected IService getService(Method method) {
		final IService result;

		if ("getOwnedElements".equals(method.getName())) {
			result = new GetOwnedElementsService(method, this);
		} else {
			result = new JavaMethodService(method, this);
		}

		return result;
	}

	/**
	 * Return first annotation with the specified title
	 */
	// @formatter:off
	@Documentation(
			comment = "{m:myObeoDSMObject.annotation(String)}",
		    value = "Return first annotation with the specified title.",
		    examples = {
		    		@Example(
		    				expression = "{m:myObeoDSMObject.annotation('some title')}", 
		    				result = "The string of the annotation.")
		    }
		)
	// @formatter:on	
	public String annotation(ObeoDSMObject object, String title) {
		if (title == null) {
			return "";
		}
		MetaDataContainer metadataContainer = object.getMetadatas();
		if (metadataContainer != null) {
			for (MetaData data : metadataContainer.getMetadatas()) {
				if (data instanceof Annotation) {
					Annotation annotation = (Annotation) data;
					if (title.equals(annotation.getTitle())) {
						String result = annotation.getBody();
						if (result == null) {
							result = "";
						}
						return result;
					}
				}
			}
		}
		return "";
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myObeoDSMObject.getDocumentationLinks()}",
		    value = "Returns the list of metadata annotations of the target ObeoDSMObject that are documentation links.",
		    examples = {
		    		@Example(
		    				expression = "{m:myObeoDSMObject.getDocumentationLinks().title->sep(',')}", 
		    				result = "A comma separated list of ObeoDSMObject's annotation titles.")
		    }
		)
	// @formatter:on	
	public List<Annotation> getDocumentationLinks(ObeoDSMObject object) {
		List<Annotation> documentationLinks = new ArrayList<>();
		if (object.getMetadatas() != null) {
			for (MetaData metadata : object.getMetadatas().getMetadatas()) {
				if (metadata instanceof Annotation) {
					Annotation annotation = (Annotation) metadata;
					if (isDocumentationLink(annotation)) {
						documentationLinks.add(annotation);
					}
				}
			}
		}
		return documentationLinks;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myObeoDSMObject.hasDocumentationLinks()}",
		    value = "Returns true if the given ObeoDSMObject has at least one documentation link, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myObeoDSMObject.hasDocumentationLinks()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasDocumentationLinks(ObeoDSMObject object) {
		return !getDocumentationLinks(object).isEmpty();
	}
	
	/**
	 * Tells if the given {@link Annotation} is a documentation link.
	 * 
	 * @param annotation the {@link Annotation}
	 * @return <code>true</code> if the given {@link Annotation} is a documentation
	 *         link, <code>false</code> otherwise.
	 */
	private boolean isDocumentationLink(Annotation annotation) {
		final String title = annotation.getTitle();
		return title != null && title.startsWith(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE);
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myObeoDSMObject.getAnnotations()}",
		    value = "Returns the list of metadata annotations of the target ObeoDSMObject that are not documentation links.",
		    examples = {
		    		@Example(
		    				expression = "{m:myObeoDSMObject.getAnnotations().getDocumentTitle()->sep(',')}", 
		    				result = "A comma separated list of ObeoDSMObject's annotation titles.")
		    }
		)
	// @formatter:on	
	public List<Annotation> getAnnotations(ObeoDSMObject obj) {
		final List<Annotation> result = new ArrayList<Annotation>();

		final MetaDataContainer metadatas = obj.getMetadatas();
		if (metadatas != null) {
			for (MetaData md : metadatas.getMetadatas()) {
				if (md instanceof Annotation) {
					Annotation annotation = (Annotation) md;
					if (!isDocumentationLink(annotation)) {
						result.add(annotation);
					}
				}
			}
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myObeoDSMObject.getAnnotations()}",
		    value = "Returns true if the given ObeoDSMObject has at least one metadata annotations that is not documentation links, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myObeoDSMObject.hasAnnotations()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasAnnotations(ObeoDSMObject obj) {
		return !getAnnotations(obj).isEmpty();
	}

	
	// @formatter:off
	@Documentation(
			comment = "{m:myAnnotation.getDocumentTitle()}",
		    value = "Returns the title of the document if the given Annotation is a document link.",
		    examples = {
		    		@Example(
		    				expression = "{m:myAnnotation.getDocumentTitle()}", 
		    				result = "The title of the document.")
		    }
		)
	// @formatter:on	
	public String getDocumentTitle(Annotation annotation) {
		final String result;

		if (isDocumentationLink(annotation)
				&& annotation.getTitle().length() >= DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE.length() + 3) {
			result = annotation.getTitle().substring(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE.length() + 3);
		} else {
			result = "";
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedElements()}",
		    value = "Returns the List of DTO, Entity, DomainClass, Enumeration, Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedElements()}", 
		    				result = "The List of DTO, Entity, DomainClass, Enumeration, Namespace.")
		    }
		)
	// @formatter:on	
	public List<ObeoDSMObject> getOwnedElements(Namespace namespace) {
		final List<ObeoDSMObject> result = new ArrayList<ObeoDSMObject>();

		final List<Type> types = new ArrayList<>();
		types.addAll(namespace.getTypes());
		final List<Reference> references = new ArrayList<>();
		for (Type type : types) {
			if (type instanceof StructuredType) {
				references.addAll(((StructuredType) type).getReferences());
			}
		}
		result.addAll(types);
		result.addAll(references);
		result.addAll(namespace.getOwnedNamespaces());

		Collections.sort(result, new Comparator<ObeoDSMObject>() {

			public int compare(ObeoDSMObject o1, ObeoDSMObject o2) {
				final int result;

				final int typeOrder = getTypeOrder(o1) - getTypeOrder(o2);
				if (typeOrder == 0) {
					final String o1Name = (String) o1.eGet(o1.eClass().getEStructuralFeature("name"));
					final String o2Name = (String) o2.eGet(o2.eClass().getEStructuralFeature("name"));
					result = o1Name.compareTo(o2Name);
				} else {
					result = typeOrder;
				}

				return result;
			};

		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedElements()}",
		    value = "Returns true if the given Namespace contains at least one DTO, Entity, DomainClass, Enumeration, or Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedElements()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedElements(Namespace namespace) {
		return !getOwnedElements(namespace).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedDomainClasses()}",
		    value = "Returns the list of DomainClass directly contained in the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedDomainClasses().name->sep(',')}", 
		    				result = "The list of Enumration directly contained in the given Namespace names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<DomainClass> getOwnedDomainClasses(Namespace namespace) {
		final List<DomainClass> result = new ArrayList<>();

		for (Type type : namespace.getTypes()) {
			if (type instanceof DomainClass) {
				result.add((DomainClass) type);
			}
		}

		Collections.sort(result, new Comparator<DomainClass>() {

			@Override
			public int compare(DomainClass o1, DomainClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedDomainClasses()}",
		    value = "Returns true if there is at least one DomainClass directly contained in the given Namespace, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedDomainClasses()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedDomainClasses(Namespace namespace) {
		return !getOwnedDomainClasses(namespace).isEmpty();
	}

	private int getTypeOrder(ObeoDSMObject obj) {
		final int result;

		if (obj instanceof DTO) {
			result = 10;
		} else if (obj instanceof Entity) {
			result = 20;
		} else if (obj instanceof DomainClass) {
			result = 30;
		} else if (obj instanceof Reference) {
			result = 40;
		} else if (obj instanceof Enumeration) {
			result = 50;
		} else if (obj instanceof Namespace) {
			result = 60;
		} else {
			result = Integer.MAX_VALUE;
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myEObject.getTypeName()}",
		    value = "Returns the name of the EClass of the given EObject.",
		    examples = {
		    		@Example(
		    				expression = "{m:myEObject.getTypeName()}", 
		    				result = "ObeoDSMObject")
		    }
		)
	// @formatter:on	
	public String getTypeName(EObject eObject) {
		return eObject.eClass().getName();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myBoolean.asOuiNon()}",
		    value = "Returns Oui si le boolean est vrai, Non sinon.",
		    examples = {
		    		@Example(
		    				expression = "{m:myBoolean.asOuiNon()}", 
		    				result = "Oui ou Non")
		    }
		)
	// @formatter:on	
	public String asOuiNon(boolean value) {
		final String result;

		if (value) {
			result = "Oui";
		} else {
			result = "Non";
		}

		return result;
	}

}
