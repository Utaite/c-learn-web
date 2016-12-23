<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- start header -->
<head>
<link href="resources/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function popupOpen() {
		var popUrl = "classdetail?ct_num=3"; //팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	}
</script>
</head>
<body>

	<header>
		<div class="navbar navbar-default navbar-static-top">
			<c:choose>
				<c:when test="${sessionScope.role == null }">
					<div align="center">
						<div class="navbar-collapse collapse " align="center">
							<ul class="nav navbar-nav">
								<li><a href="index.html"><img
										src="resources/img/main1.jpg" width="200px" height="100px"
										align="top"></a></li>
								<li><a href="member">회원가입</a></li>
								<li><a href="idsearch">id찾기</a></li>
								<li><a href="pwsearch">pw찾기</a></li>
							</ul>
						</div>
					</div>
				</c:when>
				<c:when test="${sessionScope.role eq \"user\" }">
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li><a href="index.html"><img
									src="resources/img/main1.jpg" width="200px" height="100px"
									align="top"></a></li>
							<li><a href="adminNoticeList?nowPage=1">공지사항</a></li>
							<li><a href="registerManagerList">학습하러가기</a></li>
							<li><a href="registerAddListView">수강신청</a></li>
							<li><a href="adminFaqBoardList">FAQ</a></li>
							<li><a href="momBoardList?nowPage=1">자유게시판</a></li>
							<li><a href="parentdetail">마이페이지</a></li>
						</ul>
					</div>
				</c:when>
				<c:when test="${sessionScope.role eq \"admin\" }">
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li><a href="index.html"><img
									src="resources/img/main1.jpg" width="200px" height="100px"
									align="top"></a></li>
							<li><a href="member">회원가입</a></li>
							<li><a href="adminNoticeList?nowPage=1">공지사항</a></li>
							<li><a href="adminFaqBoardList">FAQ</a></li>
							<li><a href="adminParentList?nowPage=1">부모회원관리</a></li>
							<li><a href="adminChildList?nowPage=1">자녀회원관리</a></li>
							<li><a href="momBoardList?nowPage=1">자유게시판</a></li>
							<li><a href="contChapForm">컨텐츠 등록</a>
							<li><a href=""></a>
						</ul>
					</div>
				</c:when>

			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.uid==null }">
					<li><a href="loginform">로그인 예제</a></li>
				</c:when>
				<c:otherwise>
					<li>${sessionScope.uid }님반가워용^^<a href="logout">로그아웃 예제</a></li>
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

				<!-- <div class="navbar-collapse collapse ">  
					<ul class="nav navbar-nav"> 
						<li><a href="index.html"><img src="resources/img/main1.jpg" width="200px" height="100px" align="top"></a></li>
						<li><a href="javascript:popupOpen()">열려라 팝업창</a></li>
						<li><a href="member">회원가입</a></li>
						<li><a href="idsearch">id찾기</a></li> 
						<li><a href="pwsearch">pw찾기</a></li>
						<li><a href="registerDoginList">학습하러가기</a></li>
						<li><a href="registerAddListView">수강신청</a></li>
						<li><a href="adminNoticeForm">공지사항등록</a></li>
						<li><a href="adminNoticeList?nowPage=1">공지사항리스트</a></li>
						<li><a href="adminFaqBoardList">FAQ</a></li>
				 		<li><a href="adminParentList?nowPage=1">부모회원관리</a></li>
						<li><a href="adminChildList?nowPage=1">자녀회원관리</a></li>
						<li><a href="momBoardList?nowPage=1">자유게시판</a></li>
						<li><a href="parentdetail">마이페이지</a></li>
						<li><a href="">안드로이드 연동 가자</a></li>
					</ul>
				</div>   -->
			</div>
		</div>
	</header>
</body>
<!-- end header -->
