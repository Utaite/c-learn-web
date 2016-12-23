<%@page import="or.clearn.service.FcmService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String msg = request.getParameter("msg");
	String p_token = request.getParameter("p_token");
	FcmService fs = new FcmService();
	fs.sendDataType1(p_token, msg);
%>
<body>
	알림이 정상적으로 전송되었습니다.
	<br />전송된 푸쉬 메시지를 확인하세요!
</body>