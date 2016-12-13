<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.Item"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<%
	Item item = (Item) session.getAttribute("item");
%>

</head>
<body>

	<table border="1">

		<tr bgcolor="#dce6f2" align="center">

			<td width=150>名前</td>
			<td width=80>値段</td>
			<td width=300>詳細</td>
			<td width=50>在庫</td>
		</tr>


		<tr bgcolor="#e6b9b8">
			<td>
				<%
					out.print(item.getName());
				%>
			</td>
			<td>
				<%
					out.print(item.getPrice());
				%>
			</td>
			<td>
				<%
					out.print(item.getDetails());
				%>
			</td>
			<td>
				<%
					out.print(item.getStock());
				%>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<td><FORM METHOD="POST" ACTION="insertInput.jsp">
					<INPUT TYPE="SUBMIT" VALUE="アイテムの新規作成" />
				</FORM></td>
			<td>
				<FORM METHOD="POST" ACTION="detailsInput.jsp">
					<INPUT TYPE="SUBMIT" VALUE="アイテムの詳細表示" />

				</FORM>
			</td>
		</tr>
	</table>

</body>
</html>
