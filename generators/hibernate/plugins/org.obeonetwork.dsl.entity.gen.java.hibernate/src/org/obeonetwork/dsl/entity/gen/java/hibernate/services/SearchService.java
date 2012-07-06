package org.obeonetwork.dsl.entity.gen.java.hibernate.services;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import org.obeonetwork.dsl.entity.Entity;

public class SearchService {
	
	public static String entitySuffix (Entity reference, EObject root) {
		
		TreeIterator<EObject> iterator = root.eAllContents();
		boolean found = false;
		int count = 0;
		while (iterator.hasNext() && !found) {
			Object o = iterator.next();
			if (o instanceof Entity) {
				Entity entity = (Entity) o;
				if (entity != reference) {
					if (entity.getName().equals(reference.getName())){
						count ++;
					}
				} else {
					found = true;
				}
			}
		}
		if (count > 0) {
			return String.valueOf(count);
		}
		return "";
	}

}
