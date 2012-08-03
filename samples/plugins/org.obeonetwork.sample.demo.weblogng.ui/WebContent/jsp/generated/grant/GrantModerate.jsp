<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>
<%@ taglib
        uri="http://struts.apache.org/tags-logic"
        prefix="logic" %>
<%@ taglib 
        uri="http://displaytag.sf.net" 
        prefix="display" %>


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

<html:form action="/grant/grantmoderate" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="hidden"><bean:message key="GrantModerate.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/grant/grantmoderate?event=removeRight">
					<bean:message key="GrantModerate.remove"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/grant/grantmoderate?event=addRight">
					<bean:message key="GrantModerate.add"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="moderators"><bean:message key="GrantModerate.moderators"/></label> :</td>
			<td><logic:iterate name="GrantModerateForm" id="moderators_id" property="moderators" /></td>
		</tr>
		<tr>
			<td><label for="users"><bean:message key="GrantModerate.users"/></label> :</td>
			<td><logic:iterate name="GrantModerateForm" id="users_id" property="users" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="addRight" onclick="bCancel=false;GrantModerateForm.event.value = 'addRight';">
				<bean:message key="GrantModerate.addRight"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="showUsers" onclick="bCancel=false;GrantModerateForm.event.value = 'showUsers';">
				<bean:message key="GrantModerate.showUsers"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="removeRight" onclick="bCancel=false;GrantModerateForm.event.value = 'removeRight';">
				<bean:message key="GrantModerate.removeRight"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="showModerators" onclick="bCancel=false;GrantModerateForm.event.value = 'showModerators';">
				<bean:message key="GrantModerate.showModerators"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>