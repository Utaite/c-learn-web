<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		var $trigger2 = $("tbody > tr > td");
		var $content2 = $("tbody > .f_cont");
		$content2.hide();
		$('#target1').load("adminFaqBoardListLoad .data1");
		$('#target2').load("adminFaqBoardListLoad .data2");
		$('#target3').load("adminFaqBoardListLoad .data3");
		$('#target4').load("adminFaqBoardListLoad .data4");
		$('#target5').load("adminFaqBoardListLoad .data5");		
		$trigger2.click(function() {
			var $this = $(this).parent();
			$content2.slideUp(150);
			if ($this.next().is(":hidden")) {
				$trigger2.each(function(i){
					$this.next().eq(i).slideDown(150);
				});
			}
		});

	});
</script>
<!--  jqEx12_listview -->
<div>
	<table>
		<thead class="table">
			<tr>
				<th><h2>FAQ °Ô½ÃÆÇ</h2></th>
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