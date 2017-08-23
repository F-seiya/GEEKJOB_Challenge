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
public class Add extends HttpServlet {

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
            HttpSession hs = request.getSession();
       
            ItemBeans addItem = new ItemBeans();
            addItem.setCode(request.getParameter("itemCode"));
            addItem.setName(request.getParameter("itemName"));
            addItem.setPrice(request.getParameter("itemPrice"));
            addItem.setImage(request.getParameter("itemImage"));
            
            //非ログイン状態でカートの中身がない時
            if(hs.getAttribute("loginData")== null && hs.getAttribute("cartArray")== null){
                //カートのArrayList
                ArrayList<ItemBeans> cartArray = new ArrayList<ItemBeans>();
                //商品情報格納
                cartArray.add(addItem);
                hs.setAttribute("cartArray",cartArray);
 
            //非ログイン状態でカートの中身がある時
            }else if(hs.getAttribute("loginData")== null && hs.getAttribute("cartArray")!= null){
                
                ArrayList<ItemBeans> c_Array =(ArrayList<ItemBeans>)hs.getAttribute("cartArray");
                c_Array.add(addItem);
                //カート情報更新
                hs.setAttribute("cartArray", c_Array);
            }
            
            //ログイン状態でカートの中身がない時
            if(hs.getAttribute("loginData")!= null && hs.getAttribute("userCart")== null){
               //ユーザー用のカート
               ArrayList<ItemBeans> userCart = new ArrayList<ItemBeans>();
               userCart.add(addItem);
               hs.setAttribute("userCart", userCart);
            
            //ログイン状態でカートの中身がある時
            }else if(hs.getAttribute("loginData")!= null && hs.getAttribute("userCart")!= null){
                
                ArrayList<ItemBeans> u_Array =(ArrayList<ItemBeans>)hs.getAttribute("userCart");
                u_Array.add(addItem);
                hs.setAttribute("userCart", u_Array);
            
            }
            
            
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            
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
