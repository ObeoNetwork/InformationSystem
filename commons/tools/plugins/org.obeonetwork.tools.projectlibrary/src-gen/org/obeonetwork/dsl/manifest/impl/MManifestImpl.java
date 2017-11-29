/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.manifest.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.manifest.BadVersionStringException;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.dsl.manifest.ManifestPackage;
import org.obeonetwork.dsl.manifest.util.ManifestUtils;
import org.obeonetwork.dsl.manifest.util.ManifestUtils.SemanticVersion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MManifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getVersionMajor <em>Version Major</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getVersionMinor <em>Version Minor</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getVersionPatch <em>Version Patch</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getVersionQualifier <em>Version Qualifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.manifest.impl.MManifestImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MManifestImpl extends MinimalEObjectImpl.Container implements MManifest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected String projectId = PROJECT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionMajor() <em>Version Major</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMajor()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_MAJOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVersionMajor() <em>Version Major</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMajor()
	 * @generated
	 * @ordered
	 */
	protected int versionMajor = VERSION_MAJOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionMinor() <em>Version Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMinor()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_MINOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVersionMinor() <em>Version Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMinor()
	 * @generated
	 * @ordered
	 */
	protected int versionMinor = VERSION_MINOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionPatch() <em>Version Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionPatch()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_PATCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVersionPatch() <em>Version Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionPatch()
	 * @generated
	 * @ordered
	 */
	protected int versionPatch = VERSION_PATCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionQualifier() <em>Version Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_QUALIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionQualifier() <em>Version Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionQualifier()
	 * @generated
	 * @ordered
	 */
	protected String versionQualifier = VERSION_QUALIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<MManifest> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ManifestPackage.Literals.MMANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(String newProjectId) {
		String oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__PROJECT_ID, oldProjectId, projectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersionMajor() {
		return versionMajor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionMajor(int newVersionMajor) {
		int oldVersionMajor = versionMajor;
		versionMajor = newVersionMajor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__VERSION_MAJOR, oldVersionMajor, versionMajor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersionMinor() {
		return versionMinor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionMinor(int newVersionMinor) {
		int oldVersionMinor = versionMinor;
		versionMinor = newVersionMinor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__VERSION_MINOR, oldVersionMinor, versionMinor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVersionPatch() {
		return versionPatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionPatch(int newVersionPatch) {
		int oldVersionPatch = versionPatch;
		versionPatch = newVersionPatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__VERSION_PATCH, oldVersionPatch, versionPatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersionQualifier() {
		return versionQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionQualifier(String newVersionQualifier) {
		String oldVersionQualifier = versionQualifier;
		versionQualifier = newVersionQualifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__VERSION_QUALIFIER, oldVersionQualifier, versionQualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ManifestPackage.MMANIFEST__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MManifest> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<MManifest>(MManifest.class, this, ManifestPackage.MMANIFEST__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getVersion() {
		return new SemanticVersion(versionMajor, versionMinor, versionPatch, versionQualifier).toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setVersion(String versionAsString) throws BadVersionStringException {
		SemanticVersion version = ManifestUtils.getVersionFromString(versionAsString);
		setVersionMajor(version.getMajor());
		setVersionMinor(version.getMinor());
		setVersionPatch(version.getPatch());
		setVersionQualifier(version.getQualifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ManifestPackage.MMANIFEST__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ManifestPackage.MMANIFEST__PROJECT_ID:
				return getProjectId();
			case ManifestPackage.MMANIFEST__CREATION_DATE:
				return getCreationDate();
			case ManifestPackage.MMANIFEST__VERSION_MAJOR:
				return getVersionMajor();
			case ManifestPackage.MMANIFEST__VERSION_MINOR:
				return getVersionMinor();
			case ManifestPackage.MMANIFEST__VERSION_PATCH:
				return getVersionPatch();
			case ManifestPackage.MMANIFEST__VERSION_QUALIFIER:
				return getVersionQualifier();
			case ManifestPackage.MMANIFEST__COMMENT:
				return getComment();
			case ManifestPackage.MMANIFEST__DEPENDENCIES:
				return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ManifestPackage.MMANIFEST__PROJECT_ID:
				setProjectId((String)newValue);
				return;
			case ManifestPackage.MMANIFEST__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case ManifestPackage.MMANIFEST__VERSION_MAJOR:
				setVersionMajor((Integer)newValue);
				return;
			case ManifestPackage.MMANIFEST__VERSION_MINOR:
				setVersionMinor((Integer)newValue);
				return;
			case ManifestPackage.MMANIFEST__VERSION_PATCH:
				setVersionPatch((Integer)newValue);
				return;
			case ManifestPackage.MMANIFEST__VERSION_QUALIFIER:
				setVersionQualifier((String)newValue);
				return;
			case ManifestPackage.MMANIFEST__COMMENT:
				setComment((String)newValue);
				return;
			case ManifestPackage.MMANIFEST__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends MManifest>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ManifestPackage.MMANIFEST__PROJECT_ID:
				setProjectId(PROJECT_ID_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__VERSION_MAJOR:
				setVersionMajor(VERSION_MAJOR_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__VERSION_MINOR:
				setVersionMinor(VERSION_MINOR_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__VERSION_PATCH:
				setVersionPatch(VERSION_PATCH_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__VERSION_QUALIFIER:
				setVersionQualifier(VERSION_QUALIFIER_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case ManifestPackage.MMANIFEST__DEPENDENCIES:
				getDependencies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ManifestPackage.MMANIFEST__PROJECT_ID:
				return PROJECT_ID_EDEFAULT == null ? projectId != null : !PROJECT_ID_EDEFAULT.equals(projectId);
			case ManifestPackage.MMANIFEST__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case ManifestPackage.MMANIFEST__VERSION_MAJOR:
				return versionMajor != VERSION_MAJOR_EDEFAULT;
			case ManifestPackage.MMANIFEST__VERSION_MINOR:
				return versionMinor != VERSION_MINOR_EDEFAULT;
			case ManifestPackage.MMANIFEST__VERSION_PATCH:
				return versionPatch != VERSION_PATCH_EDEFAULT;
			case ManifestPackage.MMANIFEST__VERSION_QUALIFIER:
				return VERSION_QUALIFIER_EDEFAULT == null ? versionQualifier != null : !VERSION_QUALIFIER_EDEFAULT.equals(versionQualifier);
			case ManifestPackage.MMANIFEST__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case ManifestPackage.MMANIFEST__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (projectId: ");
		result.append(projectId);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", versionMajor: ");
		result.append(versionMajor);
		result.append(", versionMinor: ");
		result.append(versionMinor);
		result.append(", versionPatch: ");
		result.append(versionPatch);
		result.append(", versionQualifier: ");
		result.append(versionQualifier);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //MManifestImpl
