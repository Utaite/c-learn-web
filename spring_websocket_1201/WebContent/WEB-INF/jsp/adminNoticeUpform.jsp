<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div>
	<form action="adminNoticeUpdate" method="post">
		<input type="hidden" value="${n_num}" name="n_num">
		<table>
			<thead>
				<tr>
					<th colspan="3"><h2>공지사항 수정</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<th><select name="n_fix">
							<option value="0">중요X</option>
							<option value="1">중요</option>
					</select></th>
					<td><input type="text" name="n_sub" id="n_sub"
						style="width: 400px;" value="${snvo.n_sub}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="2"><textarea cols="70" rows="20" name="n_cont"
							id="n_cont">${snvo.n_cont}</textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3"><input type="submit" value="수정">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="취소"
						onclick="history.back(); return false;"></th>
				</tr>
			</tfoot>
		</table>
	</form>
</div>