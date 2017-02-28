<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTR</title>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="http://bootswatch.com/cerulean/bootstrap.min.css">
</head>
<body xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="nav.jsp"/>

<div class="container">
    <form:form class="form-horizontal" method="POST" modelAttribute="User" action="/JLG/updateUser">
        <fieldset>
            <legend>Mon Compte</legend>
            <form:errors path="*" cssClass="error" element="div"/>
            <div class="form-group">
                <label class="col-lg-2 control-label">Nom*</label>
                <div class="col-lg-10">
                    <form:input class="form-control" path="nom" placeholder="Nom"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Prenom*</label>
                <div class="col-lg-10">
                    <form:input class="form-control" path="prenom" placeholder="Prenom"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Date de naissance*</label>
                <div class="col-lg-10">
                    <form:input type="date" class="form-control" path="date" placeholder="Date de naissance" pattern="yyyy-MM-dd"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Ville*</label>
                <div class="col-lg-10">
                    <form:input class="form-control" path="ville" placeholder="Ville"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Email*</label>
                <div class="col-lg-10">
                    <form:input class="form-control" path="email" placeholder="Email"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Mot de passe*</label>
                <div class="col-lg-10">
                    <form:password class="form-control" path="pwd" placeholder="Password"/>
                </div>
            </div>
            <hr/>
            <div class="form-group">
                <label class="col-lg-2 control-label">VMA*</label>
                <div class="col-lg-5">
                    <!--<form:input type="range" min="10" max="25" step="0.1" class="form-control" path="VMA" placeholder="VMA" value="${sessionScope.User.VMA}"/>-->
                    <form:input type="number" step="0.1" class="form-control" path="VMA" placeholder="VMA"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-default">Cancel</button>
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </div>
        </fieldset>
    </form:form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
