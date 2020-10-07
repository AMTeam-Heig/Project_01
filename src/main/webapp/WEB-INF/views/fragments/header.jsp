<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topnav">
    <a class="navbar-brand"><img src="./style/img/goat-title.png" height="45px"/></a>
    <a class="active" href="./home">Home</a>
    <a href="./profile">Profile</a>
    <a href="./ask">Ask</a>
    <c:if test="${currentUser == null}">
        <a href="./login">Login</a>
    </c:if>
    <c:if test="${currentUser != null}">
        <div align="right">
            <form id="logoutForm" method="POST" action="logout.do">
                <button class="nav-link" type="submit" style="margin: 10px 10px 10px 10px;">
                    Logout
                </button>
            </form>
        </div>
    </c:if>
</div>
