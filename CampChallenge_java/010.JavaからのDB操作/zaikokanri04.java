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
import javax.servlet.RequestDispatcher;
/**
 *
 * @author seiya
 */
public class zaikokanri04 extends HttpServlet {
    
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
            
            int id = Integer.parseInt(request.getParameter("商品ID"));
            String na = request.getParameter("商品名");
            int va = Integer.parseInt(request.getParameter("値段"));
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                //データベース接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zaikokanri_db","root","root");
                //SQL文を実行するため、prepareStatementを取得
                db_st = db_con.prepareStatement("INSERT INTO item(itemID, name, value) VALUES(?, ?, ?)");
                
                db_st.setInt(1, id);
                db_st.setString(2, na);
                db_st.setInt(3, va);
                
               
                //もし一行追加されたなら
                if(db_st.executeUpdate() == 1){
                    System.out.print("商品を登録しました");
                    //商品情報登録フォームページに移動
                    RequestDispatcher rd = request.getRequestDispatcher("zaikokanri03.jsp");
                    rd.forward(request, response);
                }else{
                    System.out.print("商品が登録されませんでした。");
                     //商品情報登録フォームページに移動
                    RequestDispatcher rd = request.getRequestDispatcher("zaikokanri03.jsp");
                    rd.forward(request, response);

                }
                
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
