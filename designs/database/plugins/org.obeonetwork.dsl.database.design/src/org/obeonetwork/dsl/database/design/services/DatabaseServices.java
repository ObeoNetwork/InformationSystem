package org.obeonetwork.dsl.database.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.technicalid.util.CopierUtils;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.spec.ViewSpec;
import org.obeonetwork.dsl.database.view.parser.ColObject;
import org.obeonetwork.dsl.database.view.parser.ViewContentProvider;

import com.google.common.base.Strings;

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
		if (viewSpec.initialized==false){
			// Clear view content
			if (viewSpec.getColumns()!=null){
				viewSpec.getColumns().clear();
			}
			if (viewSpec.getTables()!=null){
				viewSpec.getTables().clear();
			}
			// Parse new query and update view content
			String query = viewSpec.getQuery();
			if (!Strings.isNullOrEmpty(query)){		
				ViewContentProvider viewContentProvider = new ViewContentProvider();
				viewContentProvider.parseViewQuery(viewSpec.getQuery());
				List<ColObject> listOfColumns = viewContentProvider.getColumns();

				if (listOfColumns!=null){
					for ( ColObject column : listOfColumns){
						ViewElement elem = DatabaseFactory.eINSTANCE.createViewElement();
						elem.setName(column.getName());
						elem.setAlias(column.getAlias());
						viewSpec.getColumns().add(elem);
					}
				}
				List<String> listOfTables = viewContentProvider.getTables();
				if (listOfTables!=null){
					for ( String table : listOfTables){
						ViewElement elem = DatabaseFactory.eINSTANCE.createViewElement();
						elem.setName(table);
						viewSpec.getTables().add(elem);
					}
				}
			}
			// The initialization was done update boolean.
			viewSpec.initialized=true;
		}
	}
}
