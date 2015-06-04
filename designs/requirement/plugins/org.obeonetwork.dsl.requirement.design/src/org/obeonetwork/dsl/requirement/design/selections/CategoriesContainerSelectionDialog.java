package org.obeonetwork.dsl.requirement.design.selections;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;

/**
 * @author atakarabt
 *
 */
public class CategoriesContainerSelectionDialog extends
		ElementTreeSelectionDialog {

	/**
	 * The Selected Category
	 */
	private Category element;
	private boolean move;
	private boolean copy;

	/**
	 * @param parent
	 */
	public CategoriesContainerSelectionDialog(Shell parent) {
		super(parent, new CategoriesContainerLableProvider(),
				new CategoriesContainerSelectionContentProvider());
		if (copy) {
			setTitle("Copy Category");
		} else if (move) {
			setTitle("Move Category");
		}
		setMessage("Select the new container of the Category");
		setAllowMultiple(false);
		setHelpAvailable(false);
	}

	public void setElement(Category elementToCopy) {
		this.element = elementToCopy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#doCreateTreeViewer(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		PatternFilter filter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, style, filter, true);
		return tree.getViewer();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#createTreeViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected TreeViewer createTreeViewer(Composite parent) {
		TreeViewer treeViewer = super.createTreeViewer(parent);
		treeViewer.expandToLevel(2);
		return treeViewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#computeResult()
	 */
	@Override
	protected void computeResult() {
		if (copy) {
			copyCategory();
		}
		if (move) {
			moveCategory();
		}
		super.computeResult();
	}

	/**
	 * Move the selected Category to the selected CategoriesContainer
	 */
	private void moveCategory() {
		Object[] result2 = getResult();
		for (Object object : result2) {
			if (object instanceof Category) {
				((Category) object).getSubCategories().add((Category) element);
			} else if (object instanceof Repository) {
				((Repository) object).getMainCategories().add(
						(Category) element);
			}
		}

	}

	/**
	 * Copy Category to the selected CategoriesContainer
	 */
	private void copyCategory() {
		Object[] result2 = getResult();
		Category categoryCopy = EcoreUtil.copy(element);
		categoryCopy.getReferencedObject().clear();
		for (Object object : result2) {
			if (object instanceof Category) {
				((Category) object).getSubCategories().add(
						(Category) categoryCopy);
			} else if (object instanceof Repository) {
				((Repository) object).getMainCategories().add(
						(Category) categoryCopy);
			}
		}

	}
}
