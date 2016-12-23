<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

<!-- 2. charsetをutf-8に設定する-->
<meta charset="utf-8">

<!-- 3. ビューポートの設定-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン｜かけいぼ！</title>
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
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ログイン<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="./login.jsp">ログイン</a></li>
						</ul></li>
					<ul>
			</div>
		</div>
	</nav>


	<div class="container">
		<div class="page-header">
			<br />
			<h1>ログイン</h1>
		</div>
		<p>今日もがんばりましょう！</p>
		<p>ユーザ名・パスワードを入力してください。</p>

		<FORM class="form-horizontal" METHOD="POST" ACTION="loginServlet">
			<div class="form-group">
				<label class="control-label col-xs-2">ユーザ名</label>
				<div class="col-xs-5">
					<INPUT TYPE="TEXT" NAME="uid" VALUE="" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">パスワード</label>
				<div class="col-xs-5">
					<INPUT TYPE="password" NAME="pswd" VALUE="" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<INPUT TYPE="SUBMIT" VALUE="ログイン" />
				</div>
			</div>

		</FORM>
		<p>パスワードを忘れた方、新規の方・・・管理者までご連絡ください。</p>
	</Div>
</BODY>
</HTML>

