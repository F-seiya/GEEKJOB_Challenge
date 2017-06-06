<%-- 
    Document   : zaikokanri03
    Created on : 2017/06/06, 15:31:39
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="zaikokanri04" method="post">
            <h1>商品情報登録フォーム</h1>
            
            商品ID:<br><input type ="number" name ="商品ID" required><br>
            商品名:<br><input type ="text" name ="商品名" required><br>
            値段:<br><input type ="number" name ="値段" required><br>
            
            <input type ="submit" value ="登録"> 
        </form>
       
        <form action="zaikokanri05" method="post">
            
            <input type="submit" value="商品一覧">
        
        </form>
        
        <form action ="zaikokanri06" method="post">
            
            <input type ="submit" value="ログアウト">
                
        </form>
    </body>
</html>
