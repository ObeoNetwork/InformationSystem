package org.obeonetwork.dsl.requirement.design.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.design.selections.CategoriesContainerSelectionDialog;
import org.obeonetwork.dsl.requirement.design.selections.RequirementSelectionDialog;

/**
 * @author atakarabt
 *
 */
public class RequirementsServices {

	/**
	 * Return List of Requirements sorted by id+ " - " +name.
	 * 
	 * @param categoriesContainer
	 * @return requirements
	 */
	public List<Requirement> getRequirements(
			CategoriesContainer categoriesContainer) {
		List<Requirement> requirements = new ArrayList<Requirement>(
				categoriesContainer.getOwnedRequirements());
		Collections.sort(requirements, new Comparator<Requirement>() {
			public int compare(Requirement req1, Requirement req2) {
				String label1 = getRequirementLabel(req1);
				String label2 = getRequirementLabel(req2);
				return label1.compareToIgnoreCase(label2);
			}

			private String getRequirementLabel(Requirement requirement) {
				String label = null;
				if (requirement != null) {
					label = requirement.getId() + " - " + requirement.getName();
				}
				return label;
			}
		});
		return requirements;
	}

	/**
	 * Return List of Categories sorted by id+ " - " +name.
	 * 
	 * @param categoriesContainer
	 * @return ownedCategories
	 */
	public List<Category> getCategories(CategoriesContainer categoriesContainer) {
		List<Category> ownedCategories = categoriesContainer
				.getOwnedCategories();
		Collections.sort(ownedCategories, new Comparator<Category>() {
			public int compare(Category arg0, Category arg1) {
				String label1 = getCategoryLabel(arg0);
				String label2 = getCategoryLabel(arg1);
				return label1.compareToIgnoreCase(label2);
			}

			private String getCategoryLabel(Category category) {
				String label = null;
				if (category != null) {
					label = category.getId() + " - " + category.getName();
				}
				return label;
			}
		});
		return ownedCategories;
	}

	/**
	 * CopyCategory.
	 * 
	 * @param category
	 */
	public void copyCategory(Category category) {
		Shell parent = getShell();
		CategoriesContainerSelectionDialog categoriesContainerSelectionDialog = new CategoriesContainerSelectionDialog(
				parent, true);
		categoriesContainerSelectionDialog.setInput(category);
		categoriesContainerSelectionDialog.setElement(category);
		categoriesContainerSelectionDialog.open();
	}

	/**
	 * Move Category.
	 * 
	 * @param category
	 */
	public void moveCategory(Category category) {
		Shell parent = getShell();
		CategoriesContainerSelectionDialog categoriesContainerSelectionDialog = new CategoriesContainerSelectionDialog(
				parent, false);
		categoriesContainerSelectionDialog.setInput(category);
		categoriesContainerSelectionDialog.setElement(category);
		categoriesContainerSelectionDialog.open();
	}

	private Shell getShell() {
		Shell parent = Display.getCurrent().getActiveShell();
		if (parent == null) {
			parent = Display.getDefault().getActiveShell();
		}
		return parent;
	}

	/**
	 * Copy Requirement.
	 * 
	 * @param requirement
	 */
	public void copyRequirement(Requirement requirement) {
		Shell parent = getShell();
		RequirementSelectionDialog requirementSelectionDialog = new RequirementSelectionDialog(
				parent, true);
		requirementSelectionDialog.setInput(requirement);
		requirementSelectionDialog.setElement(requirement);
		requirementSelectionDialog.open();
	}

	/**
	 * move Requirement.
	 * 
	 * @param requirement
	 */
	public void moveRequirement(Requirement requirement) {
		Shell parent = getShell();
		RequirementSelectionDialog requirementSelectionDialog = new RequirementSelectionDialog(
				parent, false);
		requirementSelectionDialog.setInput(requirement);
		requirementSelectionDialog.setElement(requirement);
		requirementSelectionDialog.open();
	}

}
