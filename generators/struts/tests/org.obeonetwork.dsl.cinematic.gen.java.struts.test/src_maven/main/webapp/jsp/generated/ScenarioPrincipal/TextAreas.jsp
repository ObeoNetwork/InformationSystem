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

<html:form action="/scenarioprincipal/textareas" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="textArea1"><bean:message key="TextAreas.textArea1"/></label> :</td>
			<td><html:textarea property="textArea1" /></td>
		</tr>
		<tr>
			<td><label for="textArea2"><bean:message key="TextAreas.textArea2"/></label> :</td>
			<td><html:textarea property="textArea2" /></td>
		</tr>
		<tr>
			<td><label for="textArea3"><bean:message key="TextAreas.textArea3"/></label> :</td>
			<td><html:textarea property="textArea3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>