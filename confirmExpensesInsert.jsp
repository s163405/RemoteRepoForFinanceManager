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
	Expenses exp = (Expenses) session.getAttribute("exp");
	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
%>

</head>
<body>

	<div align="center">
		<h1>支出情報の追加</h1>
		<hr>
		<table border="1" bordercolor="black">
			<tr>
				<td bgcolor="#92d050" align="center" width=80>日付</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getYear() + "/" + String.format("%02d", exp.getMonth()) + "/"
					+ String.format("%02d", exp.getDay())%></td>
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
		<p>この情報を追加します。よろしいですか？</p>

		<table>
			<tr>
				<td><FORM METHOD="POST" ACTION="insertServlet">
						<INPUT TYPE="SUBMIT" VALUE="はい" />
					</FORM></td>
				<td>
					<FORM METHOD="POST" ACTION="insertExpensesInput.jsp">
						<INPUT TYPE="SUBMIT" VALUE="いいえ" />

					</FORM>
				</td>
			</tr>
		</table>



	</div>

</body>
</html>