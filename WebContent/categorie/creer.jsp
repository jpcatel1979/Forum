<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
              <%@ include file="/menu.jsp" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation Categorie</title>
</head>
<body>
<h1>Creation Categorie</h1>
<form method="POST" action="">
<label>Titre de la categorie</label>
<input name="titre"  type="text" >
<label>Categorie Mere</label>
<select name="idCategorieMere">
<option value="0">Aucune</option>
<c:forEach items="${lstCategorie}" var="categorie" >
	
	<c:if test="${categorie.categorie == null}">
	<option value="${categorie.id}">${categorie.titre}</option>
	
	</c:if>
</c:forEach>
</select>
<input type="submit" value="envoyer">
</form>
</body>
</html>