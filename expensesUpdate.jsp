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
	Expenses exp = (Expenses) session.getAttribute("exp");
	LinkedList EXPCatList = (LinkedList) session.getAttribute("EXPCatList");
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
		<h1>支出情報更新</h1>
		<hr>

		<p>更新する情報を入力してください。</p>
		<FORM METHOD="POST" ACTION="confirmExpensesUpdateServlet">
			<ul>
				<li class="date"><label>日付</label> <input id="date" type="date"
					name="date"
					value=<%=(exp.getYear() + "-" + String.format("%02d", exp.getMonth()) + "-"
					+ String.format("%02d", exp.getDay()))%>>
				</li>

				<li class="category"><label>カテゴリ</label> <select
					name="category">
						<%
							for (int i = 0; i < EXPCatList.size(); i++) {
								EXPCat expCat = (EXPCat) EXPCatList.get(i);
						%>
						<option value="<%=expCat.getRid()%>"><%=expCat.getCategory()%></option>
						<%
							}
						%>
				</select></li>

				<li class="amount"><label>金額</label> <input type="number"
					name="amount" value=<%=exp.getAmount()%>></li>
				<li class="place"><label>場所</label> <INPUT TYPE="TEXT"
					NAME="place" VALUE="<%=exp.getPlace()%>" />
				<li class="memo"><label>メモ</label> <INPUT TYPE="TEXT"
					NAME="memo" VALUE="<%=exp.getMemo()%>" /></li>

				<li><INPUT TYPE="SUBMIT" VALUE="情報の修正" /></li>
			</ul>
		</FORM>

	</div>

</BODY>
</HTML>

