<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.DaoImp.UserDaoImp"%>
<%@page import="com.Dao.UserDao"%>
<%@page import="com.Model.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
    	Integer id = Integer.parseInt(request.getParameter("id"));
      System.out.println("id is "+ id);
      UserDaoImp userDaoImp=new UserDaoImp();
      User user=userDaoImp.getUserById(id);
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<style>
 .form{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background-color:#212529;
        border-radius: 30px ;
        margin-top: 100px;
 }
 
 </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark ">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboard.jsp?">Home</a>
        </li>
          <a class="nav-link active" aria-current="page" href="user.jsp">ADD</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllUsers.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>
<div class="form" >
<form id="user" action="UpdateUser" method="post">
  <table>
  <tr>
    <td> <input type="hidden" name="id" value="<%=user.getUserId()%>"><td>
	
	</tr>
		<tr>
			
			<td><input type="text" name="name" value="<%=user.getUserName() %>"></td>
		
		</tr>
		<tr>
			
			<td><input type="text" name="CNIC" value="<%=user.getNIC()%>"></td>
		
		</tr>
		
		<tr>
			
			<td><input type="password" name="password" value="<%=user.getUserPassword()%>"></td>
		
		</tr>
		
        <tr>
		<td><button type="submit" class="btn btn-dark" id="log">UPDATE</button></td>
		</tr>
		
		
	</table>
</form>


</div>
</body>
</html>