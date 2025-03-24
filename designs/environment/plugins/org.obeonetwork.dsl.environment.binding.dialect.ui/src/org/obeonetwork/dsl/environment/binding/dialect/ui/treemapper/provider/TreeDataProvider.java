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
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class TreeDataProvider {

	private BindingInfo bindingInfo;
	private List<DBindingEdge> edges = null;
	private DBoundElement leftRoot = null;
	private DBoundElement rightRoot = null;
	
	private DBoundElementContentProvider contentProvider;
	
	public TreeDataProvider(BindingInfo bindingInfo) {
		super();
		this.bindingInfo = bindingInfo;
		contentProvider = new DBoundElementContentProvider();
	}
	
	public List<DBindingEdge> getEdges() {
		if (edges == null) {
			computeData();
		}
		return edges;
	}
	
	public DBoundElement getLeftRoot() {
		if (leftRoot == null) {
			computeData();
		}
		return leftRoot;
	}
	
	public DBoundElement getRightRoot() {
		if (rightRoot == null) {
			computeData();
		}
		return rightRoot;
	}

	public void computeData() {
		edges = new ArrayList<DBindingEdge>();
		leftRoot = BindingdialectFactory.eINSTANCE.createDBoundElement();
		leftRoot.setTarget(bindingInfo.getLeft());
		rightRoot = BindingdialectFactory.eINSTANCE.createDBoundElement();
		rightRoot.setTarget(bindingInfo.getRight());
		
		for (BindingReference bindingReference : bindingInfo.getReferences()) {
			BindingElement leftBindingElement = bindingReference.getLeft();
			BindingElement rightBindingElement = bindingReference.getRight();
			
			List<BoundableElement> leftPathReferences = new ArrayList<BoundableElement>(leftBindingElement.getPathReferences());
			leftPathReferences.add(leftBindingElement.getBoundElement());
			DBoundElement leftBoundElement = getBoundElement(leftRoot, leftPathReferences);
			List<BoundableElement> rightPathReferences = new ArrayList<BoundableElement>(rightBindingElement.getPathReferences());
			rightPathReferences.add(rightBindingElement.getBoundElement());
			DBoundElement rightBoundElement = getBoundElement(rightRoot, rightPathReferences);
			
			DBindingEdge edge = BindingdialectFactory.eINSTANCE.createDBindingEdge();
			edge.setTarget(bindingReference);
			edge.setLeft(leftBoundElement);
			edge.setRight(rightBoundElement);
			edges.add(edge);
		}
	}
	
	private DBoundElement getBoundElement(DBoundElement root, List<BoundableElement> path) {
		List<BoundableElement> remainingPath = new ArrayList<BoundableElement>(path);
		BoundableElement currentTarget = remainingPath.remove(0);
		if (EcoreUtil.equals(currentTarget, root.getTarget())) {
			if (remainingPath.isEmpty()) {
				return root;
			} else {
				return getBoundElementWithinChildren((DBoundElement[])contentProvider.getChildren(root), remainingPath);
			}
		}
		return null;
	}

	private DBoundElement getBoundElementWithinChildren(DBoundElement[] boundElements, List<BoundableElement> remainingPath) {
		BoundableElement currentTarget = remainingPath.remove(0);
		for (DBoundElement boundElement : boundElements) {
			if (EcoreUtil.equals(currentTarget, boundElement.getTarget())) {
				if (remainingPath.isEmpty()) {
					return boundElement;
				} else {
					return getBoundElementWithinChildren((DBoundElement[])contentProvider.getChildren(boundElement), remainingPath);
				}
			}
		}
		
		return null;
	}

}
