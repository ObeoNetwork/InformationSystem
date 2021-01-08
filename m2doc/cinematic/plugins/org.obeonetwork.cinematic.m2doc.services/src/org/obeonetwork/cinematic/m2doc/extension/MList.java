/*******************************************************************************
 *  Copyright (c) 2008, 2021 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package org.obeonetwork.cinematic.m2doc.extension;

import java.util.Iterator;

import org.obeonetwork.m2doc.element.MElement;

/**
 * @author vrichard
 */
public interface MList extends MElement {

    public boolean add(MElement e);

    public void clear();

    public Iterator<MElement> iterator();

    public boolean remove(Object o);

    public int size();

}
