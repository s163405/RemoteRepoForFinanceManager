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
	LinkedList expCatList = (LinkedList) session.getAttribute("EXPCatList");
	LinkedList incCatList = (LinkedList) session.getAttribute("INCCatList");
	int year = (Integer) session.getAttribute("year");
	int month = (Integer) session.getAttribute("month");
	int totalEXP = (Integer) session.getAttribute("totalEXP");
	int totalINC = (Integer) session.getAttribute("totalINC");
	int expSCData[][] = (int[][]) session.getAttribute("expSCData");
	int expPieData[] = (int[]) session.getAttribute("expPieData");
	int incPieData[] = (int[]) session.getAttribute("incPieData");
	UserData ud = (UserData) session.getAttribute("user");
%>
<!-- 2. charsetをutf-8に設定する-->
<meta charset="utf-8">

<!-- 3. ビューポートの設定-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>家計簿の概要｜かけいぼ！</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>

<script src="js/bootstrap.min.js"></script>


<script type="text/javascript" src="./js/canvasjs.min.js"></script>
<script type="text/javascript">
	window.onload = function() {

		//積み上げ棒グラフ
		var chart = new CanvasJS.Chart("EXPstackedColumn", {
			title : {//タイトル
				text : "日ごとの支出"
			},
			axisY : {//Y軸
				valueFormatString : "#######0",//桁のとり方
			},
			data : [
			<%for (int i = 0; i < expSCData[i].length; i++) {//カテゴリ別
				EXPCat thisEXPCat = (EXPCat) expCatList.get(i);%>
				{
						type : "stackedColumn",
						//凡例
						legendText : "<%=thisEXPCat.getCategory()%>",
						showInLegend : "true",//その項目をグラフに表示するか(T/F)

						<%if (i == expSCData[i].length - 1) {%>
							indexLabel : "#total 円",//棒の上に表示される数字の単位
							yValueFormatString : "#########",//単位のとり方
							indexLabelPlacement : "outside",//数字はどこに表示させるか
						<%}%>

				dataPoints : [ { <%for (int j = 0; j < expSCData.length; j++) {//1-31日%>
					y : <%=expSCData[j][i]%>, label : <%="\"" + month + "/" + (j + 1) + "\""%>
					}
				<%if (j != expSCData.length - 1) {
						out.print(",{");
					}
				}%>
				]
				<%if (i != expSCData[i].length - 1) {
					out.print("},");
				} else if (i == expSCData[i].length - 1) {
					out.print("}]");
				}%>
			<%}%>

		});
		chart.render();


		var chart = new CanvasJS.Chart("EXPpieChart", {
			theme : "theme2",
			title : {
				text : "支出の内訳"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				toolTipContent : "{y} - #percent %",//yValue(単位付き),X％
				yValueFormatString : "#######円",
				legendText : "{indexLabel}",//凡例のテキスト

				dataPoints : [
				<%for (int i = 0; i < expPieData.length; i++) {
				EXPCat thisEXPCat = (EXPCat) expCatList.get(i);%>
					{						y : <%=expPieData[i]%>,
						indexLabel : <%="\"" + thisEXPCat.getCategory() + "\""%>
					}
				<%if (i != (expPieData.length - 1)) {
					out.print(",");
				}
			}%>
				]
			} ]
		});
		chart.render();

		var chart = new CanvasJS.Chart("INCpieChart", {
			theme : "theme2",
			title : {
				text : "収入の内訳"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				toolTipContent : "{y} - #percent %",//yValue(単位付き),X％
				yValueFormatString : "#######円",
				legendText : "{indexLabel}",//凡例のテキスト

				dataPoints : [
				<%for (int i = 0; i < incPieData.length; i++) {
				INCCat thisINCCat = (INCCat) incCatList.get(i);%>
					{						y : <%=incPieData[i]%>,
						indexLabel : <%="\"" + thisINCCat.getCategory() + "\""%>
					}
				<%if (i != (incPieData.length - 1)) {
					out.print(",");
				}
			}%>
				]
			} ]
		});
		chart.render();
	}
</script>

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
						data-toggle="dropdown"> ようこそ、 <%=ud.getUserID() %>さん<span class="caret"></span>
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

			<h1>
				家計簿の概要 -
				<%=year%>年<%=month%>月
			</h1>
		</div>
		<form action="indexServlet" method="post">
			<label>他の年月を表示:<input type="month" name="month"
				value="<%=(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1))%>"></label>
			<input type="submit" value="送信">
		</form>

		<br />

		<h3>月の収支</h3>
		<TABLE align="center">
			<tr width="500" align="center">
				<td>収入</td>
				<td></td>
				<td>支出</td>
				<td></td>
				<td>のこり</td>
			</tr>
			<tr style="font-size: 250%;">
				<td><%=toYen.format(totalINC)%></td>
				<td>-</td>
				<td><%=toYen.format(totalEXP)%></td>
				<td>=</td>
				<%
					int balance = totalINC - totalEXP;
					String fontColor = "";
					if (balance < 0) {
						fontColor = "red";
					} else {
						fontColor = "black";
					}
				%>
				<td><font color="<%=fontColor%>"><%=toYen.format(balance)%></font></td>
			</tr>
		</TABLE>
		<br /> <br />

		<h3><%=ud.getUserID() %>さんの家計の分析結果</h3>
		<div id="EXPstackedColumn" style="height: 300px; width: 100%;"></div>
		<br /> <br />

		<table width="100%">
			<tr>
				<td>
					<div id="EXPpieChart" style="height: 300px; width: 100%;"></div>
				</td>

				<td>
					<div id="INCpieChart" style="height: 300px; width: 100%;"></div>
				</td>

			<tr>
		</table>
		<br /> <br />


	</Div>
</BODY>
</HTML>
