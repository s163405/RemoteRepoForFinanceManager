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
	LinkedList expCatList = (LinkedList) session.getAttribute("EXPCatList");
	LinkedList incCatList = (LinkedList) session.getAttribute("INCCatList");
	int year = (Integer) session.getAttribute("year");
	int month = (Integer) session.getAttribute("month");
	int totalEXP = (Integer) session.getAttribute("totalEXP");
	int totalINC = (Integer) session.getAttribute("totalINC");
	int expSCData[][] = (int[][]) session.getAttribute("expSCData");
	int expPieData[] = (int[]) session.getAttribute("expPieData");
	int incPieData[] = (int[]) session.getAttribute("incPieData");
%>
<script type="text/javascript"
	src="./js/canvasjs.min.js"></script>
<script type="text/javascript">
	window.onload = function() {

		//積み上げ棒グラフ
		var chart = new CanvasJS.Chart("EXPstackedColumn", {
			title : {//タイトル
				text : "日ごとの支出"
			},
			axisY : {//Y軸
				valueFormatString : "#0.#,.",//桁のとり方
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
	<Div align="center">
		<h1>家計簿の概要</h1>
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
			<tr width="500"  align="center">
				<td>収入</td>
				<td></td>
				<td>支出</td>
				<td></td>
				<td>のこり</td>
			</tr>
			<tr style="font-size: 250%;">
				<td><%=toYen.format(totalINC)%></td>
				<td> - </td>
				<td><%=toYen.format(totalEXP)%></td>
				<td> = </td>
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

		<h3>（ユーザ）さんの家計の分析結果</h3>
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

				</td>
			<tr>
		</table>
		<br /> <br />


	</Div>
</BODY>
</HTML>
