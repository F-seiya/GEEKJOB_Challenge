<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> udar =  (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
    
    //updateresult.jsp -> resultdetail.jsp経由で戻ってきた時の更新データの表示を整える為。
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <% //ArrayListにデータがある場合、ある分だけ表示
           if(udar.size()!=0){%> 
        <table border=1>
            
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
          <% for(UserDataDTO udd : udar){ %>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>&ac=<%=hs.getAttribute("ac")%>"><%= udd.getName()%></a></td>
                <td><%= sdf.format(udd.getBirthday())%></td>
                <td><%=jh.exTypenum(udd.getType())%></td>
                <td><%= udd.getNewDate() %></td>
               <% } %>
            </tr>
       <% } %>
        </table>
        
        <% //ArrayListにデータがない時の処理(一致するデータ無しの時)
            if(udar.size()==0){
                out.print("該当するデータはありません."+"<br>");
            }
        %>
         <%=jh.home()%>
         
    </body>
</html>
