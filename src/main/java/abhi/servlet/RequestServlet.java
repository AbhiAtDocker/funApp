package abhi.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abhi.base.beans.OxfordWord;
import abhi.base.beans.Word;
import abhi.base.fw.thirdParty.word.client.IClient;
import abhi.base.fw.thirdParty.word.client.impl.OxfordClient;
import abhi.base.util.FileUtility;
import abhi.base.util.StringUtil;
import abhi.game.FindAlphabets;

@WebServlet("/explore")
public class RequestServlet extends HttpServlet {

	private static Long count = 0L ;
	private IClient tpClient = new OxfordClient();
	private Boolean disable3rdParty = true;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		Integer count = 0;
		config.getServletContext().setAttribute("filePathMap", new HashMap<String,String>());
		config.getServletContext().setAttribute("pageHits",count);
		config.getServletContext().setAttribute("words", new HashMap<String,Word>());
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		RequestDispatcher dispatcher = null; 
	    Integer count1 = (Integer) getServletContext().getAttribute("pageHits");
	    getServletContext().setAttribute("pageHits", ++count1);
	    String wordStr =  request.getParameter("w");
	    if(StringUtil.isStringValid(wordStr) && wordStr.endsWith("*"))wordStr = wordStr.substring(0, wordStr.length()-1);
	   
	   	if(request.getSession().getAttribute("v")==null)setValidationParamInSession(request);
		if(request.getParameter("w")!=null){
			
			//get read from file if not present
			//get it from word. Note: before it goes to production ever every word should be in file or in memory
	
			Map<String,Word> words = (Map<String, Word>) getServletContext().getAttribute("words");
		   
			Word word =  words.get(wordStr);
					    
			if(word==null){
				
				word = FileUtility.readWordsFromFile(wordStr);
		        
				
				if(!disable3rdParty && (word==null || !StringUtil.isStringValid(word.getMeanings()))){
				 OxfordWord oWord = tpClient.processRequest(wordStr, "entries");
				 if(oWord!=null)
				  word = propulateWord(oWord,wordStr)	;
				 
				
				} 
			    if(word!=null)	
			 	 words.put(wordStr, word);
   			}
			
			   if(word!=null){
				  word.setWord(wordStr);
			     request.setAttribute("word", word);
			   }else{
				   word = new Word();
				   word.setWord(wordStr);
				   word.setMessage("Word not found. Check online.");
				   request.setAttribute("word", word);
			   }
			     dispatcher = getServletContext().getRequestDispatcher("/games/letterFinder/info.jsp"); 
					  //return html response;	
			}else{
		
			
			
			dispatcher = getServletContext().getRequestDispatcher("/games/letterFinder/letterFinder.jsp");
		    // RequestDispatcher dispatcher = context.getRequestDispatcher("/base/games/letterFinder/letterFinder.jsp");
		  
		}    		
		
		  dispatcher.forward(request, response);
        }  
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
       
		request.getSession().setAttribute("validated", request.getParameter("validated"));
		
		//request.setAttribute("formSubmission", true);
		//doGet(request, response);
		processRequest(request, response);
		
	/*	ServletContext context = getServletContext();
          String letter = request.getParameter("letter");
          FindAlphabets findAlphabets = new FindAlphabets();
          List<String> words = findAlphabets.findAlphabets(letter);
          request.setAttribute("letter", letter);
          request.setAttribute("words", words);
          RequestDispatcher dispatcher = context.getRequestDispatcher("/games/letterFinder/letterFinder.jsp");*/
         // dispatcher.forward(request, response);
		
          //request.getRequestDispatcher();
          
		
}  
	
	
	public Word propulateWord(OxfordWord oWord, String wordStr) throws IOException{
		
		String filePath = FileUtility.writeToFile(oWord, wordStr);
		Map<String,String> filePathMap = (Map<String, String>) getServletContext().getAttribute("filePathMap");
		filePathMap.put(wordStr, filePath);
		Word word = FileUtility.readFromFile(filePath);
		if(word!=null)word.setWord(wordStr);
		return word;
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = null;
		ServletContext context = getServletContext();
        String letter = request.getParameter("letter");
        String[] letters = letter.split(",");
        String category = request.getParameter("category");
        String[] refinements = request.getParameterValues("refinement");
        FindAlphabets findAlphabets = new FindAlphabets();
      //  List<String> words = findAlphabets.findStartsWithAlphabets(letter, category);
        List<String> words = findAlphabets.findStartsWithAlphabets(letters, refinements,category);
        request.setAttribute("words", words);
        dispatcher = context.getRequestDispatcher("/games/letterFinder/letterFinder.jsp");
       // RequestDispatcher dispatcher = context.getRequestDispatcher("/base/games/letterFinder/letterFinder.jsp");
        dispatcher.forward(request, response);
		
		
	}
	
	
	private void setValidationParamInSession(HttpServletRequest request){
		
		  String validated = request.getParameter("v");
          if(validated!=null && !"".equals(validated))
           request.getSession().setAttribute("v", true);		  
		  
	}
}
