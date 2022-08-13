<%-- 
    Document   : products
    Created on : Jul 27, 2022, 12:03:30 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-danger">QUAN LY SAN PHAM</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if> 

<c:url value="/admin/products" var="action" />
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data"> 
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Ten san pham</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="price" />
        <label for="price">Gia san pham</label>
    </div>
    <div class="form-group">
        <label for="file">Anh san pham</label>
        <form:input type="file" path="file" 
                    class="form-control" id="file" />

    </div>
    <br/>
    <div class="form-floating">
        <form:select path="categoryId" class="form-select" id="cate" name="cate">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="cate" class="form-label">Danh muc san pham</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table">
    <tr>
        <th></th>
        <th>Name</th>
        <th>Price</th>
        <th></th>
    </tr>
    <tbody id="myProduct">

    </tbody>
</table>

<script>
    <c:url value="/api/products" var="u" />
    window.onload = function () {
        getProducts('${u}');
    }
</script>