<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<style>
#container {
	width: 800px;
	margin: auto;
}

.name {
	width: 200px;
	text-align: center;
}
</style>
<div id="container">
	<form action="momBoardAdd" method="post" class="form-horizontal">
		<input type="hidden" name="p_num" id="p_num"
			value="${sessionScope.p_num }">
		<table class="table">
			<thead>
				<tr>
					<th colspan="3" style="text-align: center;"><h2>맘 게시판</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th class="name">제 목</th>
					<td><input type="text" name="ib_sub" id="ib_sub"
						style="width: 400px;"></td>
				</tr>

				<tr>
					<th class="name">내 용</th>
					<td colspan="2"><textarea cols="70" rows="20" name="ib_cont"
							id="ib_cont"></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3" style="text-align: center;"><input
						type="submit" value="등록" class="btn btn-default">
						&nbsp;&nbsp; <input type="button" value="취소"
						onclick="location='momBoardList?nowPage=1'"
						class="btn btn-default"></th>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<!-- 로그인 시 p넘을 세션에 넣었다가 가져온다? -->