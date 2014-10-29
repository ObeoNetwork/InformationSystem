package org.obeonetwork.dsl.entity.migration;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

public class EntityResourceHandler extends BasicResourceHandler {

	@Override
	public void preLoad(XMLResource resource, InputStream inputStream,
			Map<?, ?> options) {
		// TODO Auto-generated method stub
		super.preLoad(resource, inputStream, options);
	}
	
	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		super.postLoad(resource, inputStream, options);
		processUnknownData(resource);
	}

	/**
	 * handle unknown data in Resource.
	 * 
	 * @param resource
	 *            the resource to check
	 */
	protected void processUnknownData(final XMLResource resource) {
		final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
		for (final EObject key : extMap.keySet()) {
			final AnyType value = extMap.get(key);
			handleUnknownData(key, value);
		}
	}

	private void handleUnknownData(final EObject eObj, final AnyType unknownData) {
		handleUnknownFeatures(eObj, unknownData.getMixed());
		handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
	}

	private void handleUnknownFeatures(final EObject owner, final FeatureMap featureMap) {
		final Iterator<FeatureMap.Entry> iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		// TODO return true if the feature should be deleted
		
//		if ("useless".equals(eStructuralFeature.getName()))
//			return true;
		return false;
	}
}
