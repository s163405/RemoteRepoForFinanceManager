<%@  page contentType="text/html;   charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<HTML lang="ja">
<HEAD>
<META CHARSET="UTF-8">

</HEAD>
<BODY>
	<Div align="center">
		<h1>家計簿管理システム・ログイン</h1>
		<p>今日もがんばりましょう！</p>
		<p>ユーザ名・パスワードを入力してください。</p>

		<FORM METHOD="POST" ACTION="loginServlet">
			<table>
				<tr>
					<td>ユーザ名</td>
					<td><INPUT TYPE="TEXT" NAME="uid" VALUE="" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><INPUT TYPE="password" NAME="pswd" VALUE="" /></td>
				</tr>
				<tr>
					<td colspan="2"><center>
							<INPUT TYPE="SUBMIT" VALUE="ログイン" />
						</center></td>
				</tr>
			</table>

		</FORM>
		<p>パスワードを忘れたら・・・管理者までご連絡ください。</p>
	</Div>
</BODY>
</HTML>

