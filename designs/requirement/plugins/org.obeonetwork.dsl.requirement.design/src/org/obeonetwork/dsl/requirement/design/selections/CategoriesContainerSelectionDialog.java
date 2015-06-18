package org.obeonetwork.dsl.requirement.design.selections;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

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

	private boolean copy;

	private boolean keepReferencedObject;

	/**
	 * @param parent
	 * @param mode
	 *            true if Copy.
	 */
	public CategoriesContainerSelectionDialog(Shell parent, boolean mode) {
		super(parent, new CategoriesContainerLableProvider(),
				new CategoriesContainerSelectionContentProvider());
		this.copy = mode;
		if (copy) {
			setTitle("Copy Category");
		} else if (!copy) {
			setTitle("Move Category");
		}
		setMessage("Select the new container of the Category");
		setAllowMultiple(false);
		setHelpAvailable(false);
	}

	public void setElement(Category elementToCopy) {
		this.element = elementToCopy;
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
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#computeResult()
	 */
	@Override
	protected void computeResult() {
		if (copy) {
			copyCategory();
		}
		if (!copy) {
			moveCategory();
		}
		super.computeResult();
	}

	@Override
	protected void okPressed() {
		if (copy) {
			keepReferencedObject = MessageDialog.openQuestion(
		            getShell(),
		            "Category Referenced Object",
		            "Do you want to keep the Category Referenced Object ?");
		}
		super.okPressed();
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
		if (!keepReferencedObject) {
			categoryCopy.getReferencedObject().clear();
		}
		processIds(categoryCopy);
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

	private void processIds(Category categoryCopy) {
		String copieString = " - Copie";
		categoryCopy.setId(categoryCopy.getId().concat(copieString));
		List<Category> subCategories = categoryCopy.getSubCategories();
		for (Category category : subCategories) {
			category.setId(category.getId().concat(copieString));
		}
		List<Requirement> requirements = categoryCopy.getRequirements();
		for (Requirement requirement : requirements) {
			requirement.setId(requirement.getId().concat(copieString));
		}

	}
}
