package org.obeonetwork.dsl.interaction.design.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.CompoundEnd;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.StateInvariant;

public class DeleteServices {
	
	public void deleteCombinedFragment(CombinedFragment combinedFragment) {
		delete((Interaction) combinedFragment.eContainer(),
				combinedFragment.getStartingEnd(),
				combinedFragment.getFinishingEnd(),
				true,
				combinedFragment.getCoveredParticipants());
	}
	
    public void deleteOperand(Operand operand) {
        EObject result = operand.eContainer();
        if (result instanceof CombinedFragment) {
            CombinedFragment combinedFragment = (CombinedFragment) result;

            End startingEnd = operand.getStartingEnd();
            End finishingEnd = null;
            EList<Operand> siblings = combinedFragment.getOwnedOperands();
            if (siblings.size() == 1) {
                deleteCombinedFragment(combinedFragment);
                return;
            }
            int index = siblings.indexOf(operand);
            if (index == siblings.size() - 1) {
                // The last operand ends with the CF
                finishingEnd = combinedFragment.getFinishingEnd();
            } else {
                // Other operands ends when their successor starts
                finishingEnd = siblings.get(index + 1).getStartingEnd();
            }
            delete((Interaction) combinedFragment.eContainer(), startingEnd, finishingEnd, false, combinedFragment.getCoveredParticipants());
        }
        return;
    }
	
    private void delete(Interaction inter, End startingEnd, End finishingEnd, boolean deleteFinishingEnd, EList<Participant> coverage) {
        Set<EObject> toDelete = new HashSet<EObject>();

        boolean inside = false;
        for (End end : inter.getEnds()) {
            if (end == startingEnd) {
                toDelete.add(end);
                toDelete.add(end.getOwner());
                inside = true;
            } else if (end == finishingEnd) {
                if (deleteFinishingEnd) {
                    toDelete.add(end);
                    toDelete.add(end.getOwner());
                }
                break;
            } else if (inside && InteractionServices.covers(end, coverage)) {
                toDelete.add(end);
                toDelete.add(end.getOwner());
            }
        }

        for (EObject obj : toDelete) {
            EcoreUtil.delete(obj);
        }
    }
	
	public void deleteInteractionUse(InteractionUse interactionUse) {
		if (interactionUse == null) {
			return;
		}
		EcoreUtil.delete(interactionUse.getStartingEnd());
		EcoreUtil.delete(interactionUse.getFinishingEnd());
		EcoreUtil.delete(interactionUse, true);
	}
	
	public void deleteStateInvariant(StateInvariant stateInvariant) {
		if (stateInvariant == null) {
			return;
		}
		EcoreUtil.delete(stateInvariant.getStartingEnd());
		EcoreUtil.delete(stateInvariant.getFinishingEnd());
		EcoreUtil.delete(stateInvariant, true);
	}
	
	public void deleteExecution(Execution execution) {
		if (execution == null) {
			return;
		}
		deleteExecutionEnd(execution.getStartingEnd());
		deleteExecutionEnd(execution.getFinishingEnd());
		EcoreUtil.delete(execution, true);
	}
	
	private void deleteExecutionEnd(End executionEnd) {
		if (executionEnd != null) {
			if (executionEnd instanceof CompoundEnd) {
				CompoundEnd compoundExecutionEnd = (CompoundEnd)executionEnd;
				if (compoundExecutionEnd.isExecutionEnd() && compoundExecutionEnd.getExecution() != null) {
					compoundExecutionEnd.setOwner(null);
				} else {
					EcoreUtil.delete(compoundExecutionEnd, true);
				}
			} else {
				EcoreUtil.delete(executionEnd, true);
			}
		}
	}

	public void deleteMessage(Message message) {
		if (message == null) {
			return;
		}
		deleteMessageEnd(message.getStartingEnd());
		deleteMessageEnd(message.getFinishingEnd());
		EcoreUtil.delete(message, true);
	}
	
	private void deleteMessageEnd(End messageEnd) {
		if (messageEnd != null) {
			if (messageEnd instanceof CompoundEnd) {
				CompoundEnd compoundMessageEnd = (CompoundEnd)messageEnd;
				if (compoundMessageEnd.getOwner() == null) {
					EcoreUtil.delete(compoundMessageEnd, true);
				} else {
					compoundMessageEnd.setOtherOwner(null);
				}
			} else {
				EcoreUtil.delete(messageEnd, true);
			}
		}
	}
	
	public void deleteParticipant(Participant participant) {
		if (participant == null) {
			return;
		}
		
		// Delete all executions
		for (Execution execution : getExecutionsForParticipant(participant)) {
			deleteExecution(execution);
		}
		
		// Delete messages
		for (Message message : getMessagesForParticipant(participant)) {
			deleteMessage(message);
		}
		
		// Delete state invariants
		for (StateInvariant stateInvariant : getStateInvariantsForParticipant(participant)) {
			deleteStateInvariant(stateInvariant);
		}
		
		// Delete combined fragments
		for (CombinedFragment combinedFragment : getCombinedFragmentsForParticipant(participant)) {
			deleteCombinedFragment(combinedFragment);
		}
		
		// Delete interaction uses
		for (InteractionUse interactionUse : getInteractionUsesForParticipant(participant)) {
			deleteInteractionUse(interactionUse);
		}
		
		EcoreUtil.delete(participant, true);
	}
	
	private List<Execution> getExecutionsForParticipant(Participant participant) {
		Interaction interaction = (Interaction)participant.eContainer();
		List<Execution> result = new ArrayList<Execution>();
		for (Execution execution : interaction.getExecutions()) {
			if (participant.equals(execution.getOwner())) {
				result.add(execution);
			}
		}
		return result;
	}
	
	private List<Message> getMessagesForParticipant(Participant participant) {
		Interaction interaction = (Interaction)participant.eContainer();
		List<Message> result = new ArrayList<Message>();
		for (Message message : interaction.getMessages()) {
			if (message.getStartingEnd() != null
				&& participant.equals(message.getStartingEnd().getContext())) {
				result.add(message);
			} else if (message.getFinishingEnd() != null
				&& participant.equals(message.getFinishingEnd().getContext())) {
				result.add(message);
			}
		}
		return result;
	}
	
	private List<StateInvariant> getStateInvariantsForParticipant(Participant participant) {
		Interaction interaction = (Interaction)participant.eContainer();
		List<StateInvariant> result = new ArrayList<StateInvariant>();
		for (StateInvariant stateInvariant : interaction.getStateInvariants()) {
			if (participant.equals(stateInvariant.getOwner())) {
				result.add(stateInvariant);
			}
		}
		return result;
	}
	
	private List<CombinedFragment> getCombinedFragmentsForParticipant(Participant participant) {
		Interaction interaction = (Interaction)participant.eContainer();
		List<CombinedFragment> result = new ArrayList<CombinedFragment>();
		for (CombinedFragment combinedFragment : interaction.getCombinedFragments()) {
			if (combinedFragment.getCoveredParticipants().size() == 1
					&& combinedFragment.getCoveredParticipants().contains(participant)) {
				result.add(combinedFragment);
			}
		}
		return result;
	}
	
	private List<InteractionUse> getInteractionUsesForParticipant(Participant participant) {
		Interaction interaction = (Interaction)participant.eContainer();
		List<InteractionUse> result = new ArrayList<InteractionUse>();
		for (InteractionUse interactionUse : interaction.getInteractionUses()) {
			if (interactionUse.getCoveredParticipants().size() == 1
					&& interactionUse.getCoveredParticipants().contains(participant)) {
				result.add(interactionUse);
			}
		}
		return result;
	}
}
