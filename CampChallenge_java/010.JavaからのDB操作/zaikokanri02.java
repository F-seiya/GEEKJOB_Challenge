/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author seiya
 */
public class zaikokanri02 extends HttpServlet {

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
            
            String n = request.getParameter("ユーザーID");
            int p = Integer.parseInt(request.getParameter("パスワード"));            
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                //データベース接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zaikokanri_db","seiya0320","seiya0320");
                //SQL文を実行するため、prepareStatementを取得
                db_st = db_con.prepareStatement("SELECT * FROM user WHERE name = ? AND password = ?");
                
                db_st.setString(1, n);
                db_st.setInt(2, p);
                //SQL文の実行
                db_data = db_st.executeQuery();
                
                //入力したデータと一致すればログイン成功
                if(db_data.next() == true){
                    //セッションの取得
                    HttpSession hs = request.getSession();
                    //型変換
                    String pa = String.valueOf(p);
                    
                    //セッションへ登録
                    hs.setAttribute("username", n);
                    hs.setAttribute("password", pa);
                    //セッションから情報取得
                    String name =(String) hs.getAttribute("ユーザーID");
                    String pass =(String) hs.getAttribute("パスワード");
                    
                    //商品情報登録フォームページに移動
                    RequestDispatcher rd = request.getRequestDispatcher("zaikokanri03.jsp");
                    rd.forward(request, response);
                    
                }else{
                //一致しなければ、失敗
                    System.out.print("ログイン失敗しました。");
                    
                    //元のログインページに戻る。
                    RequestDispatcher rd = request.getRequestDispatcher("zaikokanri01.jsp");
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
