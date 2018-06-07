<%@ include file="/head.jsp" %>


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


<div><a href="/forum/gestion/categorie/creation">Creation d'une categorie</a></div>
<%@ include file="/footer.jsp" %>
