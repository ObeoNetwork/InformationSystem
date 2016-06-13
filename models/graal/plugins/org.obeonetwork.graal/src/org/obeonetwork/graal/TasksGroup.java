/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tasks Group</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.obeonetwork.graal.GraalPackage#getTasksGroup()
 * @model
 * @generated
 */
public interface TasksGroup extends AbstractTask, TasksContainer {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Actor> getRelatedActors();

} // TasksGroup
