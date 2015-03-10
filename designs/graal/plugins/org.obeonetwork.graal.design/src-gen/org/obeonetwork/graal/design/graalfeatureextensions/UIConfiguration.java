/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.graal.design.graalfeatureextensions;

import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DFeatureExtension;

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getViewpointAnalysis <em>Viewpoint Analysis</em>}</li>
 *   <li>{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getActiveUserStories <em>Active User Stories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage#getUIConfiguration()
 * @model
 * @generated
 */
public interface UIConfiguration extends DFeatureExtension {
	/**
	 * Returns the value of the '<em><b>Viewpoint Analysis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoint Analysis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoint Analysis</em>' reference.
	 * @see #setViewpointAnalysis(DAnalysis)
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage#getUIConfiguration_ViewpointAnalysis()
	 * @model
	 * @generated
	 */
	DAnalysis getViewpointAnalysis();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration#getViewpointAnalysis <em>Viewpoint Analysis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewpoint Analysis</em>' reference.
	 * @see #getViewpointAnalysis()
	 * @generated
	 */
	void setViewpointAnalysis(DAnalysis value);

	/**
	 * Returns the value of the '<em><b>Active User Stories</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UserStory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active User Stories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active User Stories</em>' reference list.
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage#getUIConfiguration_ActiveUserStories()
	 * @model
	 * @generated
	 */
	EList<UserStory> getActiveUserStories();

} // UIConfiguration
