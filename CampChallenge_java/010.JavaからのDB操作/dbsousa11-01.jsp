<%-- 
    Document   : dbsousa11-01
    Created on : 2017/06/04, 19:15:53
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
        データ更新フォーム
        <form action ="dbsousa11" method ="post">
            
            ID<br><input type ="number" name ="ID"><br>
               
            名前:<br><input type ="name" name ="名前"><br>
            電話番号:<br><input type ="text" name ="電話番号"><br>
            年齢:<br><input type ="number" name ="年齢"><br>
            生年月日:<br><input type ="text" name ="生年月日"><br>
            
            <input type ="submit" name ="送信"><br>
            
    </body>
</html>
