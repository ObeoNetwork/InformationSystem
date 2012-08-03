<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>

<html:errors />

<h2 class="date-header">Flow login</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/login/login">Screen Login</html:link> : Login to your account</h3>
</div>
<h2 class="date-header">Flow editAccount</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/editaccount/editaccount">Screen EditAccount</html:link> : Edit your account</h3>
</div>
<h2 class="date-header">Flow createAccount</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/createaccount/createaccount">Screen CreateAccount</html:link> : Create new Account</h3>
</div>
<h2 class="date-header">Flow viewLogs</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/viewlogs/viewlogs">Screen ViewLogs</html:link> : View your personnal logs</h3>
</div>
<h2 class="date-header">Flow createLog</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/createlog/createlog">Screen CreateLog</html:link> : Create a new log entry</h3>
</div>
