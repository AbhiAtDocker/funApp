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
			
			<div>&nbsp;</div>
	        <!------ SPRING MVC & HIBERNATE EXAMPLE ------>	
	        <div id="spring_mvc_hibernate_usr_mapping_table">
	            <c:if test="${not empty wordList}">
	        		<table id="usr_table" class="table">
	                	<thead>
	                    	<tr align="center">
	                        	<th scope="col">Words</th><th scope="col">categories</th><th scope="col">meaning</th><th scope="col">context</th><th scope="col">Edit</th><th scope="col">Delete</th>
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