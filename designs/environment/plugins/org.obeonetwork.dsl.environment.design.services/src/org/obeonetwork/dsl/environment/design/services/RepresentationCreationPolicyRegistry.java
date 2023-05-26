package org.obeonetwork.dsl.environment.design.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class RepresentationCreationPolicyRegistry {
	
	private static List<Predicate<ObeoDSMObject>> STATEMACHINE_PREDICATES = new ArrayList<>();
	
	public static void registerStatemachineCreationPolicy(Predicate<ObeoDSMObject> statemachineCreationPolicy) {
		STATEMACHINE_PREDICATES.add(statemachineCreationPolicy);
	}
	
	public static boolean isEligibleForStatemachine(ObeoDSMObject element) {
		return !STATEMACHINE_PREDICATES.stream().anyMatch(p -> !p.test(element));
	}

	private static List<Predicate<ObeoDSMObject>> INTERACTION_PREDICATES = new ArrayList<>();
	
	public static void registerInteractionCreationPolicy(Predicate<ObeoDSMObject> interactionCreationPolicy) {
		INTERACTION_PREDICATES.add(interactionCreationPolicy);
	}
	
	public static boolean isEligibleForInteraction(ObeoDSMObject element) {
		return !INTERACTION_PREDICATES.stream().anyMatch(p -> !p.test(element));
	}

}
