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

<html:form action="/createaccount/createaccount" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="firstName"><bean:message key="CreateAccount.firstName"/></label> :</td>
			<td><html:text property="firstName" /></td>
		</tr>
		<tr>
			<td><label for="lastName"><bean:message key="CreateAccount.lastName"/></label> :</td>
			<td><html:text property="lastName" /></td>
		</tr>
		<tr>
			<td><label for="email"><bean:message key="CreateAccount.email"/></label> :</td>
			<td><html:text property="email" /></td>
		</tr>
		<tr>
			<td><label for="login"><bean:message key="CreateAccount.login"/></label> :</td>
			<td><html:text property="login" /></td>
		</tr>
		<tr>
			<td><label for="password"><bean:message key="CreateAccount.password"/></label> :</td>
			<td><html:password property="password" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="validate" onclick="bCancel=false;CreateAccountForm.event.value = 'validate';">
				<bean:message key="CreateAccount.validate"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>