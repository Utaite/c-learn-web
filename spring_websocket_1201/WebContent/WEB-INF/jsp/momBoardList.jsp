<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="7">맘 게시판 리스트</th>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>등록일</th> 
				<th>고객번호</th>
			</tr>
		</thead>
		<tbody> 

			<c:forEach var="listv" items="${list2 }"> 
				<tr>
					<td>${listv.ib_num}</td>
					<td><a href="momBoardDetail?ib_num=${listv.ib_num}">${listv.ib_sub}</a>
					</td>
					<td>${listv.ib_hit}</td>
					<td>${listv.ib_recom}</td>
					<td>${listv.ib_date}</td>
					<td>${listv.p_num}</td>
			 	</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				<th colspan="4"><input type="button" value="글쓰기"
					onclick="location='momBoardForm'"></th>
			</tr>
			<tr>
				<th colspan="4">${pagingCode}</th>
			</tr>
			<tr>
				<td colspan="4">
					<form method="get" action="momBoardListSearch">
						<input type="hidden" id="nowPage" name="nowPage"
							value="${nowPage}"> <select name="searchType"
							id="searchType">
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