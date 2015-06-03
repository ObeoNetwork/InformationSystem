package org.obeonetwork.dsl.requirement.design.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;

public class RequirementsServices {

	
	public List<Requirement> getRequirements(CategoriesContainer categoriesContainer) {
		List<Requirement> requirements = new ArrayList<Requirement>(categoriesContainer.getOwnedRequirements());
		Collections.sort(requirements, new Comparator<Requirement>() {
			public int compare(Requirement req1, Requirement req2) {
				String label1 = getRequirementLabel(req1);
				String label2 = getRequirementLabel(req2);
				return label1.compareToIgnoreCase(label2);
			}
			private String getRequirementLabel(Requirement requirement) {
				String label = null;
				if (requirement != null) {
					label = requirement.getId() + " -" + requirement.getName();
				}
				return label;
			}
		});
		return requirements;
	}

	
	
	public List<Category>getCategories(CategoriesContainer categoriesContainer){
		List<Category> ownedCategories = categoriesContainer.getOwnedCategories();
		Collections.sort(ownedCategories, new Comparator<Category>() {
			public int compare(Category arg0, Category arg1) {
				String label1=getCategoryLabel(arg0);
				String label2=getCategoryLabel(arg1);
				return label1.compareToIgnoreCase(label2);
			}
			private String getCategoryLabel(Category category) {
				String label=null;
				if(category!=null){
					label=category.getId()+ " - " + category.getName();
				}
				return label;
			}
		});
		return ownedCategories;
	}
	
	
	
}
