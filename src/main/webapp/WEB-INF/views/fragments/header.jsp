<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="topnav">
        <a class="navbar-brand"><img src="./style/img/goat-title.png" height="45px"/></a>
        <a class="active" href="./home">Home</a>
        <a href="./profile">Profile</a>
        <a href="./ask">Ask</a>
        <c:if test="${currentUser == null}">
            <a href="./login">Login</a>
        </c:if>
        <c:if test="${currentUser != null}">
            <form id="logoutForm" method="POST" action="logout.do">
                <button type="submit">Logout</button>
            </form>
        </c:if>

        <div class="search-container">
            <form action="/action_page.php">
                <input type="text" placeholder="Search..." name="search">
                <button type="submit">Search</button>
            </form>
        </div>
    </div>
</header>
