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
package org.obeonetwork.graal.parts;

/**
 * 
 * 
 */
public class GraalViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Task view descriptor
	 * 
	 */
	public static class Task {
		public static class Properties {
	
			
			public static String id = "graal::Task::properties::id";
			
			
			public static String name = "graal::Task::properties::name";
			
			
			public static String description = "graal::Task::properties::description";
			
			
			public static String preconditions = "graal::Task::properties::preconditions";
			
			
			public static String postconditions = "graal::Task::properties::postconditions";
			
			
			public static String subActivities = "graal::Task::properties::subActivities";
			
			
			public static String actors = "graal::Task::properties::actors";
			
			
			public static String uses = "graal::Task::properties::uses";
			
	
		}
	
	}

	/**
	 * System view descriptor
	 * 
	 */
	public static class System {
		public static class Properties {
	
			
			public static String name = "graal::System::properties::name";
			
			
			public static String description = "graal::System::properties::description";
			
	
		}
	
	}

	/**
	 * Operator view descriptor
	 * 
	 */
	public static class Operator {
		public static class Properties {
	
			
			public static String kind = "graal::Operator::properties::kind";
			
			
			public static String description = "graal::Operator::properties::description";
			
			
			public static String outgoingTransitions = "graal::Operator::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::Operator::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * Transition view descriptor
	 * 
	 */
	public static class Transition {
		public static class Properties {
	
			
			public static String guard = "graal::Transition::properties::guard";
			
			
			public static String kind = "graal::Transition::properties::kind";
			
			
			public static String source = "graal::Transition::properties::source";
			
			
			public static String target = "graal::Transition::properties::target";
			
			
			public static String description = "graal::Transition::properties::description";
			
	
		}
	
	}

	/**
	 * TaskReference view descriptor
	 * 
	 */
	public static class TaskReference {
		public static class Properties {
	
			
			public static String task = "graal::TaskReference::properties::task";
			
			
			public static String description = "graal::TaskReference::properties::description";
			
			
			public static String outgoingTransitions = "graal::TaskReference::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::TaskReference::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * UserView view descriptor
	 * 
	 */
	public static class UserView {
		public static class Properties {
	
			
			public static String name = "graal::UserView::properties::name";
			
			
			public static String description = "graal::UserView::properties::description";
			
			
			public static String outgoingTransitions = "graal::UserView::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::UserView::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * UserAction view descriptor
	 * 
	 */
	public static class UserAction {
		public static class Properties {
	
			
			public static String name = "graal::UserAction::properties::name";
			
			
			public static String description = "graal::UserAction::properties::description";
			
			
			public static String outgoingTransitions = "graal::UserAction::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::UserAction::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * AppliEvent view descriptor
	 * 
	 */
	public static class AppliEvent {
		public static class Properties {
	
			
			public static String name = "graal::AppliEvent::properties::name";
			
			
			public static String description = "graal::AppliEvent::properties::description";
			
			
			public static String outgoingTransitions = "graal::AppliEvent::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::AppliEvent::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * AppliAction view descriptor
	 * 
	 */
	public static class AppliAction {
		public static class Properties {
	
			
			public static String name = "graal::AppliAction::properties::name";
			
			
			public static String description = "graal::AppliAction::properties::description";
			
			
			public static String outgoingTransitions = "graal::AppliAction::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::AppliAction::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * InitialNode view descriptor
	 * 
	 */
	public static class InitialNode {
		public static class Properties {
	
			
			public static String description = "graal::InitialNode::properties::description";
			
			
			public static String outgoingTransitions = "graal::InitialNode::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::InitialNode::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * FinalNode view descriptor
	 * 
	 */
	public static class FinalNode {
		public static class Properties {
	
			
			public static String description = "graal::FinalNode::properties::description";
			
			
			public static String outgoingTransitions = "graal::FinalNode::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::FinalNode::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * AbortNode view descriptor
	 * 
	 */
	public static class AbortNode {
		public static class Properties {
	
			
			public static String description = "graal::AbortNode::properties::description";
			
			
			public static String outgoingTransitions = "graal::AbortNode::properties::outgoingTransitions";
			
			
			public static String incomingTransitions = "graal::AbortNode::properties::incomingTransitions";
			
	
		}
	
	}

	/**
	 * Loop view descriptor
	 * 
	 */
	public static class Loop {
		public static class Properties {
	
			
			public static String lowerBound = "graal::Loop::properties::lowerBound";
			
			
			public static String upperBound = "graal::Loop::properties::upperBound";
			
			
			public static String description = "graal::Loop::properties::description";
			
			
			public static String subActivities = "graal::Loop::properties::subActivities";
			
	
		}
	
	}

	/**
	 * Actor view descriptor
	 * 
	 */
	public static class Actor {
		public static class Properties {
	
			
			public static String name = "graal::Actor::properties::name";
			
			
			public static String description = "graal::Actor::properties::description";
			
			
			public static String superActor = "graal::Actor::properties::superActor";
			
			
			public static String subActors = "graal::Actor::properties::subActors";
			
	
		}
	
	}

	/**
	 * TasksGroup view descriptor
	 * 
	 */
	public static class TasksGroup {
		public static class Properties {
	
			
			public static String id = "graal::TasksGroup::properties::id";
			
			
			public static String name = "graal::TasksGroup::properties::name";
			
			
			public static String description = "graal::TasksGroup::properties::description";
			
	
		}
	
	}

	/**
	 * UseCase view descriptor
	 * 
	 */
	public static class UseCase {
		public static class Properties {
	
			
			public static String name = "graal::UseCase::properties::name";
			
			
			public static String description = "graal::UseCase::properties::description";
			
			
			public static String tasks = "graal::UseCase::properties::tasks";
			
			
			public static String namespaces = "graal::UseCase::properties::namespaces";
			
			
			public static String domainClasses = "graal::UseCase::properties::domainClasses";
			
	
		}
	
	}

	/**
	 * UserStory view descriptor
	 * 
	 */
	public static class UserStory {
		public static class Properties {
	
			
			public static String name = "graal::UserStory::properties::name";
			
			
			public static String description = "graal::UserStory::properties::description";
			
	
		}
	
	}

	/**
	 * DomainClass view descriptor
	 * 
	 */
	public static class DomainClass {
		public static class Properties {
	
			
			public static String name = "graal::DomainClass::properties::name";
			
			
			public static String superType = "graal::DomainClass::properties::superType";
			
			
			public static String associatedTypes = "graal::DomainClass::properties::associatedTypes";
			
			
			public static String description = "graal::DomainClass::properties::description";
			
	
		}
	
	}

	/**
	 * Persistence view descriptor
	 * 
	 */
	public static class Persistence {
		public static class Properties {
	
			
			public static String estimatedVolumetry = "graal::Persistence::properties::estimatedVolumetry";
			
			
			public static String historized = "graal::Persistence::properties::historized";
			
	
		}
	
	}

}
