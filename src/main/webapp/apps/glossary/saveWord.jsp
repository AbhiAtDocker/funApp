
<%@ include file="../include/header.jsp" %>
    <h1>Word Maker</h1>

    <div id="enterWord" style="">
  
    
     <form method="POST" action="/Project1/req">
     
     Enter the word: <input type="text" name="word"/> (Letters should be "," separated) <br>
     Enter the pronunciation: <input type="text" name="pronunciation"/> (Letters should be "," separated) <br>
     Enter the meaning: <input type="textarea" name="meaning"/> (Letters should be "," separated) <br>
     Enter synonyms: <input type="text" name="synonym"/> <br>
     Enter examples: <input type="text" name="examples"/> <br>
     <input type="hidden" name="reqId" value="saveWord"/> 
      <input type="hidden" name="app" value="glossary"/>
     Enter  <input type="submit" name="Search Letter"/>
     </form>
    </div>
    <div id ="word" >
    
      ${word} 
    
      <div id="pronunciation">
      
        ${pronunciation}  
      </div>
      <div id="meaning">
      <ul>
       <c:forEach items="${meanings}" var="element"> 
	    <li>${element}</li>
	   </c:forEach>
      </ul>
      
      </div>
      <div id="synonym">
       <c:choose>
       <c:when test="${synonyms eq null}">
            No entries
       </c:when>
       <c:otherwise>
      <c:forEach items="${synonyms}" var="element"> 
	    <li>${element}</li>
	   </c:forEach>
      </c:otherwise>
      </c:choose>
      </div>
      
      <div id="example">
      <c:choose>
       <c:when test="${examples eq null}">
            No entries
       </c:when>
       <c:otherwise>
       <c:forEach items="${examples}" var="element"> 
	    <li>${element}</li>
	   </c:forEach>
      </c:otherwise>
      </c:choose>
      
            </div>
      
      
      </div>
    
<%@ include file="../include/footer.jsp" %>