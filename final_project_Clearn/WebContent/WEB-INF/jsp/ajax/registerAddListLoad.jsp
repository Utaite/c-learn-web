<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.0.min.js"></script>
<script type="text/javascript">
	// 상세보기 버튼을 클릭하면 실행되는 함수
	function popupOpen(ct_num) {
		/* console.log("ct_num : "+ct_num); */
		var popUrl = "classdetail?ct_num="+ct_num; //팝업창에 출력될 페이지 URL
		var popOption = "width=570, height=560, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	}
	
	$(function(){
		// insertClassMany라는 아이디를 가진 버튼을 클릭하면 동작하는 함수
		$('#insertClassMany').click(function(){
			// confirm 창을 실행시킨다.
			var result = confirm('수강신청을 하시겠습니까?');
			// 변수 p_num에 p_num이라는 아이디의 값을 가져온다.
			var p_num = $("#p_num").val();
			// 변수 p_token에 p_token이라는 아이디의 값을 가져온다.
			var p_token = $("#p_token").val();
			// 변수 ct_num_ary라는 변수에 배열을 선언한다.
			var ct_num_ary = [];
			// input 태그 중에서 name이라는 속성이 ckd이고 선택이 되어있는 것들을 each문을 사용해서 값이 없을 때까지 가져온다.
		    $("input[name='ckd']:checked").each(function(i) {
		    	// 가져온 값들을 ct_num_ary에 넣는다.
		       ct_num_ary.push($(this).val());
		    });
			// 이 페이지에서 전달하고 싶은 모든 데이터의 값들을 넣는다.
			var allData = { "p_num": p_num, "ct_num_ary": ct_num_ary, "p_token" :p_token};
			// 만약 (result에 대한 질문에 예를 클릭했으면)
			if(result){
				// 아래의 ajax를 실행한다.
					//({
						// url : 에 insertClass라는 주소를 넣어 선택한 값들에 대하여 등록한다.
						// type :에는 여러가지가 있는데 'post' 방식을 선택했다.
						// data : { 등록하고 싶은 값들을 작성해서 전달한다. }
						// success : data 값의 전달이 성공이면 실행된다.
						// 성공시 confirm 창을 실행시키고 예를 클릭하면 수강중인 강의 페이지로 이동한다.
						// error : 실패시 
						// alert("에러 발생~~ \n" + textStatus + " : " + errorThrown)
						// 라는 경고 창을 띄운다.
					//})
				 $.ajax({
        			url:'insertClass',
        			type:'post',
        			data: {p_num : p_num, ct_num_ary : ct_num_ary, p_token : p_token},
        			success:function(data){
        				if(confirm('수강신청 완료! 마이페이지로 이동하시겠습니까')){
        					location.replace('registerManagerList');
        				}
        			},
        			error:function(jqXHR, textStatus, errorThrown){
            			alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
        			}
    			});
			}
		});
	});
	
	function insertClassSelect(){
		// 사용자 ID를 갖고 온다.
	    var userId = $("#userId").val();
	 	
	    // name이 같은 체크박스의 값들을 배열에 담는다.
	    var checkboxValues = [];
	    $("input[name='hobby']:checked").each(function(i) {
	        checkboxValues.push($(this).val());
	    }); 
	}
</script>
<div>
	<form method="post">
		<input type="hidden" value="${cc_num }" name="cc_num"> <input
			type="hidden" value="${sessionScope.p_token }" name="p_token"
			id="p_token"> <input type="hidden"
			value="${sessionScope.p_num }" name="p_num" id="p_num">
		<table class="table">
			<c:forEach var="listv" items="${list }">
				<tr>
					<td><input type="checkbox" name="ckd" value="${listv.ct_num }">&nbsp;&nbsp;${listv.ct_sub }
					</td>
					<td>${listv.cnt}강/(${listv.ct_period }일)</td>
					<td><input type="button" value="상세보기"
						onclick="javascript:popupOpen(${listv.ct_num})"
						class="btn btn-info"></td>
				</tr>
				<tr>
					<td colspan="2">☆ ${listv.ct_star }점</td>
					<td>수강수 : ${listv.ct_hit }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="수강신청" id="insertClassMany"
			class="btn btn-danger">
	</form>
	<br />
</div>

