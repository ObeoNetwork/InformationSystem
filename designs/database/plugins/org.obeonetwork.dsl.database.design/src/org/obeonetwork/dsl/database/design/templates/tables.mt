<%
metamodel http://www.obeonetwork.org/dsl/database/1.0

import org.obeonetwork.dsl.database.design.services.EcoreServices
%>

<%-- Retrieve all non referenced external tables excluding those already displayed on the diagram --%>
<%-- args(0) : DSemanticDiagram diagram used to check for already displayed tables --%>
<%script type="TableContainer" name="allSelectableExternalTables"%>
<%allNonReferencedExternalTables - args(0).eAllContents("AbstractDNode").target.filter("database.Table")%>

<%script type="TableContainer" name="allTables"%>
<%allRoots.eAllContents.filter("database.Table")%>

<%script type="TableContainer" name="allExternalTables"%>
<%allTables - tables%>

<%script type="TableContainer" name="allReferencedTables"%>
<%tables.filter("database.Table").foreignKeys.target.nMinimize()%>

<%script type="TableContainer" name="allNonReferencedExternalTables"%>
<%allExternalTables - allReferencedTables%>

<%script type="TableContainer" name="allReferencedExternalTables"%>
<%allReferencedTables - tables%>
