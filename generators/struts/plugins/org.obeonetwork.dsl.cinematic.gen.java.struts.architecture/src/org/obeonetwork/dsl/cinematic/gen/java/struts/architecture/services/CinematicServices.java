package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.services;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.Package;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;

public class CinematicServices {

	/**
	 * Return a collection of {@link AbstractViewElement} associated with the
	 * given {@link ViewState}.
	 * 
	 * @param viewState
	 *            the given {@link ViewState}.
	 * @return a collection of {@link AbstractViewElement}.
	 */
	public Collection<AbstractViewElement> getViewElements(ViewState viewState) {
		Set<AbstractViewElement> elements = new LinkedHashSet<AbstractViewElement>();
		for (ViewContainer container : viewState.getViewContainers()) {
			elements.addAll(getViewElements(container));
		}

		return elements;

	}

	/**
	 * Return a collection of {@link ActionState} associated with the given
	 * {@link ViewState}.
	 * 
	 * @param viewState
	 *            the given {@link ViewState}.
	 * @return a collection of {@link ActionState}.
	 */
	public Collection<ActionState> getActionStates(ViewState viewState) {
		Set<ActionState> actionStates = new LinkedHashSet<ActionState>();
		Flow flow = getFlow(viewState);
		if (flow != null) {
			for (Transition transition : flow.getTransitions()) {
				FlowState from = transition.getFrom();
				FlowState to = transition.getTo();
				if (from != null && to != null) {
					if (from.equals(viewState) && to instanceof ActionState) {
						actionStates.add((ActionState) to);
					}
				}
			}
		}
		return actionStates;

	}

	/**
	 * Return a collection of {@link ViewState} associated with the given
	 * {@link ViewState}.
	 * 
	 * @param viewState
	 *            the given {@link ViewState}.
	 * @return a collection of {@link ViewState}.
	 */
	public Collection<ViewState> getNextViewStates(ViewState viewState) {
		Set<ViewState> nexts = new LinkedHashSet<ViewState>();
		Flow flow = getFlow(viewState);
		if (flow != null) {
			for (Transition transition : flow.getTransitions()) {
				FlowState from = transition.getFrom();
				FlowState to = transition.getTo();
				if (from != null && to != null) {
					if (from.equals(viewState) && to instanceof ViewState) {
						nexts.add((ViewState) to);
					} else if (from.equals(viewState) && to instanceof ActionState) {
						nexts.addAll(getNextViewStates((ActionState) to));
					} else if (from.equals(viewState) && to instanceof SubflowState) {
						nexts.addAll(getNextViewStates((SubflowState) to));
					}
				}
			}
		}
		return nexts;
	}

	
	private Collection<ViewState> getNextViewStates(ActionState actionState) {
		Set<ViewState> nexts = new LinkedHashSet<ViewState>();
		Flow flow = getFlow(actionState);
		if (flow != null) {
			for (Transition transition : flow.getTransitions()) {
				FlowState from = transition.getFrom();
				FlowState to = transition.getTo();
				if (from != null && to != null) {
					if (from.equals(actionState) && to instanceof ViewState) {
						nexts.add((ViewState) to);
					} else if (from.equals(actionState) && to instanceof SubflowState) {
						nexts.addAll(getNextViewStates((SubflowState) to));
					}
				}
			}
		}
		return nexts;
	}
	
	private Collection<ViewState> getNextViewStates(SubflowState subflow) {
		Set<ViewState> nexts = new LinkedHashSet<ViewState>();
		Flow flow = subflow.getSubflow();
		if (flow != null) {
			for (Transition transition : flow.getTransitions()) {
				FlowState from = transition.getFrom();
				FlowState to = transition.getTo();
				if (from != null && to != null) {
					if (from instanceof InitialState && to instanceof ViewState) {
						nexts.add((ViewState) to);
					}
				}
			}
		}
		return nexts;
	}
	
	/**
	 * Get the {@link ViewState} linked to the given {@link AbstractViewElement}
	 * .
	 * 
	 * @param element
	 *            the given {@link AbstractViewElement}.
	 * @return the {@link ViewState} linked to the given
	 *         {@link AbstractViewElement}, or null.
	 */
	public ViewState getViewState(AbstractViewElement element) {
		ViewContainer vc = getTopViewContainer(element);
		if (vc != null) {
			Package pack = getPackage(vc);
			for (Flow flow : pack.getFlows()) {
				for (FlowState state : flow.getStates()) {
					if (state instanceof ViewState) {
						if (((ViewState) state).getViewContainers()
								.contains(vc)) {
							return (ViewState) state;
						}
					}
				}
			}
		}
		return null;

	}

	/**
	 * Return the {@link ViewState} associated with the given
	 * {@link ActionState}.
	 * 
	 * @param actionState
	 *            the given {@link ActionState}.
	 * @return the {@link ViewState} associated with the given
	 *         {@link ActionState}, or null.
	 */
	public ViewState getAssociatedViewState(ActionState actionState) {
		Flow flow = getFlow(actionState);
		if (flow != null) {
			for (Transition transition : flow.getTransitions()) {
				FlowState from = transition.getFrom();
				FlowState to = transition.getTo();
				if (from != null && to != null) {
					if (to.equals(actionState) && from instanceof ViewState) {
						return (ViewState) from;
					}
				}
			}
		}
		return null;

	}

	/**
	 * Get the action state linked to the given {@link AbstractViewElement} with
	 * an event.
	 * 
	 * @param viewElement
	 * @param transitions
	 * @return
	 */
	public ActionState getTriggerAction(AbstractViewElement viewElement,
			Collection<Transition> transitions) {

		Collection<ViewEvent> viewEvents = viewElement.getEvents();
		ViewState viewState = getViewState(viewElement);
		for (Transition transition : transitions) {
			Collection<Event> transitionEvents = transition.getOn();
			for (Event event : transitionEvents) {
				if (viewEvents.contains(event)) {
					FlowState from = transition.getFrom();
					FlowState to = transition.getTo();
					if (to != null && from != null && to instanceof ActionState
							&& from instanceof ViewState
							&& from.equals(viewState)) {
						return (ActionState) to;
					}
				}
			}
		}

		return null;

	}

	private Collection<AbstractViewElement> getViewElements(
			ViewContainer viewContainer) {
		Set<AbstractViewElement> elements = new LinkedHashSet<AbstractViewElement>();
		for (AbstractViewElement element : viewContainer.getOwnedElements()) {
			if (element instanceof ViewContainer) {
				elements.addAll(getViewElements((ViewContainer) element));
			}
			elements.add(element);
		}
		return elements;

	}

	private Flow getFlow(EObject object) {
		EObject container = object.eContainer();
		if (container instanceof Flow) {
			return (Flow) container;
		}
		return null;
	}

	private Package getPackage(ViewContainer viewContainer) {
		EObject container = getTopViewContainer(viewContainer).eContainer();
		if (container instanceof Package) {
			return (Package) container;
		}
		return null;
	}

	private ViewContainer getTopViewContainer(AbstractViewElement element) {
		ViewContainer vc = null;
		EObject parent = element;
		while (parent != null) {
			if (parent instanceof ViewContainer) {
				vc = (ViewContainer) parent;
			}
			parent = parent.eContainer();
		}
		return vc;
	}
}
