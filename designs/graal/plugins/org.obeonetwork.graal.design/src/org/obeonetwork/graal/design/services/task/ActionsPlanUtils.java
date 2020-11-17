/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.task;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.graal.AbortNode;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.FinalNode;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.InitialNode;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.UserStory;

/**
 * Utilities services concerning activity nodes and transitions
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class ActionsPlanUtils {
	
	/**
	 * Checks if the node should be attached to user stories
	 * @param node
	 * @param userStories
	 */
	public void initNodeAfterCreation(Node node, List<UserStory> userStories) {
		if (node instanceof TaskReference) {
			return;
		}
		attachToTaskStories(node.getContainingTask(), node, userStories);
	}
	
	/**
	 * Checks if the node contained in a loop should be attached to user stories
	 * @param loop
	 * @param userStories
	 */
	public void initNodeAfterCreation(Loop loop, List<UserStory> userStories) {
		for (Node node : loop.getNodes()) {
			if (node instanceof TaskReference) {
				break;
			}
			attachToTaskStories(node.getContainingTask(), node, userStories);
		}
	}
	
	/**
	 * Checks if the transition should be attached to user stories
	 * @param transition
	 * @param userStories
	 */
	public void initTransitionAfterCreation(Transition transition, List<UserStory> userStories) {
		attachToTaskStories(transition.getContainingTask(), transition, userStories);
	}
	
	/**
	 * Checks if the loop should be attached to user stories
	 * @param loop
	 * @param userStories
	 */
	public void initLoopAfterCreation(Loop loop, List<UserStory> userStories) {
		attachToTaskStories(loop.getContainingTask(), loop, userStories);
	}
	
	/**
	 * Attach the element to the user stories associated with the task
	 * @param task Task containing the element
	 * @param element Element
	 * @param userStories List of user stories to analalyze
	 */
	private void attachToTaskStories(Task task, GraalObject element, List<UserStory> userStories) {
		if (task != null) {
			for (UserStory userStory : userStories) {
				if (task.isConcernedByUserStory(userStory)) {
					element.attachToUserStory(userStory);
				}
			}
		}
	}

	/**
	 * Returns the higher common direct activity containing the two provided nodes
	 * @param context EObject needed so the service can be called by Acceleo
	 * @param firstNode First node contained in the searched activity
	 * @param secondNode Second node contained in the searched activity
	 * @return  the closer
	 */
	public Activity getCloserCommonDirectParent(EObject context, Node firstNode, Node secondNode) {
		if (inSameActivity(firstNode, secondNode)) {
			return (Activity)firstNode.eContainer();
		}
		if (belongsToParentActivity(firstNode, secondNode)) {
			return (Activity)firstNode.eContainer();
		}
		if (belongsToParentActivity(secondNode, firstNode)) {
			return (Activity)secondNode.eContainer();
		}
		if (inSiblingActivities(firstNode, secondNode)) {
			return (Activity)secondNode.eContainer().eContainer();
		}
		return null;
	}
	
	/**
	 * Checks if a transition's reconnection is valid
	 * @param transition Transition the user is trying to reconnect
	 * @param reconnectionSourceNode Source node of the reconnected transition
	 * @param reconnectionTargetNode Target node of the reconnected transition
	 * @return true if the reconnection can be done
	 */
	public boolean isTransitionReconnectionValid(Transition transition,
												Node reconnectionSourceNode, Node reconnectionTargetNode) {
		Node existingSourceNode = transition.getSource();
		Node existingTargetNode = transition.getTarget();
		if (reconnectionSourceNode.equals(existingSourceNode)) {
			// We're trying to reconnect the source of the edge
			return isTransitionValid(reconnectionTargetNode, existingTargetNode);
		} else if (reconnectionSourceNode.equals(existingTargetNode)) {
			// We're trying to reconnect the target of the edge
			return isTransitionValid(existingSourceNode, reconnectionTargetNode);
		}
		return false;
	}
	
	/**
	 * Indicates if a transition can be created between 2 nodes
	 * @param sourceNode The source node of the soon-to-be-created transition
	 * @param targetNode The target node of the soon-to-be-created transition
	 * @return true if the transition can be created, false otherwise
	 */
	public boolean isTransitionValid(Node sourceNode, Node targetNode) {
		if (sourceNode instanceof FinalNode || sourceNode instanceof AbortNode) {
			// An ending node can have transitions towards nodes of the parent activity
			// excepting InitialNodes
			if (belongsToChildActivity(sourceNode, targetNode) && !(targetNode instanceof InitialNode)) {
				return true;
			}
			// An ending node can have transitions towards InitialNode of a sibling activity
			if (inSiblingActivities(sourceNode, targetNode) && (targetNode instanceof InitialNode)) {
				return true;
			}
		} else {
			// Other nodes can have transitions towards nodes of the same activity
			// excepting InitialNodes
			if (inSameActivity(sourceNode, targetNode) && !(targetNode instanceof InitialNode)) {
				return true;
			}
			// Other nodes can have transitions towards InitialNode of a child activity
			if (belongsToParentActivity(sourceNode, targetNode) && (targetNode instanceof InitialNode)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Indicates if a transition is valid
	 * @param transition The transition to be tested
	 * @return true if the transition is valid
	 */
	public boolean isTransitionValid(Transition transition) {
		return isTransitionValid(transition.getSource(), transition.getTarget());
	}
	
	/**
	 * Checks if the first node's parent contains the second node's parent
	 * @param firstNode
	 * @param secondNode
	 * @return True if the parent of first node contains the parent of second node
	 */
	private boolean belongsToParentActivity(Node firstNode, Node secondNode) {
		return firstNode.eContainer().eContents().contains(secondNode.eContainer());
	}

	/**
	 * Checks if the second node's parent contains the first node's parent
	 * @param firstNode
	 * @param secondNode
	 * @return True if the parent of second node contains the parent of first node
	 */
	private boolean belongsToChildActivity(Node firstNode, Node secondNode) {
		return belongsToParentActivity(secondNode, firstNode);
	}
	
	/**
	 * Checks if two nodes have the same parent
	 * @param firstNode
	 * @param secondNode
	 * @return True if both node have the same parent
	 */
	private boolean inSameActivity(Node firstNode, Node secondNode) {
		return firstNode.eContainer().equals(secondNode.eContainer());
	}
	
	/**
	 * Checks if two nodes are in sibling activities
	 * @param firstNode
	 * @param secondNode
	 * @return True if both nodes parents have the same parent
	 */
	private boolean inSiblingActivities(Node firstNode, Node secondNode) {
		return (firstNode.eContainer().eContainer() != null)
			&& (secondNode.eContainer().eContainer() != null)
			&& (firstNode.eContainer().eContainer().equals(secondNode.eContainer().eContainer()));
	}
}
