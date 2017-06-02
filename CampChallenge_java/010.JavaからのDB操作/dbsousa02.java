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
public class dbsousa02 extends HttpServlet {

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
           
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        
         
        try{
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "root");   
            
            db_st = db_con.prepareStatement("insert into profiles values(?,?,?,?,?)");
            //値を設定
            db_st.setInt(1, 6);
            db_st.setString(2,  "藤川誠也");
            db_st.setString(3, "012-171-171");
            db_st.setInt(4, 23);
            db_st.setString(5, "1994/03/20" );
            //MySQLにデータを追加。
            db_st.executeUpdate();
            
            out.print("データを追加");
            
            db_st.close();
            db_con.close();
            
            
        }catch(SQLException e_sql){
            out.print("接続時にエラー発生1" + e_sql.toString());
        }catch(Exception e){
            out.print("接続時にエラー発生2" + e.toString());
        }finally{
            if(db_con != null)
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.print(e_con.getMessage());
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
