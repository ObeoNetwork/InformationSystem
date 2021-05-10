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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.internal.session.danalysis.DAnalysisSessionImpl;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.LabelAlignment;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.design.decorators.SVGImageFigure;
import org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.design.ui.RGBSystemColorUtil;
import org.obeonetwork.utils.common.StreamUtils;
import org.obeonetwork.utils.common.StringUtils;
import org.obeonetwork.utils.sirius.services.DebugServices;
import org.obeonetwork.utils.sirius.services.EObjectUtils;

/**
 * Services to use the widgets
 * 
 * @author jdupont
 * 
 */
@SuppressWarnings("restriction")
public class CinematicWidgetServices extends DebugServices {

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
	public List<WidgetEventType> getPosssibleEvents(ViewContainerReference context) {
		return context.getViewContainer().getWidget().getPossibleEvents();
	}

	/**
	 * Tests if the given ViewElement's Widget has a style defining rounded corners.
	 * Default value is false.
	 * 
	 * @param viewElement
	 * @return true if the style if the widget defines rounded corners.
	 */
	public boolean hasRoundedCorners(AbstractViewElement viewElement) {
		return Optional.ofNullable(viewElement.getWidget().getStyle()).map(s -> s.isRoundedCorners()).orElse(false);
	}
	
	public boolean isUnderlined(AbstractViewElement viewElement) {
		return Optional.ofNullable(viewElement.getWidget().getStyle()).map(s -> s.isFontUnderlined()).orElse(false);
	}
	
	public DNodeContainer setDefaultSize(DNodeContainer viewElementDNodeContainer) {
		AbstractViewElement viewElement = (AbstractViewElement) viewElementDNodeContainer.getTarget();
		
		// Get the parent Node to Launch a refresh so that the GMF view corresponding to the new DNodeContainer is created
		Node parentNode = SiriusGMFHelper.getGmfNode((DDiagramElement) viewElementDNodeContainer.eContainer());
		CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(parentNode.getDiagram());
		canonicalSynchronizer.synchronize();
		
		// Now node should not be null
		Node node = SiriusGMFHelper.getGmfNode(viewElementDNodeContainer);
		Bounds bounds = (Bounds) node.getLayoutConstraint();
		bounds.setHeight(getDefaultHeight(viewElement));
		bounds.setWidth(getDefaultWidth(viewElement));
		
		return viewElementDNodeContainer;
	}
	
	public int getDefaultHeight(AbstractViewElement viewElement) {
		return Optional.ofNullable(viewElement.getWidget().getStyle()).map(s -> s.getDefaultHeight()).orElse(-1);
	}
	
	public int getDefaultWidth(AbstractViewElement viewElement) {
		return Optional.ofNullable(viewElement.getWidget().getStyle()).map(s -> s.getDefaultWidth()).orElse(-1);
	}
	
	public LabelAlignment getLabelHorizontalAlignment(AbstractViewElement viewElement) {
		if(viewElement.getWidget().getStyle() != null) {
			return LabelAlignment.get(viewElement.getWidget().getStyle().getLabelHAlignment().getLiteral());
		}
		return LabelAlignment.CENTER;
	}
	
	public int getBorderSize(AbstractViewElement viewElement) {
		int borderSize = ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_DEFAULT_BORDER_SIZE;
		Style style = viewElement.getWidget().getStyle();
		if(style != null && !style.isBordered()) {
			borderSize = 0;
		}
		return borderSize;
	}
		
	private RGB getLabelRGB(AbstractViewElement viewElement) {
		String colorDef = "BLACK";
		if(viewElement.getWidget().getStyle() != null) {
			if(viewElement.getWidget().getStyle().getFontColor() != null) {
				colorDef = viewElement.getWidget().getStyle().getFontColor();
			}
		}
		return RGBSystemColorUtil.getRGBByName(colorDef);
	}
	
	public int getLabelColorRed(AbstractViewElement viewElement) {
		return getLabelRGB(viewElement).red;
	}
	
	public int getLabelColorGreen(AbstractViewElement viewElement) {
		return getLabelRGB(viewElement).green;
	}
	
	public int getLabelColorBlue(AbstractViewElement viewElement) {
		return getLabelRGB(viewElement).blue;
	}
	/**
	 * Tests if the ViewElement's Widget is decorated at the given cardinal position.
	 * 
	 * @param viewElement
	 * @param cardinalPosition
	 * @return true if the given ViewElement's Widget is decorated at the given cardinal position.
	 */
	public boolean hasWidgetDecoration(AbstractViewElement viewElement, String cardinalPosition) {
		return getWidgetDecoratorPath(viewElement, cardinalPosition) != null;
	}
	
	/**
	 * Returns the path to the decorator image supposed to decorate the View Element
	 * at the given cardinal position as defined in the widget it represents, or null if 
	 * no decorator is defined at this position for the widget.
	 * 
	 * @param viewElement A ViewElement representing a widget usage
	 * @param cardinalPositionLiteral The position of the decorator as an enum literal
	 * @return a path to the decorator image or null.
	 */
	public String getWidgetDecoratorPath(AbstractViewElement viewElement, String cardinalPositionLiteral) {
		
		CardinalPosition cardinalPosition = CardinalPosition.get(cardinalPositionLiteral);
		Style style = viewElement.getWidget().getStyle();
		if(cardinalPosition != null && style != null && cardinalPosition == style.getDecoratorPosition() 
				&& !StringUtils.isNullOrWhite(style.getDecorator())) {
			return style.getDecorator();
		}
		
		return null;
	}
	
	/**
	 * Note : When used from the VSM in an expression, Sirius keeps the image in
	 * cache, thus ignoring the resize of the container.
	 * 
	 * @see #getWidgetDecoratorFigure()
	 */
	private Image getWidgetDecoratorImage(AbstractViewElement viewElement, String cardinalPosition, DSemanticDecorator diagramElementContainer) {
		Image image  = null;
		
		EList<DDiagramElement> diagramElements = null;
		if(diagramElementContainer instanceof DDiagramElementContainer) {
			diagramElements = ((DDiagramElementContainer) diagramElementContainer).getElements();
		} else if(diagramElementContainer instanceof DSemanticDiagram) {
			diagramElements = ((DSemanticDiagram) diagramElementContainer).getOwnedDiagramElements();
		}
		
		DDiagramElement diagramElement = diagramElements.stream().
				filter(dde -> dde.getTarget() == viewElement)
				.findFirst().orElse(null);
		
		Style style = viewElement.getWidget().getStyle();
		String path = getWidgetDecoratorPath(viewElement, cardinalPosition);
		if(style != null && path != null) {
			
			Bounds bounds = (Bounds) SiriusGMFHelper.getGmfNode(diagramElement).getLayoutConstraint();
//			ContainerStyle containerStyle = (ContainerStyle) diagramElement.getStyle();
//			int borderThickness = (style.isBorder())? containerStyle.getBorderSize() : 0;
			int borderThickness = 4; // Seems to be the working value in any case
			
			int width = 0;
			int height = 0;
			
			if(style.isDecoratorHFill() && style.isDecoratorVFill()) {
				width = bounds.getWidth() - borderThickness;
				height = bounds.getHeight() - borderThickness;
				image  = SVGImageFigure.flyWeightImage(path, width, height);
			} else {
				image  = SVGImageFigure.flyWeightImage(path);
				if(style.isDecoratorHFill()) {
					width = bounds.getWidth() - borderThickness;
					height = (image.getBounds().height * width) / image.getBounds().width;
					image  = SVGImageFigure.flyWeightImage(path, width, height);
				} else if(style.isDecoratorVFill()) {
					height = bounds.getHeight() - borderThickness;
					width = (image.getBounds().width * height) / image.getBounds().height;
					image  = SVGImageFigure.flyWeightImage(path, width, height);
				}
			}
		}

		return image;
	}

	/**
	 * <p>
	 * Returns the figure to be used as a decoration on the given view element at
	 * the given cardinal position proportionally sized to the dimensions of the
	 * given container diagram element according to the fill attributes of the
	 * widget.
	 * </p>
	 * <p>
	 * Note: This service is not supposed to be called if
	 * getWidgetDecoratorPath(viewElement, cardinalPosition) returns null.
	 * </p>
	 * 
	 * @param viewElement
	 * @param cardinalPosition
	 * @param containerDiagramElement
	 * @return the figure to be used as a decoration or null if no decoration is
	 *         defined at this cardinal position.
	 */
	public IFigure getWidgetDecoratorFigure(AbstractViewElement viewElement, String cardinalPosition, DSemanticDecorator diagramElementContainer) {
		Image image = getWidgetDecoratorImage(viewElement, cardinalPosition, diagramElementContainer);
		if(image != null) {
			ImageFigureEx figureImage = new ImageFigureEx();
	        figureImage.setImage(image);
	        figureImage.setSize(image.getBounds().width, image.getBounds().height);
	        return figureImage;
		}
		return null;
	}
	
	public Widget getWidgetByName(CinematicElement context, String widgetName) {
		return EObjectUtils.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
				.flatMap(tk -> tk.getWidgets().stream())
				.filter(w -> w.getName().equals(widgetName))
				.findFirst().orElse(null);
	}
	
	/**
	 * Hook method to be called in the View Container Mockup root mapping semantic
	 * expression. It has the side effect of building the palette according to the
	 * widgets present in the active toolkit.
	 * 
	 * @param context This happen to be the contextual element of the diagram but it
	 *                could be any element of the Cinematic model.
	 * @return the given contextual element unchanged.
	 */
	public CinematicElement buildWidgetPalette(CinematicElement context) {
		Collection<Viewpoint> viewpoints = new EObjectQuery(context).getAvailableViewpointsInResourceSet();
		Viewpoint cinematicVP = viewpoints.stream().filter(vp -> vp.getName().equals(ICinematicViewpoint.ID)).findFirst().orElse(null);
		
		
		DiagramDescription viewContainerDiagramDescription = (DiagramDescription) cinematicVP.getOwnedRepresentations().stream()
		.filter(r -> ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID.equals(r.getName()))
		.findFirst().orElse(null); // Can't be null
		
		Optional<ContainerCreationDescription> viewElementCreationToolPrototypeOption = StreamUtils.asStream(viewContainerDiagramDescription.getDefaultLayer().eAllContents())
		.filter(ContainerCreationDescription.class::isInstance)
		.map(ContainerCreationDescription.class::cast)
		.filter(d -> "CRE_ViewElement{{widget}}".equals(d.getName()))
		.findFirst();
		
		if(viewElementCreationToolPrototypeOption.isPresent()) {
			ContainerCreationDescription viewElementCreationToolPrototype = viewElementCreationToolPrototypeOption.get();
			ToolSection toolSection = (ToolSection) viewElementCreationToolPrototype.eContainer();
			List<Widget> widgets = EObjectUtils.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
					.flatMap(tk -> tk.getWidgets().stream())
					.filter(w -> !w.isIsContainer())
					.collect(Collectors.toList());

			for(Widget widget : widgets) {
				Copier copier = new Copier();
				copier.copy(viewElementCreationToolPrototype);
				copier.copyReferences();
				ContainerCreationDescription anotherCreationTool = (ContainerCreationDescription) copier.get(viewElementCreationToolPrototype);
				applyStringPattern(anotherCreationTool, "{{widget}}", widget.getName());				
				anotherCreationTool.setDocumentation(widget.getSummary());
				toolSection.getOwnedTools().add(anotherCreationTool);
			}

			toolSection.getOwnedTools().remove(viewElementCreationToolPrototype);
		}
	    
		Optional<ContainerCreationDescription> viewContainerCreationToolPrototypeOption = StreamUtils.asStream(viewContainerDiagramDescription.getDefaultLayer().eAllContents())
		.filter(ContainerCreationDescription.class::isInstance)
		.map(ContainerCreationDescription.class::cast)
		.filter(d -> "CRE_ViewContainer{{container}}".equals(d.getName()))
		.findFirst();
		
		if(viewContainerCreationToolPrototypeOption.isPresent()) {
			ContainerCreationDescription viewContainerCreationToolPrototype = viewContainerCreationToolPrototypeOption.get();
			ToolSection toolSection = (ToolSection) viewContainerCreationToolPrototype.eContainer();
			List<Widget> widgets = EObjectUtils.getContainerOrSelf(context, CinematicRoot.class).getToolkits().stream()
					.flatMap(tk -> tk.getWidgets().stream())
					.filter(w -> w.isIsContainer())
					.collect(Collectors.toList());

			for(Widget widget : widgets) {
				Copier copier = new Copier();
				copier.copy(viewContainerCreationToolPrototype);
				copier.copyReferences();
				ContainerCreationDescription anotherCreationTool = (ContainerCreationDescription) copier.get(viewContainerCreationToolPrototype);
				applyStringPattern(anotherCreationTool, "{{container}}", widget.getName());
				anotherCreationTool.setDocumentation(widget.getSummary());
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
				value = value.replace(pattern, replacement);
				eObject.eSet(feature, value);
			}
		}
		eObject.eContents().forEach(e -> applyStringPattern(e, pattern, replacement));
		
	}
	
	public MetaDataContainer getWidgetMetadatas(EObject eObject) {
		MetaDataContainer metaDataContainer = null;
		if (eObject instanceof AbstractViewElement) {
			if (((AbstractViewElement) eObject).getMetadatas() == null) {
				metaDataContainer = EnvironmentFactory.eINSTANCE.createMetaDataContainer();				
			} else {
				metaDataContainer = ((AbstractViewElement) eObject).getMetadatas();
			}
			
			Widget widget = ((AbstractViewElement) eObject).getWidget();
			if (widget != null) {
				for (String metadataKey : widget.getMetadataKeys()) {
					Annotation annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
					annotation.setTitle(metadataKey);
					metaDataContainer.getMetadatas().add(annotation);
				}
			}
		}
		
		return metaDataContainer;
	}

}
