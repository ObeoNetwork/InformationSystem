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

<html:form action="/users/login" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="login"><bean:message key="Login.login"/></label> :</td>
			<td><html:text property="login" /></td>
		</tr>
		<tr>
			<td><label for="password"><bean:message key="Login.password"/></label> :</td>
			<td><html:password property="password" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="createAccount" onclick="bCancel=false;LoginForm.event.value = 'createAccount';">
				<bean:message key="Login.createAccount"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="validate" onclick="bCancel=false;LoginForm.event.value = 'validate';">
				<bean:message key="Login.validate"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>