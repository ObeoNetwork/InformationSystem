/*******************************************************************************
 *  Copyright (c) 2018 Obeo. 
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

import java.util.ArrayList;
import java.util.Iterator;

import org.obeonetwork.m2doc.element.MElement;

/**
 * @author vrichard
 */
public class MListImpl extends ArrayList<MElement> implements MList {

    @Override
    public boolean add(MElement e) {
        // TODO Auto-generated method stub
        return super.add(e);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        super.clear();
    }

    @Override
    public Iterator<MElement> iterator() {
        // TODO Auto-generated method stub
        return super.iterator();
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return super.remove(o);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return super.size();
    }

}
