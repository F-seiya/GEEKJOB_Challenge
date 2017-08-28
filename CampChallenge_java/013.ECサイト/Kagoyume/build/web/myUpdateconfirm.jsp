<%-- 
    Document   : updateconfirm
    Created on : 2017/08/09, 13:26:51
    Author     : seiya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報-更新画面</title>
    </head>
    <body>
        <h1>会員情報-更新画面</h1>
        <form action="MyUpdateResult" method="POST">
        
            ユーザー名:<input type="name" name="ユーザー名" value="<%= ud.getName() %>" required><br><br>
            
            パスワード:<input type="password" name="パスワード" value="<%= ud.getPassword() %>" required><br><br>
            
            メールアドレス:<input type="text" name="メールアドレス" value="<%= ud.getMail() %>" required><br><br>
         
            住所:<input type="text" name="住所" value="<%= ud.getAddress() %>" required><br><br>
            
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="更新" value="更新"><br><br>
            
        </from> 
        
        <a href=mydata.jsp>戻る<br></a>
        
        <%=jh.top()%>
    </body>
</html>
