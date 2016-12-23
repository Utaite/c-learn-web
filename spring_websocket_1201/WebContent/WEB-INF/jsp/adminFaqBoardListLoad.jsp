<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>  
	<table class="table">
		<tbody>
			<c:forEach var="listv" items="${list}">
				<tr class="f_cont">
					<th colspan="2" class="data${listv.f_num }">${listv.f_cont}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>