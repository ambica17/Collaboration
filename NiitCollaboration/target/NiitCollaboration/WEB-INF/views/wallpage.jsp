<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<title></title>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>



<table border="0">

<tr>
<td>ID </td> &nbsp;
<td>${walldata.userid }
</tr>
<tr>
<td>Name: </td> &nbsp;
<td>${walldata.username}</td>
</tr>
<tr>
<td>EmailId:</td> &nbsp;
<td>${walldata.emailaddress}</td>
</tr>
<tr>
<td> Picture </td> &nbsp;
<td><img src="/NiitColloboration/resources/images/${walldata.userid}.jpg" width="200px" height="200px"></img></td>
</tr>
</table>

<%@include file="footer.jsp"%>