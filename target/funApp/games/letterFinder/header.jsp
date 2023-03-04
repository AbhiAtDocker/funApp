<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="abhi.base.util.InitializerJstlCustomFunction" %>
<%@ page import="java.util.*" %>

<html>
  <head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/games/letterFinder/css/LetterFinder.css">


<script src="${pageContext.request.contextPath}/games/letterFinder/js/letterfinder-min.js"></script>
    <title>Fun App </title>
  </head>
  <body onLoad="setValidate(${sessionScope.v});setIcon();generateNum('robot');">   
   
   
 <%
  InitializerJstlCustomFunction initializer = (InitializerJstlCustomFunction)application.getAttribute("initializer");
  HashMap<String,List<String>> subCategories = (HashMap<String,List<String>>)application.getAttribute("categories");
  
  
  if(initializer==null){
	 initializer = new InitializerJstlCustomFunction();
	 application.setAttribute("initializer", initializer);
	 
  }
  
  if(subCategories==null ){
   subCategories = (HashMap<String,List<String>>)initializer.getSubCategories();
   application.setAttribute("keys", initializer.getKeys());
   application.setAttribute("categories", subCategories);
  }
  
  String device =  request.getHeader("User-Agent").indexOf("Mobile")!=-1?"mobile":"other"; 
  request.setAttribute("deviceType", device);
  
  
%>  

