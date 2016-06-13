package org.obeonetwork.dsl.overview;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;



/**
 * A factory proxy for creating a OverviewModelDef.
 * 
 * @author <a href="mailto:jerome@benois.fr">Jerome Benois</a>
 */
public class OverviewModelDefExtensionDescriptor {
	
	 private static final String ID_ATTRIBUTE = "id";

	    public static final String CLASS_ATTRIBUTE = "class";

	    private IConfigurationElement element;

	    public OverviewModelDefExtensionDescriptor(final IConfigurationElement element) {
	        this.element = element;
	    }

	    public OverviewModelDef createOverviewModelDef() {
	        try {
	            return (OverviewModelDef) element
	                    .createExecutableExtension(CLASS_ATTRIBUTE);
	        } catch (final CoreException e) {
	        	e.printStackTrace();
	        } catch (final ClassCastException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public String getId() {
	        return element.getAttribute(ID_ATTRIBUTE);
	    }
}
