<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
              <%@ include file="/menu.jsp" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Message</title>
</head>
<body>
<h1>Ajout Un Message au sujet</h1>
<form method="POST" action="">
	<label>Message</label>
	<textarea rows="" cols="" name=message></textarea>
	<input name="idSujet"  type="hidden" value="<c:out value = "${sujet}"/>" >
	<input type="submit" value="envoyer">
</form>
</body>
</html>