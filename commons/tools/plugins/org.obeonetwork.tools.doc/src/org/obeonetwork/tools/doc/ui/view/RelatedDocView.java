/**
 * 
 */
package org.obeonetwork.tools.doc.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.tools.doc.DocBridgeUI;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.doc.ui.DocumentationLinkUIService;
import org.obeonetwork.tools.doc.ui.command.AddDocumentationLink;
import org.obeonetwork.tools.doc.ui.command.DeleteDocumentationLink;
import org.obeonetwork.tools.doc.ui.command.EditDocumentationLink;
import org.obeonetwork.tools.doc.ui.view.util.RelatedDocumentationContentProvider;
import org.obeonetwork.tools.doc.ui.view.util.RelatedDocumentationLabelProvider;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RelatedDocView extends EObjectLinksView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.obeonetwork.tools.doc.ui.view.RelatedDocView"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createDoubleClickAction()
	 */
	@Override
	protected Action createDoubleClickAction() {
		return new Action() {
			public void run() {
				if (!getSelectedEntries().isEmpty()) {
					try {
						IHandler openCommand = DocumentationLinkUIService.getUIService().createOpenCommand((DocumentationLink) getSelectedEntries().get(0));
						openCommand.execute(null);
					} catch (ExecutionException e) {
						DocBridgeUI.getInstance().getLog().log(new Status(Status.ERROR, DocBridgeUI.PLUGIN_ID, "An error occured during document opening.", e)); //$NON-NLS-1$
					}
				}
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#addColumns()
	 */
	protected void addColumns() {
		addColumn(DocBridgeUI.getInstance().getString("RelatedDocView_ColumnName_title"), 25); //$NON-NLS-1$
		addColumn(DocBridgeUI.getInstance().getString("RelatedDocView_ColumnURL_title"), 75); //$NON-NLS-1$
	}
	
	/**
	 * 
	 */
	@Override
	protected void fillLocalActionBar() {
		getViewSite().getActionBars().getToolBarManager().add(new AddDocumentationLink(this));
		getViewSite().getActionBars().getToolBarManager().add(new EditDocumentationLink(this));
		getViewSite().getActionBars().getToolBarManager().add(new DeleteDocumentationLink(this));
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createLabelProvider()
	 */
	protected CellLabelProvider createLabelProvider() {
		return new RelatedDocumentationLabelProvider(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createContentProvider()
	 */
	@Override
	protected EObjectLinkContentProvider createContentProvider() {
		return new RelatedDocumentationContentProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createFilters()
	 */
	@Override
	protected List<ViewerFilter> createFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof DocumentationLink;
			}
		});
		return result;
	}

	@Override
	protected String getShowChildrenActionTitle() {
		return DocBridgeUI.getInstance().getString("RelatedDocView_ShowActionChildren_title");
	}

	@Override
	protected String getShowChildrenActionDescription() {
		return DocBridgeUI.getInstance().getString("RelatedDocView_ShowActionChildren_description");
	}
	
}
