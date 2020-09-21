<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Welcome to StackOverGoat</title>
    </head>
    <body>
    <h1>Welcome to StackOverGoat <3</h1>

    <h2> All questions </h2>
    <script type="text/javascript">
        // get a HTMLCollection of elements in the page
        let collection = ${requestScope.questions};

        // using for/of iteration
        for (item of collection) {
            console.log(item);
        }
    </script>

    </body>
</html>