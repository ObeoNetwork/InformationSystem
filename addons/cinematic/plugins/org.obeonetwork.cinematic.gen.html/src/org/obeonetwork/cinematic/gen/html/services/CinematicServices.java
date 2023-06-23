/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.cinematic.gen.html.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.DecisionState;
import org.obeonetwork.dsl.cinematic.flow.FinalState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;

/**
 * @author arichard
 * 
 */
public class CinematicServices {
	
	static private int counter = 0;
	synchronized static public int getId() {
		return counter++;
	}

	/**
	 * Return a collection of {@link ActionState} and/or {@link ViewState}
	 * associated with the given {@link FlowState}.
	 * 
	 * @param flowState
	 *            the given {@link FlowState}.
	 * @param event
	 *            the given {@link Event}.
	 * @return a collection of {@link FlowState}.
	 */
	public Set<FlowState> getNextStates(FlowState flowState, Event event) {
		Set<FlowState> nexts = new HashSet<FlowState>();
		if (flowState instanceof SubflowState) {
			Flow flow = ((SubflowState) flowState).getSubflow();
			if (flow != null) {
				InitialState initialState = getInitialState(flow);
				nexts.addAll(getNextStates(initialState, null));
			}

		} else if (flowState instanceof ViewState
				|| flowState instanceof ActionState
				|| flowState instanceof InitialState
				|| flowState instanceof DecisionState) {
			Flow flow = getFlow(flowState);
			if (flow != null) {
				for (Transition transition : flow.getTransitions()) {
					FlowState from = transition.getFrom();
					FlowState to = transition.getTo();
					Collection<Event> on = transition.getOn();
					if (from != null && to != null && from.equals(flowState)
							&& (on.contains(event) || event == null)) {
						if (to instanceof ViewState) {
							nexts.add((ViewState) to);
						} else if (to instanceof ActionState) {
							nexts.add((ActionState) to);
						} else if (to instanceof SubflowState) {
							nexts.addAll(getNextStates((SubflowState) to, null));
						} else if (to instanceof DecisionState) {
							nexts.addAll(getNextStates((DecisionState) to, null));
						} else if (to instanceof FinalState) {
							Set<SubflowState> subflows = getAllSubFlowStates(flow);
							Set<Transition> transitions = getAllTransitions(flow);
							for (SubflowState subflowState : subflows) {
								if (flow.equals(subflowState.getSubflow())) {
									for (Transition transitionTmp : transitions) {
										FlowState fromTmp = transitionTmp.getFrom();
										FlowState toTmp = transitionTmp.getTo();
										if (from != null && to != null && fromTmp.equals(subflowState)) {
											nexts.add(toTmp);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return nexts;
	}

	private InitialState getInitialState(Flow flow) {
		for (FlowState flowState : flow.getStates()) {
			if (flowState instanceof InitialState) {
				return (InitialState) flowState;
			}
		}
		return null;
	}

	private Flow getFlow(EObject object) {
		EObject container = object.eContainer();
		if (container instanceof Flow) {
			return (Flow) container;
		}
		return null;
	}
	
	private CinematicRoot getCinematicRoot(EObject object) {
		EObject container = EcoreUtil.getRootContainer(object);
		if (container instanceof CinematicRoot) {
			return (CinematicRoot) container;
		}
		return null;
	}
	
	private Set<SubflowState> getAllSubFlowStates(EObject object) {
		Set<SubflowState> subflows = new HashSet<SubflowState>();
		CinematicRoot root = getCinematicRoot(object);
		for (TreeIterator<EObject> iterAssoc = root.eAllContents(); iterAssoc.hasNext();) { 
			Object obj = iterAssoc.next(); 
			if (obj instanceof SubflowState) {
				subflows.add((SubflowState) obj);
			}
		}
		return subflows;
	}
	
	private Set<Transition> getAllTransitions(EObject object) {
		Set<Transition> transitions = new HashSet<Transition>();
		CinematicRoot root = getCinematicRoot(object);
		for (TreeIterator<EObject> iterAssoc = root.eAllContents(); iterAssoc.hasNext();) { 
			Object obj = iterAssoc.next(); 
			if (obj instanceof Transition) {
				transitions.add((Transition) obj);
			}
		}
		return transitions;
	}
}
