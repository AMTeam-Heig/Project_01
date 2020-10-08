<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="./assets/css/bootstraps/bootstrap.css" rel="stylesheet">


    <title>User profile</title>
</head>
<nav class="navbar-header">
    <jsp:include flush="true" page="./fragments/header.jsp"/>
</nav>
<body>
<div class="card-group">

    <div class="card" style="padding: 15px; margin: 10px; border-radius: 15px;">
        <h1 align="center">${currentUser.username}</h1>
        <br/><br/>
        <h2>Firstname : </h2>${currentUser.firstname}<br/>
        <h2>Lastname : </h2>${currentUser.lastname}<br/>
        <h2>E-mail : </h2> ${currentUser.email}<br/>
    </div>
</div>

</body>
</html>
