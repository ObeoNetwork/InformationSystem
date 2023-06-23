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
package org.obeonetwork.database.transfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Reference;

import org.obeonetwork.database.Activator;
import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldType;
import org.obeonetwork.database.transfo.util.DeleteUtils;
import org.obeonetwork.database.transfo.util.ModelUtils;

abstract public class AbstractTransformation implements Transformation {

	private ScaffoldInfo scaffoldInfo;
	private ScaffoldType scaffoldType;
	private ResourceSet resourceSet = null;
	private boolean saveFinalResource = true;
	private Resource result;
	private Map<String, EObject> additionalResourcesMap = null;
	private Map<EObject, EObject> inputTraceabilityMap = new HashMap<EObject, EObject>();
	private Map<EObject, EObject> outputTraceabilityMap = new HashMap<EObject, EObject>();
	private List<EObject> objectsToBeKept = new ArrayList<EObject>();
	private Properties typePropertiesFile;
	
	public boolean transform(URI scaffoldInfoURI, ScaffoldType scaffoldType) {
		EObject scaffoldInfo = getResourceSet().getEObject(scaffoldInfoURI, true);
		if (scaffoldInfo instanceof ScaffoldInfo) {
			return transform((ScaffoldInfo)scaffoldInfo, scaffoldType);
		}
		return false;
	}
	
	public boolean transform(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType) {
		boolean success = doTransformationFirstStep((ScaffoldInfo)scaffoldInfo, scaffoldType);
		if (success) {
			doTransformationFinalStep();
		}
		return success;
	}
	
	public boolean doTransformationFirstStep(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType) {
		this.scaffoldInfo = scaffoldInfo;
		this.scaffoldType = scaffoldType;
		EObject sourceObject = scaffoldInfo.getStartingObjectForTransformation(scaffoldType);
		EObject targetObject = scaffoldInfo.getEndingObjectForTransformation(scaffoldType);
		Iterable<EObject> references = scaffoldInfo.getAdditionalObjectsForTransformation(scaffoldType);
		Map<EObject, EObject> traceabilityMap = scaffoldInfo.getTraceabilityMap(scaffoldType).map();
		
		return doTransformationFirstStep(sourceObject, targetObject, references, traceabilityMap);
	}
	
	private boolean doTransformationFirstStep(EObject sourceObject, EObject targetObject, Iterable<EObject> references, Map<EObject, EObject> traceabilityMap) {
		if (sourceObject != null && targetObject != null) {
			if (prepare(sourceObject, targetObject)) {
				inputTraceabilityMap = traceabilityMap; 
				additionalResourcesMap = ModelUtils.loadReferences(getResourceSet(), references);
				result = execute();
				removeOldObjects();
				saveNewTraceabilityInfo();
				return true;
			}
		}
		return false;
	}
	
	public void doTransformationFinalStep() {
//		if (saveFinalResource) {
//			ModelUtils.saveResource(getResult());
//			ModelUtils.saveResource(scaffoldInfo.eResource());
//		}
//		ModelUtils.unloadResources(getResourceSet());
	}
	
	private void removeOldObjects() {
		// Traverse the whole target resource to remove objects which have not been reused or created by this transformation
		Collection<EObject> objectsToKeep = new ArrayList<EObject>();
		objectsToKeep.addAll(outputTraceabilityMap.values());
		objectsToKeep.addAll(objectsToBeKept);
		
		Collection<EObject> objectsToBeDeleted = new ArrayList<EObject>();
		for(Iterator<EObject> it = getResult().getAllContents(); it.hasNext(); ) {
			EObject object = it.next();
			if (object instanceof Entity
					|| object instanceof Attribute
					|| object instanceof Reference
					|| object instanceof Table
					|| object instanceof Column
					|| object instanceof ForeignKey
					|| object instanceof Index
					|| object instanceof Constraint) {
				if (!objectsToKeep.contains(object)) {
					objectsToBeDeleted.add(object);
				}
			}
		}
		// Remove objects
		Session session = SessionManager.INSTANCE.getSession(scaffoldInfo);
		for (EObject objectToBeDeleted : objectsToBeDeleted) {
			deleteObject(objectToBeDeleted, session);
		}
	}
	
	private void deleteObject(EObject objectToBeDeleted, Session session) {
		DeleteUtils.delete(objectToBeDeleted, session);
	}
	
	private void saveNewTraceabilityInfo() {
		EMap<EObject, EObject> infos = new BasicEMap<EObject, EObject>();
		for (Entry<EObject, EObject> entry : outputTraceabilityMap.entrySet()) {
			infos.put(entry.getKey(), entry.getValue());
		}
		scaffoldInfo.replaceTraceabilityInfos(scaffoldType, infos);
	}

	protected abstract boolean prepare(EObject sourceObject, EObject targetObject);
	
	protected abstract Resource execute();
	
	protected <T> T getFromInputTraceabilityMap(EObject from, EClass expectedClass) {
		return getFromTraceabilityMap(from, expectedClass, inputTraceabilityMap);
	}
	
	protected <T> T getFromOutputTraceabilityMap(EObject from, EClass expectedClass) {
		return getFromTraceabilityMap(from, expectedClass, outputTraceabilityMap);
	}
	
	protected Map<EObject, EObject> getOutputTraceabilityMap() {
		return outputTraceabilityMap;
	}

	protected void setOutputTraceabilityMap(Map<EObject, EObject> outputTraceabilityMap) {
		this.outputTraceabilityMap = outputTraceabilityMap;
	}

	@SuppressWarnings("unchecked")
	private <T> T getFromTraceabilityMap(EObject from, EClass expectedClass, Map<EObject, EObject> traceabilityMap) {
		EObject object = traceabilityMap.get(from);
		if (expectedClass.isInstance(object)) {
			return (T)object;
		}
		return null;
	} 
	
	protected void addToOutputTraceability(EObject key, EObject value) {
		outputTraceabilityMap.put(key, value);
	}
	
	protected void addToObjectsToBeKept(EObject object) {
		objectsToBeKept.add(object);
	}
	
	public List<EObject> getObjectsToBeKept() {
		return objectsToBeKept;
	}
	
	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = ModelUtils.createResourceSet();
		}
		return resourceSet;
	}
	
	public Resource getResult() {
		return result;
	}
	
	public void setSaveFinalResource(boolean saveFinalResource) {
		this.saveFinalResource = saveFinalResource;
	}
	
	public Map<String, EObject> getAdditionalResourcesMap() {
		return additionalResourcesMap;
	}
	
	protected abstract String getTypePropertiesFileName();
	
	protected Properties getTypeProperties() {
		if (typePropertiesFile == null) {
			typePropertiesFile = new Properties();
			try {
				typePropertiesFile.load(getClass().getResourceAsStream(getTypePropertiesFileName()));
			} catch (IOException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
			}
		}
		return typePropertiesFile;
	}
	
}
