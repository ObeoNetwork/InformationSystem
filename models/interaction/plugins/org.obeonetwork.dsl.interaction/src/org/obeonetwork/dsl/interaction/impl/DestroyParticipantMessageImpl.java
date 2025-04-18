/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.interaction.DestroyParticipantMessage;
import org.obeonetwork.dsl.interaction.InteractionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Destroy Participant Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DestroyParticipantMessageImpl extends MessageImpl implements DestroyParticipantMessage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DestroyParticipantMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.DESTROY_PARTICIPANT_MESSAGE;
	}

} //DestroyParticipantMessageImpl
