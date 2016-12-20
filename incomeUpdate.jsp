<%@page import="DataBase.EXPCatManager"%>
<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

<%
	Income inc = (Income) session.getAttribute("inc");
	LinkedList INCCatList = (LinkedList) session.getAttribute("INCCatList");
%>
<style type="text/css">
ul li {
	list-style: none;
	margin-top: 10px;
}

label {
	margin-right: 10px;
	width: 100px;
	float: left;
}

ul {
	width: 500px;
	margin: 0 auto;
}

input {
	width: 180px;
}

select {
	width: 180px;
}

input#button {
	display: block;
	width: 150px;
	margin: 0 auto;
}
</style>

</HEAD>
<BODY>
	<div align="center">
		<h1>収入情報更新</h1>
		<hr>

		<p>更新する情報を入力してください。</p>
		<FORM METHOD="POST" ACTION="confirmIncomeUpdateServlet">
			<ul>
				<li class="date"><label>日付</label> <input id="date" type="date"
					name="date"
					value=<%=(inc.getYear() + "-" + String.format("%02d", inc.getMonth()) + "-"
					+ String.format("%02d", inc.getDay()))%>>
				</li>

				<li class="category"><label>カテゴリ</label> <select
					name="category">
						<%
							for (int i = 0; i < INCCatList.size(); i++) {
								INCCat incCat = (INCCat) INCCatList.get(i);
						%>
						<option value="<%=incCat.getRid()%>"><%=incCat.getCategory()%></option>
						<%
							}
						%>
				</select></li>

				<li class="amount"><label>金額</label> <input type="number"
					name="amount" value=<%=inc.getAmount()%>></li>
				<li class="memo"><label>メモ</label> <INPUT TYPE="TEXT"
					NAME="memo" VALUE="<%=inc.getMemo()%>" /></li>

				<li><INPUT TYPE="SUBMIT" VALUE="情報の修正" /></li>
			</ul>
		</FORM>

	</div>

</BODY>
</HTML>

