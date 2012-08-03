<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>
<%@ taglib
        uri="http://struts.apache.org/tags-logic"
        prefix="logic" %>
<%@ taglib 
        uri="http://displaytag.sf.net" 
        prefix="display" %>


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

<html:form action="/manage/addtag" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="logs"><bean:message key="AddTag.logs"/></label> :</td>
			<td><logic:iterate name="AddTagForm" id="logs_id" property="logs" /></td>
		</tr>
		<tr>
			<td><label for="tagDescription"><bean:message key="AddTag.tagDescription"/></label> :</td>
			<td><logic:iterate name="AddTagForm" id="tagDescription_id" property="tagDescription" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/addtag?event=unspecified">
					<bean:message key="AddTag.select"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="AddTag.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>