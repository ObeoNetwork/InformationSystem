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

<html:form action="/viewlogs/viewlogs" method="POST">

<html:hidden property="event" value=""/>
<h2 class="sidebar-title">Liste des logs</h2> 
<!-- 
<h3 class="sidebar-title">
	<html:link action="/main/viewlogs?event=login">Se logger</html:link> 
	<html:link action="/main/viewlogs?event=logout">Logout</html:link> 
	<html:link action="/main/viewlogs?event=editAccount">Editer son compte</html:link> 
</h3>
 --> 
<dd><strong>Name: </strong><bean:write name="ViewLogsForm" property="user"/></dd>  
<br/>&nbsp;

<logic:iterate name="ViewLogsForm" id="log" property="logs">
 <h2 class="date-header">
 <%--TODO <bean:write name="log" property="creationDateAsDay"/>--%>
 <bean:write name="log" property="creationDateAsText"/>
 </h2>

  <!-- Begin .post -->
  <div class="post"><a name="<bean:write name="log" property="id"/>"></a>     
    
    <h3 class="post-title">	 
	 <bean:write name="log" property="title"/>	 
    </h3>
         
    <div class="post-body">    
      <p><bean:write name="log" property="content"/></p>    
    </div>
 <p class="post-footer">posté par <bean:write name="log" property="author"/>
à <bean:write name="log" property="creationTimeAsText"/>
</p>
      
  </div>
</logic:iterate>
<hr/>
</html:form>