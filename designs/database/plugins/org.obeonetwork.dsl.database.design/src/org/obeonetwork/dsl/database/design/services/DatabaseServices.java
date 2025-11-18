/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services;

import static java.util.stream.Collectors.toList;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.LOGICAL_PATHMAP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewColumn;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.ViewTable;
import org.obeonetwork.dsl.database.spec.ViewSpec;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;
import org.obeonetwork.dsl.database.view.parser.ColObject;
import org.obeonetwork.dsl.database.view.parser.TblObject;
import org.obeonetwork.dsl.database.view.parser.ViewContentProvider;
import org.obeonetwork.dsl.technicalid.util.CopierUtils;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.StringUtils;
import org.obeonetwork.utils.common.ui.services.EclipseUtils;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

public class DatabaseServices {
	
	/**
	 * {@link DAnnotation} key used to store the non referenced external tables in the {@link DAnalysis}
	 */
	private static final String NON_REFERENCED_EXTERNAL_TABLES_KEY = "NonReferencedExternalTables";
	
	/**
	 * Return ForeignKeys from tables.
	 * @param tableContainer
	 * @return foreignKeys
	 */
	public List<ForeignKey> getForeignKeys(TableContainer tableContainer, DSemanticDiagram diagram){
		List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
		List<AbstractTable> tables = tableContainer.getTables();
		for (AbstractTable abstractTable : tables) {
			if(abstractTable instanceof Table){
			 foreignKeys.addAll(((Table)abstractTable).getForeignKeys());
			}
		}
		
		// Foreign keys from external tables on diagram
		for (DDiagramElement diagramElement : diagram.getDiagramElements()) {
			EObject semanticElt = diagramElement.getTarget();
			if (semanticElt instanceof Table) {
				foreignKeys.addAll(((Table)semanticElt).getForeignKeys());
			}
		}
		
		return foreignKeys;
	}
	
	
	public ForeignKey createForeignKey(Table source, Table target) {
		ForeignKey fk = DatabaseFactory.eINSTANCE.createForeignKey();
		source.getForeignKeys().add(fk);
		
		setForeignKeyTarget(fk, target);
		return fk;
	}


	public ForeignKey setForeignKeyTarget(ForeignKey fk, Table target) {
		fk.setTarget(target);
		Table source = fk.getSourceTable();
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
	
	/**
	 * Copy table from diagram to diagram and clean type of columns if it come from
	 * different diagram type
	 * 
	 * @param container
	 * @param copiedElement
	 */
	public void copyTableFromDiagramToDiagram(TableContainer container, DatabaseElement copiedElement) {
		databaseGenericCopy(container, copiedElement);
		if (isTableOrColumnFromOtherDatabaseType((Table) copiedElement,  container)) {
			for (Column column : ((Table) copiedElement).getColumns()) {
				((TypeInstance) column.getType()).setNativeType(null);
			}
		}
	}


	/**
	 * For database metamodel only; add copiedElement into the first compatible containment feature of container.
	 * Supposes that no metaclass of the metamodel element defining at least two containment features of the same type exist
	 * 
	 * @param container
	 * @param copiedElement
	 */
	private void databaseGenericCopy(DatabaseElement container, DatabaseElement copiedElement) {
		EReference containementRef = container.eClass().getEAllStructuralFeatures().stream()
				.filter(EReference.class::isInstance)
				.map(EReference.class::cast)
				.filter(eref -> eref.isContainment() && eref.isMany())
				.filter(eref -> copiedElement.eClass().getEAllSuperTypes().contains(eref.getEReferenceType()))
				.findFirst().get();
		EList<DatabaseElement> containmentList =((EList<DatabaseElement>) container.eGet(containementRef));
		containmentList.add(copiedElement);
	}
	
	/**
	 * Copy column from table to table and clean type of column if it come from
	 * different diagram type
	 * 
	 * @param container
	 * @param copiedElement
	 */
	public void copyColumnFromTableToTable(Table container, Column copiedElement) {
		databaseGenericCopy(container, copiedElement);
		if (isColumnFromOtherDatabaseSchemaType(container, copiedElement)) {
				((TypeInstance) copiedElement.getType()).setNativeType(null);
		}
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
		newColumn.setType(CopierUtils.copy(referenceColumn.getType()));
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
	 * Retrieve all non referenced external tables excluding those already displayed on the diagram and those who don't match the corresponding database type
	 * @param context the Table Container
	 * @param diagram DSemanticDiagram diagram used to check for already displayed tables and database type
	 * @return List of tables
	 */
	public List<Table> allMatchingExternalTables(TableContainer context, DSemanticDiagram diagram) {
		// Retrieve all non Referenced External Tables
		final List<Table> allSelectableExternalTables = allSelectableExternalTables(context, diagram);
		// Get the used lib type from the container database
		final Set<URI> usedLibSetInDatabase = EObjectUtils.getContainerOrSelf(diagram.getTarget(), DataBase.class)
				.getUsedLibraries().stream().map(lib -> lib.eResource().getURI()).collect(Collectors.toSet());

		// Filter based on database type
		final List<Table> allMatchingExternalTables = allSelectableExternalTables.stream()
				.filter(table -> EObjectUtils.getContainerOrSelf(table, DataBase.class).getUsedLibraries().stream()
						.map(lib -> lib.eResource().getURI())
							.anyMatch(libKind -> usedLibSetInDatabase.contains(libKind)))
				.toList();

		return allMatchingExternalTables;
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

	/**
	 * Retrieve a container if Sequences are available.
	 * @param context the Table Container 
	 * @return list of Table Container 
	 */
	public List<Sequence> allSequencesList(TableContainer tableContainer){
		List<Sequence> list = new ArrayList<Sequence>(tableContainer.getSequences());
		Collections.sort(list, new Comparator<Sequence>() {
			@Override
			public int compare(Sequence s1, Sequence s2) {
				if (s2 == null) {
					return -1;
				} else if (s1 == null) {
					return 1;
				} else {
					return String.CASE_INSENSITIVE_ORDER.compare(s1.getName(), s2.getName());
				}
			}
		});
		return list;
	}

	/**
	 * Return a table container if it contains sequences
	 * @param tableContainer
	 * @return
	 */
	public TableContainer tableContainerWithSequences(TableContainer tableContainer){
		if (!tableContainer.getSequences().isEmpty()) {
			return tableContainer;
		} else {
			return null;
		}
	}

	
	/**
	 * Is valid selected diagram element for sequence creation.
	 * 
	 * @param object semantic element
	 * @param elementView element mapping
	 * @return true if element is a TableContainer and correspond to the diagram semantic element
	 */
	public boolean sequenceCreationPreCondition(EObject element, DDiagramElement elementView){
		DDiagram diagram = elementView.getParentDiagram();
		// Check if element select for creation is the diagram semantic element
		// to avoid to create  Sequence in schema in datatbase diagram
		if (element instanceof TableContainer && ((DSemanticDecorator)diagram).getTarget().equals(element)){
			return true;
		}
		return false;
	}

	/**
	 * Is valid selected diagram for sequence creation.
	 * 
	 * @param object semantic element
	 * @param elementView element mapping diagram
	 * @return true if diagram semantic element is a TableContainer
	 */
	public boolean sequenceCreationPreCondition(EObject element, DDiagram elementView){
		if (element instanceof TableContainer){
			return true;
		}
		return false;
	}

	/**
	 * Get all views.
	 * @param tableContainer
	 * @return list of views or empty list.
	 */
	public List<View> getViews(TableContainer tableContainer){
		List<AbstractTable> tables = tableContainer.getTables();
		List<View> result = new ArrayList<View>();
		
		for(AbstractTable table : tables){
			if (table instanceof View){
				initializeViewContent((View)table);
				result.add((View)table);
			}
		}
		return result;
	}

	/**
	 * Initialize the content of a view.
	 * 
	 * Tables and Columns are transient and not saved. 
	 * They need to be be computed at the opening of the diagram.
	 * @param view to initialize.
	 */
	private void initializeViewContent(View view) {
		/* The tables and the columns references are transient. 
		 * Initializing the transient reference is a workaround 
		 * to avoid some diagram refresh problems.
		 * The initializing need to be done only one time.
		 */
		ViewSpec viewSpec = (ViewSpec) view;
		if (!viewSpec.initialized) {
			updateViewContent(view);
			
			// The initialization was done update boolean.
			viewSpec.initialized = true;
		}
	}
	
	public static View updateViewContent(View view) {
		// Clear view content
		if (view.getColumns() != null) {
			view.getColumns().clear();
		}
		if (view.getTables() != null) {
			view.getTables().clear();
		}
		
		// Parse new query
		ViewContentProvider viewContentProvider = new ViewContentProvider();
		String query = Optional.ofNullable(view.getQuery()).orElse("");
		viewContentProvider.parseViewQuery(query);

		// Update tables
		List<TblObject> parsedTables = viewContentProvider.getTables();
		if (parsedTables != null) {
			for (TblObject parsedTable : parsedTables) {
				ViewTable viewTable = DatabaseFactory.eINSTANCE.createViewTable();
				viewTable.setName(parsedTable.getName());
				viewTable.setAlias(parsedTable.getAlias());
				view.getTables().add(viewTable);
			}
		}
		
		// Update columns
		List<ColObject> parsedColumns = viewContentProvider.getColumns();
		if (parsedColumns != null) {
			for (ColObject parsedColumn : parsedColumns) {
				ViewColumn viewColumn = DatabaseFactory.eINSTANCE.createViewColumn();
				viewColumn.setName(parsedColumn.getName());
				viewColumn.setAlias(parsedColumn.getAlias());
				view.getColumns().add(viewColumn);
				
				if(!StringUtils.isNullOrWhite(parsedColumn.getTable())) {
					Optional<ViewTable> fromTableOpt = view.getTables().stream()
							.filter(t -> parsedColumn.getTable().equalsIgnoreCase(t.getName()) || 
									parsedColumn.getTable().equalsIgnoreCase(t.getAlias()))
							.findFirst();
					if(fromTableOpt.isPresent()) {
						viewColumn.setFrom(fromTableOpt.get());
					}
				} else {
					ViewTable viewTable = computeViewTableFromViewColumn(viewColumn);
					if(viewTable != null) {
						viewColumn.setFrom(viewTable);
					}
				}
			}
		}
		
		validateViewQuery(view);
		
		return view;
	}
	
	private static ViewTable computeViewTableFromViewColumn(ViewColumn viewColumn) {
		
		View view = EObjectUtils.getContainer(viewColumn, View.class);
		
		// First collect the view tables to look the column in
		List<ViewTable> viewTables = new ArrayList<>();
		
		if(viewColumn.getFrom() != null) {
			// The "from" table is specified then we must find the column in it
			viewTables.add(viewColumn.getFrom());
		} else {
			// The "from" table is not specified then we must find the column in one of the ViewTables
			viewTables.addAll(view.getTables());
		}
		
		// Now that we know the tables where to look the column in, look for it
		Column column = viewTables.stream()
		.map(DatabaseServices::findTable)
		.filter(Objects::nonNull)
		.flatMap(t -> t.getColumns().stream())
		.filter(c -> viewColumn.getName().equalsIgnoreCase(c.getName()))
		.findFirst().orElse(null);
		
		// And finally crawl to the View Table
		if(column != null) {
			Table table = column.getOwner();
			return view.getTables().stream()
					.filter(vt -> vt.getName().equalsIgnoreCase(table.getName())).findFirst().orElse(null);
		}
		
		return null;
	}
	
	private static void validateViewQuery(View view) {
		List<DDiagramEditor> openDDiagramEditorsShowingView = EclipseUtils.getOpenDDiagramEditors().stream()
				.filter(dde -> dde.getRepresentation().getOwnedRepresentationElements()
						.stream().flatMap(re -> re.getSemanticElements().stream())
						.anyMatch(e -> e == view))
				.collect(toList());
		
		for(DDiagramEditor dDiagramEditor : openDDiagramEditorsShowingView) {
			SiriusUIUtils.validateDDiagramEditor(dDiagramEditor);
		}
	}
	
	public boolean isMldElement(AbstractTable element) {
		DataBase dataBase = EObjectUtils.getContainerOrSelf(element, DataBase.class);
		boolean isMldElement = dataBase.getUsedLibraries().stream()
				.map(lib -> lib.eResource().getURI())
				.anyMatch(uri -> LOGICAL_PATHMAP.equals(uri.toString()));
		return isMldElement;
	}	
	
	public List<ViewElement> getViewElementsOrderedForDatabaseDiagram(View view) {
		List<ViewElement> viewElements = new ArrayList<>();
		
		view.getColumns().stream()
			.filter(c -> c.getFrom() == null)
			.forEach(c -> viewElements.add(c));
		
		for(ViewTable viewTable : view.getTables()) {
			viewElements.add(viewTable);
			view.getColumns().stream()
				.filter(c -> c.getFrom() == viewTable)
				.forEach(c -> viewElements.add(c));
		}
		
		return viewElements;
	}
	
	private static Table findTable(ViewTable viewTable) {
		TableContainer tableContainer = EObjectUtils.getContainer(viewTable, TableContainer.class);
		return tableContainer.getTables().stream()
				.filter(Table.class::isInstance).map(Table.class::cast)
				.filter(t -> viewTable.getName().equalsIgnoreCase(t.getName()))
				.findFirst().orElse(null);
	}
	
	private static Column findColumn(ViewColumn viewColumn) {
		if(viewColumn.getFrom() == null) {
			return null;
 		}
 		
		Table table = findTable(viewColumn.getFrom());
		if(table == null) {
			return null;
		}
 		
		return table.getColumns().stream()
				.filter(c -> viewColumn.getName().equalsIgnoreCase(c.getName()))
				.findFirst().orElse(null);
	}

	public boolean isQueryValid(View view) {
		
		if(view.getTables().stream().anyMatch(t -> findTable(t) == null)) {
			return false;
		}
		
		if(view.getColumns().stream().anyMatch(c -> !c.getName().equals("*") && c.getFrom() == null)) {
			return false;
		}
		
		if(view.getColumns().stream().anyMatch(c -> !c.getName().equals("*") && findColumn(c) == null)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param table
	 * @param container
	 * @return if table come from a different database schema than the given container; false by default if table's column don't contain enough information
	 */
	public boolean isTableOrColumnFromOtherDatabaseType(Table table, NamedElement container) {
		Column column = ((Table) table).getColumns().get(0);
		return isColumnFromOtherDatabaseSchemaType(container, column);
	}


	/**
	 * @param container
	 * @param column
	 * @return if column come from a different database schema than the given container; false by default if column don't contain enough information
	 */
	private boolean isColumnFromOtherDatabaseSchemaType(NamedElement container, Column column) {
		Type columnType = column.getType();
		if (columnType instanceof TypeInstance) {
			return !EObjectUtils.getContainerOrSelf(((TypeInstance) columnType).getNativeType(),TypesLibrary.class).equals(EObjectUtils.getContainerOrSelf(container, DataBase.class).getUsedLibraries().get(0));
		}
		return false;
	}

	public String queryValidationMessage(View view) {
		StringBuilder message = new StringBuilder();
		
		List<ViewTable> tablesNotFound = view.getTables().stream()
				.filter(t -> findTable(t) == null)
				.collect(toList());
		tablesNotFound.forEach(t -> message.append(String.format("Table %s doesn't exist.\n", t.getName())));

		List<ViewColumn> columnsFromNoTable = view.getColumns().stream()
				.filter(c -> !c.getName().equals("*") && c.getFrom() == null)
				.collect(toList());
		columnsFromNoTable.forEach(c -> message.append(String.format("Column %s is from no existing table.\n", c.getName())));

		view.getColumns().stream()
		.filter(c -> !c.getName().equals("*")
				&& !columnsFromNoTable.contains(c)
				&& !tablesNotFound.contains(c.getFrom())
				&& findColumn(c) == null)
		.forEach(c -> message.append(String.format("Column %s of table %s doesn't exist.\n", c.getName(), c.getFrom().getName())));

		if(message.length() > 0) {
			message.deleteCharAt(message.length() - 1);
		}
		
		return message.toString();
	}

	public void deleteDatabaseElement(EObject databaseElement) {
		new DatabaseSwitch<Boolean>() {

			@Override
			public Boolean caseTable(Table table) {
				Session session = Session.of(table).get();
				ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
				Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(table, true);
				for (Setting setting : inverseReferences) {
					if (DatabasePackage.Literals.FOREIGN_KEY__TARGET == setting.getEStructuralFeature()) {
						SiriusUtil.delete(setting.getEObject());
					}
				}
				SiriusUtil.delete(table);
				return true;
			}

			@Override
			public Boolean caseColumn(Column column) {
				Session session = Session.of(column).get();
				ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
				Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(column, true);
				for (Setting setting : inverseReferences) {
					if (DatabasePackage.Literals.INDEX_ELEMENT__COLUMN == setting.getEStructuralFeature() || 
							DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN == setting.getEStructuralFeature() ||
							DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN == setting.getEStructuralFeature()) {
						SiriusUtil.delete(setting.getEObject());
					}
				}
				SiriusUtil.delete(column);
				return true;
			}

			@Override
			public Boolean defaultCase(EObject object) {
				SiriusUtil.delete(object);
				return true;
			}
			
		}.doSwitch(databaseElement);
	}
	
	public static Table addNonReferencedTableToDiagram(DSemanticDiagram diagram, Table table) {
		
		DAnnotation annotation = diagram.getDAnnotation(NON_REFERENCED_EXTERNAL_TABLES_KEY);
		if(annotation == null) {
			annotation = DescriptionFactory.eINSTANCE.createDAnnotation();
			annotation.setSource(NON_REFERENCED_EXTERNAL_TABLES_KEY);
			diagram.getEAnnotations().add(annotation);
		}
		
		if(!annotation.getReferences().contains(table)) {
			annotation.getReferences().add(table);
		}
		
		return table;
	}
	
	public static Table removeNonReferencedTableFromDiagram(DSemanticDiagram diagram, Table table) {
		
		DAnnotation annotation = diagram.getDAnnotation(NON_REFERENCED_EXTERNAL_TABLES_KEY);
		if(annotation != null) {
			annotation.getReferences().remove(table);
		}
		
		return table;
	}
	
	public static List<Table> getNonReferencedTablesFromDiagram(DSemanticDiagram diagram) {
		
		DAnnotation annotation = diagram.getDAnnotation(NON_REFERENCED_EXTERNAL_TABLES_KEY);
		if(annotation != null) {
			return annotation.getReferences().stream().filter(Table.class::isInstance).map(Table.class::cast).toList();
		}
		
		return Collections.emptyList();
	}
	
	public DSemanticDiagram removeAllReferencedTablesFromDiagram(DSemanticDiagram diagram) {

		TableContainer tableContainer = (TableContainer) diagram.getTarget();
		List<Table> referencedTables = allReferencedExternalTables(tableContainer);
		DAnnotation annotation = diagram.getDAnnotation(NON_REFERENCED_EXTERNAL_TABLES_KEY);
		if(annotation != null) {
			annotation.getReferences().removeAll(referencedTables);
		}
		
		return diagram;
	}
	
}
