<%@ include file="/head.jsp" %>

<h1>Modifier Utilisateur</h1>
<form method="POST" action="">
	</form>
<form method="POST" action="">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-6">
			<input class="form-control col-xs-10" name="email" id="email" type="email" readonly value="<c:out value = "${utilisateur.email}"/>" >
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Pseudo</label>
		<div class="col-sm-6">
			<input class="form-control col-xs-10" type="text" name="pseudo" id="pseudo" value="<c:out value="${utilisateur.pseudo}"/>">
		</div>	
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label"> Mot de passe</label>
		<div class="col-sm-6">
			<input class="form-control col-xs-10" type="password" name="mdp" id="mdp" value="<c:out value="${utilisateur.password}"/>">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Date de naissance</label>
		<div class="col-sm-6">
			<input class="form-control col-xs-10" type="date" name="birthday" id="birthday" value="<c:out value="${utilisateur.birthday}"/>">
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Role</label>
		<div class="col-sm-6">
			<select class="form-control" name="role" id="role">
				<option value="1" <c:if test="${utilisateur.admin == true}">selected </c:if>>Administrateur</option>
				<option value="0" <c:if test="${utilisateur.admin == false}">selected </c:if>>Utilisateur</option>
			</select>
		</div>	
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Changer le mot de passe</label>
		<div class="col-sm-6">
			<select class="form-control" name="updatePassword" id="updatePassword">
				<option value="NON">NON</option>
				<option value="OUI">OUI</option>
			</select>
		</div>	
	</div>
	<div class="form-group row">
		<input class="btn btn-primary" type="submit" value="modifier">
	</div>
</form>
<%@ include file="/footer.jsp" %>
