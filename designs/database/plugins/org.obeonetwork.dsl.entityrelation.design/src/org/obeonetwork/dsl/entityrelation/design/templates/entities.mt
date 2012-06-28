<%
metamodel http://www.obeonetwork.org/dsl/entityrelation/1.0

import org.obeonetwork.dsl.entityrelation.design.services.EcoreServices
%>

<%-- Retrieve all non referenced external entities excluding those already displayed on the diagram --%>
<%-- args(0) : DSemanticDiagram diagram used to check for already displayed entities --%>
<%script type="LogicalModel" name="allSelectableExternalEntities"%>
<%allNonReferencedExternalEntities - args(0).eAllContents("AbstractDNode").target.filter("entityrelation.Entity")%>

<%script type="LogicalModel" name="allEntities"%>
<%allRoots.eAllContents.filter("entityrelation.Entity")%>

<%script type="LogicalModel" name="allExternalEntities"%>
<%allEntities - entities%>

<%script type="LogicalModel" name="allReferencedEntities"%>
<%(relations.source + relations.target).nMinimize()%>

<%script type="LogicalModel" name="allNonReferencedExternalEntities"%>
<%allExternalEntities - allReferencedEntities%>

<%script type="LogicalModel" name="allReferencedExternalEntities"%>
<%allReferencedEntities - entities%>
