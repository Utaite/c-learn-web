<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 회원가입</title>
<script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0rc1.js"></script>
</head>
<script>
	$(function() {
		// jQuery는 요소 선택자를 사용해서 idChkBtn의 클릭 이벤트를 감지하여
		// id가 id인 text의 값을 받아오는 예제
		$('#idCheck').click(function() {
			var idv = $('#a_id').val();
			console.log("id값 : " + idv);
			// target에 ajax의 결과를 바로 적용
			$('#target2').load('adminIdChk?a_id=' + idv);
		});
	});

	$(function() {
		// jQuery는 요소 선택자를 사용해서 idChkBtn의 클릭 이벤트를 감지하여
		// id가 id인 text의 값을 받아오는 예제
		$('#nicknameCheck').click(function() {
			var nicknamev = $('#a_nickname').val();
			console.log("id값 : " + nicknamev);
			// target에 ajax의 결과를 바로 적용
			$('#target3').load('adminNicknamechk?a_nickname=' + nicknamev);
		});
	});
</script>
<body bgcolor="#ffffff" text="#000000">
	<P align="center">
		<FONT size="6"><B>관리자 회원가입</B></FONT>
	</P>
	<form action="adminadd" method="post" id="join"
		enctype="multipart/form-data">
		<table width="550" align="center" border="1" bordercolor="ADD8E6"
			cellpadding="5">
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 인증번호</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15" id="a_num"
					name="a_num" maxlength="30">&nbsp;<input type="button"
					value="유효체크" id='numCheck'>
					<p id="target"></p></td>

			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 아이디</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15" id="a_id"
					name="a_id" maxlength="30">&nbsp;<input type="button"
					value="중복체크" id='idCheck'>
					<p id="target2"></p></td>

			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 이름</td>
				<td bgcolor="#E0FFFF"><input type="text" id="a_name"
					name="a_name" size=15 maxlength="30"></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 비밀번호</td>
				<td bgcolor="#E0FFFF"><input type="password" size="15"
					id="a_pwd" name="a_pwd" maxlength="10">&nbsp;
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 권한</td>
				<td bgcolor="#E0FFFF"><input type="radio" name="r_num"
					value="1">게시판 <input type="radio" name="r_num"
					value="2">회원관리 <input type="radio" name="r_num"
					value="3">컨텐츠관리<br></td>
			</tr>
			<tr>
				<td height="30" align="center" bgcolor="#FFDEAD">관리자 닉네임</td>
				<td bgcolor="#E0FFFF"><input type="text" size="15"
					id="a_nickname" name="a_nickname" maxlength="20">&nbsp;<input
					type="button" value="중복체크" id='nicknameCheck'>
					<p id="target3"></p></td>
			</tr>
			<tr style="border: none;">
				<td height="50" align="right" colspan="2" style="border: none;">
					<input type="submit" value="회원가입"> <input type="button"
					value="취소" onClick="location='adminmenu'"> <!-- 로케이션 cifrom 가게 해주세요 -->
				</td>
			</tr>
		</table>
	</form>
</body>
</html>