/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions;

import org.obeonetwork.dsl.environment.MetaData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Risk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.graalextensions.Risk#getBenefits <em>Benefits</em>}</li>
 *   <li>{@link org.obeonetwork.graalextensions.Risk#getDrawbacks <em>Drawbacks</em>}</li>
 *   <li>{@link org.obeonetwork.graalextensions.Risk#getRisk <em>Risk</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.graalextensions.GraalExtensionsPackage#getRisk()
 * @model
 * @generated
 */
public interface Risk extends MetaData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Benefits</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.graalextensions.BenefitsLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Benefits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Benefits</em>' attribute.
	 * @see org.obeonetwork.graalextensions.BenefitsLevel
	 * @see #setBenefits(BenefitsLevel)
	 * @see org.obeonetwork.graalextensions.GraalExtensionsPackage#getRisk_Benefits()
	 * @model
	 * @generated
	 */
	BenefitsLevel getBenefits();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graalextensions.Risk#getBenefits <em>Benefits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Benefits</em>' attribute.
	 * @see org.obeonetwork.graalextensions.BenefitsLevel
	 * @see #getBenefits()
	 * @generated
	 */
	void setBenefits(BenefitsLevel value);

	/**
	 * Returns the value of the '<em><b>Drawbacks</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.graalextensions.DrawbacksLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawbacks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawbacks</em>' attribute.
	 * @see org.obeonetwork.graalextensions.DrawbacksLevel
	 * @see #setDrawbacks(DrawbacksLevel)
	 * @see org.obeonetwork.graalextensions.GraalExtensionsPackage#getRisk_Drawbacks()
	 * @model
	 * @generated
	 */
	DrawbacksLevel getDrawbacks();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graalextensions.Risk#getDrawbacks <em>Drawbacks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drawbacks</em>' attribute.
	 * @see org.obeonetwork.graalextensions.DrawbacksLevel
	 * @see #getDrawbacks()
	 * @generated
	 */
	void setDrawbacks(DrawbacksLevel value);

	/**
	 * Returns the value of the '<em><b>Risk</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.graalextensions.RiskLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Risk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk</em>' attribute.
	 * @see org.obeonetwork.graalextensions.RiskLevel
	 * @see #setRisk(RiskLevel)
	 * @see org.obeonetwork.graalextensions.GraalExtensionsPackage#getRisk_Risk()
	 * @model
	 * @generated
	 */
	RiskLevel getRisk();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graalextensions.Risk#getRisk <em>Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk</em>' attribute.
	 * @see org.obeonetwork.graalextensions.RiskLevel
	 * @see #getRisk()
	 * @generated
	 */
	void setRisk(RiskLevel value);

} // Risk
