<%-- 
    Document   : datasousa05-01
    Created on : 2017/05/29, 20:22:31
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
            
            out.print("元の値は"+request.getParameter("整数")+"<br>");
            String sr = request.getParameter("整数");
            
            int n = Integer.parseInt(sr);
            
                
 
            for(int i = 2; i<n; i++){
                while((n%i)==0){
                    out.print( i +"<br>");
                    n/=i;
                }
            }out.print("余った値は"+ n);
                
           
            
             
                
            
        %>
        
        
    </body>
</html>
