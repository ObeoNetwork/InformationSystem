/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.ui.editpolicies;

import org.eclipse.gef.commands.Command;


public class EMFtoGEFCommandWrapper extends Command {

	/** The wrapped EMF Command. Package-level visibility so that the command stack wrapper can access the field. */
	private org.eclipse.emf.common.command.Command emfCommand;

	/**
	 * Constructor.
	 * 
	 * @param command
	 *            the wrapped EMF command
	 */
	public EMFtoGEFCommandWrapper(final org.eclipse.emf.common.command.Command command) {
		super(command.getLabel());
		emfCommand = command;
	}

	/**
	 * Returns the wrapped EMF command.
	 * 
	 * @return the EMF command
	 */
	public org.eclipse.emf.common.command.Command getEMFCommand() {
		return emfCommand;
	}

	/**
	 * Dispose.
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		emfCommand.dispose();
	}

	/**
	 * Can execute.
	 * 
	 * @return true, if can execute
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return emfCommand.canExecute();
	}

	/**
	 * Can undo.
	 * 
	 * @return true, if can undo
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return emfCommand.canUndo();
	}

	/**
	 * Execute.
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		emfCommand.execute();
	}

	/**
	 * Redo.
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		emfCommand.redo();
	}

	/**
	 * Undo.
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		emfCommand.undo();
	}

}


