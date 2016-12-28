<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="resources/vendor/bootstrap/css/style.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet" />
<style>
li img{width: 100%; height: 120px;}
button {
	width: 100%;
}
</style>
<div class="navbar navbar-default navbar-static-top"
	style="background-image: url('resources/menubar/menubar.jpg'); height: 125px;">
	<c:choose>
		<c:when test="${sessionScope.uid == null }">
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">


					<li><button onclick="location='loginform'">
							<img src="resources/menubar/login.jpg">
						</button></li>
					<li><button onclick="location='member'">
							<img src="resources/menubar/user.jpg">
						</button></li>
					<li><button onclick="location='idsearch'">
							<img src="resources/menubar/findid.jpg">
						</button></li>
					<li><button onclick="location='pwsearch'">
							<img src="resources/menubar/findpwd.jpg">
						</button></li>
				</ul>
			</div>
		</c:when>
		<c:when test="${sessionScope.role eq \"admin\" }">
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">
					<li><button onclick="location='adminNoticeList?nowPage=1'">
							<img src="resources/menubar/notice.jpg">
						</button></li>
					<li><button onclick="location='adminFaqBoardList'">
							<img src="resources/menubar/faqboard.jpg">
						</button></li>
					<li><button onclick="location='adminParentList?nowPage=1'">
							<img src="resources/menubar/p_userManager.jpg">
						</button></li>
					<li><button onclick="location='adminChildList?nowPage=1'">
							<img src="resources/menubar/c_userManager.jpg">
						</button></li>
					<li><button onclick="location='momBoardList?nowPage=1'">
							<img src="resources/menubar/momBoard.jpg">
						</button></li>
					<li><button onclick="location='contChapForm'">
							<img src="resources/menubar/contentAdd.jpg">
						</button></li>
					<li><button onclick="location='logout'">
							<img src="resources/menubar/logout.jpg">
						</button></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">
				<li><button onclick="location='noticeList?nowPage=1'">
							<img src="resources/menubar/notice.jpg">
						</button></li>
					<li><button onclick="location='registerManagerList'">
							<img src="resources/menubar/registerList.jpg">
						</button></li>
					<li><button onclick="location='registerAddListView'">
							<img src="resources/menubar/registerAdd.jpg">
						</button></li>
					<li><button onclick="location='adminFaqBoardList'">
							<img src="resources/menubar/faqboard.jpg">
						</button></li>
					<li><button onclick="location='momBoardList?nowPage=1'">
							<img src="resources/menubar/momBoard.jpg">
						</button></li>
					<li><button onclick="location='parentdetail'">
							<img src="resources/menubar/mypage.jpg">
						</button></li>
					<li><button onclick="location='logout'">
							<img src="resources/menubar/logout.jpg">
						</button></li>
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