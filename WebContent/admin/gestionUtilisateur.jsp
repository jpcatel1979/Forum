<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
              <%@ include file="/menu.jsp" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des utilisateurs</title>
</head>
<body>

<h1>Liste des utilisateurs</h1>
<table>
<thead>
<tr>
<th>Email</th>
<th>Pseudo</th>
<th>role</th>
<th>Date de naissance</th>
<th>Date d'inscription</th>
<th>Suppresion<th>
<th>Modification<th>
</tr>
</thead>
<tbody>
<c:forEach items="${lstUtilisateur}" var="utilisateur" varStatus="status">
<tr>
	<td><c:out value = "${utilisateur.email}"/></td>
	<td><c:out value = "${utilisateur.pseudo}"/></td>
	<td><c:out value = "${utilisateur.admin}"/></td>
	<td><c:out value = "${utilisateur.birthday}"/></td>
	<td><c:out value = "${utilisateur.dateCreation}"/></td>
	<td>
	
		<form action="/forum/gestion/utilisateur" method="post" >
			<input id="email" name="email" type="hidden" value ="${utilisateur.email}">
			<input id="action" name="action" type="hidden" value ="Delette">
			
		  <input type="submit" />
		</form>		
	</td>
	<td>
	<a href="/forum/gestion/utilisateur/update?email=${utilisateur.email}">modifier</a>	
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<div><a href="/forum/gestion/utilisateur/creation">Creation d'un compte</a></div>
</body>
</html>