<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		// 변수 $trigger2를 선언
		var $trigger2 = $("tbody > tr > td");
		// 변수 $content2를 선언
		var $content2 = $("tbody > .f_cont");
		// 답변을 숨겨놓는다.
		$content2.hide();
		// (tbody > .f_cont (target1,2,3,4,5))에 adminFaqBoardListLoad .data1,2,3,4,5를 로드한다.
		$('#target1').load("adminFaqBoardListLoad .data1");
		$('#target2').load("adminFaqBoardListLoad .data2");
		$('#target3').load("adminFaqBoardListLoad .data3");
		$('#target4').load("adminFaqBoardListLoad .data4");
		$('#target5').load("adminFaqBoardListLoad .data5");
		// 변수 $trigger2 : 질문을 클릭
		$trigger2.click(function() {
			// var $this = tbody > tr
			var $this = $(this).parent();
			// tbody > .f_cont를 보여준다.
			$content2.slideUp(150);
			// 만약 그 다음 것을 누르면 전에 보여준 것은 닫는다.
			if ($this.next().is(":hidden")) {
				$trigger2.each(function(i) {
					$this.next().eq(i).slideDown(150);
				});
			}
		});
	});
</script>
<!--  jqEx12_listview -->
<div style="width: 800px; margin: auto;">
	<table class="table">
		<thead>
			<tr>
				<th colspan="2" style="text-align: center;"><h2>FAQ 게시판</h2></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listv" items="${list}">
				<tr>
					<td colspan="2">${listv.f_sub}</td>
				</tr>
				<tr class="f_cont">
					<th colspan="2" id="target${listv.f_num }"></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>