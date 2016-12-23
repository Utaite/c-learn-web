<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		var $tab = $('div.tabMenu>.tabGroup>li');
		var $sub = $('div.tabMenu>.subGroup>li');
		var i = 0;
		
		$('#registerDoing').show();
		$('#registerDoingList').load('registerDoginList');
		$('#registerDoneList').hide();
		
		$tab.click(function() {
			i = $(this).index();
			$sub.hide();
			$sub.eq(i).show();
		});
	});
</script>
<script>
$(function(){
	$('#registerDoing').click(function(){
		$('#registerDoingList').load('registerDoginList');
	});
	
 	$('#registerDone').click(function(num) {
 		$('#registerDoneList').load('registerDoneList');
 	});
});
</script>
<div class="tabMenu">
<input type="hidden" value="${sessionScope.p_num }" name="p_num">
	<ul class="tabGroup">
		<li id="registerDoing">수강중인 강의</li>
		<li id="registerDone">수강 완료된 강의</li>
	</ul>
	<ul class="subGroup">
		<li id="registerDoingList"></li>
		<li id="registerDoneList"></li>
	</ul>
</div>
