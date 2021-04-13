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
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.LayoutDirection;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;

public class CinematicLayoutServices {

	public static Layout extractLayout(DNodeContainer viewContainerDNC) {
		
		// Launch refresh so that the GMF views are created and up to date
		refreshDiagram(viewContainerDNC);
		
		Bounds viewContainerBounds = getBounds(viewContainerDNC);
		ViewContainer viewContainer = (ViewContainer) viewContainerDNC.getTarget();
		
		Layout viewContainerLayout = createLayout(viewContainerBounds, LayoutDirection.VERTICAL, viewContainer);
		
		populateLayout(viewContainerLayout, viewContainerDNC);
		
		return viewContainerLayout;
	}

	private static void refreshDiagram(DNodeContainer viewContainerDNC) {
		Node viewContainerNode = SiriusGMFHelper.getGmfNode(viewContainerDNC);
		CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(viewContainerNode.getDiagram());
		canonicalSynchronizer.synchronize();
	}

	private static void populateLayout(Layout viewContainerLayout, DNodeContainer viewContainerDNC) {
		EList<DDiagramElement> ownedDiagramElements = viewContainerDNC.getOwnedDiagramElements();
		Map<DDiagramElement, Layout> diagramElementToLayout = createLayoutCompartments(viewContainerLayout, ownedDiagramElements);
		
		for(DDiagramElement ownedDiagramElement : ownedDiagramElements) {
			if(ownedDiagramElement.getTarget() instanceof ViewContainer) {
				populateLayout(diagramElementToLayout.get(ownedDiagramElement), (DNodeContainer) ownedDiagramElement);
			}
		}
	}

	private static Map<DDiagramElement, Layout> createLayoutCompartments(Layout viewContainerLayout, List<DDiagramElement> ownedDiagramElements) {
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
				Layout subLayout = createLayout(bounds, 
						switchDirection(viewContainerLayout.getDirection()), 
						(AbstractViewElement)diagramElement.getTarget());
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				diagramElementToLayout.put(diagramElement, subLayout);
			} else if(containedBounds.size() > 1) {
				Bounds containingBounds = computeContainingBounds(containedBounds);
				List<DDiagramElement> diagramElements = containedBounds.stream().map(b -> boundsToDiagramElements.get(b)).collect(toList());
				Layout subLayout = createLayout(containingBounds, 
						switchDirection(viewContainerLayout.getDirection()), 
						null);
				viewContainerLayout.getOwnedLayouts().add(subLayout);
				Map<DDiagramElement, Layout> subDiagramElementToLayout = createLayoutCompartments(subLayout, diagramElements);
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

	private static Layout createLayout(Bounds bounds, LayoutDirection direction, AbstractViewElement viewElement) {
		Layout layout = ViewFactory.eINSTANCE.createLayout();
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

	public static void restoreLayout(ViewContainer viewContainer, DNodeContainer viewContainerDNC) {
		restoreLayout(viewContainer.getLayout(), viewContainerDNC);
		DialectManager.INSTANCE.refresh(viewContainerDNC.getParentDiagram(), new NullProgressMonitor());
	}
	
	public static void previewLayout(Layout layout, DNodeContainer layoutDNC) {
		previewLayout(layoutDNC);
		DialectManager.INSTANCE.refresh(layoutDNC.getParentDiagram(), new NullProgressMonitor());
	}

	// TODO take into account the thickness of the borders
	private static void previewLayout(DNodeContainer layoutDNC) {
		Layout layout = (Layout) layoutDNC.getTarget();
		Bounds bounds = getBounds(layoutDNC);
		bounds.setX(layout.getX());
		bounds.setY(layout.getY());
		bounds.setWidth(layout.getWidth());
		bounds.setHeight(layout.getHeight());
		for(DNodeContainer childLayoutDNC : layoutDNC.getOwnedDiagramElements().stream().filter(de -> de.getTarget() instanceof Layout).map(DNodeContainer.class::cast).collect(toList())) {
			previewLayout(childLayoutDNC);
		}
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
