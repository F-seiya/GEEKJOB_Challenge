/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author seiya
 */
public class dbsousa12 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
           
            request.setCharacterEncoding("UTF-8");

            String n = request.getParameter("名前");
            int a = Integer.parseInt(request.getParameter("年齢"));
            String b = request.getParameter("生年月日");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                //データベース接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "root");
                
                //SQL文を実行するため、 preparedStatementを取得。
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? AND age = ? AND birthday = ?");
                 
                db_st.setString(1, "%"+ n + "%");
                db_st.setInt(2, a);
                db_st.setString(3, b);
                
                //SQL文の実行
                db_data = db_st.executeQuery();

                //データがある間、表示。
                while (db_data.next()) {
                    out.print("ID:" + db_data.getInt("profilesID") + "<br>");
                    out.print("名前:" + db_data.getString("name") + "<br>");
                    out.print("電話番号:" + db_data.getString("tell") + "<br>");
                    out.print("年齢:" + db_data.getInt("age"));
                    out.print("生年月日" + db_data.getDate("birthday") + "<br>");
                }

                db_data.close();
                db_st.close();
                db_con.close();

            } catch (SQLException e_sql) {
                out.print("接続時にエラー発生1" + e_sql.toString());
            } catch (Exception e) {
                out.print("接続時にエラー発生2" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        out.print(e_con.getMessage());
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
