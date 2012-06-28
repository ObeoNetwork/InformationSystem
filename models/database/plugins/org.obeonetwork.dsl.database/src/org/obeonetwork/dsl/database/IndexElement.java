/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.database;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.IndexElement#getColumn <em>Column</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.IndexElement#isAsc <em>Asc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getIndexElement()
 * @model
 * @generated
 */
public interface IndexElement extends DatabaseElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Column#getIndexElements <em>Index Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getIndexElement_Column()
	 * @see org.obeonetwork.dsl.database.Column#getIndexElements
	 * @model opposite="indexElements"
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.IndexElement#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Asc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asc</em>' attribute.
	 * @see #setAsc(boolean)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getIndexElement_Asc()
	 * @model
	 * @generated
	 */
	boolean isAsc();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.IndexElement#isAsc <em>Asc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asc</em>' attribute.
	 * @see #isAsc()
	 * @generated
	 */
	void setAsc(boolean value);

} // IndexElement
