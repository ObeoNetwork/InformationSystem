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
package org.obeonetwork.dsl.database.liquibasegen;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ResourceAccessor;

/**
 * Updates the database with the changes specified in a changelog {@link File} 
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a>
 */
@SuppressWarnings("restriction")
public class LiquibaseUpdater {
	
	private IFile changelog;
	
	/**
	 * 
	 * @param changelog a XML Liquibase changelog {@link File}
	 */
	public LiquibaseUpdater(IFile changelog) {
		this.changelog = changelog;		
	}

	/**
	 * Performs the update of the database with the provided information.
	 * Liquibase automatically determines which Database Driver is required.
	 * 
	 * @param URL a {@link String}
	 * @param username a {@link String}
	 * @param password a {@link String}
	 * @throws LiquibaseException if an error happened during the connexion or the update. 
	 */
	public void update(String URL, String username, String password) throws LiquibaseException {
		ResourceAccessor accessor = new ProjectResourceAccessor(changelog.getProject());
		
		Database database = DatabaseFactory.getInstance().openDatabase(URL, username, password, null, accessor);
		
		try (Liquibase liquibase = new Liquibase(changelog.getLocation().toOSString(), accessor, database)) {
			liquibase.update("");
		}
		
	}
}
