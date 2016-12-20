<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<HTML>
<HEAD>

<%
	Income inc = (Income) session.getAttribute("inc");
	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
%>
</HEAD>
<BODY>
	<div align="center">
		<h1>収入の詳細情報</h1>
		<hr>
		<table border="1" bordercolor="black">
			<tr>
				<td bgcolor="#92d050" align="center" width=80>日付</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=inc.getYear() + "/" + String.format("%02d", inc.getMonth()) + "/" + String.format("%02d", inc.getDay())%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>カテゴリ</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=inc.getCategory().getCategory()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>金額</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=toYen.format(inc.getAmount())%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>メモ</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=inc.getMemo()%>
				</td>
			</tr>
		</table>
		<br />
		<table align="0">
			<tr>
				<td><form method=post action=updatePreperationServlet>
						<input type=submit value=このアイテムの情報を修正する>
					</form></td>
				<td><form method=post action=confirmIncomeDelete.jsp>
						<input type=submit value=このアイテムを削除する>
					</form></td>
			</tr>
			<tr>
				<td><form method=post action=listServlet>
						<input type=submit value=一覧に戻る>
					</form></td>
				<td></td>
			</tr>
		</table>

	</div>
</BODY>
</HTML>
