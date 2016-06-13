<%
metamodel http://www.obeonetwork.org/dsl/soa/2.0.0

import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
%>

<%script type="ServiceDTO" name="dtoPackage" post="trim"%>
<%if (getProperty("useDtoPackage")=="no"){%>
	<%getCompleteName%>
<%}else{%>
    <%if (getProperty("use.functional.disposition") == "true"){%>
        <%baseImports%>.<%projectName%>.<%normalizedName%><%insertInPackage("dto.package")%>
    <%}else{%>
        <%baseImports%>.<%projectName%><%insertInPackage("dto.package")%>.<%normalizedName%>
    <%}%>
<%}%>

<%script type="Service" name="soaPackage" post="trim"%>
<%if (getProperty("useSoaPackage")=="no"){%>
	<%getCompleteName%>
<%}else{%>
    <%if (getProperty("use.functional.disposition") == "true"){%>
        <%baseImports%>.<%projectName%>.<%normalizedName%><%insertInPackage("soa.package")%>
    <%}else{%>
        <%baseImports%>.<%projectName%><%insertInPackage("soa.package")%>.<%normalizedName%>
    <%}%>
<%}%>

<%script type="EObject" name="normalizedName"%>
<%self().name.toStandardNotation().toLowerCase()%>

<%script type="EObject" name="getCompleteName"%>
<%self().getCompleteName()%>

<%script type="Service" name="serviceName"%>
<%name.toStandardNotation().toU1Case()%>Service

<%script type="ServiceDTO" name="serviceDtoName"%>
<%name%>Dto

<%script type="Service" name="serviceInterfaceName"%>
I<%serviceName.toU1Case()%>

<%script type="Service" name="serviceInterfaceQualifiedName"%>
<%soaPackage%>.<%serviceInterfaceName%>

<%script type="Service" name="serviceImplQualifiedName"%>
<%soaPackage%>.<%serviceName%>Impl

<%script type="ServiceDTO" name="serviceDtoQualifiedName"%>
<%dtoPackage%>.<%serviceDtoName%>

<%script type="Service" name="isRequiredService"%>
<%kind=="required"%>

<%script type="Service" name="isProvidedService"%>
<%kind=="provided"%>