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

<html:form action="/createlog/createlog" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="title"><bean:message key="CreateLog.title"/></label> :</td>
			<td><html:text property="title" /></td>
		</tr>
		<tr>
			<td><label for="content"><bean:message key="CreateLog.content"/></label> :</td>
			<td><html:textarea property="content" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="validate" onclick="bCancel=false;CreateLogForm.event.value = 'validate';">
				<bean:message key="CreateLog.validate"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>