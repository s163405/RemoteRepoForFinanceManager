<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<HTML>
<HEAD>
<%
	Item item = (Item) session.getAttribute("item");
%>
</HEAD>
<BODY>
	<div align="center">
		<table border="1" bordercolor="black">
			<p>アイテムの詳細情報</p>

			<tr>
				<td bgcolor="#92d050" align="center" width=80>名前</td>
				<td bgcolor="#fcd5b5" align="left" width=400>
					<%
						out.print(item.getName());
					%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>値段</td>
				<td bgcolor="#fcd5b5" align="left" width=400>
					<%
						out.print(item.getPrice());
					%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>詳細</td>
				<td bgcolor="#fcd5b5" align="left" width=400>
					<%
						out.print(item.getDetails());
					%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#92d050" align="center" width=80>在庫</td>
				<td bgcolor="#fcd5b5" align="left" width=400>
					<%
						out.print(item.getStock());
					%>
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
