/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.postgres;

import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.obeonetwork.dsl.database.reverse.decoders.impl.PostGresStatementBuilder;
import org.osgi.framework.Version;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PostGreStatementBuilderTest {
	
	@Mock
	Connection connection;
	
	@Mock 
	PreparedStatement statement;
	
	@Mock
	ResultSet resultSet;
	
	@Test
	public void checkGetVersionNumbersAtStart() throws SQLException {
		
		when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
		when(statement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString(Mockito.anyInt())).thenReturn("12.2 (Debian 12.2-1.pgdg100+1)");
		
		PostGresStatementBuilder builder = new PostGresStatementBuilder(connection);
		Version version = builder.getPostgreServerVersion();
		
		Assert.assertEquals(12, version.getMajor());
		Assert.assertEquals(2, version.getMinor());
	}
	
	@Test
	public void checkGetVersionNumbersAtMiddle() throws SQLException {
		
		when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
		when(statement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString(Mockito.anyInt())).thenReturn("(Debian 12.2-1.pgdg100+1)");
		
		PostGresStatementBuilder builder = new PostGresStatementBuilder(connection);
		Version version = builder.getPostgreServerVersion();
		
		Assert.assertEquals(12, version.getMajor());
		Assert.assertEquals(2, version.getMinor());
	}
	
	@Test
	public void checkGetVersionNumbersAtEnd() throws SQLException {
		
		when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
		when(statement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString(Mockito.anyInt())).thenReturn("(Debian.pgdg) 12.2");
		
		PostGresStatementBuilder builder = new PostGresStatementBuilder(connection);
		Version version = builder.getPostgreServerVersion();
		
		Assert.assertEquals(12, version.getMajor());
		Assert.assertEquals(2, version.getMinor());
	}
	
	@Test
	public void checkGetVersionStandard() throws SQLException {
		
		when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
		when(statement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString(Mockito.anyInt())).thenReturn("12.2");
		
		PostGresStatementBuilder builder = new PostGresStatementBuilder(connection);
		Version version = builder.getPostgreServerVersion();
		
		Assert.assertEquals(12, version.getMajor());
		Assert.assertEquals(2, version.getMinor());
	}
}
