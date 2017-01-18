package fr.gouv.mindef.safran.project.lifecycle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;

public class ReferenceData {

	private EObject referencingElement;
	private EStructuralFeature referencingFeature;
	private EObject referencedElement;
	
	public ReferenceData(EObject referencedElement, Setting setting) {
		this.referencingElement = setting.getEObject();
		this.referencingFeature = setting.getEStructuralFeature();
		this.referencedElement = referencedElement;
	}
	
	public EObject getReferencingElement() {
		return referencingElement;
	}
	
	public EStructuralFeature getReferencingFeature() {
		return referencingFeature;
	}
	
	public EObject getReferencedElement() {
		return referencedElement;
	}
}
