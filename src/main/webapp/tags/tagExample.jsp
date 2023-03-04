<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
  <%@ page import="abhi.base.util.InitializerJstlCustomFunction" %>
<%@ page import="java.util.*" %>
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
  InitializerJstlCustomFunction initializer = (InitializerJstlCustomFunction)application.getAttribute("initializer");
  
  if(initializer==null){
	  initializer = new InitializerJstlCustomFunction();
	 application.setAttribute("initializer", initializer);
  }
  
  HashMap<String,List<String>> subCategories = (HashMap<String,List<String>>)initializer.getSubCategories();
  request.setAttribute("categories", subCategories);
  out.println(subCategories);
  

	  
	  %>
	  @@@@@
	  ========
	  
  <c:forEach var="entry" items="${categories}">
  Key: <c:out value="${entry.key}"/>
  Value: <c:out value="${entry.value}"/> <br><br>

</c:forEach>	  
	  
----------------



  <h:example greeting="Hello"  name="Whoisit!"/>
  
 

</body>
</html>