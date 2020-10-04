<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/stylesheet.css">
    <link href="./assets/css/bootstrap.css" rel="stylesheet">
    <link href="./style/app.css" rel="stylesheet">
    <link href="./style/login.css" rel="stylesheet">

    <title>User profile</title>
</head>

<jsp:include flush="true" page="./fragments/header.jsp"/>

<body>
<div class="card-group">

    <div class="card" style="padding: 5px; margin: 10px; border-radius: 15px;">
        <h1 align="center">DISPLAY USERNAME HERE</h1>
        blarghTest <br/>
        <c:forEach items="${users.users}" var="user">
            ${user.username}
        </c:forEach>
        <br/>
        blourghTest
        <br/><br/>
        <b>Firstname : </b> ${user.firstname}<br/>
        <b>Lastname : </b> ${user.lastname}<br/>
        <b>E-mail : </b> ${user.email}<br/>
    </div>
</div>

</body>
</html>
