<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gradumake</title>
    <link href="<c:url value="/scripts/css/results.css" />" rel="stylesheet">
</head>
<body>

<div> <h1>Gradumake</h1>
    <h2>Goodbye Ramen, Hello Quinoa</h2>
    <br>
    <h3>Gradumake is empowering recent graduates and young professionals to cook healthy, quick, and easy meals for
        themselves. Join the foodolution.
    </h3>
    <br>

    <c:if test="${isRecipeListEmpty}">
        <div id="recipes_not_found">
            <form action="/" method="get">
            <h3>
                Sorry, no recipes were found with those ingredients. Please try again.
            </h3>
            <button id="try_again" type="submit">Try Again</button>
            </form>
        </div>
    </c:if>

    <div id="recipe_list">
        <c:forEach var="recipe" items="${recipeList}" varStatus="row">
            <div class="col">
                <img src="${recipe.imageUrl}"/><br>
                <a href="${recipe.url}">${recipe.title}</a><br>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

