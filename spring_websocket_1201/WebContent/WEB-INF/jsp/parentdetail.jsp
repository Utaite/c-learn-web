<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div>
	<table>
		<thead>
			<tr>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${parentVO.p_id }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${parentVO.p_mail }</td>
			</tr>
			<tr>
				<th>휴대폰전화</th>
				<td>${parentVO.p_phone }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${parentVO.p_name }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${parentVO.p_addr }</td>
			</tr>
			<tr>
				<th>사진</th>
				<td><img src="resources/upload/${parentVO.p_pic}"
					style="width: 200px; height: 200px;"></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${parentVO.p_nickname }</td>
			</tr>
			<tr>

				<td height="50" align="right" colspan="2" style="border: none;">
					<input type="button" value="자녀등록" onclick="location='children'">
					<input type="button" value="수정"
					onclick="location='parentupform?p_num=${parentVO.p_num}'">
					</a> <input type="button" value="취소" onclick="location='ciform'">
				</td>
			</tr>
		</tbody>
	</table>
</div>