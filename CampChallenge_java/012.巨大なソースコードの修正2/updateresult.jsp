<%@page import="jums.UserDataBeans"
        import="jums.JumsHelper"%>

<%  //"update.jsp"で更新したデータを表示
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udr = (UserDataBeans) hs.getAttribute("udr");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udr.getName()%><br>
        生年月日:<%= udr.getYear() + "年" + udr.getMonth() + "月" + udr.getDay() + "日"%><br>
        種別:<%= jh.exTypenum(udr.getType())%><br>
        電話番号:<%= udr.getTell()%><br>
        自己紹介:<%= udr.getComment()%><br>
        
        
        以上の内容で登録しました。<br>
    <a href="resultdetail.jsp">詳細画面へ戻る<br></a>
    <%=jh.home()%>
    </body>
</html>
