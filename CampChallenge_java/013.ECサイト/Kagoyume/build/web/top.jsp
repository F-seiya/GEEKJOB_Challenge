<%-- 
    Document   : top
    Created on : 2017/07/19, 16:11:38
    Author     : seiya
--%>

<%@page import="jums.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
    //検索ワード情報が入っているセッション
    if(hs.getAttribute("word")!=null){
        hs.removeAttribute("word");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップ</title>
    </head>
    <body>
        <h1>Kagoyume</h1>
        <% if(request.getAttribute("word") == null){ %>
             Kagoyumeは、買い物気分が味わえる仮想空間です。<br>
        <% }else if(request.getAttribute("word").equals("No")){ %>
            Kagoyumeは、買い物気分が味わえる仮想空間です。<br><br>
            検索ワードの入力をお願いします。
        <% } %>
        
        <%if (ud == null) {%>

            <form action="Login" method="POST">
                <input type="hidden" name="before" value="/top.jsp">
                <input type="submit" name="loginbtn" value="ログインページ"><br><br>
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
     
        
            <form action="Search" method="GET">
                <input type="text" name="searchword" size="30">
                <input type="submit" name="sbmbtn" value="検索">
            </form>
        
        
    </body>
</html>
