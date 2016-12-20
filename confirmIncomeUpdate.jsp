<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<%
Income inc = (Income) session.getAttribute("inc");
NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
%>

</head>
<body>

	<div align="center">
		<h1>収入情報の修正確認</h1>
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
		<p>収入情報をこのように修正します。よろしいですか？</p>

		<table>
			<tr>
				<td><FORM METHOD="POST" ACTION="updateServlet">
						<INPUT TYPE="SUBMIT" VALUE="はい" />
					</FORM></td>
				<td>
					<FORM METHOD="POST" ACTION="expensesUpdate.jsp">
						<INPUT TYPE="SUBMIT" VALUE="いいえ" />

					</FORM>
				</td>
			</tr>
		</table>



	</div>

</body>
</html>