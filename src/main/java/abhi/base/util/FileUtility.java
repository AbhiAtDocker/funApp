package abhi.base.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import abhi.base.beans.OxfordWord;
import abhi.base.beans.Word;

public class FileUtility {
	
	
	 private final static String FILE_PATH="D:\\abhi\\workspace\\kbsoft\\funApp\\src\\main\\resources";
	 private final static List<String> keys = Arrays.asList("definitions","notes");
	 
	 
	 public static String getFileStorePath(){
		 return FILE_PATH;
	 }
	
	  
	 public static String getFileUrl(String name) throws IOException{
		 String path = null;
		 if(StringUtil.isStringValid(name)){
			 path = FILE_PATH + System.getProperty("file.separator")+name + ".txt";
		 }
		 
		 //just ensures file is there once operation starts.
		 File file = new File(path);
		 
		 if (file.createNewFile()){
		        System.out.println("File is created!");
		      }else{
		        System.out.println("File already exists.");
		      }
		 
		return path; 
	 }

	  public static File getFile(String fileName){
		 File file  = null;
		 try{
		    ClassLoader classLoader = FileUtility.class.getClassLoader();
		    URL url = classLoader.getResource(fileName.concat(".txt")); 
		    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
		    if(url!=null)file = new File(filePath); 
		 
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	        return file; 
	 }
	 
	 
	 public static Word readWordsFromFile(String filePath){
			String line = null;
	        File file = getFile(filePath);
	        Word word = null;
	        if(file!=null){
	         word = new Word();

	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(file);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                //System.out.println(line);
	            	if(line.startsWith("definitions"))
						word.setMeanings(line.split("=")[1]);
					else if(line.startsWith("notes"))
							word.setNotes(line.split("=").length>1?line.split("=")[1]:null);
	            }   

	            // Always close files.
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                		filePath + "'");                
	        }
	        catch(IOException ex) {  
	            System.out.println(
	                "Error reading file '" 
	                + filePath + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	       }
			
			return word;
	    }
	 

	 public static Word readFromFile(String path){
		 Word word = new Word();
		 try (Stream<String> stream = Files.lines(Paths.get(path))) {

				stream.forEach(entry->{
					
					if(entry.startsWith("definitions"))
					word.setMeanings(entry.split("=").length>1?entry.split("=")[1]:"");
					else if(entry.startsWith("notes"))
						word.setNotes(entry.split("=").length>1?entry.split("=")[1]:null);
				});

			} catch (IOException e) {
				e.printStackTrace();
			}  
		 
	 
	   return word;
	 }
	 
	 
	 
	 public static String writeToFile(OxfordWord oWord, String fileName) 
			  throws IOException {
		         
		         String filePath = getFileUrl(fileName);  
		         final StringBuffer toWrit = new StringBuffer();
		          BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		         keys.forEach(key->{
		        	 
		        	 toWrit.append(getPropertyValue(oWord, key));
		        	 try {
						writer.write(toWrit.toString());
						writer.newLine();
						toWrit.setLength(0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         });
		        
		        //String str =toWrit.toString();
			    
			    //writer.write(str);
			    writer.close();
			    return filePath;
			}
	 
	 
	 
	 
	 
	 
	 public static StringBuffer getPropertyValue(OxfordWord oWord, String key){
           
		 StringBuffer returnValue = null;
		 if("definitions".equalsIgnoreCase(key)){
			 returnValue = getDefinition(oWord, key);
		 }else if("notes".equalsIgnoreCase(key)){
			 returnValue = getNotes(oWord, key);
		 }
		 return returnValue;
	 }
	 
	 
	 
	 private static StringBuffer getNotes(OxfordWord oWord, String key){
		 
		 final StringBuffer returnValue = new StringBuffer();
		 returnValue.append(key).append("=");
		 oWord.getResults().forEach(result->{
			result.getLexicalEntries().forEach(lexicalEntry -> {
				lexicalEntry.getEntries().forEach(entry->{
				  if(entry.getNotes()!=null)entry.getNotes().forEach(note->returnValue.append(note.getText()).append("."));
				});
			});
			 
		 });
		 
		 
		 
		 
		 return returnValue;
	 }
	 
	 
	/*****
	 *  
	 * @param oWord
	 * @param key
	 * @return
	 */
	 
	 private static StringBuffer getDefinition(OxfordWord oWord, String key){
		 
		 final StringBuffer returnValue = new StringBuffer();
		 returnValue.append(key).append("=");
		 oWord.getResults().forEach(result->{
			result.getLexicalEntries().forEach(lexicalEntry -> {
				lexicalEntry.getEntries().forEach(entry->{
				  entry.getSenses().forEach(sense ->{
					  if(sense.getDefinitions()!=null)
					   sense.getDefinitions().forEach(definition ->{
						  returnValue.append(definition).append(";");
					  });
					  
				  });
				});
			});
			 
		 });
		 
		 return new StringBuffer((returnValue.substring(0, returnValue.length()-1)).concat("."));
	 }
	 
	 
	 
	 
	 
}
