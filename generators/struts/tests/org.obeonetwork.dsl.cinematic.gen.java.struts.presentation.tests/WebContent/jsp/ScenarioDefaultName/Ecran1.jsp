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

<html:form action="/scenariodefaultname/ecran1" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td colspan="2"><bean:message key="Ecran1.label1"/></td>
		</tr>
		<tr>
			<td><label for="textFiel1"><bean:message key="Ecran1.textfiel1"/></label> :</td>
			<td><html:text property="textFiel1" /></td>
		</tr>
		<tr>
			<td><label for="combobox1"><bean:message key="Ecran1.combobox1"/></label> :</td>
			<td>
				<html:select property="combobox1">
					<html:options property="combobox1Values"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td><label for="password1"><bean:message key="Ecran1.password1"/></label> :</td>
			<td><html:password property="password1" /></td>
		</tr>
		<tr>
			<td><label for="checkbox1"><bean:message key="Ecran1.checkbox1"/></label> :</td>
			<td><html:checkbox property="checkbox1" /></td>
		</tr>
		<tr>
			<td><label for="radio1"><bean:message key="Ecran1.radio1"/></label> :</td>
			<td><html:radio property="radio1" value="radio1"/></td>
		</tr>
		<tr>
			<td><label for="slider1"><bean:message key="Ecran1.slider1"/></label> :</td>
			<td><html:text property="slider1" /></td>
		</tr>
		<tr>
			<td><label for="push1"><bean:message key="Ecran1.push1"/></label> :</td>
			<td><html:text property="push1" /></td>
		</tr>
		<tr>
			<td><label for="toogle1"><bean:message key="Ecran1.toogle1"/></label> :</td>
			<td><html:text property="toogle1" /></td>
		</tr>
		<tr>
			<td><label for="button1"><bean:message key="Ecran1.button1"/></label> :</td>
			<td><html:text property="button1" /></td>
		</tr>
		<tr>
			<td>DisplayList1 :</td>
			<td><logic:iterate name="Ecran1Form" id="displayList1_id" property="displayList1" /></td>
		</tr>
		<tr>
			<td><label for="canvas1"><bean:message key="Ecran1.canvas1"/></label> :</td>
			<td><html:text property="canvas1" /></td>
		</tr>
		<tr>
			<td><label for="link1"><bean:message key="Ecran1.link1"/></label> :</td>
			<td><html:text property="link1" /></td>
		</tr>
		<tr>
			<td><label for="textArea"><bean:message key="Ecran1.textarea"/></label> :</td>
			<td><html:textarea property="textArea" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="action1" value="action1" onclick="bCancel=false;Ecran1Form.event.value = 'action1';"/>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>