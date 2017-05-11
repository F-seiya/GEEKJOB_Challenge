<%-- 
    Document   : challenge1-10
    Created on : 2017/05/11, 16:49:14
    Author     : seiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>

<%
    HashMap<String, String> data = new HashMap<String, String>();
          
              data.put("1","AAA");
              data.put("hello", "world");
              data.put("soeda", "33");
              data.put("20", "20");
              
              out.print(data.get("20"));     //(" ")に値を入力
          
%>
