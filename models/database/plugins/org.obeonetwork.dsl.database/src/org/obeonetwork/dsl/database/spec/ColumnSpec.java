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
package org.obeonetwork.dsl.database.spec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.impl.ColumnImpl;

public class ColumnSpec extends ColumnImpl {
	
	@Override
	public EList<Index> getIndexes() {

		List<Index> indexes = new ArrayList<Index>();
		for (IndexElement indexElement : getIndexElements()) {
			if (!indexes.contains(indexElement.eContainer())) {
				indexes.add((Index)indexElement.eContainer());
			}
		}
		return new EcoreEList.UnmodifiableEList<Index>(this,
															DatabasePackage.Literals.COLUMN__INDEXES,
															indexes.size(),
															indexes.toArray());		
	}
	
	@Override
	public EList<ForeignKey> getForeignKeys() {
		List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
		for (ForeignKeyElement fkElement : getForeignKeyElements()) {
			if (!foreignKeys.contains(fkElement.eContainer())) {
				foreignKeys.add((ForeignKey)fkElement.eContainer());
			}
		}
		return new EcoreEList.UnmodifiableEList<ForeignKey>(this,
															DatabasePackage.Literals.COLUMN__FOREIGN_KEYS,
															foreignKeys.size(),
															foreignKeys.toArray());
	}
	
	@Override
	public boolean isInPrimaryKey() {
		return (getPrimaryKey() != null);
	}
	
	@Override
	public boolean isInForeignKey() {
		return !(getForeignKeys().isEmpty());
	}
	
	@Override
	public boolean isUnique() {
		// We have to check if the column is contained within a unique index
				for (Index index : getIndexes()) {
					if (index.isUnique()) {
						return true;
					}
				}
				return false;
	}
	
	@Override
	public void addToPrimaryKey() {
		// Do nothing if the column is already a PK column or if it does not belong to a table
		if (isInPrimaryKey() == false
				&& getOwner() != null
				&& getOwner() instanceof Table) {
			Table table = (Table)getOwner();
			// First, ensure there is a Primary Key defined on this table
			PrimaryKey pk = table.getPrimaryKey();
			if (pk == null) {
				// Create a new PK
				pk = DatabaseFactory.eINSTANCE.createPrimaryKey();
				pk.setName(table.getName() + "_PK");
				table.setPrimaryKey(pk);
			}
			
			// Then attach the column to the primary key
			pk.getColumns().add(this);
		}
	}
	
	@Override
	public void removeFromPrimaryKey() {
		if (isInPrimaryKey() == true) {
			getPrimaryKey().getColumns().remove(this);
		}
	}
	
	@Override
	public void addToUniqueIndex() {
		if (isUnique() == false
				&& getOwner() != null
				&& getOwner() instanceof Table) {
			Table table = (Table)getOwner();
			
			Index index = getCorrespondingUniqueIndex();
			
			if (index == null) {
				// Create a new unique index
				index = DatabaseFactory.eINSTANCE.createIndex();
				index.setName(table.getName() + "_" + getName() + "_UNIQUE_INDEX");
				index.setUnique(true);
				table.getIndexes().add(index);
				
				IndexElement indexElt = DatabaseFactory.eINSTANCE.createIndexElement();
				index.getElements().add(indexElt);
				indexElt.setAsc(true);
				indexElt.setColumn(this);
			}
		}
	}
	
	@Override
	public void removeFromUniqueIndex() {
		Index uniqueIndex = getCorrespondingUniqueIndex();
		if (uniqueIndex != null) {
			EcoreUtil.delete(uniqueIndex, true);
		}
	}
	
	private Index getCorrespondingUniqueIndex() {
		for(Index index : getIndexes()) {
			if (index.isUnique()
					&& index.getElements().size() == 1
					&& index.getElements().get(0).getColumn() == this) {
				return index;
			}
		}
		return null;
	}
	

}
