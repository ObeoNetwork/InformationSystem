package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class CreateMappingCommand extends RecordingCommand {

	private DBindingEdge edge;
	final private BindingInfo bindingInfo;
	final private DBoundElement leftBoundElement;
	final private DBoundElement rightBoundElement;
	
	public CreateMappingCommand(TransactionalEditingDomain domain,
			BindingInfo bindingInfo,
			DBoundElement leftBoundElement,
			DBoundElement rightBoundElement) {
		super(domain, "Create mapping");
		this.bindingInfo = bindingInfo;
		this.leftBoundElement = leftBoundElement;
		this.rightBoundElement = rightBoundElement;
	}

	@Override
	protected void doExecute() {
		final BindingElement leftBindingElement = getOrCreateBindingElement(leftBoundElement);
		final BindingElement rightBindingElement = getOrCreateBindingElement(rightBoundElement);
		
		if (!areAlreadyBound(leftBindingElement, rightBindingElement)) {			
			BindingReference bindingReference = EnvironmentFactory.eINSTANCE.createBindingReference();
			bindingReference.setLeft(leftBindingElement);
			bindingReference.setRight(rightBindingElement);
			bindingInfo.getReferences().add(bindingReference);
			
			edge = BindingdialectFactory.eINSTANCE.createDBindingEdge();
			edge.setTarget(bindingReference);
			edge.setLeft(leftBoundElement);
			edge.setRight(rightBoundElement);
		}
	}

	public DBindingEdge getBindingEdge() {
		return edge;
	}

	private boolean areAlreadyBound(BindingElement leftBindingElement, BindingElement rightBindingElement) {
		for (BindingReference reference : leftBindingElement.getReferencedByAsLeft()) {
			if (reference.getRight().equals(rightBindingElement)) {
				return true;
			}
		}
		return false;
	}
	
	private BindingElement getOrCreateBindingElement(DBoundElement boundElement) {
		EObject target = boundElement.getTarget();
		List<BoundableElement> globalPath = getGlobalPath(boundElement);
		
		BindingElement element = getExistingBindingElement(globalPath);
		if (element == null) {
			// We have to create a new BindingElement because no one exists
			final BindingElement bindingElement = EnvironmentFactory.eINSTANCE.createBindingElement();
			bindingElement.setBoundElement((BoundableElement)target);

			// We remove the last element in path because it's the same than bindingElement.getboundElement
			globalPath.remove(globalPath.size() - 1);
			bindingElement.getPathReferences().addAll(globalPath);
			
			bindingInfo.getElements().add(bindingElement);
			element = bindingElement;
		}

		return element;
	}

	private List<BoundableElement> getGlobalPath(DBoundElement boundElement) {
		List<BoundableElement> globalPath = new ArrayList<BoundableElement>();
		DBoundElement current = boundElement;
		while (current != null) {
			if (current.getTarget() instanceof BoundableElement) {
				globalPath.add((BoundableElement) current.getTarget());
			}
			current = current.getParent();
		}
		Collections.reverse(globalPath);
		return globalPath;
	}
	
	private List<BoundableElement> getGlobalPath(BindingElement bindingElement) {
		List<BoundableElement> globalPath = new ArrayList<BoundableElement>();
		globalPath.addAll(bindingElement.getPathReferences());
		globalPath.add(bindingElement.getBoundElement());
		return globalPath;
	}
	
	private BindingElement getExistingBindingElement(List<BoundableElement> globalPath) {
		for (BindingElement bindingElement : bindingInfo.getElements()) {
			
			List<BoundableElement> bindingElementPath = getGlobalPath(bindingElement);
			boolean elementFound = true;
			
			// Check if the paths are the same
			if (globalPath.size() == bindingElementPath.size()) {
				for (int i = 0; i < globalPath.size(); i++) {
					if (!EcoreUtil.equals(globalPath.get(i), bindingElementPath.get(i))) {
						// We stop analysing this binding element as soon as there is a difference between the paths
						elementFound = false;
						break;
					}
				}
				if (elementFound) {
					return bindingElement;
				}
			}
		}
		return null;
	}
	
}
