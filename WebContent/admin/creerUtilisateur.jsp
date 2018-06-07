<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ include file="/menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation Utilisateur</title>
</head>
<body>
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
</body>
</html>