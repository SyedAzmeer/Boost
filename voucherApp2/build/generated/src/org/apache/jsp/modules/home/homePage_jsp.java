package org.apache.jsp.modules.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("    function invoke(btn){\n");
      out.write("        //var email = document.myform.email.value;\n");
      out.write("        //var voucherCode = document.myform.voucherCode.value;\n");
      out.write("        \n");
      out.write("        if(btn == 1){\n");
      out.write("            window.location = '");
      out.print( request.getContextPath());
      out.write("/modules/voucher/voucherDetail.jsp?';\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("         if(btn == 2){\n");
      out.write("           window.location = '");
      out.print( request.getContextPath());
      out.write("/modules/voucher/voucherList.jsp?';\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("</script>\n");

    String email = "";
    
    
    if(request.getParameter("email") != null && request.getParameter("email") != ""){
        email = request.getParameter("email");
    }





      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Welcome to the Voucher Pool App</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form id=\"myform\">\n");
      out.write("            <table border=0 cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"> \n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>\n");
      out.write("                        <h2>Please click button below for voucher transaction </h2>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" id=\"btnSubmit\" name=\"btnSubmit\" onclick=\"invoke(1)\" value=\"Validate voucher\"> \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr></tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" id=\"btnSubmit2\" name=\"btnSubmit2\" onclick=\"invoke(2)\" value=\"Voucher List\"> \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
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
