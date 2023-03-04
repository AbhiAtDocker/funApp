<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
  <head>
    <title>Course Designer</title>
  </head>
  <body>
    <h1>Letter Finder</h1>
    <hr>
    <div id="course" style="">
   
    <br>
    <div id="form1">
     <form method="POST" action="/base/j2ee">
     
     Start Date: <input type="text" name="startDate"/>   End Date <input type="text" name="endDate"/>  <br>
     Student Name: <input type="text" name="student" />  Student Level <input type="text" name="level"/><br>
     Test Taken: <input type="text" name="test"/><br>
     Courses: <br>
     <ul>
      <li>java Preliminary: <input type="checkbox" name="j2ee_priliminary"/></li>
     <li>j2ee Preliminary: <input type="checkbox" name="java_preliminary"/></li>
     <li>java Intermediate: <input type="checkbox" name="j2ee_priliminary"/></li>
     <li>j2ee Intermediate: <input type="checkbox" name="java_preliminary"/></li>
     <>java Advance: <input type="checkbox" name="j2ee_priliminary"/></li>
     j2ee Advance: <input type="checkbox" name="java_preliminary"/><li>
     </ul><br>
      
     
      <input type="submit" name="Search Letter"/>
     </form>
    </div>
    </div>
    
    
    <div id="results" style="">
      <b><u>Result:</u></b><br>
      
      <i>Words that contain letter ${letter}</i> are: <c:out value="${param.letter}"/>
    <ul>
	  <c:forEach items="${words}" var="element"> 
	    <li>${element}</li>
	   </c:forEach>
    </ul>
    </div>
  
    
  </body>
</html>