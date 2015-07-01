package org.obeonetwork.dsl.requirement.design.selections;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

/**
 * @author atakarabt
 *
 */
public class CategoriesContainerSelectionDialog extends AbstractSelectionDialog {

	/**
	 * @param parent
	 * @param mode
	 *            true if Copy.
	 */
	public CategoriesContainerSelectionDialog(Shell parent, boolean mode) {
		super(parent, new LabelProvider(),
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

	/**
	 * Move the selected Category to the selected CategoriesContainer
	 */
	private void moveCategory() {
		Object[] result = getResult();
		for (Object object : result) {
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
		Object[] result = getResult();
		Category categoryCopy = EcoreUtil.copy((Category) element);
		if (!keepReferencedObject) {
			categoryCopy.getReferencedObject().clear();
		}
		for (Object object : result) {
			processCopy(categoryCopy, (CategoriesContainer) object);
			if (object instanceof Category) {
				((Category) object).getSubCategories().add(categoryCopy);
			} else if (object instanceof Repository) {
				((Repository) object).getMainCategories().add(categoryCopy);
			}
		}

	}

	/**
	 * Add "- Copie" String to the copied Category.
	 * 
	 * @param categoryCopy
	 */
	private void processCopy(Category categoryCopy,
			CategoriesContainer categoriesContainer) {
		String categoryCopyId = categoryCopy.getId().concat(COPIE_STRING);
		categoryCopy.setId(categoryCopyId);
		String index = computeCategoryCopyId(categoryCopy, categoriesContainer);
		computeSubCategories(categoryCopy, index);
		computeRequirementsId(categoryCopy, index);
	}

	/**
	 * Add index to Requirements Id.
	 * 
	 * @param category
	 * @param index
	 */
	private void computeRequirementsId(Category category, String index) {
		List<Requirement> requirements = category.getRequirements();
		for (Requirement requirement : requirements) {
			if (index == null) {
				requirement.setId(requirement.getId().concat(COPIE_STRING));
			} else {
				requirement.setId(requirement.getId().concat(COPIE_STRING)
						.concat(index));
			}
		}

	}

	/**
	 * Compute Sub Categories copy operation.
	 * 
	 * @param categoryCopy
	 * @param index
	 */
	private void computeSubCategories(Category categoryCopy, String index) {
		List<Category> subCategories = categoryCopy.getSubCategories();
		for (Category category : subCategories) {
			computeSubCategoriesId(index, category);
			if (!keepReferencedObject) {
				category.getReferencedObject().clear();
			}
			computeSubCategories(category, index);
			computeRequirementsId(category, index);
		}
	}

	/**
	 * Add index to Sub Categories Id.
	 * 
	 * @param index
	 * @param category
	 */
	private void computeSubCategoriesId(String index, Category category) {
		if (index == null) {
			category.setId(category.getId().concat(COPIE_STRING));
		} else {
			category.setId(category.getId().concat(COPIE_STRING).concat(index));
		}
	}

	/**
	 * Add index to CategoryCopy Id.
	 * 
	 * @param categoryCopyId
	 * @return idIndex
	 */
	private String computeCategoryCopyId(Category categoryCopy,
			CategoriesContainer parentCategory) {
		String index = null;
		List<Category> ownedCategories = parentCategory.getOwnedCategories();
		int size = ownedCategories.size();
		if (size != 0) {
			index = Integer.toString(size);
			categoryCopy.setId(categoryCopy.getId().concat(index));
		}
		return index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.obeonetwork.dsl.requirement.design.selections.AbstractSelectionDialog
	 * #isEmptyReferencedObject()
	 */
	@Override
	protected boolean isEmptyReferencedObject() {
		return ((Category) element).getReferencedObject().isEmpty();
	}
}
