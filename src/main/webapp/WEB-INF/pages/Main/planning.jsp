<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>HTR</title>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <spring:url value="/resources/js/script.js" var="mainJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="http://bootswatch.com/cerulean/bootstrap.min.css">
</head>
<body xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="nav.jsp"/>

<div class="container">
    <blockquote>
        <p>PLANNING</p>
    </blockquote>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Date de début</th>
            <th>Date de fin</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="planning" items="${listPlanning}">
                <tr>
                    <td>${planning.id}</td>
                    <td><fmt:formatDate type="date" dateStyle="short"
                                        timeStyle="short"
                                        value="${planning.date_debut}"/></td>
                    <td><fmt:formatDate type="date" dateStyle="short"
                                        timeStyle="short"
                                        value="${planning.date_fin}"/></td>
                    <td><a href="planning/${planning.id}">
                        Voir
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
