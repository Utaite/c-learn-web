<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>classdetail</title>
</head>
<body>
	<h2>제목 : ${vo.ct_sub }</h2>
	<h3>총 ${chapternum }강/${vo.ct_period }일</h3>
	<p>설명 : ${vo.ct_detail }</p>
	목차
	<table>
		<tr>
			<th>제목</th>
			<th>재생시간</th>
		</tr>
	<c:forEach var="listv" items="${list }">
		<tr>
			<td>${listv.ch_sub}</td>
			<td>${listv.ch_time}</td>
		</tr>
	</c:forEach>
	</table>
	<h2> 별점 : ${vo.ct_star }</h2> 
	<input type="button" value="닫기" onclick="window.close()"></input>
</body>
</html>