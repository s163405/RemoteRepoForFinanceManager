<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<%
	Expenses exp = (Expenses) session.getAttribute("exp");
	NumberFormat toYen = NumberFormat.getCurrencyInstance(); //通貨形式
	UserData ud = (UserData) session.getAttribute("user");
%>
<!-- 3. ビューポートの設定-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>支出情報の削除｜かけいぼ！</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>

<script src="js/bootstrap.min.js"></script>

</head>
<body>


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

	<div class="container">
		<div class="page-header">
			<br />
			<h1>支出情報の削除</h1>
		</div>

		<table border="1" bordercolor="black">
			<tr>
				<td bgcolor="#92d050" align="center" width=80>日付</td>
				<td bgcolor="#fcd5b5" align="left" width=400><%=exp.getYear() + "/" + String.format("%02d", exp.getMonth()) + "/" + String.format("%02d", exp.getDay())%>
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

		<p>この情報を削除します。よろしいですか？</p>

		<table>
			<tr>
				<td><FORM METHOD="POST" ACTION="deleteExpensesServlet">
						<INPUT TYPE="SUBMIT" VALUE="はい" />
					</FORM></td>
				<td>
					<FORM METHOD="POST" ACTION="expensesDetails.jsp">
						<INPUT TYPE="SUBMIT" VALUE="いいえ" />

					</FORM>
				</td>
			</tr>
		</table>



	</div>

</body>
</html>