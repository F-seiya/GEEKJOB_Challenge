<%-- 
    Document   : cartDescription
    Created on : 2017/08/17, 22:01:58
    Author     : seiya
--%>

<%@page import="jums.JumsHelper"%>
<%@page import="jums.ItemBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ItemBeans ibd =(ItemBeans)request.getAttribute("ibd");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>カート商品詳細ページ</h1>
        <%=jh.top()%>    <a href="Cart">カートページへ戻る</a><br><br>
        
        [商品名]<br><%=ibd.getName()%><br><br>
        [商品詳細]<br><%=ibd.getDescription()%><br><br>
        [値段]<br><%=ibd.getPrice()%>円<br><br>
        [平均評価値]<br><%=ibd.getReviewAverage()%><br><br>
        
         <img src="<%=ibd.getImage()%>"><br><br>
         
    </body>
</html>
