<%-- 
    Document   : buyconfirm
    Created on : 2017/08/22, 3:47:07
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh =JumsHelper.getInstance();
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
        <h1>購入確認画面</h1>
        
        <%=jh.top()%><br>
        
        <% if(ud != null){ %>
            ようこそ<a href="Mydata"><%=ud.getName()%>さん</a>

            <form action="Logout" method="POST">
                <input type="submit" name="logoutbtn" value="ログアウト"><br><br>
            </form>
        <% } %>
        
        <% if(hs.getAttribute("userCart")== null && hs.getAttribute("cartArray")==null){%>
        
                カートの中身はございません。
                
        <% }else if(hs.getAttribute("userCart")!= null){ %>
            
            <table border="1">
            
                <th wideth="500">商品名</th>
                <th wideth="200">値段</th>
            
              <% for(ItemBeans ucart: uc){ %>
                <tr>
                    <td><%=ucart.getName()%></td>
                    <td><%=ucart.getPrice()%>円</td>
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
            
           <form action="BuyComplete" method="POST">
                <br><input type="radio" name="deliverytype" value="1"　checked required>配送1
                    <input type="radio" name="deliverytype" value="2">配送2
                    <input type="radio" name="deliverytype" value="3">配送3<br><br>
                
                <input type="submit" name="buycomletebtn" value="上記の内容で購入する"><br><br>
                
           </form>
            
            <a href="Cart" method="GET">カートページに戻る</a>
        
        <% } %>
         
    </body>
</html>
