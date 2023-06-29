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
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.dialogs.event.FlowstateEventSelectionDialog;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.environment.design.wizards.EObjectCheckBoxFilter;
import org.obeonetwork.dsl.environment.design.wizards.EObjectTreeItemWrapper;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage;
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
		
		EObjectTreeItemWrapper input = new EObjectTreeItemWrapper(interpreter, childrenExpression, selectableCondition);
		
		for(EObject root : roots) {
			new EObjectTreeItemWrapper(input, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		input,
        		true);
		
        wizard.setLevelToExpand(3);
        
        wizard.setPreSelectedEObjects(viewState.getViewContainers().stream().collect(toList()));
        
        wizard.setTreeSelectMode(ISObjectSelectionWizardPage.PICK_ANY);
        
        List<AbstractPackage> allPackages = new ArrayList<>();
        collectAllPackages(allPackages, cinematicRoot);
        Set<ViewContainer> alreadyBoundViewContainers = allPackages.stream()
        		.flatMap(p -> p.getFlows().stream())
        		.flatMap(f -> f.getStates().stream())
        		.filter(ViewState.class::isInstance).map(ViewState.class::cast)
        		.filter(vs -> vs != viewState)
        		.flatMap(vs -> vs.getViewContainers().stream())
        		.collect(toSet());
        		
        wizard.setICheckBoxFilter(new EObjectCheckBoxFilter("Hide View Containers bound to other View States", true) {
			
			@Override
			public boolean filterEObject(EObject eObject) {
				return alreadyBoundViewContainers.contains(eObject);
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
	
	private void collectAllPackages(List<AbstractPackage> allPackages, AbstractPackage aPackage) {
		allPackages.add(aPackage);
		aPackage.getSubPackages().stream().forEach(sp -> collectAllPackages(allPackages, sp));
	}

	public void openEventSelectionDialog(Transition transition) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		FlowstateEventSelectionDialog dialog = new FlowstateEventSelectionDialog(shell, transition);
		dialog.open();
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
