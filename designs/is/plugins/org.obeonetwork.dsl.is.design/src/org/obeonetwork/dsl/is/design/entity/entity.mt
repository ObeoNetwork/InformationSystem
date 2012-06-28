<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.is.design.service.EcoreService
import org.obeonetwork.dsl.is.design.service.EntityService
import org.obeonetwork.dsl.is.design.service.DiagramService
%>
<%-- Retrieve all non referenced external entities excluding those already displayed on the diagram --%>
<%-- args(0) : DSemanticDiagram diagram used to check for already displayed entities --%>
<%script type="Block" name="allSelectableExternalEntities"%>
<%allNonReferencedExternalEntities - args(0).eAllContents("AbstractDNode").target.filter("entity.Entity")%>

<%script type="Block" name="allContainedEntities"%>
<%eAllContents().filter("entity.Entity")%>

<%script type="Block" name="allEntities"%>
<%allRoots.eAllContents.filter("entity.Entity")%>

<%script type="Block" name="allExternalEntities"%>
<%allEntities - allContainedEntities%>

<%script type="Entity" name="referencedEntities"%>
<%(ownedReferences.type + ~type.entity + supertype + ~supertype).nMinimize()%>

<%script type="Block" name="allReferencedEntities"%>
<%(allContainedEntities.referencedEntities).nMinimize()%>

<%script type="Block" name="allReferencedExternalEntities"%>
<%allReferencedEntities - allContainedEntities%>

<%script type="Block" name="allNonReferencedExternalEntities"%>
<%allExternalEntities - allReferencedEntities%>

<%-- args(0) : DSemanticDiagram diagram used to check for activated layer --%>
<%script type="Block" name="visibleEntitiesOnEntityDiagram"%>
<%if (args(0).isLayerActivated("External Entities")){%>
<%entities + subblocks.entities + allReferencedExternalEntities%>
<%}else{%>
<%entities + subblocks.entities%>
<%}%>
