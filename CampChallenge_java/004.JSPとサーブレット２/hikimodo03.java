/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   引数と戻り値3 課題
 * @author seiya
 */
public class hikimodo03 extends HttpServlet {
    
      int[] userdata ={1, 2, 3};
    
    String[]profile(int n){
        
        String[] data1 ={"1", "a", "1991", "東京"};
        String[] data2 ={"2", "b", "1992", null};
        String[] data3 ={"3", "c", "1993", "京都"};
        
       switch(n){
       
           case 1:
               return data1;
               
           case 2:
               return data2;
              
           case 3:
               return data3;
             
           default:
               return null;
       }      
    }
    

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
            
            Integer limit = 2;
            
             //profileメソッド内の配列(data1, data2, data3)を一つずつ取り出す。
           for(int m =1; m<=limit; m++){
               String[] prof = profile(m);
               
               //配列(data1, data2, data3)それぞれの中身(ID, 名前, 年, 出身)を一つずつ取り出す。
                for(int i =0; i<prof.length; i++){
                    
                    //配列の中身がnullの時、continueで飛ばす。
                    if(prof[i]== null){
                     continue;   
                    }
                    out.print(prof[i]+"<br>");
                    
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
