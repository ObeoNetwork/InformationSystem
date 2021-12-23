package org.obeonetwork.dsl.soa.spec;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.impl.OperationImpl;

public class OperationSpec extends OperationImpl {

	@Override
	public EList<SecurityScheme> getSecuritySchemes() {
		
		return ECollections.unmodifiableEList(getSecurityApplications().stream().map(sa -> sa.getSecurityScheme()).collect(Collectors.toList()));
	}

}
