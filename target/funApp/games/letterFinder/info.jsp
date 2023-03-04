<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
body {font-family: Arial, Helvetica, sans-serif;}



</style>

<div id="detailInfo">
 <span class="close" id="close" onClick="closeOnClick()">&times;</span>   
      <h1>${word.word}</h1>
       
  <c:choose>
    <c:when test="${word.message ne null}">
      <section id="message">  ${word.message}</section>
     </c:when> 
     <c:otherwise>
       <section id="word"> 
         <p>${word.word}: ${word.meanings}</p>
         <p><c:if test="${word.notes ne null}">
               Notes: ${word.notes} 
          </p>   
             </c:if>
       
       </section>
     </c:otherwise>
  </c:choose>


 </div>

