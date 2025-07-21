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
import org.eclipse.sirius.business.api.helper.SiriusUtil;
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
import org.obeonetwork.dsl.cinematic.flow.util.FlowSwitch;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.ISObjectCheckBoxFilter;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.SelectMode;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.SiriusInterpreterUtils;
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
	
	private static List<EObject> getEventSelectionDialogChildren(Object parent) {
		List<EObject> children = new ArrayList<>();
		
		if(parent instanceof Flow) {
			Flow flow = (Flow) parent;
			children.addAll(flow.getEvents());
		} else if(parent instanceof Package) {
			Package aPackage = (Package) parent;
			children.addAll(aPackage.getSubPackages());
			children.addAll(aPackage.getViewContainers());
		} else if(parent instanceof AbstractViewElement) {
			AbstractViewElement abstractViewElement = (AbstractViewElement) parent;
			children.addAll(abstractViewElement.getWidget().getPossibleEvents());
			if(abstractViewElement instanceof ViewContainer) {
				ViewContainer viewContainer = (ViewContainer) abstractViewElement;
				children.addAll(viewContainer.getOwnedElements());
			} else if(abstractViewElement instanceof ViewContainerReference) {
				ViewContainerReference viewContainerReference = (ViewContainerReference) abstractViewElement;
				children.add(viewContainerReference.getViewContainer());
			}
		}
		
		return children;
	}
	
	public void openEventSelectionDialog(Transition transition) {
		String windowTitle = "Event selection";
		String message = "Select the events triggering this transition.";
		
		CinematicRoot cinematicRoot = FlowsUtil.getCinematicRoot(transition);
		List<EObject> roots = new ArrayList<>();
		roots.add(EObjectUtils.getContainer(transition, Flow.class));
		roots.addAll(cinematicRoot.getViewContainers());
		roots.addAll(cinematicRoot.getSubPackages());
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				CinematicFlowServices::getEventSelectionDialogChildren);
		
		treeRoot.getConfiguration().setSelectableCondition(
				(wrappedEObject) -> wrappedEObject instanceof FlowEvent || wrappedEObject instanceof WidgetEventType);
		
		for(EObject root : roots) {
			new ISObjectTreeItemWrapper(treeRoot, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
        wizard.setLevelToExpand(2);
        
        List<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers = 
        		treeRoot.getAllSelectableTreeItemWrappers().stream()
        		.filter(tiw -> transition.getOn().stream().anyMatch(event -> treeItemWrapperMatchesEvent(tiw, event)))
        		.collect(toList());
                
		wizard.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
        
		EList<ViewContainer> contextualViewContainers = ((ViewState) transition.getFrom()).getViewContainers();
        wizard.setCheckBoxFilter(new ISObjectCheckBoxFilter("Hide non contextual View Containers", !contextualViewContainers.isEmpty()) {
			@Override
			public boolean filter(ISObjectTreeItemWrapper treeItemWrapper) {
				List<ISObjectTreeItemWrapper> ancestors = treeItemWrapper.getAncestors();
				ancestors.add(treeItemWrapper);
				return !(ancestors.get(1).getWrappedObject() instanceof Flow) &&
						!ancestors.stream()
						.map(tiw -> tiw.getWrappedObject())
						.filter(ViewContainer.class::isInstance).map(ViewContainer.class::cast)
						.anyMatch(vc -> contextualViewContainers.contains(vc));
			}
		});
        
        if(wizard.open() == Window.OK) {
        	Collection<ISObjectTreeItemWrapper> selectedTreeItemWrappers = wizard.getSelectedTreeItemWrappers();
        	
        	List<Event> removedEvents = transition.getOn().stream()
        			.filter(event -> selectedTreeItemWrappers.stream().noneMatch(tiw -> treeItemWrapperMatchesEvent(tiw, event)))
        			.collect(toList());
        	
        	List<ISObjectTreeItemWrapper> addedEvents = selectedTreeItemWrappers.stream()
        			.filter(tiw -> transition.getOn().stream().noneMatch(event -> treeItemWrapperMatchesEvent(tiw, event)))
        			.collect(toList());
        	
        	// Get or create a View Event for each added event
        	addedEvents.forEach(addedEvent -> {
        		if(addedEvent.getWrappedObject() instanceof FlowEvent) {
        			transition.getOn().add((FlowEvent) addedEvent.getWrappedObject());
        		} else if(addedEvent.getWrappedObject() instanceof WidgetEventType) {
            		transition.getOn().add(ViewUtil.getOrCreateViewEvent(
                			(AbstractViewElement)addedEvent.getParent().getWrappedObject(), 
                			(WidgetEventType)addedEvent.getWrappedObject()));
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
	
	private boolean treeItemWrapperMatchesEvent(ISObjectTreeItemWrapper treeItemWrapper, Event event) {
		boolean match = false;
		
		if(event instanceof FlowEvent) {
			match = treeItemWrapper.getWrappedObject() == event;
		} else if(event instanceof ViewEvent) {
			match = treeItemWrapper.getWrappedObject() == ((ViewEvent)event).getType() &&
					treeItemWrapper.getParent().getWrappedObject() == event.eContainer();
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
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				(wrappedEObject) -> SiriusInterpreterUtils.evaluateToEObjectList(interpreter, (EObject) wrappedEObject, childrenExpression));
		
		treeRoot.getConfiguration().setSelectableCondition(ViewContainer.class::isInstance);
		
		for(EObject root : roots) {
			new ISObjectTreeItemWrapper(treeRoot, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
        wizard.setLevelToExpand(3);
        
        wizard.setPreSelectedObjects(viewState.getViewContainers().stream().collect(toList()));
        
        wizard.setTreeSelectMode(SelectMode.PICK_ANY);
        
        Set<ViewContainer> alreadyBoundViewContainers = 
        		StreamUtils.closure((AbstractPackage)cinematicRoot, p -> p.getSubPackages().stream().map(AbstractPackage.class::cast))
        		.flatMap(p -> p.getFlows().stream())
        		.flatMap(f -> f.getStates().stream())
        		.filter(ViewState.class::isInstance).map(ViewState.class::cast)
        		.filter(vs -> vs != viewState)
        		.flatMap(vs -> vs.getViewContainers().stream())
        		.collect(toSet());
        		
        wizard.setCheckBoxFilter(new ISObjectCheckBoxFilter("Hide View Containers bound to other View States", true) {
			@Override
			public boolean filter(ISObjectTreeItemWrapper treeItemWrapper) {
				return alreadyBoundViewContainers.contains(treeItemWrapper.getWrappedObject());
			}
		});
        
        if(wizard.open() == Window.OK) {
        	List<ViewContainer> selectedViewContainers = wizard.getSelectedObjects().stream().map(ViewContainer.class::cast).collect(toList());
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
	
	public void deleteFlowElement(EObject element) {
		new FlowSwitch<Boolean>() {

			@Override
			public Boolean caseFlowState(FlowState flowState) {
				Session session = Session.of(flowState).get();
				ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
				Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(flowState, true);
				for (Setting setting : inverseReferences) {
					if (FlowPackage.Literals.TRANSITION__FROM == setting.getEStructuralFeature() || 
							FlowPackage.Literals.TRANSITION__TO == setting.getEStructuralFeature()) {
						SiriusUtil.delete(setting.getEObject());
					}
				}
				SiriusUtil.delete(flowState);
				return true;
			}

			@Override
			public Boolean defaultCase(EObject object) {
				SiriusUtil.delete(object);
				return true;
			}
			
		}.doSwitch(element);
	}
	
}
