<%-- 
    Document   : updateresult
    Created on : 2017/08/09, 14:43:20
    Author     : seiya
--%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData upd = (UserData)hs.getAttribute("upd");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報-更新結果画面</title>
    </head>
    <body>
        <h1>会員情報-更新結果画面</h1>
        
        ユーザー名:<%=upd.getName()%><br>
        パスワード:<% for(int i = 0; i<upd.getPassword().length(); i++){
                         out.print("*");
                    }
        %><br>
        メールアドレス:<%=upd.getMail()%><br>
        住所:<%=upd.getAddress()%><br>
        
        以上の内容で更新されました。<br><br>
        <%=jh.top()%>
    </body>
</html>
