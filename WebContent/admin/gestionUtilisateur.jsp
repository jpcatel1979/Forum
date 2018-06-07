<%@ include file="/head.jsp" %>


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
<%@ include file="/footer.jsp" %>
