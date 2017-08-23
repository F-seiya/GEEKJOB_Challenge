<%-- 
    Document   : login
    Created on : 2017/07/19, 15:13:59
    Author     : seiya
--%>

<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //引数が"false"の時、nullが返ってくる。
    HttpSession hs =request.getSession(false);

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーログインページ</title>
    </head>
    <body>
        <%if(hs.getAttribute("login")!= null){%>
            <p>ログイン失敗しました</p>
            <p>再度入力お願いします。</p>
        <%}%>
       
       <form action="LoginCheck" method="POST">
       ユーザー名:<input type="name" name="ユーザー名" value=""><br>
       パスワード:<input type="password" name="パスワード" value=""><br><br>
                <input type="submit" name="login" value="ログイン"><br><br>
       </form>
        
       <form action="Registration" method="GET">
            <input type="submit" name="Registration" value="新規会員登録"><br><br>
       </form>
        
       <%= jh.top()%>
    </body>
</html>
