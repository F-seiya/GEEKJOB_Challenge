<%-- 
    Document   : myhistory
    Created on : 2017/08/22, 17:46:41
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
    ArrayList<ItemBeans> b_Array =(ArrayList<ItemBeans>)request.getAttribute("historyArray");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>購入履歴閲覧ページ</h1>
        
         <%if (ud == null) {%>

            <form action="Login" method="POST">
                <input type="hidden" name="before" value="/top.jsp">
                <input type="submit" name="loginbtn" value="ログインページ"><br><br>
            </form>

        <% } else {%> 

            ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

            <form action="Logout" method="POST">
                <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
            </form>

            <form action="Cart" method="POST">
                <input type="submit" name="cart" value="カート"><br><br>
            </form>

        <% } %>
        
        <% if(b_Array.size()==0){ %>
            購入履歴はありません。
        <% }else{ %>
        
            <table border="1">
            
                <th wideth="500">商品名</th>
                <th wideth="200">値段</th>
                <th wideth="200">発送方法</th>
                <th wideth="200">購入日時</th>
                <th>商品画像</th>
            
              <% for(ItemBeans ib: b_Array){ %>
                 <tr>
                    <td><%=ib.getName()%></td>
                    <td><%=ib.getPrice()%>円</td>
                    <td><%=ib.getDeliveryType()%></td>
                    <td><%=ib.getBuyDate()%></td>  
                    <td><img src="<%=ib.getImage()%>"></td>
                 </tr>
               <% } %>
            </table>   
        
        <% } %>
       
    </body>
</html>
