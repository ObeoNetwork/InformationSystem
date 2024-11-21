/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.provider.custom;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.provider.util.SystemContentItemProviderUtil;

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
	protected Command createMoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value,
			int index) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			if (feature instanceof EReference && value instanceof EObject) {
				return createWrappedCommand(
						createMoveCommand(domain, finalOwner, (EReference) feature, (EObject) value, index),
						finalOwner);
			}
			return createWrappedCommand(new MoveCommand(domain, finalOwner, feature, value, index), finalOwner);
		}
		return null;
	}

	@Override
	@Deprecated
	protected Command createMoveCommand(EditingDomain domain, EObject owner, EReference feature, EObject value,
			int index) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(new MoveCommand(domain, finalOwner, feature, value, index), finalOwner);
		}
		return null;
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value,
			int index) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			if (index == CommandParameter.NO_INDEX) {
				return createWrappedCommand(createSetCommand(domain, finalOwner, feature, value), finalOwner);
			}
			return createWrappedCommand(new SetCommand(domain, finalOwner, feature, value, index), finalOwner);
		}
		return null;
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(new SetCommand(domain, finalOwner, feature, value), finalOwner);
		}
		return null;
	}

	@Deprecated
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EReference feature,
			Collection<?> collection, int index) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(super.createAddCommand(domain, finalOwner, feature, collection, index),
					finalOwner);
		}
		return null;
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection collection, int index) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(super.createAddCommand(domain, finalOwner, feature, collection, index),
					finalOwner);
		}
		return null;
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection collection) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(super.createRemoveCommand(domain, finalOwner, feature, collection), finalOwner);
		}
		return null;
	}

	@Deprecated
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EReference feature,
			Collection collection) {
		EObject finalOwner = actualOwner(owner, feature);
		if (finalOwner != null) {
			return createWrappedCommand(super.createRemoveCommand(domain, finalOwner, feature, collection), finalOwner);
		}
		return null;
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
		if (eObject != null) {
			return super.getValue(eObject, eStructuralFeature);
		}
		if (target instanceof System) {
			return super.getValue((EObject) target, eStructuralFeature);
		}
		return Collections.EMPTY_LIST;
	}

	protected EObject actualOwner(EObject owner, EStructuralFeature feature) {
		EObject finalOwner = owner;
		if (owner == null && target instanceof System
				&& SystemContentItemProviderUtil.SYSTEM_CUSTOM_CONTENT_ORDERED_REFERENCES.contains(feature)) {
			finalOwner = (System) target;
		}
		return finalOwner;
	}

}
