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
package org.obeonetwork.utils.common.ui.services;

import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;

public class DebugServices {

	public EObject trace(EObject self) {
		java.lang.System.out.println("### AQL Trace ###");
		java.lang.System.out.println("self.eClass()   = \"" + self.eClass().getName() + "\"");
		java.lang.System.out.println("self.toString() = \"" + self.toString() + "\"");
		java.lang.System.out.println("self.name       = \"" + 
			Optional.ofNullable(self.eClass().getEStructuralFeature("name"))
			.map(f -> (String)self.eGet(f)).orElse(null) + "\"");
		
		return self;
	}
	
	public EObject traceVars(EObject o) {
		trace(o);
		Session session = new EObjectQuery(o).getSession();
		Map<String, ?> vars = session.getInterpreter().getVariables();
		java.lang.System.out.println(vars.keySet().size() + " variable(s)");
		for(String var : vars.keySet()) {
			java.lang.System.out.println("- " + var + " = " + vars.get(var) + " (" + vars.get(var).getClass() + ")");
		}
		return o;
	}
	
}
