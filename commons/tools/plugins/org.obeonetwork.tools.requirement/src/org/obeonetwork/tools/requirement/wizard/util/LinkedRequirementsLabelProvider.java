/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.tools.requirement.wizard.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.requirement.Requirement;

public class LinkedRequirementsLabelProvider extends AdapterFactoryLabelProvider implements ITableLabelProvider {
	private final static int ID=0;
	private final static int NAME=1;
	private final static int CATEGORY=2;
	
	public LinkedRequirementsLabelProvider(final AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getColumnText(Object object, int columnIndex) {
		String text=null;
		if(object instanceof Requirement){
			Requirement requirement = (Requirement)object;
			if(columnIndex==ID){
				text=requirement.getId();
			}else if (columnIndex==NAME) {
				text=requirement.getName();
			}else if (columnIndex==CATEGORY) {
				text=requirement.getCategory()!=null ? requirement.getCategory().getName():"";				 //$NON-NLS-1$
			}
		}else{
			text = super.getColumnText(object, columnIndex);
		}
		return text;
	}

	public Image getColumnImage(Object object, int columnIndex) {		
		return null;
	}
	
	
}
