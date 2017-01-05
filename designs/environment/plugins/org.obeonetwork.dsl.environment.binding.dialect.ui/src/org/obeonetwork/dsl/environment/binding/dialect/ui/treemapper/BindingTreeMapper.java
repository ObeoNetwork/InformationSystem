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
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport;
import org.eclipse.nebula.treemapper.TreeMapper;
import org.eclipse.nebula.treemapper.TreeMapperUIConfigProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.DBoundElementContentProvider;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.DBoundElementLabelProvider;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class BindingTreeMapper extends TreeMapper<DBindingEdge, DBoundElement, DBoundElement> {
	private static final Color EDGE_DEFAULT_COLOR = new Color(Display.getCurrent(), new RGB(247, 206, 206));
	private static final Color EDGE_SELECTED_COLOR = new Color(Display.getCurrent(), new RGB(147, 86, 111));
	
	private static final int EDGE_DEFAULT_WIDTH = 1;
	private static final int EDGE_SELECTED_WIDTH = 3;
	private static TreeMapperUIConfigProvider uiConfig = new TreeMapperUIConfigProvider(EDGE_DEFAULT_COLOR, EDGE_DEFAULT_WIDTH,
																						EDGE_SELECTED_COLOR, EDGE_SELECTED_WIDTH);
	private Set<DBoundElement> leftSelectedElements = new HashSet<DBoundElement>();
	private Set<DBoundElement> rightSelectedElements = new HashSet<DBoundElement>();
	private boolean leftSelectionComputed = false;
	private boolean edgesLeftSelectionComputed = false;
	private boolean rightSelectionComputed = false;
	private boolean edgesRightSelectionComputed = false;
	
	public BindingTreeMapper(Composite parent, ISemanticTreeMapperSupport<DBindingEdge, DBoundElement, DBoundElement> semanticSupport) {
		this(parent, semanticSupport, uiConfig);
	}

	private BindingTreeMapper(Composite parent, ISemanticTreeMapperSupport<DBindingEdge, DBoundElement, DBoundElement> semanticSupport, TreeMapperUIConfigProvider uiConfig) {
		super(parent, semanticSupport, uiConfig);
		setContentProviders(new DBoundElementContentProvider(), new DBoundElementContentProvider());
		setLabelProviders(new DBoundElementLabelProvider(), new DBoundElementLabelProvider());
		
		addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("unchecked")
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					selectEdges(selection.toList());
				}
			}
		});
		
		getLeftTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("unchecked")
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					selectLeftElements(selection.toList());
				}
			}
		});
		
		getRightTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("unchecked")
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					selectRightElements(selection.toList());
				}
			}
		});
	}
	
	private void selectEdges(List<DBindingEdge> edges) {
		if (edgesLeftSelectionComputed == false) {
			leftSelectedElements.clear();
			for (DBindingEdge bindingEdge : edges) {
				leftSelectedElements.add(bindingEdge.getLeft());
			}
			leftSelectionComputed = true;
			getLeftTreeViewer().setSelection(new StructuredSelection(new ArrayList<DBoundElement>(leftSelectedElements)));
		} else {
			edgesLeftSelectionComputed = false;
		}
		if (edgesRightSelectionComputed == false) {
			rightSelectedElements.clear();
			for (DBindingEdge bindingEdge : edges) {
				rightSelectedElements.add(bindingEdge.getRight());
			}
			rightSelectionComputed = true;
			getRightTreeViewer().setSelection(new StructuredSelection(new ArrayList<DBoundElement>(rightSelectedElements)));
		} else {
			edgesRightSelectionComputed = false;
		}
		
	}
	
	private void selectLeftElements(List<DBoundElement> elements) {
		if (leftSelectionComputed == true) {
			leftSelectionComputed = false;
		} else {
			edgesLeftSelectionComputed = true;
			setSelection(new StructuredSelection(getRelatedEdges(elements)));
		}
	}
	
	private void selectRightElements(List<DBoundElement> elements) {
		if (rightSelectionComputed == true) {
			rightSelectionComputed = false;
		} else {
			edgesRightSelectionComputed = true;
			setSelection(new StructuredSelection(getRelatedEdges(elements)));
		}
	}
	
	private List<DBindingEdge> getRelatedEdges(Collection<DBoundElement> elements) {
		Set<DBindingEdge> relatedEdges = new HashSet<DBindingEdge>();
		for (DBoundElement boundElement : elements) {
			relatedEdges.addAll(boundElement.getEdges());
		}
		return new ArrayList<DBindingEdge>(relatedEdges);
	}
}
