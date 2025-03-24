/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.project.lifecycle;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.tools.internal.views.common.modelingproject.OpenRepresentationsFileJob;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.obeonetwork.utils.common.StreamUtils;

@SuppressWarnings("restriction")
public class ImporterUtil {
	
	public static Session getSession(ModelingProject project) {
		Session session = project.getSession();
		if (session == null) {
			final Option<URI> optionalMainSessionFileURI = project.getMainRepresentationsFileURI(new NullProgressMonitor(), false, false);
			if (optionalMainSessionFileURI.some()) {
				URI representationsFileURI = optionalMainSessionFileURI.get();
				OpenRepresentationsFileJob job = new OpenRepresentationsFileJob(representationsFileURI);
				job = new OpenRepresentationsFileJob(representationsFileURI);
				if(job.run(new NullProgressMonitor()) == Status.OK_STATUS) {
					session = SessionManager.INSTANCE.getSession(representationsFileURI, new NullProgressMonitor());
				}
			}
		}
		return session;
	}
	
	public static boolean isOfAnyClass(EObject object, Collection<EClass> eClasses) {
		for (EClass eClass : eClasses) {
			if (eClass.isInstance(object)) {
				return true;
			}
		}
		return false;
	}
	
	public static Collection<DRepresentationDescriptor> getRelatedRepresentationDescriptors(Session session, Collection<EObject> semanticElements) {
		Collection<DRepresentationDescriptor> representationDescriptors = new ArrayList<DRepresentationDescriptor>();
		
		for (EObject semanticElement : semanticElements) {
			representationDescriptors.addAll(DialectManager.INSTANCE.getRepresentationDescriptors(semanticElement, session));
		}
		return representationDescriptors;
	}
	
	public static Collection<ReferenceData> getReferencingElements(Collection<EObject> elements, Session session) {
		Collection<ReferenceData> referencesData = new ArrayList<ReferenceData>();
		
		Collection<EObject> allElements = getAllElementsWithChildren(elements);
		
		for (EObject element : allElements) {
			Collection<Setting> inverseReferences = session.getSemanticCrossReferencer().getInverseReferences(element, true);
			for (Setting setting : inverseReferences) {
				referencesData.add(new ReferenceData(element, setting));
			}		
		}
		return referencesData;
	}
	
	
	public static Collection<EObject> getAllElementsWithChildren(Collection<EObject> roots) {
		List<EObject> children = roots.stream().flatMap(root -> StreamUtils.asStream(root.eAllContents())).collect(toList());
		children.addAll(roots);
		return children;
	}
	
	public static <T extends EObject> List<T> getAllContentsOfType(EObject root, Class<T> type) {
		return StreamUtils.asStream(root.eAllContents()).filter(type::isInstance).map(type::cast).collect(toList());
	}
	
}
