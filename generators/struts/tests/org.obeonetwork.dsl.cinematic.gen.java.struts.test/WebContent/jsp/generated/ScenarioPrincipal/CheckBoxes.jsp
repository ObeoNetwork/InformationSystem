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

<html:form action="/scenarioprincipal/checkboxes" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="checkBox1"><bean:message key="CheckBoxes.checkBox1"/></label> :</td>
			<td><html:checkbox property="checkBox1" /></td>
		</tr>
		<tr>
			<td><label for="checkBox2"><bean:message key="CheckBoxes.checkBox2"/></label> :</td>
			<td><html:checkbox property="checkBox2" /></td>
		</tr>
		<tr>
			<td><label for="checkBox3"><bean:message key="CheckBoxes.checkBox3"/></label> :</td>
			<td><html:checkbox property="checkBox3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>