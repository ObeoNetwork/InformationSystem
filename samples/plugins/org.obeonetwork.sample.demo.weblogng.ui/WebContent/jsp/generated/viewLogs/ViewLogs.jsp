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
	
	<table>
		<tr>
			<td><label for="logs"><bean:message key="ViewLogs.logs"/></label> :</td>
			<td><logic:iterate name="ViewLogsForm" id="logs_id" property="logs" /></td>
		</tr>
		<tr>
			<td><label for="message"><bean:message key="ViewLogs.message"/></label> :</td>
			<td><html:text property="message" /></td>
		</tr>
		<tr>
			<td><label for="user"><bean:message key="ViewLogs.user"/></label> :</td>
			<td><html:text property="user" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/viewlogs/viewlogs?event=addComment">
					<bean:message key="ViewLogs.comments"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="categories"><bean:message key="ViewLogs.categories"/></label> :</td>
			<td><logic:iterate name="ViewLogsForm" id="categories_id" property="categories" /></td>
		</tr>
		<tr>
			<td><label for="tags"><bean:message key="ViewLogs.tags"/></label> :</td>
			<td><logic:iterate name="ViewLogsForm" id="tags_id" property="tags" /></td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="ViewLogs.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="reload" onclick="bCancel=false;ViewLogsForm.event.value = 'reload';">
				<bean:message key="ViewLogs.reload"/>
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
				<html:submit property="logout" onclick="bCancel=false;ViewLogsForm.event.value = 'logout';">
				<bean:message key="ViewLogs.logout"/>
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
				<html:submit property="login" onclick="bCancel=false;ViewLogsForm.event.value = 'login';">
				<bean:message key="ViewLogs.login"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="viewComments" onclick="bCancel=false;ViewLogsForm.event.value = 'viewComments';">
				<bean:message key="ViewLogs.viewComments"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="addComment" onclick="bCancel=false;ViewLogsForm.event.value = 'addComment';">
				<bean:message key="ViewLogs.addComment"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>