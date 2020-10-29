<%--
  Created by IntelliJ IDEA.
  User: Walid
  Date: 23.10.2020
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="./assets/css/bootstraps/bootstrap.css" rel="stylesheet">

    <title>Statistics</title>
</head>
<body>

<jsp:include flush="true" page="./fragments/header.jsp"/>

<div class="card-group">
    <div class="card" style="padding: 5px; margin: 10px; border-radius: 15px;">


        <div style="text-align: center;"><h2>Here some numbers</h2></div>

                <h2>Number of questions  : </h2>${stats.nbQuestion}<br/>
                <h2>Number of users  : </h2>${stats.nbUser}<br/>
    </div>
</div>


</body>
</html>
