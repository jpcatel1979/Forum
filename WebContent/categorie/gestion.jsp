<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
              <%@ include file="/menu.jsp" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des categories</title>
</head>
<body>

<h1>Liste des Categories</h1>

<c:forEach items="${lstCategorie}" var="categorieMere" varStatus="status">
	<c:if test="${categorieMere.categorie == null}">
	<h3><c:out value = "${categorieMere.titre}"/></h3>
	<ul>
		<c:forEach items="${lstCategorie}" var="categorieFille" varStatus="status">
			<c:if test="${categorieFille.categorie.id == categorieMere.id }">
				<li>
					<c:out value = "${categorieFille.titre}"/>
					supprimer
					<a href="/forum/gestion/categorie/update?categorieId=${categorieFille.id}">modifier</a>	
				</li>
			</c:if>	
		</c:forEach>
	</ul>
	
	</a></c:if>

    

</c:forEach>


</tbody>
</table>
<div><a href="/forum/gestion/categorie/creation">Creation d'une categorie</a></div>
</body>
</html>