package org.obeonetwork.dsl.requirement.design.selections;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;

/**
 * @author atakarabt
 *
 */
public class RequirementSelectionDialog extends AbstractSelectionDialog {

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 * @param mode
	 *            True if copy operation.
	 */
	public RequirementSelectionDialog(Shell parent, boolean mode) {
		super(parent, new LabelProvider(),
				new RequirementSelectionContentProvider());
		this.copy = mode;
		if (copy) {
			setTitle("Copy Requirement");
		} else if (!copy) {
			setTitle("Move Requirement");
		}
		setMessage("Select the new container of the Requirement");
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
			copyRequirement();
		}
		if (!copy) {
			moveRequirement();
		}
		super.computeResult();
	}

	/**
	 * Move Requirement.
	 */
	private void moveRequirement() {
		Object[] result = getResult();
		for (Object object : result) {
			((Category) object).getRequirements().add((Requirement) element);
		}
	}

	/**
	 * Copy Requirement.
	 */
	private void copyRequirement() {
		Object[] result = getResult();
		Requirement requirementCopy = EcoreUtil.copy((Requirement) element);
		if (!keepReferencedObject) {
			requirementCopy.getReferencedObject().clear();
		}
		for (Object object : result) {
			computeRequirementId(requirementCopy, (Category) object);
			((Category) object).getRequirements().add(requirementCopy);
		}
	}

	/**
	 * @param requirementCopy
	 * @param category
	 */
	private void computeRequirementId(Requirement requirementCopy,
			Category category) {
		
	int index=	computeRequirementCopyIndex(requirementCopy,category);
		if(index==0 || index == 1){
			requirementCopy.setId(requirementCopy.getId().concat(COPIE_STRING));
		}else{
		requirementCopy.setId(requirementCopy.getId().concat(COPIE_STRING)
				.concat(String.valueOf(index)));
		}

	}

	/**
	 * Return the index of the copied Requirement.
	 * @param requirementCopy
	 * @param category
	 * @return
	 */
	private int computeRequirementCopyIndex(Requirement requirementCopy,
			Category category) {
		boolean allIdsContainsCopy=true;
		int index=0;
		List<Requirement> ownedRequirements = category.getOwnedRequirements();
		for (Requirement requirement : ownedRequirements) {
			if(requirement.getName()!=null){
				if(requirement.getName().equals(requirementCopy.getName())){
					index++;
					if (!requirement.getId().contains(COPIE_STRING)) {
						allIdsContainsCopy=false;
					}
				}
			}
		}
		if(allIdsContainsCopy){
			index++;
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
		return ((Requirement) element).getReferencedObject().isEmpty();
	}

}
