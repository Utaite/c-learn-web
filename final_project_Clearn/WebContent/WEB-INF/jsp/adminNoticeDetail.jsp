<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function noticeDelete(n_num,nowPage) {
		if(confirm("정말로 삭제 하시겠습니까?")){
			location="adminNoticeDelete?n_num=" + n_num + "&nowPage=" + nowPage;
		}
	}
</script>
<div>
	<table>
		<thead>
			<tr>
				<th colspan="2" style="text-align: left; font-size: 30px;">공지사항</th>
			</tr>
			<tr>
				<th colspan="2" style="text-align: left; font-size: 15px;">공지사항을
					알려드립니다.</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="2" style="text-align: left;"><h2>${snvo.n_sub }</h2></th>
			</tr>
			<tr>
				<td>작성일&nbsp;&nbsp;${snvo.n_date}</td>
				<td style="text-align: right;">조회수&nbsp;&nbsp;${snvo.n_hit}</td>
			</tr>
			<tr>
				<th colspan="2" style="text-align: right;"><input type="button"
					value="목록" onclick="location='adminNoticeList?nowPage=1'"></th>
			</tr>
			<tr>
				<td colspan="2">${snvo.n_cont }</td>
			</tr>
		</tbody>
		<tfoot>
			<th colspan="2"><input type="button" value="수정"
				onclick="location='adminNoticeUpform?n_num=${n_num}'"> <input
				type="button" value="삭제" onclick="noticeDelete(${n_num},${nowPage})"></th>
		</tfoot>
	</table>
</div>