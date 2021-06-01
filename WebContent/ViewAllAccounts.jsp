<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.DaoImp.AccountDaoImp"%>
<%@page import="com.Dao.AccountDao"%>
<%@page import="com.Model.Account"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
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
          <a class="nav-link active" aria-current="page" href="dashboard.jsp?">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="account.jsp">ADD</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllAccounts.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>

<jsp:useBean id="accountDaoImp" class="com.DaoImp.AccountDaoImp"></jsp:useBean>
<%List<Account> list=accountDaoImp.getAllAcounts();
request.setAttribute("list", list);
%>

<table class="table">
  <thead>
    <tr>
     
      <th scope="col">Account No</th>
      <th scope="col">Account Holder</th>
      <th scope="col">Password</th>
      <th scope="col">Address</th>
      <th scope="col">Balance</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
      <th scope="col">Withdraw</th>
      <th scope="col">Deposite</th>
    </tr>
   
    <c:forEach items="${list}" var="acct">
     <tr>
    <td>${acct.getAccountNo()}</td>
    <td>${acct.getAccountHolder()}</td>
    <td>${acct.getPassword()}</td>
    <td>${acct.getAddress()}</td>
    <td>${acct.getBalance()}</td>
    <td><a href='updateAccount.jsp?id=${acct.getAccountId()}'>Edit</a></td>  
    <td><a href='DeleteAccount?id=${acct.getAccountId()}'>Delete</a></td>
    <td><a href='withdrawAmount.jsp?id=${acct.getAccountId()}'>WithDraw</a></td>  
    <td><a href='depositeAmount.jsp?id=${acct.getAccountId()}'>Deposite</a></td>
     </tr>
    
    </c:forEach>
    
  </thead>
  <tbody>
    
  </tbody>
</table>
</body>
</html>