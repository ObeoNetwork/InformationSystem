/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.Operand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operand</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OperandImpl extends InteractionFragmentImpl implements Operand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.OPERAND;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public End getFinishingEnd() {
        End result = null;
        EObject eContainer = eContainer();

        if (eContainer instanceof CombinedFragment) {
            CombinedFragment cf = (CombinedFragment) eContainer;
            result = cf.getFinishingEnd();

            Operand prev = null;
            for (Operand op : cf.getOwnedOperands()) {
                if (this.equals(prev)) {
                    result = op.getStartingEnd();
                    break;
                } else {
                    prev = op;
                }
            }
        }

        return result;
	}

} //OperandImpl
