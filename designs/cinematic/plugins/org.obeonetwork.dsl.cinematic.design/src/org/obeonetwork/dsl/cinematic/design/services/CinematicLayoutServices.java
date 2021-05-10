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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.LayoutDirection;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.utils.common.StreamUtils;

public class CinematicLayoutServices {

	public static Layout extractLayout(DDiagram viewContainerDDiagram) {
		// Launch refresh so that the GMF views are created and up to date
		Diagram gmfDiagram = SiriusGMFHelper.getGmfDiagram(viewContainerDDiagram);
		CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(gmfDiagram);
		canonicalSynchronizer.synchronize();
		
		ViewContainer viewContainer = (ViewContainer) new DDiagramQuery(viewContainerDDiagram).getRepresentationDescriptor().getTarget();
		DNodeContainer rootDNC = viewContainerDDiagram.getOwnedDiagramElements().stream()
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
		
		Bounds viewContainerBounds = getBounds(rootDNC);
		
		Layout viewContainerLayout = createOrReuseLayout(viewContainerBounds, LayoutDirection.VERTICAL, viewContainer, existingLayouts);
		
		buildSubLayouts(viewContainerLayout, rootDNC, existingLayouts);
		
		return viewContainerLayout;
	}

	private static void buildSubLayouts(Layout viewContainerLayout, DNodeContainer viewContainerDNC, Map<AbstractViewElement, Layout> existingLayouts) {
		EList<DDiagramElement> ownedDiagramElements = viewContainerDNC.getOwnedDiagramElements();
		Map<DDiagramElement, Layout> diagramElementToLayout = createLayoutCompartments(viewContainerLayout, ownedDiagramElements, existingLayouts);
		
		for(DDiagramElement ownedDiagramElement : ownedDiagramElements) {
			if(ownedDiagramElement.getTarget() instanceof ViewContainer) {
				buildSubLayouts(diagramElementToLayout.get(ownedDiagramElement), (DNodeContainer) ownedDiagramElement, existingLayouts);
			}
		}
	}

	private static Map<DDiagramElement, Layout> createLayoutCompartments(Layout viewContainerLayout, List<DDiagramElement> ownedDiagramElements, Map<AbstractViewElement, Layout> existingLayouts) {
		Map<DDiagramElement, Layout> diagramElementToLayout = new HashMap<>();
		
		Map<Bounds, DDiagramElement> boundsToDiagramElements = new HashMap<>();
		ownedDiagramElements.forEach(dde -> boundsToDiagramElements.put(getBounds(dde), dde));
		
		List<Integer> transversals = getTransversals(viewContainerLayout.getDirection(), boundsToDiagramElements.keySet());
		for(int i = 0; i < transversals.size() - 1; i++) {
			int t1 = transversals.get(i);
			int t2 = transversals.get(i + 1);
			List<Bounds> containedBounds = getContainedBounds(t1, t2, viewContainerLayout.getDirection(), boundsToDiagramElements.keySet());
			if(containedBounds.size() == 1) {
				Bounds bounds = containedBounds.get(0);
				DDiagramElement diagramElement = boundsToDiagramElements.get(bounds);
				Layout subLayout = createOrReuseLayout(bounds, 
						switchDirection(viewContainerLayout.getDirection()), 
						(AbstractViewElement)diagramElement.getTarget(),
						existingLayouts);
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				diagramElementToLayout.put(diagramElement, subLayout);
			} else if(containedBounds.size() > 1) {
				Bounds containingBounds = computeContainingBounds(containedBounds);
				List<DDiagramElement> diagramElements = containedBounds.stream().map(b -> boundsToDiagramElements.get(b)).collect(toList());
				Layout subLayout = createOrReuseLayout(containingBounds, 
						switchDirection(viewContainerLayout.getDirection()), 
						null,
						existingLayouts);
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				Map<DDiagramElement, Layout> subDiagramElementToLayout = createLayoutCompartments(subLayout, diagramElements, existingLayouts);
				diagramElementToLayout.putAll(subDiagramElementToLayout);
			}
		}
		return diagramElementToLayout;
	}

	private static Bounds computeContainingBounds(List<Bounds> containedBounds) {
		int lowX = 0;
		int lowY = 0;
		int highX = 0;
		int highY = 0;
		if(!containedBounds.isEmpty()) {
			Bounds any = containedBounds.get(0);
			lowX = any.getX();
			highX = lowX + any.getWidth();
			lowY = any.getY();
			highY = lowY + any.getHeight();
			for(Bounds bounds : containedBounds) {
				lowX = Math.min(lowX, bounds.getX());
				highX = Math.max(highX, bounds.getX() + bounds.getWidth());
				lowY = Math.min(lowY, bounds.getY());
				highY = Math.max(highY, bounds.getY() + bounds.getHeight());
			}
		}
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(lowX);
		bounds.setY(lowY);
		bounds.setWidth(highX - lowX);
		bounds.setHeight(highY - lowY);
		return bounds;
	}

	private static List<Bounds> getContainedBounds(int t1, int t2, LayoutDirection d, Collection<Bounds> boundsCollection) {
		return boundsCollection.stream().filter(bounds -> getLowCoordinate(bounds, d) >= t1 && getHighCoordinate(bounds, d) <= t2).collect(toList());
	}

	private static List<Integer> getTransversals(LayoutDirection d, Collection<Bounds> boundsCollection) {
		Set<Integer> transversals = new HashSet<>();
		for(Bounds bounds : boundsCollection) {
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

	private static boolean isTransversal(int c, Collection<Bounds> boundsCollection, LayoutDirection d) {
		boolean isTransversal = true;
		Iterator<Bounds> boundsIterator = boundsCollection.iterator();
		while(isTransversal && boundsIterator.hasNext()) {
			Bounds bounds = boundsIterator.next();
			isTransversal = isTransversal && (c <= getLowCoordinate(bounds, d) || c >= getHighCoordinate(bounds, d));
		}
		
		return isTransversal;
	}

	private static int getLowCoordinate(Bounds bounds, LayoutDirection d) {
		int c = 0;
		switch (d) {
		case HORIZONTAL:
			c = bounds.getX();
			break;
		case VERTICAL:
			c = bounds.getY();
			break;
		}
		return c;
	}

	private static int getHighCoordinate(Bounds bounds, LayoutDirection d) {
		int c = 0;
		switch (d) {
		case HORIZONTAL:
			c = bounds.getX() + bounds.getWidth();
			break;
		case VERTICAL:
			c = bounds.getY() + bounds.getHeight();
			break;
		}
		return c;
	}

	private static Layout createOrReuseLayout(Bounds bounds, LayoutDirection direction, AbstractViewElement viewElement, Map<AbstractViewElement, Layout> existingLayouts) {
		Layout layout = null;
		if(existingLayouts != null && viewElement != null) {
			layout = existingLayouts.get(viewElement);
		}
		if(layout == null) {
			layout = ViewFactory.eINSTANCE.createLayout();
		}
		layout.setViewElement(viewElement);
		layout.setX(bounds.getX());
		layout.setY(bounds.getY());
		layout.setHeight(bounds.getHeight());
		layout.setWidth(bounds.getWidth());
		layout.setDirection(direction);
		return layout;
	}

	private static LayoutDirection switchDirection(LayoutDirection direction) {
		LayoutDirection other = null;
		switch (direction) {
		case HORIZONTAL:
			other = LayoutDirection.VERTICAL;
			break;
		case VERTICAL:
			other = LayoutDirection.HORIZONTAL;
			break;
		}
		return other;
	}

	public static Bounds getBounds(DDiagramElement dDiagramElement) {
		Node node = SiriusGMFHelper.getGmfNode(dDiagramElement);
		Bounds bounds= (Bounds)node.getLayoutConstraint();
		return bounds;
	}

	public static void restoreLayout(ViewContainer viewContainer, DDiagram viewContainerDDiagram) {
		DNodeContainer rootDNC = viewContainerDDiagram.getOwnedDiagramElements().stream()
				.filter(e -> e.getTarget() == viewContainer)
				.map(DNodeContainer.class::cast)
				.findFirst().orElse(null);
		
		restoreLayout(viewContainer.getLayout(), rootDNC);
		
		DialectManager.INSTANCE.refresh(viewContainerDDiagram, new NullProgressMonitor());
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
		Bounds adjustedGmfBounds = computePreviewBounds(layout);
		Bounds gmfBounds = getBounds(layoutDNC);
		gmfBounds.setX(adjustedGmfBounds.getX());
		gmfBounds.setY(adjustedGmfBounds.getY());
		gmfBounds.setWidth(adjustedGmfBounds.getWidth());
		gmfBounds.setHeight(adjustedGmfBounds.getHeight());

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
	private static Bounds computePreviewBounds(Layout layout) {
		final int margin = 16; // Magic value
		
		int x = layout.getX();
		int y = layout.getY();
		if(layout.eContainer() instanceof Layout && ((Layout) layout.eContainer()).getViewElement() == null) {
			Layout virtualLayout = (Layout) layout.eContainer();
			x -= virtualLayout.getX();
			y -= virtualLayout.getY();
		}
		
		Bounds adjustedGmfBounds = NotationFactory.eINSTANCE.createBounds();
		if(layout.getOwnedLayouts().isEmpty()) {
			adjustedGmfBounds.setX(x);
			adjustedGmfBounds.setY(y);
			adjustedGmfBounds.setWidth(layout.getWidth());
			adjustedGmfBounds.setHeight(layout.getHeight());
		} else {
			Bounds boundingArea = computeContainingBounds(layout.getOwnedLayouts().stream()
					.map(childLayout -> computePreviewBounds(childLayout))
					.collect(toList()));
			
			adjustedGmfBounds.setX(x);
			adjustedGmfBounds.setY(y);
			adjustedGmfBounds.setWidth(Math.max(boundingArea.getWidth() + margin, layout.getWidth()));
			adjustedGmfBounds.setHeight(Math.max(boundingArea.getHeight() + margin, layout.getHeight()));
		}
		return adjustedGmfBounds;
	}

	private static void restoreLayout(Layout layout, DDiagramElement dDiagramElement) {
		Bounds bounds = getBounds(dDiagramElement);
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
