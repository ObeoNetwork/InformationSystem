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

<html:form action="/scenarioprincipal/allinone" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="combo"><bean:message key="AllInOne.combo"/></label> :</td>
			<td>
				<html:select property="combo">
					<html:options property="comboValues"/>
				</html:select>
			</td>
		</tr>
		<tr>
			<td><label for="password"><bean:message key="AllInOne.password"/></label> :</td>
			<td><html:password property="password" /></td>
		</tr>
		<tr>
			<td><label for="check"><bean:message key="AllInOne.check"/></label> :</td>
			<td><html:checkbox property="check" /></td>
		</tr>
		<tr>
			<td><label for="radio"><bean:message key="AllInOne.radio"/></label> :</td>
			<td><html:radio property="radio" value="radio"/></td>
		</tr>
		<tr>
			<td><label for="display"><bean:message key="AllInOne.display"/></label> :</td>
			<td><logic:iterate name="AllInOneForm" id="display_id" property="display" /></td>
		</tr>
		<tr>
			<td><label for="textfield"><bean:message key="AllInOne.textfield"/></label> :</td>
			<td><html:text property="textfield" /></td>
		</tr>
		<tr>
			<td><label for="textarea"><bean:message key="AllInOne.textarea"/></label> :</td>
			<td><html:textarea property="textarea" /></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="AllInOne.label"/></td>
		</tr>
		<tr>
			<td><label for="slider"><bean:message key="AllInOne.slider"/></label> :</td>
			<td><html:text property="slider" /></td>
		</tr>
		<tr>
			<td><label for="pushbutton"><bean:message key="AllInOne.pushbutton"/></label> :</td>
			<td><html:text property="pushbutton" /></td>
		</tr>
		<tr>
			<td><label for="toggle"><bean:message key="AllInOne.toggle"/></label> :</td>
			<td><html:text property="toggle" /></td>
		</tr>
		<tr>
			<td><label for="button"><bean:message key="AllInOne.button"/></label> :</td>
			<td><html:text property="button" /></td>
		</tr>
		<tr>
			<td><label for="canvas"><bean:message key="AllInOne.canvas"/></label> :</td>
			<td><html:text property="canvas" /></td>
		</tr>
		<tr>
			<td>
				<html:link action="/scenarioprincipal/allinone?event=unspecified">
					<bean:message key="AllInOne.link"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="progressbar"><bean:message key="AllInOne.progressbar"/></label> :</td>
			<td><html:text property="progressbar" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
		<tr>
			<td>
				<html:submit property="action" onclick="bCancel=false;AllInOneForm.event.value = 'action';">
				<bean:message key="AllInOne.action"/>
				</html:submit>
			</td>
		</tr>
	</table>
</fieldset>

</html:form>