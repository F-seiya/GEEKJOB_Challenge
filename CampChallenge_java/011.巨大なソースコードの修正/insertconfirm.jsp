<%@page import="javax.servlet.http.HttpSession" %>
 <!--修正課題:1-->
<%@page import="jums.JumsHelper" %>
<!--修正課題:3-->
<%@page import="jums.UserDataBeans" %>

<%
    HttpSession hs = request.getSession();
//    修正課題:3
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("UDB");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
<!--修正課題:3 -->
<!--修正課題:4-->
<% if(!udb.getName().equals("") && !udb.getYear().equals("") && !udb.getMonth().equals("") &&
      !udb.getDay().equals("") && !udb.getType().equals("") && !udb.getTell().equals("")
      && !udb.getComment().equals("")){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
             <!--修正課題:2-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
<!--修正課題:4-->
        <% if(udb.getName().equals("")){ 
            out.print("名前の入力が不完全です <br>");
           } %>
           
        <% if(udb.getYear().equals("")){
            out.print("年の値の入力が不完全です <br>");
           }%>
           
        <% if(udb.getMonth().equals("")){
            out.print("月の入力が不完全です <br>");
           }%>
           
        <% if(udb.getDay().equals("")){
            out.print("日の入力が不完全です <br>");
           }%>
        
        <% if(udb.getTell().equals("")){
            out.print("電話番号の入力が不完全です <br>");
           }%>
           
        <% if(udb.getComment().equals("")){
            out.print("自己紹介文の入力が不完全です <br>");
           }%>
        
        
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
         <!--修正課題:1-->
         
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
