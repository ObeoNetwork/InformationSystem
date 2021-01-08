/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.ui.business.api.query.NodeQuery;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.design.Activator;
import org.obeonetwork.dsl.requirement.design.comparators.CategoryComparator;
import org.obeonetwork.dsl.requirement.design.comparators.RequirementComparator;
import org.obeonetwork.dsl.requirement.design.provider.RequirementLabelProvider;
import org.obeonetwork.dsl.requirement.design.selection.CategorySelectionDialog;
import org.obeonetwork.tools.requirement.ui.decorators.ObjectWithRequirement;

/**
 * @author sthibaudeau
 *
 */
public class RequirementsServices {
	
	private static final String COPY = "Copy";


	public String getRequirementsLabel(EObject element) {
		return new RequirementLabelProvider().getText(element);
	}

	/**
	 * Return List of Requirements sorted by id+ " - " +name.
	 * 
	 * @param categoriesContainer
	 * @return requirements
	 */
	public List<Requirement> getRequirements(CategoriesContainer categoriesContainer) {
		List<Requirement> requirements = new ArrayList<Requirement>(categoriesContainer.getOwnedRequirements());
		Collections.sort(requirements, RequirementComparator.INSTANCE);
		return requirements;
	}

	/**
	 * Return List of Categories sorted by id+ " - " +name.
	 * 
	 * @param categoriesContainer
	 * @return ownedCategories
	 */
	public List<Category> getCategories(CategoriesContainer categoriesContainer) {
		List<Category> ownedCategories = categoriesContainer.getOwnedCategories();
		Collections.sort(ownedCategories, CategoryComparator.INSTANCE);
		return ownedCategories;
	}

	/**
	 * CopyCategory.
	 * 
	 * @param category
	 */
	public void copyCategory(Category category) {
		Shell shell = getShell();
		CategorySelectionDialog dlg = new CategorySelectionDialog(shell, "Copy a category", "Select a container for the new category");
		dlg.setInput(SessionManager.INSTANCE.getSession(category));
		dlg.setInitialSelection(category.eContainer());
		if (dlg.open() == Window.OK) {
			Object selectedObject = dlg.getFirstResult();
			if (selectedObject instanceof CategoriesContainer) {
				CategoriesContainer newContainer = (CategoriesContainer)selectedObject;
				
				// Check if there are referenced objects
				boolean keepReferencedObject = false;
				if (!category.getReferencedObject().isEmpty()) {
					keepReferencedObject = MessageDialog.openQuestion(shell, "Referenced objects", "Do you want to keep the referenced objects ?");
				}
				
				// Copy object
				Category newCategory = EcoreUtil.copy(category);
				newCategory.setId(getNewIdForCopiedCategory(newContainer, newCategory));
				if (!keepReferencedObject) {
					newCategory.getReferencedObject().clear();
				}
				
				// Add to parent
				addToCategoriesContainer(newContainer, newCategory);
			}
		};
	}
	
	private String getNewIdForCopiedCategory(CategoriesContainer newContainer, Category category) {
		String newId = "";
		if (category.getId() != null) {
			newId = category.getId();
		}
		newId += COPY;
		
		int max = 1 + getMaxCorrespondingIdForCategory(newContainer, newId);
		if (max > 1) {
			newId += max;
		}
		return newId;
	}
	
	private String getNewIdForCopiedRequirement(Category newContainer, Requirement requirement) {
		String newId = "";
		if (requirement.getId() != null) {
			newId = requirement.getId();
		}
		newId += COPY;
		
		int max = 1 + getMaxCorrespondingIdForRequirement(newContainer, newId);
		if (max > 1) {
			newId += max;
		}
		return newId;
	}
	
	private int getMaxCorrespondingIdForCategory(CategoriesContainer container, String prefix) {
		Collection<String> ids = new ArrayList<String>();
		for (Category category : container.getOwnedCategories()) {
			if (category.getId() != null) {
				ids.add(category.getId());
			}
		}
		return getMaxCorrespondingId(ids, prefix);
	}
	
	private int getMaxCorrespondingIdForRequirement(Category container, String prefix) {
		Collection<String> ids = new ArrayList<String>();
		for (Requirement requirement : container.getOwnedRequirements()) {
			if (requirement.getId() != null) {
				ids.add(requirement.getId());
			}
		}
		return getMaxCorrespondingId(ids, prefix);
	}
	
	private int getMaxCorrespondingId(Collection<String> ids, String prefix) {
		int max = 0;
		Pattern ptn = Pattern.compile("^" + prefix + "([0-9]*)");
		for (String id : ids) {
			if (id != null) {
				Matcher m = ptn.matcher(id);
				if (m.find()) {
					String group = m.group(1);
					if (group != null) {
						int value = -1;
						if ("".equals(group)) {
							value = 1;
						} else {
							value = new Integer(group);
						}
						if (value > max) {
							max = value;
						}
					}
				}
			}
		}
		return max;
	}

	/**
	 * Move Category.
	 * 
	 * @param category
	 */
	public void moveCategory(Category category) {
		Shell shell = getShell();
		CategorySelectionDialog dlg = new CategorySelectionDialog(shell, "Move a category", "Select a new container for the category", category);
		dlg.setInput(SessionManager.INSTANCE.getSession(category));
		dlg.setInitialSelection(category.eContainer());
		if (dlg.open() == Window.OK) {
			Object selectedObject = dlg.getFirstResult();
			if (selectedObject instanceof CategoriesContainer) {
				CategoriesContainer newContainer = (CategoriesContainer)selectedObject;
				// Add to parent
				addToCategoriesContainer(newContainer, category);
			}
		}
	}

	private void addToCategoriesContainer(CategoriesContainer container, Category category) {
		if (container instanceof Repository) {
			((Repository) container).getMainCategories().add(category);
		} else if (container instanceof Category) {
			((Category) container).getSubCategories().add(category);
		}
	}


	/**
	 * Copy Requirement.
	 * 
	 * @param requirement
	 */
	public void copyRequirement(Requirement requirement) {
		Shell shell = getShell();
		CategorySelectionDialog dlg = new CategorySelectionDialog(shell, "Copy a requirement", "Select a container for the new requirement");
		dlg.setInput(SessionManager.INSTANCE.getSession(requirement));
		dlg.setInitialSelection(requirement.eContainer());
		dlg.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length > 0 && selection[0] instanceof Category) {
					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Select a category");
			}
		});
		
		if (dlg.open() == Window.OK) {
			Object selectedObject = dlg.getFirstResult();
			if (selectedObject instanceof Category) {
				Category newContainer = (Category)selectedObject;
				
				// Check if there are referenced objects
				boolean keepReferencedObject = false;
				if (!requirement.getReferencedObject().isEmpty()) {
					keepReferencedObject = MessageDialog.openQuestion(shell, "Referenced objects", "Do you want to keep the referenced objects ?");
				}
				
				// Copy object
				Requirement newRequirement = EcoreUtil.copy(requirement);
				newRequirement.setId(getNewIdForCopiedRequirement(newContainer, newRequirement));
				if (!keepReferencedObject) {
					newRequirement.getReferencedObject().clear();
				}
				
				// Add to parent
				newContainer.getRequirements().add(newRequirement);
			}
		};
	}

	/**
	 * move Requirement.
	 * 
	 * @param requirement
	 */
	public void moveRequirement(Requirement requirement) {
		Shell shell = getShell();
		CategorySelectionDialog dlg = new CategorySelectionDialog(shell, "Move a requirement", "Select a new container for the requirement");
		dlg.setInput(SessionManager.INSTANCE.getSession(requirement));
		dlg.setInitialSelection(requirement.eContainer());
		dlg.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length > 0 && selection[0] instanceof Category) {
					return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Select a category");
			}
		});
		
		if (dlg.open() == Window.OK) {
			Object selectedObject = dlg.getFirstResult();
			if (selectedObject instanceof Category) {
				Category newContainer = (Category)selectedObject;
				// change parent
				newContainer.getRequirements().add(requirement);
			}
		};
	}
	
	/**
	 * Checks whether a graphical element should be decorated for linked requirements
	 * @param semanticDecorator
	 * @return
	 */
	public boolean shouldDecorateForLinkedRequirement(DSemanticDecorator semanticDecorator) {
		// If the decorator is disabled we do not decorate diagrams
		if (!ObjectWithRequirement.isDecoratorEnabled()) {
			return false;
		}
		
		// We do not decorate bordered nodes and edges
		if (isBorderedNode(semanticDecorator)) {
			return false;
		} else if (semanticDecorator instanceof DEdge) {
			return false;
		}
		
		// We check if we can compute an image for the decorator
		boolean result = getImagePathForLinkedRequirementDecorator(semanticDecorator.getTarget()) != null;
		return result;
	}
	
	/**
	 * Checks whether a DNode is a bordered node
	 * @param semanticDecorator
	 * @return
	 */
	private boolean isBorderedNode(DSemanticDecorator semanticDecorator) {
		if (semanticDecorator instanceof DNode) {
			Collection<EObject> inverseReferences = new EObjectQuery((DNode)semanticDecorator).getInverseReferences(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.VIEW__ELEMENT);
			Iterator<EObject> iterator = inverseReferences.iterator();
			if (iterator.hasNext()) {
				EObject next = iterator.next();
				if (next instanceof Node) {
					return new NodeQuery((Node)next).isBorderedNode();
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns image path to decorate an object with a linked requirement
	 * @param element
	 * @return
	 */
	public String getImagePathForLinkedRequirementDecorator(EObject element) {
		return ObjectWithRequirement.getImagePathForDecorator(element);
	}
	
	private Shell getShell() {
		Shell shell = Display.getCurrent().getActiveShell();
		if (shell == null) {
			shell = Display.getDefault().getActiveShell();
		}
		return shell;
	}
}
