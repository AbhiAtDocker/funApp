<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>List Words</title>
	    
	    <!-- Bootstrap Css -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	    <div id="springMvcHibernate" class="container">
	        <h3 id="header_msg" align="center" class="text-primary">List Words</h3>
	        <br>
			
			<ul>
			 <li> ${word.metadata.provider}
			 <li> 
			     <ul>
			    <c:forEach items="${word.results}" var="result" varStatus="loop">
			      <li> Result - ${loop.index}
			       <li>Language : ${result.language} 
			      <li>Type: ${result.type}
			      <li>Word:${result.word}
	               <li> 
	                   <ul>
	                   <c:forEach items="${result.lexicalEntries}" var="lexicalEntry" varStatus="loop">
	                    <li> Lexical Category: ${lexicalEntry.lexicalCategory}
	                    <li> 
	                      <ul>
	                         <li>Derivatives</li> 
	                         <c:forEach items="${lexicalEntry.derivatives}" var="derivative" varStatus="loop">
	                          
	                           <li> text: ${derivative.text} 
	                         
	                         </c:forEach>
	                      </ul> <!-- End of derivative -->
	                     <li>
	                      <ul>  
	                        
	                         <c:forEach items="${lexicalEntry.entries}" var="entry" varStatus="loop">
	                          <li>Entries - ${loop.index}</li>
	                        <%--   <li> HomographNumber (??) - ${entry.homographNumber} --%>
	                          <li> Etymologies - ${entry.etymologies}
	                          <li> 
	                             <ul>
	                                 <c:forEach items="${entry.grammaticalFeatures}" var="grammer" varStatus="loop">
	                                  <li> Grammar - ${loop.index}
	                                  <li>  text : ${grammer.text} - ${grammer.type}
	                             
	                                 </c:forEach>
	                             
	                             </ul> <!-- End of grammatical features -->
	
	                            <li>
	                               <ul>
	                                 <c:forEach items="${entry.senses}" var="sense" varStatus="loop">
	                                  <li> Sense - ${loop.index}
	                                  <li> id: ${sense.id}
	                                  <li>  Definition : ${sense.definitions}
	                                  <li>    
	                                        <ul>
	                                            <c:forEach items="${sense.examples}" var="example" varStatus="loop">
	                                             <li> Example - ${loop.index}
	                                             <li> example - ${example.text}
	                                          
	                                            </c:forEach>
	                                        </ul> <!-- End of the examples -->
	                                   <li> shorts: ${sense.shortDefinitions} 
	                                   <li> //TODO: subsenses , thesaurasLinks
	                                 </c:forEach> <!--  end of senses -->
	                                
	                             </ul>
	
                              	                            
	                            
	                            </c:forEach> <!-- End of  Entries-->
	                        
	                      </ul> 
	                     
	                     
	                     
	                     <li> 
	                   
	                        <ul>
	                          <c:forEach items="${lexicalEntries.pronunciations}" var="pronounciation" varStatus="loop">
	                            <li> Pronounciation - ${loop.index}
	                            <li> Audio File - ${pronounciation.audioFile}
	                            <li> Dialects - ${pronounciation.dialects}
	                            <li> PhoneticNotation - ${pronounciation.phonaticNotation}
	                            <li> PhoneticSpelling - ${pronounciation.phoneticSpelling}
	                            
	                          </c:forEach> 
	                           
	                   
	                           </ul> <!-- End of Pronunciation -->
	                          
	                         </c:forEach>
	                   
	                       </ul> <!-- End Lexical Entries -->
	                  
	                  
	                     </c:forEach> 
	               
	                  </ul>	<!-- End of results -->	 
			 
			   </ul>
			
			
			
			<div>&nbsp;</div>
	        <!------ SPRING MVC & HIBERNATE EXAMPLE ------>	
	        <div id="spring_mvc_hibernate_usr_mapping_table">
	            <c:if test="${not empty word}">
	        		<table id="usr_table" class="table">
	                	<thead>
	                    	<tr align="center">
	                        	<th scope="col">Words ${word} </th><th scope="col">categories</th><th scope="col">meaning</th><th scope="col">context</th><th scope="col">Edit</th><th scope="col">Delete</th>
	                    	</tr>
	                	</thead>
	                	<tbody>
	                    	<c:forEach var="u" items="${wordList}">
	                        	<tr align="center">
	                            	<td>${u.word}</td><td>${u.categories}</td><td>${u.meanings}</td><td>${u.context}</td><td><a href="editUser/${u.id}">Edit</a></td><td><a href="deleteUser/${u.id}">Delete</a></td>
	                        	</tr>
	                    	</c:forEach>
	                	</tbody>
	            	</table>
	        	</c:if>
	        	
	        	<!-- Error Message -->
	        	<c:if test="${empty wordList}">
	        		<span id="errMsg" class="text-danger">Error in retrieving data!</span>
	        	</c:if>
	        </div>
	    </div>
	</body>
</html>