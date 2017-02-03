<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default" xmlns:c="http://www.w3.org/1999/html">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="home">Home</a></li>
            <li><a href="#">Forum</a></li>
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
                        <li><a href="#">Action</a></li>
                        <li class="divider"></li>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
