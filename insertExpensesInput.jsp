<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

<%
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
	<Div align="center">
		<h1>新規入力(支出)</h1>
		<hr>
		<p>追加するアイテムの情報を入力してください。</p>
<FORM METHOD="POST" ACTION="confirmExpensesInputServlet">
			<ul>
				<li class="date"><label>日付</label> <input id="date" type="date" name="date">
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
					name="amount"></li>
				<li class="place"><label>場所</label> <INPUT TYPE="TEXT"
					NAME="place" />
				<li class="memo"><label>メモ</label> <INPUT TYPE="TEXT"
					NAME="memo" /></li>

				<li><INPUT TYPE="SUBMIT" VALUE="確認" /></li>
			</ul>
		</FORM>
	</Div>
</BODY>
</HTML>

