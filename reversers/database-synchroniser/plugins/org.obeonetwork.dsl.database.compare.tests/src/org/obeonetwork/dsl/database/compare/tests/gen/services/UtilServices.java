/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.tests.gen.services;

import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.provider.CompareItemProviderAdapterFactory;
import org.eclipse.emf.compare.provider.spec.CompareItemProviderAdapterFactorySpec;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;
import org.obeonetwork.dsl.database.dbevolution.provider.DbevolutionItemProviderAdapterFactory;
import org.obeonetwork.dsl.database.provider.DatabaseItemProviderAdapterFactory;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

public class UtilServices {
	
	DiffContentService service = new DiffContentService();
	
	DbevolutionItemProviderAdapterFactory dbEvolution = new DbevolutionItemProviderAdapterFactory();
	CompareItemProviderAdapterFactory compare = new CompareItemProviderAdapterFactorySpec();
	DatabaseItemProviderAdapterFactory database = new DatabaseItemProviderAdapterFactory();
	TypesLibraryItemProviderAdapterFactory library = new TypesLibraryItemProviderAdapterFactory();
	
	public String getLabel(EObject object) {
		
		ComposedAdapterFactory composeable = new ComposedAdapterFactory();
		composeable.addAdapterFactory(dbEvolution);
		composeable.addAdapterFactory(compare);
		composeable.addAdapterFactory(database);
		composeable.addAdapterFactory(library);
		
		IItemLabelProvider provider = (IItemLabelProvider) composeable.adapt(object, IItemLabelProvider.class);
		if (provider != null) {
			return provider.getText(object);
		}
		return "";
	}
	
	public List<Diff> getSubDifferences(Diff diff) {
		return service.getSubDiffs(diff, diff.getMatch().getComparison());
	}

}
