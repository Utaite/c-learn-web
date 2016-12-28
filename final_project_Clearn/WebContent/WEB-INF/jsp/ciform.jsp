<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div>
	<P align="center">
		<FONT size="6"><B>정보 등록 및 관리</B></FONT>
	</P>
	<form action="childadd" method="post" id="jooin">
		<table>
			<div>
				<a href="member">부모 회원가입<img src="resources/img/h.jpg" width="250px" height="250px"></a>
				<a href="children">자녀등록<img src="resources/img/child.jpg" width="250px" height="250px"></a> 
				<a href="parentdetail">마이페이지
				<img src="resources/img/m.jpg" width="250px" height="250px"></a>
			<p>chk : ${sessionScope.p_num } </p>
			</div>
		</table>
	</form>
</div>