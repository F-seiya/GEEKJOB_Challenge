
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
import java.util.*;
/**
 *
 * @author seiya
 */
public class BlackJack extends HttpServlet {

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
            
            Dealer d = new Dealer();
            User u = new User();
            
            //カードを二枚引く
            ArrayList<Integer> d_deal = d.deal();
              //Dealerの手札に加える。
              d.setCard(d_deal);
             //カードを引くかどうかの処理
             while(d.checkSum()){
                d.setCard(d.hit());
             }
            //カードを二枚引く。 もう一度する事でカード情報が更新される。
               d_deal = d.deal();
            // Userの手札に加える。
               u.setCard(d_deal);
            // カードを引くかどうかの処理
             while(u.checkSum()){
                u.setCard(d.hit());
             }
            // それぞれのカードの合計値を出す
            out.print(d.open() +"<br>");
            out.print(u.open() +"<br>");
            
            // 結果画面の表示
            if(d.open() > 21){
                out.print("Dealerがバースト<br>" + "Userの勝ち");
              
                }else if(u.open() > 21){
                  out.print("Userがバースト<br>" + "Dealerの勝ち");
                
                }else if(d.open() == u.open()){
                    out.print("引き分け");
                
                }else if(d.open() > u.open()){
                    out.print("Dealerの勝ち");
                
                }else if(d.open() < u.open()){
                    out.print("Useの勝ち");
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
