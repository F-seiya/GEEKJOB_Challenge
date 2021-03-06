/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author seiya
 */
public class MyUpdateResult extends HttpServlet {

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
        
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

            UserDataDTO ud = (UserDataDTO)hs.getAttribute("loginData");
                    
            UserData upd = new UserData();
            upd.setName(request.getParameter("ユーザー名"));
            upd.setPassword(request.getParameter("パスワード"));
            upd.setMail(request.getParameter("メールアドレス"));
            upd.setAddress(request.getParameter("住所"));
            
            hs.setAttribute("upd", upd);
            //upd(更新データ)をudに格納することによってudが更新される。
            upd.UD2DTOMapping(ud);
            
           //DBへデータ更新
           UserDataDAO.getInstance().update(ud);
           
           request.getRequestDispatcher("/myUpdateresult.jsp").forward(request, response);
           
           hs.removeAttribute(accesschk);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch(Exception e){
            System.out.println(e.getMessage());
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
