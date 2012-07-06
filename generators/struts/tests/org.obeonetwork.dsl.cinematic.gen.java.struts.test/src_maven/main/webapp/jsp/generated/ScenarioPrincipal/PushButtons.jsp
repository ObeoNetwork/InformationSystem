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

<html:form action="/scenarioprincipal/pushbuttons" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="pushButton1"><bean:message key="PushButtons.pushButton1"/></label> :</td>
			<td><html:text property="pushButton1" /></td>
		</tr>
		<tr>
			<td><label for="pushButton2"><bean:message key="PushButtons.pushButton2"/></label> :</td>
			<td><html:text property="pushButton2" /></td>
		</tr>
		<tr>
			<td><label for="pushButton3"><bean:message key="PushButtons.pushButton3"/></label> :</td>
			<td><html:text property="pushButton3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>