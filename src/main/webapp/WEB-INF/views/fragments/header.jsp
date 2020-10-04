<%--
  Created by IntelliJ IDEA.
  User: clari
  Date: 29.09.2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="topnav">
        <a class="navbar-brand"><img src="./style/img/goat-title.png" height="50px"/></a>
        <a class="active" href="/Project_01">Home</a>
        <a href="/Project_01/profile">Profile</a>
        <a href="/Project_01/ask">Ask</a>
        <c:if test="${username != null}">
            <a href="/Project_01/login">Login</a>
        </c:if>
        <c:if test="${username == null}">
            <a href="#">Logout</a>
        </c:if>

        <div class="search-container">
            <form action="/action_page.php">
                <input type="text" placeholder="Search..." name="search">
                <button type="submit">Search</button>
            </form>
        </div>
    </div>
</header>
