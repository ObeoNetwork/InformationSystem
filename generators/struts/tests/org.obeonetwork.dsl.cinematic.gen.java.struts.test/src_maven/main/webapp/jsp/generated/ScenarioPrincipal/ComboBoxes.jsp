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

<html:form action="/scenarioprincipal/comboboxes" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="comboBox1"><bean:message key="ComboBoxes.comboBox1"/></label> :</td>
			<td>
				<html:select property="comboBox1">
					<html:options property="comboBox1Values"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td><label for="comboBox2"><bean:message key="ComboBoxes.comboBox2"/></label> :</td>
			<td>
				<html:select property="comboBox2">
					<html:options property="comboBox2Values"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td><label for="comboBox3"><bean:message key="ComboBoxes.comboBox3"/></label> :</td>
			<td>
				<html:select property="comboBox3">
					<html:options property="comboBox3Values"/>
				</html:select>
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