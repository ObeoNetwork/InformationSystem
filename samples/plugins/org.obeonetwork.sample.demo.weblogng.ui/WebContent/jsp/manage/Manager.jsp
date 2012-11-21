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

<html:form action="/manage/manager" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td>
				<html:link action="/manage/manager?event=unspecified">
					<bean:message key="Manager.screenDeleteUser"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/manager?event=unspecified">
					<bean:message key="Manager.screenManageComments"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/manager?event=unspecified">
					<bean:message key="Manager.screenManageCategories"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<html:link action="/manage/manager?event=unspecified">
					<bean:message key="Manager.screenManageTags"/>
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