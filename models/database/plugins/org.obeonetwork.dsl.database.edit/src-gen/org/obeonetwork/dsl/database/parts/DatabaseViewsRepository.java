/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

/**
 * 
 * 
 */
public class DatabaseViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * DataBase view descriptor
	 * 
	 */
	public static class DataBase_ {
		public static class Properties {
	
			
			public static String name = "database::DataBase_::properties::name";
			
			
			public static String url = "database::DataBase_::properties::url";
			
			
			public static String usedLibraries = "database::DataBase_::properties::usedLibraries";
			
			
			public static String comments = "database::DataBase_::properties::comments";
			
	
		}
	
	}

	/**
	 * Column view descriptor
	 * 
	 */
	public static class Column {
		public static class Properties {
	
			
			public static String name = "database::Column::properties::name";
			
			
			public static String type = "database::Column::properties::type";
			
				public static class TypeAttributes {
			
					
					public static String length = "database::Column::properties::typeAttributes::length";
					
					
					public static String precision = "database::Column::properties::typeAttributes::precision";
					
			
				}
			
			
			public static String literals = "database::Column::properties::literals";
			
				public static class NullablePkAndUnique {
			
					
					public static String nullable = "database::Column::properties::nullablePkAndUnique::nullable";
					
					
					public static String primaryKey = "database::Column::properties::nullablePkAndUnique::primary key";
					
					
					public static String unique = "database::Column::properties::nullablePkAndUnique::unique";
					
			
				}
			
				public static class Sequence {
			
					
					public static String autoincrement = "database::Column::properties::sequence::autoincrement";
					
					
					public static String sequence_ = "database::Column::properties::sequence::sequence_";
					
			
				}
			
			
			public static String defaultValue = "database::Column::properties::default value";
			
			
			public static String comments = "database::Column::properties::comments";
			
	
		}
	
	}

	/**
	 * Index view descriptor
	 * 
	 */
	public static class Index {
		public static class Properties {
	
			
			public static String name = "database::Index::properties::name";
			
			
			public static String qualifier = "database::Index::properties::qualifier";
			
			
			public static String unique = "database::Index::properties::unique";
			
			
			public static String cardinality = "database::Index::properties::cardinality";
			
			
			public static String indexType = "database::Index::properties::index type";
			
			
			public static String elements = "database::Index::properties::elements";
			
			
			public static String comments = "database::Index::properties::comments";
			
	
		}
	
	}

	/**
	 * View view descriptor
	 * 
	 */
	public static class View {
		public static class Properties {
	
			
			public static String name = "database::View::properties::name";
			
			
			public static String query = "database::View::properties::query";
			
			
			public static String comments = "database::View::properties::comments";
			
	
		}
	
	}

	/**
	 * Table view descriptor
	 * 
	 */
	public static class Table {
		public static class Properties {
	
			
			public static String name = "database::Table::properties::name";
			
			
			public static String columns = "database::Table::properties::columns";
			
			
			public static String comments = "database::Table::properties::comments";
			
	
		}
	
	}

	/**
	 * Foreign Keys view descriptor
	 * 
	 */
	public static class ForeignKeys {
		public static class Properties {
	
			
			public static String foreignKeys_ = "database::Foreign Keys::properties::foreign keys_";
			
	
		}
	
	}

	/**
	 * Indexes view descriptor
	 * 
	 */
	public static class Indexes {
		public static class Properties {
	
			
			public static String indexes_ = "database::Indexes::properties::indexes_";
			
	
		}
	
	}

	/**
	 * Constraints view descriptor
	 * 
	 */
	public static class Constraints {
		public static class Properties {
	
			
			public static String constraints_ = "database::Constraints::properties::constraints_";
			
	
		}
	
	}

	/**
	 * Primary Key view descriptor
	 * 
	 */
	public static class PrimaryKey {
		public static class Properties {
	
			
			public static String name = "database::Primary Key::properties::name";
			
			
			public static String columns = "database::Primary Key::properties::columns";
			
			
			public static String comments = "database::Primary Key::properties::comments";
			
	
		}
	
	}

	/**
	 * Foreign Key view descriptor
	 * 
	 */
	public static class ForeignKey {
		public static class Properties {
	
			
			public static String name = "database::Foreign Key::properties::name";
			
			
			public static String target = "database::Foreign Key::properties::target";
			
			
			public static String elements = "database::Foreign Key::properties::elements";
			
			
			public static String comments = "database::Foreign Key::properties::comments";
			
	
		}
	
	}

	/**
	 * Foreign Key Element view descriptor
	 * 
	 */
	public static class ForeignKeyElement {
		public static class Properties {
	
			
			public static String sourceTable = "database::Foreign Key Element::properties::Source table";
			
			
			public static String fKColumn = "database::Foreign Key Element::properties::FK Column";
			
			
			public static String targetTable = "database::Foreign Key Element::properties::Target table";
			
			
			public static String pKColumn = "database::Foreign Key Element::properties::PK column";
			
			
			public static String comments = "database::Foreign Key Element::properties::comments";
			
	
		}
	
	}

	/**
	 * Index Element view descriptor
	 * 
	 */
	public static class IndexElement {
		public static class Properties {
	
			
			public static String column = "database::Index Element::properties::column";
			
			
			public static String asc = "database::Index Element::properties::asc";
			
			
			public static String comments = "database::Index Element::properties::comments";
			
	
		}
	
	}

	/**
	 * Constraint view descriptor
	 * 
	 */
	public static class Constraint {
		public static class Properties {
	
			
			public static String name = "database::Constraint::properties::name";
			
			
			public static String expression = "database::Constraint::properties::expression";
			
			
			public static String comments = "database::Constraint::properties::comments";
			
	
		}
	
	}

	/**
	 * Schema view descriptor
	 * 
	 */
	public static class Schema {
		public static class Properties {
	
			
			public static String name = "database::Schema::properties::name";
			
			
			public static String comments = "database::Schema::properties::comments";
			
	
		}
	
	}

	/**
	 * Sequence view descriptor
	 * 
	 */
	public static class Sequence {
		public static class Properties {
	
			
			public static String name = "database::Sequence::properties::name";
			
				public static class StartIncrement {
			
					
					public static String start = "database::Sequence::properties::StartIncrement::start";
					
					
					public static String increment = "database::Sequence::properties::StartIncrement::increment";
					
			
				}
			
				public static class MinMax {
			
					
					public static String minValue = "database::Sequence::properties::MinMax::min value";
					
					
					public static String maxValue = "database::Sequence::properties::MinMax::max value";
					
			
				}
			
			
			public static String comments = "database::Sequence::properties::comments";
			
	
		}
	
	}

}
