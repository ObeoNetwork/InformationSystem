package org.obeonetwork.dsl.soa.gen.contracts.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.System;
/**
 * A service that helps building or retrieving namespaces and prefix associated
 * to Service or Category domain objects.
 * @author Laurent Broudoux
 */
public class NamespaceServices {

	public static final String NAMESPACE_PREFIX_KEY = "nsPrefix";

	private static Integer namespaceCounter = 1;

	private static Map<String, String> namespacePrefix = new HashMap<String, String>();

	/** The constructor. */
	private NamespaceServices() {
		// prevent instantiation.
	}

	public static void resetNamespaces() {
		namespaceCounter = 1;
		namespacePrefix.clear();
	}

	public static String getTargetNamespace(Service service) {
		StringBuilder result = new StringBuilder(getNamespacePrefix());
		// First add system name if any.
		EObject container = service.eContainer();
		if (container instanceof System) {
			System system = (System) container;
			result.append('/').append(system.getName());
		}
		// Then add service name.
		result.append('/').append(service.getName());
		return result.toString();
	}

	public static String getTargetNamespace(Category category) {
		StringBuilder result = new StringBuilder(getNamespacePrefix());
		StringBuilder categoryTree = new StringBuilder();
		// First add system name if any.
		EObject container = category.eContainer();
		if (container instanceof System) {
			System system = (System) container;
			result.append('/').append(system.getName());
		} else if (container instanceof Category) {
			Category parent = (Category) container;
			categoryTree.insert(0, parent.getName()).insert(0, '/');
		}
		// Then add category name.
		result.append(categoryTree).append('/').append(category.getName());
		return result.toString();
	}

	public static String getNamespacePrefix(Category category) {
		String nsPrefix = namespacePrefix.get(category.getName());
		if (nsPrefix == null) {
			synchronized (namespaceCounter) {
				nsPrefix = "ns" + namespaceCounter;
				namespacePrefix.put(category.getName(), nsPrefix);
				namespaceCounter++;
			}
		}
		return nsPrefix;
	}

	public static String getNamespacePrefix() {
		return java.lang.System.getProperty(NAMESPACE_PREFIX_KEY,
				"http://www.github.com");
	}
}
