package abhi.base.util;


public class StringUtil {
	
	public static boolean isStringValid(String str){
		return str!=null && !"".equals(str);
	}
	
	 public static String replaceWith(String str, String replace, String replaceWith){
		 
		 return str.contains(replace)?str.replace(replace, replaceWith):str;
	 }

}
