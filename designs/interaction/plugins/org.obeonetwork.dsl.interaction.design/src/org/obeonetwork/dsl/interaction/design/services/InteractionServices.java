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
package org.obeonetwork.dsl.interaction.design.services;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;
import org.eclipse.sirius.ecore.extender.business.api.permission.LockStatus;
import org.eclipse.sirius.ecore.extender.business.api.permission.PermissionAuthorityRegistry;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.DestroyParticipantMessage;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.StateInvariant;
import org.obeonetwork.dsl.interaction.design.Activator;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionParentSelectionContentProvider;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionParentSelectionLabelProvider;
import org.obeonetwork.is.eef.custom.reference.CustomEEFExtEObjectSelectionWizard;

/**
 * Java services for the sample 'Interaction' sequence diagrams.
 * 
 * @author Obeo
 */
public class InteractionServices {
	
	public List<EObject> getAllRootsInSession(EObject context) {
		List<EObject> rootObjects = new ArrayList<EObject>();
		Session session = SessionManager.INSTANCE.getSession(context);
		if (session != null) {
			for (Resource semanticResource : session.getSemanticResources()) {
				rootObjects.addAll(semanticResource.getContents());
			}
		}
		return rootObjects;
	}
	
	public List<Interaction> getAllInteractionsInSession(EObject context) {
		List<Interaction> allInteractions = new ArrayList<Interaction>();
		List<EObject> roots = getAllRootsInSession(context);
		for (EObject root : roots) {
			for (Iterator<EObject> i = root.eAllContents(); i.hasNext(); ) {
				EObject object = i.next();
				if (object instanceof Interaction) {
					allInteractions.add((Interaction)object);
				}
			}
		}
		return allInteractions;
	}
	
	public Operand computePredecessorForOperand(Operand operand) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(operand.getStartingEnd());
		
		// The predecessor is the last Operand found amongst the preceding operands for the same combined fragment
		Operand predecessor = null;
		for (End end : precedingEnds) {
			if (end.isOperandEnd() && end.isStartingEnd()
					&& operand.eContainer().equals(end.getOperand().eContainer())) {
				predecessor = end.getOperand();
			}
		}
		
		return predecessor;
	}
	
	public CombinedFragment computePredecessorForCombinedFragment(CombinedFragment combinedFragment) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(combinedFragment.getStartingEnd());
		
		// The predecessor is the last CombinedFragment found amongst the preceding combined fragments
		CombinedFragment predecessor = null;
		for (End end : precedingEnds) {
			if (end.isCombinedFragmentEnd() && end.isStartingEnd()) {
				predecessor = end.getCombinedFragment();
			}
		}
		
		return predecessor;
	}
	
	public InteractionUse computePredecessorForInteractionUse(InteractionUse interactionUse) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(interactionUse.getStartingEnd());
		
		// The predecessor is the last InteractionUse found amongst the preceding interaction uses
		InteractionUse predecessor = null;
		for (End end : precedingEnds) {
			if (end.isInteractionUseEnd() && end.isStartingEnd()) {
				predecessor = end.getInteractionUse();
			}
		}
		
		return predecessor;
	}
	
	public Message computePredecessorForMessage(Message message) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(message.getStartingEnd());
		
		// The predecessor is the last Message found amongst the preceding messages
		Message predecessor = null;
		for (End end : precedingEnds) {
			if (end.isMessageEnd() && end.isFinishingEnd()) {
				predecessor = end.getMessage();
			}
		}
		
		return predecessor;
	}

	public StateInvariant computePredecessorForStateInvariant(StateInvariant stateInvariant) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(stateInvariant.getStartingEnd());
		
		// The predecessor is the last StateInvariant found amongst the preceding state invariants
		StateInvariant predecessor = null;
		for (End end : precedingEnds) {
			if (end.isStateInvariantEnd() && end.isStartingEnd()) {
				predecessor = end.getStateInvariant();
			}
		}
		
		return predecessor;
	}
	
	public Execution computePredecessorForExecution(Execution execution) {
		// Get the preceding end
		List<End> precedingEnds = getPrecedingEnds(execution.getStartingEnd());
		
		// The predecessor is the last Execution found amongst the preceding executions
		Execution predecessor = null;
		for (End end : precedingEnds) {
			if (end.isExecutionEnd() && end.isStartingEnd()) {
				predecessor = end.getExecution();
			}
		}		
		
		return predecessor;
	}
	
	private List<End> getPrecedingEnds(End end){
		List<End> result = new ArrayList<End>();
		
		Interaction interaction = (Interaction)end.eContainer();
		for (End siblingEnd : interaction.getEnds()) {
			if (!end.equals(siblingEnd)) {
				result.add(siblingEnd);
			} else {
				return result;
			}
		}
		
		return result;
	}
	
    /**
     * Helper class to keep track of who "contains" who depending on the
     * interleaving of the start/finish ends.
     * 
     * @author Obeo
     * @see InteractionServices#computeContainmentStructure(Participant)
     */
    private static final class EventContext {
        private final EObject parent;

        private final boolean start;

        private final InteractionFragment element;

        private final int level;

        public EventContext(EObject parent, InteractionFragment element, boolean start, int level) {
            this.parent = parent;
            this.element = element;
            this.level = level;
            this.start = start;
        }

        public boolean isStart() {
            return start;
        }

        public EObject getParent() {
            return parent;
        }

        public InteractionFragment getElement() {
            return element;
        }

        @SuppressWarnings("unused")
        public int getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return String.format("%02d\t%s\t%s", level, element, parent);
        }
    }

    /**
     * Computes the semantic elements corresponding to the events directly below
     * the specified parent on a given lifelines. This is necessary because the
     * VSM expects a tree-like structure for mappings, but in an 'Interactions'
     * model, the events corresponding to the start/finish of
     * execution/messages/etc. are stored in a linear structure.
     * 
     * @param context
     *            the participant/lifeline on which to look.
     * @param parent
     *            the semantic element of the parent event.
     * @return the semantic elements of all the direct sub-events of
     *         <code>parent</code> on the given participant. The order is not
     *         specified.
     */
    public Collection<InteractionFragment> getDirectEventsOn(Participant context, EObject parent) {
    	List<EventContext> structure = computeContainmentStructure(context);
        LinkedHashSet<InteractionFragment> events = new LinkedHashSet<InteractionFragment>();
        for (EventContext ec : structure) {
            if (ec.getParent().equals(parent) && ec.getElement() != parent) {
                events.add(ec.getElement());
            }
        }
        return events;
    }

    /**
     * Returns the event end which represents the finishing of an operand. An
     * operand only has a starting end in the model. Its finishing end must be
     * inferred from the context. If the operand is the last operand in the
     * Combined Fragment, it finishes with the end of the CF. Otherwise it
     * finished when the next operand starts.
     * 
     * @param operand
     *            the operand.
     * @return the event end which represents the finishing of the operand.
     */
//    public AbstractEnd getFinishingEnd(Operand operand) {
//        AbstractEnd result = null;
//        EObject eContainer = operand.eContainer();
//
//        if (eContainer instanceof CombinedFragment) {
//            CombinedFragment cf = (CombinedFragment) eContainer;
//            result = cf.getFinish();
//
//            Operand prev = null;
//            for (Operand op : cf.getOwnedOperands()) {
//                if (operand.equals(prev)) {
//                    result = op.getStart();
//                    break;
//                } else {
//                    prev = op;
//                }
//            }
//        }
//
//        return result;
//    }

    /**
     * Returns the semantic element corresponding to the source of a message.
     * This can be a participant or an execution.
     * 
     * @param msg
     *            the message.
     * @return the semantic elements corresponding to the source of the message.
     */
    public EObject getSendingContext(Message msg) {
        End sendingEnd = msg.getStartingEnd();
        if (sendingEnd != null) {
            Participant p = sendingEnd.getContext();
            List<EventContext> structure = computeContainmentStructure(p);
            for (EventContext ec : structure) {
                if (ec.getElement().equals(msg) && ec.isStart()) {
                    EObject parent = ec.getParent();
                    if (parent != null) {
                        return parent;
                    } else {
                        return p;
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Returns the semantic element corresponding to the target of a message.
     * This can be a participant, execution or an instance role.
     * 
     * @param msg
     *            the message.
     * @return the semantic elements corresponding to the target of the message.
     */
    public EObject getReceivingContext(Message msg) {
        End receivingEnd = msg.getFinishingEnd();
        if (receivingEnd != null) {
            Participant p = receivingEnd.getContext();
            List<EventContext> structure = computeContainmentStructure(p);
            for (EventContext ec : structure) {
                if (ec.getElement().equals(msg) && !ec.isStart()) {
                    EObject parent = ec.getParent();
                    if (parent != null) {
                        return parent;
                    } else {
                        return p;
                    }
                }
            }
        }
        return msg;
    }
    
    private List<EventContext> computeContainmentStructure(Participant owner) {
        if (!(owner.eContainer() instanceof Interaction)) {
            return Collections.emptyList();
        } else {
            Interaction interaction = (Interaction) owner.eContainer();
            Stack<EObject> ancestors = new Stack<EObject>();
            ancestors.push(owner);
            List<EventContext> result = new ArrayList<EventContext>();
            for (End end : interaction.getEnds()) {
                if (end.getContext() != owner) {
                    continue;
                }

                if (end.isStartingEnd() && end.isExecutionEnd()) {
                    result.add(new EventContext(ancestors.peek(), end.getExecution(), true, ancestors.size() + 1));
                    ancestors.push(end.getExecution());
                }
                
                if (end.isStartingEnd() && end.isStateInvariantEnd()) {
                    result.add(new EventContext(ancestors.peek(), end.getStateInvariant(), true, ancestors.size() + 1));
                    ancestors.push(end.getStateInvariant());
                }
                
                if (end.isMessageEnd()) {
                    Message msg = end.getMessage();
                    if (msg != null) {
                        result.add(new EventContext(ancestors.peek(), end.getMessage(), end.equals(msg.getStartingEnd()), ancestors.size()));
                    }
                }

                if (end.isFinishingEnd() && end.isExecutionEnd()) {
                    ancestors.pop();
                    result.add(new EventContext(ancestors.peek(), end.getExecution(), false, ancestors.size() + 1));
                }
                
                if (end.isFinishingEnd() && (end.isStateInvariantEnd())) {
                    ancestors.pop();
                    result.add(new EventContext(ancestors.peek(), end.getStateInvariant(), false, ancestors.size() + 1));
                }
            }
            return result;
        }
    }

    /**
     * Compute the depth of a combined fragment. If the EObject if not a
     * combined fragment, this method return 0.
     * 
     * @param eobject
     *            the EObject to find the depth if it is a combined fragment
     * @param nbOfColors Total number of colors
     * @return the depth if it is a combined fragment.
     */
    public int computeCombinedFragmentDepth(EObject eobject, int nbOfColors) {
        int combinedFragmentDepth = 0;
        if (eobject instanceof CombinedFragment) {
            CombinedFragment currentCombinedFragment = (CombinedFragment) eobject;
            EList<Participant> coveredParticipants = currentCombinedFragment.getCoveredParticipants();
            End start = currentCombinedFragment.getStartingEnd();
            EObject eContainer = start.eContainer();
            EList<EObject> eContents = eContainer.eContents();
            int startIndex = eContents.lastIndexOf(start);

            List<EObject> contents = eContents.subList(0, startIndex);
            for (EObject obj : contents) {
                if (obj instanceof End) {
                	End end = (End) obj;
                    if (end.isCombinedFragmentEnd()) {
	                    CombinedFragment combinedFragment = end.getCombinedFragment();
	                    if (covers(end, coveredParticipants)) {
	                        if (combinedFragment.getStartingEnd().equals(end)) {
	                            combinedFragmentDepth++;
	                        } else if (combinedFragment.getFinishingEnd().equals(end)) {
	                            combinedFragmentDepth--;
	                        }
	                    }
                    }
                }
            }
        }

        return getColorDepth(combinedFragmentDepth, nbOfColors);
    }
    
    /**
     * Computes the depth of an Execution. If the EObject is not an Execution,
     * this method returns 0.
     * 
     * @param eobject the EObject to find the depth if it is an Execution
     * @param nbOfColors Total number of colors
     * @return the depth if it is an Execution.
     */
    public int computeExecutionDepth(EObject eobject, int nbOfColors) {
        int executionDepth = 0;
        if (eobject instanceof Execution) {
            Execution currentExecution = (Execution) eobject;
            Participant currentLifeline = currentExecution.getOwner();
            End start = currentExecution.getStartingEnd();
            EObject eContainer = start.eContainer();
            EList<EObject> eContents = eContainer.eContents();
            int startIndex = eContents.lastIndexOf(start);

            List<EObject> contents = eContents.subList(0, startIndex);
            for (EObject obj : contents) {
                if (obj instanceof End) {
                    End end = (End) obj;
                    if (end.isExecutionEnd()) {
                    	Execution execution = end.getExecution();
                    	if (currentLifeline != null && execution != null && currentLifeline.equals(execution.getOwner())) {
                    		if (execution.getStartingEnd().equals(end)) {
                    			executionDepth++;
                    		} else if (execution.getFinishingEnd().equals(end)) {
                    			executionDepth--;
                    		}
                    	}
                    }
                }
            }
        }
        return getColorDepth(executionDepth, nbOfColors);
    }
    
    /**
     * Get the color corresponding to a depth in interpolated colors
     * @param absoluteDepth Depth
     * @param nbOfColors Total number of colors
     * @return the color number corresponding to the depth
     */
    private int getColorDepth(int absoluteDepth, int nbOfColors) {
    	// We defined 10 levels for colors in the vsm
    	// Avoid to have two consecutive levels with same color :
    	int mod = absoluteDepth % nbOfColors;
    	int qot = absoluteDepth / nbOfColors;
    	if (qot % 2 != 0) {
    		mod = nbOfColors - mod;
    	}
    	return mod;
    }

    /**
     * Returns true if the fragment associated to the end concerns at least one of the specified participants
     * @param end
     * @param participants
     * @return
     */
    static public boolean covers(End end, Collection<Participant> participants) {
        if (end.isExecutionEnd() || end.isMessageEnd()) {
            return participants.contains(end.getContext());
        } else if (end.isCombinedFragmentEnd()) {
            Set<Participant> covered = new HashSet<Participant>(end.getCombinedFragment().getCoveredParticipants());
            covered.retainAll(participants);
            return !covered.isEmpty();
        } else if (end.isInteractionUseEnd()) {
            Set<Participant> covered = new HashSet<Participant>(end.getInteractionUse().getCoveredParticipants());
            covered.retainAll(participants);
            return !covered.isEmpty();
        } else if (end.isOperandEnd()) {
            Set<Participant> covered = new HashSet<Participant>(((CombinedFragment)end.getOperand().eContainer()).getCoveredParticipants());
            covered.retainAll(participants);
            return !covered.isEmpty();
        } else {
            return false;
        }
    }   
    
    /**
     * Retrieve the current participant.
     * @param context the context on which is applied the service
     * @return The participant.
     */
    public Participant currentParticipant(Participant context){
    	return context;
    }
    
    /**
     * Retrieve the current participant.
     * @param context the context on which is applied the service
     * @return The participant.
     */
    public Participant currentParticipant(End context){
    	return context.getContext();
    }
    
    /**
     * Retrieve the current participant.
     * @param context the context on which is applied the service
     * @return The participant.
     */
    public Participant currentParticipant(Execution context){
    	return context.getOwner();
    }
    
    /**
     * Retrieve the current participant.
     * @param context the context on which is applied the service
     * @return The participant.
     */
    public Participant currentParticipant(StateInvariant context){
    	return context.getOwner();
    }
    
    /**
     * Return true if the context is pointed by a DestroyParticipantMessage.
     * @param context the context on which is applied the service
     * @return boolean, true if the context is pointed by a DestroyParticipantMessage, false otherwise
     */
    public boolean isPointedByDestroyMessage(Participant context){
    	boolean isPointedByDestroyMessage = false;
    	Interaction interaction = null;    	
    	EObject container = context.eContainer();
    	while (container != null){
    		if( container instanceof Interaction){
    			interaction = (Interaction)container;
    			//loop output
    			container = null;
    		}else{
    			container = container.eContainer();
    		}
    	}
    	if (interaction != null){
    		List<Message> messages = interaction.getMessages();
    		List<DestroyParticipantMessage> destroyParticipantMesssages = new ArrayList<DestroyParticipantMessage>();
    		for (Message message : messages){
    			// Retrieve DestroParticipantMessage
    			if (message instanceof DestroyParticipantMessage){
    				destroyParticipantMesssages.add((DestroyParticipantMessage)message);
    			}
    		}
    		for (DestroyParticipantMessage destroyParticipantMessage : destroyParticipantMesssages){
    			// Retrieve the finishingEnd that the context is the same as parameter
    			if (destroyParticipantMessage.getFinishingEnd().getContext() == context){
    				isPointedByDestroyMessage = true;
    			}
    		}    			
    	}
    	return isPointedByDestroyMessage;
    }
    
    /**
     * Create the label for the graphical participant element. 
     * @param context the context which is applied the service
     * @return the label participant
     */
    public String getParticipantLabel(Participant context){
    	// Retrive the participant name
    	String label = context.getName();
    	// If a type is defined construct the label as name:type.name(type) 
    	if (context.getType() != null){
    		label = label.concat(":");
    		label = label.concat("\n");
    		Class<?> classType = context.getType().getClass();
    		Method[] allMethods = classType.getMethods();
    		for (Method method : allMethods) {
    			String methodName = method.getName();
    			if (methodName.contains("Name") && method.getParameterTypes().length == 0){
    				try {
    					label = label.concat(method.invoke(context.getType()).toString());
    				} catch (IllegalArgumentException e) {							
    					e.printStackTrace();
    				} catch (IllegalAccessException e) {							
    					e.printStackTrace();
    				} catch (InvocationTargetException e) {							
    					e.printStackTrace();
    				}
    			}
    		}
    		label = label.concat(" (");
    		label = label.concat(context.getType().eClass().getName());
    		label = label.concat(")");
    	}
    	return label;
    } 

    /**
     * Change the parent of an interaction with a selected one 
     * @param interaction
     * @return
     */
    public Interaction changeParentForInteraction(final Interaction interaction) {
    	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    	
    	AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    	InteractionParentSelectionLabelProvider labelProvider = new InteractionParentSelectionLabelProvider(adapterFactory);
    	InteractionParentSelectionContentProvider contentProvider = new InteractionParentSelectionContentProvider(adapterFactory);
    	ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(shell, labelProvider, contentProvider);
    	dlg.setHelpAvailable(false);
    	dlg.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				Object selectedObject = selection[0];
				if (selectedObject instanceof EObject) {
					IPermissionAuthority authority = PermissionAuthorityRegistry.getDefault().getPermissionAuthority((EObject)selectedObject);
					if (authority != null) {
						LockStatus lockStatus = authority.getLockStatus((EObject)selectedObject);
						if (LockStatus.LOCKED_BY_OTHER.equals(lockStatus)) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "This element is locked by another user");
						}
					}
				}
				return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
			}
		});
    	
    	dlg.setTitle("Change interaction's parent");
    	dlg.setMessage("Select the new parent for the interaction");
    	
    	Session session = SessionManager.INSTANCE.getSession(interaction);
		if (session == null) {
			return interaction;
		}
		dlg.setInput(session.getSemanticResources().toArray());
		dlg.setInitialSelection(interaction.eContainer());
    	
    	int btn = dlg.open();
    	if (btn == Dialog.OK) {
    		Object selectedElement = dlg.getFirstResult();
    		if (selectedElement instanceof ObeoDSMObject && selectedElement != interaction.eContainer()) {
    			// Change the parent
    			((ObeoDSMObject)selectedElement).getBehaviours().add(interaction);
    		}
    	}
    	
    	return interaction;
    }
    
    public EObject getPredecessor(EObject context, EObject predecessor){
    	if (predecessor != null){
    		return predecessor;
    	} else { 
    		return null;
    	}
    }
    
	/**
	 * Prompts the user, through a wizard modal dialog, to select an
	 * {@link ObeoDSMObject} with the intention that it will be
	 * {@link Participant#setType(ObeoDSMObject) set as the type of} the given
	 * {@link Participant}.
	 * 
	 * @param participant the (non-{@code null}) {@link Participant} for which we
	 *                    want to select an {@link ObeoDSMObject}.
	 * @return the (non-{@code null}) {@link ObeoDSMObject} selected by the user
	 *         through the UI if the dialog was closed with the 'OK' button.
	 *         {@code null} if the dialog was closed with the 'Cancel' button.
	 */
	public static ObeoDSMObject promptUserToSelectParticipantType(final Participant participant) {
		Objects.requireNonNull(participant);

		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		final CustomEEFExtEObjectSelectionWizard wizard = new CustomEEFExtEObjectSelectionWizard(participant,
				InteractionPackage.Literals.PARTICIPANT__TYPE, (EditingContextAdapter) null);
		final WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		if (Window.OK == wizardDialog.open()) {
			return (ObeoDSMObject) wizard.getResult().get(0);
		} else {
			return null;
		}
	}
       
}
