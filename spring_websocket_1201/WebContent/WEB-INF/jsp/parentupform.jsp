<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 관리</title>
</head>
<body bgcolor="#ffffff" text="#000000">
	<P align="center">
		<FONT size="6"><B>정보 수정 하기</B></FONT>
	</P>
	<form action="parentupdate" method="post" id="join"
		enctype="multipart/form-data">
		<input type="hidden" name="p_num" value="${pvo.p_num }">
		<table width="550" align="center" border="1" bordercolor="ADD8E6"
			cellpadding="5">
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">이름</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15" id="p_name"
					name="p_name" maxlength="10" value="${pvo.p_name }">&nbsp;
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">비밀번호</td>
				<td bgcolor="#E0FFFF"><input type="password" id="p_pw"
					name="p_pw" size=15 maxlength="30" value="${pvo.p_pw }"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">닉네임</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15"
					id="p_nickname" name="p_nickname" maxlength="20" value="${pvo.p_nickname }">&nbsp;<input
					type="button" id="nicknameCheck" value="중복확인">
					<p id="target2"></p></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">이메일</td>
				<td bgcolor="#E0FFFF"><input type="text" id="p_mail"
					name="p_mail" size=15 maxlength="30" value="${pvo.p_mail }"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">주소</td>
				<td bgcolor="#E0FFFF"><input type="text" id="p_addr"
					name="p_addr" size=15 value="${pvo.p_addr }"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">휴대폰번호</td>
				<td bgcolor="#E0FFFF"><select id="p_phone1" name="p_phone1"
					style="width: 70;">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
				</select> - <input type="text" id="p_phone2" name="p_phone2" size="4"
					maxlength="4" value="${phone2}"> - <input type="text" id="p_phone3"
					name="p_phone3" size="4" maxlength="4" value="${phone3}"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">사진선택</td>
				<td bgcolor="#E0FFFF"><input type="file" id="img_file"
					name="img_file">
					<img src="resources/upload/${pvo.p_pic }" width="150" height="150">
					</td>
			</tr>
			<tr style="border: none;">
				<td height="50" align="right" colspan="2" style="border: none;">
					<input type="submit" value="수정하기"> <input type="button"
					value="취소" onclick="location='parentdetail?p_num=${pvo.p_num}'">
					<input type="button" value="홈으로"
					onclick="location='ciform'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>