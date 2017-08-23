<%-- 
    Document   : add
    Created on : 2017/08/17, 3:17:57
    Author     : seiya
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート追加確認処理</title>
    </head>
    <body>
        
        <%if (ud == null) {%>

        <form action="Login" method="POST">
            <input type="hidden" name="before" value="/add.jsp">
            <input type="submit" name="loginbtn" value="ログインページ">
        </form>

        <% } else {%> 

        ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

        <form action="Logout" method="POST">
            <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
        </form>

        <form action="Cart" method="POST">
            <input type="submit" name="cart" value="カート"><br><br>
        </form>

        <% }%>
        
        <%=jh.top()%><br><br>
        
        <a href="item.jsp">商品詳細ページに戻る</a>
        
        <h3>カートに商品を追加しました。</h3><br>
            
        <form action="Cart" method="POST">
            <input type="hidden" name="before" value="Cart">
            <input type="submit" name="cartbtn" value="カートページへ">
        </form>

    </body>
</html>
