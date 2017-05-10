<%-- 
    Document   : challenge1-6
    Created on : 2017/05/10, 11:46:37
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   int num = 3;
    
    switch (num){
        case 1:
               out.print("one");
               break;
               
        case 2:
               out.print("two");
               break;
               
        default:
               out.print("想定外");
               break;

}
%>