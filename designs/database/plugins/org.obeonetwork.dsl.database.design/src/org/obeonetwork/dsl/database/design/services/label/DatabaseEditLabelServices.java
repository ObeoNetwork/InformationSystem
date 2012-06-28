/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services.label;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

public class DatabaseEditLabelServices extends DatabaseSwitch<DatabaseElement>{
	
	private String editedLabelContent;

	public DatabaseElement editDatabaseElementLabel(DatabaseElement element, String editedLabelContent) {
		this.editedLabelContent = editedLabelContent;
		return doSwitch(element);
	}

	@Override
	public DatabaseElement caseColumn(Column column) {
		// the label can be in the form "attributeName : typeName (precision, length)"
		int pos = editedLabelContent.indexOf(':');
		if (pos != -1) {
			String attributeName = editedLabelContent.substring(0, pos - 1).trim();
			column.setName(attributeName);
			
			String typeDef = editedLabelContent.substring(pos + 1).trim();
			// Retrieve types libraries
			DataBase database = getDataBase(column);
			if (database != null) {
				Collection<NativeTypesLibrary> nativeTypesLibraries = new ArrayList<NativeTypesLibrary>();
				for (TypesLibrary library : database.getUsedLibraries()) {
					if (library instanceof NativeTypesLibrary) {
						nativeTypesLibraries.add((NativeTypesLibrary)library);
					}
				}
				setType(column, typeDef, nativeTypesLibraries);
			}
		} else {
			// there is only a name
			return super.caseNamedElement(column);
		}
		return column;
	}
	
	private void setType(Column column, String typeName, Collection<NativeTypesLibrary> typesLibraries) {
		for (NativeTypesLibrary nativeTypesLibrary : typesLibraries) {
			for (NativeType nativeType : nativeTypesLibrary.getNativeTypes()) {
				String typePattern = getNativeTypePattern(nativeType);
				
				String typeRegexPattern = null;
				if (nativeType.getSpec() == NativeTypeKind.ENUM) {
					typeRegexPattern = typePattern;
				} else {
					typeRegexPattern = typePattern.replace("%n", "(.*)");
					typeRegexPattern = typeRegexPattern.replace("%p", "(.*)");
				}
				if (typeRegexPattern != null) {
					Pattern ptn = null;
					try {
						ptn = Pattern.compile(typeRegexPattern, Pattern.CASE_INSENSITIVE);
					} catch (Exception e){
						// Do nothing, the loop will try the other types
					}
					if (ptn != null) {
						Matcher matcher = ptn.matcher(typeName);
						if (matcher.matches()) {
							// Ensure there is a type instance
							if (column.getType() == null || (column.getType() instanceof TypeInstance == false)) {
								TypeInstance type = TypesLibraryFactory.eINSTANCE.createTypeInstance();
								type.setNativeType(nativeType);
								column.setType(type);
							}
							TypeInstance columnType = ((TypeInstance)column.getType());
							columnType.setNativeType(nativeType);
							switch(nativeType.getSpec()) {
							case SIMPLE :
								// Nothing special to do
								return;
							case LENGTH :
								// Retrieve length
								String lengthString = matcher.group(1).trim();
								// Ensure its a string representing an int
								int length = getIntValue(lengthString);
								columnType.setLength(length);
								return;
							case LENGTH_AND_PRECISION :
								int nPos = typePattern.indexOf("%n");
								int pPos = typePattern.indexOf("%p");
								String nString = null;
								String pString = null;
								if (nPos < pPos) {
									nString = matcher.group(1).trim();
									nString = matcher.group(2).trim();
								} else {
									nString = matcher.group(2).trim();
									pString = matcher.group(1).trim();
								}
								int nValue = getIntValue(nString);
								int pValue = getIntValue(pString);
								columnType.setLength(nValue);
								columnType.setPrecision(pValue);
								break;
							case ENUM :
								// Retrieves values
								columnType.getLiterals().clear();
								String valuesString = matcher.group(1).trim();
								for (String value : valuesString.split(",")) {
									columnType.getLiterals().add(value.trim());
								}
								return;
							}
						}
					}
				}
			}
		}
	}
	
	private int getIntValue(String stringValue)	 {
		int result;
		try {
			result = Integer.parseInt(stringValue);
		} catch (NumberFormatException e) {
			result = 0;
		}
		return result;
	}
	
	private DataBase getDataBase(EObject object) {
		if (object.eContainer() != null) {
			if (object.eContainer() instanceof DataBase) {
				return (DataBase)object.eContainer();
			} else {
				return getDataBase(object.eContainer());
			}
		}
		return null;
	}
	
	private String getNativeTypePattern(NativeType nativeType) {
		String label = nativeType.getName();
		label = label.replaceAll("\\(", "\\(");
		label = label.replaceAll("\\)", "\\)");
		switch(nativeType.getSpec()) {
		case LENGTH :
			if (!label.contains("%n")) {
				return label + "\\(%n\\)";
			}
			break;
		case LENGTH_AND_PRECISION :
			if (!label.contains("%n") && !label.contains("%p")) {
				return label + "\\(%n, %p\\)";
			} else if (!label.contains("%n")) {
				return label + "\\(%n\\)";
			} else if (!label.contains("%p")) {
				return label + "\\(%p\\)";
			}
			break;
		case ENUM :
			return label + "\\((.*)\\)";
		}
		return label;
	}

	@Override
	public DatabaseElement caseNamedElement(NamedElement object) {
		object.setName(editedLabelContent);
		return object;
	}
}
