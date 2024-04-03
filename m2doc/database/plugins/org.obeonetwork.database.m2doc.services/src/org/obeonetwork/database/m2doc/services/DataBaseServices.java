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
package org.obeonetwork.database.m2doc.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.design.IDatabaseViewpointConstants;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.m2doc.element.MImage;
import org.obeonetwork.m2doc.sirius.services.M2DocSiriusServices;

/**
 * AQL Services for M2Doc.
 * 
 * @author Obeo
 */
public class DataBaseServices {

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.typeLibraryName()}",
            value = "Returns the name of the used library or the empty string if it's not known.",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.typeLibraryName()}", 
                            result = "the name of the used library or the empty string if it's not known.")
            }
        )
    // @formatter:on    
    public String typeLibraryName(DataBase db) {
        List<TypesLibrary> libs = db.getUsedLibraries();
        if (libs.size() > 0 && libs.get(0) instanceof NativeTypesLibrary) {
            return ((NativeTypesLibrary) libs.get(0)).getName();
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.allTables()}",
            value = "Returns all the table contained and referenced by the database (including the table of external databases referenced through foreign keys).",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.allTables()}", 
                            result = "the set of all tables contained and referenced by the database.")
            }
        )
    // @formatter:on    
    public Set<Table> allTables(DataBase database) {
        TableCollector collector = new TableCollector();
        collector.doSwitch(database);
        return collector.tables;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.allViews()}",
            value = "Returns all the views contained and referenced by the database (including the table of external databases referenced through foreign keys).",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.allViews()}", 
                            result = "the set of all views contained and referenced by the database.")
            }
        )
    // @formatter:on    
    public Set<View> allViews(DataBase database) {
        ViewCollector collector = new ViewCollector();
        collector.doSwitch(database);
        return collector.tables;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.allSequences()}",
            value = "Returns all the sequences contained and referenced by the database (including the sequences associated to tables of external databases referenced through foreign keys).",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.allSequences()}", 
                            result = "the set of all sequences contained and referenced by the database.")
            }
        )
    // @formatter:on    
    public Set<Sequence> allSequences(DataBase database) {
        Set<Sequence> result = new HashSet<Sequence>();
        result.addAll(database.getSequences());
        Set<Table> tables = allTables(database);
        for (Table table : tables) {
            if (table.eContainer() instanceof TableContainer) {
                result.addAll(((TableContainer) table.eContainer()).getSequences());
            }
        }
        return result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.localTables()}",
            value = "Returns the list of local tables including tables in schemas.",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.localTables()}", 
                            result = "the list of local tables including tables in schemas.")
            }
        )
    // @formatter:on    
    public List<Table> localTables(DataBase db) {
        List<Table> result = new ArrayList<Table>();
        for (AbstractTable table : db.getTables()) {
            if (table instanceof Table) {
                result.add((Table) table);
            }
        }
        for (Schema schema : db.getSchemas()) {
            for (AbstractTable table : schema.getTables()) {
                if (table instanceof Table) {
                    result.add((Table) table);
                }
            }
        }
        return result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.localViews()}",
            value = "Returns the list of local tables including tables in schemas.",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.localViews()}", 
                            result = "the list of local tables.")
            }
        )
    // @formatter:on    
    public List<View> localViews(DataBase db) {
        List<View> result = new ArrayList<View>();
        for (AbstractTable table : db.getTables()) {
            if (table instanceof View) {
                result.add((View) table);
            }
        }
        for (Schema schema : db.getSchemas()) {
            for (AbstractTable table : schema.getTables()) {
                if (table instanceof View) {
                    result.add((View) table);
                }
            }
        }
        return result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myDataBase.localSequences()}",
            value = "Returns the list of local sequences including sequences in schemas.",
            examples = {
                    @Example(
                            expression = "{m:myDataBase.localSequences()}", 
                            result = "the list of local sequences.")
            }
        )
    // @formatter:on    
    public List<Sequence> localSequences(DataBase db) {
        List<Sequence> result = new ArrayList<Sequence>();
        for (Sequence seq : db.getSequences()) {
            result.add(seq);
        }
        for (Schema schema : db.getSchemas()) {
            for (Sequence seq : schema.getSequences()) {
                result.add(seq);
            }
        }
        return result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:database.asDatabaseImage()}",
            value = "Returns a collection of images representing the target Database Database Diagrams.",
            examples = {
                    @Example(
                            expression = "{m:database.asDatabaseImage()}", 
                            result = "A sequence of images.")
            }
        )
    // @formatter:on    
    public List<MImage> asDatabaseImage(DataBase database) throws SizeTooLargeException, IOException {
        Session session = new EObjectQuery(database).getSession();
        List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(database,
                IDatabaseViewpointConstants.DATABASE_DIAGRAM_ID);

        return images;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:database.asDatabaseImage(width)}",
            value = "Returns a collection of images representing the target Database Database Diagrams scaled to the given width keeping the initial image ratio.",
            examples = {
                    @Example(
                            expression = "{m:database.asDatabaseImage(400)}", 
                            result = "A sequence of images.")
            }
        )
    // @formatter:on    
    public List<MImage> asDatabaseImage(DataBase database, int width) throws SizeTooLargeException, IOException {
        Session session = new EObjectQuery(database).getSession();
        List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(database,
                IDatabaseViewpointConstants.DATABASE_DIAGRAM_ID);
        images.forEach(i -> i.conserveRatio());
        images.forEach(i -> i.setWidth(width));

        return images;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:database.asDatabaseImage(width, height)}",
            value = "Returns a collection of images representing the target Database Database Diagrams scaled to the given width and heigth.",
            examples = {
                    @Example(
                            expression = "{m:database.asDatabaseImage(400, 300)}", 
                            result = "A sequence of images.")
            }
        )
    // @formatter:on    
    public List<MImage> asDatabaseImage(DataBase database, int width, int height)
            throws SizeTooLargeException, IOException {
        Session session = new EObjectQuery(database).getSession();
        List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(database,
                IDatabaseViewpointConstants.DATABASE_DIAGRAM_ID);
        images.forEach(i -> i.setHeight(height));
        images.forEach(i -> i.setWidth(width));

        return images;
    }

    /**
     * Switch class used to collect the tables of a data base.
     * 
     * @author Obeo
     */
    private static class TableCollector extends DatabaseSwitch<String> {
        /**
         * The set used to collect tables.
         */
        private Set<Table> tables = new HashSet<Table>();

        @Override
        public String caseDataBase(DataBase object) {
            for (AbstractTable table : object.getTables()) {
                doSwitch(table);
            }
            for (Schema schema : object.getSchemas()) {
                doSwitch(schema);
            }
            return "";
        }

        @Override
        public String caseTable(Table object) {
            // SAFRAN-832 : check if the table has already been handled
            // this is to avoid StackOverflowError because of recursive FK
            if (!tables.contains(object)) {
                tables.add(object);
                for (ForeignKey key : object.getForeignKeys()) {
                    doSwitch(key.getTarget());
                }
            }
            return "";
        }

        @Override
        public String caseSchema(Schema object) {
            for (AbstractTable table : object.getTables()) {
                doSwitch(table);
            }
            return "";
        }

    }

    /**
     * Switch class used to collect the tables of a data base.
     * 
     * @author Obeo
     */
    private static class ViewCollector extends DatabaseSwitch<String> {
        /**
         * The set used to collect tables.
         */
        private Set<View> tables = new HashSet<View>();

        @Override
        public String caseDataBase(DataBase object) {
            for (AbstractTable table : object.getTables()) {
                doSwitch(table);
            }
            for (Schema schema : object.getSchemas()) {
                doSwitch(schema);
            }
            return "";
        }

        @Override
        public String caseView(View object) {
            tables.add(object);
            return "";
        }

        @Override
        public String caseSchema(Schema object) {
            for (AbstractTable table : object.getTables()) {
                doSwitch(table);
            }
            return "";
        }

    }

}
