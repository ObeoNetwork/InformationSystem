package org.obeonetwork.graal.provider.custom;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.obeonetwork.graal.System;

/**
 * Base ItemProvider for the logical blocs below a {@link System}.
 * 
 * @author Obeo
 *
 */
public class TransientSystemItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	public TransientSystemItemProvider(AdapterFactory adapterFactory, System system) {
		super(adapterFactory);
		system.eAdapters().add(this);
	}

	@Override
	public Object getParent(Object object) {
		return target;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(target);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection collection, int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner);
	}

	protected Command createWrappedCommand(Command command, final EObject owner) {
		return new CommandWrapper(command) {
			public Collection getAffectedObjects() {
				Collection affected = super.getAffectedObjects();
				if (affected.contains(owner)) {
					affected = Collections.singleton(TransientSystemItemProvider.this);
				}
				return affected;
			}
		};
	}

	@Override
	protected Object getValue(EObject eObject, EStructuralFeature eStructuralFeature) {
		// super.getValue((EObject)target, eStructuralFeature);
		if (eObject != null) {
			return super.getValue(eObject, eStructuralFeature);
		}
		return Collections.EMPTY_LIST;
		// return getValue((EObject) target, eStructuralFeature);
		// return null;
	}

}
