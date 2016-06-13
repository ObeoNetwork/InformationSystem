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

<html:form action="/users/editaccount" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="email"><bean:message key="EditAccount.email"/></label> :</td>
			<td><html:text property="email" /></td>
		</tr>
		<tr>
			<td><label for="firstName"><bean:message key="EditAccount.firstName"/></label> :</td>
			<td><html:text property="firstName" /></td>
		</tr>
		<tr>
			<td><label for="lastName"><bean:message key="EditAccount.lastName"/></label> :</td>
			<td><html:text property="lastName" /></td>
		</tr>
		<tr>
			<td><label for="login"><bean:message key="EditAccount.login"/></label> :</td>
			<td><html:text property="login" /></td>
		</tr>
		<tr>
			<td><label for="password"><bean:message key="EditAccount.password"/></label> :</td>
			<td><html:password property="password" /></td>
		</tr>
		<tr>
			<td><label for="telephone"><bean:message key="EditAccount.telephone"/></label> :</td>
			<td><html:text property="telephone" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="validate" onclick="bCancel=false;EditAccountForm.event.value = 'validate';">
				<bean:message key="EditAccount.validate"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>