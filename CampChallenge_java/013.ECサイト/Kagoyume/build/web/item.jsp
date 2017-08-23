<%-- 
    Document   : item
    Created on : 2017/08/17, 1:39:54
    Author     : seiya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.ItemBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
    ArrayList<ItemBeans> iArray =(ArrayList<ItemBeans>)hs.getAttribute("searchArray"); 
    ItemBeans ib = new ItemBeans();
    
    for(int i = 0; i<iArray.size(); i++){
        if(hs.getAttribute("code").equals(iArray.get(i).getCode())){
            ib = iArray.get(i);
        }
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>商品詳細ページ</h1>
        
        <%if (ud == null) {%>

        <form action="Login" method="POST">
            <input type="hidden" name="before" value="/item.jsp">
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

        <%=jh.top()%><br><br>
        
        <a href="search.jsp">検索結果ページに戻る</a><br><br>
        
        
            [商品名]<br><%=ib.getName()%><br><br>
            [商品詳細]<br><%=ib.getDescription()%><br><br>
            [値段]<br><%=ib.getPrice()%>円<br><br>
            [平均評価値]<br><%=ib.getReviewAverage()%><br>
            <img src="<%=ib.getImage()%>"><br><br>
           
        <form action="Add" method="GET">
            <input type="hidden" name="itemCode" value="<%=ib.getCode()%>">
            <input type="hidden" name="itemName" value="<%=ib.getName()%>">
            <input type="hidden" name="itemPrice" value="<%=ib.getPrice()%>">
            <input type="hidden" name="itemImage" value="<%=ib.getImage()%>">

            <input type="submit" name="addbtn" value="カートに追加"><br><br>
        </form>
            
    </body>
</html>
