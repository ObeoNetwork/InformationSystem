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

<html:form action="/scenarioprincipal/displaylists" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="displayList1"><bean:message key="DisplayLists.displayList1"/></label> :</td>
			<td><logic:iterate name="DisplayListsForm" id="displayList1_id" property="displayList1" /></td>
		</tr>
		<tr>
			<td><label for="displayList2"><bean:message key="DisplayLists.displayList2"/></label> :</td>
			<td><logic:iterate name="DisplayListsForm" id="displayList2_id" property="displayList2" /></td>
		</tr>
		<tr>
			<td><label for="displayList3"><bean:message key="DisplayLists.displayList3"/></label> :</td>
			<td><logic:iterate name="DisplayListsForm" id="displayList3_id" property="displayList3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>