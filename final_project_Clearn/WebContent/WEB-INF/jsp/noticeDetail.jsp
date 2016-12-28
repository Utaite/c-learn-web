<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: auto; width: 800px;">
	<div style="padding-bottom: 100px; padding-top: 100px;">
		<table class="table">
			<thead>
				<tr>
					<th colspan="2" style="text-align: center; font-size: 30px;">공지사항
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th colspan="2" style="text-align: left;"><h3>${snvo.n_sub }</h3></th>
				</tr>
				<tr>
					<td>작성일&nbsp;&nbsp;${snvo.n_date}</td>
					<td style="text-align: right;">조회수&nbsp;&nbsp;${snvo.n_hit}</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: right;"><input
						type="button" value="목록" onclick="location='noticeList?nowPage=1'"
						class="btn btn-default"></th>
				</tr>
				<tr>
					<td colspan="2">${snvo.n_cont }</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>