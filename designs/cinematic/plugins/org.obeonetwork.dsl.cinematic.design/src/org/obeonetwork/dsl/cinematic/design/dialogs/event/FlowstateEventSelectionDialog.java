/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.dsl.cinematic.design.dialogs.Messages;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class FlowstateEventSelectionDialog extends Dialog {
	private Text txtFilterText;
	private Transition transition;
	
	// WidgetEventTypes used in ViewEvents need to be related to the AbstractViewElement it belongs to.
	// We store in these data structures the events linked to the transition. 
	// They are added/removed to the transition once the OK button is pressed.
	private Map<AbstractViewElement, Collection<WidgetEventType>> viewElementWidgetMap;
	private Collection<FlowEvent> flowEventsCollection;	
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public FlowstateEventSelectionDialog(Shell parentShell, Transition transition) {
		super(parentShell);
		this.transition = transition;
		setShellStyle(SWT.SHELL_TRIM);
		initializeEventCollections();		
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));
		
		Button btnCheckButton = new Button(composite, SWT.CHECK);

		btnCheckButton.setText(Messages.CinematicDialog_hideNonContextualViewContainers);
		new Label(composite, SWT.NONE);
		
		txtFilterText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFilterText.setMessage(Messages.CinematicDialog_filterText);
		
		Button btnClearButton = new Button(composite, SWT.NONE);
		btnClearButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnClearButton.setText(Messages.CinematicDialog_clear);
		
		CheckboxTreeViewer checkboxTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		Tree tree = checkboxTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		FlowstateEventContentProvider contentProvider = new FlowstateEventContentProvider(transition);
		
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				contentProvider.switchHideNonContextualViewContainers();
				checkboxTreeViewer.refresh();
			}				
		});
		
		btnCheckButton.setSelection(contentProvider.isHideNonContextualViewContainer());
		
		FlowstateEventViewerFilter eventViewerFilter = new FlowstateEventViewerFilter(checkboxTreeViewer);
		txtFilterText.addKeyListener(eventViewerFilter);
		
		checkboxTreeViewer.setFilters(eventViewerFilter);
		checkboxTreeViewer.setContentProvider(contentProvider);		
		checkboxTreeViewer.setLabelProvider(new FlowstateEventLabelProvider());					
		checkboxTreeViewer.setCheckStateProvider(new FlowstateEventCheckstateProvider(viewElementWidgetMap, flowEventsCollection));
		checkboxTreeViewer.addCheckStateListener(new FlowstateEventCheckstateListener(viewElementWidgetMap, flowEventsCollection));	
		checkboxTreeViewer.setInput(transition);
		
		btnClearButton.addListener(SWT.Selection, event -> {
			txtFilterText.setText(""); // clearing the text input		 //$NON-NLS-1$
			event.widget = txtFilterText;
			txtFilterText.notifyListeners(SWT.KeyUp, event); // we notify the text area listeners to consider the new text value.
		});
		
		return container;
	}

	/**
	 * Populates the transition's events collections with the events currently referred in the 'on' attribute of the {@link Transition}  
	 * By storing this data when the dialog starts, it is possible to know which events are added/removed once the dialog is closed.
	 */
	private void initializeEventCollections() {
		viewElementWidgetMap = new HashMap<>();
		flowEventsCollection = new ArrayList<>();		

		transition.getOn().forEach(event -> {
			if (event instanceof FlowEvent) {
				flowEventsCollection.add((FlowEvent) event);
			}
			
			if (event instanceof ViewEvent) {
				AbstractViewElement abstractViewElement = (AbstractViewElement) event.eContainer();
				if (viewElementWidgetMap.containsKey(abstractViewElement)) {
					viewElementWidgetMap.get(abstractViewElement).add(((ViewEvent) event).getType());
				} else {
					HashSet<WidgetEventType> widgetEventTypeSet = new HashSet<>();
					widgetEventTypeSet.add(((ViewEvent) event).getType());
					viewElementWidgetMap.put(abstractViewElement, widgetEventTypeSet);					
				}
			}
		});
		
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		
		// Will add the entities created to the model when OK is pressed
		button.addListener(SWT.Selection, new FlowstateEventButtonListener(transition, viewElementWidgetMap, flowEventsCollection));
		
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 361);
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.CinematicDialog_EventSelection);	
	}
}
 