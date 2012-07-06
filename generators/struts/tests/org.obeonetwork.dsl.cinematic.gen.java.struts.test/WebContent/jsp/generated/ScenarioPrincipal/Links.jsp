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

<html:form action="/scenarioprincipal/links" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=unspecified">
					<bean:message key="Links.myLink1"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=unspecified">
					<bean:message key="Links.myLink2"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=unspecified">
					<bean:message key="Links.myLink3"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=anAction">
					<bean:message key="Links.anActionLink"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=anAction">
					<bean:message key="Links.anActionLink1"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=anotherAction">
					<bean:message key="Links.anotherActionLink"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/links?event=anAction">
					<bean:message key="Links.allActionsLink"/>
				</html:link>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="anAction" onclick="bCancel=false;LinksForm.event.value = 'anAction';">
				<bean:message key="Links.anAction"/>
				</html:submit>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit property="anotherAction" onclick="bCancel=false;LinksForm.event.value = 'anotherAction';">
				<bean:message key="Links.anotherAction"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>