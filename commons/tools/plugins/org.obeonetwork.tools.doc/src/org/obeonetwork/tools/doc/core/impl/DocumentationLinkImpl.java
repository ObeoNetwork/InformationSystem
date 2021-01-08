/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.core.impl;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ext.emf.EReferencePredicate;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DocumentationLinkImpl implements DocumentationLink {

	protected ObeoDSMObject source;
	protected String name;
	protected String value;
	protected Annotation annotation;
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.EObjectLink#getType()
	 */
	public String getType() {
		return DocumentationLinkType.DOCUMENTATION_LINK_TYPE;
	}

	/**
	 * @param source
	 * @param name
	 * @param value
	 */
	DocumentationLinkImpl(ObeoDSMObject source) {
		this.source = source;
		name = ""; //$NON-NLS-1$
		value = ""; //$NON-NLS-1$
		annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
		annotation.setTitle(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE + " - "); //$NON-NLS-1$
		if (source.getMetadatas() == null) {
			source.setMetadatas(EnvironmentFactory.eINSTANCE.createMetaDataContainer());
		}
		source.getMetadatas().getMetadatas().add(annotation);
	}

	/**
	 * @param source
	 * @param name
	 * @param value
	 */
	DocumentationLinkImpl(Annotation annotation) {
		if (annotation.eContainer() != null && annotation.eContainer().eContainer() instanceof ObeoDSMObject) {
			this.source = (ObeoDSMObject) annotation.eContainer().eContainer();
			this.name = annotation.getTitle().substring(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE.length() + 3);
			this.value = annotation.getBody();
			this.annotation = annotation;
		} else {
			throw new IllegalStateException("DocumentationLink can be only create for ObeoDSMObject"); //$NON-NLS-1$
		}
	}

	/**
	 * @return the source
	 */
	public ObeoDSMObject getSource() {
		return source;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
		annotation.setTitle(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE + " - " + name);  //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#getValue()
	 */
	public String getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#setValue(java.lang.String)
	 */
	public void setValue(String value) {
		this.value = value;
		annotation.setBody(value);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#delete()
	 */
	public void delete() {
		Session session = SessionManager.INSTANCE.getSession(annotation);
		if (session != null) {
			ModelAccessor vpModelAccessor = session.getModelAccessor();
			vpModelAccessor.eDelete(annotation, session.getSemanticCrossReferencer(), new EReferencePredicate() {
		        public boolean apply(EReference reference) {
		            return DSemanticDecorator.class.isAssignableFrom(reference.getContainerClass());
		        }
		    });
		} else {
			EcoreUtil.delete(annotation);
		}
		name = ""; //$NON-NLS-1$
		value = ""; //$NON-NLS-1$
		annotation = null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#isWorkspaceDocumentation()
	 */
	public boolean isWorkspaceDocumentation() {
		return value != null && value.startsWith(DocumentationLink.WORKSPACE_PREFIX);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#getWebFormattedValue()
	 */
	public String getWebFormattedValue() {
		StringBuilder builder = new StringBuilder();
		if (!value.startsWith("http://")) { //$NON-NLS-1$ //$NON-NLS-2$
			builder.append("http://"); //$NON-NLS-1$
		}
		builder.append(value);
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.doc.core.DocumentationLink#getWorkspaceRelativeValue()
	 */
	public String getWorkspaceRelativeValue() {
		return value.substring(DocumentationLink.WORKSPACE_PREFIX.length());
	}
	
}
