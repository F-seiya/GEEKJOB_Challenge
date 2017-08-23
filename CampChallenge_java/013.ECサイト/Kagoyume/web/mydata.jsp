<%-- 
    Document   : mydata
    Created on : 2017/08/08, 16:38:29
    Author     : seiya
--%>
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
        <title>会員情報 - 閲覧画面</title>
    </head>
    <body>
        <h1>会員情報 - 閲覧画面</h1>
        
        ユーザー名:<%= ud.getName()%><br>
        パスワード:<% for(int i = 0; i<ud.getPassword().length(); i++){
                         out.print("*");
                    }
                 %><br>
        メールアドレス:<%= ud.getMail()%><br>
        住所: <%= ud.getAddress()%><br>
        
        <a href="MyHistory">購入履歴へ</a>
        
        <form action="MyUpdateConfirm" method="POST">
            <input type="submit" name="update" value="会員情報更新">
        </form>
        
        <form action="MyDeleteConfirm" method="POST">
            <input type="submit" name="delete" value="会員情報削除">
        </form>
        
        <%=jh.top()%>
    </body>
</html>
