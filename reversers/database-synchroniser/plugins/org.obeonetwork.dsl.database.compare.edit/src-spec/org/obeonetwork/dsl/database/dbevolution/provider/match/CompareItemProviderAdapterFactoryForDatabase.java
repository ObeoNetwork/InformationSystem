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
package org.obeonetwork.dsl.database.dbevolution.provider.match;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.provider.spec.CompareItemProviderAdapterFactorySpec;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.dbevolution.provider.DatabaseChangeSetItemProvider;
import org.obeonetwork.dsl.database.dbevolution.util.DbevolutionSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support DB evolution compare merge viewer,
 * on matches.
 * 
 * @author Obeo
 */
public class CompareItemProviderAdapterFactoryForDatabase extends CompareItemProviderAdapterFactorySpec {

	private DatabaseChangeSetItemProvider databaseItemProvider = null;
	
	/** The Specific switch to create adapters for match on database. */
	// CHECKSTYLE:OFF
	protected DbevolutionSwitch<Adapter> modelSwitchSpec = new DbevolutionSwitch<Adapter>() {
		// CHECKSTYLE:ON

		@Override
		public Adapter defaultCase(EObject object) {
			if (object instanceof Match && ((Match)object).getLeft() instanceof DataBase) {
				if (databaseItemProvider == null) {
					databaseItemProvider = new DatabaseChangeSetItemProvider(
							CompareItemProviderAdapterFactoryForDatabase.this);
				}
				return databaseItemProvider;
			}

			// delegate to the default notational switch
			return modelSwitch.doSwitch(object);
		}
	};

	/**
	 * Constructor calling super {@link #CompareItemProviderAdapterFactory()}.
	 */
	public CompareItemProviderAdapterFactoryForDatabase() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.notation.util.NotationAdapterFactory#createAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitchSpec.doSwitch((EObject)target);
	}
}
