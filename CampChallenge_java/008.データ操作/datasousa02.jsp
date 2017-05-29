<%-- 
    Document   : datasousa02
    Created on : 2017/05/29, 14:11:41
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
        
    <%    
        request.setCharacterEncoding("UTF-8");
    
        out.print(request.getParameter("名前"));
        
        out.print(request.getParameter("性別"));
        
        out.print(request.getParameter("趣味"));
        
    %>   
    </body>
</html>


    




