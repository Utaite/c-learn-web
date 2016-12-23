<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	var popOption = "width=570, height=560, resizable=no, scrollbars=no, status=no;";
	function cpopupOpen(p_num) {
		var popUrl = "api/watchCresult?p_num=" + p_num;
		window.open(popUrl, "", popOption);
	}
	function qpopupOpen(p_num) {
		var popUrl = "api/watchQresult?p_num=" + p_num;
		window.open(popUrl, "", popOption);
	}
</script>
<div>
	<input type="hidden" value="${ct_num }" name="ct_num" id="ct_num">
	<h3>강의 목록</h3>
	<input type="button" value="퀴즈확인"
		onclick="javascript:qpopupOpen(${sessionScope.p_num })"> <input
		type="button" value="접속기록확인"
		onclick="javascript:cpopupOpen(${sessionScope.p_num })">
	<table class="table">
		<tr>
			<th>번호</th>
			<th>강의명</th>
			<th>수강일(날짜)</th>
			<th>학습하기</th>
		</tr>
		<c:forEach var="listv" items="${list }" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${listv.ch_sub }</td>
				<!-- 으아아아아아 -->
				<c:choose>
					<c:when test="${listv.cl_done eq 0}">
						<td>미수강</td>
					</c:when>
					<c:when test="${listv.cl_done eq 1}">
						<td>학습완료(${listv.cl_date })</td>
					</c:when>
				</c:choose>
				<td>
					<form method="post" action="watchAndroid">
						<input type="hidden" name="msg" value="새로운 수업이 시작되었어요!"> <input
							type="hidden" name="v_num" value="${listv.v_num }"> <input
							type="hidden" name="p_token" value="${sessionScope.p_token }">
						<input type="submit" value="학습하기">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
</div>