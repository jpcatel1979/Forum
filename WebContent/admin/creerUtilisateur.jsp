<%@ include file="/head.jsp" %>

<h1>Creation Utilisateur</h1>
<form method="POST" action="">
<label>Email</label>
<input name="email" id="email" type="email" >
<label>Pseudo</label>
<input type="text" name="pseudo" id="pseudo">
<label> Mot de passe</label>
<input type="password" name="mdp" id="mdp">
<label>Date de naissance</label>
<input type="date" name="birthday" id="birthday">
<label>Role</label>
<select name="role" id="role">
<option value="1">Administrateur</option>
<option value="0">Utilisateur</option>

</select>
<input type="submit" value="s'inscrire">
</form>
<%@ include file="/footer.jsp" %>
</body>
</html>