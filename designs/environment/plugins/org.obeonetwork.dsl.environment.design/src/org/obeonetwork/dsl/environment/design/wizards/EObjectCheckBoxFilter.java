package org.obeonetwork.dsl.environment.design.wizards;

import org.eclipse.emf.ecore.EObject;

public abstract class EObjectCheckBoxFilter implements ISObjectSelectionWizardPage.ICheckBoxFilter {
	
	private String label;
	private boolean defaultCheckValue = false;

	public EObjectCheckBoxFilter(String label, boolean defaultCheckValue) {
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

	@Override
	public boolean filter(EObjectTreeItemWrapper element) {
		return filterEObject(element.getWrappedEObject());
	}

	public abstract boolean filterEObject(EObject eObject);
	
}
