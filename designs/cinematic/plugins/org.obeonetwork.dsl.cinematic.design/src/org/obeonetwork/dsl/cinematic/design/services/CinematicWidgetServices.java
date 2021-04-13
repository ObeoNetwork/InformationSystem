/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.internal.session.danalysis.DAnalysisSessionImpl;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.design.decorators.SVGImageFigure;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.environment.design.services.ModelServices;
import org.obeonetwork.utils.common.StreamUtils;

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

	public String getWorkspaceImagePath(Widget widget) {
		String workspaceImagePath = null;
		Enumeration<URL> entries = Activator.getDefault().getBundle().findEntries("/icons/toolkit", widget.getName() + ".*", false);
		if(entries != null && entries.hasMoreElements()) {
			URL entry = entries.nextElement();
			workspaceImagePath = "/org.obeonetwork.dsl.cinematic.design" + entry.getFile();
		} else {
			workspaceImagePath = "/org.obeonetwork.dsl.cinematic.design/icons/toolkit/Unknown.png";
		}
		
		return workspaceImagePath;
	}
	
	public boolean hasWidgetDecoration(ViewElement viewElement, String cardinalPosition) {
		return getWidgetDecoratorPath(viewElement, cardinalPosition) != null;
	}
	
	// TODO Use the values from the model (this is a remaining of the POC)
	public String getWidgetDecoratorPath(ViewElement viewElement, String cardinalPosition) {
		Widget widget = viewElement.getWidget();
		String decoratorPath = null;
		
		if("Combo".equals(widget.getName())) {
			if("East".equals(cardinalPosition)) {
				decoratorPath = "/org.obeonetwork.dsl.cinematic.design/icons/decorators/DropDownArrow.svg";
			}
		} else if("Radio".equals(widget.getName())) {
			if("West".equals(cardinalPosition)) {
				decoratorPath = "/org.obeonetwork.dsl.cinematic.design/icons/decorators/RadioChecked.svg";
			}
		}
		
		return decoratorPath;
	}
	
	/**
	 * Note : When used as a public service from the VSM, Sirius keeps in cache the image, thus ignoring the resize of the container.
	 * @see #getWidgetDecoratorFigure()
	 */
	private Image getWidgetDecoratorImage(ViewElement viewElement, String cardinalPosition, DDiagramElementContainer containerDiagramElement) {
		DDiagramElement diagramElement = containerDiagramElement.getElements().stream().filter(dde -> dde.getTarget() == viewElement).findFirst().orElse(null);
		
		String path = getWidgetDecoratorPath(viewElement, cardinalPosition);
		Bounds bounds = CinematicLayoutServices.getBounds(diagramElement);
		
		// TODO : Calculer la largeur proportionellement à la hauteur
		int h = bounds.getHeight() - 4;
		Image image  = SVGImageFigure.flyWeightImage(path, h, h);
		return image;
	}

	/**
	 * This service assumes that getWidgetDecoratorPath(viewElement,
	 * cardinalPosition) does not return null.
	 * 
	 * @param viewElement
	 * @param cardinalPosition
	 * @param containerDiagramElement
	 * @return the figure to be used as a decoration on the given view element at
	 *         the given cardinal position and proportionnaly sized to the height of
	 *         the given container diagram element.
	 */
	public IFigure getWidgetDecoratorFigure(ViewElement viewElement, String cardinalPosition, DDiagramElementContainer containerDiagramElement) {
		Image image = getWidgetDecoratorImage(viewElement, cardinalPosition, containerDiagramElement);
		ImageFigureEx figureImage = new ImageFigureEx();
        figureImage.setImage(image);
        figureImage.setSize(image.getBounds().width, image.getBounds().height);
        return figureImage;
	}
	
	public Widget getWidgetByName(CinematicElement context, String widgetName) {
		return ModelServices.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
				.flatMap(tk -> tk.getWidgets().stream())
				.filter(w -> w.getName().equals(widgetName))
				.findFirst().orElse(null);
	}
	
	// TODO Comment
	public EObject buildWidgetPalette(CinematicElement context) {
		Collection<Viewpoint> viewpoints = new EObjectQuery(context).getAvailableViewpointsInResourceSet();
		Viewpoint cinematicVP = viewpoints.stream().filter(vp -> vp.getName().equals(ICinematicViewpoint.ID)).findFirst().orElse(null);
		
		
		DiagramDescription viewContainerDiagramDescription = (DiagramDescription) cinematicVP.getOwnedRepresentations().stream()
		.filter(r -> ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID.equals(r.getName()))
		.findFirst().orElse(null); // Can't be null
		
		Optional<ContainerCreationDescription> viewElementCreationToolPrototypeOption = StreamUtils.asStream(viewContainerDiagramDescription.getDefaultLayer().eAllContents())
		.filter(ContainerCreationDescription.class::isInstance)
		.map(ContainerCreationDescription.class::cast)
		.filter(d -> "CRE_ViewElement%widget%".equals(d.getName()))
		.findFirst();
		
		if(viewElementCreationToolPrototypeOption.isPresent()) {
			ContainerCreationDescription viewElementCreationToolPrototype = viewElementCreationToolPrototypeOption.get();
			ToolSection toolSection = (ToolSection) viewElementCreationToolPrototype.eContainer();
			List<Widget> widgets = ModelServices.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
					.flatMap(tk -> tk.getWidgets().stream())
					.filter(w -> !w.isIsContainer())
					.collect(Collectors.toList());

			for(Widget widget : widgets) {
				Copier copier = new Copier();
				copier.copy(viewElementCreationToolPrototype);
				copier.copyReferences();
				ContainerCreationDescription anotherCreationTool = (ContainerCreationDescription) copier.get(viewElementCreationToolPrototype);
				applyStringPattern(anotherCreationTool, "%widget%", widget.getName());

				toolSection.getOwnedTools().add(anotherCreationTool);
			}

			toolSection.getOwnedTools().remove(viewElementCreationToolPrototype);
		}
	    
		Optional<ContainerCreationDescription> viewContainerCreationToolPrototypeOption = StreamUtils.asStream(viewContainerDiagramDescription.getDefaultLayer().eAllContents())
		.filter(ContainerCreationDescription.class::isInstance)
		.map(ContainerCreationDescription.class::cast)
		.filter(d -> "CRE_ViewContainer%container%".equals(d.getName()))
		.findFirst();
		
		if(viewContainerCreationToolPrototypeOption.isPresent()) {
			ContainerCreationDescription viewContainerCreationToolPrototype = viewContainerCreationToolPrototypeOption.get();
			ToolSection toolSection = (ToolSection) viewContainerCreationToolPrototype.eContainer();
			List<Widget> widgets = ModelServices.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
					.flatMap(tk -> tk.getWidgets().stream())
					.filter(w -> w.isIsContainer())
					.collect(Collectors.toList());

			for(Widget widget : widgets) {
				Copier copier = new Copier();
				copier.copy(viewContainerCreationToolPrototype);
				copier.copyReferences();
				ContainerCreationDescription anotherCreationTool = (ContainerCreationDescription) copier.get(viewContainerCreationToolPrototype);
				applyStringPattern(anotherCreationTool, "%container%", widget.getName());

				toolSection.getOwnedTools().add(anotherCreationTool);
			}

			toolSection.getOwnedTools().remove(viewContainerCreationToolPrototype);
		}
	    
		// Refresh UI
		if(viewElementCreationToolPrototypeOption.isPresent() || viewContainerCreationToolPrototypeOption.isPresent()) {
			Session session = new EObjectQuery(context).getSession();
			if(session instanceof DAnalysisSessionImpl) {
			    ((DAnalysisSessionImpl)session).notifyListeners(SessionListener.VSM_UPDATED);
			}
		}
		
		return context;
	}
	
	private void applyStringPattern(EObject eObject, String pattern, String replacement) {
		for(EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures()) {
			if(eObject.eGet(feature) instanceof String) {
				String value = (String) eObject.eGet(feature);
				value = value.replaceAll(pattern, replacement);
				eObject.eSet(feature, value);
			}
		}
		eObject.eContents().forEach(e -> applyStringPattern(e, pattern, replacement));
		
	}

	// TODO Move the trace methods to a Debug sevices component
	public EObject trace(EObject receiver) {
		java.lang.System.out.println("receiver.eClass() = \"" + receiver.eClass().getName() + "\"");
		java.lang.System.out.println("receiver.toString() = \"" + receiver.toString() + "\"");
		java.lang.System.out.println("receiver.name = \"" + 
			Optional.ofNullable(receiver.eClass().getEStructuralFeature("name"))
			.map(f -> (String)receiver.eGet(f)).orElse(null) + "\"");
		
		return receiver;
	}
	
	public EObject traceVars(EObject o) {
		trace(o);
		Session session = new EObjectQuery(o).getSession();
		Map<String, ?> vars = session.getInterpreter().getVariables();
		java.lang.System.out.println(vars.keySet().size() + " variable(s)");
		for(String var : vars.keySet()) {
			java.lang.System.out.println(var + " = " + vars.get(var) + " (" + vars.get(var).getClass() + ")");
		}
		return o;
	}
	
}
