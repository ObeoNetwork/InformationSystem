<%
metamodel /org.obeonetwork.dsl.interaction/model/interaction.ecore
%>

<%script type="interaction.Participant" name="currentParticipant"%>
<%self%>
<%script type="interaction.End" name="currentParticipant"%>
<%context%>
<%script type="interaction.Execution" name="currentParticipant"%>
<%owner%>
<%script type="interaction.StateInvariant" name="currentParticipant"%>
<%owner%>

<%script type="interaction.Participant" name="isPointedByDestroyMessage"%>
<%eContainer("Interaction").messages.filter("DestroyParticipantMessage").finishingEnd[context == current("Participant")].nSize > 0%>