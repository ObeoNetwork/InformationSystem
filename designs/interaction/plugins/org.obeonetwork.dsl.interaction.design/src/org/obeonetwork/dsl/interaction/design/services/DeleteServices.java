/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.design.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ext.emf.EReferencePredicate;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
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
		Session session = null;
		ModelAccessor modelAccessor = null;
        for (EObject obj : toDelete) {
        	if (session == null) {
        		session = SessionManager.INSTANCE.getSession(obj);
        	}
        	if (modelAccessor == null) {
        		modelAccessor = session.getModelAccessor();
        	}
        	delete(obj, session, modelAccessor);
        }
    }
	
	public void deleteInteractionUse(InteractionUse interactionUse) {
		if (interactionUse == null) {
			return;
		}
		Session session = SessionManager.INSTANCE.getSession(interactionUse);
		ModelAccessor modelAccessor = session.getModelAccessor();
		delete(interactionUse.getStartingEnd(), session, modelAccessor);
		delete(interactionUse.getFinishingEnd(), session, modelAccessor);
		delete(interactionUse, session, modelAccessor);
	}
	
	public void deleteStateInvariant(StateInvariant stateInvariant) {
		if (stateInvariant == null) {
			return;
		}
		Session session = SessionManager.INSTANCE.getSession(stateInvariant);
		ModelAccessor modelAccessor = session.getModelAccessor();
		delete(stateInvariant.getStartingEnd(), session, modelAccessor);
		delete(stateInvariant.getFinishingEnd(), session, modelAccessor);
		delete(stateInvariant, session, modelAccessor);
	}
	
	public void deleteExecution(Execution execution) {
		if (execution == null) {
			return;
		}
		Session session = SessionManager.INSTANCE.getSession(execution);
		ModelAccessor modelAccessor = session.getModelAccessor();
		deleteExecutionEnd(execution.getStartingEnd(), session, modelAccessor);
		deleteExecutionEnd(execution.getFinishingEnd(), session, modelAccessor);
		delete(execution, session, modelAccessor);
	}
	
	private void deleteExecutionEnd(End executionEnd, Session session, ModelAccessor modelAccessor) {
		if (executionEnd != null) {
			if (executionEnd instanceof CompoundEnd) {
				CompoundEnd compoundExecutionEnd = (CompoundEnd)executionEnd;
				if (compoundExecutionEnd.isExecutionEnd() && compoundExecutionEnd.getExecution() != null) {
					compoundExecutionEnd.setOwner(null);
				} else {
					delete(compoundExecutionEnd, session, modelAccessor);
				}
			} else {
				delete(executionEnd, session, modelAccessor);
			}
		}
	}

	public void deleteMessage(Message message) {
		if (message == null) {
			return;
		}
		Session session = SessionManager.INSTANCE.getSession(message);
		ModelAccessor modelAccessor = session.getModelAccessor();
		deleteMessageEnd(message.getStartingEnd(), session, modelAccessor);
		deleteMessageEnd(message.getFinishingEnd(), session, modelAccessor);
		delete(message, session, modelAccessor);
	}
	
	private void deleteMessageEnd(End messageEnd, Session session, ModelAccessor modelAccessor) {
		if (messageEnd != null) {
			if (messageEnd instanceof CompoundEnd) {
				CompoundEnd compoundMessageEnd = (CompoundEnd)messageEnd;
				if (compoundMessageEnd.getOwner() == null) {
					delete(compoundMessageEnd, session, modelAccessor);
				} else {
					compoundMessageEnd.setOtherOwner(null);
				}
			} else {
				delete(messageEnd, session, modelAccessor);
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
		
		delete(participant);
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
	
	public static void delete(EObject object, Session session, ModelAccessor modelAccessor) {
		Session vpSession = session;
		ModelAccessor vpModelAccessor = modelAccessor;
		if (vpSession == null) {
			vpSession = SessionManager.INSTANCE.getSession(object);
		}
		if (vpModelAccessor == null) {
			vpModelAccessor = vpSession.getModelAccessor();
		}
		vpModelAccessor.eDelete(object, vpSession.getSemanticCrossReferencer(), new EReferencePredicate() {
	        public boolean apply(EReference reference) {
	            return DSemanticDecorator.class.isAssignableFrom(reference.getContainerClass());
	        }
	    });
	}
	
	public static void delete(EObject object, Session session) {
		delete(object, session, null);
	}

	public static void delete(EObject object) {
		delete(object, null, null);
	}
}
