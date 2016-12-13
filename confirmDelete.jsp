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

	<div align="center">
		<div align="center">アイテムの削除</div>

		<table border="1">

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
		<p>このアイテムを削除します。よろしいですか？</p>

		<table>
			<tr>
				<td><FORM METHOD="POST" ACTION="deleteServlet">
						<INPUT TYPE="SUBMIT" VALUE="はい" />
					</FORM></td>
				<td>
					<FORM METHOD="POST" ACTION="details.jsp">
						<INPUT TYPE="SUBMIT" VALUE="いいえ" />

					</FORM>
				</td>
			</tr>
		</table>



	</div>

</body>
</html>