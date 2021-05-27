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
package fr.gouv.mindef.safran.database.transfo.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;


public class LabelProvider {
	
	public static String getEntityKeyForTable(Table table) {
		return "Entity_" + getEntityPhysicalNameFromTable(table);
	}
	
	public static String getTableKeyForEntity(Entity entity) {
		return "Table_" + getTableNameFromEntity(entity);
	}
	
	public static String getEntityNameFromTable(Table table) {
		return StringUtils.toCamelCase(table.getName());
	}
	
	public static String getEntityPhysicalNameFromTable(Table table) {
		return table.getName();
	}
	
	public static String getAttributeNameFromColumn(Column column) {
		return StringUtils.toCamelCase(column.getName());
	}
	
	public static String getAttributePhysicalNameFromColumn(Column column) {
		return column.getName();
	}
	
	public static String getReferencePhysicalNameFromFK(ForeignKey fk) {
		return fk.getName();
	}
	
	public static String getReferenceNameFromFK(ForeignKey fk) {
		return StringUtils.toU1Lower(StringUtils.toCamelCase(fk.getName()));
	}
	
	public static String getFKNameFromReference(Reference reference) {
		String name = AnnotationHelper.getPhysicalName(reference);
		if (name == null || name.trim().length() == 0) {
			return null;
		}
		return StringUtils.toSqlNotation(name);
	}
	
	public static String getFKNameFromSourceTableAndPK(Table table, Column targetPk) {
		String name = targetPk.getName();
		
		// reflexive reference: we don't want the FK and PK to have the same name
		// SAFRAN-715
		
		long numberOfTableWithPKName = table.getColumns()
		.stream()
		.filter(t -> t.getName() != null)
		.map(Column::getName)
		.filter(n -> n.matches(String.format("(%s){1}(_[0-9]+)?", targetPk.getName())))
		.count();
		
		if (numberOfTableWithPKName > 0)
			name = String.format("%s_%d", targetPk.getName(), numberOfTableWithPKName);		
		
		return StringUtils.toSqlNotation(name);
	}
	
	public static String getTableNameFromEntity(Entity entity) {
		String value = AnnotationHelper.getPhysicalName(entity);
		if (value == null || value.trim().length() == 0) {
			value = getNameFeatureValue(entity);
		}
		return StringUtils.toSqlNotation(value);
	}
	
	public static String getColumnNameFromAttribute(Attribute attribute) {
		String value = AnnotationHelper.getPhysicalName(attribute);
		if (value == null || value.trim().length() == 0) {
			value = getNameFeatureValue(attribute);
		}
		return StringUtils.toSqlNotation(value);
	}
	
	public static String getNameFeatureValue(ObeoDSMObject dsmObject) {
		EStructuralFeature nameFeature = dsmObject.eClass().getEStructuralFeature("name");
		Object nameValue = dsmObject.eGet(nameFeature);
		if (nameValue != null && nameValue instanceof String) {
			return (String) nameValue;
		}
		return null;
	}

	public static String getJoinTableName(Table table1, Table table2) {
		
		
		String name1 = table1.getName();
		String name2 = table2.getName();
		// Determine common prefix
		int sepPos = name1.indexOf("_");
		if (sepPos != -1) {
			String prefix = name1.substring(0, sepPos + 1);
			return prefix + name1.substring(prefix.length()) + name2.substring(prefix.length());
		}
		return name1 + name2; 
	}
}
