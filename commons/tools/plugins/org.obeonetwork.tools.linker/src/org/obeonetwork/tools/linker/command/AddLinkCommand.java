/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.linker.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.EObjectLinker;

/**
 * @author Obeo
 *
 */
public class AddLinkCommand extends AbstractCommand {

	protected EObject source;
	protected EObjectLinker linker;
	protected EObjectLink addedLink;
	private String type;

	/**
	 * @param label
	 */
	public AddLinkCommand(EObject source, String type) {
		super("Add a new Link to an element"); //$NON-NLS-1$
		this.source = source;
		this.type = type;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		linker = EObjectLinker.getLinker(source);
		return linker != null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		addedLink = linker.create(source, type);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return linker != null && addedLink != null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		linker.delete(addedLink);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		execute();
	}
	
	
	
}
