<!-- Start of user code for layout -->

<%@ taglib
        uri="http://struts.apache.org/tags-tiles"
        prefix="tiles" %>
<%@ taglib
        uri="http://struts.apache.org/tags-bean"
        prefix="bean" %>
<%@ taglib
        uri="http://struts.apache.org/tags-html"
        prefix="html" %>

<bean:define id="link" value="<%=request.getContextPath()%>"/>
<tiles:importAttribute name="title"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>	
		<title><tiles:getAsString name="title"/></title>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="service.feed" type="application/atom+xml" title="<tiles:getAsString name="title"/>" href="atom.xml"/>
		<link rel="icon" href="${link}/images/favico.ico" type="image/ico" /> 
		<link rel="stylesheet" type="text/css" href="${link}/css/<tiles:getAsString name="scenario" ignore="true"/>/<tiles:getAsString name="pageName" ignore="true"/>.css" media="screen" title="style1"/>
		<link rel="stylesheet" type="text/css" href="${link}/css/style1.css" media="screen" title="style1"/>
		<link rel="alternate stylesheet" type="text/css" href="${link}/css/style2.css" media="screen" title="style2"/>
		<link rel="alternate stylesheet" type="text/css" href="${link}/css/style3.css" media="screen" title="style3"/>
		<script type="text/javascript" src="${link}/js/<tiles:getAsString name="scenario" ignore="true"/>/<tiles:getAsString name="pageName" ignore="true"/>.js"></script>
		<script type="text/javascript" src="${link}/js/alljs.jsp"></script>
	</head>
<body>

<div id="content">

	<!-- Begin #header -->
		<div id="header">
			<div>
			  <h1 id="blog-title">
				<tiles:getAsString name="title" ignore="true"/>
			  </h1>
			  <p id="description">&nbsp;</p>
			</div>
		</div>
		
	<!-- End #header -->
	
	<!-- Begin #content -->
	<div id="main">
		<div id="main2">
			<div id="main3">
				<tiles:insert attribute="body"/>
			</div>
		</div>
	</div>
	<!-- Enf #content -->

	<!-- Begin #sidebar -->
	<div id="sidebar">	
		<tiles:insert attribute="sidebar"/>	
	</div>
	<!-- End #sidebar -->

	<div class="clear">&nbsp;</div>
	
	<!-- Begin #footer -->
	<div id="footer">
		<tiles:insert attribute="footer"/>
	</div>
	<!-- End #footer -->

</div> <!-- end #wrap -->

</body>
</html>

<!-- End of user code -->
