<%-- 
    Document   : registrationcomplete
    Created on : 2017/07/19, 15:12:15
    Author     : seiya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserData"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData udr =(UserData)request.getAttribute("udr");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録結果画面</title>
    </head>
    <body>
        <h1>会員登録完了</h1><br>
        ユーザー名:<%= udr.getName()%><br>
        パスワード:<% for(int i = 0; i<udr.getPassword().length(); i++){
                         out.print("*");
                    }
                 %><br>
        
        メールアドレス:<%= udr.getMail()%><br>
        住所:<%= udr.getAddress()%><br>
        
        以上の内容で登録しました。<br><br>
        <h2><%= jh.top()%></h2>
    </body>
</html>

