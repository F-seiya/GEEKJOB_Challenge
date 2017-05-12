<%-- 
    Document   : challenge2-4
    Created on : 2017/05/12, 10:45:08
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
   int num1 = 1000;
   int count = 0;
   
   while (num1 < 100 == false) {
        
          num1 = num1 / 2; 
          
          count++;
          
  }
     out.print(num1 + "<br>"); 
     out.print(count + "回ループしました。");
     
%>

