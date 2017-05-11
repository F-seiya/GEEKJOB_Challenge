<%-- 
    Document   : challenge2-1
    Created on : 2017/05/11, 17:37:21
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    long num = 1;
   
    for(int i = 1; i<=20; i++){
        
        num *= 8;
    }
    out.print(num);

%>
