<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script type="text/javascript">
	function popupOpen() {
		var popUrl = "classdetail?ct_num=3"; //팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	}
	window.onload = function() {
		if ("${status}" === "") {
		} else {
			alert("${status}");
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.uid==null }">
			<li><a href="loginform">로그인 예제</a></li>
		</c:when>
		<c:otherwise>
			<li>${sessionScope.uid }님반가워용^^<a href="logout">로그아웃 예제</a></li>
		</c:otherwise>
	</c:choose>
	<div>
		<img src="resources/img/index image.png">
	</div>
</body>
</html>