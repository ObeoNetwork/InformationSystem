/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RemoveLinkCommand extends AbstractCommand {

	protected EObject source;
	protected EObjectLinker linker;
	protected EObjectLink removedLink;

	/**
	 * @param source
	 * @param link
	 */
	public RemoveLinkCommand(EObject source, EObjectLink link) {
		super("Remove a link"); //$NON-NLS-1$
		this.source = source;
		this.removedLink = link;
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
		linker.delete(removedLink);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return linker != null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		removedLink = linker.create(source, removedLink.getType());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		execute();
	}

}
