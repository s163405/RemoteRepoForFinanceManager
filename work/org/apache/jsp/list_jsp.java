/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2016-12-19 10:17:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DBSample.*;
import java.util.*;
import java.text.NumberFormat;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("DBSample");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.NumberFormat");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");

	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
	LinkedList EXPList = (LinkedList) session.getAttribute("EXPList");
	LinkedList INCList = (LinkedList) session.getAttribute("INCList");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./css/style.css\" type=\"text/css\"\r\n");
      out.write("\tmedia=\"print, projection, screen\" />\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.js\"\r\n");
      out.write("\tintegrity=\"sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"./js/jquery.tablesorter.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#EXPTable\").tablesorter({\r\n");
      out.write("\t\t\theaders : {\r\n");
      out.write("\t\t\t\t4 : {\r\n");
      out.write("\t\t\t\t\tsorter : false\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#INCTable\").tablesorter({\r\n");
      out.write("\t\t\theaders : {\r\n");
      out.write("\t\t\t\t3 : {\r\n");
      out.write("\t\t\t\t\tsorter : false\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\t<Div align=\"center\">\r\n");
      out.write("\t\t<h1>履歴リスト</h1>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<h2>2016年12月</h2>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<h3>○支出</h3>\r\n");
      out.write("\t\t<TABLE id=\"EXPTable\" class=\"tablesorter\">\r\n");
      out.write("\t\t\t<thread>\r\n");
      out.write("\t\t\t<tr bgcolor=\"#c6d9f1\" align=\"center\">\r\n");
      out.write("\t\t\t\t<th>日付</th>\r\n");
      out.write("\t\t\t\t<th>カテゴリ</th>\r\n");
      out.write("\t\t\t\t<th>金額</th>\r\n");
      out.write("\t\t\t\t<th>場所</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</thread>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < EXPList.size(); i++) {
						Expenses exp = (Expenses) EXPList.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#fcd5b5\">\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(exp.getYear() + "/" + exp.getMonth() + "/" + exp.getDay());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(exp.getCategory().getCategory());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(toYen.format(exp.getAmount()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(exp.getPlace());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td><form method=post action=detailsServlet>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=hidden name=type value=EXP> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=hidden name=RID value=");
      out.print(exp.getRid());
      out.write("> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=submit value=詳細>\r\n");
      out.write("\t\t\t\t\t\t</form></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</TABLE>\r\n");
      out.write("\t\t<form method=post action=insertInput.jsp>\r\n");
      out.write("\t\t\t<input type=submit value=支出を新規入力する>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<br /> <br />\r\n");
      out.write("\t\t<h3>○収入</h3>\r\n");
      out.write("\t\t<TABLE id=\"INCTable\" class=\"tablesorter\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#c6d9f1\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<th>日付</th>\r\n");
      out.write("\t\t\t\t\t<th>カテゴリ</th>\r\n");
      out.write("\t\t\t\t\t<th>金額</th>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < INCList.size(); i++) {
						Income inc = (Income) INCList.get(i);
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#fcd5b5\">\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(inc.getYear() + "/" + inc.getMonth() + "/" + inc.getDay());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(inc.getCategory().getCategory());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(toYen.format(inc.getAmount()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td><form method=post action=detailsServlet>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=hidden name=type value=INC> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=hidden name=RID value=");
      out.print(inc.getRid());
      out.write("> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=submit value=詳細>\r\n");
      out.write("\t\t\t\t\t\t</form></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</TABLE>\r\n");
      out.write("\t\t<form method=post action=insertInput.jsp>\r\n");
      out.write("\t\t\t<input type=submit value=収入を新規入力する>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t</Div>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
