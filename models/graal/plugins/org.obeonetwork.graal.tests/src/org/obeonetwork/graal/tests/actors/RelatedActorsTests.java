package org.obeonetwork.graal.tests.actors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;

public class RelatedActorsTests {
	
	private System s;
	private Actor a1;
	private Actor a2;
	private Actor a3;
	private Actor a4;
	private Actor a5;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Load Graal package
		GraalPackage.eINSTANCE.eClass();
	}

	@Test
	public void directActorsOnTask() {
		 initSystem();
		 Task t1 = addTask(s, "T1", a1);
		 Task t2 = addTask(s, "T2");
		 assertActors(s, a1);
		 assertActors(t1, a1);
		 assertActors(t2);
		 
		 addUse(t1, t2);
		 assertActors(s, a1);
		 assertActors(t1, a1);
		 assertActors(t2, a1);

		 addActor(t2, a2);
		 assertActors(s, a1, a2);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 
		 Task t3 = addTask(s, "T3", a3);
		 addUse(t2, t3);
		 assertActors(s, a1, a2, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 
		 Task t4 = addTask(s, "T4");
		 assertActors(s, a1, a2, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 assertActors(t4);
		 
		 addUse(t3, t4);
		 assertActors(s, a1, a2, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 assertActors(t4, a3);
		 
		 addUse(t2, t4);
		 assertActors(s, a1, a2, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 assertActors(t4, a2, a3);
		 
		 t2.getActors().remove(a2);
		 assertActors(s, a1, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a1);
		 assertActors(t3, a3);
		 assertActors(t4, a1, a3);
		 
		 TasksGroup g1 = addGroup(s, "G1");
		 g1.getTasks().add(t3);
		 g1.getTasks().add(t4);
		 assertActors(s, a1, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a1);
		 assertActors(t3, a3);
		 assertActors(t4, a1, a3);
		 assertActors(g1, a1, a3);
		 
		 addActor(t2, a2);
		 assertActors(s, a1, a2, a3);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 assertActors(t4, a2, a3);
		 assertActors(g1, a2, a3);
		 
		 Task t5 = addTask(g1, "T5", a4);
		 addUse(t3, t5);
		 assertActors(s, a1, a2, a3, a4);
		 assertActors(t1, a1);
		 assertActors(t2, a2);
		 assertActors(t3, a3);
		 assertActors(t4, a2, a3);
		 assertActors(t5, a4);
		 assertActors(g1, a2, a3, a4);
		 
		 t1.getActors().remove(a1);
		 t3.getActors().remove(a3);
		 assertActors(s, a2, a4);
		 assertActors(t1);
		 assertActors(t2, a2);
		 assertActors(t3, a2);
		 assertActors(t4, a2);
		 assertActors(t5, a4);
		 assertActors(g1, a2, a4);
		 
		 TasksGroup g2 = addGroup(g1, "G2");
		 g2.getTasks().add(t3);
		 g2.getTasks().add(t5);
		 assertActors(s, a2, a4);
		 assertActors(t1);
		 assertActors(t2, a2);
		 assertActors(t3, a2);
		 assertActors(t4, a2);
		 assertActors(t5, a4);
		 assertActors(g1, a2, a4);
		 assertActors(g2, a2, a4);
		 
		 
	}
	
	private AbstractTask addActor(Task task, Actor actor) {
		task.getActors().add(actor);
		return task;
	}
	
	private void addUse(Task usingTask, Task usedTask) {
		usingTask.getUses().add(usedTask);
	}
	
	private TasksGroup addGroup(TasksContainer container, String name) {
		TasksGroup group = GraalFactory.eINSTANCE.createTasksGroup();
		group.setName(name);
		container.getTasks().add(group);
		return group;
	}
	
	private Task addTask(TasksContainer container, String name, Actor... actors) {
		Task task = GraalFactory.eINSTANCE.createTask();
		task.setName(name);
		container.getTasks().add(task);
		for (Actor actor : actors) {
			addActor(task, actor);
		}
		return task;
	}

	private void assertActors(GraalObject object, Actor... actors) {
		List<Actor> actualActors = getActors(object);
		assertEquals(actualActors.size(), actors.length);
		for (Actor actor : actors) {
			assertTrue(actualActors.contains(actor));
		}
	}
	
	private List<Actor> getActors(GraalObject object) {
		if (object instanceof Task) {
			return ((Task) object).getRelatedActors();
		} else if (object instanceof TasksGroup) {
			return ((TasksGroup) object).getRelatedActors();
		} else if (object instanceof System) {
			return ((System) object).getRelatedActors();
		}
		return null;
	}
	
	private void initSystem() {
		s = GraalFactory.eINSTANCE.createSystem();
		a1 = GraalFactory.eINSTANCE.createActor();
		a1.setName("actor1");
		a2 = GraalFactory.eINSTANCE.createActor();
		a2.setName("actor2");
		a3 = GraalFactory.eINSTANCE.createActor();
		a3.setName("actor3");
		a4 = GraalFactory.eINSTANCE.createActor();
		a4.setName("actor4");
		a5 = GraalFactory.eINSTANCE.createActor();
		a5.setName("actor5");
		s.getActors().add(a1);
		s.getActors().add(a2);
		s.getActors().add(a3);
		s.getActors().add(a4);
		s.getActors().add(a5);
	}
}
