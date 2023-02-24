/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.binding.dialect.ui.editor.BindingTreeEditorManager;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands.CreateMappingCommand;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands.DeleteMappingCommand;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

/**
 * @author sthibaudeau
 *
 */
public class BindingTreeSemanticSupport implements ISemanticTreeMapperSupport<DBindingEdge, DBoundElement, DBoundElement>{

	private BindingInfo bindingInfo;
	final private BindingTreeEditorManager editorManager;
	
	
	public BindingTreeSemanticSupport(BindingInfo bindingInfo, BindingTreeEditorManager editorManager) {
		super();
		this.bindingInfo = bindingInfo;
		this.editorManager = editorManager;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport#canCreateSemanticMappingObject(java.lang.Object, java.lang.Object)
	 */
	public boolean canCreateSemanticMappingObject(DBoundElement leftItem, DBoundElement rightItem) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport#canDeleteSemanticMappingObject(java.lang.Object)
	 */
	public boolean canDeleteSemanticMappingObjects(Collection<DBindingEdge> semanticMappingObjects) {
		return MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Delete mappings", "Delete the selected mappings ?");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport#createSemanticMappingObject(java.lang.Object, java.lang.Object)
	 */
	public DBindingEdge createSemanticMappingObject(DBoundElement leftItem, DBoundElement rightItem) {
		CreateMappingCommand createMappingCmd = new CreateMappingCommand(editorManager.getEditingDomain(),
				bindingInfo, leftItem, rightItem);
		editorManager.execute(createMappingCmd);
		return createMappingCmd.getBindingEdge();
	}
	
	public List<DBindingEdge> createSemanticMappingObjects(List<DBoundElement> leftItems, List<DBoundElement> rightItems) {
		return null;
	}
	
	public void deleteSemanticMappingObject(DBindingEdge semanticMappingObject) {
		DeleteMappingCommand deleteMappingCmd = new DeleteMappingCommand(editorManager.getEditingDomain(), editorManager.getAccessor(), semanticMappingObject);
		editorManager.execute(deleteMappingCmd);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport#resolveLeftItem(java.lang.Object)
	 */
	public DBoundElement resolveLeftItem(DBindingEdge semanticMappingObject) {
		return semanticMappingObject.getLeft();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.nebula.treemapper.ISemanticTreeMapperSupport#resolveRightItem(java.lang.Object)
	 */
	public DBoundElement resolveRightItem(DBindingEdge semanticMappingObject) {
		return semanticMappingObject.getRight();
	}

}
