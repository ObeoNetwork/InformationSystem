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

<html:form action="/scenariodefaultname/ecran3" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<display:table name="Ecran3Form.table3" requestURI="" class="list" id="idTable3">
			<display:column property="table3_TextField1" title="Table3_TextField1" />	
		</display:table>
		<tr>
			<td><label for="textField3"><bean:message key="Ecran3.textfield3"/></label> :</td>
			<td><html:text property="textField3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>