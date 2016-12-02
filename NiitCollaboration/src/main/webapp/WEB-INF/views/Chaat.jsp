<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<CENTER>CHAT PAGE</CENTER>
	<form:form method="POST" action="postC" commandName="chat">
		<table>
			<tr>
				<td>Message :</td>
				</tr>
				<td><form:input path="message"  width="50"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Send"></td>
			</tr>
			
		</table>
	</form:form>
<%@include file="angularchat.jsp" %>

<%@include file="footer.jsp" %>
</body>
</html>