<%@ include file="/head.jsp" %>

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
<%@ include file="/footer.jsp" %>
