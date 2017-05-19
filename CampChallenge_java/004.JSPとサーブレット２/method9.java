/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author seiya
 */
public class method9 extends HttpServlet {
    
    ArrayList<HashMap> profile(){
            
        HashMap<String, String> data1 = new HashMap<String, String>();
        
        HashMap<String, String> data2 = new HashMap<String, String>();
        
        HashMap<String, String> data3 = new HashMap<String, String>();
        
        data1.put("ID","1"); data1.put("名前", "佐藤");
        data1.put("生年月日","1991/01/01");  data1.put("出身地", null);
        
        data2.put("ID","2"); data2.put("名前","鈴木"); 
        data2.put("生年月日","1992/02/02"); data2.put("出身地","大阪");
        
        data3.put("ID","3"); data3.put("名前","田中"); 
        data3.put("生年月日","1993/03/03"); data3.put("出身地","京都");

        ArrayList<HashMap> prof = new ArrayList<HashMap>();
        
        prof.add(data1);
        prof.add(data2);
        prof.add(data3);
        
        return prof;
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
            
            Integer limit  = 2;
             ArrayList<HashMap> matome = profile();  
             for(int i = 0; i<3; i++){
                 HashMap<String, String> data = matome.get(i);
              if(limit != i){  
                for (Map.Entry<String, String> a: data.entrySet()){
                    if(a.getValue() == null){
                        continue;
                    } 
                    if(a.getKey() != "ID"){
                 
                    out.print(a.getKey() + a.getValue());
                    } 
                
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
