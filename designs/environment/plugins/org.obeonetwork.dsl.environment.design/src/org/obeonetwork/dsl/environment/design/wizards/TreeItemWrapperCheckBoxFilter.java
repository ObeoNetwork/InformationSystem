package org.obeonetwork.dsl.environment.design.wizards;

public abstract class TreeItemWrapperCheckBoxFilter implements ISObjectSelectionWizardPage.ICheckBoxFilter {
	
	private String label;
	private boolean defaultCheckValue = false;

	public TreeItemWrapperCheckBoxFilter(String label, boolean defaultCheckValue) {
		this.label = label;
		this.defaultCheckValue = defaultCheckValue;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public boolean getDefaultCheckValue() {
		return defaultCheckValue;
	}
	
}
