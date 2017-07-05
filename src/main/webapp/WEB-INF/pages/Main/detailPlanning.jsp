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
        <p>DETAIL PLANNING N° ${planning.id}</p>
    </blockquote>

    <c:choose>
        <c:when test="${planning.nb_semaine == 3}">
            <table class="table table-striped detailPlanning">
                <thead>
                <tr>
                    <th>Lundi</th>
                    <th>Mardi</th>
                    <th>Mercredi</th>
                    <th>Jeudi</th>
                    <th>Vendredi</th>
                    <th>Samedi</th>
                    <th>Dimanche</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="1" end="${nbSemaine}">
                    <tr>
                        <td></td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 1}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:out value="${seance.rep_min}"/>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td></td>
                        <td>Footing</td>
                        <td></td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 5}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:choose>
                                            <c:when test="${seance.rep_min > 0}">
                                                <c:out value="${seance.rep_min}"/>
                                            </c:when>
                                            <c:when test="${seance.rep_min == 0}">
                                                <c:out value="${seance.rep_max}"/>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>

                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:when test="${planning.nb_semaine == 5}">
            <table class="table table-striped detailPlanning">
                <thead>
                <tr>
                    <th>Lundi</th>
                    <th>Mardi</th>
                    <th>Mercredi</th>
                    <th>Jeudi</th>
                    <th>Vendredi</th>
                    <th>Samedi</th>
                    <th>Dimanche</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="1" end="${nbSemaine}">
                    <tr>
                        <td></td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 1}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:out value="${seance.rep_min}"/>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>Footing</td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 2}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:out value="${seance.rep_min}"/>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td></td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 5}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:choose>
                                            <c:when test="${seance.rep_min > 0}">
                                                <c:out value="${seance.rep_min}"/>
                                            </c:when>
                                            <c:when test="${seance.rep_min == 0}">
                                                <c:out value="${seance.rep_max}"/>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>Footing long</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:when test="${planning.nb_semaine == 7}">
            <table class="table table-striped detailPlanning">
                <thead>
                <tr>
                    <th>Lundi</th>
                    <th>Mardi</th>
                    <th>Mercredi</th>
                    <th>Jeudi</th>
                    <th>Vendredi</th>
                    <th>Samedi</th>
                    <th>Dimanche</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="1" end="${nbSemaine}">
                    <tr>
                        <td>footing</td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 1}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:out value="${seance.rep_min}"/>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>footing</td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 2}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:out value="${seance.rep_min}"/>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>footing</td>
                        <c:forEach var="seance" items="${listSeance}">
                            <c:if test="${seance.typeSeance.id == 5}">
                                <c:if test="${seance.difficulte == i}">
                                    <td>
                                        <c:out value="${seance.nb_serie}"/>
                                        x
                                        <c:choose>
                                            <c:when test="${seance.rep_min > 0}">
                                                <c:out value="${seance.rep_min}"/>
                                            </c:when>
                                            <c:when test="${seance.rep_min == 0}">
                                                <c:out value="${seance.rep_max}"/>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                        x
                                        <c:out value="${seance.seance}"/>
                                        m à
                                        <c:out value="${seance.pourcentage_vma}"/>
                                        %
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>Footing long</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>


</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${mainJs}"></script>
</body>
</html>
