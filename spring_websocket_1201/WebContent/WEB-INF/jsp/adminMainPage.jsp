<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<style>
#rr { 100%;
	
}

#wrap {
	width: 90%;
	margin: auto;
	text-align: center;
	margin-top: 125px;
}

#goNotice {
	background-image: url("resources/img/Chrysanthemum.jpg");
	width: 300px;
	height: 500px;
}

#goFaqBoard {
	background-image: url("resources/img/Desert.jpg");
	width: 300px;
	height: 500px;
}

#goCheckMail {
	background-image: url("resources/img/Hydrangeas.jpg");
	width: 300px;
	height: 500px;
}

#go {
	background-image: url("resources/img/Jellyfish.jpg");
	width: 300px;
	height: 500px;
}
</style>
<div id="rr">
	<div id="wrap">
		<input type="button" id="goNotice" onclick="location='adminNoticeList?nowPage=1'">
		<input type="button" id="goFaqBoard" onclick="location='adminFaqBoardList'">
		<input type="button" id="goCheckMail" onclick="location='adminParentList?nowPage=1'">
		<input type="button" id="go" onclick="location='adminChildList?nowPage=1'">
	</div>
</div>