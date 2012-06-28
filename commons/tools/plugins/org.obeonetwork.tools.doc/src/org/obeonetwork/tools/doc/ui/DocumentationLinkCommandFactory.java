/**
 * 
 */
package org.obeonetwork.tools.doc.ui;

import org.eclipse.core.commands.IHandler;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface DocumentationLinkCommandFactory {
	
	/**
	 * Creates a new {@link IHandler} to open the given {@link DocumentationLink}.
	 * @param entry to open
	 * @return the Handler opening the given {@link DocumentationLink}.
	 */
	IHandler createOpenCommand(DocumentationLink entry);
}
