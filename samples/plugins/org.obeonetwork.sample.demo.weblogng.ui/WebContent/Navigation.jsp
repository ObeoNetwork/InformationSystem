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
<h2 class="date-header">Flow errors</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/errors/errors">Screen Errors</html:link> : Errors View</h3>
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
<h2 class="date-header">Flow viewComments</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/viewcomments/viewcomments">Screen ViewComments</html:link> : View comments posted about your logs</h3>
</div>
<h2 class="date-header">Flow grant</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/grant/grantadministrate">Screen GrantAdministrate</html:link> : Give moderate rights</h3>
	<h3 class="post-title"><html:link action="/grant/grantmoderate">Screen GrantModerate</html:link> : Give admin rights</h3>
</div>
<h2 class="date-header">Flow search</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/search/search">Screen Search</html:link> : Search</h3>
</div>
<h2 class="date-header">Flow manage</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/manage/deleteuser">Screen DeleteUser</html:link> : Delete user account</h3>
	<h3 class="post-title"><html:link action="/manage/deletecomment">Screen DeleteComment</html:link> : Delete comment</h3>
	<h3 class="post-title"><html:link action="/manage/manager">Screen Manager</html:link> : Manager</h3>
	<h3 class="post-title"><html:link action="/manage/managecomments">Screen ManageComments</html:link> : ManageComments</h3>
	<h3 class="post-title"><html:link action="/manage/managecategories">Screen ManageCategories</html:link> : Manage categories</h3>
	<h3 class="post-title"><html:link action="/manage/managetags">Screen ManageTags</html:link> : ManageTags</h3>
	<h3 class="post-title"><html:link action="/manage/updatecomment">Screen UpdateComment</html:link> : Update comment</h3>
	<h3 class="post-title"><html:link action="/manage/createcategory">Screen CreateCategory</html:link> : Create a new category</h3>
	<h3 class="post-title"><html:link action="/manage/updatecategory">Screen UpdateCategory</html:link> : Update an existing category</h3>
	<h3 class="post-title"><html:link action="/manage/deletecategory">Screen DeleteCategory</html:link> : Delete an existing category</h3>
	<h3 class="post-title"><html:link action="/manage/createtag">Screen CreateTag</html:link> : Create a new tag</h3>
	<h3 class="post-title"><html:link action="/manage/updatetag">Screen UpdateTag</html:link> : Update an existing tag</h3>
	<h3 class="post-title"><html:link action="/manage/deletetag">Screen DeleteTag</html:link> : Delete an existing tag</h3>
	<h3 class="post-title"><html:link action="/manage/addtag">Screen AddTag</html:link> : Add tag</h3>
	<h3 class="post-title"><html:link action="/manage/removetag">Screen RemoveTag</html:link> : Remove an existing tag</h3>
	<h3 class="post-title"><html:link action="/manage/addcategory">Screen AddCategory</html:link> : Add category</h3>
	<h3 class="post-title"><html:link action="/manage/removecategory">Screen RemoveCategory</html:link> : Remove an existing category</h3>
</div>
<h2 class="date-header">Flow monitoring</h2>
<div class="post">
	<h3 class="post-title"><html:link action="/monitoring/monitor">Screen Monitor</html:link> : Monitor</h3>
	<h3 class="post-title"><html:link action="/monitoring/seeusers">Screen SeeUsers</html:link> : See users</h3>
	<h3 class="post-title"><html:link action="/monitoring/seecategories">Screen SeeCategories</html:link> : See categories</h3>
	<h3 class="post-title"><html:link action="/monitoring/seetags">Screen SeeTags</html:link> : See tags</h3>
	<h3 class="post-title"><html:link action="/monitoring/seecomments">Screen SeeComments</html:link> : See comments</h3>
</div>
