package org.obeonetwork.dsl.cinematic.design.services.flows.listeners;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.obeonetwork.dsl.cinematic.design.services.flows.providers.ViewContainerTreeContentProvider;

public class ViewContainerHideBoundContainersListener extends SelectionAdapter {

	private ViewContainerTreeContentProvider containerTreeContentProvider;
	private CheckboxTreeViewer checkboxTreeViewer;
	
	public ViewContainerHideBoundContainersListener(CheckboxTreeViewer checkboxTreeViewer, ViewContainerTreeContentProvider containerTreeContentProvider) {
		this.checkboxTreeViewer = checkboxTreeViewer;
		this.containerTreeContentProvider = containerTreeContentProvider;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {		
		containerTreeContentProvider.switchHideContainersBoundToOtherViewStates();
		checkboxTreeViewer.refresh();
	}

}
