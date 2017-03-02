<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <p>FORUM</p>
    </blockquote>

    <div class="col-md-12 searchBar">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Nouvel
            article
        </button>
    </div>

    <div class="col-md-12">
        <c:if test="${not empty listForum}">
            <div class="panel-group" id="accordion">
                <c:forEach var="forum" items="${listForum}">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse-${forum.id}">
                                    <c:out value="${forum.titre}"/>
                                </a>

                                <ul class="nav nav-pills badgesForum" role="tablist">
                                    <li role="presentation">Articles <span
                                            class="badge">${fn:length(forum.articles)}</span></li>
                                </ul>
                            </h4>
                        </div>
                        <c:if test="${not empty forum.articles}">
                            <div id="collapse-${forum.id}" class="panel-collapse collapse">
                                <ul class="list-group">
                                    <c:forEach var="article" items="${forum.articles}">
                                        <li class="list-group-item"><a href="article/${article.id}">
                                            <c:out value="${article.sujet}"/>
                                        </a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title col-md-4" id="exampleModalLabel">Nouvel Article</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="usr">Titre de l'article :</label>
                    <input type="text" class="form-control" id="usr">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                <a href="#" class="btn btn-info" role="button">Enregistrer</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
