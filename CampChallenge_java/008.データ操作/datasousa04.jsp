<%-- 
    Document   : datasousa04
    Created on : 2017/05/29, 15:48:33
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
        <form action ="datasousa04-01.jsp" method ="post">
            
            <input type ="radio" name = "商品種別" value = "雑貨">雑貨<br>
            <input type ="radio" name = "商品種別" value ="生鮮食品">生鮮食品<br>
            <input type ="radio" name = "商品種別" value ="その他">その他<br>
            
            総額<input type ="number" name ="総額" value ="0" >
            個数<input type ="number" name ="個数" value ="0" >
           
            一個あたりの値段<input name="one" </input>
            <input type ="button" onclick="one.value =
                           Number(総額.value)/Number(個数.value);"value="計算">
           
            
            <input type = "submit" name = "送信" ><br>
            
        
        
        </form>
    </body>
</html>
