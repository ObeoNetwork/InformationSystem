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

<html:form action="/scenarioprincipal/labels" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td colspan="2"><bean:message key="Labels.monLabe1l"/></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="Labels.monLabel2"/></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="Labels.monLabel3"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>