<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="2"><h2>자녀 회원 관리</h2></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>이름</th>
				<td>${scvo.c_name }</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${scvo.c_age }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${scvo.c_gender }</td>
			</tr>
			<tr>
				<th>사진</th>
				<td><img src="resources/upload/${scvo.c_pic }" width="150"
					height="150"></td>
			</tr>
			<tr>
				<th>생일</th>
				<td>${scvo.c_birth }</td>
			</tr>
		</tbody>
		<tfoot>
		<tr>
			<th colspan="2"><input type="button" value="목록" onclick="history.back();"></th>
		</tr>
		</tfoot>
	</table>
</div>