/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts;

/**
 * 
 * 
 */
public class EntityrelationViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * LogicalModel view descriptor
	 * 
	 */
	public static class LogicalModel {
		public static class Properties {
	
			
			public static String name = "entityrelation::LogicalModel::properties::name";
			
			
			public static String usedLibraries = "entityrelation::LogicalModel::properties::usedLibraries";
			
			
			public static String comments = "entityrelation::LogicalModel::properties::comments";
			
	
		}
	
	}

	/**
	 * Entity view descriptor
	 * 
	 */
	public static class Entity {
		public static class Properties {
	
			
			public static String name = "entityrelation::Entity::properties::name";
			
			
			public static String attributes = "entityrelation::Entity::properties::attributes";
			
			
			public static String comments = "entityrelation::Entity::properties::comments";
			
	
		}
	
	}

	/**
	 * Identifiers view descriptor
	 * 
	 */
	public static class Identifiers {
		public static class Properties {
	
			
			public static String identifiers_ = "entityrelation::Identifiers::properties::identifiers_";
			
	
		}
	
	}

	/**
	 * Relation view descriptor
	 * 
	 */
	public static class Relation {
		public static class Properties {
	
			
			public static String name = "entityrelation::Relation::properties::name";
			
			
			public static String identifier = "entityrelation::Relation::properties::identifier";
			
				public static class Source {
			
					
					public static String source_ = "entityrelation::Relation::properties::Source::source_";
					
					
					public static String sourceRole = "entityrelation::Relation::properties::Source::sourceRole";
					
					
					public static String sourceCardinality = "entityrelation::Relation::properties::Source::sourceCardinality";
					
					
					public static String sourceIsComposite = "entityrelation::Relation::properties::Source::sourceIsComposite";
					
			
				}
			
				public static class Target {
			
					
					public static String target_ = "entityrelation::Relation::properties::Target::target_";
					
					
					public static String targetRole = "entityrelation::Relation::properties::Target::targetRole";
					
					
					public static String targetCardinality = "entityrelation::Relation::properties::Target::targetCardinality";
					
					
					public static String targetIsComposite = "entityrelation::Relation::properties::Target::targetIsComposite";
					
			
				}
			
			
			public static String elements = "entityrelation::Relation::properties::elements";
			
			
			public static String comments = "entityrelation::Relation::properties::comments";
			
	
		}
	
	}

	/**
	 * Relation Element view descriptor
	 * 
	 */
	public static class RelationElement {
		public static class Properties {
	
			
			public static String sourceEntity = "entityrelation::Relation Element::properties::source entity";
			
			
			public static String sourceAttribute = "entityrelation::Relation Element::properties::source attribute";
			
			
			public static String targetEntity = "entityrelation::Relation Element::properties::target entity";
			
			
			public static String targetAttribute = "entityrelation::Relation Element::properties::target attribute";
			
			
			public static String comments = "entityrelation::Relation Element::properties::comments";
			
	
		}
	
	}

	/**
	 * Attribute view descriptor
	 * 
	 */
	public static class Attribute {
		public static class Properties {
	
			
			public static String name = "entityrelation::Attribute::properties::name";
			
			
			public static String type = "entityrelation::Attribute::properties::type";
			
				public static class TypeAttributes {
			
					
					public static String length = "entityrelation::Attribute::properties::typeAttributes::length";
					
					
					public static String precision = "entityrelation::Attribute::properties::typeAttributes::precision";
					
			
				}
			
			
			public static String literals = "entityrelation::Attribute::properties::literals";
			
				public static class RequiredAndIdentifier {
			
					
					public static String required = "entityrelation::Attribute::properties::requiredAndIdentifier::required";
					
					
					public static String inPrimaryIdentifier = "entityrelation::Attribute::properties::requiredAndIdentifier::in primary identifier";
					
			
				}
			
			
			public static String comments = "entityrelation::Attribute::properties::comments";
			
	
		}
	
	}

	/**
	 * Identifier view descriptor
	 * 
	 */
	public static class Identifier {
		public static class Properties {
	
			
			public static String name = "entityrelation::Identifier::properties::name";
			
			
			public static String attributes = "entityrelation::Identifier::properties::attributes";
			
			
			public static String comments = "entityrelation::Identifier::properties::comments";
			
	
		}
	
	}

}
