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

<html:form action="/scenarioprincipal/actions" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="action1" onclick="bCancel=false;ActionsForm.event.value = 'action1';">
				<bean:message key="Actions.action1"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="mon Action" onclick="bCancel=false;ActionsForm.event.value = 'monAction';">
				<bean:message key="Actions.monAction"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="monAutreAction" onclick="bCancel=false;ActionsForm.event.value = 'monAutreAction';">
				<bean:message key="Actions.monAutreAction"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>