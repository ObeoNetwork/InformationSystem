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
package org.obeonetwork.dsl.soa.design.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.soa.MediaType;
import org.obeonetwork.utils.common.StringUtils;

public class SOAValidators {
	// type "/" subtype ["+" suffix] *[";" parameter]
	// https://stackoverflow.com/questions/25201083/regex-to-match-and-validate-internet-media-type
	private static final String OWS = "[ \\w]*";
	private static final String TOKEN = "[0-9A-Za-z!#$%&'*+.^_`|~-]+";
	private static final String QUOTED_STRING = "\"(?:[^\"\\\\]|\\.)*\"";
	private static final String TYPE = "(application|audio|font|example|image|message|model|multipart|text|video|x-(?:"
			+ TOKEN + "))";
	private static final String PARAMETER = ";" + OWS + TOKEN + "=" + "(?:" + TOKEN + "|" + QUOTED_STRING + ")";
	private static final String SUFFIX = "(" + TOKEN + ")((?:" + OWS + PARAMETER + ")*)";
	private static final String MEDIA_TYPE = TYPE + "/" + SUFFIX;

	// https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java
	private static final Pattern URL_PARAM_PATTERN = Pattern.compile(
			"^((https?|ftp|file)://)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);

	// https://stackoverflow.com/questions/8204680/java-regex-email
	// compliant with RFC822 and accepts IP address and server names for intranet
	// purposes.
	private static final Pattern EMAIL_PARAM_PATTERN = Pattern.compile(
			"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
			Pattern.CASE_INSENSITIVE);


	/**
	 * Checks if a URL is valid.
	 * 
	 * @param URL a {@link String}
	 * @return <code>true</code> if the URL is valid
	 */
	public static boolean isValidURL(String URL) {
		if (URL != null) {
			Matcher matcher = URL_PARAM_PATTERN.matcher(URL);
			return matcher.matches();
		} else {
			return false;
		}

	}

	/**
	 * Checks if an email is valid.
	 * 
	 * @param email a {@link String}
	 * @return <code>true</code> if the email is valid
	 */
	public static boolean isValidEmail(String email) {
		if (email != null) {
			Matcher matcher = EMAIL_PARAM_PATTERN.matcher(email);
			return matcher.matches();
		} else {
			return false;
		}
	}

	/**
	 * Checks that the identifier of the given {@link MediaType} matches the spec
	 * {@link https://stackoverflow.com/questions/25201083/regex-to-match-and-validate-internet-media-type}
	 * 
	 * @param mediaType a {@link MediaType}
	 * @return <code>true</code> if the {@link MediaType} has no identifier, or a
	 *         valid one.
	 */
	public static boolean isValidIdentifier(MediaType mediaType) {
		if (!StringUtils.isNullOrWhite(mediaType.getIdentifier())) {
			return mediaType.getIdentifier().matches(MEDIA_TYPE);
		}
		return true;
	}

	public static boolean isValidPrefix(MediaType mediaType) {
		if (!StringUtils.isNullOrWhite(mediaType.getIdentifier())) {
			String prefix = mediaType.getIdentifier().split("/")[0];
			return prefix.matches(TYPE);
		}
		return true;
	}

	public static boolean isValidSuffix(MediaType mediaType) {
		if (!StringUtils.isNullOrWhite(mediaType.getIdentifier())) {
			String[] splitIdentifier = mediaType.getIdentifier().split("/");
			return splitIdentifier.length > 1 && splitIdentifier[1].matches(SUFFIX);
		}
		return true;
	}

	public static boolean isNotEmptyIdentifier(MediaType mediaType) {
		return StringUtils.isNullOrWhite(mediaType.getIdentifier());
	}

}
 