<%--
  Created by IntelliJ IDEA.
  User: Elodie
  Date: 25.09.2020
  Time: 08:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="./style/app.css" rel="stylesheet">
    <link href="./style/login.css" rel="stylesheet">
    <title>
        Ask questions !
    </title>
</head>
<body>
<h2> All questions </h2>
1 - ${requestScope.questions.get(0).title}<br/>
2 - ${requestScope.questions.get(1).title}<br/>
</body>
</html>
