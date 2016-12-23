<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table class="table">
		<thead>
			<tr>
				<th colspan="4">공지사항 리스트</th>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listv" items="${list1 }" end="5">
				<tr>
					<td>[공지]</td>
					<td><a href="adminNoticeDetail?n_num=${listv.n_num}">${listv.n_sub}</a></td>
					<td>${listv.n_hit}</td>
					<td>${listv.n_date}</td>
				</tr>
			</c:forEach>
			<c:forEach var="listv" items="${list2 }">
				<tr>
					<td>${listv.n_num}</td>
					<td><a href="adminNoticeDetail?n_num=${listv.n_num}">${listv.n_sub}</a></td>
					<td>${listv.n_hit}</td>
					<td>${listv.n_date}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="4"><input type="button" value="글쓰기"
					onclick="location='adminNoticeForm'"></th>
			</tr>
			<tr>
				<th colspan="4">${pagingCode }</th>
			</tr>



			<tr>
				<td colspan="4">
					<form method="post" action="adminNoticeListSearch">
						<input type="hidden" id="nowPage" name="nowPage"
							value="${nowPage}"> <select name="searchType"
							id="searchType">
							<option value="0">선택</option>
							<option value="1">제목</option>
							<option value="2">내용</option>
						</select>&nbsp; <input type="text" name="searchValue" id="searchValue"
							value="${searchValue}">&nbsp; <input type="submit"
							value="검색">
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</div>