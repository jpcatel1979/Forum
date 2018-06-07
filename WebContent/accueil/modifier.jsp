<%@ include file="/head.jsp" %>

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
<%@ include file="/footer.jsp" %>
