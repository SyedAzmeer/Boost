package org.apache.jsp.modules.voucher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.myapp.home.homeJB;
import com.myapp.action.homeAction;
import com.myapp.process.voucherProcess;
import java.util.ArrayList;

public final class voucherDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private ArrayList voucherList = new ArrayList();
    
    private int countVoucherList = 0;
    



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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write('\n');

    homeAction ha = new homeAction();
    voucherProcess pro = new voucherProcess();
    homeJB jb = null;
    
    String email = "";
    String voucherCode = "";
    if(request.getParameter("email") != null && request.getParameter("email") != ""){
        email = request.getParameter("email");
    }
    if(request.getParameter("voucherCode") != null && request.getParameter("voucherCode") != ""){
        voucherCode = request.getParameter("voucherCode");
    }
    
    if ((email != null && !email.equals("")) && (voucherCode != null && !voucherCode.equals(""))) {
        if (!pro.checkVoucherDetail(email,voucherCode)) {
            System.out.println("Failed to display detail");
        }else{
            if(pro.getObjhJB() != null){
                jb = pro.getObjhJB();
            }
        }
    }
    
    
    

      out.write("\n");
      out.write("<script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("    function invoke(btn){\n");
      out.write("        if(btn == 1){\n");
      out.write("            var email = document.myform.txtemail.value;\n");
      out.write("            var voucherCode = document.myform.txtvoucherCode.value;\n");
      out.write("            \n");
      out.write("            if(email != null && email != \"\"){\n");
      out.write("                alert(\"Please enter email\");\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("            if(voucherCode != null && voucherCode != \"\"){\n");
      out.write("                alert(\"Please enter voucher code\");\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("            window.location = '");
      out.print( request.getContextPath());
      out.write("/modules/voucher/voucherDetail.jsp?email='+email+'&voucherCode='+voucherCode;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        if(btn == 2){\n");
      out.write("            var answer = confirm(\"Do you want to redeem this voucher code?\");\n");
      out.write("            if(answer){\n");
      out.write("                document.myform.action = '");
      out.print( request.getContextPath() );
      out.write("/modules/home/home.do?action=redeemVoucher&email=");
      out.print( email);
      out.write("&voucherCode=");
      out.print( voucherCode );
      out.write("';\n");
      out.write("                document.myform.submit();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Voucher Detail</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form id=\"myform\" name=\"myform\" method=\"post\">\n");
      out.write("           <table>\n");
      out.write("               <tr>\n");
      out.write("                   <td>\n");
      out.write("                       <label>Email: <b></b></label>\n");
      out.write("                   </td>\n");
      out.write("                    <td>\n");
      out.write("                       <input type=\"text\" id=\"txtemail\" name=\"txtemail\" value=\"\">\n");
      out.write("                   </td>\n");
      out.write("               </tr>\n");
      out.write("               <tr>\n");
      out.write("                   <td>\n");
      out.write("                       <label>Voucher Code: <b></b></label>\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       <input type=\"text\" id=\"txtvoucherCode\" name=\"txtvoucherCode\" value=\"\">\n");
      out.write("                   </td>\n");
      out.write("               </tr>\n");
      out.write("               <tr>\n");
      out.write("                   <td>\n");
      out.write("                       <input type=\"button\" id=\"btnSubmit\" name=\"btnSubmit\" onclick=\"invoke(1)\" value=\"Submit\">\n");
      out.write("                   </td>\n");
      out.write("               </tr>\n");
      out.write("           </table>\n");
      out.write("            ");

             if(jb != null){
            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email:");
      out.print( email);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td>Voucher Code:");
      out.print( voucherCode );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Percentage Discount:</td>\n");
      out.write("                    <td>");
      out.print( jb.getOfferDiscountRate() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("<!--                <tr>\n");
      out.write("                    <td>Date of Usage:</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>-->\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" id=\"btnRedeem\" name=\"btnRedeem\" onclick=\"invoke(2)\" value=\"Redeem\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            ");

                       }
            
      out.write("\n");
      out.write("           \n");
      out.write("       </form>\n");
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
