<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="./assets/css/bootstrap.css" rel="stylesheet">
    <link href="./style/app.css" rel="stylesheet">
    <link href="./style/login.css" rel="stylesheet">
    <link href="" rel="stylesheet">
    <title>Register</title>
</head>
<body>
<div class="login-block">
    <div class="app-name">
        <span>Enregistrez-vous!</span>
    </div>
    <form action="./register" method="POST">
        <div class="form-group row">
            <div class="col-md-5">
                <label for="login" class="col-form-label">Identifiant</label>
            </div>
            <div class="col-md-6">
                <input type="text" name="username" id="login" class="form-control" placeholder="Identifiant">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-5">
                <label for="password" class="col-form-label">Mot de passe</label>
            </div>
            <div class="col-md-6">
                <input type="password" name="password" id="password" class="form-control" placeholder="Mot de passe">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-12"><input type="submit" class="btn mb-2 submit" value="S'enregistrer"></div>
        </div>
    </form>
    <c:if test="${error != null}">
        <hr>
        ${error}
    </c:if>
</div>
<div class="login-block">
    <a href="./login">Retour au login</a>
</div>
</body>
</html>