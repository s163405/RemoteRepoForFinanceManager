<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="DBSample.Item"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

<%
	Item item = (Item) session.getAttribute("item");
%>

</HEAD>
<BODY>
	<p>追加するアイテムの情報を入力してください。</p>
	<FORM METHOD="POST" ACTION="confirmUpdateServlet">
		名前 <INPUT TYPE="TEXT" NAME="name" VALUE="<%=item.getName() %>" /> <br /> <br /> 値段 <INPUT
			TYPE="TEXT" NAME="price" VALUE="<%=item.getPrice() %>" /> <br /> <br /> 詳細 <INPUT
			TYPE="TEXT" NAME="details" VALUE="<%=item.getDetails() %>" /> <br /> <br /> 在庫 <INPUT
			TYPE="TEXT" NAME="stock" VALUE="<%=item.getStock() %>" /> <br /> <br /> <INPUT
			TYPE="SUBMIT" VALUE="アイテムの修正" />
	</FORM>

</BODY>
</HTML>

