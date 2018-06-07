
<%@ include file="/head.jsp" %>
<h1>Forum</h1>

<c:forEach items="${lstCategorie}" var="categorieMere" varStatus="status">
	<c:if test="${categorieMere.categorie == null}">
	<h3><c:out value = "${categorieMere.titre}"/></h3>
	<ul>
		<c:forEach items="${lstCategorie}" var="categorieFille" varStatus="status">
			<c:if test="${categorieFille.categorie.id == categorieMere.id }">
				<li>
					<c:out value = "${categorieFille.titre}"/>
						<c:forEach items="${lstSujet}" var="sujet" >
							<c:if test="${categorieFille.id == sujet.categorie.id }">
								<ul>
									<c:out value = "${sujet.sujet}"/>
										<c:forEach items="${lstMessage}" var="message">
											<c:if test="${message.sujet.id == sujet.id }">
												<li><c:out value = "${message.texte}"/></li>
											</c:if>
										</c:forEach>
										<li><a href="/forum/ajout/message?Idsujet=${sujet.id}">Nouveau Message</a></li>	
										
								</ul>
							</c:if>
						</c:forEach>
					<a href="/forum/ajout/sujet?Idcategorie=${categorieFille.id}">Nouveau sujet</a>	
				</li>
			</c:if>	
		</c:forEach>
	</ul>
	
	</a></c:if>

    

</c:forEach>
<%@ include file="/footer.jsp" %>

