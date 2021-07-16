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
	private Liquibase liquibase;
	
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
	 * @param URL a {@link StringIndexOutOfBoundsException}
	 * @param username a {@link StringIndexOutOfBoundsException}
	 * @param password a {@link String}
	 * @throws LiquibaseException if an error happened during the connexion or the update. 
	 */
	public void update(String URL, String username, String password) throws LiquibaseException {
		ResourceAccessor accessor = new ProjectResourceAccessor(changelog.getProject());
		
		Database database;
		database = DatabaseFactory.getInstance().openDatabase(URL, username, password, null, accessor);
		liquibase = new Liquibase(changelog.getLocation().toOSString(), accessor, database);
		try {
			liquibase.update("");
		} catch (LiquibaseException exception) {
			// liquibase needs to be closed in case of error.
			liquibase.close();
			throw exception;
		}
	}
}
