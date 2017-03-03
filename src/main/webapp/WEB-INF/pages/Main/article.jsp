<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns:form="http://www.w3.org/1999/html">
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
        <p>ARTICLE - #${article.id}</p>
    </blockquote>

    <div class="col-md-12 searchBar">
        <c:if test="${not empty sessionScope.User}">
            <button type="button" class="btn btn-primary addNewMessage" data-toggle="modal" data-target="#newMessage"
                    data-article-id="${article.id}">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Nouveau message
            </button>
        </c:if>
        <c:if test="${empty sessionScope.User}">
            <a href="/JLG/login" class="btn btn-primary" role="button">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Nouveau message
            </a>
        </c:if>
    </div>

    <div class="col-md-12">
        <c:forEach var="message" items="${article.messages}" varStatus="i">
            <div class="message">
                <div class="header-message">
                    <span>${message.user.nom} ${message.user.prenom} - <fmt:formatDate type="both" dateStyle="short"
                                                                                       timeStyle="short"
                                                                                       value="${message.created}"/></span>
                    <span class="indexLoop">#${i.index + 1}</span>
                </div>
                <div class="body-message">
                    <p>${message.contenu}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="newMessage" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title col-md-4" id="forum">Nouveau Message</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form method="POST" modelAttribute="Message" action="/JLG/addMessage">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="contenu">Contenu :</label>
                        <input type="hidden" class="form-control" name="article_id" id="article_id"/>
                        <form:textarea class="form-control areaContenu" path="contenu" maxlength="255" rows="3"
                                       id="contenu"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
