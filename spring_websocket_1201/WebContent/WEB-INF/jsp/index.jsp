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
	<a href="javascript:popupOpen()">열려라 팝업창</a>
	<a href="member">회원가입</a>
	<a href="idsearch">id찾기</a>
	<a href="pwsearch">pw찾기</a>
	<a href="registerDoginList">학습하러가기</a>
	<a href="registerManagerList">학습관리</a>
	<a
		href="registerAddListView?p_id=${sessionScope.p_id }&p_token=${sessionScope.p_token }">수강신청</a>
	<a href="adminNoticeForm">공지사항등록</a>
	<a href="adminNoticeList?nowPage=1">공지사항리스트</a>
	<a href="adminFaqBoardList">FAQ</a>
	<a href="adminParentList?nowPage=1">부모회원관리</a>
	<a href="adminChildList?nowPage=1">자녀회원관리</a>
	<a href="momBoardList?nowPage=1">자유게시판</a>
	<a href="parentdetail">마이페이지</a>
	<a href="">안드로이드 연동 가자</a>
</body>
</html>