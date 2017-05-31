package org.obeonetwork.dsl.database.compare.tests.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class EMFUtils {

	/**
	 * 
	 * @param type
	 * @param container
	 * @return all instances of {@code type} contained directly or indirectly by
	 *         {@code container}.
	 */
	public static Collection<EObject> getAllContentsOfType(EClass type, EObject container) {
		Collection<EObject> instances = new ArrayList<>();
		Iterator<EObject> iterator = container.eAllContents();
		while (iterator.hasNext()) {
			EObject eo = iterator.next();
			if (type.isInstance(eo)) {
				instances.add(eo);
			}
		}
		return instances;
	}
}
