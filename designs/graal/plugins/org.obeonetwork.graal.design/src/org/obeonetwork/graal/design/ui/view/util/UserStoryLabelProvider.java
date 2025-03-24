/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.design.Activator;
import org.obeonetwork.graal.design.ui.view.UserStoriesView;

/**
 * @author Obeo
 *
 */
public class UserStoryLabelProvider extends StyledCellLabelProvider {

	private AdapterFactoryLabelProvider delegateLabelProvider;
	private UserStoriesView userStoriesView;
	private static Image highlightImage;
	private static Image noHighlightImage;

	/**
	 * @param userStoriesView 
	 * 
	 */
	public UserStoryLabelProvider(UserStoriesView userStoriesView, AdapterFactory adapterFactory) {
		super();
		this.userStoriesView = userStoriesView;
		this.delegateLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		if (highlightImage == null) {
			highlightImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/Highlight.gif").createImage();
		}
		if (noHighlightImage == null) {
			noHighlightImage = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/NoHighlight.gif").createImage();
		}
	}
	

	@Override
	public void dispose() {
		if (highlightImage == null) {
			highlightImage.dispose();
			highlightImage = null;
		}
		if (noHighlightImage == null) {
			noHighlightImage.dispose();
			noHighlightImage = null;
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
	 */
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		String label;
		if (element instanceof UserStory) {
			label = ((UserStory)element).getName(); 
		} else {
			label = delegateLabelProvider.getText(element);
		}
		StyledString str = new StyledString(label, getStyle(cell));
		cell.setText(str.getString());
		cell.setStyleRanges(str.getStyleRanges());
		if (isActivatedStory(cell)) {
			cell.setImage(null);
			cell.setImage(highlightImage);			
		} else {
			cell.setImage(null);
			cell.setImage(noHighlightImage);
		}
	}

	public Styler getStyle(ViewerCell cell) {
		if (isActivatedStory(cell)) {
			return new Styler() {

				/**
				 * {@inheritDoc}
				 * @see org.eclipse.jface.viewers.StyledString.Styler#applyStyles(org.eclipse.swt.graphics.TextStyle)
				 */
				@Override
				public void applyStyles(TextStyle textStyle) {
					textStyle.font = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
				}
				
			};
		}
		return null;
	}

	private boolean isActivatedStory(ViewerCell cell) {
		return cell.getElement() instanceof UserStory && userStoriesView.isActiveUserStory((UserStory) cell.getElement());	
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
	 */
	@Override
	public String getToolTipText(Object element) {
		if (element instanceof UserStory) {
			return ((UserStory) element).getDescription();
		}
		String tooltip = super.getToolTipText(element);
		if (tooltip == null && "".equals(tooltip)){
			tooltip = "No description available";
		}
		return tooltip;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipShift(java.lang.Object)
	 */
	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipDisplayDelayTime(java.lang.Object)
	 */
	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 50;
	}


}
