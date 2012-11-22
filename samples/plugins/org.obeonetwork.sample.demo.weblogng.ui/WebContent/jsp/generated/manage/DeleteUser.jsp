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

<html:form action="/manage/deleteuser" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="users"><bean:message key="DeleteUser.users"/></label> :</td>
			<td><logic:iterate name="DeleteUserForm" id="users_id" property="users" /></td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="DeleteUser.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/deleteuser?event=unspecified">
					<bean:message key="DeleteUser.delete"/>
				</html:link>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>