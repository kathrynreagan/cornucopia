<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gradumake</title>
    <link href="<c:url value="/scripts/css/base.css" />" rel="stylesheet">
</head>
<body>
    <div id="recipe_list">
        <c:forEach var="recipe" items="${recipeList}" varStatus="row">
            <img src="${recipe.imageUrl}"/>
            <a href="${recipe.url}">${recipe.title}</a><br>
        </c:forEach>
    </div>
</body>
</html>