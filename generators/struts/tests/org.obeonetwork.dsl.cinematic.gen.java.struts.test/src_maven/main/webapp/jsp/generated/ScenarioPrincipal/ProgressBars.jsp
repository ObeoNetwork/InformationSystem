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

<html:form action="/scenarioprincipal/progressbars" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="progressBar1"><bean:message key="ProgressBars.progressBar1"/></label> :</td>
			<td><html:text property="progressBar1" /></td>
		</tr>
		<tr>
			<td><label for="progressBar2"><bean:message key="ProgressBars.progressBar2"/></label> :</td>
			<td><html:text property="progressBar2" /></td>
		</tr>
		<tr>
			<td><label for="progressBar3"><bean:message key="ProgressBars.progressBar3"/></label> :</td>
			<td><html:text property="progressBar3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>