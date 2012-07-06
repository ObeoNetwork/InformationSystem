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

<html:form action="/scenarioprincipal/canvas" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="myCanvas1"><bean:message key="Canvas.myCanvas1"/></label> :</td>
			<td><html:text property="myCanvas1" /></td>
		</tr>
		<tr>
			<td><label for="myCanvas2"><bean:message key="Canvas.myCanvas2"/></label> :</td>
			<td><html:text property="myCanvas2" /></td>
		</tr>
		<tr>
			<td><label for="myCanvas3"><bean:message key="Canvas.myCanvas3"/></label> :</td>
			<td><html:text property="myCanvas3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>