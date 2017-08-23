<%-- 
    Document   : registration
    Created on : 2017/07/19, 14:51:47
    Author     : seiya
--%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //registrationconfirmから戻ってきた際に入力済みの値を保持する処理。
    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode")!= null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録 入力フォーム</title>
    </head>
    <body>
        <h1>新規会員登録</h1>
         <form action="RegistrationConfirm" method="POST">
            ユーザー名:<input type="name" name="ユーザー名" value="<% if(reinput){out.print(ud.getName());}%>"><br><br>
            
            パスワード:<input type="password" name="パスワード" value="<% if(reinput){out.print(ud.getPassword());}%>" ><br><br>
            
            メールアドレス:<input type="text" name="メールアドレス" value="<% if(reinput){out.print(ud.getMail());}%>" ><br><br>
         
            住所:<input type="text" name="住所" value="<% if(reinput){out.print(ud.getAddress());}%>" ><br><br>
            
            <input type="submit" name="登録" value="登録"><br><br>
            
            <%= jh.top()%>
        </form>
    </body>
</html>
