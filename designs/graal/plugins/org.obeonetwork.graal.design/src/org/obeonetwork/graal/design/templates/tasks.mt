<%
metamodel http://www.obeonetwork.org/dsl/graal/2.0.0
%>

<%script type="graal.AbstractTask" name="tasksAndGroupsUsed"%>
<%tasksUsed + groupsUsed%>

<%script type="graal.AbstractTask" name="groupsUsed"%>
<%null%>

<%script type="graal.Task" name="groupsUsed"%>
<%((uses.eContainer("TasksGroup") + uses.eContainer("TasksGroup").ancestor().filter("TasksGroup").nMinimize) - eContainer("TasksGroup")).nMinimize%>

<%script type="graal.TasksGroup" name="groupsUsed"%>
<%((tasks.groupsUsed - current).nMinimize) - current%>

<%script type="graal.AbstractTask" name="tasksUsed"%>
<%null%>

<%script type="graal.Task" name="tasksUsed"%>
<%uses%>

<%script type="graal.TasksGroup" name="tasksUsed"%>
<%(tasks.tasksUsed - tasks).nMinimize%>

<%script type="graal.UseCase" name="allTasks"%>
<%tasks.filter("Task") + tasks.filter("TasksGroup").eAllContents("Task")%>
