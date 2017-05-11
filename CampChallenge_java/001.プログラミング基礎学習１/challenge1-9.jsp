<%-- 
    Document   : challenge1-9
    Created on : 2017/05/11, 11:58:20
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>

<%
   ArrayList<String> data = new ArrayList<String>();
   
         data.add("10");
         data.add("100");
         data.add("soeda");
         data.add("hayashi");
         data.add("-20");
         data.add("118");
         data.add("END");
         
        data.set(2, "33");
        
        out.print(data.get(2));
         
%>
