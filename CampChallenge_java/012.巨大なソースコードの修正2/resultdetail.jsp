<%@page import="java.text.SimpleDateFormat"
        import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs =request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData01");
    //生年月日の表示を設定 マッピング(.getTime())によってデータの内容が変わる為。
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= sdf.format(udd.getBirthday())%><br>
        種別:<%=jh.exTypenum(udd.getType())%>
        <br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
         <input type="submit" name="update" value="変更"style="width:100px">
         <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
        
        <form action="Delete" method="POST">
         <input type="submit" name="delete" value="削除"style="width:100px">
         <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
        <a href=searchresult.jsp>戻る<br></a>
       
      <%=jh.home()%>
    </body>

</html>
