package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    UserDataDTO ud =(UserDataDTO)hs.getAttribute("loginData");
    
    //検索ワード情報が入っているセッション
    if(hs.getAttribute("word")!=null){
        hs.removeAttribute("word");
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>トップ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Kagoyume</h1>\n");
      out.write("        ");
 if(request.getAttribute("word") == null){ 
      out.write("\n");
      out.write("             Kagoyumeは、買い物気分が味わえる仮想空間です。<br>\n");
      out.write("        ");
 }else if(request.getAttribute("word").equals("No")){ 
      out.write("\n");
      out.write("            Kagoyumeは、買い物気分が味わえる仮想空間です。<br><br>\n");
      out.write("            検索ワードの入力をお願いします。\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if (ud == null) {
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"Login\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" name=\"before\" value=\"/top.jsp\">\n");
      out.write("                <input type=\"submit\" name=\"loginbtn\" value=\"ログインページ\"><br><br>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        ");
 } else {
      out.write(" \n");
      out.write("\n");
      out.write("            ようこそ<a href=\"Mydata\">");
      out.print(ud.getName());
      out.write("さん</a>\n");
      out.write("\n");
      out.write("            <form action=\"Logout\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" name=\"logoutbtn\" value=\"ログアウト\"><br><br>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <form action=\"Cart\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" name=\"cart\" value=\"カート\"><br><br>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("     \n");
      out.write("        \n");
      out.write("            <form action=\"Search\" method=\"GET\">\n");
      out.write("                <input type=\"text\" name=\"searchword\" size=\"30\">\n");
      out.write("                <input type=\"submit\" name=\"sbmbtn\" value=\"検索\">\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
