<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
	$(function() {
		var $tab = $('div.tabMenu>.tabGroup>li');
		var $sub = $('div.tabMenu>.subGroup>li');
		var i = 0;
		// 수강중인 강의 탭을 보여준다.
		$('#registerDoing').show();
		// 수강중인 강의 리스트를 로드한다.
		$('#registerDoingList').load('registerDoginList');
		// 수강중인 강의 탭의 글자색을 빨강색으로
		$('#registerDoing').css('color', 'red');
		// 수강 완료된 강의 탭의 글자색을 검색색으로 보여준다.
		$('#registerDone').css('color', 'black');
		// 수강 완료된 강의 탭을 숨긴다.
		$('#registerDoneList').hide();

		// 탭을 클릭하면
		$tab.click(function() {
			// 탭의 수만큼 보여준다.
			i = $(this).index();
			// 목록을 감춘다.
			$sub.hide();
			// 목록의 수만큼 보여준다.
			$sub.eq(i).show();
		});
	});
</script>
<script>
	$(function() {
		// 수강중인 강의 탭을 클릭하면
		$('#registerDoing').click(function() {
			// 수강중인 강의 리스트를 로드하고
			$('#registerDoingList').load('registerDoginList');
			// 수강중인 강의 탭의 색은 빨강색으로 보여주고
			$('#registerDoing').css('color', 'red');
			// 수강 완료된 강의 탭의 색은 검정색으로 보여준다.
			$('#registerDone').css('color', 'black');
		});
		// 수강 완료된 강의 탭을 클릭하면
		$('#registerDone').click(function(num) {
			// 수강 완료된 강의 리스트를 로드한다.
			$('#registerDoneList').load('registerDoneList');
			// 수강 중인 강의 탭의 색을 검정색으로 보여준다.
			$('#registerDoing').css('color', 'black');
			// 수강 완료된 강의 탭의 색을 빨강색으로 보여준다.
			$('#registerDone').css('color', 'red');
		});
	});
</script>
<div class="tabMenu" style="width: 1000px;">
	<input type="hidden" value="${sessionScope.p_num }" name="p_num">
	<ul style="list-style: none;" class="tabGroup">
		<li id="registerDoing"
			style="float: left; border: 1px solid; font-size: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;수강중인
			강의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li id="registerDone"
			style="float: left; border: 1px solid; font-size: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;수강
			완료된 강의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
	</ul>
	<ul style="list-style: none;" class="subGroup">
		<li id="registerDoingList"></li>
		<li id="registerDoneList"></li>
	</ul>
</div>
