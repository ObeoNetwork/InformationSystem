/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.impl.ActionImpl;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.OperationKind;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.PropertiesExtension;
import org.obeonetwork.dsl.soa.Securable;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.Server;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.Verb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getSecurityApplications <em>Security Applications</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getSecuritySchemes <em>Security Schemes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#isPublic <em>Public</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getFault <em>Fault</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getVerb <em>Verb</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getExposition <em>Exposition</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#isPaged <em>Paged</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getServers <em>Servers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getPage <em>Page</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.OperationImpl#getPaginationExtension <em>Pagination Extension</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends ActionImpl implements Operation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final OperationKind KIND_EDEFAULT = OperationKind.REQUEST_RESPONSE_LITERAL;
	/**
	 * The default value of the '{@link #isPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIC_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getVerb() <em>Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerb()
	 * @generated
	 * @ordered
	 */
	protected static final Verb VERB_EDEFAULT = Verb.GET;

	/**
	 * The default value of the '{@link #getExposition() <em>Exposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposition()
	 * @generated
	 * @ordered
	 */
	protected static final ExpositionKind EXPOSITION_EDEFAULT = ExpositionKind.NONE;

	/**
	 * The default value of the '{@link #isPaged() <em>Paged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PAGED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Parameter> getInput() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__INPUT, SoaPackage.Literals.OPERATION__INPUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Parameter> getOutput() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__OUTPUT, SoaPackage.Literals.OPERATION__OUTPUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationKind getKind() {
		return (OperationKind)eDynamicGet(SoaPackage.OPERATION__KIND, SoaPackage.Literals.OPERATION__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(OperationKind newKind) {
		eDynamicSet(SoaPackage.OPERATION__KIND, SoaPackage.Literals.OPERATION__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPublic() {
		return (Boolean)eDynamicGet(SoaPackage.OPERATION__PUBLIC, SoaPackage.Literals.OPERATION__PUBLIC, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublic(boolean newPublic) {
		eDynamicSet(SoaPackage.OPERATION__PUBLIC, SoaPackage.Literals.OPERATION__PUBLIC, newPublic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Parameter> getFault() {
		return (EList<Parameter>)eDynamicGet(SoaPackage.OPERATION__FAULT, SoaPackage.Literals.OPERATION__FAULT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getURI() {
		return (String)eDynamicGet(SoaPackage.OPERATION__URI, SoaPackage.Literals.OPERATION__URI, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setURI(String newURI) {
		eDynamicSet(SoaPackage.OPERATION__URI, SoaPackage.Literals.OPERATION__URI, newURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Verb getVerb() {
		return (Verb)eDynamicGet(SoaPackage.OPERATION__VERB, SoaPackage.Literals.OPERATION__VERB, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerb(Verb newVerb) {
		eDynamicSet(SoaPackage.OPERATION__VERB, SoaPackage.Literals.OPERATION__VERB, newVerb);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpositionKind getExposition() {
		return (ExpositionKind)eDynamicGet(SoaPackage.OPERATION__EXPOSITION, SoaPackage.Literals.OPERATION__EXPOSITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExposition(ExpositionKind newExposition) {
		eDynamicSet(SoaPackage.OPERATION__EXPOSITION, SoaPackage.Literals.OPERATION__EXPOSITION, newExposition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPaged() {
		return (Boolean)eDynamicGet(SoaPackage.OPERATION__PAGED, SoaPackage.Literals.OPERATION__PAGED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaged(boolean newPaged) {
		eDynamicSet(SoaPackage.OPERATION__PAGED, SoaPackage.Literals.OPERATION__PAGED, newPaged);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Server> getServers() {
		return (EList<Server>)eDynamicGet(SoaPackage.OPERATION__SERVERS, SoaPackage.Literals.OPERATION__SERVERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getSize() {
		return (Parameter)eDynamicGet(SoaPackage.OPERATION__SIZE, SoaPackage.Literals.OPERATION__SIZE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetSize() {
		return (Parameter)eDynamicGet(SoaPackage.OPERATION__SIZE, SoaPackage.Literals.OPERATION__SIZE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Parameter newSize) {
		eDynamicSet(SoaPackage.OPERATION__SIZE, SoaPackage.Literals.OPERATION__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getPage() {
		return (Parameter)eDynamicGet(SoaPackage.OPERATION__PAGE, SoaPackage.Literals.OPERATION__PAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetPage() {
		return (Parameter)eDynamicGet(SoaPackage.OPERATION__PAGE, SoaPackage.Literals.OPERATION__PAGE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPage(Parameter newPage) {
		eDynamicSet(SoaPackage.OPERATION__PAGE, SoaPackage.Literals.OPERATION__PAGE, newPage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertiesExtension getPaginationExtension() {
		return (PropertiesExtension)eDynamicGet(SoaPackage.OPERATION__PAGINATION_EXTENSION, SoaPackage.Literals.OPERATION__PAGINATION_EXTENSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesExtension basicGetPaginationExtension() {
		return (PropertiesExtension)eDynamicGet(SoaPackage.OPERATION__PAGINATION_EXTENSION, SoaPackage.Literals.OPERATION__PAGINATION_EXTENSION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPaginationExtension(PropertiesExtension newPaginationExtension) {
		eDynamicSet(SoaPackage.OPERATION__PAGINATION_EXTENSION, SoaPackage.Literals.OPERATION__PAGINATION_EXTENSION, newPaginationExtension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SecurityApplication> getAllSecurityApplications() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<SecurityApplication> getSecurityApplications() {
		return (EList<SecurityApplication>)eDynamicGet(SoaPackage.OPERATION__SECURITY_APPLICATIONS, SoaPackage.Literals.SECURABLE__SECURITY_APPLICATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<SecurityScheme> getSecuritySchemes() {
		// TODO: implement this method to return the 'Security Schemes' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.OPERATION__SECURITY_APPLICATIONS:
				return ((InternalEList<?>)getSecurityApplications()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__INPUT:
				return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__OUTPUT:
				return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__FAULT:
				return ((InternalEList<?>)getFault()).basicRemove(otherEnd, msgs);
			case SoaPackage.OPERATION__SERVERS:
				return ((InternalEList<?>)getServers()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.OPERATION__SECURITY_APPLICATIONS:
				return getSecurityApplications();
			case SoaPackage.OPERATION__SECURITY_SCHEMES:
				return getSecuritySchemes();
			case SoaPackage.OPERATION__INPUT:
				return getInput();
			case SoaPackage.OPERATION__OUTPUT:
				return getOutput();
			case SoaPackage.OPERATION__KIND:
				return getKind();
			case SoaPackage.OPERATION__PUBLIC:
				return isPublic();
			case SoaPackage.OPERATION__FAULT:
				return getFault();
			case SoaPackage.OPERATION__URI:
				return getURI();
			case SoaPackage.OPERATION__VERB:
				return getVerb();
			case SoaPackage.OPERATION__EXPOSITION:
				return getExposition();
			case SoaPackage.OPERATION__PAGED:
				return isPaged();
			case SoaPackage.OPERATION__SERVERS:
				return getServers();
			case SoaPackage.OPERATION__SIZE:
				if (resolve) return getSize();
				return basicGetSize();
			case SoaPackage.OPERATION__PAGE:
				if (resolve) return getPage();
				return basicGetPage();
			case SoaPackage.OPERATION__PAGINATION_EXTENSION:
				if (resolve) return getPaginationExtension();
				return basicGetPaginationExtension();
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
			case SoaPackage.OPERATION__SECURITY_APPLICATIONS:
				getSecurityApplications().clear();
				getSecurityApplications().addAll((Collection<? extends SecurityApplication>)newValue);
				return;
			case SoaPackage.OPERATION__INPUT:
				getInput().clear();
				getInput().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SoaPackage.OPERATION__OUTPUT:
				getOutput().clear();
				getOutput().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SoaPackage.OPERATION__KIND:
				setKind((OperationKind)newValue);
				return;
			case SoaPackage.OPERATION__PUBLIC:
				setPublic((Boolean)newValue);
				return;
			case SoaPackage.OPERATION__FAULT:
				getFault().clear();
				getFault().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SoaPackage.OPERATION__URI:
				setURI((String)newValue);
				return;
			case SoaPackage.OPERATION__VERB:
				setVerb((Verb)newValue);
				return;
			case SoaPackage.OPERATION__EXPOSITION:
				setExposition((ExpositionKind)newValue);
				return;
			case SoaPackage.OPERATION__PAGED:
				setPaged((Boolean)newValue);
				return;
			case SoaPackage.OPERATION__SERVERS:
				getServers().clear();
				getServers().addAll((Collection<? extends Server>)newValue);
				return;
			case SoaPackage.OPERATION__SIZE:
				setSize((Parameter)newValue);
				return;
			case SoaPackage.OPERATION__PAGE:
				setPage((Parameter)newValue);
				return;
			case SoaPackage.OPERATION__PAGINATION_EXTENSION:
				setPaginationExtension((PropertiesExtension)newValue);
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
			case SoaPackage.OPERATION__SECURITY_APPLICATIONS:
				getSecurityApplications().clear();
				return;
			case SoaPackage.OPERATION__INPUT:
				getInput().clear();
				return;
			case SoaPackage.OPERATION__OUTPUT:
				getOutput().clear();
				return;
			case SoaPackage.OPERATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SoaPackage.OPERATION__PUBLIC:
				setPublic(PUBLIC_EDEFAULT);
				return;
			case SoaPackage.OPERATION__FAULT:
				getFault().clear();
				return;
			case SoaPackage.OPERATION__URI:
				setURI(URI_EDEFAULT);
				return;
			case SoaPackage.OPERATION__VERB:
				setVerb(VERB_EDEFAULT);
				return;
			case SoaPackage.OPERATION__EXPOSITION:
				setExposition(EXPOSITION_EDEFAULT);
				return;
			case SoaPackage.OPERATION__PAGED:
				setPaged(PAGED_EDEFAULT);
				return;
			case SoaPackage.OPERATION__SERVERS:
				getServers().clear();
				return;
			case SoaPackage.OPERATION__SIZE:
				setSize((Parameter)null);
				return;
			case SoaPackage.OPERATION__PAGE:
				setPage((Parameter)null);
				return;
			case SoaPackage.OPERATION__PAGINATION_EXTENSION:
				setPaginationExtension((PropertiesExtension)null);
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
			case SoaPackage.OPERATION__SECURITY_APPLICATIONS:
				return !getSecurityApplications().isEmpty();
			case SoaPackage.OPERATION__SECURITY_SCHEMES:
				return !getSecuritySchemes().isEmpty();
			case SoaPackage.OPERATION__INPUT:
				return !getInput().isEmpty();
			case SoaPackage.OPERATION__OUTPUT:
				return !getOutput().isEmpty();
			case SoaPackage.OPERATION__KIND:
				return getKind() != KIND_EDEFAULT;
			case SoaPackage.OPERATION__PUBLIC:
				return isPublic() != PUBLIC_EDEFAULT;
			case SoaPackage.OPERATION__FAULT:
				return !getFault().isEmpty();
			case SoaPackage.OPERATION__URI:
				return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
			case SoaPackage.OPERATION__VERB:
				return getVerb() != VERB_EDEFAULT;
			case SoaPackage.OPERATION__EXPOSITION:
				return getExposition() != EXPOSITION_EDEFAULT;
			case SoaPackage.OPERATION__PAGED:
				return isPaged() != PAGED_EDEFAULT;
			case SoaPackage.OPERATION__SERVERS:
				return !getServers().isEmpty();
			case SoaPackage.OPERATION__SIZE:
				return basicGetSize() != null;
			case SoaPackage.OPERATION__PAGE:
				return basicGetPage() != null;
			case SoaPackage.OPERATION__PAGINATION_EXTENSION:
				return basicGetPaginationExtension() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Securable.class) {
			switch (derivedFeatureID) {
				case SoaPackage.OPERATION__SECURITY_APPLICATIONS: return SoaPackage.SECURABLE__SECURITY_APPLICATIONS;
				case SoaPackage.OPERATION__SECURITY_SCHEMES: return SoaPackage.SECURABLE__SECURITY_SCHEMES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Securable.class) {
			switch (baseFeatureID) {
				case SoaPackage.SECURABLE__SECURITY_APPLICATIONS: return SoaPackage.OPERATION__SECURITY_APPLICATIONS;
				case SoaPackage.SECURABLE__SECURITY_SCHEMES: return SoaPackage.OPERATION__SECURITY_SCHEMES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //OperationImpl