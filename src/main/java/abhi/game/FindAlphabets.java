package abhi.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author Abhi
 *
 */
public class FindAlphabets {
	
	private static String filePath="Words.txt";
	private static String PROPERTYPATH="proprties.txt";
	private static Map<String,List<String>> properties = new HashMap<>();

	/***
	 * 
	 * @param alphabet
	 * @return
	 */
	public List<String> findAlphabets(String alphabet){
		List<String> allWords = new ArrayList<String>();
		List<String> lettersFound = new ArrayList<String>();
		List<String> lines = readWordsFromFile(filePath);
		if(lines!=null && lines.size()>0){
		 for(String line:lines){
			String[] keyValue = line.split("=");
			String value = keyValue[1];
			String[] letters = value.split(",");
			if(letters.length>0)
				allWords.addAll(Arrays.asList(letters));
		 }
		}
		
		for(String word: allWords)
         if(word.contains(alphabet)|| word.contains(alphabet.toUpperCase()))
        	 lettersFound.add(word);
		
		return lettersFound;
	}
	
	
	/****
	 * 
	 * @return
	 */
	public Map<String,List<String>> getProperties(){
		
	    List<String> lines =  	readWordsFromFile(PROPERTYPATH);
	     
	     lines.forEach(element->{
	    	 String[] split = element.split("=");
	    	 if(split.length==2){
	    	   String[] splitValues = split[1].split(",");
	    	   properties.put(split[0], Arrays.asList(splitValues)) ;
	    	 }
	     });
	    
		return properties;
	}
	
	
	public List<String> getAppicableProperties(String key){
		
		return properties.get(key);
	}
	
	
	/***
	 * Returns all the entries of the categories
	 * @param alphabet
	 * @return
	 */
	public List<String> findStartsWithAlphabets(String[] startsWith, String[] categories, String cat){
		
		List<String> startWithLetter = Arrays.asList(startsWith);
		List<String> categoriesList =  categories!=null?Arrays.asList(categories):Arrays.asList(cat);
		List<String> allItems = new ArrayList<String>();
	    
		
		for(String category: categoriesList){
			if(startWithLetter.isEmpty()){
				allItems.addAll(findStartsWithAlphabets("", category));
			}else{
			for(String letter: startWithLetter){
				allItems.addAll(findStartsWithAlphabets(letter, category));
			}
		   }
		}
		
		Collections.sort(allItems, (s1,s2)->s1.compareTo(s2));
		return allItems;
	}
	
	
	
	
	
	

	/***
	 * Returns all the entries of the categories
	 * @param alphabet
	 * @return
	 */
	public List<String> findStartsWithAlphabets(String startsWith, String categories){
		List<String> allWords = new ArrayList<String>();
		List<String> startsWithLetter = new ArrayList<String>();
		List<String> lines = readWordsFromFile(filePath);
		if(lines!=null && lines.size()>0){
		 for(String line:lines){
			String[] keyValue = line.split("=");
			if(categories.equalsIgnoreCase(keyValue[0])){
			String value = keyValue[1];
			String[] letters = value.split(",");
			if(letters.length>0)
				allWords.addAll(Arrays.asList(letters));
			}
		 }
		}
		
		
		for(String word: allWords)
         if(word.toLowerCase().startsWith(startsWith.toLowerCase()))
        	 startsWithLetter.add(word);
		
		return startsWithLetter;
	}
	
	

	/***
	 * Returns all the entries of the categories
	 * @param alphabet
	 * @return
	 */
	public List<String> findAlphabets(String alphabet, String categories){
		List<String> allWords = new ArrayList<String>();
		List<String> lettersFound = new ArrayList<String>();
		List<String> lines = readWordsFromFile(filePath);
		if(lines!=null && lines.size()>0){
		 for(String line:lines){
			String[] keyValue = line.split("=");
			if(categories.equalsIgnoreCase(keyValue[0])){
			String value = keyValue[1];
			String[] letters = value.split(",");
			if(letters.length>0)
				allWords.addAll(Arrays.asList(letters));
			}
		 }
		}
		
		for(String word: allWords)
         if(word.contains(alphabet)|| word.contains(alphabet.toUpperCase()))
        	 lettersFound.add(word);
		
		return lettersFound;
	}

	
	/**
	 * 
	 * @return
	 */
	public List<String> readWordsFromFile(String filePath){
		String line = null;
        List<String> lines = new ArrayList<String>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                lines.add(line);
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
    
		
		return lines;
    }
	
	
	
	public void saveInFile(String op,String key, String entry ){
	
		/*BufferedWriter out = new BufferedWriter(new FileWriter(FILE_PATH));
		if("c".equalsIgnoreCase(op)){
			out.write("\n");
		}*/
			
		
		
	}
	
    
	

	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		/*try {
			Files.write(Paths.get(FILE_PATH), (System.lineSeparator() + "appending this" + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*try {

			String data = " This is new content";

			File file = new File(FILE_PATH);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
*/
	   }
	
	
}
