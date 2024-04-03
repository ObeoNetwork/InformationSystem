/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

import org.obeonetwork.dsl.soa.services.Messages;

public class HttpStatusService {
	
	private static final Map<String, String> httpStatus;
	private static final List<String> standardSuccessCodes;
	private static final List<String> standardErrorCodes;

	private HttpStatusService() {
	}

	static {
		httpStatus = new HashMap<>();
		httpStatus.put("200", Messages.HttpStatusService_HTTP_responseMessage200); //$NON-NLS-1$
		httpStatus.put("201", Messages.HttpStatusService_HTTP_responseMessage201); //$NON-NLS-1$
		httpStatus.put("202", Messages.HttpStatusService_HTTP_responseMessage202); //$NON-NLS-1$
		httpStatus.put("203", Messages.HttpStatusService_HTTP_responseMessage203); //$NON-NLS-1$
		httpStatus.put("204", Messages.HttpStatusService_HTTP_responseMessage204); //$NON-NLS-1$
		httpStatus.put("205", Messages.HttpStatusService_HTTP_responseMessage205); //$NON-NLS-1$
		httpStatus.put("206", Messages.HttpStatusService_HTTP_responseMessage206); //$NON-NLS-1$
		httpStatus.put("207", Messages.HttpStatusService_HTTP_responseMessage207); //$NON-NLS-1$
		httpStatus.put("208", Messages.HttpStatusService_HTTP_responseMessage208); //$NON-NLS-1$
		httpStatus.put("226", Messages.HttpStatusService_HTTP_responseMessage226); //$NON-NLS-1$
		httpStatus.put("400", Messages.HttpStatusService_HTTP_responseMessage400); //$NON-NLS-1$
		httpStatus.put("401", Messages.HttpStatusService_HTTP_responseMessage401); //$NON-NLS-1$
		httpStatus.put("402", Messages.HttpStatusService_HTTP_responseMessage402); //$NON-NLS-1$
		httpStatus.put("403", Messages.HttpStatusService_HTTP_responseMessage403); //$NON-NLS-1$
		httpStatus.put("404", Messages.HttpStatusService_HTTP_responseMessage404); //$NON-NLS-1$
		httpStatus.put("405", Messages.HttpStatusService_HTTP_responseMessage405); //$NON-NLS-1$
		httpStatus.put("406", Messages.HttpStatusService_HTTP_responseMessage406); //$NON-NLS-1$
		httpStatus.put("407", Messages.HttpStatusService_HTTP_responseMessage407); //$NON-NLS-1$
		httpStatus.put("408", Messages.HttpStatusService_HTTP_responseMessage408); //$NON-NLS-1$
		httpStatus.put("409", Messages.HttpStatusService_HTTP_responseMessage409); //$NON-NLS-1$
		httpStatus.put("410", Messages.HttpStatusService_HTTP_responseMessage410); //$NON-NLS-1$
		httpStatus.put("411", Messages.HttpStatusService_HTTP_responseMessage411); //$NON-NLS-1$
		httpStatus.put("412", Messages.HttpStatusService_HTTP_responseMessage412); //$NON-NLS-1$
		httpStatus.put("413", Messages.HttpStatusService_HTTP_responseMessage413); //$NON-NLS-1$
		httpStatus.put("414", Messages.HttpStatusService_HTTP_responseMessage414); //$NON-NLS-1$
		httpStatus.put("415", Messages.HttpStatusService_HTTP_responseMessage415); //$NON-NLS-1$
		httpStatus.put("416", Messages.HttpStatusService_HTTP_responseMessage416); //$NON-NLS-1$
		httpStatus.put("417", Messages.HttpStatusService_HTTP_responseMessage417); //$NON-NLS-1$
		httpStatus.put("418", Messages.HttpStatusService_HTTP_responseMessage418); //$NON-NLS-1$
		httpStatus.put("421", Messages.HttpStatusService_HTTP_responseMessage421); //$NON-NLS-1$
		httpStatus.put("422", Messages.HttpStatusService_HTTP_responseMessage422); //$NON-NLS-1$
		httpStatus.put("423", Messages.HttpStatusService_HTTP_responseMessage423); //$NON-NLS-1$
		httpStatus.put("424", Messages.HttpStatusService_HTTP_responseMessage424); //$NON-NLS-1$
		httpStatus.put("425", Messages.HttpStatusService_HTTP_responseMessage425); //$NON-NLS-1$
		httpStatus.put("426", Messages.HttpStatusService_HTTP_responseMessage426); //$NON-NLS-1$
		httpStatus.put("428", Messages.HttpStatusService_HTTP_responseMessage428); //$NON-NLS-1$
		httpStatus.put("429", Messages.HttpStatusService_HTTP_responseMessage429); //$NON-NLS-1$
		httpStatus.put("431", Messages.HttpStatusService_HTTP_responseMessage431); //$NON-NLS-1$
		httpStatus.put("451", Messages.HttpStatusService_HTTP_responseMessage451); //$NON-NLS-1$
		httpStatus.put("500", Messages.HttpStatusService_HTTP_responseMessage500); //$NON-NLS-1$
		httpStatus.put("501", Messages.HttpStatusService_HTTP_responseMessage501); //$NON-NLS-1$
		httpStatus.put("502", Messages.HttpStatusService_HTTP_responseMessage502); //$NON-NLS-1$
		httpStatus.put("503", Messages.HttpStatusService_HTTP_responseMessage503); //$NON-NLS-1$
		httpStatus.put("504", Messages.HttpStatusService_HTTP_responseMessage504); //$NON-NLS-1$
		httpStatus.put("505", Messages.HttpStatusService_HTTP_responseMessage505); //$NON-NLS-1$
		httpStatus.put("506", Messages.HttpStatusService_HTTP_responseMessage506); //$NON-NLS-1$
		httpStatus.put("507", Messages.HttpStatusService_HTTP_responseMessage507); //$NON-NLS-1$
		httpStatus.put("508", Messages.HttpStatusService_HTTP_responseMessage508); //$NON-NLS-1$
		httpStatus.put("510", Messages.HttpStatusService_HTTP_responseMessage510); //$NON-NLS-1$
		httpStatus.put("511", Messages.HttpStatusService_HTTP_responseMessage511); //$NON-NLS-1$
		
		standardSuccessCodes = httpStatus.keySet().stream().filter(c -> c.startsWith("2")).sorted().collect(toList());
		standardErrorCodes = httpStatus.keySet().stream().filter(c -> c.startsWith("4") || c.startsWith("5")).sorted().collect(toList());
	}
	
	public static String getHttpMessage(String statusCode) {
		return httpStatus.get(statusCode);
	}
	
	public static List<String> getStandardSuccessCodes() {
		return standardSuccessCodes;
	}
	
	public static List<String> getStandardErrorCodes() {
		return standardErrorCodes;
	}
	
}
