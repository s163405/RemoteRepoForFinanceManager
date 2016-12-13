<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

</HEAD>
<BODY>
<p>追加するアイテムの情報を入力してください。</p>
	<FORM METHOD="POST" ACTION="confirmInsertServlet">
		名前 <INPUT TYPE="TEXT" NAME="name"  VALUE="" /> <br /><br />
		値段 <INPUT TYPE="TEXT" NAME="price"  VALUE="" /> <br /><br />
		詳細 <INPUT TYPE="TEXT" NAME="details"  VALUE="" /> <br /><br />
		在庫 <INPUT TYPE="TEXT" NAME="stock"  VALUE="" /> <br /><br />
			<INPUT TYPE="SUBMIT" VALUE="新規作成" />
	</FORM>
</BODY>
</HTML>

