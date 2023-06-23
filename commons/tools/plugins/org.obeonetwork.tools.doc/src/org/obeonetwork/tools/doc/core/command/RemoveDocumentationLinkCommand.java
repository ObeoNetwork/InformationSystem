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
/**
 * 
 */
package org.obeonetwork.tools.doc.core.command;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.doc.core.impl.DocumentationLinkHelper;
import org.obeonetwork.tools.linker.command.RemoveLinkCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RemoveDocumentationLinkCommand extends RemoveLinkCommand {

	/**
	 * @param source
	 * @param link
	 */
	public RemoveDocumentationLinkCommand(EObject source, DocumentationLink link) {
		super(source, link);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.command.AddLinkCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		linker = DocumentationLinkHelper.getDocumentationLinker(source);		
		return linker != null;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && source == removedLink.getSource();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		DocumentationLink oldEntry = (DocumentationLink) removedLink;
		super.undo();
		((DocumentationLink)removedLink).setName(oldEntry.getName());
		((DocumentationLink)removedLink).setValue(oldEntry.getValue());
	}

}
