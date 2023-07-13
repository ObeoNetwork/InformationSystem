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
package org.obeonetwork.utils.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        return asStream(sourceIterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator, boolean parallel) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
    
    public static <T> Stream<T> closure(T element, Function<? super T, Stream<T>> lambda) {
    	List<T> elements = new ArrayList<>();
    	collect(elements, element, lambda);
    	
    	return elements.stream();
    }

	private static <T> void collect(List<T> elements, T element, Function<? super T, Stream<T>> lambda) {
		elements.add(element);
		lambda.apply(element).forEach(child -> collect(elements, (T) child, lambda));
	}
    
}
