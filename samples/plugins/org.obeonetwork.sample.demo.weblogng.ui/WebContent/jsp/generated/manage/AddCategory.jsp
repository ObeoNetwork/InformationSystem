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

<html:form action="/manage/addcategory" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="categoryDescription"><bean:message key="AddCategory.categoryDescription"/></label> :</td>
			<td><logic:iterate name="AddCategoryForm" id="categoryDescription_id" property="categoryDescription" /></td>
		</tr>
		<tr>
			<td><label for="logs"><bean:message key="AddCategory.logs"/></label> :</td>
			<td><logic:iterate name="AddCategoryForm" id="logs_id" property="logs" /></td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="AddCategory.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/addcategory?event=unspecified">
					<bean:message key="AddCategory.select"/>
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