<%-- 
    Document   : stats
    Created on : Aug 9, 2022, 10:00:58 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">THONG KE BAO CAO</h1>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Ten danh muc</th>
                <th>So san pham</th>
            </tr>
            <c:forEach items="${catStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChart"></canvas>
    </div>
</div>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Ma San Pham</th>
                <th>Ten San Pham</th>
                <th>Doanh Thu</th>
            </tr>
            <c:forEach items="${revenueStats}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td>${r[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChart2"></canvas>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
        let labels2 = [];
    <c:forEach items="${catStats}" var="c">
        data.push(${c[2]});
        labels.push('${c[1]}');
    </c:forEach>
        
    <c:forEach items="${revenueStats}" var="r">
        data2.push(${r[2]});
        labels2.push('${r[1]}');
    </c:forEach>
        
        cateStats(labels, data);
        
        revenueStats(labels2, data2)
       
    }
</script>
