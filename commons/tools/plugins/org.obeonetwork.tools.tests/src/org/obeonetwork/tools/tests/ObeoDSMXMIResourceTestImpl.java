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
package org.obeonetwork.tools.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * A resource for testing purpose. Allows to serialize EObjects in a comparable
 * form. The XMI ids are replaced with a string representing a containment path,
 * and the following features are ignored (not serialized) :
 * <ul>
 * <li>technicalid::Identifiable.technicalid</li>
 * <li>environment::ObeoDSMObject.createdOn</li>
 * <li>environment::ObeoDSMObject.modifiedOn</li>
 * </ul>
 */
public class ObeoDSMXMIResourceTestImpl extends XMIResourceImpl {
	
	private static final List<EStructuralFeature> IGNORED_FEATURES = new ArrayList<>();
	static {
		IGNORED_FEATURES.add(TechnicalIDPackage.eINSTANCE.getIdentifiable_Technicalid());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn());
	}
	
	@Override
    protected XMLHelper createXMLHelper() {
        return new XMLHelperImpl() {
        	
            @Override
            public Object getValue(EObject obj, EStructuralFeature f) {
                if(IGNORED_FEATURES.contains(f)) {
                    return null;
                }
                
                Object value = super.getValue(obj, f);
                
                return value;
            }
            
            @Override
            public String getHREF(EObject obj) {
            	StringBuffer href = new StringBuffer();
            	
            	EObject ancestor = obj;
            	while(ancestor != null) {
                	EStructuralFeature nameFeature = ancestor.eClass().getEStructuralFeature("name");
                	if(nameFeature != null) {
                    	href.insert(0, "[" + ancestor.eGet(nameFeature) + "]");
                	}
                	
            		if(ancestor.eContainingFeature() != null) {
            			href.insert(0, ancestor.eContainingFeature().getName());
                		href.insert(0, ".");
            		}
            		
            		ancestor = ancestor.eContainer();
            	}
            	
            	return href.toString();
            }
            
        };
    }

}
