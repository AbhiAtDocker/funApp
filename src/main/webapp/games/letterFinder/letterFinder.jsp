<%@include file="header.jsp" %>
  
  <div id="heading">
   <div id="text">
    <h1>Fun App - Explore Urself <i class="fa fa-hand-o-right" style="font-size:36px;color:red"></i></h1>

<!--      <i class="fa fa-hand-o-down" style="font-size:36px;color:red"></i>
 -->
    
    <%-- <c:choose>
      <c:when test="${sessionScope.v eq null}">
     
      </c:when>
      <c:otherwise>
       
      </c:otherwise>
    </c:choose> --%>
    <h3><i>Search By Letter(s) and Category<i></h3>
   </div>
  
     <div id="robot">
         
     </div>
   
   </div>
      
    <h1 style="display:none"> <%=application.getAttribute("pageHits") %></h1>
    
    <div id="search" >
     <form method="POST" action="${pageContext.request.contextPath}/explore" id="form1" >
    <!--  <input type="hidden" name="validated"  id="validated"/> -->
     <label>Enter Letter(s) (<i> ',' separated </i>)<i style="color:red"> * </i>:</label>
     <input type="text" name="letter" id="letters" disabled="disabled"/> <br>
     <label for="categories">Categories(<i style="color:red"> * </i>)</label>
     <select id="category" name="category" onChange="prepareRefinements(this.value)" id="category" disabled="disabled">
	      <option value='' selected disabled hidden>Choose a Category</option>
	      <option value="countries:All">Countries</option>
	      <option value="boundaries:All">Boundaries</option>
	      <option value="feelings:All">Feelings</option>
    </select>
    <!-- if this option will be shown if 
         selected category has more than one
         subcategories and if checked 
         then sub categories will open up -->     
     
      
      <div id="refinements" >     
             <input type="checkbox" name="checkRefinement" value="yes" onclick="displayRefinements()"><label>Refine the search <I>(Optional - Will return all items in result)</I></label>
             
             <c:forEach var="entry" items="${categories}">
             <div id="displayRefinements:${entry.key}"  style="display:none">
                <c:forEach var="listElement" items="${entry.value}">
                 <input type="checkbox" name="refinement" value='<c:out value="${entry.key}:${listElement}"/>'><label>${listElement}</label>                  

                </c:forEach>
              </div>
            </c:forEach>	
        </div>
      <!-- TODO: ensure that categories is selected. -->
      <input type="submit" name="Search Letter" onClick="return validate('letters','category');" />
      
     </form>

  
    <div id="results" style="">
      <b><u>Search Result: </u></b><br>
        <c:if test="${(param.category != '') && param.category ne null}">
      <i><c:out value="${param.category}"/> that starts with letter <c:out value="${param.letter}"/> </i> are: 
    <c:choose>
     <c:when test="${words ne null && fn:length(words)>0}">
    <ol>
	  <c:forEach items="${words}" var="element"> 
	    <c:choose>
	     <c:when test="${requestScope.deviceType eq 'mobile' && fn:length(element)>26}">
	        <li style="font-size:9px">${element} <i id="withEle" class="fa fa-hand-o-right" style="padding-left:10px;color:green"></i>  <div id="info" title="hover for more info" link="${pageContext.request.contextPath}/explore?w=${element}" onmouseover="getInfo(this);" ><b>&#9432;</b></div></li>
	     </c:when>
	     <c:otherwise>
	        <li> ${element} <i id="withEle" class="fa fa-hand-o-right" style="padding-left:10px;color:green"></i>  <div id="info" title="hover for more info" link="${pageContext.request.contextPath}/explore?w=${element}"  onmouseover="getInfo(this);" ><b>&#9432;</b></div></li>
	     </c:otherwise>
	     </c:choose>
	   </c:forEach>
    </ol>
    </c:when>
    <c:otherwise>
     <ul>
        <li> No entries found 
     </ul>
    </c:otherwise>
    </c:choose>
    </div>
    </c:if>
  
   </div>
   
   <div id="popup">
     
    </div>
  
 <%@include file="footer.jsp"%>