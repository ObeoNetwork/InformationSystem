/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.view;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.State;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.part.ViewPart;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.UserStoryElement;
import org.obeonetwork.graal.design.command.LinkStory;
import org.obeonetwork.graal.design.command.UnlinkStory;
import org.obeonetwork.graal.design.command.UpdateStoryActivationStatus;
import org.obeonetwork.graal.design.services.configuration.UIConfigurationServices;
import org.obeonetwork.graal.design.ui.view.command.HighlightUserStoryCommand;
import org.obeonetwork.graal.design.ui.view.util.UserStoriesCheckStateProvider;
import org.obeonetwork.graal.design.ui.view.util.UserStoriesContentProvider;
import org.obeonetwork.graal.design.ui.view.util.UserStoryLabelProvider;
import org.obeonetwork.graal.design.ui.view.util.ViewpointMultiSelectionListener;

import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;



/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class UserStoriesView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.obeonetwork.graal.design.ui.view.UserStoriesView";

	private CheckboxTreeViewer viewer;

	private AdapterFactory adapterFactory;

	private DAnalysis activeAnalysis;

	private ViewpointMultiSelectionListener selectionListener;

	/**
	 * The constructor.
	 */
	public UserStoriesView() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new UserStoriesContentProvider());
		viewer.setLabelProvider(new UserStoryLabelProvider(this, adapterFactory));
		viewer.setCheckStateProvider(new UserStoriesCheckStateProvider(viewer));
		viewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getElement() instanceof UserStory) {
					UserStory story = (UserStory) event.getElement();
					if (viewer.getInput() instanceof UserStoryElement) {
						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(viewer.getInput());
						if (editingDomain != null) {
							if (event.getChecked()) {
								LinkStory command = new LinkStory(story, (UserStoryElement) viewer.getInput());
								editingDomain.getCommandStack().execute(command);
							} else {
								UnlinkStory command = new UnlinkStory(story, (UserStoryElement) viewer.getInput());
								editingDomain.getCommandStack().execute(command);
							}
						}
					} else if (viewer.getInput() instanceof Collection<?>) {
						List<UserStoryElement> selection = new ArrayList<UserStoryElement>();
						for (Object next : (Collection<?>)viewer.getInput()) {
							if (next instanceof UserStoryElement) {
								selection.add((UserStoryElement) next);
							}
						}
						if (!selection.isEmpty()) {
							TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selection.get(0));
							if (editingDomain != null) {
								if (event.getChecked()) {
									LinkStory command = new LinkStory(story, selection);
									editingDomain.getCommandStack().execute(command);
								} else {
									UnlinkStory command = new UnlinkStory(story, selection);
									editingDomain.getCommandStack().execute(command);
								}
							}
						}
					}
				}
				viewer.refresh();
			}
		});
		ColumnViewerToolTipSupport.enableFor(viewer);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
				State state = service.getCommand(HighlightUserStoryCommand.COMMAND_ID).getState(HighlightUserStoryCommand.STATE_ID);
				state.setValue(getSelectedStories().size() == 1 && isActiveUserStory(getSelectedStories().get(0)));
				service.refreshElements(HighlightUserStoryCommand.COMMAND_ID, null);
			}
		});
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				updateUserStoryHighlightment();
				ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
				State state = service.getCommand(HighlightUserStoryCommand.COMMAND_ID).getState(HighlightUserStoryCommand.STATE_ID);
				state.setValue(getSelectedStories().size() == 1 && isActiveUserStory(getSelectedStories().get(0)));
				service.refreshElements(HighlightUserStoryCommand.COMMAND_ID, null);
			}
		});
		
		getSite().setSelectionProvider(viewer);
		selectionListener = new ViewpointMultiSelectionListener(this) {

			@Override
			protected void eObjectSelected(DAnalysis analysis, List<EObject> selectedEObjects) {
				update(analysis, selectedEObjects);
			}
		};
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(selectionListener);
	}

	protected void update(DAnalysis analysis, final List<EObject> selectedEObjects) {
		if (analysis != null) {
			// Retrieve the local analysis (for CDO projetcs)
			Session session = (new EObjectQuery(analysis)).getSession();
			if (session != null) {
				EObject analysisEObject = session.getSessionResource().getContents().get(0);
				if (analysisEObject instanceof DAnalysis) {
					this.activeAnalysis = (DAnalysis)analysisEObject;
					viewer.setInput(selectedEObjects);
					return;
				}
			}
		}
		this.activeAnalysis = null;
		viewer.setInput(null);
	}
	
	/**
	 * @return
	 */
	public List<EObject> getInput() {
		List<EObject> result = new ArrayList<EObject>();
		if (viewer.getInput() instanceof EObject) {
			result.add((EObject) viewer.getInput());
		} else if (viewer.getInput() instanceof Collection<?>) {
			for (Object next : (Collection<?>)viewer.getInput()) {
				if (next instanceof EObject) {
					result.add((EObject) next);
				}
			}
		}
		return result;
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserStory> getSelectedStories() {
		if (viewer.getSelection() instanceof StructuredSelection) {
			return ((StructuredSelection)viewer.getSelection()).toList();
		}
		return Collections.emptyList();
	}
	
	/**
	 * @return
	 */
	public EditingDomain getEditingDomain() {
		return getInput().isEmpty()?null:TransactionUtil.getEditingDomain(getInput().get(0));
	}

	/**
	 * @return the activeAnalysis
	 */
	public DAnalysis getActiveAnalysis() {
		return activeAnalysis;
	}

	public boolean isActiveUserStory(UserStory story) {
		List<UserStory> activeUserStories = getActiveUserStories();
		return activeUserStories.contains(story);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		if (selectionListener != null) {
			getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(selectionListener);
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void refresh() {
		viewer.refresh();
	}

	public void updateUserStoryHighlightment() {
		if (getSelectedStories().size() == 1) {
			UserStory currentStory = getSelectedStories().get(0);
			getEditingDomain().getCommandStack().execute(new UpdateStoryActivationStatus(activeAnalysis, currentStory));
			viewer.refresh();
		}
	}

	private List<UserStory> getActiveUserStories() {
		List<UserStory> result = new ArrayList<UserStory>();
		if (UIConfigurationServices.getUIConfiguration(activeAnalysis) != null && !UIConfigurationServices.getUIConfiguration(activeAnalysis).getActiveUserStories().isEmpty()) {
			result.addAll(UIConfigurationServices.getUIConfiguration(activeAnalysis).getActiveUserStories());
		}
		return result;
	}
	
	
	
}