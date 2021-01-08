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
package org.obeonetwork.dsl.database.gen.common.services;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

public class StatusUtils {

	private static final String PLUGIN_ID = "org.obeonetwork.dsl.database.sqlgen";

	/**
	 * Creates an error status
	 * 
	 * @param message the error message
	 * @return a {@link IStatus}
	 */
	public static IStatus createErrorStatus(String message) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message);
	}

	/**
	 * Creates an warning status
	 * 
	 * @param message the error message
	 * @return a {@link IStatus}
	 */
	public static IStatus createWarningStatus(String message) {
		return new Status(IStatus.WARNING, PLUGIN_ID, message);
	}

	/**
	 * Creates an error status
	 * 
	 * @param message the error message
	 * @param e       a throwable
	 * @return a {@link IStatus}
	 */
	public static IStatus createErrorStatus(String message, Throwable e) {
		Throwable cause = e.getCause();
		if (cause != null && !cause.equals(e)) {
			MultiStatus multiStatus = new MultiStatus(PLUGIN_ID, IStatus.ERROR, message, e);
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, cause.getMessage(), cause));
			return multiStatus;
		} else {
			return new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		}
	}

	/**
	 * Creates a {@link IStatus} from the given children (the severity of the main
	 * status is the worst severity from its children)
	 * 
	 * @param message  a message
	 * @param statuses list of children
	 * @return a {@link IStatus}
	 */
	public static IStatus createMultiStatus(String message, List<IStatus> statuses) {
		MultiStatus mStatus = new MultiStatus(PLUGIN_ID, -1, message, null);
		for (IStatus s : statuses) {
			mStatus.add(s);
		}
		return mStatus;
	}

}
