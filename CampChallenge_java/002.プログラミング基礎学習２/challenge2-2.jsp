<%-- 
    Document   : challenge2-2
    Created on : 2017/05/11, 19:13:08
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String text = "A";
    
    for(int i = 1; i < 30; i++){
        text = text + "A";
    
    }
    
    out.print(text);
    

%>
