/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.update;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseUpdater;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * Abstract test class for {@link Parameterized} tests
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
 *         
 */
public abstract class AbstractLiquibaseUpdateTest {
	protected String url;
	protected String username;
	protected String password;
	protected Database database;
	protected Liquibase liquibase;
	protected String changelog;
	protected String fileName;
	protected IProject project;

	public AbstractLiquibaseUpdateTest(String fileName) {
		this.fileName = fileName;
		
	}

	@Parameters
	public static List<String> parameters() {
		return Arrays.asList(	"update/01-create-table/run.changelog.xml",
								"update/02-primary-key/run.changelog.xml",
								"update/03-foreign-key/run.changelog.xml",
								"update/04-sequence/run.changelog.xml",
								"update/05-index/run.changelog.xml");
	}
	
	@Before
	public void clearDatabase() throws Exception {		
		database = DatabaseFactory.getInstance().openDatabase(url, username, password, null, new ClassLoaderResourceAccessor());
		liquibase = new Liquibase(changelog, new ClassLoaderResourceAccessor(), database);
		try {
			liquibase.dropAll();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testApplyChangelog() throws CoreException {
		// https://wiki.eclipse.org/FAQ_How_do_I_open_an_editor_on_a_file_outside_the_workspace%3F
		File file = new java.io.File(fileName);
		Assert.assertTrue(file.exists());
		
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		project = ws.getRoot().getProject("External Files");
		if (!project.exists())
		    project.create(null);
		if (!project.isOpen())
		    project.open(null);
		
		IPath location = new Path(file.getAbsolutePath());
		
		IFile ecfile = project.getFile(location.lastSegment());
		ecfile.createLink(location, IResource.NONE, null);
		
		project.accept(new IResourceVisitor() {
			
			@Override
			public boolean visit(IResource resource) throws CoreException {
				System.out.println(resource.getLocationURI().toString());
				return true;
			}
		});
		
		try {
			new LiquibaseUpdater(ecfile).update(url, username, password);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	@After
	public void tearDown() throws CoreException {
		if (project.exists() && project.isOpen()) {
			project.delete(true, new NullProgressMonitor());
		}
	}
	
}
