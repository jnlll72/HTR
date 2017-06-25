<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <p>GENERATOR</p>
    </blockquote>
    <form:form class="form-horizontal" method="POST" modelAttribute="Planning" action="/JLG/addPlanning">
        <form:errors path="*" cssClass="error" element="div"/>
        <div class="form-group">
            <label class="col-lg-2 control-label">Date de début*</label>
            <div class="col-lg-10">
                <form:input type="date" class="form-control" path="date_debut" placeholder="Date de début"
                            pattern="yyyy-MM-dd"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Date de fin*</label>
            <div class="col-lg-10">
                <form:input type="date" class="form-control" path="date_fin" placeholder="Date de fin"
                            pattern="yyyy-MM-dd"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Séances / semaine*</label>
            <div class="col-lg-10">
                <form:input type="number" class="form-control" path="nb_semaine" placeholder=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 control-label">Type de compétition*</label>
            <div class="col-lg-10">
                <select class="form-control" name="typeCourse_id" id="typeCourse_id">
                    <c:forEach items="${listTypeCourse}" var="type_course">
                        <option value="${type_course.id}">${type_course.intitule}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
                <button type="reset" class="btn btn-default">Cancel</button>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form:form>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
