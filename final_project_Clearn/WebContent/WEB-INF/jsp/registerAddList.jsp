<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		var $tab = $('div.tabMenu>.tabGroup>li');
		var $sub = $('div.tabMenu>.subGroup>li');
		var i = 0;

		// 한글 탭을 보여준다.
		$('#tab1').show();
		// 한글 탭의 색을 빨강으로
		$('#tab1').css('color', 'red');
		// 수학 탭의 색을 검정으로
		$('#tab2').css('color', 'black');
		// 영어 탭의 색을 검정으로 보여준다.
		$('#tab3').css('color', 'black');
		// 한글 리스트를 로드한다.
		$('#subTab1').load('registerAddListLoad?cc_num=3');
		// 수학 리스트와 영어 리스트를 감춘다.
		$('#subTab2').hide();
		$('#subTab3').hide();

		$tab.click(function() {
			i = $(this).index();
			$sub.hide();
			$sub.eq(i).show();
		});
	});
</script>
<script>
	$(function() {
		// 한글 탭을 클릭하면
		$('#tab1').click(function() {
			// 한글 리스트를 로드한다.
			$('#subTab1').load('registerAddListLoad?cc_num=3');
			// 한글 탭의 색을 빨강으로
			$('#tab1').css('color', 'red');
			// 수학 탭의 색을 검정으로
			$('#tab2').css('color', 'black');
			// 영어 탭의 색을 검정으로 보여준다.
			$('#tab3').css('color', 'black');
		});
		// 수학 탭을 클릭하면
		$('#tab2').click(function() {
			// 수학 리스트를 로드한다.
			$('#subTab2').load('registerAddListLoad?cc_num=1');
			// 수학 탭의 색을 빨강으로
			$('#tab2').css('color', 'red');
			// 한글 탭의 색을 검정으로
			$('#tab1').css('color', 'black');
			// 영어 탭의 색을 검정으로 보여준다.
			$('#tab3').css('color', 'black');
		});
		// 영어 탭을 클릭하면
		$('#tab3').click(function() {
			// 영어 리스트를 로드한다.
			$('#subTab3').load('registerAddListLoad?cc_num=2');
			// 영어 탭의 색을 빨강으로
			$('#tab3').css('color', 'red');
			// 한글 탭의 색을 검정으로
			$('#tab1').css('color', 'black');
			// 수학 탭의 색을 검정으로 보여준다.
			$('#tab2').css('color', 'black');
		});
	});
</script>
<style>
.tabMenu {
	width: 1000px;
}
</style>
<div class="tabMenu">
	<ul style="list-style: none;" class="tabGroup">
		<li id="tab1" style="float: left; border: 1px solid; font-size: 20px;">&nbsp;&nbsp;&nbsp;한글&nbsp;&nbsp;&nbsp;</li>
		<li id="tab2" style="float: left; border: 1px solid; font-size: 20px;">&nbsp;&nbsp;&nbsp;수학&nbsp;&nbsp;&nbsp;</li>
		<li id="tab3" style="float: left; border: 1px solid; font-size: 20px;">&nbsp;&nbsp;&nbsp;영어&nbsp;&nbsp;&nbsp;</li>
	</ul>
	<ul style="list-style: none;" class="subGroup">
		<li id="subTab1"></li>
		<li id="subTab2"></li>
		<li id="subTab3"></li>
	</ul>
</div>
