<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
      <h3>Home Page</h3>
      
      This a Web Application for Employeee Reimbursement. <br><br>
      <b>It includes the following functions:</b>
      <ul>
         <li>Login</li>
         <li>Logout</li>
         <li>Storing user information in cookies</li>
		 <li>View Reimbursement History</li>
		 <li>Request Reimbursement </li>
      </ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>