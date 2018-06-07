
<%@ include file="/head.jsp" %>
<div><h1>Forum</h1></div>

<c:forEach items="${lstCategorie}" var="categorieMere" varStatus="status">
	<c:if test="${categorieMere.categorie == null}">
	<div class="col-sm-12">
	<h4 class="text-primary"><c:out value = "${categorieMere.titre}"/></h4>
	<ul class="list-group">
		<c:forEach items="${lstCategorie}" var="categorieFille" varStatus="status">
			<c:if test="${categorieFille.categorie.id == categorieMere.id }">
				<li class="list-group-item list-group-item-primary">
					<p class="text-uppercase font-weight-bold"><c:out value = "${categorieFille.titre}"/></p>
						<c:forEach items="${lstSujet}" var="sujet" >
							<c:if test="${categorieFille.id == sujet.categorie.id }">
								<ul>
									<p class="text-uppercase font-weight-bold text-primary"><c:out value = "${sujet.sujet}"/></p>
										<c:forEach items="${lstMessage}" var="message">
											<c:if test="${message.sujet.id == sujet.id }">
												<li class="list-group-item">
													<c:out value = "${message.texte}"/>
												</li>
											</c:if>
										</c:forEach>
										
												<li class="list-group-item"><a href="/forum/ajout/message?Idsujet=${sujet.id}">Nouveau Message</a></li>	
								</ul>
							</c:if>
						</c:forEach>
					<a href="/forum/ajout/sujet?Idcategorie=${categorieFille.id}">Nouveau sujet</a>	
				</li>
			</c:if>	
		</c:forEach>
	</ul>
	</div>
	</br>
</c:if>

    

</c:forEach>
<%@ include file="/footer.jsp" %>

