/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.compare.impl.DiffImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RemoveSchema;
import org.obeonetwork.dsl.database.dbevolution.SchemaChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remove Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RemoveSchemaImpl extends SchemaChangeImpl implements RemoveSchema {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveSchemaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.REMOVE_SCHEMA;
	}

} //RemoveSchemaImpl
