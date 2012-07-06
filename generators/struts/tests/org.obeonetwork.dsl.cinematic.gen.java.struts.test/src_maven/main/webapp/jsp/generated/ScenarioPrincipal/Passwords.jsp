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

<html:form action="/scenarioprincipal/passwords" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="passWord1"><bean:message key="Passwords.passWord1"/></label> :</td>
			<td><html:password property="passWord1" /></td>
		</tr>
		<tr>
			<td><label for="passWord2"><bean:message key="Passwords.passWord2"/></label> :</td>
			<td><html:password property="passWord2" /></td>
		</tr>
		<tr>
			<td><label for="passWord3"><bean:message key="Passwords.passWord3"/></label> :</td>
			<td><html:password property="passWord3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>