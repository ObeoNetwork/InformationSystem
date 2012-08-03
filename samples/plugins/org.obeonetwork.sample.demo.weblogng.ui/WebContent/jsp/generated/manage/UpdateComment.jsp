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

<html:form action="/manage/updatecomment" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="content"><bean:message key="UpdateComment.content"/></label> :</td>
			<td><html:textarea property="content" /></td>
		</tr>
		<tr>
			<td><label for="email"><bean:message key="UpdateComment.email"/></label> :</td>
			<td><html:text property="email" /></td>
		</tr>
		<tr>
			<td><label for="website"><bean:message key="UpdateComment.website"/></label> :</td>
			<td><html:text property="website" /></td>
		</tr>
		<tr>
			<td><label for="name"><bean:message key="UpdateComment.name"/></label> :</td>
			<td><html:text property="name" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>