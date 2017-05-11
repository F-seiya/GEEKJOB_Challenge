<%-- 
    Document   : challenge2-3
    Created on : 2017/05/11, 19:47:31
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
   int total = 0;
   
   for(int i = 1; i <= 100; i++){
       
       total += i;
  }
   
    out.print(total);

%>
