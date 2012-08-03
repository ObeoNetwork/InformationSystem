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

<html:form action="/search/search" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td colspan="2"><bean:message key="Search.logHeader"/></td>
		</tr>
		<tr>
			<td><label for="searchField"><bean:message key="Search.searchField"/></label> :</td>
			<td><html:text property="searchField" /></td>
		</tr>
		<tr>
			<td><label for="logs"><bean:message key="Search.logs"/></label> :</td>
			<td><logic:iterate name="SearchForm" id="logs_id" property="logs" /></td>
		</tr>
		<tr>
			<td><label for="comments"><bean:message key="Search.comments"/></label> :</td>
			<td><logic:iterate name="SearchForm" id="comments_id" property="comments" /></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="Search.commentHeader"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>