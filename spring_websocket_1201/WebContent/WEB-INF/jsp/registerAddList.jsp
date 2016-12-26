<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		var $tab = $('div.tabMenu>.tabGroup>li');
		var $sub = $('div.tabMenu>.subGroup>li');
		var i = 0;

		$('#tab1').show();
		$('#subTab1').load('registerAddListLoad?cc_num=3');
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
		$('#tab1').click(function() {
			$('#subTab1').load('registerAddListLoad?cc_num=3');
		});

		$('#tab2').click(function() {
			$('#subTab2').load('registerAddListLoad?cc_num=1');
		});
		$('#tab3').click(function() {
			$('#subTab3').load('registerAddListLoad?cc_num=2');
		});
	});
</script>
<div class="tabMenu">
	<ul style="list-style: none;" class="tabGroup">
		<li id="tab1"><a>한글</a></li>
		<li id="tab2"><a>수학</a></li>
		<li id="tab3"><a>영어</a></li>
	</ul>
	<ul class="subGroup">
		<li id="subTab1"></li>
		<li id="subTab2"></li>
		<li id="subTab3"></li>
	</ul>
</div>
