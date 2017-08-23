/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.jasper.JasperException;

/**
 *
 * @author seiya
 */
public class LoginCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.jasper.JasperException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,JasperException{
         response.setContentType("text/html;charset=UTF-8");
         
            final String top ="/top.jsp";
            final String search ="/search.jsp";
            final String item ="/item.jsp";
            final String add ="/add.jsp";
            final String cart ="Cart";
           
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //"UserData"に入力された値を格納
            UserData udl = new UserData();
            udl.setName(request.getParameter("ユーザー名"));
            udl.setPassword(request.getParameter("パスワード"));
            
            //DTOオブジェクトにマッピング。 DB専用のパラメーターに変換.
            UserDataDTO udL = new UserDataDTO();
            udl.UD2DTOMapping(udL);
            
            //DBへデータの参照(search)
            UserDataDTO loginData = UserDataDAO.getInstance().loginsearch(udL);
            
            String page =(hs.getAttribute("beforepage")).toString();
            
            
            //直前のページに戻るための処理
            if(page.equals(top) && loginData!= null){
                
                hs.setAttribute("loginData", loginData);
                request.getRequestDispatcher(top).forward(request, response);
                hs.removeAttribute("beforepage");
               
            }else if(page.equals(search) && loginData!= null){
                
                hs.setAttribute("loginData", loginData);
                request.getRequestDispatcher(search).forward(request, response);
                hs.removeAttribute("beforepage");
                
            }else if(page.equals(item) && loginData!= null){
                
                hs.setAttribute("loginData", loginData);
                request.getRequestDispatcher(item).forward(request, response);
                 hs.removeAttribute("beforepage");
                
            }else if(page.equals(add) && loginData!= null){
                
                hs.setAttribute("loginData", loginData);
                request.getRequestDispatcher(add).forward(request, response);
                hs.removeAttribute("beforepage");
                 
            }else if(page.equals(cart) && loginData!= null){
                
                hs.setAttribute("loginData", loginData);
                request.getRequestDispatcher(cart).forward(request, response);
                hs.removeAttribute("beforepage");
                
            }else{
                hs.setAttribute("login", "No");
                request.getRequestDispatcher("/Login").forward(request, response);
            }
            
            
        } catch (Exception e){
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
