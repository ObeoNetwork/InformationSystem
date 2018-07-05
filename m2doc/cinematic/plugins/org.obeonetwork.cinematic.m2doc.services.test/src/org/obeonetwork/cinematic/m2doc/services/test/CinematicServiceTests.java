package org.obeonetwork.cinematic.m2doc.services.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.obeonetwork.cinematic.m2doc.services.CinematicServices;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.NamedFlowState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.m2doc.element.MImage;public class CinematicServiceTests {
	
	CinematicServices cs = new CinematicServices ();

	@Test
	public void testViewElementIsRequired () {
		ViewElement viewElement1 = (ViewElement) EcoreUtil.create(ViewPackage.Literals.VIEW_ELEMENT);		
		ViewElement viewElement2 = (ViewElement) EcoreUtil.create(ViewPackage.Literals.VIEW_ELEMENT);
		
		viewElement1.setRequired(true);
		viewElement2.setRequired(false);
		
		assertEquals("Oui", cs.isRequired(viewElement1));
		assertEquals("Non", cs.isRequired(viewElement2));
	}
	
	@Test
	public void testGetAnnotations () {
		FlowEvent flowEventNoMD = (FlowEvent) EcoreUtil.create(FlowPackage.Literals.FLOW_EVENT);
		FlowEvent flowEventEmptyMD = (FlowEvent) EcoreUtil.create(FlowPackage.Literals.FLOW_EVENT);
		FlowEvent flowEventWithMD = (FlowEvent) EcoreUtil.create(FlowPackage.Literals.FLOW_EVENT);
		
		MetaDataContainer mdc = (MetaDataContainer) EcoreUtil.create(EnvironmentPackage.Literals.META_DATA_CONTAINER);
		MetaDataContainer mdc2 = (MetaDataContainer) EcoreUtil.create(EnvironmentPackage.Literals.META_DATA_CONTAINER);
		
		flowEventEmptyMD.setMetadatas(mdc);
		flowEventWithMD.setMetadatas(mdc2);
		
		MetaData md1 = (MetaData) EcoreUtil.create(EnvironmentPackage.Literals.ANNOTATION);
		MetaData md2 = (MetaData) EcoreUtil.create(EnvironmentPackage.Literals.ANNOTATION);
		MetaData md3= (MetaData) EcoreUtil.create(EnvironmentPackage.Literals.ANNOTATION);
		
		mdc2.getMetadatas().add(md1);
		mdc2.getMetadatas().add(md2);
		mdc2.getMetadatas().add(md3);
		
		MetaData [] datas = {md1, md2, md3 };
		
		assertEquals(0, cs.getAnnotations(flowEventNoMD).size());
		assertEquals(0, cs.getAnnotations(flowEventEmptyMD).size());
		assertEquals(3, cs.getAnnotations(flowEventWithMD).size());
		assertArrayEquals(datas, cs.getAnnotations(flowEventWithMD).toArray());
	}

	@Test
	public void testGetCinematicIcon () {
		FlowEvent flowEvent = (FlowEvent) EcoreUtil.create(FlowPackage.Literals.FLOW_EVENT);
		MImage image = cs.cinematicIcon(flowEvent);
		assertNotNull(image);
		assertEquals(16, image.getWidth());
	}
	

	@Test
	public void testGetCinematicLabel () {
		FlowEvent flowEvent = (FlowEvent) EcoreUtil.create(FlowPackage.Literals.FLOW_EVENT);
		FlowAction flowAction =(FlowAction) EcoreUtil.create(FlowPackage.Literals.FLOW_ACTION);
		ViewContainer container =(ViewContainer) EcoreUtil.create(ViewPackage.Literals.VIEW_CONTAINER);
		
		final String baseName= "basename";
		container.setName (baseName);
		flowAction.setName(baseName);
		flowEvent.setName(baseName);
		
		assertEquals("basename : ViewContainer", cs.cinematicLabel(container));
		assertEquals(baseName, cs.cinematicLabel(flowAction));
		assertEquals(baseName, cs.cinematicLabel(flowEvent));
	}
	
	@Test
	public void testGetAllActionStatesWithOperations () {
		// instanciate all pieces
		CinematicRoot root = (CinematicRoot) EcoreUtil.create(CinematicPackage.Literals.CINEMATIC_ROOT);
		Flow emptyFlow1 = (Flow) EcoreUtil.create(FlowPackage.Literals.FLOW);
		Flow emptyFlow2 = (Flow) EcoreUtil.create(FlowPackage.Literals.FLOW);
		Flow FlowwithActions1 = (Flow) EcoreUtil.create(FlowPackage.Literals.FLOW);
		Flow FlowwithActions2 = (Flow) EcoreUtil.create(FlowPackage.Literals.FLOW);
		
		NamedFlowState abortState = (NamedFlowState) EcoreUtil.create(FlowPackage.Literals.ABORT_STATE);
		NamedFlowState actionState0 = (NamedFlowState) EcoreUtil.create(FlowPackage.Literals.ACTION_STATE);
		NamedFlowState actionState1 = (NamedFlowState) EcoreUtil.create(FlowPackage.Literals.ACTION_STATE);
		NamedFlowState actionState2 = (NamedFlowState) EcoreUtil.create(FlowPackage.Literals.ACTION_STATE);
		NamedFlowState decisionState = (NamedFlowState) EcoreUtil.create(FlowPackage.Literals.DECISION_STATE);
		
		FlowAction flowAction0 =(FlowAction) EcoreUtil.create(FlowPackage.Literals.FLOW_ACTION);
		FlowAction flowAction1 =(FlowAction) EcoreUtil.create(FlowPackage.Literals.FLOW_ACTION);
		FlowAction flowAction2 =(FlowAction) EcoreUtil.create(FlowPackage.Literals.FLOW_ACTION);
		
//		Action action1 = (Action) EcoreUtil.create(EnvironmentPackage.Literals.ACTION);
//		Action action2 = (Action) EcoreUtil.create(EnvironmentPackage.Literals.ACTION);
//		Action action3 = (Action) EcoreUtil.create(EnvironmentPackage.Literals.ACTION);
		
		
		// connecting up the puzzle
		root.getFlows().add(emptyFlow1);
		root.getFlows().add(emptyFlow2);
		root.getFlows().add(FlowwithActions1);
		root.getFlows().add(FlowwithActions2);
		
		FlowwithActions1.getStates().add(abortState);
		FlowwithActions1.getStates().add(actionState0);
		FlowwithActions1.getStates().add(actionState1);
		FlowwithActions2.getStates().add(actionState2);
		FlowwithActions2.getStates().add(decisionState);
		
		actionState1.getActions().add(flowAction0);
		actionState2.getActions().add(flowAction1);
		actionState2.getActions().add(flowAction2);
		
//		flowAction2.getOperations().add(action1);
//		flowAction2.getOperations().add(action2);
//		flowAction1.getOperations().add(action3);
		

		List<ActionState> result = cs.getAllActionStatesWithOperations(root);
		NamedFlowState [] expected = {actionState1, actionState2};
//		assertArrayEquals(expected, result.toArray());
	}
}
