<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar" xmlns:c="http://www.w3.org/1999/html">
    <div class="container">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/JLG/">Home</a></li>
                <li><a href="forum">Forum</a></li>
                <li><a href="#">Generator</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty sessionScope.User}">
                    <li><a href="signup">Sign up</a></li>
                    <li><a href="login">Log in</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.User}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Bonjour
                            <c:out value="${sessionScope.User.prenom}"/>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="account">Mon compte</a></li>
                            <li class="divider"></li>
                            <li><a href="logout">Déconnexion</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
