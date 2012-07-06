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

<html:form action="/scenarioprincipal/radiobuttons" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="radioButton1"><bean:message key="RadioButtons.radioButton1"/></label> :</td>
			<td><html:radio property="radioButton1" value="radioButton1"/></td>
		</tr>
		<tr>
			<td><label for="radioButton2"><bean:message key="RadioButtons.radioButton2"/></label> :</td>
			<td><html:radio property="radioButton2" value="radioButton2"/></td>
		</tr>
		<tr>
			<td><label for="radioButton3"><bean:message key="RadioButtons.radioButton3"/></label> :</td>
			<td><html:radio property="radioButton3" value="radioButton3"/></td>
		</tr>
		<tr>
			<td><label for="radioButton11"><bean:message key="RadioButtons.radioButton11"/></label> :</td>
			<td><html:radio property="radioButton11" value="radioButton11"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>