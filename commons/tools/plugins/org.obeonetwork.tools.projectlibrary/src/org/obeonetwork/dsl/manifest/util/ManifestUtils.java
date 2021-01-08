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
package org.obeonetwork.dsl.manifest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.manifest.BadVersionStringException;

/**
 * Utilities around manifests
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ManifestUtils {
	
	public static final String MODELING_ARCHIVE_FILE_EXTENSION = ".mar";

	private static final Pattern VERSION_PATTERN = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)(\\.[a-zA-Z0-9]+)?$");
	
	private static final String VERSION_PART_SEPARATOR = ".";
	
	public static boolean isVersionFormatValid(String versionAsString) {
		return VERSION_PATTERN.matcher(versionAsString).matches();
	}
	
	public static boolean isGreaterOrEqual(String version1, String version2) {
		return compareVersion(version1, version2) >= 0;
	}
	
	public static boolean isGreater(String version1, String version2) {
		return compareVersion(version1, version2) > 0;
	}
	
	public static boolean isEqual(String version1, String version2) {
		return compareVersion(version1, version2) == 0;
	}
	
	public static int compareVersion(String version1, String version2) {
		SemanticVersion v1 = null;
		SemanticVersion v2 = null;
		try {
			v1 = getVersionFromString(version1);
		} catch (BadVersionStringException e) {
			return -1;
		}
		try {
			v2 = getVersionFromString(version2);
		} catch (BadVersionStringException e) {
			return 1;
		}
		return v1.compareTo(v2);
	}
	
	public static SemanticVersion getVersionFromString(String versionAsString) throws BadVersionStringException {
		SemanticVersion version = new SemanticVersion();
		
		if (versionAsString == null) {
			version.setMajor(-1);
			version.setMinor(-1);
			version.setPatch(-1);
			return version;
		}
		
		Matcher matcher = VERSION_PATTERN.matcher(versionAsString);
		
		if (matcher.matches()) {
			String major = matcher.group(1);
			String minor = matcher.group(2);
			String patch = matcher.group(3);
			
			String qualifier = matcher.groupCount() >= 4 ? matcher.group(4) : "";
			
			try {
				int majorInt = Integer.parseInt(major);
				version.setMajor(majorInt);
			} catch (NumberFormatException e) {
				throw new BadVersionStringException();
			}
			
			try {
				int minorInt = Integer.parseInt(minor);
				version.setMinor(minorInt);
			} catch (NumberFormatException e) {
				throw new BadVersionStringException();
			}
			
			try {
				int patchInt = Integer.parseInt(patch);
				version.setPatch(patchInt);
			} catch (NumberFormatException e) {
				throw new BadVersionStringException();
			}
			
			version.setQualifier(qualifier);
		} else {
			throw new BadVersionStringException();
		}
		return version;
	}
	
	public static class SemanticVersion implements Comparable<SemanticVersion> {
		private int major;
		private int minor;
		private int patch;
		private String qualifier;
		
		public SemanticVersion() {
			super();
		}
		
		public SemanticVersion(int major, int minor, int patch, String qualifier) {
			super();
			this.major = major;
			this.minor = minor;
			this.patch = patch;
			this.qualifier = qualifier;
		}
		
		public int getMajor() {
			return major;
		}
		
		public void setMajor(int major) {
			this.major = major;
		}
		
		public int getMinor() {
			return minor;
		}
		
		public void setMinor(int minor) {
			this.minor = minor;
		}
		
		public int getPatch() {
			return patch;
		}
		
		public void setPatch(int patch) {
			this.patch = patch;
		}
		
		public String getQualifier() {
			return qualifier;
		}
		
		public void setQualifier(String qualifier) {
			this.qualifier = qualifier;
		}
		
		@Override
		public String toString() {
			String version = "" + getMajor() + VERSION_PART_SEPARATOR + getMinor() + VERSION_PART_SEPARATOR + getPatch();
			if (getQualifier() != null && !getQualifier().trim().isEmpty()) {
				version += VERSION_PART_SEPARATOR + getQualifier();
			}
			return version;
		}

		@Override
		public int compareTo(SemanticVersion other) {
			if (getMajor() > other.getMajor()) {
				return 1; 
			} else if (getMajor() < other.getMajor()) {
				return -1;
			} else {
				if (getMinor() > other.getMinor()) {
					return 1; 
				} else if (getMinor() < other.getMinor()) {
					return -1;
				} else {
					if (getPatch() > other.getPatch()) {
						return 1; 
					} else if (getPatch() < other.getPatch()) {
						return -1;
					} else {
						if (getQualifier() == null) {
							if (other.getQualifier() == null) {
								return 0;
							} else {
								return -1;
							}
						} else {
							return getQualifier().compareTo(other.getQualifier());
						}
					}
				}	
			}
		}
	}
}
