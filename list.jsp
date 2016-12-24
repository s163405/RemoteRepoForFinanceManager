<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<HTML lang="ja">
<HEAD>
<%
	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
	Calendar calendar = Calendar.getInstance();//年月切り替え
	LinkedList EXPList = (LinkedList) session.getAttribute("EXPList");
	LinkedList INCList = (LinkedList) session.getAttribute("INCList");
	int year = (Integer) session.getAttribute("year");
	int month = (Integer) session.getAttribute("month");
	UserData ud = (UserData) session.getAttribute("user");
%>
<!-- 2. charsetをutf-8に設定する-->
<meta charset="utf-8">

<!-- 3. ビューポートの設定-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>履歴リスト｜かけいぼ！</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/style.css" type="text/css"
	media="print, projection, screen" />
<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
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

<style type="text/css">
.table {
	display: table;
}

.tableContents {
	display: table-cell;
	vertical-align: middle;
}
</style>

</HEAD>
<BODY>


	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">

			<!-- モバイル表示用の省略メニュー -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-menu">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">かけいぼ！</a>
			</div>

			<!-- ナビゲーションメニュー -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav">
					<li><a href="./indexServlet">家計簿の概要</a></li>
					<li><a href="./listServlet">履歴リスト</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-left">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 新規入力<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:void(0)"
								onclick="document.insertEXP.submit(); return false;">支出</a></li>
							<form name="insertEXP" method="post"
								action="./insertPreperationServlet">
								<input type="hidden" name="type" value="EXP">
							</form>

							<li><a href="javascript:void(0)"
								onclick="document.insertINC.submit(); return false;">収入</a></li>
							<form name="insertINC" method="post"
								action="./insertPreperationServlet">
								<input type="hidden" name="type" value="INC">
							</form>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ようこそ、 <%=ud.getUserID()%> さん<span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="./logoutServlet">ログアウト</a></li>
						</ul></li>
					<ul>
			</div>
		</div>
	</nav>



	<Div class="container">
		<div class="page-header">
			<br />
			<h1>
				履歴リスト -
				<%=year%>年<%=month%>月
			</h1>
		</div>


		<form action="listServlet" method="post">
			<label>他の年月を表示:<input type="month" name="month"
				value="<%=(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1))%>"></label>
			<input type="submit" value="送信">
		</form>

		<h3>支出</h3>
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

		<!--
		<form method=post action=insertPreperationServlet>
			<input type=hidden name=type value=EXP> <input type=submit
				value=支出を新規入力する>
		</form>
		 -->
		<br /> <br />
		<h3>収入</h3>
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
		<!-- <form method=post action=insertPreperationServlet>
			<input type=hidden name=type value=INC> <input type=submit
				value=収入を新規入力する>
		</form> -->
		<footer>
			<br />
		</footer>


	</Div>
</BODY>
</HTML>
