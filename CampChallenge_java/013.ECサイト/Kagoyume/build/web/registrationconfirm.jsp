<%-- 
    Document   : registrationconfirm
    Created on : 2017/07/19, 15:10:19
    Author     : seiya
--%>
<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.UserData"%>

<%
    JumsHelper  jh = JumsHelper.getInstance();
    
    HttpSession hs = request.getSession();
    UserData ud =(UserData)hs.getAttribute("ud");
    
    ArrayList<String> chkarray = ud.chkbeans();
    

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録確認画面</title>
    </head>
    <body>
        <% if (chkarray.size() == 0) {%>
        <h1>登録確認</h1>

        ユーザー名:<%= ud.getName()%><br>
        パスワード:<% for (int i = 0; i < ud.getPassword().length(); i++) {
                        out.print("*");
                    }
                 %><br>
        メールアドレス:<%= ud.getMail()%><br>
        住所:<%= ud.getAddress()%><br><br>

        上記の内容で登録致します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else {%>
        <h1>入力が不完全です。</h1>
        <%=jh.check(chkarray)%>
        <% }%>      
        <form action="Registration" method="POST">
            <input type="submit" name="no" value="戻る">
            <!--            戻る際に入力フォームの値を保持する値があるか、判断する為にパラメーターを送る処理-->
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        <%=jh.top()%>
    </body>
</html>
