/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.toolkits;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getPossibleEvents <em>Possible Events</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer <em>Is Container</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getStyle <em>Style</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getMetadataHelp <em>Metadata Help</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getMetadataDefinitions <em>Metadata Definitions</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget()
 * @model
 * @generated
 */
public interface Widget extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of this Widget.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The icon path of this widget.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target implementation of this Widget.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Implementation()
	 * @model
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Toolkit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toolkit</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Toolkit owning this Widget.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Toolkit</em>' container reference.
	 * @see #setToolkit(Toolkit)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Toolkit()
	 * @see org.obeonetwork.dsl.cinematic.toolkits.Toolkit#getWidgets
	 * @model opposite="widgets" transient="false"
	 * @generated
	 */
	Toolkit getToolkit();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getToolkit <em>Toolkit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toolkit</em>' container reference.
	 * @see #getToolkit()
	 * @generated
	 */
	void setToolkit(Toolkit value);

	/**
	 * Returns the value of the '<em><b>Possible Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of the events this Widget handles.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Possible Events</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_PossibleEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<WidgetEventType> getPossibleEvents();

	/**
	 * Returns the value of the '<em><b>Is Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this Widget is a container.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Container</em>' attribute.
	 * @see #setIsContainer(boolean)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_IsContainer()
	 * @model
	 * @generated
	 */
	boolean isIsContainer();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#isIsContainer <em>Is Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Container</em>' attribute.
	 * @see #isIsContainer()
	 * @generated
	 */
	void setIsContainer(boolean value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference.
	 * @see #setStyle(Style)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Style()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Style getStyle();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getStyle <em>Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' containment reference.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Style value);

	/**
	 * Returns the value of the '<em><b>Metadata Help</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Concatenated values of metadataDefinitions.help.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metadata Help</em>' attribute.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_MetadataHelp()
	 * @model unique="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	String getMetadataHelp();

	/**
	 * Returns the value of the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summary</em>' attribute.
	 * @see #setSummary(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Summary()
	 * @model
	 * @generated
	 */
	String getSummary();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getSummary <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary</em>' attribute.
	 * @see #getSummary()
	 * @generated
	 */
	void setSummary(String value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' attribute.
	 * @see #setDocumentation(String)
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_Documentation()
	 * @model
	 * @generated
	 */
	String getDocumentation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.cinematic.toolkits.Widget#getDocumentation <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' attribute.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(String value);

	/**
	 * Returns the value of the '<em><b>Metadata Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.toolkits.MetaDataDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadata Definitions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getWidget_MetadataDefinitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MetaDataDefinition> getMetadataDefinitions();

} // Widget
