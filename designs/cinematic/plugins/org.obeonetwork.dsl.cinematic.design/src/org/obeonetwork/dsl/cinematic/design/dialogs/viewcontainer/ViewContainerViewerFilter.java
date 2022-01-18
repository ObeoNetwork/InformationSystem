/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer;

import org.eclipse.core.internal.propertytester.StringMatcher;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.StringUtils;

@SuppressWarnings("restriction")
/**
 * Class managing filtering over the {@link CheckboxTreeViewer} and listening to the text input area.
 * When is entered in the area, a query is produced and recursively applied to the elements of the tree.  
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class ViewContainerViewerFilter extends ViewerFilter implements KeyListener {
	
	private StringMatcher matcher;
	private CheckboxTreeViewer checkboxTreeViewer;
	private String query;
	
	public ViewContainerViewerFilter(CheckboxTreeViewer checkboxTreeViewer) {	
		this.checkboxTreeViewer = checkboxTreeViewer;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (StringUtils.isNullOrWhite(query)) { // We display the full tree when no query is entered
			return true;
		} else {
			boolean isChildrenFiltered = false;
			if (element instanceof ViewContainer) {
				isChildrenFiltered = ((ViewContainer) element).getViewContainers().stream().anyMatch(v -> select(viewer, element, v));				
			}
			// we display elements if its name matches with the query, or if it contains elements that do.
			return isChildrenFiltered || matcher.match(((ViewContainer) element).getName());
		}				
	}

	@Override
	public void keyPressed(KeyEvent e) {				
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		// We update the query when text is typed, and immediately refresh the model.
		// If this filter gets slow on massive trees, performances could be improved here.
		query = ((Text) e.widget).getText().trim();
		matcher = new StringMatcher (query);
		checkboxTreeViewer.refresh();		
	}	
}
