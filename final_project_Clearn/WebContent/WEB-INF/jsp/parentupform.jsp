<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#container {
	width: 800px;
	margin: auto;
}

.name {
	text-align: center;
	width: 200px;
}
</style>
<div id="container">
	<div>
		<P align="center">
			<FONT size="6"><B>정보 수정 하기</B></FONT>
		</P>
		<form action="parentupdate" method="post" id="join"
			enctype="multipart/form-data" class="form-horizontal">
			<input type="hidden" name="p_num" value="${pvo.p_num }">
			<table class="table">
				<tr>
					<td class="name">이름</td>
					<td><input type="text" size="15" id="p_name" name="p_name"
						maxlength="10" value="${pvo.p_name }"></td>
				</tr>
				<tr>
					<td class="name">비밀번호</td>
					<td><input type="password" id="p_pw" name="p_pw" size=15
						maxlength="30" value="${pvo.p_pw }"></td>
				</tr>
				<tr>
					<td class="name">닉네임</td>
					<td><input type="text" size="15" id="p_nickname"
						name="p_nickname" maxlength="20" value="${pvo.p_nickname }"></td>
				</tr>
				<tr>
					<td class="name">이메일</td>
					<td><input type="text" id="p_mail" name="p_mail" size=15
						maxlength="30" value="${pvo.p_mail }"></td>
				</tr>
				<tr>
					<td class="name">주소</td>
					<td><input type="text" id="p_addr" name="p_addr" size=15
						value="${pvo.p_addr }"></td>
				</tr>
				<tr>
					<td class="name">휴대폰번호</td>
					<td><select id="p_phone1" name="p_phone1" style="width: 70;">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select> - <input type="text" id="p_phone2" name="p_phone2" size="4"
						maxlength="4" value="${phone2}"> - <input type="text"
						id="p_phone3" name="p_phone3" size="4" maxlength="4"
						value="${phone3}"></td>
				</tr>
				<tr>
					<td class="name">사진선택</td>
					<td><input type="file" id="img_file" name="img_file" class="btn btn-danger">
						<br />  <img src="resources/upload/${pvo.p_pic }"
						width="150" height="150"><br /> <br /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input type="submit" value="수정하기"
						class="btn btn-default">&nbsp;&nbsp; <input type="button" value="취소"
						onclick="location='parentdetail?p_num=${pvo.p_num}'"
						class="btn btn-default"> &nbsp;&nbsp;<input type="button" value="홈으로"
						onclick="location='index'" class="btn btn-default">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>