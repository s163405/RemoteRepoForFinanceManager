/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2016-12-20 13:19:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.EXPCatManager;
import DBSample.*;
import java.util.*;

public final class expensesUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("DataBase.EXPCatManager");
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
      response.setContentType("text/html;   charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<HTML lang=\"ja\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<META CHARSET=\"UTF-8\">\r\n");
      out.write("\r\n");

	Expenses exp = (Expenses) session.getAttribute("exp");
	LinkedList EXPCatList = (LinkedList) session.getAttribute("EXPCatList");

      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("ul li {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("\tmargin-right: 10px;\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\twidth: 500px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("\twidth: 180px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("select {\r\n");
      out.write("\twidth: 180px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input#button {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<h1>支出情報更新</h1>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t\t<p>更新する情報を入力してください。</p>\r\n");
      out.write("\t\t<FORM METHOD=\"POST\" ACTION=\"confirmExpensesUpdateServlet\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"date\"><label>日付</label> <input id=\"date\" type=\"date\"\r\n");
      out.write("\t\t\t\t\tname=\"date\"\r\n");
      out.write("\t\t\t\t\tvalue=");
      out.print((exp.getYear() + "-" + String.format("%02d", exp.getMonth()) + "-"
					+ String.format("%02d", exp.getDay())));
      out.write(">\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"category\"><label>カテゴリ</label> <select\r\n");
      out.write("\t\t\t\t\tname=\"category\">\r\n");
      out.write("\t\t\t\t\t\t");

							for (int i = 0; i < EXPCatList.size(); i++) {
								EXPCat expCat = (EXPCat) EXPCatList.get(i);
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(expCat.getRid());
      out.write('"');
      out.write('>');
      out.print(expCat.getCategory());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t</select></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"amount\"><label>金額</label> <input type=\"number\"\r\n");
      out.write("\t\t\t\t\tname=\"amount\" value=");
      out.print(exp.getAmount());
      out.write("></li>\r\n");
      out.write("\t\t\t\t<li class=\"place\"><label>場所</label> <INPUT TYPE=\"TEXT\"\r\n");
      out.write("\t\t\t\t\tNAME=\"place\" VALUE=\"");
      out.print(exp.getPlace());
      out.write("\" />\r\n");
      out.write("\t\t\t\t<li class=\"memo\"><label>メモ</label> <INPUT TYPE=\"TEXT\"\r\n");
      out.write("\t\t\t\t\tNAME=\"memo\" VALUE=\"");
      out.print(exp.getMemo());
      out.write("\" /></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li><INPUT TYPE=\"SUBMIT\" VALUE=\"アイテムの修正\" /></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</FORM>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
      out.write("\r\n");
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
