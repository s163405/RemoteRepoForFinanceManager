<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<HTML>
<HEAD>
<%
	LinkedList EXPList = (LinkedList) session.getAttribute("EXPList");
	LinkedList INCList = (LinkedList) session.getAttribute("INCList");
%>
</HEAD>
<BODY>
<Div align="center">
<h1>詳細リスト</h1>
<hr>
<h2>2016年12月</h2>
<br/>

<h3>○支出</h3>
	<TABLE BORDER=1>
		<tr bgcolor="#c6d9f1" align="center">
			<th>日付</th>
			<th>カテゴリ</th>
			<th>金額</th>
			<th>場所</th>
			<th></th>
		</tr>
		<%
			for (int i = 0; i < EXPList.size(); i++) {
				Expenses exp = (Expenses) EXPList.get(i);
		%>
		<tr bgcolor="#fcd5b5">
			<td><%=exp.getDate()%></td>
			<td><%=exp.getCategory()%></td>
			<td><%=exp.getAmount()%></td>
			<td><%=exp.getPlace()%></td>
			<td><form method=post action=detailsServlet>
					<input type=hidden name=RID value=<%=exp.getRid()%>> <input
						type=submit value=詳細>
				</form></td>
		</tr>
		<%
			}
		%>
	</TABLE>
	<form method=post action=insertInput.jsp>
		<input type=submit value=アイテムを新規作成する>
	</form>

	</Div>
</BODY>
</HTML>
