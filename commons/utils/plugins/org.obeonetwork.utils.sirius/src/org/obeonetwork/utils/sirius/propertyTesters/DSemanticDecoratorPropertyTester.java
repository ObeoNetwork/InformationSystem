/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.sirius.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

/**
 * {@link PropertyTester} for asserting that a {@link DSemanticDecorator} selected refers to a specific {@link EObject} type.
 * 
 * @author Thibault Béziers la Fosse <a href="mailto:thibault.beziers-la-fosse@obeo.fr">thibault.beziers-la-fosse@obeo.fr</a>
 *
 */
public class DSemanticDecoratorPropertyTester extends PropertyTester {

    private final static String TARGET_TYPE = "targetType";
    
    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        DSemanticDecorator dSemanticDecorator = (DSemanticDecorator) receiver;
        
        if(TARGET_TYPE.equals(property)) {
            return targetType(dSemanticDecorator, (String) expectedValue);
        }
        
        return false;
    }
    
    /**
     * Asserts that a {@link DSemanticDecorator} is of the queried type, or inherits of the queried type.
     * @param dSemanticDecorator a {@link DSemanticDecorator}
     * @param expectedTypeName the qualified name of the {@link Class}
     * @return <code>true</code> or <code>false</code>
     * 
     */
    private boolean targetType(DSemanticDecorator dSemanticDecorator, String expectedTypeName) {
        EObject target = dSemanticDecorator.getTarget();
        if(target != null) {
            Class<?>[] interfaces = target.getClass().getInterfaces();
            for(int i = 0; i < interfaces.length; i++) {
                if(interfaces[i].getName().equals(expectedTypeName)) {
                    return true;
                }
            }
            Class<?> superClass = target.getClass();
            while(superClass != null) {
                if(superClass.getName().equals(expectedTypeName)) {
                    return true;
                }
                superClass = superClass.getSuperclass();
            }
        }
        return false;
    }

}