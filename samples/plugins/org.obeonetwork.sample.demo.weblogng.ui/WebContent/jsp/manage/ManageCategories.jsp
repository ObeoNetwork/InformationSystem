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

<html:form action="/manage/managecategories" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="categories"><bean:message key="ManageCategories.categories"/></label> :</td>
			<td><logic:iterate name="ManageCategoriesForm" id="categories_id" property="categories" /></td>
		</tr>
		<tr>
			<td><label for="hidden"><bean:message key="ManageCategories.hidden"/></label> :</td>
			<td><html:text property="hidden" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managecategories?event=unspecified">
					<bean:message key="ManageCategories.create"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managecategories?event=unspecified">
					<bean:message key="ManageCategories.update"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managecategories?event=unspecified">
					<bean:message key="ManageCategories.delete"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managecategories?event=unspecified">
					<bean:message key="ManageCategories.add"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/managecategories?event=unspecified">
					<bean:message key="ManageCategories.remove"/>
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