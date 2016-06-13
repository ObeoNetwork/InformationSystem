/**
 * 
 */
package org.obeonetwork.tools.doc.ui.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.tools.doc.DocBridgeUI;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.doc.core.command.RemoveDocumentationLinkCommand;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DeleteDocumentationLink extends EObjectLinksViewAction {

	/**
	 * @param linksView
	 */
	public DeleteDocumentationLink(EObjectLinksView linksView) {
		super(linksView);
		this.setText(DocBridgeUI.getInstance().getString("DeleteDocumentationLinkAction_title")); //$NON-NLS-1$
		this.setToolTipText(DocBridgeUI.getInstance().getString("DeleteDocumentationLinkAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(DocBridgeUI.getInstance().getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		this.setEnabled(false);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		MessageDialog dialog = new MessageDialog(
				linksView.getSite().getShell(), 
				DocBridgeUI.getInstance().getString("DeleteDocumentationLinkAction_ConfirmDialog_title"), null,  //$NON-NLS-1$
				DocBridgeUI.getInstance().getString("DeleteDocumentationLinkAction_ConfirmDialog_msg"), MessageDialog.CONFIRM, new String[] { IDialogConstants.OK_LABEL, //$NON-NLS-1$
					IDialogConstants.CANCEL_LABEL }, 1);
		boolean openConfirm = dialog.open() == Window.OK;
		if (openConfirm) {
			List<DocumentationLink> selection = new ArrayList<DocumentationLink>();
			for (EObjectLink link : linksView.getSelectedEntries()) {
				if (link instanceof DocumentationLink) {
					selection.add((DocumentationLink) link);
				}
			}
			EObject input = linksView.getInput();
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(input);
			if (!selection.isEmpty() && editingDomain != null) {
				for (DocumentationLink entry : selection) {						
					editingDomain.getCommandStack().execute(new RemoveDocumentationLinkCommand(input, entry));
				}
				linksView.refresh();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireSelectionChanged(java.util.List)
	 */
	@Override
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		this.setEnabled(newSelection.size() > 0);
	}

}
