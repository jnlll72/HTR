<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>JLG</title>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <spring:url value="/resources/js/script.js" var="mainJs" />
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="http://bootswatch.com/bower_components/bootstrap/dist/css/bootstrap.min.css">
</head>
<body xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="nav.jsp"/>

<div class="container">
    <div class="jumbotron">
        <h4 class="lead">BIENVENUE</h4>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
