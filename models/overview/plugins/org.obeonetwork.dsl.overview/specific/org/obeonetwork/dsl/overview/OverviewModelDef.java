package org.obeonetwork.dsl.overview;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.AdapterFactory;

public interface OverviewModelDef {

    public final static String EXTENSION_POINT = "org.obeonetwork.dsl.overview.overviewModelDef";
	
    //Check root metadatas and return true if the current Model Def is applicable on the current
    //Overview model
    boolean isApplicable(Root root);
    
    String getFileNameExtension();
    
    AdapterFactory getAdapterFactory();
    
    void initModel(Root root);
    
	Collection<?> getNewChildDescriptors(Root root);

	String getID();
	
	void openEditor(IFile modelFile);
}
