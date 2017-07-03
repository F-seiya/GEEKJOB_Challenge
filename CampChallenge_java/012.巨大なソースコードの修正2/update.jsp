<%@page import="java.text.SimpleDateFormat"
        import="jums.UserDataDTO"
        import="jums.JumsHelper" %>

<!--(resultdetail.jsp)で表示した値を保持する処理-->
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData01");
    
    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat day = new SimpleDateFormat("dd");
    
    int y = Integer.parseInt(year.format(udd.getBirthday()));
    int m = Integer.parseInt(month.format(udd.getBirthday()));
    int d = Integer.parseInt(day.format(udd.getBirthday()));
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%=udd.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<%if(i == y){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<%if(i == m){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<%if(i == d){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(udd.getType()==i){out.print("checked");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment()%></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="更新">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
        <br>
        <a href=resultdetail.jsp>戻る<br></a>
   
        <%=jh.home()%>
    </body>
</html>
