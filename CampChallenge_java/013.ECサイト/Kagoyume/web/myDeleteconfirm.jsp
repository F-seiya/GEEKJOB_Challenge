<%-- 
    Document   : deleteconfirm
    Created on : 2017/08/09, 15:50:43
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報-削除確認画面</title>
    </head>
    <body>
        <h1>会員情報-削除確認画面</h1>
        
        ユーザー名: <%= ud.getName()%><br>
        パスワード:<% for(int i=0; i<ud.getPassword().length(); i++){
                        out.print("*");
                    }
                 %><br>
        メールアドレス:<%= ud.getMail() %><br>
        住所:<%= ud.getAddress() %><br><br>
        
        <h4>上記の内容を削除しますか?</h4><br><br>
        
        <form action="MyDeleteResult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="delete" value="はい"><br>
        </form>
        
        <form action="/top.jsp" method="POST">
            <input type="submit" name="return" value="いいえ"><br>

        </form>
        
    </body>
</html>
