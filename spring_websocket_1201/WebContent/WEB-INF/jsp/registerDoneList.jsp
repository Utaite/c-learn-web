<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>수강완료 강의</h3>
	<input type="hidden" value="${p_num }" name="p_num"> <input
		type="hidden" value="${ct_num }" name="ct_num">
	<table>
		<tr>
			<th>과목</th>
			<th>컨텐츠</th>
			<th>이수율</th>
			<th>별점</th>
		</tr>
		<c:forEach var="listv" items="${list }">
			<tr>
				<td>${listv.cc_name }</td>
				<td>${listv.ct_sub }</td>
				<td>${listv.percent }%</td>
				<c:choose>
					<c:when test="${listv.cl_dostar eq 0 }">
						<td>
							<form action="dostar" method="post">
							<input type="hidden" name="ct_num" value="${listv.ct_num }">
							<input type="hidden" name="p_num" value="${listv.p_num }">
								<select name="ct_star">
									<option>선택</option>
									<option value="0">☆☆☆☆☆</option>
									<option value="1">★☆☆☆☆</option>
									<option value="2">★★☆☆☆</option>
									<option value="3">★★★☆☆</option>
									<option value="4">★★★★☆</option>
									<option value="5">★★★★★</option>
								</select> <input type="submit" value="등록">
							</form>
						</td>
					</c:when>
					<c:otherwise>
						<td>★${listv.ct_star }점</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</div>