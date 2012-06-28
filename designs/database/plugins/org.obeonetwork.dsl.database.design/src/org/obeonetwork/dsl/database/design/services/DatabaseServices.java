package org.obeonetwork.dsl.database.design.services;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Table;

public class DatabaseServices {
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
}
