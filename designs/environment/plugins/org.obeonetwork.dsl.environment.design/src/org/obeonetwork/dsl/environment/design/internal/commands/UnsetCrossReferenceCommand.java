/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.internal.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * This class is used to remove a list of cross references of semantic resources
 * being removed from a project. This will use the {@link SetCommand} to unset
 * uses of semantic resources.
 * 
 * @author gcoutable
 */
public class UnsetCrossReferenceCommand extends AbstractOverrideableCommand {

	private List<Setting> settings = new ArrayList<>();
	
	private Map<OverridenSetCommand, Setting> command2Settings = new HashMap<>();

	public UnsetCrossReferenceCommand(EditingDomain domain) {
		super(domain);
	}
	
	public void addSetting(Setting setting) {
		this.settings.add(setting);
	}
	
	public void addAllSetting(List<Setting> settings) {
		this.settings.addAll(settings);
	}
	
	@Override
	protected boolean prepare() {
		boolean prepare = true;
		for (Setting setting : settings) {
			OverridenSetCommand command = new OverridenSetCommand(domain, setting.getEObject(), setting.getEStructuralFeature(), SetCommand.UNSET_VALUE);
			this.command2Settings.put(command, setting);
			prepare &= command.canExecute();
		}
		return prepare;
	}
	
	@Override
	public void doExecute() {
		for (OverridenSetCommand command : command2Settings.keySet()) {
			command.doExecute();
		}
	}
	
	@Override
	public boolean doCanUndo() {
		// Can undo if all setCommand can be undone
		return this.command2Settings.entrySet().stream()
				.map(Entry::getKey)
				.map(SetCommand::canUndo)
				.reduce(Boolean.TRUE, (prev, next) -> prev && next);
	}

	@Override
	public void doUndo() {
		Map<EObject,EObject> old2New = new HashMap<>();
		for (Entry<OverridenSetCommand, Setting> entry : command2Settings.entrySet()) {
			OverridenSetCommand command = entry.getKey();
			Object oldValue = command.getOldValue();
			if (oldValue instanceof EObject) {
				EObject newEObject = old2New.get(oldValue);
				if (newEObject == null) {
					URI uri = EcoreUtil.getURI((EObject) oldValue);
					ResourceSet resourceSet = domain.getResourceSet();
					newEObject = resourceSet.getEObject(uri, false);
					old2New.put((EObject) oldValue, newEObject);
				}
				command.setOldValue(newEObject);
				command.doUndo();
			}
		}
	}

	@Override
	public void doRedo() {
		for (Entry<OverridenSetCommand, Setting> entry : command2Settings.entrySet()) {
			entry.getKey().doRedo();
		}
	}

	@Override
	public void doDispose() {
		this.settings.clear();
		this.command2Settings.clear();
		super.doDispose();
	}
}
