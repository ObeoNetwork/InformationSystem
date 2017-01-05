/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.impl.StandardEditingPolicy;

public class CustomEditingPolicy extends StandardEditingPolicy {

	protected PropertiesEditingContext editionContext;

	/**
	 * @param propertiesEditionContext
	 */
	public CustomEditingPolicy(PropertiesEditingContext propertiesEditionContext) {
		super(propertiesEditionContext);
		this.editionContext = propertiesEditionContext;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	@Override
	public void execute() {
		EditingDomain editingDomain = EEFUtils.getEditingDomain(editionContext);
		if (editingDomain != null) {
			DomainPropertiesEditionContext domainPropertiesEditionContext = new DomainPropertiesEditionContext(null, null, editingDomain, editionContext.getAdapterFactory(),editionContext.getEObject());
			WizardEditingOperation operation = new WizardEditingOperation(domainPropertiesEditionContext);
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				EEFRuntimePlugin.getDefault().logError("An error occured during wizard editing.", e);
			}
		} else {
			super.execute();
		}
	}
}
