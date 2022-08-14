<%-- 
    Document   : cart
    Created on : Aug 8, 2022, 10:02:11 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-info">GIO HANG</h1>

<c:if test="${cart == null}">
    <div class="alert alert-danger">
        Khong co san pham nao trong gio!!!
    </div>
</c:if>

<c:if test="${cart != null}">
    <table class="table">
        <tr>
            <th>Ma san pham</th>
            <th>Anh san pham</th>
            <th>Ten san pham</th>
            <th>Don gia</th>
            <th>So luong</th>
            <th></th>
        </tr>
        <c:forEach items="${cart.values()}" var="c">
            <tr>
                <td>${c.id}</td>
                <td><img src="${c.image}" alt="${c.name}" style="width: 100px"></td>
                <td>${c.name}</td>
                <td>${c.price}</td>
                <td>
                    <div class="form-group">
                        <input type="number" 
                               onblur="updateCart(${c.id}, this)"
                               value="${c.quantity}" 
                               class="form-control" />
                    </div>
                </td>
                <td>
                    <input type="button" 
                           onclick="deleteCart(${c.id})"
                           value="Xoa" 
                           class="btn btn-danger" />
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="alert alert-info">
        
        <h5>Tong tien: <span id="amountId">${countCart.amount}</span> VND</h5>
    </div>
    <input type="button" value="Thanh toan" class="btn btn-info" />
    <br/>
</c:if>