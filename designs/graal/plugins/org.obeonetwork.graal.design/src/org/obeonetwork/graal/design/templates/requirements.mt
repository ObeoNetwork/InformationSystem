<%
metamodel http://www.obeonetwork.org/dsl/requirement/1.0

import org.obeonetwork.graal.design.templates.tasks
%>

<%-- 
	Return the linked Task if exist using the "asTask" service
--%>
<%script type="requirement.Requirement" name="relatedTask"%>
<%referencedObject.asTask%>

<%-- 
	Try to interpret an object as a Task
	  - return this if the object is a Task
	  - Up the containing hierarchy to find a Task
	  - null otherwise
--%>
<%script type="ecore.EObject" name="asTask"%>
<%self.filter("Task") + self.eContainer("Task")%>

<%-- 
	Return the linked Task if exist using the "asTask" service
--%>
<%script type="requirement.Requirement" name="relatedUseCase"%>
<%referencedObject.asUseCase%>

<%-- 
	Try to interpret an object as an UseCase
	  - return this if the object is a UseCase
	  - return the UseCase associated to the group if the referencedObject
	 	can be interpreted as a group
	  - return the UseCase associated to the task if the referencedObject
	 	can be interpreted as a task 
	  - null otherwise
--%>
<%script type="ecore.EObject" name="asUseCase"%>
<%self.filter("UseCase") + self.filter("TasksGroup").getUseCase() + self.asTask.getUseCase()%>
