package jums;

import base.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
            
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
            
        try {
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
           
            
            UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData01");
           
            UserDataBeans udr = new UserDataBeans();
            udr.setName(request.getParameter("name"));
            udr.setYear(request.getParameter("year"));
            udr.setMonth(request.getParameter("month"));
            udr.setDay(request.getParameter("day"));
            udr.setTell(request.getParameter("tell"));
            udr.setType(request.getParameter("type"));
            udr.setComment(request.getParameter("comment"));
            
            hs.setAttribute("udr", udr);
            //udr(更新データ)をuddに格納することによってuddが更新される。
            udr.UD2DTOMapping(udd);
            
        //DBへデータの更新
            UserDataDAO.getInstance().update(udd);

//修正中 update.jsp -> resultdetail.jsp -> searchresult.jspに遷移した時、更新データ(bithdayの表示)おかしい。
    ArrayList<UserDataDTO> uparray = (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
    
        for(int j =0; j <uparray.size(); j++){
            if(uparray.get(j).getUserID() == udd.getUserID()){
               uparray.set(j, udd);
                
            }
        }
           
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            
        } catch(Exception e){
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
