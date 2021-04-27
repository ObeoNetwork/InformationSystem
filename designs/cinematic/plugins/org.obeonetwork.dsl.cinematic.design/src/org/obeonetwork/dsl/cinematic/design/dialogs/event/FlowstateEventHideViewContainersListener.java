package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
public class FlowstateEventHideViewContainersListener extends SelectionAdapter {
	
	private CheckboxTreeViewer checkboxTreeViewer;
	private FlowstateEventContentProvider containerTreeContentProvider;

	
	public FlowstateEventHideViewContainersListener(CheckboxTreeViewer checkboxTreeViewer,
			FlowstateEventContentProvider containerTreeContentProvider) {	
		this.checkboxTreeViewer = checkboxTreeViewer;
		this.containerTreeContentProvider = containerTreeContentProvider;
	}


	@Override
	public void widgetSelected(SelectionEvent e) {		
		containerTreeContentProvider.switchHideNonContextualViewContainers();
		checkboxTreeViewer.refresh();
	}
}
