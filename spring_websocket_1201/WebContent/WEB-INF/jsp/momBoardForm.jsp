<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div> 
	<%
		session.setAttribute("p_id", "user1");
		session.setAttribute("p_pw", "test00");
	%>

	<form action="momBoardAdd" method="post">
		<table>
			<thead>   
				<tr>
					<th colspan="3"><h2>"맘 게시판"</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>제 목</th>

					<td><input type="text" name="ib_sub" id="ib_sub"
						style="width: 400px;"></td>
				</tr>

				<tr>
					<th>내 용</th>
					<td colspan="2"><textarea cols="70" rows="20" name="ib_cont"
							id="ib_cont"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="p_num" id="p_num"
						value="5"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3"><input type="submit" value="등록">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="취소"
						onclick="location='momBoardList?nowPage=1'"></th>
				</tr>
			</tfoot>
		</table> 
	</form>
</div>

<!-- 로그인 시 p넘을 세션에 넣었다가 가져온다? -->