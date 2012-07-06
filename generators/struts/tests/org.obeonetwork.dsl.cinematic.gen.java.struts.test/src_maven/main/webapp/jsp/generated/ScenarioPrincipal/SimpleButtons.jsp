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

<html:form action="/scenarioprincipal/simplebuttons" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="simpleButton1"><bean:message key="SimpleButtons.simpleButton1"/></label> :</td>
			<td><html:text property="simpleButton1" /></td>
		</tr>
		<tr>
			<td><label for="simpleButton2"><bean:message key="SimpleButtons.simpleButton2"/></label> :</td>
			<td><html:text property="simpleButton2" /></td>
		</tr>
		<tr>
			<td><label for="simpleButton3"><bean:message key="SimpleButtons.simpleButton3"/></label> :</td>
			<td><html:text property="simpleButton3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>