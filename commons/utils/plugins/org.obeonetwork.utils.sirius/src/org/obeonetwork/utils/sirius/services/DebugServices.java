/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.sirius.services;

import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;

public class DebugServices {

	public EObject trace(EObject receiver) {
		java.lang.System.out.println("receiver.eClass() = \"" + receiver.eClass().getName() + "\"");
		java.lang.System.out.println("receiver.toString() = \"" + receiver.toString() + "\"");
		java.lang.System.out.println("receiver.name = \"" + 
			Optional.ofNullable(receiver.eClass().getEStructuralFeature("name"))
			.map(f -> (String)receiver.eGet(f)).orElse(null) + "\"");
		
		return receiver;
	}
	
	public EObject traceVars(EObject o) {
		trace(o);
		Session session = new EObjectQuery(o).getSession();
		Map<String, ?> vars = session.getInterpreter().getVariables();
		java.lang.System.out.println(vars.keySet().size() + " variable(s)");
		for(String var : vars.keySet()) {
			java.lang.System.out.println(var + " = " + vars.get(var) + " (" + vars.get(var).getClass() + ")");
		}
		return o;
	}
	
}
