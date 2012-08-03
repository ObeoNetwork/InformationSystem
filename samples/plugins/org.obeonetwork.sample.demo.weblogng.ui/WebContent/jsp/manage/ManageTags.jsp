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

<html:form action="/manage/managetags" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="hidden"><bean:message key="ManageTags.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managetags?event=unspecified">
					<bean:message key="ManageTags.delete"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managetags?event=unspecified">
					<bean:message key="ManageTags.update"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managetags?event=unspecified">
					<bean:message key="ManageTags.remove"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="tags"><bean:message key="ManageTags.tags"/></label> :</td>
			<td><logic:iterate name="ManageTagsForm" id="tags_id" property="tags" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managetags?event=unspecified">
					<bean:message key="ManageTags.create"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managetags?event=unspecified">
					<bean:message key="ManageTags.add"/>
				</html:link>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>