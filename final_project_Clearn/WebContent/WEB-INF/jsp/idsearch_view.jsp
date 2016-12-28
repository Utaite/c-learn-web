<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-1.9.0rc1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0rc1.js"></script>
<script>
	var answer = "";
	function check_code(){
		console.log("answer : "+answer);
		console.log("element : "+document.getElementById("answer_input").value);
		if(document.getElementById("answer_input").value === answer){
			location.href='get_id?p_mail='+document.getElementById("p_mail").value;
		} else {
			alert('인증번호가 틀렸습니다.');
		}
	} 
	$(function() {
		$('#code_req').click(function() {
			var p_name = encodeURIComponent($('#p_name').val());
			var p_mail = encodeURIComponent($('#p_mail').val());
			$.ajax({
				url : 'findid',
				type : 'post',
				data : {p_name, p_mail},
				success : function(msg){
					msg = msg.replace(/(^\s*)|(\s*$)/ig,'').replace(/\n/ig,'');
					console.log("msg값 : "+msg);
					if(msg===""){
						alert('가입된 정보가 없습니다. ');
					} else {
					$('#code_input').html("인증번호 : <input type=\"text\" id=\"answer_input\" name=\"answer_input\"> <input type=\"button\" id=\"ck_answer\" name=\"ck_answer\" value=\"확인\" onclick=\"check_code()\" >");
					answer = msg;
					}
				}
			})
		});
		
	 	
		
		$('#ck_answer').click(function() {
			if ($('#answer_input').val() == answer) {
				$(location).attr('href', "findid_result");
			} else {
				confirm('인증번호가 틀렸습니다.');
			}
		});
	});
</script>
<style>
#contnent {
	width: 800px;
	margin: auto;
}
</style>
<div id="contnent">
	<div style="color: #000000; background-color: #ffffff; padding-top: 150px; padding-bottom: 150px;">
		이름 &nbsp;<input type="text" id="p_name" name="p_name">&nbsp;&nbsp; 이메일 &nbsp;<input
			type="email" id="p_mail" name="p_mail">&nbsp;&nbsp;&nbsp; <input type="button"
			value="인증번호 요청" id="code_req" class="btn btn-danger" style="background:pink; color: black;">
			<br/><br/>
		<div id="code_input"></div>
	</div>
</div>