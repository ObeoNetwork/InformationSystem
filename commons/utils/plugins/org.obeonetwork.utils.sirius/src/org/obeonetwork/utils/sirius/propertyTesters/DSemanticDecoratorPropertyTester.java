package org.obeonetwork.utils.sirius.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

public class DSemanticDecoratorPropertyTester extends PropertyTester {

    private final static String TARGET_TYPE = "targetType";
    
    public DSemanticDecoratorPropertyTester() {
    }

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        DSemanticDecorator dSemanticDecorator = (DSemanticDecorator) receiver;
        
        if(TARGET_TYPE.equals(property)) {
            return targetType(dSemanticDecorator, (String) expectedValue);
        }
        
        return false;
    }

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