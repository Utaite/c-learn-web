<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table>
		<tr>
			<th>번호</th>
			<th>동영상번호</th>
			<th>시작시간</th>
			<th>종료시간</th>
		</tr>
		<c:forEach var="listv" items="${list }" varStatus="status">
			<tr>
				<td>${listv.number }</td>
				<td>${listv.v_num }</td>
				<td>${listv.start_time }</td>
				<td>${listv.end_time }</td>
			</tr>
		</c:forEach>
	</table>
</div>