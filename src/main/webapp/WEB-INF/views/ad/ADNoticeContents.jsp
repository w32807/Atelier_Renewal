<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Atelier | Admin</title>
</head>
<link href="./resources/ADATList/css/main.css" rel="stylesheet">
<script type="text/javascript" src="resources/assets/scripts/main.js"></script>
<script src="./resources/main/js/jquery-3.3.1.min.js" /></script>
<script src="./resources/js/common.js" /></script>

<body style="background-color:lightblue;">
	<!-- Modal HTML embedded directly into document -->
	<div class="container" style="text-align:center;">
		<div>
			<br style="clear: both">
			<div class="form-group col-md-12 " style="margin-left: -50px;">
				<div>
					<input type="hidden" value="작성자">
					<input type="hidden" value="조회수">
					<input type="hidden" value="날짜">
				</div>
				<form id="ADNoticeUpdateFrm" method="post">
					<div class="col-sm-10" style="padding: 0;">
						<input type="hidden" name="nt_num" value="${ntdto.nt_num}">
						<input type="text" id="nt_title" name="nt_title" class="form-control" value="${ntdto.nt_title}" style="padding-right: 100px; width: 750px;" readonly>
					</div>
					<br>
					<textarea class="form-control input-sm " readonly="readonly" id="nt_contents" name="nt_contents" maxlength="140" rows="15" style="width: 750px;">${ntdto.nt_contents}</textarea>
				</form>	
			</div>
			<div class="d-block text-center card-footer" style="margin-left: -33px; width: 750px;">
				<button class="btn-wide btn btn-info" id="saveBtn" style="display: none;">Save</button>
				<button class="btn-wide btn btn-info" id="closeBtn" onclick="window.close();" style="background-color: #d92550; border: #d92550;">Close</button>
				<button class="btn-wide btn btn-warning" id="modifyBtn">수정</button>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$("#modifyBtn").click(function() {
		$("#nt_title").removeAttr('readonly');	//선택한 요소의 특정 속성 제거
		$("#nt_contents").removeAttr('readonly');	//선택한 요소의 특정 속성 제거
		$("#saveBtn").show();
		$("#closeBtn").hide();
	})
	
	$("#saveBtn").click(function(e) {
		var ntTitle = $("#nt_title").val();
		var ntContents = $("#nt_contents").val();
		
		if(!isStrNull(ntTitle)) alert("제목을 입력해주세요");
		if(!isStrNull(ntContents)) alert("내용을 입력해주세요");
		
		fn_comAjax(fn_formToJson($("form")), 'ADNoticeUpdate', fn_successSave, fn_errorSave);

	});
	
	function fn_successSave(data) {
		if(data > 0){
			alert("공지사항 수정 완료!");
			opener.parent.location.reload();
			window.close();
		}else{
			fn_errorSave();
		}
	}
	
	function fn_errorSave() {
		alert("공지사항 수정 실패!");
	}
</script>

</html>