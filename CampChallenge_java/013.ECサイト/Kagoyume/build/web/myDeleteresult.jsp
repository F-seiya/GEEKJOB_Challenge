<%-- 
    Document   : deleteresult
    Created on : 2017/08/09, 16:23:29
    Author     : seiya
--%>

<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO dud =(UserDataDTO)request.getAttribute("loginData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報-削除完了画面</title>
    </head>
    <body>
        <h1>会員情報-削除完了画面</h1>
        ユーザー名:<%=dud.getName()%><br>
        パスワード:<% for(int i = 0; i<dud.getPassword().length(); i++){
                         out.print("*");
                    }
                 %><br>
        メールアドレス:<%=dud.getMail()%><br>
        住所:<%=dud.getAddress()%><br>
        
        <h5>以上の会員情報を削除しました。</h5>
        
        <%=jh.top()%>
    </body>
</html>
