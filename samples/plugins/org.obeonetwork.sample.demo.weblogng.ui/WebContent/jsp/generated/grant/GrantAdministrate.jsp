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

<html:form action="/grant/grantadministrate" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="users"><bean:message key="GrantAdministrate.users"/></label> :</td>
			<td><logic:iterate name="GrantAdministrateForm" id="users_id" property="users" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/grant/grantadministrate?event=addRight">
					<bean:message key="GrantAdministrate.add"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="GrantAdministrate.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td><label for="moderators"><bean:message key="GrantAdministrate.moderators"/></label> :</td>
			<td><logic:iterate name="GrantAdministrateForm" id="moderators_id" property="moderators" /></td>
		</tr>
		<tr>
			<td><label for="admins"><bean:message key="GrantAdministrate.admins"/></label> :</td>
			<td><logic:iterate name="GrantAdministrateForm" id="admins_id" property="admins" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/grant/grantadministrate?event=removeRight">
					<bean:message key="GrantAdministrate.remove"/>
				</html:link>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="addRight" onclick="bCancel=false;GrantAdministrateForm.event.value = 'addRight';">
				<bean:message key="GrantAdministrate.addRight"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="removeRight" onclick="bCancel=false;GrantAdministrateForm.event.value = 'removeRight';">
				<bean:message key="GrantAdministrate.removeRight"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="showUsers" onclick="bCancel=false;GrantAdministrateForm.event.value = 'showUsers';">
				<bean:message key="GrantAdministrate.showUsers"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="showModerators" onclick="bCancel=false;GrantAdministrateForm.event.value = 'showModerators';">
				<bean:message key="GrantAdministrate.showModerators"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="showAdmins" onclick="bCancel=false;GrantAdministrateForm.event.value = 'showAdmins';">
				<bean:message key="GrantAdministrate.showAdmins"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>