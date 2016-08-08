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
            ${recipe.title}<br>
        </c:forEach>
    </div>
</body>
</html>


<%--<div>--%>
    <%--<table id="home-table">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th></th>--%>
            <%--<th>Name</th>--%>
            <%--<th>Price</th>--%>
            <%--<th>Description</th>--%>
            <%--<th>Type</th>--%>
            <%--<th></th>--%>

        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach var="item" items="${items}" varStatus="row">--%>
            <%--<tr>--%>
                <%--<td style="width: 12%"><img width="100%" height="same-as-width" src="<c:out value="${item.imageURL}"/>"/></td>--%>
                <%--<td style="width: 22%;"><c:out value="${item.name}"/></td>--%>
                <%--<td style="width: 10%;"><c:out value="£${item.price}"/></td>--%>
                <%--<td style="width: 33%;"><c:out value="${item.description}"/></td>--%>
                <%--<td style="width: 10%;"><c:out value="${item.type}"/></td>--%>
                <%--<td style="width: 8%;">--%>
                    <%--<form:form action="/" method="post" modelAttribute="item">--%>
                        <%--<form:hidden path="itemId" value="${item.itemId}"/>--%>
                        <%--<input title="Add to cart" alt="Add to cart" style="width:100%;" type="image" name="submit" value="submit" src="../../images/add-to-cart.png" class="reserve-button add-to-cart" id="add_item${item.name}" type="submit">--%>
                    <%--</form:form>--%>
                <%--</td>--%>

            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
<%--</div>--%>
