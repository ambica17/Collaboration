<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="perform_login" method="post">

<table border="0">
<tr>
<td>User Name:</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</form>

 <div class="wrapper">
       <img src="resources/images/flip_image.png" class="img-responsive" alt="Responsive image">
        <div class="sol-sm-6">
        
        </div>
     </div>
   <%@include file="footer.jsp" %></body>
