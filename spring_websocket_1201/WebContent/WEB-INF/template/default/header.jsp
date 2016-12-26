<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="resources/css/style.css" rel="stylesheet" />
<header>
	<div class="navbar navbar-default navbar-static-top">
		<c:choose>
			<c:when test="${sessionScope.uid == null }">
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li><a href="index.html"><img
								src="resources/img/main1.jpg" width="200px" height="100px"
								align="top"></a></li>
						<li><a href="loginform">로그인</a></li>
						<li><a href="member">회원가입</a></li>
						<li><a href="idsearch">아이디 찾기</a></li>
						<li><a href="pwsearch">비밀번호 찾기</a></li>
					</ul>
				</div>
			</c:when>
			<c:when test="${sessionScope.role eq \"admin\" }">
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li><a href="index.html"><img
								src="resources/img/main1.jpg" width="200px" height="100px"
								align="top"></a></li>
						<li><a href="adminNoticeList?nowPage=1">공지사항</a></li>
						<li><a href="adminFaqBoardList">FAQ</a></li>
						<li><a href="adminParentList?nowPage=1">부모회원관리</a></li>
						<li><a href="adminChildList?nowPage=1">자녀회원관리</a></li>
						<li><a href="momBoardList?nowPage=1">자유게시판</a></li>
						<li><a href="contChapForm">컨텐츠 등록</a></li>
						<li><br />${sessionScope.uid }님안녕하세요~^^</li>
						<li><a href="logout">로그아웃</a></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li><a href="index.html"><img
								src="resources/img/main1.jpg" width="200px" height="100px"
								align="top"></a></li>
						<li><a href="noticeList?nowPage=1">공지사항</a></li>
						<li><a href="registerManagerList">학습하러가기</a></li>
						<li><a href="registerAddListView">수강신청</a></li>
						<li><a href="adminFaqBoardList">FAQ</a></li>
						<li><a href="momBoardList?nowPage=1">자유게시판</a></li>
						<li><a href="parentdetail">마이페이지</a></li>
						<li><br />${sessionScope.uid }님안녕하세요~^^</li>
						<li><a href="logout">로그아웃</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="container" id="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
		</div>
	</div>
</header>
