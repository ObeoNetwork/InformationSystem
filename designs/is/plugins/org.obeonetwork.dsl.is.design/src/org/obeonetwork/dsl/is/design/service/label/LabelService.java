/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.service.label;

import org.obeonetwork.dsl.entity.util.EntitySwitch;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.util.EnvironmentSwitch;
import org.obeonetwork.dsl.soa.util.SoaSwitch;

public class LabelService {

	SoaLabelSwitch soaLabelSwitch;
	EntityLabelSwitch entityLabelSwitch;
	EnvironmentLabelSwitch environmentLabelSwitch;
	
	/**
	 * Computes the label for an object from SOA meta-model
	 * @param context Object for which we want to compute a label
	 * @return computed label
	 */
	public String computeSoaLabel(ObeoDSMObject context) {
		return getSoaLabelSwitch().doSwitch(context);
	}
	
	/**
	 * Computes the label for an object from Entity meta-model
	 * @param context Object for which we want to compute a label
	 * @return computed label
	 */
	public String computeEntityLabel(ObeoDSMObject context) {
		return getEntityLabelSwitch().doSwitch(context);
	}
	
	/**
	 * Computes the label for an object from Environment meta-model
	 * @param context Object for which we want to compute a label
	 * @return computed label
	 */
	public String computeEnvironmentLabel(ObeoDSMObject context) {
		return getEnvironmentLabelSwitch().doSwitch(context);
	}

	/**
	 * Instantiates (if needed) a switch for labels on SOA and returns it
	 * @return
	 */
	private SoaSwitch<String> getSoaLabelSwitch() {
		if (soaLabelSwitch == null) {
			soaLabelSwitch = new SoaLabelSwitch();
		}
		return soaLabelSwitch;
	}
	
	/**
	 * Instantiates (if needed) a switch for labels on Entity and returns it
	 * @return
	 */
	private EntitySwitch<String> getEntityLabelSwitch() {
		if (entityLabelSwitch == null) {
			entityLabelSwitch = new EntityLabelSwitch();
		}
		return entityLabelSwitch;
	}
	
	/**
	 * Instantiates (if needed) a switch for labels on Environment and returns it
	 * @return
	 */
	private EnvironmentSwitch<String> getEnvironmentLabelSwitch() {
		if (environmentLabelSwitch == null) {
			environmentLabelSwitch = new EnvironmentLabelSwitch();
		}
		return environmentLabelSwitch;
	}
}
