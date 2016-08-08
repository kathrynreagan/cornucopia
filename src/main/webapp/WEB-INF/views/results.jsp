<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gradumake</title>
    <link href="<c:url value="/scripts/css/results.css" />" rel="stylesheet">
</head>
<body>

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
</body>
</html>

<%--<c:if test="${isItemOutOfStock}">--%>
    <%--<div id="out-of-stock" class="add-to-cart-failure page-action">--%>
        <%--Sorry, that item is temporarily out of stock. Please check back later!--%>
    <%--</div>--%>
<%--</c:if>--%>

