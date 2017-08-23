/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class BuyComplete extends HttpServlet {

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
            int d_type =Integer.parseInt(request.getParameter("deliverytype"));
            
            HttpSession hs = request.getSession();
            ArrayList<ItemBeans> uc =(ArrayList<ItemBeans>)hs.getAttribute("userCart");
            
            UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
            int userID = ud.getUserID();
            int total = ud.getTotal();
            
            BuyDataDTO bdd = new BuyDataDTO();
            
            for(int i= 0; i<uc.size(); i++){
                total += Integer.parseInt(uc.get(i).getPrice());
                uc.get(i).setDeliveryType(d_type);
                //フォームの値とユーザー情報をBuyDataDTOにマッピング
                uc.get(i).BD2DTOMapping(bdd, userID);
                //DB(buy_t)へデータの挿入
                BuyDataDAO.getInstance().buyinsert(bdd);
            } 
            //DB(user_t)へデータ(総購入金額)の更新
            UserDataDAO.getInstance().updateTotal(total, userID);
            //ユーザー情報に総購入金額データを保存
            ud.setTotal(total);
            
            //購入完了時にユーザーのカート情報を削除
            hs.removeAttribute("userCart");
            
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
            
        }catch(SQLException se){
            System.out.println(se.getMessage());
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
