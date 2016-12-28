<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script>
	$(function() {
		var $tab = $('div.tabMenu>.tabGroup>li');
		var $sub = $('div.tabMenu>.subGroup>li');
		var i = 0;
		$tab.click(function() {
			i = $(this).index();
			$sub.hide();
			$sub.eq(i).show();
		});
	});
</script>
<div class="tabMenu">
	<ul class="tabGroup">
		<li>수강중인 강의</li>
		<li>수강이 완료된 강의</li>
	</ul>
	<ul class="subGroup">
		<li>substance1</li>
		<li>substance2</li>
	</ul>
</div>

