<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 
<head> 
 
<%-- <%   --%> 
<!-- // 	session.setAttribute("uid", "사용자3"); -->
<%-- %> --%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Contents Enroll</title>
<script type="text/javascript" src="/js/jquery-1.3.2.js"></script>
<script> 
	var rn = 0;
	function addRow() {
		var oRow = dyntbl1.insertRow();
		oRow.onmouseover = function() {
			dyntbl1.clickedRowIndex = this.rowIndex
		}; 
		var oCell1 = oRow.insertCell();
		var oCell2 = oRow.insertCell();
		var oCell3 = oRow.insertCell();
		var oCell4 = oRow.insertCell();
		/* oCell1.innerHTML = "<input type=text name=list["+rn"].ch_sub>"; */
		oCell1.innerHTML = "<input type=text name=ch_sub>";
		oCell2.innerHTML = "<input type=number name=ch_time>"+'분';
		oCell3.innerHTML = "<input type=file name=chap_file>";
		oCell4.innerHTML = "<input type=button value=\" X \" onClick=\"delRow()\">";
	}
	function delRow() {
		dyntbl1.deleteRow(dyntbl1.clickedRowIndex);
	}
	// n수 많큼 행 추가 
	function addRowCnt() {
		//var ln = document.getElementById("dyntbl1").rows.length;
		var ln = 2; //n
		for (i = 0; i < ln; i++) {
			addRow();
		}
	}
	// 모든 행 삭제
	function delRowAll() {
		var ln = document.getElementById("dyntbl1").rows.length;
		for (i = 0; i < ln; i++) {
			delRow();
		}
	}
</script>


<style type="text/css">
p {
	font-size: 25px;
	font-weight: bold;
}

.table {
	font-size: 17px;
	font-weight: bolder;
}
</style>
</head>
<body>
	<div style="width: 500px">
		<br>
		<p align="center" id="sub">컨텐츠/강의 추가</p>
		<form method="post" action="insertRegister" enctype="multipart/form-data">
			<table border="0px" class="table">
				<tr>
					<td>강의제목 :</td>
					<td><input type="text" name="ct_sub">
						&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>과목 :</td>
					<td><select name="cc_num">
							<option value="">선택</option>
							<option value="1">한글</option>
							<option value="2">산수</option>
							<option value="3">영어</option>
					</select></td>
				</tr>
				<tr>
					<td>강의설명 :</td>
					<br>
					<td><textarea rows="2" cols="60" name="ct_detail"></textarea></td>
				</tr>
				<tr>
					<td>강의기간 :</td>
					<td> <select name="ct_period">
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
					<option value="50">50</option></select>
					일</td>

				</tr>
			</table>


			<br>

			<table id="dyntbl1" border=1>
				<tr>
					<th>챕터명</th>
					<th>강의시간</th>
					<th>영상첨부</th>
					<th><input type=button value=" + " onClick="addRow()"></th>
				</tr>
				 <tr onMouseOver="dyntbl1.clickedRowIndex=this.rowIndex">
					<td><input type=text name=ch_sub></td>
					<td><input type=number name=ch_time>분</td>
					<td><input type=file name=chap_file></td>
					<td><input type=button name=dyntbl1_delRow value=" X "
						onClick="delRow()"></td>
				</tr>
			</table>
			<br>
			<p align="center"> 
				<input type="submit" value="저장">
			</p>
		</form>
	</div>
</body>