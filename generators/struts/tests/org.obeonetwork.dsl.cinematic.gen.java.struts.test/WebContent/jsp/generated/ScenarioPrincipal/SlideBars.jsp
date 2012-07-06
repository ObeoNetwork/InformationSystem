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

<html:form action="/scenarioprincipal/slidebars" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td><label for="sliderBar1"><bean:message key="SlideBars.sliderBar1"/></label> :</td>
			<td><html:text property="sliderBar1" /></td>
		</tr>
		<tr>
			<td><label for="sliderBar2"><bean:message key="SlideBars.sliderBar2"/></label> :</td>
			<td><html:text property="sliderBar2" /></td>
		</tr>
		<tr>
			<td><label for="sliderBar3"><bean:message key="SlideBars.sliderBar3"/></label> :</td>
			<td><html:text property="sliderBar3" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>