<%-- 
    Document   : buycomplete
    Created on : 2017/08/22, 4:48:39
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh =JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>購入完了画面</h1>
        
        <%=jh.top()%>
        
        <% if(ud != null){ %>
            ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

            <form action="Logout" method="POST">
                <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
            </form>
        <% } %>
        
        購入が完了しました。
        
        
    </body>
</html>
