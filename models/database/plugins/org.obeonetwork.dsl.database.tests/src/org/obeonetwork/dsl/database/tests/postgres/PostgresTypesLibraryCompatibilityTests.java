/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.postgres;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

/**
 * Reads saved models through the URI mappings supplied by Eclipse/EMF.
 * Historical model URIs and fragments must remain fixed when mappings change.
 */
public class PostgresTypesLibraryCompatibilityTests {

    private static final String RESOURCE_PATH =
            "org.obeonetwork.dsl.database.tests/resources/postgres/uri-compatibility/";
    private static final String LIBRARY_ID = "_Zj69UBEnEeGTa_JlZYBw1A";
    private static final String[] TYPE_NAMES = { "INTEGER", "VARCHAR", "BIGSERIAL", "SMALLSERIAL" };
    private static final String[] COMMON_TYPE_IDS = {
            "_EfcOQG5FEeS0qO0NdvQESw", "_hn9LAGTNEeSmq67_vSAzgg",
            "_Wi1LUCnFEfG9cPNti5l34g", "_WCKuQCnFEfG9cPNti5l34g" };

    @Test
    public void readsPostgres9Model() {
        assertModelResolves("postgres-9.database", "Postgres-9", new String[] {
                "_EfcOQG5FEeS0qO0NdvQESw", "_hn9LAGTNEeSmq67_vSAzgg",
                "_55dXICnEEfG9cPNti5l34g", "_xzRTICnEEfG9cPNti5l34g" });
    }

    @Test
    public void readsPostgres95To13Model() {
        assertModelResolves("postgres-9.5-13.database", "Postgres", COMMON_TYPE_IDS);
    }

    @Test
    public void readsPostgresModel() {
        assertModelResolves("postgres.database", "Postgres", COMMON_TYPE_IDS);
    }

    private void assertModelResolves(String fileName, String libraryName, String[] typeIds) {
        ResourceSet resourceSet = new ResourceSetImpl();
        URI modelURI = URI.createPlatformPluginURI(RESOURCE_PATH + fileName, true);
        Resource modelResource = resourceSet.getResource(modelURI, true);
        EcoreUtil.resolveAll(resourceSet);

        var unresolved = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
        assertTrue("Unresolved references in " + modelURI + ": " + unresolved, unresolved.isEmpty());
        for (Resource resource : resourceSet.getResources()) {
            assertTrue("Errors in " + resource.getURI() + ": " + resource.getErrors(),
                    resource.getErrors().isEmpty());
            assertTrue("Warnings in " + resource.getURI() + ": " + resource.getWarnings(),
                    resource.getWarnings().isEmpty());
        }

        assertEquals(1, modelResource.getContents().size());
        DataBase database = (DataBase) modelResource.getContents().get(0);
        assertEquals(1, database.getUsedLibraries().size());
        NativeTypesLibrary library = (NativeTypesLibrary) database.getUsedLibraries().get(0);
        assertFalse(library.eIsProxy());
        assertTrue("Library is not recognized as PostgreSQL", TypesLibraryUtil.isPostgresMPD(library));
        assertEquals(libraryName, library.getName());
        assertEquals(LIBRARY_ID, EcoreUtil.getURI(library).fragment());

        assertEquals(1, database.getSchemas().size());
        assertEquals(1, database.getSchemas().get(0).getTables().size());
        Table table = (Table) database.getSchemas().get(0).getTables().get(0);
        assertEquals(TYPE_NAMES.length, table.getColumns().size());
        for (int i = 0; i < TYPE_NAMES.length; i++) {
            Column column = table.getColumns().get(i);
            assertTrue(column.getType() instanceof TypeInstance);
            NativeType type = ((TypeInstance) column.getType()).getNativeType();
            assertNotNull("Missing type for " + column.getName(), type);
            assertFalse("Unresolved type for " + column.getName(), type.eIsProxy());
            assertEquals(TYPE_NAMES[i], type.getName());
            assertEquals(typeIds[i], EcoreUtil.getURI(type).fragment());
            assertTrue("Type outside the declared library", library.getNativeTypes().contains(type));
            assertSame(library.eResource(), type.eResource());
        }
    }
}
