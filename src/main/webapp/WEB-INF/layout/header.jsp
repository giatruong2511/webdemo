<%-- 
    Document   : header
    Created on : Jul 27, 2022, 10:55:15 AM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-sm navbar-info bg-info">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/" />">WebApp Online</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">&#9969; Trang chu</a>
                </li>
                <c:forEach items="${categories}" var="c">
                    <c:url value="/" var="cUrl">
                        <c:param name="cateId" value="${c.id}"></c:param>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item" style="padding-left: 10px">
                    <a class="nav-link" href="<c:url value="/cart" />">
                        <i class="fa fa-shopping-cart"></i>
                        <div class="badge btn-danger" id="cartCounter">${count}</div>
                    </a>
                </li>    
            </ul>
            
            <c:url value="/" var="action" />
            <form method="get" action="${action}" class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhap tu khoa...">
                <button type="submit" class="btn btn-primary" type="button">Tim</button>
            </form>
        </div>
    </div>
</nav>
