<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<table>
		<tr>
			<th>번호</th>
			<th>강의명</th>
			<th>수강일</th>
			<th>학습하기</th>
		</tr>
		<c:forEach var="listv" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${listv.ch_sub}</td>
				<td>${listv.cl_done }</td>
				<td><input type="button" value="학습하기" onclick="location.href='play'"></td>
			</tr>
		</c:forEach>
	</table>
</div>