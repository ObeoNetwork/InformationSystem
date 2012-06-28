<%
metamodel http://www.obeonetwork.org/dsl/soa/2.0.0

import org.obeonetwork.dsl.is.design.service.EcoreService
import org.obeonetwork.dsl.is.design.service.DiagramService
%>

<%-- Retrieve all non referenced external components excluding those already displayed on the diagram --%>
<%-- args(0) : DSemanticDiagram diagram used to check for already displayed components --%>
<%script type="System" name="allSelectableExternalComponents"%>
<%allNonReferencedExternalComponents  - args(0).eContents().filter("DNodeContainer").target.filter("soa.Component") %>

<%-- Retrieve all non referenced external DTOs excluding those already displayed on the diagram --%>
<%-- args(0) : DSemanticDiagram diagram used to check for already displayed DTOs --%>
<%script type="Category" name="allSelectableExternalDTOs"%>
<%allNonReferencedExternalDTOs - args(0).eAllContents("AbstractDNode").target.filter("soa.ServiceDTO")%>

<%script type="Service" name="isRequiredService"%>
<%kind=="required"%>

<%script type="Service" name="isProvidedService"%>
<%kind=="provided"%>

<%script type="System" name="allComponents"%>
<%allRoots.eAllContents().filter("soa.Component")%>

<%script type="System" name="allExternalComponents"%>
<%allComponents - ownedComponents%>

<%script type="System" name="allReferencedComponents"%>
<%(ownedWires.source.eContainer() + ownedWires.dest.eContainer()).nMinimize()%>

<%script type="System" name="allReferencedExternalComponents"%>
<%allReferencedComponents - ownedComponents%>

<%script type="System" name="allNonReferencedExternalComponents"%>
<%allExternalComponents - allReferencedExternalComponents%>

<%script type="Category" name="allDTOs"%>
<%allRoots.eAllContents().filter("soa.ServiceDTO")%>

<%script type="Category" name="allContainedDTOs"%>
<%(types + ownedCategories.types).nMinimize()%>

<%script type="Category" name="allExternalDTOs"%>
<%allDTOs - allContainedDTOs%>

<%script type="ServiceDTO" name="referencedDTOs"%>
<%(ownedReferences.type + ~type.dto + supertype + ~supertype).nMinimize()%>

<%script type="Category" name="allReferencedDTOs"%>
<%(allContainedDTOs.referencedDTOs).nMinimize()%>

<%script type="Category" name="allReferencedExternalDTOs"%>
<%allReferencedDTOs - allContainedDTOs%>

<%script type="Category" name="allNonReferencedExternalDTOs"%>
<%allExternalDTOs - allReferencedDTOs%>

<%-- args(0) : DSemanticDiagram diagram used to check for activated layer --%>
<%script type="Category" name="visibleDtosOnCategoryDtoView"%>
<%if (args(0).isLayerActivated("External DTO")){%>
<%types + ownedCategories.types + allReferencedExternalDTOs%>
<%}else{%>
<%types + ownedCategories.types%>
<%}%>

<%script type="DTORegistry" name="visibleDtosOnDtoView"%>
<%ownedCategories.visibleDtosOnDtoView%>

<%script type="Category" name="visibleDtosOnDtoView"%>
<%types + ownedCategories.visibleDtosOnDtoView%>