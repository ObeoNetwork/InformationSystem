<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>

<table style="border: 0px;">
	<tr>
		<td><html:image page="/images/navig.gif"/></td>
		<td>Navigation links : </td>
	</tr>
	<tr>
		<td>-</td>
		<td><html:link action="/errors/errors">Errors</html:link> Screen</td>
	</tr>
	<tr>
		<td>-</td>
		<td><html:link action="/login/login">Login</html:link> Screen</td>
	</tr>

</table>