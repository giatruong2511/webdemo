<%-- 
    Document   : product-detail
    Created on : Jul 30, 2022, 5:57:08 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">CHI TIET SAN PHAM</h1>
<div class="row">
    <div class="col-md-4 col-xs-6">
        <img src="${product.image}" class="img-fluid" />
    </div>
    <div class="col-md-8 col-xs-6">
        <h1>${product.name}</h1>
        <p>${product.description}</p>
        <h3>${product.price} VND</h3>
        <div>
            <input type="button" value="Them vao gio" class="btn btn-danger" />
        </div>
    </div>
</div>
<br />
<div>
    <div class="form-group">
        <textarea class="form-control" id="content" 
                  placeholder="Nhap noi dung binh luan"></textarea>
    </div>
    <br />
    <div>
        <input type="button" 
               onclick=""
               value="Them binh luan" 
               class="btn btn-info" />
    </div>

</div>