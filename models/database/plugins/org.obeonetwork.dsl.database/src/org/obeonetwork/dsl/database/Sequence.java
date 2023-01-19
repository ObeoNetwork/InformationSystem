/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getStart <em>Start</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getCacheSize <em>Cache Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#isCycle <em>Cycle</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Sequence#getColumns <em>Columns</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The starting value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(BigInteger)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_Start()
	 * @model
	 * @generated
	 */
	BigInteger getStart();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The increment size.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Increment</em>' attribute.
	 * @see #setIncrement(BigInteger)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_Increment()
	 * @model
	 * @generated
	 */
	BigInteger getIncrement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#getIncrement <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' attribute.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(BigInteger)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_MinValue()
	 * @model
	 * @generated
	 */
	BigInteger getMinValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(BigInteger)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_MaxValue()
	 * @model
	 * @generated
	 */
	BigInteger getMaxValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Cache Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cache size.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cache Size</em>' attribute.
	 * @see #setCacheSize(BigInteger)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_CacheSize()
	 * @model
	 * @generated
	 */
	BigInteger getCacheSize();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#getCacheSize <em>Cache Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Size</em>' attribute.
	 * @see #getCacheSize()
	 * @generated
	 */
	void setCacheSize(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if the sequence is cyclic.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cycle</em>' attribute.
	 * @see #setCycle(boolean)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_Cycle()
	 * @model
	 * @generated
	 */
	boolean isCycle();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Sequence#isCycle <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycle</em>' attribute.
	 * @see #isCycle()
	 * @generated
	 */
	void setCycle(boolean value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Column}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Column#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of colums this sequence is applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getSequence_Columns()
	 * @see org.obeonetwork.dsl.database.Column#getSequence
	 * @model opposite="sequence"
	 * @generated
	 */
	EList<Column> getColumns();

} // Sequence
