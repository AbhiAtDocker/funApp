package abhi.base.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class InitializerJstlCustomFunction {
	
	private static String FILE_LOCATION="Words.txt";

	private HashMap<String,List<String>> allSubCategories = null;
	private HashMap<String,List<String>> keyEntries = new HashMap<String, List<String>>(); 
	
	public static void main(String[] args) {
		
		InitializerJstlCustomFunction initClass = new InitializerJstlCustomFunction();
		
		System.out.println(initClass.getSubCategories());
		
	}
	
	
	public HashMap<String,List<String>> getSubCategories(){
		if(allSubCategories == null){
		  allSubCategories = new HashMap<String, List<String>>();
		  String lastCategory = null;
		  List<String> subcategories = null;
	      List<String> lines = readWordsFromFile();
	      for(String line:lines){
	    	  if(!line.startsWith("##")){
	    		  
	    		  String[] keyValue = line.split("=");
	    		  keyEntries.put(keyValue[0], Arrays.asList(keyValue[1].split(",")));
	    		  String key = keyValue[0];
    			  String[] catSubCat = key.split(":");
	    		  if(lastCategory==null || !catSubCat[0].equalsIgnoreCase(lastCategory)){
	    			  subcategories = new ArrayList<String>();
	    			  allSubCategories.put(catSubCat[0], subcategories);
	    			  subcategories.add(catSubCat[1]);
	    			 	    			  
	    		  }else{
	    			  subcategories = allSubCategories.get(catSubCat[0]);
	    			  subcategories.add(catSubCat[1]);	  
	    	       }
	    		  lastCategory = catSubCat[0];
	    				  
	    	  }
	      }
		}
  	  				
    	return allSubCategories;
	}
	
	
	public Set<String> getKeys(){
		return keyEntries!=null?keyEntries.keySet():null;
	}
	
	
	/***
	 * 
	 * 
	 * Pass the category name to get subcategory
	 * Assumption is that allSubCategories name is already defined.
	 * @param categoryName
	 * @return
	 */
	
	
	public List<String> getSubCategories(String categoryName){
		return allSubCategories.get(categoryName);
	}

	
	/***
	 * Reads the path from the file
	 * @return
	 */
	public List<String> readWordsFromFile(){
		String line = null;
       List<String> lines = new ArrayList<String>();
       ClassLoader classLoader = getClass().getClassLoader();
       File file = new File(classLoader.getResource(FILE_LOCATION).getFile());

       try {
           // FileReader reads text files in the default encoding.
           FileReader fileReader = 
               new FileReader(file);

           // Always wrap FileReader in BufferedReader.
           BufferedReader bufferedReader = 
               new BufferedReader(fileReader);

           while((line = bufferedReader.readLine()) != null) {
             //  System.out.println(line);
               lines.add(line);
           }   

           // Always close files.
           bufferedReader.close();         
       }
       catch(FileNotFoundException ex) {
           System.out.println(
               "Unable to open file '" + 
            		   FILE_LOCATION + "'");                
       }
       catch(IOException ex) {  
           System.out.println(
               "Error reading file '" 
               + FILE_LOCATION + "'");                  
           // Or we could just do this: 
           // ex.printStackTrace();
       }
   
		
		return lines;
   }
	
	
    public static Integer getSum(int x, int y){
        int sum = x+y;
        return sum;
    }
}
