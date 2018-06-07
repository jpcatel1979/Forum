<%@ include file="/head.jsp" %>

<h1>Creation Utilisateur</h1>
	<form method="POST" action="">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-6">
			<input class="form-control col-xs-10" name="email" id="email" type="email" >
			</div>
		</div>
		<div class="form-group row">
		
			<label class="col-sm-2 col-form-label">Pseudo</label>
			<div class="col-sm-6">
				<input class="form-control col-xs-10" type="text" name="pseudo" id="pseudo">
			</div>	
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label"> Mot de passe</label>
			<div class="col-sm-6">
				<input class="form-control col-xs-10" type="password" name="mdp" id="mdp">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Date de naissance</label>
			<div class="col-sm-6">
				<input class="form-control col-xs-10" type="date" name="birthday" id="birthday">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Role</label>
			<div class="col-sm-6">
				<select class="form-control" name="role" id="role">
					<option value="1">Administrateur</option>
					<option value="0">Utilisateur</option>
				</select>
			</div>	
		</div>
		<div class="form-group row">
			
				<input class="btn btn-primary" type="submit" value="s'inscrire">
		</div>
	</form>
<%@ include file="/footer.jsp" %>