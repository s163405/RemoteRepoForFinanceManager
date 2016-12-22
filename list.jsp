<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<HTML>
<HEAD>
<%
	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
	Calendar calendar = Calendar.getInstance();//年月切り替え
	LinkedList EXPList = (LinkedList) session.getAttribute("EXPList");
	LinkedList INCList = (LinkedList) session.getAttribute("INCList");
	int year = (Integer) session.getAttribute("year");
	int month = (Integer) session.getAttribute("month");
%>

<link rel="stylesheet" href="./css/style.css" type="text/css"
	media="print, projection, screen" />
<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/jquery.tablesorter.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#EXPTable").tablesorter({
			headers : {
				4 : {
					sorter : false
				}
			}
		});
		$("#INCTable").tablesorter({
			headers : {
				3 : {
					sorter : false
				}
			}
		});

	});
</script>

</HEAD>
<BODY>
	<Div align="center">
		<h1>履歴リスト</h1>
						<form method=post action=indexServlet>
			<input type=submit value=家計簿の概要表示へ>
		</form>
		<hr>
		<h2><%=year%>年<%=month%>月
		</h2>

		<p>
		<form action="listServlet" method="post">
			<label>他の年月を表示:<input type="month" name="month"
				value="<%=(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1))%>"></label>
			<input type="submit" value="送信">
		</form>
		</p>

		<br />

		<h3>*支出*</h3>
		<TABLE id="EXPTable" class="tablesorter">
			<thead>
				<tr bgcolor="#c6d9f1" align="center">
					<th>日付</th>
					<th>カテゴリ</th>
					<th>金額</th>
					<th>場所</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < EXPList.size(); i++) {
						Expenses exp = (Expenses) EXPList.get(i);
				%>
				<tr bgcolor="#fcd5b5">
					<td><%=exp.getYear() + "/" + String.format("%02d", exp.getMonth()) + "/"
						+ String.format("%02d", exp.getDay())%></td>
					<td><%=exp.getCategory().getCategory()%></td>
					<td><%=toYen.format(exp.getAmount())%></td>
					<td><%=exp.getPlace()%></td>
					<td width="30px"><form method=post action=detailsServlet>
							<input type=hidden name=type value=EXP> <input
								type=hidden name=RID value=<%=exp.getRid()%>> <input
								type=submit value=詳細>
						</form></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</TABLE>
		<form method=post action=insertPreperationServlet>
			<input type=hidden name=type value=EXP> <input type=submit
				value=支出を新規入力する>
		</form>
		<br /> <br />
		<h3>*収入*</h3>
		<TABLE id="INCTable" class="tablesorter">
			<thead>
				<tr bgcolor="#c6d9f1" align="center">
					<th>日付</th>
					<th>カテゴリ</th>
					<th>金額</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < INCList.size(); i++) {
						Income inc = (Income) INCList.get(i);
				%>
				<tr bgcolor="#fcd5b5">
					<td><%=inc.getYear() + "/" + String.format("%02d", inc.getMonth()) + "/"
						+ String.format("%02d", inc.getDay())%></td>
					<td><%=inc.getCategory().getCategory()%></td>
					<td><%=toYen.format(inc.getAmount())%></td>
					<td width="30px"><form method=post action=detailsServlet>
							<input type=hidden name=type value=INC> <input
								type=hidden name=RID value=<%=inc.getRid()%>> <input
								type=submit value=詳細>
						</form></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</TABLE>
		<form method=post action=insertPreperationServlet>
			<input type=hidden name=type value=INC> <input type=submit
				value=収入を新規入力する>
		</form>

	</Div>
</BODY>
</HTML>
