package org.obeonetwork.dsl.requirement.design.selections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * @author atakarabt
 *
 */
public abstract class AbstractSelectionDialog extends
		ElementTreeSelectionDialog {

	/**
	 * The Selected element.
	 */
	protected EObject element;
	/**
	 * True if Copy operation.
	 */
	protected boolean copy;

	/**
	 * True to keep Referenced Object.
	 */
	protected boolean keepReferencedObject;

	/**
	 * " - Copie" String.
	 */
	protected final String COPIE_STRING = " - Copie";

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 * @param labelProvider
	 * @param contentProvider
	 */
	public AbstractSelectionDialog(Shell parent, LabelProvider labelProvider,
			AbstractSelectionContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.ElementTreeSelectionDialog#doCreateTreeViewer(
	 * org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		PatternFilter filter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, style, filter, true);
		return tree.getViewer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.ElementTreeSelectionDialog#createTreeViewer(org
	 * .eclipse.swt.widgets.Composite)
	 */
	@Override
	protected TreeViewer createTreeViewer(Composite parent) {
		TreeViewer treeViewer = super.createTreeViewer(parent);
		treeViewer.expandToLevel(2);
		return treeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		if (copy && !isEmptyReferencedObject()) {
			keepReferencedObject = MessageDialog.openQuestion(getShell(),
					"Referenced Object",
					"Do you want to keep the Referenced Object ?");
		}
		super.okPressed();
	}

	/**
	 * @return True if referencedObject feature is empty.
	 */
	protected abstract boolean isEmptyReferencedObject();
	/**
	 * @param requirement
	 */
	public void setElement(EObject eObject) {
		this.element = eObject;
	}
}
