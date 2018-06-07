<%@ include file="/head.jsp" %>

<h1>Modifier Utilisateur</h1>
<form method="POST" action="">
<label>Email</label>
<input name="email" id="email" type="email" readonly value="<c:out value = "${utilisateur.email}"/>" >
<label>Pseudo</label>
<input type="text" name="pseudo" id="pseudo" value="<c:out value="${utilisateur.pseudo}"/>">
<label> Mot de passe</label>
<input type="password" name="mdp" id="mdp" value="<c:out value="${utilisateur.password}"/>">
<label>Date de naissance</label>
<input type="date" name="birthday" id="birthday" value="<c:out value="${utilisateur.birthday}"/>">
<label>Role</label>
<select name="role" id="role">
<option value="1" <c:if test="${utilisateur.admin == true}">selected </c:if>>Administrateur</option>
<option value="0" <c:if test="${utilisateur.admin == false}">selected </c:if>>Utilisateur</option>

</select>  

<label>Changer le mot de passe</label>
<select name="updatePassword" id="updatePassword">
<option value="NON">NON</option>
<option value="OUI">OUI</option>

</select>  
<input type="submit" value="modifier">
</form>
<%@ include file="/footer.jsp" %>
