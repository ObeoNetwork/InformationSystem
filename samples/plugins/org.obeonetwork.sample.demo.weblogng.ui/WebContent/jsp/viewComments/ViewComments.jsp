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

<html:form action="/viewcomments/viewcomments" method="POST">

<html:hidden property="event" value=""/>

<fieldset>
	<legend>Informations</legend>
	
	<table>
		<tr>
			<td>
				<html:link action="/org.eclipse.emf.ecore.impl.DynamicEObjectImpl@7bc59afb (eClass: org.eclipse.emf.ecore.impl.EClassImpl@6a421438 (name: OclInvalid_Class) (instanceClassName: null) (abstract: false, interface: false))/org.eclipse.emf.ecore.impl.DynamicEObjectImpl@7bc59afb (eClass: org.eclipse.emf.ecore.impl.EClassImpl@6a421438 (name: OclInvalid_Class) (instanceClassName: null) (abstract: false, interface: false))?event=org.eclipse.emf.ecore.impl.DynamicEObjectImpl@7bc59afb (eClass: org.eclipse.emf.ecore.impl.EClassImpl@6a421438 (name: OclInvalid_Class) (instanceClassName: null) (abstract: false, interface: false))">
					<bean:message key="ViewComments.comments"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td><label for="email"><bean:message key="ViewComments.email"/></label> :</td>
			<td><html:text property="email" /></td>
		</tr>
		<tr>
			<td><label for="log"><bean:message key="ViewComments.log"/></label> :</td>
			<td><logic:iterate name="ViewCommentsForm" id="log_id" property="log" /></td>
		</tr>
		<tr>
			<td><label for="content"><bean:message key="ViewComments.content"/></label> :</td>
			<td><html:textarea property="content" /></td>
		</tr>
		<tr>
			<td><label for="website"><bean:message key="ViewComments.website"/></label> :</td>
			<td><html:text property="website" /></td>
		</tr>
		<tr>
			<td><label for="comments"><bean:message key="ViewComments.comments"/></label> :</td>
			<td><logic:iterate name="ViewCommentsForm" id="comments_id" property="comments" /></td>
		</tr>
		<tr>
			<td><label for="name"><bean:message key="ViewComments.name"/></label> :</td>
			<td><html:text property="name" /></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend>Actions</legend>
	<table>
	</table>
</fieldset>

</html:form>