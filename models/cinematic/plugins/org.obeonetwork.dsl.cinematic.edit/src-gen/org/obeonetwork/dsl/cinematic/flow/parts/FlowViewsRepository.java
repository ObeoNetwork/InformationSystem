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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts;

/**
 * 
 * 
 */
public class FlowViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Flow view descriptor
	 * 
	 */
	public static class Flow_ {
		public static class Properties {
	
			
			public static String name = "flow::Flow_::properties::name";
			
			
			public static String description = "flow::Flow_::properties::description";
			
			
			public static String events = "flow::Flow_::properties::events";
			
			
			public static String states = "flow::Flow_::properties::states";
			
			
			public static String transitions = "flow::Flow_::properties::transitions";
			
	
		}
	
	}

	/**
	 * Transition view descriptor
	 * 
	 */
	public static class Transition {
		public static class Properties {
	
			
			public static String name = "flow::Transition::properties::name";
			
			
			public static String guard = "flow::Transition::properties::guard";
			
			
			public static String modal = "flow::Transition::properties::modal";
			
			
			public static String on = "flow::Transition::properties::on";
			
			
			public static String description = "flow::Transition::properties::description";
			
			
			public static String from = "flow::Transition::properties::from";
			
			
			public static String to = "flow::Transition::properties::to";
			
	
		}
	
	}

	/**
	 * ActionState view descriptor
	 * 
	 */
	public static class ActionState {
		public static class Properties {
	
			
			public static String name = "flow::ActionState::properties::name";
			
			
			public static String actions = "flow::ActionState::properties::actions";
			
			
			public static String description = "flow::ActionState::properties::description";
			
	
		}
	
	}

	/**
	 * ViewState view descriptor
	 * 
	 */
	public static class ViewState {
		public static class Properties {
	
			
			public static String name = "flow::ViewState::properties::name";
			
			
			public static String actions = "flow::ViewState::properties::actions";
			
			
			public static String newInstance = "flow::ViewState::properties::newInstance";
			
			
			public static String refresh = "flow::ViewState::properties::refresh";
			
			
			public static String viewContainers = "flow::ViewState::properties::viewContainers";
			
			
			public static String description = "flow::ViewState::properties::description";
			
	
		}
	
	}

	/**
	 * DecisionState view descriptor
	 * 
	 */
	public static class DecisionState {
		public static class Properties {
	
			
			public static String name = "flow::DecisionState::properties::name";
			
			
			public static String actions = "flow::DecisionState::properties::actions";
			
			
			public static String description = "flow::DecisionState::properties::description";
			
	
		}
	
	}

	/**
	 * SubflowState view descriptor
	 * 
	 */
	public static class SubflowState {
		public static class Properties {
	
			
			public static String subflow = "flow::SubflowState::properties::subflow";
			
			
			public static String actions = "flow::SubflowState::properties::actions";
			
			
			public static String description = "flow::SubflowState::properties::description";
			
	
		}
	
	}

	/**
	 * AsyncEventState view descriptor
	 * 
	 */
	public static class AsyncEventState {
		public static class Properties {
	
			
			public static String name = "flow::AsyncEventState::properties::name";
			
			
			public static String actions = "flow::AsyncEventState::properties::actions";
			
			
			public static String description = "flow::AsyncEventState::properties::description";
			
	
		}
	
	}

	/**
	 * InitialState view descriptor
	 * 
	 */
	public static class InitialState {
		public static class Properties {
	
			
			public static String name = "flow::InitialState::properties::name";
			
			
			public static String actions = "flow::InitialState::properties::actions";
			
			
			public static String description = "flow::InitialState::properties::description";
			
	
		}
	
	}

	/**
	 * AbortState view descriptor
	 * 
	 */
	public static class AbortState {
		public static class Properties {
	
			
			public static String name = "flow::AbortState::properties::name";
			
			
			public static String actions = "flow::AbortState::properties::actions";
			
			
			public static String description = "flow::AbortState::properties::description";
			
	
		}
	
	}

	/**
	 * FinalState view descriptor
	 * 
	 */
	public static class FinalState {
		public static class Properties {
	
			
			public static String name = "flow::FinalState::properties::name";
			
			
			public static String actions = "flow::FinalState::properties::actions";
			
			
			public static String description = "flow::FinalState::properties::description";
			
	
		}
	
	}

	/**
	 * FlowAction view descriptor
	 * 
	 */
	public static class FlowAction {
		public static class Properties {
	
			
			public static String name = "flow::FlowAction::properties::name";
			
			
			public static String calls = "flow::FlowAction::properties::calls";
			
			
			public static String operations = "flow::FlowAction::properties::operations";
			
			
			public static String description = "flow::FlowAction::properties::description";
			
	
		}
	
	}

	/**
	 * FlowEvent view descriptor
	 * 
	 */
	public static class FlowEvent {
		public static class Properties {
	
			
			public static String name = "flow::FlowEvent::properties::name";
			
			
			public static String binds = "flow::FlowEvent::properties::binds";
			
			
			public static String description = "flow::FlowEvent::properties::description";
			
	
		}
	
	}

}
