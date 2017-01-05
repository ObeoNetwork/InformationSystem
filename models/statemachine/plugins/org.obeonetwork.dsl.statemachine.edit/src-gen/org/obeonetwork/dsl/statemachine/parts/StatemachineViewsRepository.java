/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.statemachine.parts;

/**
 * 
 * 
 */
public class StatemachineViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * StateMachine view descriptor
	 * 
	 */
	public static class StateMachine_ {
		public static class Properties {
	
			
			public static String name = "statemachine::StateMachine_::properties::name";
			
			
			public static String regions = "statemachine::StateMachine_::properties::regions";
			
			
			public static String keywords = "statemachine::StateMachine_::properties::keywords";
			
			
			public static String description = "statemachine::StateMachine_::properties::description";
			
	
		}
	
	}

	/**
	 * State view descriptor
	 * 
	 */
	public static class State {
		public static class Properties {
	
			
			public static String name = "statemachine::State::properties::name";
			
			
			public static String incomingTransitions = "statemachine::State::properties::incomingTransitions";
			
			
			public static String outcomingTransitions = "statemachine::State::properties::outcomingTransitions";
			
			
			public static String keywords = "statemachine::State::properties::keywords";
			
			
			public static String description = "statemachine::State::properties::description";
			
	
		}
	
	}

	/**
	 * Region view descriptor
	 * 
	 */
	public static class Region {
		public static class Properties {
	
			
			public static String name = "statemachine::Region::properties::name";
			
			
			public static String keywords = "statemachine::Region::properties::keywords";
			
			
			public static String description = "statemachine::Region::properties::description";
			
	
		}
	
	}

	/**
	 * Transition view descriptor
	 * 
	 */
	public static class Transition {
		public static class Properties {
	
			
			public static String guard = "statemachine::Transition::properties::guard";
			
			
			public static String from = "statemachine::Transition::properties::from";
			
			
			public static String to = "statemachine::Transition::properties::to";
			
			
			public static String keywords = "statemachine::Transition::properties::keywords";
			
			
			public static String description = "statemachine::Transition::properties::description";
			
	
		}
	
	}

	/**
	 * InitialState view descriptor
	 * 
	 */
	public static class InitialState {
		public static class Properties {
	
			
			public static String incomingTransitions = "statemachine::InitialState::properties::incomingTransitions";
			
			
			public static String outcomingTransitions = "statemachine::InitialState::properties::outcomingTransitions";
			
			
			public static String keywords = "statemachine::InitialState::properties::keywords";
			
			
			public static String description = "statemachine::InitialState::properties::description";
			
	
		}
	
	}

	/**
	 * FinalState view descriptor
	 * 
	 */
	public static class FinalState {
		public static class Properties {
	
			
			public static String incomingTransitions = "statemachine::FinalState::properties::incomingTransitions";
			
			
			public static String outcomingTransitions = "statemachine::FinalState::properties::outcomingTransitions";
			
			
			public static String keywords = "statemachine::FinalState::properties::keywords";
			
			
			public static String description = "statemachine::FinalState::properties::description";
			
	
		}
	
	}

}
