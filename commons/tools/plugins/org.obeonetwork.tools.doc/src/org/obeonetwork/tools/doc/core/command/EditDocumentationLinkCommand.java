/**
 * 
 */
package org.obeonetwork.tools.doc.core.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EditDocumentationLinkCommand extends AbstractCommand {

	private DocumentationLink link;
	private String newName;
	private String newValue;

	/**
	 * 
	 */
	public EditDocumentationLinkCommand(DocumentationLink link, String newName, String newValue) {
		super("Edit a documentation link"); //$NON-NLS-1$
		this.link = link;
		this.newName = newName;
		this.newValue = newValue;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.command.AddLinkCommand#execute()
	 */
	public void execute() {
		String oldName = link.getName();
		String oldValue = link.getValue();
		link.setName(newName);
		link.setValue(newValue);
		newName = oldName;
		newValue = oldValue;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		execute();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		execute();
	}	
	
	
}
