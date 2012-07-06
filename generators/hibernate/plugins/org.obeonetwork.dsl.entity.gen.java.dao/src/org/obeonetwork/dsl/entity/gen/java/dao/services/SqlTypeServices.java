package org.obeonetwork.dsl.entity.gen.java.dao.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlTypeServices {

	protected static String[] SQLKeywords = new String[]{"NULL"};
	
	/**
	 * Convert a standard name to SQL convention.<br/>
	 * Exemple : myAttribute -> MY_ATTRIBUTE
	 * @param umlName
	 * @return
	 */
	public String toSqlNotation(String umlName) {
		String sqlName = umlName.replaceAll("\\p{Punct}^_", "");//Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~ Except '_'
		sqlName = sqlName.replaceAll("\\.", "");
		Pattern p = Pattern.compile("(\\p{Lower})(\\p{Upper})");
		Matcher m = p.matcher(sqlName);		
		sqlName = m.replaceAll("$1_$2");
		sqlName = sqlName.replaceAll(" ", "");
		StringBuffer dest = new StringBuffer(sqlName.length());
		
		for (int i = 0; i < sqlName.length(); i++) {
			char c = sqlName.charAt(i);
			switch (c) {
			case '\u00E9' : //'�':
			case '\u00E8' : //'�':
			case '\u00EA' : //'�':
				dest.append('e');break;
			case '\u00e0' : //'�':
				dest.append('a');break;
			case '\u00f9' : //'�':
				dest.append('u');break;
			default:
				dest.append(c);
				break;
			}
		}
		sqlName = dest.toString();				
		sqlName = sqlName.toUpperCase();
		for (int i = 0; i < SQLKeywords.length; i++) {
			String keyword = SQLKeywords[i];
			if (sqlName.equals(keyword)){
				sqlName = sqlName.concat("1");
			}
		}		
		return sqlName;
	}
	
//	public boolean isBiAssociationSource(Property prop) {
//		Class contClass = (Class)prop.eContainer();
//		Class targetClass = (Class)prop.getType();
//		if (contClass.getName().compareTo(targetClass.getName()) > 0)
//			return true;
//		else
//			return false;
//	}

}
