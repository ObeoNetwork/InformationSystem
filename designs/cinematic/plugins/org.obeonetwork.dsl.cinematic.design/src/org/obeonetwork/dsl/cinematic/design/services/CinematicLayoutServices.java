package org.obeonetwork.dsl.cinematic.design.services;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.eclipse.sirius.diagram.ui.internal.refresh.GMFHelper;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.LayoutDirection;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.utils.common.StreamUtils;
import org.obeonetwork.utils.sirius.services.EObjectUtils;

@SuppressWarnings("restriction")
public class CinematicLayoutServices {

	public static Layout extractLayout(DDiagram mockupDiagram) {
		// Launch refresh so that the GMF views are created and up to date
		Diagram gmfDiagram = SiriusGMFHelper.getGmfDiagram(mockupDiagram);
		CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(gmfDiagram);
		canonicalSynchronizer.synchronize();
		
		ViewContainer viewContainer = (ViewContainer) new DDiagramQuery(mockupDiagram).getRepresentationDescriptor().getTarget();
		DNodeContainer rootDNC = mockupDiagram.getOwnedDiagramElements().stream()
				.filter(e -> e.getTarget() == viewContainer)
				.map(DNodeContainer.class::cast)
				.findFirst().orElse(null);
		
		List<Layout> allLayouts = StreamUtils.asStream(viewContainer.eAllContents())
				.filter(Layout.class::isInstance).map(Layout.class::cast)
				.collect(toList());
		
		Map<AbstractViewElement, Layout> existingLayouts = new HashMap<>();
		allLayouts.stream()
		.filter(l -> l.getViewElement() != null)
		.forEach(l -> existingLayouts.put(l.getViewElement(), l));
		
		allLayouts.forEach(l -> EcoreUtil.remove(l));
		
		Rectangle viewContainerBounds = computeGmfBounds(rootDNC);
		
		Layout viewContainerLayout = createOrReuseLayout(viewContainerBounds, LayoutDirection.VERTICAL, viewContainer, existingLayouts);
		
		buildSubLayouts(viewContainerLayout, rootDNC, existingLayouts);
		
		return viewContainerLayout;
	}

	private static void buildSubLayouts(Layout viewContainerLayout, DNodeContainer viewContainerDNC, Map<AbstractViewElement, Layout> existingLayouts) {
		EList<DDiagramElement> ownedDiagramElements = viewContainerDNC.getOwnedDiagramElements();
		Map<DDiagramElement, Layout> diagramElementToLayout = createLayoutCompartments(viewContainerLayout, ownedDiagramElements, existingLayouts);
		
		for(DDiagramElement ownedDiagramElement : ownedDiagramElements) {
			if(ownedDiagramElement.getTarget() instanceof ViewContainer && diagramElementToLayout.get(ownedDiagramElement) != null) {
				buildSubLayouts(diagramElementToLayout.get(ownedDiagramElement), (DNodeContainer) ownedDiagramElement, existingLayouts);
			}
		}
	}

	private static Map<DDiagramElement, Layout> createLayoutCompartments(Layout viewContainerLayout, List<DDiagramElement> ownedDiagramElements, Map<AbstractViewElement, Layout> existingLayouts) {
		Map<DDiagramElement, Layout> diagramElementToLayout = new HashMap<>();
		
		if(EObjectUtils.getAncestors(viewContainerLayout).stream()
				.filter(Layout.class::isInstance).map(Layout.class::cast)
				.anyMatch(l -> 
					l.getX() == viewContainerLayout.getX() &&
					l.getY() == viewContainerLayout.getY() &&
					l.getWidth() == viewContainerLayout.getWidth() &&
					l.getHeight() == viewContainerLayout.getHeight())) {
			// TODO Manage this exception case properly
			System.out.println("Something went wrong extracting the layout");
			return diagramElementToLayout;
		}
		
		Map<Rectangle, DDiagramElement> boundsToDiagramElements = new HashMap<>();
		ownedDiagramElements.forEach(dde -> boundsToDiagramElements.put(computeGmfBounds(dde), dde));
		
		List<Integer> hTransversals = getTransversals(LayoutDirection.HORIZONTAL, boundsToDiagramElements.keySet());
		List<Integer> vTransversals = getTransversals(LayoutDirection.VERTICAL, boundsToDiagramElements.keySet());
		
		List<Integer> transversals = null;
		if(hTransversals.size() > vTransversals.size()) {
			transversals = hTransversals;
			viewContainerLayout.setDirection(LayoutDirection.HORIZONTAL);
		} else {
			transversals = vTransversals;
			// viewContainerLayout.direction defaults to VERTICAL
		}
		
		for(int i = 0; i < transversals.size() - 1; i++) {
			int t1 = transversals.get(i);
			int t2 = transversals.get(i + 1);
			List<Rectangle> containedBounds = getContainedBounds(t1, t2, viewContainerLayout.getDirection(), boundsToDiagramElements.keySet());
			if(containedBounds.size() == 1) {
				Rectangle bounds = containedBounds.get(0);
				DDiagramElement diagramElement = boundsToDiagramElements.get(bounds);
				Layout subLayout = createOrReuseLayout(bounds, 
						LayoutDirection.VERTICAL, 
						(AbstractViewElement)diagramElement.getTarget(),
						existingLayouts);
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				diagramElementToLayout.put(diagramElement, subLayout);
			} else if(containedBounds.size() > 1) {
				Rectangle containingBounds = computeContainingBounds(containedBounds);
				List<DDiagramElement> diagramElements = containedBounds.stream().map(b -> boundsToDiagramElements.get(b)).collect(toList());
				Layout subLayout = createOrReuseLayout(containingBounds, 
						LayoutDirection.VERTICAL, 
						null,
						existingLayouts);
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				Map<DDiagramElement, Layout> subDiagramElementToLayout = createLayoutCompartments(subLayout, diagramElements, existingLayouts);
				diagramElementToLayout.putAll(subDiagramElementToLayout);
			}
		}
		return diagramElementToLayout;
	}

	private static Rectangle computeContainingBounds(List<Rectangle> containedBounds) {
		int lowX = 0;
		int lowY = 0;
		int highX = 0;
		int highY = 0;
		if(!containedBounds.isEmpty()) {
			Rectangle any = containedBounds.get(0);
			lowX = any.x();
			highX = lowX + any.width();
			lowY = any.y();
			highY = lowY + any.height();
			for(Rectangle bounds : containedBounds) {
				lowX = Math.min(lowX, bounds.x());
				highX = Math.max(highX, bounds.x() + bounds.width());
				lowY = Math.min(lowY, bounds.y());
				highY = Math.max(highY, bounds.y() + bounds.height());
			}
		}
		
		return new PrecisionRectangle(lowX, lowY, highX - lowX, highY - lowY);
	}

	private static List<Rectangle> getContainedBounds(int t1, int t2, LayoutDirection d, Collection<Rectangle> boundsCollection) {
		return boundsCollection.stream().filter(bounds -> getLowCoordinate(bounds, d) >= t1 && getHighCoordinate(bounds, d) <= t2).collect(toList());
	}

	private static List<Integer> getTransversals(LayoutDirection d, Collection<Rectangle> boundsCollection) {
		Set<Integer> transversals = new HashSet<>();
		for(Rectangle bounds : boundsCollection) {
			int low = getLowCoordinate(bounds, d);
			if(isTransversal(low, boundsCollection, d)) {
				transversals.add(low);
			}
			int high = getHighCoordinate(bounds, d);
			if(isTransversal(high, boundsCollection, d)) {
				transversals.add(high);
			}
		}
		
		return transversals.stream().sorted().collect(toList());
	}

	private static boolean isTransversal(int c, Collection<Rectangle> boundsCollection, LayoutDirection d) {
		boolean isTransversal = true;
		Iterator<Rectangle> boundsIterator = boundsCollection.iterator();
		while(isTransversal && boundsIterator.hasNext()) {
			Rectangle bounds = boundsIterator.next();
			isTransversal = isTransversal && (c <= getLowCoordinate(bounds, d) || c >= getHighCoordinate(bounds, d));
		}
		
		return isTransversal;
	}

	private static int getLowCoordinate(Rectangle bounds, LayoutDirection d) {
		int c = 0;
		switch (d) {
		case HORIZONTAL:
			c = bounds.x();
			break;
		case VERTICAL:
			c = bounds.y();
			break;
		}
		return c;
	}

	private static int getHighCoordinate(Rectangle bounds, LayoutDirection d) {
		int c = 0;
		switch (d) {
		case HORIZONTAL:
			c = bounds.x() + bounds.width();
			break;
		case VERTICAL:
			c = bounds.y() + bounds.height();
			break;
		}
		return c;
	}

	private static Layout createOrReuseLayout(Rectangle bounds, LayoutDirection direction, AbstractViewElement viewElement, Map<AbstractViewElement, Layout> existingLayouts) {
		Layout layout = null;
		if(existingLayouts != null && viewElement != null) {
			layout = existingLayouts.get(viewElement);
		}
		if(layout == null) {
			layout = ViewFactory.eINSTANCE.createLayout();
		}
		layout.setViewElement(viewElement);
		layout.setX(bounds.x());
		layout.setY(bounds.y());
		layout.setHeight(bounds.height());
		layout.setWidth(bounds.width());
		layout.setDirection(direction);
		return layout;
	}

	private static Bounds getGmfBounds(DDiagramElement dDiagramElement) {
		Node gmfNode = SiriusGMFHelper.getGmfNode(dDiagramElement);
		Bounds gmfBounds = (Bounds)gmfNode.getLayoutConstraint();
		return gmfBounds;
	}

	private static Rectangle computeGmfBounds(DDiagramElement dDiagramElement) {
		Node gmfNode = SiriusGMFHelper.getGmfNode(dDiagramElement);
		Bounds gmfBounds = (Bounds)gmfNode.getLayoutConstraint();
		
		Rectangle draw2dBounds = GMFHelper.getAbsoluteBounds(gmfNode, false);
		draw2dBounds.setX(gmfBounds.getX());
		draw2dBounds.setY(gmfBounds.getY());
		
		return draw2dBounds;
	}
	
	public static void restoreLayout(ViewContainer viewContainer, DDiagram mockupDiagram) {
		DNodeContainer rootDNC = mockupDiagram.getOwnedDiagramElements().stream()
				.filter(e -> e.getTarget() == viewContainer)
				.map(DNodeContainer.class::cast)
				.findFirst().orElse(null);
		
		restoreLayout(viewContainer.getLayout(), rootDNC);
		
		DialectManager.INSTANCE.refresh(mockupDiagram, new NullProgressMonitor());
	}
	
	public static void previewLayout(Layout layout, DDiagram layoutDDiagram) {
		DNodeContainer rootDNC = layoutDDiagram.getOwnedDiagramElements().stream()
				.filter(e -> e.getTarget() == layout)
				.map(DNodeContainer.class::cast)
				.findFirst().orElse(null);
		
		previewLayout(rootDNC);
		
		DialectManager.INSTANCE.refresh(layoutDDiagram, new NullProgressMonitor());
	}
	
	private static void previewLayout(DNodeContainer layoutDNC) {
		Layout layout = (Layout) layoutDNC.getTarget();
		Rectangle adjustedGmfBounds = computePreviewBounds(layout);
		Bounds gmfBounds = getGmfBounds(layoutDNC);
		gmfBounds.setX(adjustedGmfBounds.x());
		gmfBounds.setY(adjustedGmfBounds.y());
		gmfBounds.setWidth(adjustedGmfBounds.width());
		gmfBounds.setHeight(adjustedGmfBounds.height());

		layoutDNC.getOwnedDiagramElements().stream()
		.filter(de -> de.getTarget() instanceof Layout)
		.map(DNodeContainer.class::cast)
		.forEach(childLayoutDNC -> previewLayout(childLayoutDNC));
	}

	/**
	 * Compute the GMF Bounds that will allow a non overlaping visualisation of the
	 * Layout objects, taking into account the fact that space has to be added to
	 * insert the border of the structural Layouts (not linked to any View Element).
	 * 
	 * @param layout
	 * @return
	 */
	private static Rectangle computePreviewBounds(Layout layout) {
		final int margin = 16; // Magic value
		
		int x = layout.getX();
		int y = layout.getY();
		if(layout.eContainer() instanceof Layout && ((Layout) layout.eContainer()).getViewElement() == null) {
			Layout virtualLayout = (Layout) layout.eContainer();
			x -= virtualLayout.getX();
			y -= virtualLayout.getY();
		}
		
		Rectangle adjustedGmfBounds = new PrecisionRectangle();
		if(layout.getOwnedLayouts().isEmpty()) {
			adjustedGmfBounds.setX(x);
			adjustedGmfBounds.setY(y);
			adjustedGmfBounds.setWidth(layout.getWidth());
			adjustedGmfBounds.setHeight(layout.getHeight());
		} else {
			Rectangle boundingArea = computeContainingBounds(layout.getOwnedLayouts().stream()
					.map(childLayout -> computePreviewBounds(childLayout))
					.collect(toList()));
			
			adjustedGmfBounds.setX(x);
			adjustedGmfBounds.setY(y);
			adjustedGmfBounds.setWidth(Math.max(boundingArea.width() + margin, layout.getWidth()));
			adjustedGmfBounds.setHeight(Math.max(boundingArea.height() + margin, layout.getHeight()));
		}
		return adjustedGmfBounds;
	}

	private static void restoreLayout(Layout layout, DDiagramElement dDiagramElement) {
		Bounds bounds = getGmfBounds(dDiagramElement);
		bounds.setX(layout.getX());
		bounds.setY(layout.getY());
		bounds.setWidth(layout.getWidth());
		bounds.setHeight(layout.getHeight());
		
		if(dDiagramElement instanceof DNodeContainer) {
			for(DDiagramElement childDiagramElement : ((DNodeContainer) dDiagramElement).getOwnedDiagramElements()) {
				if(childDiagramElement.getTarget() instanceof AbstractViewElement) {
					Layout childLayout = getViewElementLayout(layout, (AbstractViewElement) childDiagramElement.getTarget());
					if(childLayout != null) {
						restoreLayout(childLayout, childDiagramElement);
					}
				}
			}
		}
		
	}

	private static Layout getViewElementLayout(Layout layout, AbstractViewElement viewElement) {
		Queue<Layout> queue = new LinkedList<>();
		queue.add(layout);
		while(!queue.isEmpty()) {
			Layout l = queue.poll();
			if(l.getViewElement() == viewElement) {
				return l;
			}
			queue.addAll(l.getOwnedLayouts());
		}
		return null;
	}	
}
