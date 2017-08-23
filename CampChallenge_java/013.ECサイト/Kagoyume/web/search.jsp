<%-- 
    Document   : search
    Created on : 2017/08/16, 12:14:35
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.ItemBeans"%>
<%@page import="java.util.ArrayList"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
    ArrayList<ItemBeans> sArray = (ArrayList<ItemBeans>)hs.getAttribute("searchArray");
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>検索結果一覧</h1>
        
        <%if (ud == null) {%>

        <form action="Login" method="POST">
            <input type="hidden" name="before" value="/search.jsp">
            <input type="submit" name="loginbtn" value="ログインページ">
        </form>

        <% } else {%> 

        ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

        <form action="Logout" method="POST">
            <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
        </form>

        <form action="Cart" method="POST">
            <input type="submit" name="cart" value="カート"><br><br>
        </form>

        <% }%>

        <%=jh.top()%>
        
        検索ワード:<%=hs.getAttribute("word")%><br> 
        
        検索結果数:<%=sArray.get(sArray.size()-1).getTotalResultsAvailable()%><br>
        
        <% if(sArray.size()!= 0){ %>
        
            <% for(ItemBeans ib: sArray){ %>
                <table> 
                    <td><a href="Item?code=<%=ib.getCode()%>"><%=ib.getName()%></a></td>
                    <td><%=ib.getPrice()%>円</td>
                    <td><img src="<%=ib.getImage()%>"></td>
                </table>
            <% } %>
           
        
        <% }else{ %>
            検索結果に該当するものがございませんでした。
        
        <% } %>
               
    </body>
</html>
