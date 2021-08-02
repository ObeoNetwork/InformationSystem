package org.obeonetwork.dsl.soa.design.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.SecurityScheme;

/**
 * Basic {@link IStructuredContentProvider} that returns all the {@link Flow} contained in a {@link SecurityScheme}
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
 */
public class FlowContentProvider implements IStructuredContentProvider {

	private SecurityScheme securityScheme;
	
	
	public FlowContentProvider(SecurityScheme securityScheme) {
		this.securityScheme = securityScheme;
	}

	@Override
	public Object[] getElements(Object object) {
		return securityScheme.getFlows().stream().toArray();
	}

}
