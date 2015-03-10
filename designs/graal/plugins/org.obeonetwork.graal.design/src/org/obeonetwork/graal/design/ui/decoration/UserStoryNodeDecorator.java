/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.decoration;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.obeonetwork.graal.UserStory;

import org.eclipse.sirius.ext.draw2d.figure.FigureUtilities;

/**
 * Decorator for nodes to display User Story information
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 */
public class UserStoryNodeDecorator extends AbstractUserStoryDecorator {
	private static final int MARGIN = 5;
	private static final int SPACING = 3;
	
	protected UserStoryNodeDecorator(IDecoratorTarget target) {
		super(target);
	}
	
	/**
	 * Refresh the decorator
	 * this method is called from the parent's refresh() method
	 */
	@Override
	public void doRefresh() {
		removeDecoration();
		if (isConcernedByActiveUserStory()) {
			IDecoration decoration = getDecoratorTarget().addDecoration(
					new UserStoryNodeFigure(getActiveUserStories(), getTargetEditPart().getFigure()),
					new UserStoryNodeLocator(getTargetEditPart().getFigure()), false);
			setDecoration(decoration);
		}
	}

	/**
	 * Decoration on node and container
	 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
	 *
	 */
	private class UserStoryNodeFigure extends Figure {
		private IFigure decorated;
		private RectangleFigure rect;
		//private Label label;
		
		/**
		 * Constructs the figure
		 * this method don't care about location and size
		 */
		public UserStoryNodeFigure(List<UserStory> userStories, IFigure decoratedFigure) {
			decorated = decoratedFigure;
			UserStory userStory = null;
			if (userStories.isEmpty() == false) {
				userStory = userStories.get(0);
			}
			
			/*String userStoryName = "";
			if (userStory != null) {
				userStoryName = userStory.getName();
			}*/
			
			ToolbarLayout layout = new ToolbarLayout(false);
			layout.setSpacing(SPACING);
			layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			setLayoutManager(layout);
			
			rect = new RectangleFigure();
			rect.setBorder(new LineBorder(pickColor(userStory), 1));
			rect.setBackgroundColor(pickColor(userStory));
			rect.setAlpha(30);
			/* to fade away underlying shapes
			rect.setBorder(new LineBorder(ColorConstants.white, 1));
			rect.setBackgroundColor(ColorConstants.white);
			rect.setAlpha(180); */
			
			/*label = new Label(userStoryName);
			label.setFont(new Font(null, "", 8, SWT.BOLD));
			label.setForegroundColor(pickColor(userStory));*/
			
			add(rect);
			//add(label);
		}
		
		/**
		 * Calculates the size
		 */
		public void calculateSize() {
			rect.setSize(decorated.getSize().getCopy().getExpanded(MARGIN * 2, MARGIN * 2));
			
			//label.setSize(label.getPreferredSize());
			
			//int totalHeight = rect.getSize().height + SPACING + label.getSize().height;
			//int totalWidth = Math.max(rect.getSize().width, label.getSize().width);
			int totalHeight = rect.getSize().height + SPACING;
			int totalWidth = rect.getSize().width;
			
			setSize(new Dimension(totalWidth, totalHeight));
		}

		/**
		 * Calculates the translation needed to center the figure around the decorated object
		 * @return
		 */
		public Point getTranslationFromDecorated() {
			int x = - MARGIN - Math.abs(getSize().width - rect.getSize().width + 1) / 2;
			int y = - MARGIN;
			return new Point(x, y);
		}
	}
	
	/**
	 * Locator used to set the Figure at the right location and size
	 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
	 *
	 */
	private final class UserStoryNodeLocator implements Locator {
		
		private final IFigure decorated;

		private UserStoryNodeLocator(IFigure decorated) {
			this.decorated = decorated;
		}

		/**
		 * Calculate size and location for the decoration
		 */
		public void relocate(IFigure target) {
			if (target instanceof Decoration) {
				// The UserStoryNodeDecoration instance is the first child of the decoration
				IFigure decoration = (IFigure)target.getChildren().get(0);
				if (decoration instanceof UserStoryNodeFigure) {
					UserStoryNodeFigure nodeDecoration = (UserStoryNodeFigure)decoration;
					nodeDecoration.calculateSize();
					Point translation = nodeDecoration.getTranslationFromDecorated();
					target.setLocation(getNewLocationFromTranslation(translation));
					target.setSize(decoration.getSize());
				}
			}
		}
		
		/**
		 * Calculates the new location
		 * scrolling and zooming must be taken into account in some cases
		 * @param translation
		 * @return Calculated location
		 */
		private Point getNewLocationFromTranslation(Point translation) {
			Point location = decorated.getBounds().getLocation().getTranslated(translation).getCopy();
			if (isInContainer()) {
				Point absoluteLocation = location.getCopy();
				decorated.translateToAbsolute(absoluteLocation);
				double actualZoom = getZoom(getTargetEditPart());
				absoluteLocation.translate(getScrollSize(getTargetEditPart()));
				absoluteLocation.performScale(1.0d / actualZoom);
				return absoluteLocation;
			} else {
				return location;
			}
		}
		
		/**
	     * Get the zoom factor.
	     * 
	     * @param part the current part
	     * @return the zoom factor
	     */
	    private double getZoom(IGraphicalEditPart part) {
	        double scale = 1.0;
	        if (part.getRoot() instanceof DiagramRootEditPart) {
	            DiagramRootEditPart rootEditPart = (DiagramRootEditPart) part.getRoot();
	            scale = rootEditPart.getZoomManager().getZoom();
	        }
	        return scale;
	    }
	    
	    /**
	     * Returns the difference between the logical origin (0, 0) and the top-left
	     * point actually visible. This corresponds to how much the scrollbars
	     * "shift" the diagram.
	     * 
	     * @param part an edit part on the view
	     * @return the scroll size
	     */
	    private Point getScrollSize(IGraphicalEditPart part) {
	        DiagramRootEditPart rootEditPart = (DiagramRootEditPart)part.getRoot();
			FreeformViewport viewport = FigureUtilities.getFreeformViewport(rootEditPart.getFigure());
	        if (viewport != null) {
	            return viewport.getViewLocation();
	        } else {
	            return new Point(0, 0);
	        }
	    }
		
	    /**
	     * Checks if the edit part is contained within a container
	     * and thus we should use absolute coordinates
	     * @return
	     */
		private boolean isInContainer() {
			boolean result = (getTargetEditPart().getParent() instanceof CompartmentEditPart);
			if (result != true) {
				result = (getTargetEditPart().getParent().getParent() instanceof CompartmentEditPart);
			}
			return result;
		}
	}
}
