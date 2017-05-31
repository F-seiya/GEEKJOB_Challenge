<%-- 
    Document   : test
    Created on : 2017/05/31, 12:01:14
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
        <form action ="datasousa08" method ="post">
            
            ・名前<input type ="text" name ="名前"><br>
            
            <input type ="radio" name ="性別" value ="男性">男性<br>
            <input type ="radio" name ="性別" value ="女性">女性<br>
            
            ・趣味<br><textarea name ="趣味"></textarea><br>
            
            <input type ="submit" name ="登録"><br>
    </body>
</html>
