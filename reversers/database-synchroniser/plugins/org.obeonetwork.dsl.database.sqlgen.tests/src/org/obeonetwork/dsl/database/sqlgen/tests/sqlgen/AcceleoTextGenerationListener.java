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
package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.acceleo.engine.event.AcceleoTextGenerationEvent;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;

public class AcceleoTextGenerationListener implements IAcceleoTextGenerationListener{
	
	protected StringBuffer body;
	protected HashMap<String, StringBuffer> bodies = new HashMap<String, StringBuffer>(); 
	
	public String getBody(String fileName) {
		if(bodies.containsKey(fileName)){
			return bodies.get(fileName).toString();	
		}else{
			return null;
		}		
	}
	public Set<String> getFileNames() {
		return bodies.keySet();
	}

	public void textGenerated(AcceleoTextGenerationEvent event) {		
		this.body.append(event.getText());
	}

	public void filePathComputed(AcceleoTextGenerationEvent event) {		
		this.body=new StringBuffer();
	}

	public void fileGenerated(AcceleoTextGenerationEvent event) {		
		String fileName = event.getText(); 
		this.bodies.put(fileName, body);
		this.body=null;
	}

	public void generationEnd(AcceleoTextGenerationEvent event) {		
	}

	public boolean listensToGenerationEnd() {
		return false;
	}

}
