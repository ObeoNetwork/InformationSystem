<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>
<%@ taglib
        uri="http://struts.apache.org/tags-logic"
        prefix="logic" %>


<logic:messagesPresent>
   <bean:message key="errors.header"/>
   <ul>
   <html:messages id="error">
      <li><bean:write name="error"/></li>
   </html:messages>
   </ul>
   <bean:message key="errors.footer"/>
   <hr />
</logic:messagesPresent>

<html:form action="/viewlogs/viewlogs" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	<!-- 
	<dd><strong>Name: </strong><bean:write name="ViewLogsForm" property="user"/></dd>  
	-->
	<logic:iterate name="ViewLogsForm" id="log" property="logs">
		<h2 class="date-header">
	 		<bean:write name="log" property="creationDateAsText"/>
	 	</h2>
	  	<!-- Begin .post -->
	  	<div class="post"><a name="<bean:write name="log" property="id"/>"></a>     
	    <h3 class="post-title"><bean:write name="log" property="title"/></h3>
	    <div class="post-body">
	    	<p><bean:write name="log" property="content"/></p>    
	    </div>
	 	<p class="post-footer">
	 		posté par <bean:write name="log" property="author"/>
	 		à <bean:write name="log" property="creationTimeAsText"/>
		</p>  
	  </div>
	</logic:iterate>
	<hr/>
<!--
	<table>
		<tr>
			<td><label for="message"><bean:message key="ViewLogs.message"/></label> :</td>
			<td><html:text property="message" /></td>
		</tr>
		<tr>
			<td><label for="user"><bean:message key="ViewLogs.user"/></label> :</td>
			<td><html:text property="user" /></td>
		</tr>
		<tr>
			<td><label for="logs"><bean:message key="ViewLogs.logs"/></label> :</td>
			<td><logic:iterate name="ViewLogsForm" id="logs_id" property="logs" /></td>
		</tr>
	</table>
-->
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="login" onclick="bCancel=false;ViewLogsForm.event.value = 'login';">
				<bean:message key="ViewLogs.login"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="editAccount" onclick="bCancel=false;ViewLogsForm.event.value = 'editAccount';">
				<bean:message key="ViewLogs.editAccount"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="createLog" onclick="bCancel=false;ViewLogsForm.event.value = 'createLog';">
				<bean:message key="ViewLogs.createLog"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="reload" onclick="bCancel=false;ViewLogsForm.event.value = 'reload';">
				<bean:message key="ViewLogs.reload"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="logout" onclick="bCancel=false;ViewLogsForm.event.value = 'logout';">
				<bean:message key="ViewLogs.logout"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>