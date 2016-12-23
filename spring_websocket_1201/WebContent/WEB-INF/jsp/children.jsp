<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자녀 정보등록</title>
<script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0rc1.js"></script>
</head>
<body>
<body bgcolor="#ffffff" text="#000000">
	<P align="center">
		<FONT size="6"><B>자녀정보등록</B></FONT>
	</P>
	<form action="childrenAdd" method="post" id="join" enctype="multipart/form-data">
		<table width="550" align="center" border="1" bordercolor="ADD8E6"
			cellpadding="5">
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">이름</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15" id="c_name"
					name="c_name"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">성별</td>
				<td bgcolor="#E0FFFF"><input type="radio" name="c_gender"
					value="여자">여성 <input type="radio" name="c_gender"
					value="남자">남성<br></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">사진선택</td>
				<td bgcolor="#E0FFFF"><input type="file" id="c_pic"
					name="c_pic"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">나이</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15" id="c_age"
					name="c_age"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">생일</td>
				<td bgcolor="#E0FFFF"><input type="date" name="c_birth"
					id="c_birth"></td>
			</tr>
			<tr style="border: none;">
				<td height="50" align="right" colspan="2" style="border: none;">
					<input type="submit" value="등록"> <input type="button"
					value="취소" onclick="location='parentdetail'">
				</td>
			</tr>
		</table>
	</form>
</body>


</html>