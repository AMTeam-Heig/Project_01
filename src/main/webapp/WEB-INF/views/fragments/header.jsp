<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="./assets/css/bootstrap.css" rel="stylesheet">

<nav class="navbar navbar-dark bg-dark" style="position: fixed">
    <a class="navbar-brand">
        <img src="./assets/img/goat-title.png" height="45px" class="navbar-brand"/>
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul>
            <li class="nav-item active"><a class="nav-link" href="./home">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="./profile">Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="./ask">Ask</a></li>
        </ul>
        <c:if test="${currentUser == null}">
            <a class="nav-link" href="./login" align="right">
                <button class="nav-link" type="submit" style="margin: 10px 10px 10px 10px;">
                    Login
                </button>
            </a>
        </c:if>
        <c:if test="${currentUser != null}">
            <form id="logoutForm" method="POST" action="logout.do" align="right">
                <button class="nav-link" type="submit" style="margin: 10px 10px 10px 10px;">
                    Logout
                </button>
            </form>
        </c:if>
    </div>
</nav>