/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author seiya
 */
public class Cart extends HttpServlet {

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
            
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
            
            String cartp =request.getParameter("before"); 
            
            //ログイン状態でカートの中身がある時
            if(hs.getAttribute("loginData")!= null && hs.getAttribute("cartArray")!= null){
                //ユーザー専用のカートに移す
                ArrayList<ItemBeans> userCart =(ArrayList<ItemBeans>)hs.getAttribute("cartArray");
                
                hs.setAttribute("userCart", userCart);
                //非ログイン状態のカート情報を削除
                hs.removeAttribute("cartArray");
           
            //ログイン状態でカートで中身がない時
            }else if(hs.getAttribute("loginData")!= null && hs.getAttribute("cartArray")== null){
                
            //非ログイン状態
            }else{
                //ログイン成功時に"LoginCheck.java"にてカートページに遷移する為にパラメーターをセッション格納
                hs.setAttribute("beforepage", cartp);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
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
