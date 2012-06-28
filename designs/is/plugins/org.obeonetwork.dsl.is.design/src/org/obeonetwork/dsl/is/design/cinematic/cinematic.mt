<%
metamodel http://www.obeonetwork.org/dsl/cinematic/2.0.0

import org.obeonetwork.dsl.is.design.service.EcoreService
%>

<%script type="Scenario" name="allScreens"%>
<%allRoots.eAllContents().filter("Screen")%>

<%script type="Scenario" name="allExternalScreens"%>
<%allScreens - ownedScreens%>

<%script type="Scenario" name="allReferencedScreens"%>
<%(ownedScreens.previousScreen + ownedScreens.next).nMinimize()%>

<%script type="Scenario" name="allReferencedExternalScreens"%>
<%allReferencedScreens - ownedScreens%>

<%script type="Scenario" name="allNonReferencedExternalScreens"%>
<%allExternalScreens - allReferencedExternalScreens%>
