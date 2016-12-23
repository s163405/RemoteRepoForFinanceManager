<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

<%
	LinkedList EXPCatList = (LinkedList) session.getAttribute("EXPCatList");
	UserData ud = (UserData) session.getAttribute("user");
%>
<!-- 2. charsetをutf-8に設定する-->
<meta charset="utf-8">

<!-- 3. ビューポートの設定-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規入力（支出）｜かけいぼ！</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>

<script src="js/bootstrap.min.js"></script>

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


	<div class="container">
		<div class="page-header">
			<br />
			<h1>新規入力（支出）</h1>
		</div>
		<p>追加する情報を入力してください。</p>
		<FORM class="form-horizontal" METHOD="POST"
			ACTION="confirmExpensesInsertServlet">
			<div class="form-group">
				<label class="control-label col-xs-2">日付</label>
				<div class="col-xs-5">
					<input id="date" type="date" name="date">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">カテゴリ</label>

				<div class="col-xs-5">
					<select name="category">
						<%
							for (int i = 0; i < EXPCatList.size(); i++) {
								EXPCat expCat = (EXPCat) EXPCatList.get(i);
						%>
						<option value="<%=expCat.getRid()%>"><%=expCat.getCategory()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">金額</label>
				<div class="col-xs-5">
					<input type="number" name="amount">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">場所</label>
				<div class="col-xs-5">
					<INPUT TYPE="TEXT" NAME="place" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2"> メモ</label>
				<div class="col-xs-5">
					<INPUT TYPE="TEXT" NAME="memo" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<INPUT TYPE="SUBMIT" VALUE="確認" />
				</div>
			</div>
		</FORM>
	</div>
</BODY>
</HTML>

