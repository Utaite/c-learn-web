<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="8"><h2>부모 회원 관리</h2></th>
			</tr>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>휴대폰번호</th>
				<th>이름</th>
				<th>주소</th>
				<th>닉네임</th>
				<th>가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listv" items="${list}">
				<tr>
					<td>${listv.p_num }</td>
					<td><a href="adminParentDetail?p_num=${listv.p_num }">${listv.p_id }</a></td>
					<td>${listv.p_mail }</td>
					<td>${listv.p_phone }</td>
					<td>${listv.p_name }</td>
					<td>${listv.p_addr }</td>
					<td>${listv.p_nickname }</td>
					<td>${listv.p_date }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="8">${pagingCode }</th>
			</tr>
			<tr>
				<td colspan="8">
					<form method="post" action="adminParentListSearch">
						<input type="hidden" id="nowPage" name="nowPage"
							value="${nowPage}"> <select name="searchType"
							id="searchType">
							<option value="0">선택</option>
							<option value="1">아이디</option>
							<option value="2">이름</option>
							<option value="2">전화번호</option>
						</select>&nbsp; <input type="text" name="searchValue" id="searchValue"
							value="${searchValue}">&nbsp; <input type="submit"
							value="검색">
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</div>