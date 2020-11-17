/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders;

import java.sql.Connection;

import org.obeonetwork.dsl.database.DataBase;


public interface DataBaseBuilder {
	
	void buildTables();
	
	void buildForeignKeys();
	
	void post();
	
	DataBase getDataBase();
	
	Connection getConnection();
	
}
