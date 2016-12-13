<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

</HEAD>
<BODY>
<p>取得したいアイテムのRIDを入力してください。</p>
	<FORM METHOD="POST" ACTION="detailsServlet">
		<INPUT TYPE="TEXT" NAME="RID"  VALUE="" /> 	<INPUT TYPE="SUBMIT" VALUE="送信" />
	</FORM>
</BODY>
</HTML>

