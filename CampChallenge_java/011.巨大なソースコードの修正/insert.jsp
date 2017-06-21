
<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
   HttpSession hs = request.getSession();
//   修正課題:5
//insertconfirmで保存したudbセッションのインスタンスを取得
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
     //初期値を設定
      String n = "";
      int y = 0;
      int m = 0;
      int d = 0;
      String t ="";
      String te ="";
      String c ="";
      
    
    //何も入力せずに登録確認画面に行くと、udbにnullがセットされ、nullを数値に変えようとしてエラーが出る為、
    //初期値(未入力)を保持する処理
    
    //以前入力された値があると、保持するため  
    //udbセッションの有無を確認し、セッションがあれば値を取得。(それぞれの値は確認していない。)
    if(udb != null){
          //udbの値を取得 
            n = udb.getName();
        //udb内の値を確認し、値が空でなければ、取得する。(年、月、日、職種)
        if(!udb.getYear().equals("")){ 
            y = Integer.parseInt(udb.getYear());  
        }
        if(!udb.getMonth().equals("")){ 
            m = Integer.parseInt(udb.getMonth());
        }
        if(!udb.getDay().equals("")){
            d = Integer.parseInt(udb.getDay());
        }
        if(udb.getType() != null){
            t = udb.getType();
        }
            te = udb.getTell();
            c = udb.getComment();
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:                                <!--修正課題:5-->
        <input type="text" name="name" value="<%= n %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
                                    <!--修正課題:5-->
            <option value="<%=i%>"<%if(i == y){out.print("selected");} %>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %> 
                                    <!--修正課題:5-->
            <option value="<%=i%>"<%if(i == m){out.print("selected");} %>> <%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %> 
                                    <!--修正課題:5-->
            <option value="<%=i%>"<%if(i == d){out.print("selected");} %>> <%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>                                        <!--修正課題:5-->
        <input type="radio" name="type" value="1"<%if(t.equals("1")){out.print("checked");}%>>エンジニア<br>
        <input type="radio" name="type" value="2"<%if(t.equals("2")){out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3"<%if(t.equals("3")){out.print("checked");}%>>その他<br>
        <br>

        電話番号:                             <!--修正課題:5-->
        <input type="text" name="tell" value="<%= te %>">
        <br><br>

        自己紹介文
        <br>                                                                    <!--修正課題:5-->
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= c %></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
