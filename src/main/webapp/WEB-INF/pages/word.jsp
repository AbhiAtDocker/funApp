<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Word</title>
<style>

body{
   background: skyblue;
}

table{
   width:1500px;
   margin:3px;
   table-layout:fixed;
}

table,tr,td,th{
  padding:20px;
  color:black;
 /*  border:1px solid #080808; */
  border-collapse:collapse;
  font-size:18px;
  font-family:arial;
  background: linear-gradient (top,#3c3c3c 0%, #222222 100%);
  background: -webkit-linear-gradient (top,#3c3c3c 0%, #222222 100%);

}
td{
  width:auto;
 
}

td>input{
  width:100%;
}

td:hover{
 background:orange;
}


 /* tr:nth-child(even) :nth-child(odd) {
  background:rgba(100,255,50,.1);
  }  */
  
  
  td:nth-child(odd){width: 15%}
  td:nth-child(even) {width: 30%}
</style>

</head>
<body>


  <c:if test="${wordAdded!=null}">
   <h2>Word Added:${wordAdded.word} </h2>
   <ul>
     <li> Meaning: ${wordAdded.meanings}
     <li> Category: ${wordAdded.categories}
   </ul>
  </c:if>

  
    <h2>Add a Word </h2>
    <form:form method="POST" id="form1" action="/wordApp/addWord" modelAttribute="word">
   <table>
    <tr>
        <td><form:label path="word">Word</form:label></td>
        <td><form:input path="word" /></td>
    </tr>
    <tr>
        <td><form:label path="meanings">Meanings</form:label></td>
        <td><form:input path="meanings" /></td>
    </tr>
    <tr>
        <td><form:label path="newContext">Context</form:label></td>
        <td><form:input path="newContext" /></td>
    </tr>
    <tr>
        
        <td> <form:label path="categories" >Categories</form:label></td>
        <td> <form:input path="categories"/></td>
    </tr>
    <tr>
        
        <td> <form:label path="date" >Date</form:label></td>
        <td> <form:input path="date" type="date" pattern="MM/dd/yyyy"/></td>
    </tr>
   
     <tr>
        <td colspan="2">
            <input type="submit" value="Submit" id="submit1"/>
        </td>
    </tr>
    </form:form>
    <tr></tr>
    <tr><th>Search Form</th></tr>
    <form:form method="POST" id="form2" action="/wordApp/searchResult" modelAttribute="word">
     <tr>
        <tr>
        <td><form:label path="word">Word</form:label></td>
        <td><form:input path="word" /></td>
    </tr>
    <tr>
        
        <td> <form:label path="date" >Date</form:label></td>
        <td> <form:input path="date" type="date" pattern="MM/dd/yyyy"/></td>
    </tr>
    
     <tr>
        <td> Get results from 3rd Party
        <td><input type="radio" value="y" name="tp"/ > Yes
        <td><input type="radio" value="n" name="tp"/ > No</td>
    </tr>
    <tr><td><input type="submit" value="Search" id="submit2" > </td></tr>
    
    </form:form>
    <tr> </tr><tr> </tr><tr> </tr><tr> </tr>
    <tr> <td>Search Results </td></tr>
      <tr><th>Word</th><th>Meanings</th><th>context</th><th>category</th><th>Date</th></tr>
       <c:forEach items="${result}" var="word">
        <tr> <td> ${word.word}</td><td>${word.meanings} </td><td> ${word.context}</td><td>${word.categories}</td> <td>${word.date}</td></tr>
       
       </c:forEach>
    
    
    
    
</table>  

        
        
    




    

</body>
</html>