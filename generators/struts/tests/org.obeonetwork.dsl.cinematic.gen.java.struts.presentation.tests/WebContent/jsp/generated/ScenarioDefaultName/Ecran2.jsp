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

<html:form action="/scenariodefaultname/ecran2" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<display:table name="Ecran2Form.table2" requestURI="" class="list" id="idTable2">
			<display:column property="table2_Combobox1" title="Table2_Combobox1" />	
			<display:column property="table2_Password1" title="Table2_Password1" />	
			<display:column property="table2_Checkbox1" title="Table2_Checkbox1" />	
			<display:column property="table2_Radio1" title="Table2_Radio1" />	
			<display:column property="table2_DisplayList1" title="Table2_DisplayList1" />	
			<display:column property="table2_TextField1" title="Table2_TextField1" />	
			<display:column property="table2_TextArea1" title="Table2_TextArea1" />	
		</display:table>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="action2" onclick="bCancel=false;Ecran2Form.event.value = 'action2';">
				<bean:message key="Ecran2.action2"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>