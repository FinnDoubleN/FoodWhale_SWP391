package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <!-- Basic -->\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <!-- Mobile Metas -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1\">\r\n");
      out.write("        <!-- Site Metas -->\r\n");
      out.write("        <title>Register Page</title>\r\n");
      out.write("        <meta name=\"keywords\" content=\"\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("        <!-- Site Icons -->\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/fevicon.ico.png\" type=\"image/x-icon\" />\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <!-- Site CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("        <!-- Colors CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/colors.css\">\r\n");
      out.write("        <!-- ALL VERSION CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/versions.css\">\r\n");
      out.write("        <!-- Responsive CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("        <!-- Custom CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("        <!-- Modernizer for Portfolio -->\r\n");
      out.write("        <script src=\"js/modernizer.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"./img/logo_web.png\" type=\"image/x-icon\">\r\n");
      out.write("        <script type=\"module\" src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js\"></script>\r\n");
      out.write("        <script nomodule src=\"https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\r\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/service.css\">\r\n");
      out.write("        <!-- [if lt IE 9] -->\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/register.css\">      \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("        <div class=\"main-w3layouts wrapper\" >\r\n");
      out.write("            <h1>Register Form</h1>\r\n");
      out.write("            <div class=\"main-agileinfo\">\r\n");
      out.write("                <div class=\"agileits-top\">\r\n");
      out.write("                    <form action=\"register\" method=\"post\">\r\n");
      out.write("                        <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                        <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                        \r\n");
      out.write("                        <input class=\"text\" type=\"text\" name=\"username\" placeholder=\"Username\" required=\"\">\r\n");
      out.write("                        <input id=\"pass\" class=\"text\" type=\"password\" name=\"password\" minlength=\"8\" placeholder=\"Password\" required=\"\">\r\n");
      out.write("                        <img onclick=\"myFunction1()\" src=\"img/eye2.jpg\" width=\"30\" height=\"30\">\r\n");
      out.write("                        <input id=\"pass1\"  type=\"password\" name=\"confirm\" minlength=\"8\" placeholder=\"Confirm Password\" required=\"\">\r\n");
      out.write("                        <img onclick=\"myFunction2()\" src=\"img/eye2.jpg\" width=\"30\" height=\"30\">\r\n");
      out.write("                        <div class=\"enter\">\r\n");
      out.write("                            <h2 style=\"color: white\">Gender :</h2>\r\n");
      out.write("                            <div style=\"color: white\" class=\"p-t-10\">\r\n");
      out.write("                                <label class=\"radio-container m-r-45\">Male\r\n");
      out.write("                                    <input type=\"radio\" name=\"gender\" value=\"1\">\r\n");
      out.write("                                    <span class=\"checkmark\"></span>\r\n");
      out.write("                                </label>\r\n");
      out.write("                                <label class=\"radio-container\">Female\r\n");
      out.write("                                    <input type=\"radio\" name=\"gender\" value=\"0\">\r\n");
      out.write("                                    <span class=\"checkmark\"></span>\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input class=\"text \" type=\"email\" name=\"email\" placeholder=\"Email\" required=\"\">\r\n");
      out.write("                        <input class=\"text\" type=\"text\" name=\"phonenumber\" placeholder=\"Phone Number\" required=\"\">\r\n");
      out.write("                        <h2 style=\"color: white\">Date of birth :</h2>\r\n");
      out.write("                        <input class=\"text\" type=\"date\" name=\"age\" placeholder=\"Date of birth\" required=\"\">\r\n");
      out.write("                        <input class=\"text\" type=\"text\" name=\"image\" placeholder=\"Image\" required=\"\">\r\n");
      out.write("                        <input class=\"text\" type=\"text\" name=\"address\" placeholder=\"Address\" required=\"\">\r\n");
      out.write("                        <div class=\"wthree-text\">\r\n");
      out.write("                            <label class=\"anim\">\r\n");
      out.write("                                <input type=\"checkbox\" class=\"checkbox\" required=\"\">\r\n");
      out.write("                                <span>I Agree To The Terms & Conditions</span>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <div class=\"clear\"> </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"submit\" value=\"SIGN UP\">\r\n");
      out.write("                        <a href=\"\">ALREADY HAVE AN ACCOUNT? SIGN IN</a>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"#home\" data-scroll class=\"dmtop global-radius\"><i class=\"fa fa-angle-up\"></i></a>\r\n");
      out.write("        <!-- all js files -->\r\n");
      out.write("        <script src=\"js/all.js\"></script>\r\n");
      out.write("        <!-- all plugins -->\r\n");
      out.write("        <script src=\"js/custom.js\"></script>\r\n");
      out.write("        <!-- map -->\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCNUPWkb4Cjd7Wxo-T4uoUldFjoiUA1fJc&callback=myMap\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://unpkg.com/swiper/swiper-bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"https://unpkg.com/scrollreveal\"></script>\r\n");
      out.write("        <script src=\"./js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("                            var x = true;\r\n");
      out.write("                            function myFunction1() {\r\n");
      out.write("                                if (x) {\r\n");
      out.write("                                    document.getElementById('pass').type = \"text\";\r\n");
      out.write("                                    x = false;\r\n");
      out.write("                                } else {\r\n");
      out.write("                                    document.getElementById('pass').type = \"password\";\r\n");
      out.write("                                    x = true;\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("        </script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var x = true;\r\n");
      out.write("            function myFunction2() {\r\n");
      out.write("                if (x) {\r\n");
      out.write("                    document.getElementById('pass1').type = \"text\";\r\n");
      out.write("                    x = false;\r\n");
      out.write("                } else {\r\n");
      out.write("                    document.getElementById('pass1').type = \"password\";\r\n");
      out.write("                    x = true;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
