<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<HTML>
<HEAD>
<%
	LinkedList itemList = (LinkedList) session.getAttribute("ItemList");
%>
</HEAD>
<BODY>

	<TABLE BORDER=1>
		<tr bgcolor="#c6d9f1" align="center">
			<td>名前</td>
			<td>値段</td>
			<td></td>
		</tr>
		<%
			for (int i = 0; i < itemList.size(); i++) {
				Item item = (Item) itemList.get(i);
		%>
		<tr bgcolor="#fcd5b5">
			<td><%=item.getName()%></td>
			<td><%=item.getPrice()%></td>
			<td><form method=post action=detailsServlet>
					<input type=hidden name=RID value=<%=item.getRid()%>> <input
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
</BODY>
</HTML>
