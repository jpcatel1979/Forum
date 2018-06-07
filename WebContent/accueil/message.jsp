<%@ include file="/head.jsp" %>

<h1>Ajouter un Message au sujet <c:out value = "${sujet.sujet}"/></h1>
<form method="POST" action="">
	<label>Message</label>
	<textarea rows="" cols="" name=message></textarea>
	<input name="idSujet"  type="hidden" value="<c:out value = "${sujet}"/>" >
	<input type="submit" value="envoyer">
</form>
<%@ include file="/footer.jsp" %>
