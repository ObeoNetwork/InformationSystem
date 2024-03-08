package org.obeonetwork.graal.provider.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.provider.util.SystemContentItemProviderUtil;

/**
 * ItemProvider for the logical blocs: Actors, UseCases, SubSystems,
 * UserStories, Tasks and Namespaces below a {@link System}.
 * 
 * @author Obeo
 *
 */
public class SystemCustomContentItemProvider extends TransientSystemItemProvider {

	private EStructuralFeature reference;
	private Supplier<EObject> elementFactory;
	private String labelText;

	private SystemCustomContentItemProvider(AdapterFactory adapterFactory, System system) {
		super(adapterFactory, system);
	}

	public SystemCustomContentItemProvider(AdapterFactory adapterFactory, System system, EStructuralFeature reference,
			Supplier<EObject> elementFactory, String labelText) {
		this(adapterFactory, system);
		Objects.requireNonNull(reference);
		Objects.requireNonNull(elementFactory);
		Objects.requireNonNull(system);
		this.reference = reference;
		this.elementFactory = elementFactory;
		this.labelText = labelText;
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(reference);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		return labelText;
	}

	@Override
	protected String getFeatureText(Object feature) {
		if (feature instanceof EStructuralFeature
				&& SystemContentItemProviderUtil.SYSTEM_CUSTOM_CONTENT_ORDERED_REFERENCES.contains(feature)) {
			return SystemContentItemProviderUtil.getFeatureText((EStructuralFeature) feature);
		}
		return super.getFeatureText(feature);
	}

	@Override
	public Object getImage(final Object element) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.obeonetwork.graal.edit", //$NON-NLS-1$
				"icons/full/obj16/" + reference.getEType().getName() + ".gif"); // $NON-NLS-N$
		// Namespace.gif and AbstractTask.gif must be added manually in the directory if
		// absent.
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		CommandParameter cmdParameter = createChildParameter(reference, elementFactory.get());
		cmdParameter.setOwner(target);
		newChildDescriptors.add(cmdParameter);
	}

	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
		ArrayList<Object> newChildDescriptors = new ArrayList<Object>();
		collectNewChildDescriptors(newChildDescriptors, object);
		return newChildDescriptors;
		// return super.getNewChildDescriptors(target, editingDomain, sibling);
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection collection) {
		if (new AddCommand(domain, (EObject) owner, reference, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}

	public EStructuralFeature getReference() {
		return reference;
	}

	public Supplier<EObject> getElementFactory() {
		return elementFactory;
	}

	public String getLabelText() {
		return labelText;
	}

}
