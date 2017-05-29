<%-- 
    Document   : datasousa04-01
    Created on : 2017/05/29, 16:39:21
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
        
        <%
            request.setCharacterEncoding("UTF-8");
            
            out.print(request.getParameter("商品種別") +"/");
            
            out.print(request.getParameter("one") +"/");
            
            String total = request.getParameter("総額");
           
            int num = Integer.parseInt(total);
            
                if(num>=3000){
                    out.print("今回のポイントは"+ num * 0.04 +"です");
                }else if(num>=5000){
                    out.print("今回のポイントは" + num * 0.05 +"です。");
                }else{
                    out.print("今回は、ポイントはありません。");
                }
           
        
         %>
        
    </body>
</html>

