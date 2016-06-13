/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.design.services.label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.design.services.flows.FlowsUtil;
import org.obeonetwork.dsl.cinematic.design.services.flows.WidgetEventTypeAndAbstractViewElement;
import org.obeonetwork.dsl.cinematic.design.services.ui.UiUtil;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.util.FlowSwitch;
import org.obeonetwork.dsl.cinematic.provider.CinematicEditPlugin;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;


public class FlowEditLabelSwitch extends FlowSwitch<EObject> implements EditLabelSwitch {
	private String newLabel;
	
	public EObject editLabel(EObject eObject, String newLabel) {
		this.newLabel = newLabel;
		doSwitch(eObject);
		return eObject;
	}

	@Override
	public EObject caseNamedElement(NamedElement namedElement) {
		namedElement.setName(newLabel);
		return namedElement;
	}
	

	@Override
	public EObject caseTransition(Transition transition) {
		String eventPart = null;
		String guard = null;
		Collection<String> notFoundEventNames = new ArrayList<String>();
		
		// We search for '[' and ']' characters
		int openingBracketPos = newLabel.indexOf("[");
		int closingBracketPos = newLabel.lastIndexOf("]");
		if (openingBracketPos != -1 && openingBracketPos != newLabel.length() - 1) {
			// if there is no closing bracket or its before the opening bracket
			// we consider there is a closing bracket at the end of the string
			if (closingBracketPos == -1 || closingBracketPos < openingBracketPos) {
				closingBracketPos = newLabel.length();
			}
			guard = newLabel.substring(openingBracketPos + 1, closingBracketPos).trim();
			// We now consider the rest of the string i.e. trigger events
			eventPart = newLabel.substring(0, openingBracketPos).trim();
		} else {
			guard = null;
			eventPart = newLabel.trim();
		}
			
		// Get the containing flow
		if (transition.eContainer() != null && transition.eContainer() instanceof Flow) {
			Flow flow = (Flow)transition.eContainer();
			
			String[] events = eventPart.split(",");
			
			// Retrieve associated events and possible event types
			Collection<Event> associatedEvents = FlowsUtil.getAssociatedEvents(flow);
			Collection<WidgetEventTypeAndAbstractViewElement> possibleEvents = FlowsUtil.getPossibleWidgetEvents(flow);
			
			Collection<Object> eventsToBeAssociated = new ArrayList<Object>();
			for (String event : events) {
				List<Object> candidatesEvents = new ArrayList<Object>();
				String eventName = event.trim();
				
				if (eventName != null && !eventName.equals("")) {
					
					// Test if the event was already associated
					boolean alreadyAssociatedEvent = false;
					for (Event alreadyAssociated : transition.getOn()) {
						if (eventName.equals(alreadyAssociated.getName().trim())) {
							alreadyAssociatedEvent = true;
							break;
						}
					}
					if (alreadyAssociatedEvent) {
						break;
					}
					
					for (Event associatedEvent : associatedEvents) {
						if (eventName.equalsIgnoreCase(associatedEvent.getName().trim())) {
							candidatesEvents.add(associatedEvent);
						}
					}
					for (WidgetEventTypeAndAbstractViewElement widgetEventTypeAndElement : possibleEvents) {
						if (eventName.equalsIgnoreCase(widgetEventTypeAndElement.getWidgetEventType().getName().trim())) {
							candidatesEvents.add(widgetEventTypeAndElement);
						}
					}
				}
				// Now, let's see if we had some results
				if (candidatesEvents.isEmpty()) {
					notFoundEventNames.add(eventName);
				} else if (candidatesEvents.size() == 1 && candidatesEvents.get(0) instanceof Event) {
					eventsToBeAssociated.add((Event)candidatesEvents.get(0));
				} else if (candidatesEvents.size() == 1 && candidatesEvents.get(0) instanceof WidgetEventTypeAndAbstractViewElement) {
					WidgetEventTypeAndAbstractViewElement info = (WidgetEventTypeAndAbstractViewElement)candidatesEvents.get(0);
					boolean create = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
												"Create a new Event ?",
												"An event named '" + eventName + "' does not exist yet but a ViewEvent could be created for the widget '" + info.getAbstractViewElement().getName()+ "'.\n"
												+ "Do you want to create this event ?");
					if (create) {
						eventsToBeAssociated.add(info);
					}
				} else {
					Object result = UiUtil.getUserChoiceWithinList(
							"Select an event",
							"You could pick an existing event or create a new one for '" + eventName + "'",
							candidatesEvents.toArray(),
							new LabelProvider() {
								
								@Override
								public Image getImage(Object element) {
									URL imageURL = null;
									if (element instanceof FlowEvent) {
										imageURL = (URL)CinematicEditPlugin.INSTANCE.getImage("full/obj16/FlowEvent");
									} else if (element instanceof ViewEvent) {
										imageURL = (URL)CinematicEditPlugin.INSTANCE.getImage("full/obj16/ViewEvent");
									} else if (element instanceof WidgetEventTypeAndAbstractViewElement) {
										imageURL = (URL)CinematicEditPlugin.INSTANCE.getImage("full/obj16/NewViewEvent");
									}
									if (imageURL != null) {
										ImageDescriptor imgDesc = ImageDescriptor.createFromURL(imageURL);
										if (imgDesc != null) {
											return imgDesc.createImage();
										}
									}
									return null;
								}

								@Override
								public String getText(Object element) {
									String label = null;
									if (element instanceof Event) {
										Event event = (Event) element;
										label = getLabel(event);
									} else if (element instanceof WidgetEventTypeAndAbstractViewElement) {
										AbstractViewElement viewElement = ((WidgetEventTypeAndAbstractViewElement)element).getAbstractViewElement();
										WidgetEventType eventType = ((WidgetEventTypeAndAbstractViewElement)element).getWidgetEventType();
										label = getLabel(viewElement) + "::" + eventType.getName() + " (will create a new event)";
									}
									return label;
								}
								
								private String getLabel(EObject eObject) {
									String label = ""; 
									if (eObject.eContainer() != null) {
										String parentLabel = getLabel(eObject.eContainer());
										if (parentLabel != null) {
											label = parentLabel + "::";
										}
									}
									if (eObject instanceof NamedElement) {
										label += ((NamedElement)eObject).getName();
									}
									 
									return label;
								}
								
							});
					if (result != null) {
						eventsToBeAssociated.add(result);
					}
				}
			}
			
			
			// Warn and ask the user if we have to continue
			boolean doIt = true;
			if (!notFoundEventNames.isEmpty()) {
				String label = "";
				for (String name : notFoundEventNames) {
					label += "'" + name + "',";
				}
				// Remove last comma
				label = label.substring(0, label.length() - 1);
				
				doIt = MessageDialog.openQuestion(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"Edit the transition",
						"No event found for " + label + ".\n"
						+ "Edit the transition anyway ?");
			}
			
			if (doIt) {
				transition.setGuard(guard);
				// Let's associate the events now
				if (!eventsToBeAssociated.isEmpty()) {
					transition.getOn().clear();
					for (Object object : eventsToBeAssociated) {
						if (object instanceof Event) {
							transition.getOn().add((Event)object);
						} else if (object instanceof WidgetEventTypeAndAbstractViewElement) {
							AbstractViewElement viewElement = ((WidgetEventTypeAndAbstractViewElement)object).getAbstractViewElement();
							WidgetEventType eventType = ((WidgetEventTypeAndAbstractViewElement)object).getWidgetEventType();
							ViewEvent event = ViewFactory.eINSTANCE.createViewEvent();
							event.setName(eventType.getName());
							event.setType(eventType);
							viewElement.getEvents().add(event);
							transition.getOn().add(event);
						}
					}
				}
			}
		}
		
		return transition;
	}

	@Override
	public EObject caseSubflowState(SubflowState subflowState) {
		String flowName = newLabel.trim();
		// Check if the name has changed
		if (flowName != null && subflowState.getSubflow() != null && subflowState.getSubflow().getName() != null) {
			if (flowName.equalsIgnoreCase(subflowState.getSubflow().getName().trim())) {
				// Nothing to do
				return subflowState;
			}
		}
		
		List<Flow> foundFlows = FlowsUtil.getFlowsWithName(subflowState, flowName);
		if (foundFlows.isEmpty()) {
			// No flow found, let's notify the user
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
										"Unable to find flow",
										"No found flow with this name");
		} else if (foundFlows.size() == 1) {
			subflowState.setSubflow(foundFlows.get(0));
		} else {
			// Several flows with the same name, we let the user choose the correct one		
			Object result = UiUtil.getUserChoiceWithinList(
								"Select a flow",
								"Select a flow among the flows with the specified name",
								foundFlows.toArray(),
								new LabelProvider() {
									
									@Override
									public Image getImage(Object element) {
										URL imageURL = null;
										if (element instanceof Flow) {
											imageURL = (URL)CinematicEditPlugin.INSTANCE.getImage("full/obj16/Flow");
										}
										if (imageURL != null) {
											ImageDescriptor imgDesc = ImageDescriptor.createFromURL(imageURL);
											if (imgDesc != null) {
												return imgDesc.createImage();
											}
										}
										return null;
									}
			
									@Override
									public String getText(Object element) {
										String label = "";
										if (element instanceof Flow) {
											Flow flow = (Flow) element;
											label = getLabel(flow);
										}
										return label;
									}
									
									private String getLabel(EObject eObject) {
										String label = ""; 
										if (eObject.eContainer() != null) {
											String parentLabel = getLabel(eObject.eContainer());
											if (parentLabel != null) {
												label = parentLabel + "::";
											}
										}
										if (eObject instanceof NamedElement) {
											label += ((NamedElement)eObject).getName();
										}
										 
										return label;
									}
								});
			if (result instanceof Flow) {
				subflowState.setSubflow((Flow)result);
			}
		}
		return subflowState;
	}
	
}
