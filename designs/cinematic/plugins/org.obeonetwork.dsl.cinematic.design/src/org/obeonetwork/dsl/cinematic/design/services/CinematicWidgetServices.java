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
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;

/**
 * Services to use the widgets
 * 
 * @author jdupont
 * 
 */
public class CinematicWidgetServices {

	private static final String CREATE_VIEW_CONTAINER_TITLE = "Create View container";

	/**
	 * Retrieves widgets that have the property isContainer set to true and
	 * contained in the semantic element.
	 * 
	 * @param context
	 *            VSM context
	 * @param semanticElement
	 *            Semantic element
	 */
	public List<Widget> getWidgetsIsContainer(EObject context,
			EObject semanticElement) {
		List<Widget> widgetsIsContainer = new ArrayList<Widget>();
		CinematicRoot cinematicRoot = null;
		if (semanticElement instanceof CinematicRoot) {
			cinematicRoot = (CinematicRoot) semanticElement;
		} else {
			EObject element = semanticElement;
			while (!(element.eContainer() instanceof CinematicRoot)) {
				element = semanticElement.eContainer();
			}
			cinematicRoot = (CinematicRoot) element.eContainer();
		}
		List<Toolkit> toolkits = cinematicRoot.getToolkits();
		for (Toolkit toolkit : toolkits) {
			EList<Widget> widgets = toolkit.getWidgets();
			for (Widget widget : widgets) {
				if (widget.isIsContainer()) {
					widgetsIsContainer.add(widget);
				}
			}
		}
		return widgetsIsContainer;
	}

	/**
	 * Retrieves the selected widget. Return null if neither widget was
	 * selected.
	 * 
	 * @param context
	 *            the VSM context
	 * @param selectedElement
	 *            The selected Element
	 * @return the selected widget, null otherwise
	 */
	public Widget getSelectedWidget(EObject context, EObject selectedElement) {
		Widget selectedWidget = null;
		if (selectedElement instanceof Widget) {
			selectedWidget = (Widget) selectedElement;
		}
		return selectedWidget;
	}

	/**
	 * Return the selected Widget if this widget have container property.
	 * 
	 * @param context
	 *            the ViewContainer
	 * @param selectedElement
	 *            the Widget selected
	 * @return the widget selected if have container property, null otherwise
	 */
	public Widget getWidgetHavePropertyIsContainer(ViewContainer context,
			Widget selectedElement) {
		Widget widgetToReturn = null;
		if (selectedElement.isIsContainer()) {
			widgetToReturn = selectedElement;
		}
		return widgetToReturn;
	}

	/**
	 * Return the widgets that have container property.
	 * 
	 * @param context
	 *            the ViewContainer
	 * @return List of widgets that have property is Container set to true
	 */
	public List<Widget> getWidgetsHavePropertyIsContainer(EObject context) {
		List<Widget> widgetsIsContainer = new ArrayList<Widget>();
		CinematicRoot cinematicRoot = null;
		EObject container = null;
		if (context.eContainer() != null) {
			container = context.eContainer();
		} else {
			container = context;
		}
		while (container.eContainer() != null
				&& !(container instanceof CinematicRoot)) {
			container = container.eContainer();
		}
		if (context instanceof CinematicRoot) {
			cinematicRoot = (CinematicRoot) context;
		} else if (container instanceof CinematicRoot) {
			cinematicRoot = (CinematicRoot) container;
		}
		if (cinematicRoot != null) {
			List<Toolkit> toolkits = cinematicRoot.getToolkits();
			if (toolkits.isEmpty()) {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), CREATE_VIEW_CONTAINER_TITLE, "No toolkit has been associated yet.\nPlease use the 'Associate toolkit' tool on the root level.");
			} else {
				for (Toolkit toolkit : toolkits) {
					for (Widget widget : toolkit.getWidgets()) {
						if (widget.isIsContainer()) {
							widgetsIsContainer.add(widget);
						}
					}
				}
			}
		}
		return widgetsIsContainer;
	}

	/**
	 * Retrieve the list of toolkits and their widgets
	 * @param context context
	 * @param widgets
	 *            the list of widgets that have the property isContainer set to
	 *            true
	 * @return list of toolkits and their widgets
	 */
	public List<EObject> getToolkitsFromWidget(EObject context,
			List<Widget> widgets) {
		List<Toolkit> toolkits = new ArrayList<Toolkit>();
		List<EObject> toolkitsAndWidgest = new ArrayList<EObject>();
		// Adds the associates toolkit to widget
		for (Widget widget : widgets) {
			if (!toolkits.contains(widget.getToolkit())) {
				toolkits.add(widget.getToolkit());
			}
		}
		toolkitsAndWidgest.addAll(toolkits);
		toolkitsAndWidgest.addAll(widgets);
		return toolkitsAndWidgest;
	}

	/**
	 * Return the selected Widget if this widget have no container property.
	 * 
	 * @param context
	 *            the ViewContainer
	 * @param selectedElement
	 *            the Widget selected
	 * @return the widget selected if have no container property, null otherwise
	 */
	public Widget getWidgetHavePropertyIsNotContainer(ViewContainer context,
			Widget selectedElement) {
		Widget widgetToReturn = null;
		if (!selectedElement.isIsContainer()) {
			widgetToReturn = selectedElement;
		}
		return widgetToReturn;
	}

	/**
	 * Return the selected Widget if this widget have no container property.
	 * 
	 * @param context
	 *            the ViewElement
	 * @param selectedElement
	 *            the Widget selected
	 * @return the widget selected if have no container property, null otherwise
	 */
	public Widget getWidgetHavePropertyIsNotContainer(ViewElement context,
			Widget selectedElement) {
		Widget widgetToReturn = null;
		if (!selectedElement.isIsContainer()) {
			widgetToReturn = selectedElement;
		}
		return widgetToReturn;
	}

	/**
	 * Return possible events.	 
	 * @param context The view container reference
	 * @return list of widget event type
	 */
	public List<WidgetEventType> getPosssibleEvents(
			ViewContainerReference context) {
		return context.getViewContainer().getWidget().getPossibleEvents();
	}

}
