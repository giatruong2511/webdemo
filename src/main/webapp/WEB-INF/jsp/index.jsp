<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="<spring:url value="/css/style.css" />">

<br />
<h1 class="text-center text-info">DANH SACH SAN PHAM</h1>
<br />
<c:if test="${products.size() == 0}">
    <p>
        <em>KHONG co san pham nao!!!</em>
    </p>
</c:if>

<div class="row">
    <c:forEach items="${products}" var="p">
        <div class="col-md-4 col-xs-12" style="padding: 5px;">
            <div class="card">
                <a href="<c:url value="/products/${p.id}" />">
                    <img class="card-img-top" src="${p.image}" alt="${p.name}">
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <fmt:formatNumber value="${p.price}" type="number" maxFractionDigits = "3" /> VND
                    <p />
                    <div>
                        <a href="<c:url value="/products/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
                        
                        <a href="<c:url value="#" />" class="btn btn-danger" onclick="addToCart(${p.id} , '${p.name}', '${p.image}', ${p.price})">Dat hang</a>
                    </div>
                    
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div >
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(counter/pageSize)}" var="page">
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${page}">${page}</a></li>
            </c:forEach>

    </ul>
</div>
<div class="alert alert-success">
    <strong>DANH SACH SAN PHAM NOI BAT</strong>
</div>
<div class="row">
    <c:forEach items="${hotProducts}" var="p">
        <div class="col-md-3 col-xs-12" style="padding: 5px;">
            <div class="card">
                <a href="<c:url value="/products/${p[0]}" />">
                    <img class="card-img-top" class="img-fluid" src="${p[3]}" alt="Card image">
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p[1]}</h4>
                    <fmt:formatNumber value="${p[2]}" type="number" maxFractionDigits = "3" /> VND
                    <p />

                </div>
            </div>
        </div>
    </c:forEach>
</div>