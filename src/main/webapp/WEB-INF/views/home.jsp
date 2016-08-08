<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gradumake</title>
    <link href="<c:url value="/scripts/css/base.css" />" rel="stylesheet">
</head>
<body>
    <div>


        <h1>Gradumake</h1>
        <h2>Goodbye Ramen, Hello Quinoa</h2>
        <br>
        <h3>Gradumake is empowering recent graduates and young professionals to cook healthy, quick, and easy meals for
            themselves. Join the foodolution.
        </h3>
        <br>

        <form action="/results" method="post">

            <input type="text" id="ingredients_input" placeholder="bacon, lettuce, tomato" name="ingredients">

            <button type="submit" id="ingredients_submit" name="submitIngredients-btn" value="Submit" formaction="/results" formmethod="post">
                Submit
            </button>

        </form>

    </div>
</body>
</html>
