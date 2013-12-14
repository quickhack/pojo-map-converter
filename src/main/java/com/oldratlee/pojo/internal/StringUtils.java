package com.oldratlee.pojo.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtils
 * 
 * @author qian.lei
 */

public final class StringUtils {

	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	private static final Pattern KVP_PATTERN = Pattern.compile("([_.a-zA-Z0-9][-_.a-zA-Z0-9]*)[=](.*)"); //key value pair pattern.
	
	private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
	
	public static boolean isBlank(String str)
	{
		if( str == null || str.length() == 0 )
			return true;
		return false;
	}

	/**
	 * is empty string.
	 * 
	 * @param str source string.
	 * @return is empty.
	 */
	public static boolean isEmpty(String str)
	{
		if( str == null || str.length() == 0 )
			return true;
		return false;
	}
    
    /**
     * is integer string.
     * 
     * @param str
     * @return is integer
     */
    public static boolean isInteger(String str) {
    	if (str == null || str.length() == 0)
    		return false;
        return INT_PATTERN.matcher(str).matches();
    }
    
    public static int parseInteger(String str) {
    	if (! isInteger(str))
    		return 0;
        return Integer.parseInt(str);
    }

    /**
     * Returns true if s is a legal Java identifier.<p>
     * <a href="http://www.exampledepot.com/egs/java.lang/IsJavaId.html">more info.</a>
     */
    public static boolean isJavaIdentifier(String s) {
        if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
            return false;
        }
        for (int i=1; i<s.length(); i++) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
        
    /**
     * 
     * @param values
     * @param value
     * @return contains
     */
    public static boolean isContains(String[] values, String value) {
        if (value != null && value.length() > 0 && values != null && values.length > 0) {
            for (String v : values) {
                if (value.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }
    
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

    /**
     * 
     * @param e
     * @return string
     */
    public static String toString(Throwable e) {
    	StringWriter w = new StringWriter();
        PrintWriter p = new PrintWriter(w);
        p.print(e.getClass().getName());
        if (e.getMessage() != null) {
            p.print(": " + e.getMessage());
        }
        p.println();
        try {
            e.printStackTrace(p);
            return w.toString();
        } finally {
            p.close();
        }
    }
    
    /**
     * 
     * @param msg
     * @param e
     * @return string
     */
    public static String toString(String msg, Throwable e) {
    	StringWriter w = new StringWriter();
        w.write(msg + "\n");
        PrintWriter p = new PrintWriter(w);
        try {
            e.printStackTrace(p);
            return w.toString();
        } finally {
            p.close();
        }
    }


	/**
	 * join string.
	 * 
	 * @param array String array.
	 * @return String.
	 */
	public static String join(String[] array)
	{
		if( array.length == 0 ) return "";
		StringBuilder sb = new StringBuilder();
		for( String s : array )
			sb.append(s);
		return sb.toString();
	}

	/**
	 * join string like javascript.
	 * 
	 * @param array String array.
	 * @param split split
	 * @return String.
	 */
	public static String join(String[] array, String split)
	{
		if( array.length == 0 ) return "";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++)
		{
			if( i > 0 )
				sb.append(split);
			sb.append(array[i]);
		}
		return sb.toString();
	}
	
	public static String join(Collection<String> coll, String split) {
	    if(coll.isEmpty()) return "";
	    
	    StringBuilder sb = new StringBuilder();
	    boolean isFirst = true;
	    for(String s : coll) {
	        if(isFirst) isFirst = false; else sb.append(split);
	        sb.append(s);
	    }
	    return sb.toString();
	}

	private StringUtils(){}
}
