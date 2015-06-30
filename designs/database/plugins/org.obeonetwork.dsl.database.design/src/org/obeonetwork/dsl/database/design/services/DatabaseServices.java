package org.obeonetwork.dsl.database.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;

public class DatabaseServices {
	
	/**
	 * Return ForeignKeys from tables.
	 * @param tableContainer
	 * @return foreignKeys
	 */
	public List<ForeignKey> getForeignKeys(TableContainer tableContainer){
		List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
		List<AbstractTable> tables = tableContainer.getTables();
		for (AbstractTable abstractTable : tables) {
			if(abstractTable instanceof Table){
			 foreignKeys.addAll(((Table)abstractTable).getForeignKeys());
			}
		}
		return foreignKeys;
	}
	
	
	public ForeignKey createForeignKey(Table source, Table target) {
		ForeignKey fk = DatabaseFactory.eINSTANCE.createForeignKey();
		source.getForeignKeys().add(fk);
		fk.setTarget(target);
		
		// Initialize with columns
		if (target.getPrimaryKey() != null) {
			for (Column pkColumn : target.getPrimaryKey().getColumns()) {
				Column fkColumn = getOrCreateColumn(source, pkColumn);
				if (pkColumn != null && fkColumn != null) {
					ForeignKeyElement fke = DatabaseFactory.eINSTANCE.createForeignKeyElement();
					fke.setPkColumn(pkColumn);
					fke.setFkColumn(fkColumn);
					fk.getElements().add(fke);
				}
			}
		}
		return fk;
	}
	
	private Column getOrCreateColumn(Table table, Column referenceColumn) {
		
		// Check if a column with the same name already exists
		if (referenceColumn.getName() != null) {
			for (Column column : table.getColumns()) {
				if (referenceColumn.getName().equalsIgnoreCase(column.getName())) {
					return column;
				}
			}
		}
		
			// No column found, we have to create a new one
		Column newColumn = DatabaseFactory.eINSTANCE.createColumn();
		table.getColumns().add(newColumn);
		newColumn.setName(referenceColumn.getName());
		newColumn.setType(EcoreUtil.copy(referenceColumn.getType()));
		return newColumn;
	}
	
	/**
	 * Retrieve all non referenced external tables excluding those already displayed on the diagram
	 * @param context the Table Container
	 * @param diagram DSemanticDiagram diagram used to check for already displayed tables
	 * @return List of tables
	 */
	public List<Table> allSelectableExternalTables (TableContainer context, DSemanticDiagram diagram){
		// Retrieve all non Referenced External Tables
				List<Table> allNonReferencedExternalTables = allNonReferencedExternalTables(context);
				List<Table> tablesInDiagram = new ArrayList<Table>();
				// Retrieve all AbstracteDNode contained in diagram.
				List<EObject> allDNodes = EcoreServices.eAllContents(diagram, AbstractDNode.class);
				for (EObject node : allDNodes){
					// Retrieve all tables contained in AbstractDNode
					if (((AbstractDNode)node).getTarget() instanceof Table){				
						tablesInDiagram.add((Table)((AbstractDNode)node).getTarget());
					}
				}
				// Remove all tables contained in AbstractDNode present in allNonReferencedExternalTables
				allNonReferencedExternalTables.removeAll(tablesInDiagram);
				return allNonReferencedExternalTables;
	}

	/**
	 * Retrieve all Non referenced External Tables.
	 * @param context the Table Container 
	 * @return list of Tables
	 */
	public List<Table> allNonReferencedExternalTables(TableContainer context) {
		// Retrieve all external Tables
		List<Table> allExternalTables = allExternalTables(context);
		// Remove all referenced Tables present in all Externals Tables
		allExternalTables.removeAll(allReferencedTables(context));
		return allExternalTables;
	}
	
	/**
	 * Retrieve all referenced External Tables.
	 * @param context the Table Container 
	 * @return list of Tables
	 */
	public List<Table> allReferencedExternalTables(TableContainer context) {
		// Retrieve all external Tables
		List<Table> allReferencedTables = allReferencedTables(context);
		// Remove all referenced Tables present in all Externals Tables
		allReferencedTables.removeAll(context.getTables());
		return allReferencedTables;
	}

	/**
	 * Retrieve all External Tables.
	 * @param context the Table Container 
	 * @return list of Tables
	 */
	public List<Table> allExternalTables(TableContainer context) {
		// Retrieve all Tables
		List<Table> allTables = allTables(context);
		// Remove all tables from DataBase present in all tables
		allTables.removeAll(context.getTables());
		return allTables;
	}

	/**
	 * Retrieve all referenced Tables.
	 * @param context the Table Container 
	 * @return list of Tables
	 */
	public List<Table> allReferencedTables(TableContainer context) {
		// Retrieve all tables
		List<AbstractTable> abstractTables = context.getTables();
		List<Table> tables = new ArrayList<Table>();
		List<Table> tablesFKtarget = new ArrayList<Table>();
		// Retrieve all tables instance of Table
		for (AbstractTable abstractTable : abstractTables) {
			if (abstractTable instanceof Table) {
				tables.add((Table) abstractTable);
			}
		}
		// Retrieve all foreigns keys for the tables
		for (Table table : tables) {
			for (ForeignKey fk : table.getForeignKeys()) {
				if (!tablesFKtarget.contains(fk.getTarget())) {
					// retrieve all table from target of foreigns keys
					tablesFKtarget.add(fk.getTarget());
				}
			}
		}
		
		Set<Table> allReferencedTables = new HashSet<Table>();		
		// Remove duplicates
		allReferencedTables.addAll(tablesFKtarget);
		return new ArrayList<Table>(allReferencedTables);

	}

	/**
	 * Retrieve all Tables.
	 * @param context the Table Container 
	 * @return list of Tables
	 */
	public List<Table> allTables(TableContainer context) {
		EcoreServices ecoreServices = new EcoreServices();
		// Retrieve all roots from context
		Collection<EObject> allRoots = ecoreServices.allRoots(context);
		List<Table> tables = new ArrayList<Table>();
		// Retrieve all Tables contained in all roots
		for (EObject object : allRoots) {
			List<Table> allContainedTables = new ArrayList<Table>();
			for (EObject obj : EcoreServices.eAllContents(object, Table.class)) {
				allContainedTables.add((Table) obj);
			}
			tables.addAll(allContainedTables);
		}
		return tables;
	}
}
