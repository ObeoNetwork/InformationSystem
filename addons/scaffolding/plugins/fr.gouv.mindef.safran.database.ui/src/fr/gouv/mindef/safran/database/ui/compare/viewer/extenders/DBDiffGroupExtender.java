/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.compare.viewer.extenders;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeFactory;
import org.eclipse.emf.edit.tree.TreeNode;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;

public class DBDiffGroupExtender implements IDifferenceGroupExtender {

	private DiffContentService service = new DiffContentService();
	
	public DBDiffGroupExtender() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean handle(TreeNode treeNode) {
		EObject data = treeNode.getData();
		if (data instanceof Diff) {
			return service.handle((Diff) data);
		}
		return false;
	}

	@Override
	public void addChildren(TreeNode treeNode) {
		EObject data = treeNode.getData();
		if (data instanceof Diff) {
			for (Diff subDiff : service.getSubDiffs((Diff) data, ((Diff) data).getMatch().getComparison())) {
				buildTreeNode(treeNode, subDiff);
			}
		}	
	}
	
	protected TreeNode buildTreeNode(TreeNode parent, Diff candidate) {
		TreeNode node = TreeFactory.eINSTANCE.createTreeNode();
		node.setData(candidate);
		node.setParent(parent);	
		if (handle(node)) {
			addChildren(node);
		}
		return node;
	}
		
}
