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
	int totalEXP = (Integer) session.getAttribute("totalEXP");
	int totalINC = (Integer) session.getAttribute("totalINC");
	int expSCData[][] = (int[][]) session.getAttribute("expSCData");
	int expPieData[] = (int[]) session.getAttribute("expPieData");
	int incPieData[] = (int[]) session.getAttribute("incPieSData");
%>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var chart = new CanvasJS.Chart("EXPstackedColumn", {
			title : {//タイトル
				text : "Coal Reserves of Countries"
			},
			axisY : {
				valueFormatString : "#0.#,.",
			},
			data : [ {
				type : "stackedColumn",
				legendText : "Anthracite & Bituminous",
				showInLegend : "true",
				dataPoints : [ {
					y : 111338,
					label : "USA"
				}, {
					y : 49088,
					label : "Russia"
				}, {
					y : 62200,
					label : "China"
				}, {
					y : 90085,
					label : "India"
				}, {
					y : 38600,
					label : "Australia"
				}, {
					y : 48750,
					label : "SA"
				} ]
			}, {
				type : "stackedColumn",
				legendText : "SubBituminous & Lignite",
				showInLegend : "true",
				indexLabel : "#total bn",
				yValueFormatString : "#0.#,.",
				indexLabelPlacement : "outside",
				dataPoints : [ {
					y : 135305,
					label : "USA"
				}, {
					y : 107922,
					label : "Russia"
				}, {
					y : 52300,
					label : "China"
				}, {
					y : 3360,
					label : "India"
				}, {
					y : 39900,
					label : "Australia"
				}, {
					y : 0,
					label : "SA"
				} ]
			} ]
		});
		chart.render();

		var chart = new CanvasJS.Chart("EXPpieChart", {
			theme : "theme2",
			title : {
				text : "Gaming Consoles Sold in 2012"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				toolTipContent : "{y} - #percent %",
				yValueFormatString : "#,##0,,.## Million",
				legendText : "{indexLabel}",
				dataPoints : [ {
					y : 4181563,
					indexLabel : "PlayStation 3"
				}, {
					y : 2175498,
					indexLabel : "Wii"
				}, {
					y : 3125844,
					indexLabel : "Xbox 360"
				}, {
					y : 1176121,
					indexLabel : "Nintendo DS"
				}, {
					y : 1727161,
					indexLabel : "PSP"
				}, {
					y : 4303364,
					indexLabel : "Nintendo 3DS"
				}, {
					y : 1717786,
					indexLabel : "PS Vita"
				} ]
			} ]
		});
		chart.render();

		var chart = new CanvasJS.Chart("INCpieChart", {
			theme : "theme2",
			title : {
				text : "Gaming Consoles Sold in 2012"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				toolTipContent : "{y} - #percent %",
				yValueFormatString : "#,##0,,.## Million",
				legendText : "{indexLabel}",
				dataPoints : [ {
					y : 4181563,
					indexLabel : "PlayStation 3"
				}, {
					y : 2175498,
					indexLabel : "Wii"
				}, {
					y : 3125844,
					indexLabel : "Xbox 360"
				}, {
					y : 1176121,
					indexLabel : "Nintendo DS"
				}, {
					y : 1727161,
					indexLabel : "PSP"
				}, {
					y : 4303364,
					indexLabel : "Nintendo 3DS"
				}, {
					y : 1717786,
					indexLabel : "PS Vita"
				} ]
			} ]
		});
		chart.render();
	}
</script>

</HEAD>
<BODY>
	<Div align="center">
		<h1>概要</h1>
		<form method=post action=listServlet>
			<input type=submit value=履歴リスト表示へ>
		</form>
		<hr>
		<h2><%=year%>年<%=month%>月
		</h2>
		<p>
		<form action="indexServlet" method="post">
			<label>他の年月を表示:<input type="month" name="month"
				value="<%=(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1))%>"></label>
			<input type="submit" value="送信">
		</form>

		</p>

		<br />

		<h3>月の収支</h3>
		<TABLE align="center">
			<tr width="500">
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
				<td><%=toYen.format(totalINC - totalEXP)%></td>
			</tr>
		</TABLE>
		<br /> <br />

		<h3>日ごとの支出</h3>
		<div id="EXPstackedColumn" style="height: 300px; width: 100%;"></div>
		<br /> <br />

		<table width="100%">
			<tr>
				<td><h3>支出</h3>
					<div id="EXPpieChart" style="height: 300px; width: 100%;"></div></td>

				<td><h3>収入</h3>
					<div id="INCpieChart" style="height: 300px; width: 100%;"></div></td>

				</td>
			<tr>
		</table>
		<br /> <br />


	</Div>
</BODY>
</HTML>
