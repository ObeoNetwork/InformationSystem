package org.obeonetwork.dsl.soa.design.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.soa.MediaType;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.utils.common.StringUtils;

public class SOAValidators {

	private static final String OWS = "[ \t]*";
	private static final String TOKEN = "[0-9A-Za-z!#$%&'*+.^_`|~-]+";
	private static final String QUOTED_STRING = "\"(?:[^\"\\\\]|\\.)*\"";
	private static final String TYPE = "(application|audio|font|example|image|message|model|multipart|text|video|x-(?:" + TOKEN + "))";
	private static final String PARAMETER = ";" + OWS + TOKEN + "=" + "(?:" + TOKEN + "|" + QUOTED_STRING + ")";
	private static final String MEDIA_TYPE = TYPE + "/" + "(" + TOKEN + ")((?:" + OWS + PARAMETER + ")*)";
	// https://stackoverflow.com/questions/163360/regular-expression-to-match-urls-in-java
	private static final Pattern URL_PARAM_PATTERN = Pattern.compile(
			"^((https?|ftp|file)://)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);
	// https://stackoverflow.com/questions/8204680/java-regex-email 
	// compliant with RFC822 and accepts IP address and server names for intranet purposes.
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
	 * @return <code>true</code> if the {@link MediaType} has no identifier, or a valid one.
	 */
	public static boolean isValidIdentifier(Parameter parameter) {
		if (parameter.getMediaType() != null) {
			if (!StringUtils.isNullOrWhite(parameter.getMediaType().getIdentifier())) {
				return parameter.getMediaType().getIdentifier().matches(MEDIA_TYPE);
			}
		}
		return true;		
	}
}
