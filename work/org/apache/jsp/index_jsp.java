/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2016-12-22 10:43:37 UTC
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

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	Calendar calendar = Calendar.getInstance();//年月切り替え
	LinkedList expCatList = (LinkedList) session.getAttribute("EXPCatList");
	LinkedList incCatList = (LinkedList) session.getAttribute("INCCatList");
	int year = (Integer) session.getAttribute("year");
	int month = (Integer) session.getAttribute("month");
	int totalEXP = (Integer) session.getAttribute("totalEXP");
	int totalINC = (Integer) session.getAttribute("totalINC");
	int expSCData[][] = (int[][]) session.getAttribute("expSCData");
	int expPieData[] = (int[]) session.getAttribute("expPieData");
	int incPieData[] = (int[]) session.getAttribute("incPieSData");

      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t//積み上げ棒グラフ\r\n");
      out.write("\t\tvar chart = new CanvasJS.Chart(\"EXPstackedColumn\", {\r\n");
      out.write("\t\t\ttitle : {//タイトル\r\n");
      out.write("\t\t\t\ttext : \"日ごとの支出\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\taxisY : {//Y軸\r\n");
      out.write("\t\t\t\tvalueFormatString : \"#0.#,.\",//桁のとり方\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
for (int i = 0; i < expSCData[i].length; i++) {//カテゴリ別
				EXPCat thisEXPCat = (EXPCat) expCatList.get(i);
      out.write("\r\n");
      out.write("\t\t\t\tdata : [ {\r\n");
      out.write("\t\t\t\t\t\ttype : \"stackedColumn\",\r\n");
      out.write("\t\t\t\t\t\t//凡例\r\n");
      out.write("\t\t\t\t\t\tlegendText : \"");
      out.print(thisEXPCat.getCategory());
      out.write("\",\r\n");
      out.write("\t\t\t\t\t\tshowInLegend : \"true\",//その項目をグラフに表示するか(T/F)\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if (i == expSCData[i].length - 1) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tindexLabel : \"#total 円\",//棒の上に表示される数字の単位\r\n");
      out.write("\t\t\t\t\t\t\tyValueFormatString : \"#0.#,.\",//単位のとり方\r\n");
      out.write("\t\t\t\t\t\t\tindexLabelPlacement : \"outside\",//数字はどこに表示させるか\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\tdataPoints : [ {\r\n");
      out.write("\t\t\t\t");
for (int j = 0; j < expSCData.length; j++) {//1-31日
      out.write("\r\n");
      out.write("\t\t\t\t\ty : ");
      out.print(expSCData[i][j]);
      out.write(",\r\n");
      out.write("\t\t\t\t\tlabel : ");
      out.print(month+"/"+(j+1));
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t");
if(j!=expSCData.length-1){
					out.print(",");}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tchart.render();\r\n");
      out.write("*/\r\n");
      out.write("\r\n");
      out.write("\t\tvar chart = new CanvasJS.Chart(\"EXPpieChart\", {\r\n");
      out.write("\t\t\ttheme : \"theme2\",\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : \"Gaming Consoles Sold in 2012\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdata : [ {\r\n");
      out.write("\t\t\t\ttype : \"pie\",\r\n");
      out.write("\t\t\t\tshowInLegend : true,\r\n");
      out.write("\t\t\t\ttoolTipContent : \"{y} - #percent %\",//yValue(単位付き),X％\r\n");
      out.write("\t\t\t\tyValueFormatString : \"#,##0,,.## Million\",\r\n");
      out.write("\t\t\t\tlegendText : \"{indexLabel}\",//凡例のテキスト\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tdataPoints : [\r\n");
      out.write("\t\t\t\t");
for(i=0;i<expPieData.length;i++){
					EXPCat thisEXPXat=(EXPCat)expCatList.get(i);
      out.write("\r\n");
      out.write("\t\t\t\t\t{\t\t\t\t\t\ty : ");
      out.print(expPieData[i]);
      out.write(",\r\n");
      out.write("\t\t\t\t\t\tindexLabel : ");
      out.print(thisEXPCat);
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t");
if(i!=(expPieData.length-1)){
					out.print(",");
					}
					}
      out.write("\r\n");
      out.write("\t\t\t\t},  ]\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tchart.render();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t//ここまで変えた\r\n");
      out.write("\r\n");
      out.write("\t\tvar chart = new CanvasJS.Chart(\"INCpieChart\", {\r\n");
      out.write("\t\t\ttheme : \"theme2\",\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : \"Gaming Consoles Sold in 2012\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdata : [ {\r\n");
      out.write("\t\t\t\ttype : \"pie\",\r\n");
      out.write("\t\t\t\tshowInLegend : true,\r\n");
      out.write("\t\t\t\ttoolTipContent : \"{y} - #percent %\",\r\n");
      out.write("\t\t\t\tyValueFormatString : \"#,##0,,.## Million\",\r\n");
      out.write("\t\t\t\tlegendText : \"{indexLabel}\",\r\n");
      out.write("\t\t\t\tdataPoints : [ {\r\n");
      out.write("\t\t\t\t\ty : 4181563,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"PlayStation 3\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 2175498,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"Wii\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 3125844,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"Xbox 360\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 1176121,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"Nintendo DS\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 1727161,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"PSP\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 4303364,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"Nintendo 3DS\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ty : 1717786,\r\n");
      out.write("\t\t\t\t\tindexLabel : \"PS Vita\"\r\n");
      out.write("\t\t\t\t} ]\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tchart.render();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\t<Div align=\"center\">\r\n");
      out.write("\t\t<h1>概要</h1>\r\n");
      out.write("\t\t<form method=post action=listServlet>\r\n");
      out.write("\t\t\t<input type=submit value=履歴リスト表示へ>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<h2>");
      out.print(year);
      out.write('年');
      out.print(month);
      out.write("月\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t<form action=\"indexServlet\" method=\"post\">\r\n");
      out.write("\t\t\t<label>他の年月を表示:<input type=\"month\" name=\"month\"\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print((calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1)));
      out.write("\"></label>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"送信\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<h3>月の収支</h3>\r\n");
      out.write("\t\t<TABLE align=\"center\">\r\n");
      out.write("\t\t\t<tr width=\"500\">\r\n");
      out.write("\t\t\t\t<td>収入</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td>支出</td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td>のこり</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr style=\"font-size: 250%;\">\r\n");
      out.write("\t\t\t\t<td>");
      out.print(toYen.format(totalINC));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>-</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(toYen.format(totalEXP));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>=</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(toYen.format(totalINC - totalEXP));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</TABLE>\r\n");
      out.write("\t\t<br /> <br />\r\n");
      out.write("\r\n");
      out.write("\t\t<h3>日ごとの支出</h3>\r\n");
      out.write("\t\t<div id=\"EXPstackedColumn\" style=\"height: 300px; width: 100%;\"></div>\r\n");
      out.write("\t\t<br /> <br />\r\n");
      out.write("\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><h3>支出</h3>\r\n");
      out.write("\t\t\t\t\t<div id=\"EXPpieChart\" style=\"height: 300px; width: 100%;\"></div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td><h3>収入</h3>\r\n");
      out.write("\t\t\t\t\t<div id=\"INCpieChart\" style=\"height: 300px; width: 100%;\"></div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br /> <br />\r\n");
      out.write("\r\n");
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
