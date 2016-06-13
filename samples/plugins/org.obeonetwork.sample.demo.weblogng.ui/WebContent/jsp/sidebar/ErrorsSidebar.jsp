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
		<td><html:link action="/createaccount/createaccount">CreateAccount</html:link> Screen</td>
	</tr>
	<tr>
		<td>-</td>
		<td><html:link action="/editaccount/editaccount">EditAccount</html:link> Screen</td>
	</tr>

</table>