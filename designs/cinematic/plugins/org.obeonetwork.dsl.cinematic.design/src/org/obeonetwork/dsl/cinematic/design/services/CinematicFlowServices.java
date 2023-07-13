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
package org.obeonetwork.dsl.cinematic.design.services;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.Package;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.design.services.view.ViewUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.environment.design.wizards.EObjectTreeItemWrapper;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.SelectMode;
import org.obeonetwork.dsl.environment.design.wizards.TreeItemWrapperCheckBoxFilter;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.StreamUtils;

/**
 * Services to use the flows
 * 
 */
public class CinematicFlowServices {

	/**
	 * Retrieve the view container associate to flow
	 * 
	 * @param context
	 *            the context. In this case should be a flow
	 * @return the list of view Container associate to the flow
	 */
	private List<ViewContainer> getViewContainerAssociate(EObject context) {
		List<ViewContainer> viewContainers = new ArrayList<ViewContainer>();
		if (context instanceof Flow) {
			Flow flow = (Flow) context;
			// Retrieve the flow's states
			EList<FlowState> states = flow.getStates();
			List<ViewState> viewStates = new ArrayList<ViewState>();
			// Retrieve the View state type in the states list
			for (FlowState state : states) {
				if (state instanceof ViewState) {
					viewStates.add((ViewState) state);
				}
			}
			// Retrieve all viewContainers contained in the view State
			for (ViewState viewState : viewStates) {
				viewContainers.addAll(viewState.getViewContainers());
			}
		}
		return viewContainers;
	}

	/**
	 * Retrieve the view container associate to flow and the hierarchy of
	 * viewContainer associate to flow (view Container's parents).
	 * 
	 * @param context
	 *            the context
	 * @return the list of viewContainer associate to flow
	 */
	public List<ViewContainer> getViewContainerAssociateAndAncestors(
			EObject context) {
		List<ViewContainer> viewContainersAncestors = new ArrayList<ViewContainer>();
		if (context instanceof Flow) {
			// Retrieve the viewContainer associate directly to flow
			List<ViewContainer> viewContainers = getViewContainerAssociate(context);
			viewContainersAncestors.addAll(viewContainers);
			for (ViewContainer viewContainer : viewContainers) {
				EObject objectContainer = viewContainer.eContainer();
				while (objectContainer.eContainer() != null) {
					if (objectContainer instanceof ViewContainer) {
						viewContainersAncestors
								.add((ViewContainer) objectContainer);
					}
					objectContainer = objectContainer.eContainer();
				}
			}
		}
		return viewContainersAncestors;
	}
	
	public List<EObject> getEventSelectionDialogChildren(EObject parent) {
		List<EObject> children = new ArrayList<>();
		
		if(parent instanceof Flow) {
			Flow flow = (Flow) parent;
			children.addAll(flow.getEvents());
		} else if(parent instanceof Package) {
			Package aPackage = (Package) parent;
			children.addAll(aPackage.getSubPackages());
			children.addAll(aPackage.getViewContainers());
		} else if(parent instanceof ViewContainer) {
			ViewContainer viewContainer = (ViewContainer) parent;
			children.addAll(viewContainer.getWidget().getPossibleEvents());
			children.addAll(viewContainer.getViewContainers());
		}
		
		return children;
	}
	
	public void openEventSelectionDialog(Transition transition) {
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(transition);
		
		String windowTitle = "Event selection";
		String message = "Select the events triggering this transition.";
		
		CinematicRoot cinematicRoot = FlowsUtil.getCinematicRoot(transition);
		List<EObject> roots = new ArrayList<>();
		roots.add(EObjectUtils.getContainer(transition, Flow.class));
		roots.addAll(cinematicRoot.getViewContainers());
		roots.addAll(cinematicRoot.getSubPackages());
		
		String childrenExpression = "aql:self.getEventSelectionDialogChildren()";
		String selectableCondition = "aql:self.oclIsKindOf(flow::FlowEvent) or self.oclIsKindOf(toolkits::WidgetEventType)";
		
		EObjectTreeItemWrapper treeRoot = new EObjectTreeItemWrapper(interpreter, childrenExpression, selectableCondition);
		for(EObject root : roots) {
			new EObjectTreeItemWrapper(treeRoot, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
        wizard.setLevelToExpand(2);
        
        List<EObjectTreeItemWrapper> preSelectedTreeItemWrappers = 
        		treeRoot.getAllSelectableTreeItemWrappers().stream()
        		.filter(tiw -> transition.getOn().stream().anyMatch(event -> treeItemWrapperMatchesEvent(tiw, event)))
        		.collect(toList());
                
		wizard.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
        
		EList<ViewContainer> contextualViewContainers = ((ViewState) transition.getFrom()).getViewContainers();
        wizard.setCheckBoxFilter(new TreeItemWrapperCheckBoxFilter("Hide non contextual View Containers", !contextualViewContainers.isEmpty()) {
			@Override
			public boolean filter(EObjectTreeItemWrapper treeItemWrapper) {
				List<EObjectTreeItemWrapper> ancestors = treeItemWrapper.getAncestors();
				return !(ancestors.get(ancestors.size() - 2).getWrappedEObject() instanceof Flow) &&
						!ancestors.stream()
						.map(tiw -> tiw.getWrappedEObject())
						.filter(ViewContainer.class::isInstance).map(ViewContainer.class::cast)
						.anyMatch(vc -> contextualViewContainers.contains(vc));
			}
		});
        
        if(wizard.open() == Window.OK) {
        	Collection<EObjectTreeItemWrapper> selectedTreeItemWrappers = wizard.getSelectedTreeItemWrappers();
        	
        	List<Event> removedEvents = transition.getOn().stream()
        			.filter(event -> selectedTreeItemWrappers.stream().noneMatch(tiw -> treeItemWrapperMatchesEvent(tiw, event)))
        			.collect(toList());
        	
        	List<EObjectTreeItemWrapper> addedEvents = selectedTreeItemWrappers.stream()
        			.filter(tiw -> transition.getOn().stream().noneMatch(event -> treeItemWrapperMatchesEvent(tiw, event)))
        			.collect(toList());
        	
        	// Get or create a View Event for each added event
        	addedEvents.forEach(addedEvent -> {
        		if(addedEvent.getWrappedEObject() instanceof FlowEvent) {
        			transition.getOn().add((FlowEvent) addedEvent.getWrappedEObject());
        		} else if(addedEvent.getWrappedEObject() instanceof WidgetEventType) {
            		transition.getOn().add(ViewUtil.getOrCreateViewEvent(
                			(ViewContainer)addedEvent.getParent().getWrappedEObject(), 
                			(WidgetEventType)addedEvent.getWrappedEObject()));
        		}
        	});
        	
        	// Remove the unselected events
        	transition.getOn().removeAll(removedEvents);
        	
        	// Delete the unselected ViewEvents not referenced by any other transition
        	removedEvents.stream()
        	.filter(ViewEvent.class::isInstance).map(ViewEvent.class::cast)
        	.filter(viewEvent -> new EObjectQuery(viewEvent).getInverseReferences(FlowPackage.eINSTANCE.getTransition_On()).isEmpty())
        	.forEach(viewEvent -> EcoreUtil.remove(viewEvent));
        }
        
	}
	
	private boolean treeItemWrapperMatchesEvent(EObjectTreeItemWrapper treeItemWrapper, Event event) {
		boolean match = false;
		
		if(event instanceof FlowEvent) {
			match = treeItemWrapper.getWrappedEObject() == event;
		} else if(event instanceof ViewEvent) {
			match = treeItemWrapper.getWrappedEObject() == ((ViewEvent)event).getType() &&
					treeItemWrapper.getParent().getWrappedEObject() == event.eContainer();
		}
		
		return match;
	}
	
	public void openViewContainerSelectionDialog(ViewState viewState) {
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(viewState);
		
		String windowTitle = "View Container selection";
		String message = String.format("Select the containers to be assigned to the '%s' View State.", viewState.getName());
		
		CinematicRoot cinematicRoot = FlowsUtil.getCinematicRoot(viewState);
		List<EObject> roots = new ArrayList<>();
		roots.addAll(cinematicRoot.getViewContainers());
		roots.addAll(cinematicRoot.getSubPackages());
		
		String childrenExpression = "aql:self.viewContainers + if self.oclIsKindOf(cinematic::Package) then self.subPackages else Sequence{} endif";
		String selectableCondition = "aql:self.oclIsKindOf(view::ViewContainer)";
		
		EObjectTreeItemWrapper treeRoot = new EObjectTreeItemWrapper(interpreter, childrenExpression, selectableCondition);
		for(EObject root : roots) {
			new EObjectTreeItemWrapper(treeRoot, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
        wizard.setLevelToExpand(3);
        
        wizard.setPreSelectedEObjects(viewState.getViewContainers().stream().collect(toList()));
        
        wizard.setTreeSelectMode(SelectMode.PICK_ANY);
        
        Set<ViewContainer> alreadyBoundViewContainers = 
        		StreamUtils.closure((AbstractPackage)cinematicRoot, p -> p.getSubPackages().stream().map(AbstractPackage.class::cast))
        		.flatMap(p -> p.getFlows().stream())
        		.flatMap(f -> f.getStates().stream())
        		.filter(ViewState.class::isInstance).map(ViewState.class::cast)
        		.filter(vs -> vs != viewState)
        		.flatMap(vs -> vs.getViewContainers().stream())
        		.collect(toSet());
        		
        wizard.setCheckBoxFilter(new TreeItemWrapperCheckBoxFilter("Hide View Containers bound to other View States", true) {
			@Override
			public boolean filter(EObjectTreeItemWrapper treeItemWrapper) {
				return alreadyBoundViewContainers.contains(treeItemWrapper.getWrappedEObject());
			}
		});
        
        if(wizard.open() == Window.OK) {
        	List<ViewContainer> selectedViewContainers = wizard.getSelectedEObjects().stream().map(ViewContainer.class::cast).collect(toList());
        	List<ViewContainer> removed = viewState.getViewContainers().stream().filter(vc -> !selectedViewContainers.contains(vc)).collect(toList());
        	List<ViewContainer> added = selectedViewContainers.stream().filter(vc -> !viewState.getViewContainers().contains(vc)).collect(toList());
        	viewState.getViewContainers().removeAll(removed);
        	viewState.getViewContainers().addAll(added);
        }

	}
	
	public static boolean isSubViewContainer(ViewContainer container) {
		return container.eContainer() instanceof ViewContainer;
	}
	
	/**
	 * Checks if a transition targets a view state or is on the path towards a view state 
	 * @param transition a {@link Transition}
	 * @return <code>true</code> or <code>false</code>
	 */
	public static boolean isViewStateTransition(Transition transition) {
		FlowState from = transition.getFrom();
		FlowState to = transition.getTo();
		Session session = new EObjectQuery(transition).getSession();
		ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		
		Collection<FlowState> outgoingFlowStates = new HashSet<>();		
		collectTargetFlowStates(outgoingFlowStates, to, crossReferencer);
		
		Collection<FlowState> incomingFlowStates = new HashSet<>();
		collectSourceFlowStates(incomingFlowStates, from, crossReferencer);
		
		outgoingFlowStates.removeAll(incomingFlowStates);
		
		return outgoingFlowStates.stream().anyMatch(ViewState.class::isInstance);
	}
	
	/**
	 * Gathers all the {@link FlowState}s on a single {@link Transition} path
	 * @param sourceFlowStates a {@link Collection} of {@link FlowState}
	 * @param flowState a {@link FlowState} where the path ends
	 * @param crossReferencer a {@link CrossReferencer}
	 */
	private static void collectSourceFlowStates(Collection<FlowState> sourceFlowStates, FlowState flowState, ECrossReferenceAdapter crossReferencer) {
		if (!sourceFlowStates.contains(flowState)) {
			sourceFlowStates.add(flowState);	
			
			if (flowState instanceof ViewState) {
				return ;
			}
			
			// gets all the transition pointing towards the FlowState
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(flowState, FlowPackage.eINSTANCE.getTransition_To(), true);
			
			inverseReferences.stream()
				.map(Setting::getEObject)
				.filter(Transition.class::isInstance)
				.map(Transition.class::cast)
				.forEach(transition -> collectSourceFlowStates(sourceFlowStates, transition.getFrom(), crossReferencer));			
		}
	}
	
	/**
	 * Gets all the {@link FlowState}s that are on a {@link Transition} path 
	 * @param targetFlowStates a {@link Collection} of {@link FlowState}
	 * @param flowState {@link FlowState}
	 * @param crossReferencer a {@link CrossReferencer}
	 */
	private static void collectTargetFlowStates(Collection<FlowState> targetFlowStates, FlowState flowState, ECrossReferenceAdapter crossReferencer) {
		if (!targetFlowStates.contains(flowState)) {
			targetFlowStates.add(flowState);		
			
			if (flowState instanceof ViewState) {
				return ;
			}			

			// all the transitions starting from the FlowState
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(flowState, FlowPackage.eINSTANCE.getTransition_From(), true);
			
			inverseReferences.stream()
				.map(Setting::getEObject)
				.filter(Transition.class::isInstance)
				.map(Transition.class::cast)
				.forEach(transition -> {
					collectTargetFlowStates(targetFlowStates, transition.getTo(), crossReferencer);	
				});			
			
			// if the state is a SubFlow, checks if the SubFlow goes to a ViewState
			if (flowState instanceof SubflowState && ((SubflowState) flowState).getSubflow() != null) {				
				((SubflowState) flowState)
					.getSubflow()
					.getStates()
					.stream()
					.filter(InitialState.class::isInstance)
					.forEach(initialNode -> {
						collectTargetFlowStates(targetFlowStates, initialNode, crossReferencer);
					});
			}
		}	
	}
}
