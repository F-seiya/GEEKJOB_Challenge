<%-- 
    Document   : datasousa01
    Created on : 2017/05/29, 13:35:32
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="datasousa02.jsp" method ="post">
       
            <input type = "text" name = "名前"><br>
            <input type = "radio" name = "性別" value = "男性">男性<br>
            <input type = "radio" name = "性別" value　= "女性">女性<br>
            <textarea name = "趣味"></textarea><br>
       
            <input type = "submit" name = "登録"/><br>
        
       </form> 
    </body>
</html>
