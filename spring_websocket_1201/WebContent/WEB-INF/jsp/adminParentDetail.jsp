<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="2"><h2>부모 회원 관리</h2></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${spvo.p_id }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${spvo.p_pw }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${spvo.p_mail }</td>
			</tr>
			<tr>
				<th>휴대폰번호</th>
				<td>${spvo.p_phone }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${spvo.p_name }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${spvo.p_addr }</td>
			</tr>
			<tr>
				<th>사진</th>
				<td><img src="resources/upload/${spvo.p_pic }" width="150" height="150"></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${spvo.p_nickname }</td>
			</tr>
		</tbody>
		<tfoot>
			<th colspan="2"><input type="button" value="목록" onclick="history.back();"></th>
		</tfoot>
	</table>
</div>