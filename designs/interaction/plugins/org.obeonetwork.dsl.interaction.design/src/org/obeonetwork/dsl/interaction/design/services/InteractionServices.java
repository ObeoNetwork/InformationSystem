package org.obeonetwork.dsl.interaction.design.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFragment;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.StateInvariant;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;

/**
 * Java services for the sample 'Interaction' sequence diagrams.
 * 
 * @author sthibaudeau
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
     * @author pcdavid
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

    /**
     * Delete a combined fragments, including all the events it contains.
     * 
     * @param obj
     *            the combined fragment to delete.
     * @return the parent of the fragment deleted.
     */
//    public EObject deleteCombinedFragment(CombinedFragment cf) {
//        EObject result = cf.eContainer();
//        delete((Interaction) cf.eContainer(), cf.getStart(), cf.getFinish(), true, cf.getCoveredParticipants());
//        return result;
//    }

    /**
     * Delete an operand, including all the events it contains. Does nothing if
     * the operand is the only one in the fragment, as this would produce an
     * invalid interaction.
     * 
     * @param oper
     *            the operand to delete.
     * @return the parent of the operand deleted.
     */
//    public EObject deleteOperand(Operand oper) {
//        EObject result = oper.eContainer();
//        if (result instanceof CombinedFragment) {
//            CombinedFragment cf = (CombinedFragment) result;
//
//            OperandEnd startingEnd = oper.getStart();
//            AbstractEnd finishingEnd = null;
//            EList<Operand> siblings = cf.getOwnedOperands();
//            if (siblings.size() == 1) {
//                // Do nothing it asked to delete the only operand in a CF.
//                return result;
//            }
//            int index = siblings.indexOf(oper);
//            assert index != -1 : "inconsistent model";
//            if (index == siblings.size() - 1) {
//                // The last operand ends with the CF
//                finishingEnd = cf.getFinish();
//            } else {
//                // Other operands ends when their successor starts
//                finishingEnd = siblings.get(index + 1).getStart();
//            }
//            delete((Interaction) cf.eContainer(), startingEnd, finishingEnd, false, cf.getCoveredParticipants());
//        }
//        return result;
//    }

    /**
     * Delete all the events of an interaction inside a range of event ends.
     * 
     * @param inter
     *            the interaction from which to delete elements.
     * @param startingEnd
     *            the starting of the range of events to delete.
     * @param finishingEnd
     *            the finishing of the range of events to delete.
     * @param deleteFinishingEnd
     *            whether to delete the finishing end (and the corresponding
     *            event) or to stop just before.
     * @param coverage
     *            the participants from which to delete events. Events which
     *            happen in the specified range but strictly on participants
     *            outside this list will not be deleted.
     */
//    public void delete(Interaction inter, AbstractEnd startingEnd, AbstractEnd finishingEnd, boolean deleteFinishingEnd, EList<Participant> coverage) {
//        Set<EObject> toDelete = new HashSet<EObject>();
//
//        boolean inside = false;
//        for (AbstractEnd end : inter.getEnds()) {
//            if (end == startingEnd) {
//                toDelete.add(end);
//                toDelete.add(getOwnerEvent(end));
//                inside = true;
//            } else if (end == finishingEnd) {
//                if (deleteFinishingEnd) {
//                    toDelete.add(end);
//                    toDelete.add(getOwnerEvent(end));
//                }
//                break;
//            } else if (inside && covers(end, coverage)) {
//                toDelete.add(end);
//                toDelete.add(getOwnerEvent(end));
//            }
//        }
//
//        for (EObject obj : toDelete) {
//            EcoreUtil.delete(obj);
//        }
//    }

//    public EObject getOwnerEvent(AbstractEnd end) {
//        if (end instanceof ExecutionEnd) {
//            return ((ExecutionEnd) end).getExecution();
//        } else if (end instanceof MessageEnd) {
//            return ((MessageEnd) end).getMessage();
////        } else if (end instanceof CombinedFragmentEnd) {
////            return ((CombinedFragmentEnd) end).getOwner();
////        } else if (end instanceof InteractionUseEnd) {
////            return ((InteractionUseEnd) end).getOwner();
////        } else if (end instanceof OperandEnd) {
////            return ((OperandEnd) end).getOwner();
//        } else {
//            assert false : "unhandled kind of AbstractEnd";
//            return null;
//        }
//    }

//    public boolean covers(AbstractEnd end, Collection<Participant> participants) {
//        if (end instanceof ExecutionEnd) {
//            return participants.contains(((ExecutionEnd) end).getContext());
//        } else if (end instanceof MessageEnd) {
//            return participants.contains(((MessageEnd) end).getContext());
////        } else if (end instanceof CombinedFragmentEnd) {
////            Set<Participant> covered = new HashSet<Participant>(((CombinedFragmentEnd) end).getOwner().getCoveredParticipants());
////            covered.retainAll(participants);
////            return !covered.isEmpty();
////        } else if (end instanceof InteractionUseEnd) {
////            Set<Participant> covered = new HashSet<Participant>(((InteractionUseEnd) end).getOwner().getCoveredParticipants());
////            covered.retainAll(participants);
////            return !covered.isEmpty();
////        } else if (end instanceof OperandEnd) {
////            Set<Participant> covered = new HashSet<Participant>(((CombinedFragment) ((OperandEnd) end).getOwner().eContainer()).getCoveredParticipants());
////            covered.retainAll(participants);
////            return !covered.isEmpty();
//        } else {
//            assert false : "unhandled kind of AbstractEnd";
//            return false;
//        }
//    }
    
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
//
//    public boolean isStartingExecutionEnd(AbstractEnd end) {
//        if (end instanceof ExecutionEnd) {
//            ExecutionEnd ee = (ExecutionEnd) end;
//            return ee.getExecution() != null && ee.getExecution().getStart() == end;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isFinishingExecutionEnd(AbstractEnd end) {
//        if (end instanceof ExecutionEnd) {
//            ExecutionEnd ee = (ExecutionEnd) end;
//            return ee.getExecution() != null && ee.getExecution().getEnd() == end;
//        } else {
//            return false;
//        }
//    }

//    public boolean isStartingStateEnd(AbstractEnd end) {
//        if (end instanceof StateEnd) {
//            StateEnd ee = (StateEnd) end;
//            return ee.getState() != null && ee.getState().getStart() == end;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean isFinishingStateEnd(AbstractEnd end) {
//        if (end instanceof StateEnd) {
//            StateEnd ee = (StateEnd) end;
//            return ee.getState() != null && ee.getState().getEnd() == end;
//        } else {
//            return false;
//        }
//    }

    /**
     * Compute the depth of a combined fragment. If the EObject if not a
     * combined fragment, this method return 0.
     * 
     * @param eobject
     *            the EObject to find the depth if it is a combined fragment
     * @return the depth if it is a combined fragment.
     */
//    public int computeCombinedFragmentDepth(EObject eobject) {
//        int combinedFragmentDepth = 0;
//        if (eobject instanceof CombinedFragment) {
//            CombinedFragment currentCombinedFragment = (CombinedFragment) eobject;
//            EList<Participant> coveredParticipants = currentCombinedFragment.getCoveredParticipants();
//            CombinedFragmentEnd start = currentCombinedFragment.getStart();
//            EObject eContainer = start.eContainer();
//            EList<EObject> eContents = eContainer.eContents();
//            int startIndex = eContents.lastIndexOf(start);
//
//            List<EObject> contents = eContents.subList(0, startIndex);
//            for (EObject obj : contents) {
//                if (obj instanceof CombinedFragmentEnd) {
//                    CombinedFragmentEnd combinedFragmentEnd = (CombinedFragmentEnd) obj;
//                    CombinedFragment combinedFragment = combinedFragmentEnd.getOwner();
//                    if (covers(combinedFragmentEnd, coveredParticipants)) {
//                        if (combinedFragment.getStart().equals(combinedFragmentEnd)) {
//                            combinedFragmentDepth++;
//                        } else if (combinedFragment.getFinish().equals(combinedFragmentEnd)) {
//                            combinedFragmentDepth--;
//                        }
//                    }
//                }
//            }
//        }
//
//        return getModuloDepth(combinedFragmentDepth, 5);
//    }
//

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
     * Check if the current participant can be created, regarding the end before
     * click.
     * 
     * @param eobject
     *            the EObject to find the depth if it is an Execution
     * @return the depth if it is an Execution.
     */
//    public boolean canCreate(Participant participant, EObject endBefore) {
//        boolean result = false;
//        if (participant != null && participant.eContainer() instanceof Interaction) {
//            result = true;
//            AbstractEnd semanticEndBefore = getSemanticEnd(endBefore);
//            if (semanticEndBefore != null) {
//                for (AbstractEnd end : ((Interaction) participant.eContainer()).getEnds()) {
//                    result = participant != end.getContext();
//                    if (!result || end == semanticEndBefore) {
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    /**
     * Check if the current participant can be destroyed, regarding the end
     * before click.
     * 
     * @param eobject
     *            the EObject to find the depth if it is an Execution
     * @return the depth if it is an Execution.
     */
//    public boolean canDestroy(Participant participant, EObject endBefore) {
//        boolean result = false;
//        if (participant != null && participant.eContainer() instanceof Interaction) {
//            result = true;
//            AbstractEnd semanticEndBefore = getSemanticEnd(endBefore);
//            List<AbstractEnd> ends = new ArrayList<AbstractEnd>(((Interaction) participant.eContainer()).getEnds());
//            Collections.reverse(ends);
//            for (AbstractEnd end : ends) {
//                if (end != semanticEndBefore) {
//                    result = participant != end.getContext();
//                }
//
//                if (!result || end == semanticEndBefore) {
//                    break;
//                }
//            }
//        }
//        return result;
//    }

//    private AbstractEnd getSemanticEnd(EObject endBefore) {
//        if (endBefore instanceof EventEnd && ((EventEnd) endBefore).getSemanticEnd() instanceof AbstractEnd) {
//            return (AbstractEnd) ((EventEnd) endBefore).getSemanticEnd();
//        }
//        return null;
//    }
}
