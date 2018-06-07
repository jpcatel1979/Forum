<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Categorie</title>
</head>
<body>
<h1>Modifier Categorie</h1>
<form method="POST" action="">
<label>Titre de la categorie</label>
<input name="titre"  type="text" value="<c:out value="${cat.titre}" />"/>
<label>Categorie Mere</label>
<select name="idCategorieMere">
<option value="0">Aucune</option>
<c:forEach items="${lstCategorie}" var="categorieMere" >
	
	<c:if test="${categorieMere.categorie == null}">
	<option value="${categorieMere.id}" <c:if test="${categorieMere.id == cat.categorie.id }">selected</c:if> >${categorieMere.titre}
	</option>
	</c:if>
</c:forEach>
</select>
<input name="categorieId" type="hidden" value="<c:out value="${cat.id}" />"/>
<input type="submit" value="envoyer"/>
</form>
</body>
</html>