/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author seiya
 */
public class zaikokanri05 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                //データベース接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zaikokanri_db","seiya0320","seiya0320");
               
                //SQL文を実行するため、 preparedStatementを取得。
                db_st = db_con.prepareStatement("SELECT * FROM item;");
                //SQL文実行
                db_data = db_st.executeQuery();
               //セッションの取得 
              // HttpSession hs2 = request.getSession();
               //型変換「
//               String j = String.valueOf(id);
//               String w = String.valueOf(va);
//               //セッションへ
//               hs2.setAttribute("商品ID", j);
//               hs2.setAttribute("商品名", na);
//               hs2.setAttribute("値段", va);
               

                //カラムの情報を取得して表示
                while(db_data.next()){
                    out.print("商品ID:" + db_data.getInt("itemID") +"<br>");
                    out.print("商品名:" + db_data.getString("name") +"<br>");
                    out.print("商品ID:" + db_data.getInt("value") +"<br>");
                
                }
                out.print("<a href=zaikokanri03.jsp>戻る</a>");
                
                
                db_data.close();
                db_st.close();
                db_con.close();
        
        
            }catch(SQLException e_sql){
                out.println("接続時にエラー発生1:" + e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラー発生2" + e.toString());
            }finally {
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        out.println(e_con.getMessage());
                    }
                }
            
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
