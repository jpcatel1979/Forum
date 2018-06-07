<%@ include file="/head.jsp" %>

<h1>Creation Message</h1>
<form method="POST" action="">
	<label>Sujet</label>
	<input name="sujet"  type="text" >
	<label>Message</label>
	<textarea rows="" cols="" name=message></textarea>
	<input type="submit" value="envoyer">
</form>
<%@ include file="/footer.jsp" %>
