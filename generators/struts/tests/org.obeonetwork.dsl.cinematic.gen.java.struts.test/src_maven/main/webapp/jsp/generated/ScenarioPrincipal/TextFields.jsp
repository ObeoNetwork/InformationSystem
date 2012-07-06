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

<html:javascript formName="TextFieldsForm" staticJavascript="false" />
<html:form action="/scenarioprincipal/textfields" method="POST" onsubmit="return validateTextFieldsForm(this)">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="textField1"><bean:message key="TextFields.textField1"/></label> :</td>
			<td><html:text property="textField1" /></td>
		</tr>
		<tr>
			<td><label for="textField2"><bean:message key="TextFields.textField2"/></label> :</td>
			<td><html:text property="textField2" /></td>
		</tr>
		<tr>
			<td><label for="textField3"><bean:message key="TextFields.textField3"/></label> :</td>
			<td><html:text property="textField3" /></td>
		</tr>
		<tr>
			<td><label for="boolean_"><bean:message key="TextFields.boolean_"/></label> :</td>
			<td><html:text property="boolean_" /></td>
		</tr>
		<tr>
			<td><label for="date"><bean:message key="TextFields.date"/></label> :</td>
			<td><html:text property="date" /></td>
		</tr>
		<tr>
			<td><label for="double_"><bean:message key="TextFields.double_"/></label> :</td>
			<td><html:text property="double_" /></td>
		</tr>
		<tr>
			<td><label for="mail"><bean:message key="TextFields.mail"/></label> :</td>
			<td><html:text property="mail" /></td>
		</tr>
		<tr>
			<td><label for="unnamed"><bean:message key="TextFields.unnamed"/></label> :</td>
			<td><html:text property="unnamed" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>