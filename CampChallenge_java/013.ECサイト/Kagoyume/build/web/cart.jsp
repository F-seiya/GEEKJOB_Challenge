<%-- 
    Document   : cart
    Created on : 2017/08/17, 15:28:42
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    ArrayList<ItemBeans> uc =(ArrayList<ItemBeans>)hs.getAttribute("userCart");
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>カートページ</h1>
        
        <%=jh.top()%><br>
        
        <% if(ud != null){ %>
            ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

            <form action="Logout" method="POST">
                <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
            </form>
        <% } %>
        
        <% if(hs.getAttribute("userCart")== null){ %>
             カートの中身はありません。
        <% }else{ %>
            
            <table border="1">
            
                <th wideth="500">商品名</th>
                <th wideth="200">商品コード</th>
                <th wideth="200">値段</th>
                <th>商品画像</th>
            
              <% for(ItemBeans ucart: uc){ %>
                 <tr>
                    <td><a href="CartDescription?code=<%=ucart.getCode()%>"><%=ucart.getName()%></a></td>
                    <td><%=ucart.getCode()%></td>
                    <td><%=ucart.getPrice()%>円</td>
                    <td><img src="<%=ucart.getImage()%>"></td>
                
                    <td>
                        <form action="DeleteCartItem" method="GET">
                            <input type="submit" name="itemdeletebtn" value="削除">
                            <input type="hidden" name="deleteitemCode" value="<%=ucart.getCode()%>">
                        </form>
                    </td>   
                 </tr>
              <% } %>
            
            </table>
        
        
            <% 
                int total = 0;
                for(ItemBeans iprice: uc){
                    total += Integer.parseInt(iprice.getPrice());
                } 
                out.print("[合計金額]"+ total +"円");
            %>
     
            <%if(total>0){%>
                <form action="BuyConfirm" method="GET">
                <br><br><input type="submit" name="buyconfirmbtn" value="購入ページへ進む">
                </form>
            <% } %>
            
        <% } %>
       
    </body>
</html>
