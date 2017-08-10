/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIpake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author seiya
 */
public class test01 extends HttpServlet {
    
    public static String getResult(String urlString){
        String result = "";

        try {
            //URL接続
            URL url = new URL(urlString);
            //URLにアクセスして結果を得るクラス
            HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
            ucon.connect();
            
            InputStream is = ucon.getInputStream();
            //ファイル読み込み
            InputStreamReader isr = new InputStreamReader(is);

            //ファイル効率良く読み込み
            BufferedReader br = new BufferedReader(isr);

            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                result += tmp;
            }
            br.close();
            ucon.disconnect();

       
       
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return result;
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
        String result ="";
        try (PrintWriter out = response.getWriter()) {
        
        //アプリケーションID
        String id ="dj00aiZpPWx6WmxWTjZPZm52dyZzPWNvbnN1bWVyc2VjcmV0Jng9Yzg-";
        
        String uri ="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid="+id +"&query=時計"
                + "&output=json";
               
        out.print(getResult(uri));
        
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
