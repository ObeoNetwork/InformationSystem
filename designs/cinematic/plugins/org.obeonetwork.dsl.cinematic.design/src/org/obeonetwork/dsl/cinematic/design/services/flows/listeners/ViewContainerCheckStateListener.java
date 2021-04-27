package org.obeonetwork.dsl.cinematic.design.services.flows.listeners;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class ViewContainerCheckStateListener implements ICheckStateListener {
	private ViewState viewState;
	private CheckboxTreeViewer checkboxTreeViewer;
		
	public ViewContainerCheckStateListener(CheckboxTreeViewer checkboxTreeViewer, ViewState viewState) {
		super();
		this.viewState = viewState;
		this.checkboxTreeViewer = checkboxTreeViewer;
	}


	@Override
	public void checkStateChanged(CheckStateChangedEvent event) {
		ViewContainer container = (ViewContainer) event.getElement();
		if (event.getChecked()) {
			viewState.getViewContainers().add(container);									
		 
			/**
			 * if a parent viewContainer is added to the view state
			 * we remove its children from the viewstate, since
			 * they are included in it, and we dont want duplicate
			 * links in the view 
			 */
			container.eAllContents().forEachRemaining(eObject -> {
				viewState.getViewContainers().remove(eObject);
			});
			
			checkboxTreeViewer.expandToLevel(container, TreeViewer.ALL_LEVELS);
		} else {
			// FIXME @VRI: Should we be able to uncheck children containers ? If so: what happens ? 
			viewState.getViewContainers().remove(container);
		}
		
		checkboxTreeViewer.refresh();
	}
}
