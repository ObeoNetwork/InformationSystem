/**
 * 
 */
package org.obeonetwork.tools.doc.core.command;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.doc.core.impl.DocumentationLinkHelper;
import org.obeonetwork.tools.doc.core.impl.DocumentationLinkType;
import org.obeonetwork.tools.linker.command.AddLinkCommand;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class AddDocumentationLinkCommand extends AddLinkCommand {

	private String name;
	private String value;

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
	 * @param source
	 * @param name
	 * @param value
	 */
	public AddDocumentationLinkCommand(EObject source, String name, String value) {
		super(source, DocumentationLinkType.DOCUMENTATION_LINK_TYPE);
		this.name = name;
		this.value = value;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.command.AddLinkCommand#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		((DocumentationLink)addedLink).setName(name);
		((DocumentationLink)addedLink).setValue(value);
	}	
	
	
}
