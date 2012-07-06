package org.obeonetwork.dsl.environment.gen.java.common.services;

import org.eclipse.emf.ecore.EObject;



/**
 * Acceleo services for String.
 * Copyright (c) 2005-2006 Obeo
 *
 */
public class StringServices {
	
//	public Strings() {
//		Trace.TRACE = true;
//	}
	
	String[] keywords = {  
		    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", 
		    "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "goto", "if",
		    "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package",
		    "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
		    "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
	
	/**
	 * Return the String with the first letter uppercase. Useful for class name.
	 */
	public String firstUpper(String s) {
		if (s.length() > 0) 
			s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
		return s;
	}

	/**
	 * Return the String with the first letter lowercase. Useful for attribute name.
	 */
	public String firstLower(String s) {
		if (s.length() > 0) 
			s = Character.toLowerCase(s.charAt(0)) + s.substring(1);
		return s;
	}

	/**
	 * Compare to strings.
	 */
	public int compare(EObject node, String s1, String s2) {
		return s1.compareTo(s2);
	}

	/**
	 * Replace all instance of one String by another.
	 * @param text Text to tranform
	 * @param arg1 Text to search
	 * @param arg2 Text used for remplace
	 */
	public String replaceAll(String text, String arg1, String arg2) {
		return text.replaceAll(arg1,arg2);
	}
	
	/**
	 * Transform a String with notation aa.bb.cc to aa/bb/cc<br/>
	 * Usefull for package translating.
	 */
	public String toPath(String packageName) {
		return packageName.trim().replaceAll("\\.","/");
	}

	/**
	 * Return a unique code from a String.
	 */
	public int uniqueCode(String s){
		return s.hashCode();
	}

	/**
	 * Convert to standard notation.<br/>
	 * Remove spaces, non letter/digit charaters.
	 * @param name Name to tranform 
	 * @return The String normalized
	 */
	public String toStandardNotation(String name){
		String dest = toClassStandardNotation(name);
		for (int i = 0; i < keywords.length; i++) {
			if (keywords[i].equalsIgnoreCase(dest.toString())) {
				dest += '_';
			}
		}
		return dest.toString();
	}

	public String toClassStandardNotation(String name) {
		StringBuffer dest = new StringBuffer(name.length());
		
		boolean nextMaj = false;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			
			if(!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
				// ignore
				continue;
			}
			
			switch (c) {
			case ' ':
				nextMaj = true;break;
			case '\u00E9' : //'�':
			case '\u00E8' : //'�':
			case '\u00EA' : //'�':
				dest.append('e');break;
			case '\u00e0' : //'�':
				dest.append('a');break;
			case '\u00f9' : //'�':
				dest.append('u');break;
			default:
				if (nextMaj) {
					nextMaj = false;
					dest.append(Character.toUpperCase(c));					
				} else {
					dest.append(c);
				} break;
			}
		}
		return dest.toString();
	}

	/**
	 * Convert to standard package notation.<br/>
	 * Remove spaces, non letter/digit charaters and transfomr to lower case.
	 * @param name Name to tranform 
	 * @return The String normalized
	 */
	public String toPkgName(String name){		
		return toPackageStandardNotation(name).toLowerCase();
	}
	
	private String toPackageStandardNotation(String name) {
		StringBuffer dest = new StringBuffer(name.length());
		
		boolean nextMaj = false;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			
			if(!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
				if ('.' == c) {
					dest.append(c);
				}
				// ignore
				continue;
			}
			
			switch (c) {
			case ' ':
				nextMaj = true;break;
			case '\u00E9' : //'�':
			case '\u00E8' : //'�':
			case '\u00EA' : //'�':
				dest.append('e');break;
			case '\u00e0' : //'�':
				dest.append('a');break;
			case '\u00f9' : //'�':
				dest.append('u');break;
			default:
				if (nextMaj) {
					nextMaj = false;
					dest.append(Character.toUpperCase(c));					
				} else {
					dest.append(c);
				} break;
			}
		}
		
		for (int i = 0; i < keywords.length; i++) {
			if (keywords[i].equalsIgnoreCase(dest.toString())) {
				dest.append('_');
			}
		}
		return dest.toString();
	}

	/**
	 * Repeat nb times the s String.
	 * @param node Just for apply service.
	 * @param s The String to repeat.
	 * @param nb How many time it must be repeated.
	 * @return
	 */
	public String repeat(EObject node, String s, int nb) {
		int size = nb * s.length();
		StringBuffer strBuf = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			strBuf.append(s);
		}
		return strBuf.toString();
	}
	
	/**
	 * Tests if a given String represents a java primitive type.
	 * 
	 * @param typeName
	 *            The name of the type to test.
	 * @return Returns true if and only if the given String represents a java
	 *         primitive type.
	 */
	public boolean isPrimitiveType(String typeName) {
		return "int,boolean,long,double,float,char,byte,".indexOf(typeName.toLowerCase()
				+ ",") >= 0;
	}
	

}
