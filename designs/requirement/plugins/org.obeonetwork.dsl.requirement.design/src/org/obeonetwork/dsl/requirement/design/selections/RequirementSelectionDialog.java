package org.obeonetwork.dsl.requirement.design.selections;

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
		int size = category.getRequirements().size();
		requirementCopy.setId(requirementCopy.getId().concat(COPIE_STRING)
				.concat(String.valueOf(size)));

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
