<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="../../css/stylesheet.css">
    <title>Welcome to StackOverGoat</title>
</head>
<html>
    <header>

        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#">Profile</a>
            <a href="#">Ask</a>
            <a href="#">Login</a>
            <div class="search-container">
                <form action="/action_page.php">
                    <input type="text" placeholder="Search..." name="search">
                    <button type="submit">Search</button>
                </form>
            </div>
        </div>
    </header>
    <body>
    <br />
    <center><h1>- StackOverGoat -</h1></center>

        <h2>Let the chickens era begins !</h2>
        <p>"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."</p>


    <h2> All questions </h2>
    1 - ${requestScope.questions.get(0).title}<br/>
    2 - ${requestScope.questions.get(1).title}<br/>

    </body>
</html>