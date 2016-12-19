<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<HTML>
<HEAD>

<%
	Expenses exp = (Expenses) session.getAttribute("exp");

	session.removeAttribute("type");

	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
%>
</HEAD>
<BODY>
	<div align="center">
		<h1>支出の詳細情報</h1>
		<hr>
		<table border="1" bordercolor="black">
			<tr>
				<td bgcolor="#92d050" align="center" width=80>日付</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getYear() + "/" + exp.getMonth() + "/" + exp.getDay()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>カテゴリ</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getCategory().getCategory()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>金額</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=toYen.format(exp.getAmount())%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>場所</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getPlace()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>メモ</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getMemo()%>
				</td>
			</tr>
		</table>
		<br />
		<table align="0">
			<tr>
				<td><form method=post action=update.jsp>
						<input type=submit value=このアイテムの情報を修正する>
					</form></td>
				<td><form method=post action=confirmDelete.jsp>
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
