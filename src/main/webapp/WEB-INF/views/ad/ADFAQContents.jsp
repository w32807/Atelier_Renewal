<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Atelier | Admin</title>
		<link href="./resources/ADATList/css/main.css" rel="stylesheet">
		<script type="text/javascript" src="resources/assets/scripts/main.js"></script>
		<script src="./resources/main/js/jquery-3.3.1.min.js" /></script>
		<script src="./resources/js/common.js" /></script>
	</head>
	<body style="background-color:lightblue;">
		<div class="container" style="text-align:center;">
			<div>
			    <br style="clear: both">
				<div class="form-group col-md-12 " style="margin-left: -50px;">
					<div>
					    <input type="hidden" value="작성자">
					    <input type="hidden" value="조회수">
					    <input type="hidden" value="날짜">
					</div>
					<form id="FAQupdateFrm" >
				        <input type="hidden" name="ftNum" value="${faq.ftNum}">
						<div class="col-sm-10" style="padding: 0;">
							<input type="text" class="form-control"  id="title"  name="ftTitle"  value="${faq.ftTitle}" readonly="readonly" style="padding-right: 100px; width: 750px;">
						</div>
						<br>
						<textarea class="form-control input-sm"  readonly="readonly" id="contents" maxlength="140" rows="15" name="ftContents" style="width: 750px;" >${faq.ftContents}</textarea>
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
	        $("#title").removeAttr('readonly');
	        $("#contents").removeAttr('readonly');         
			$("#saveBtn").show();
			$("#closeBtn").hide();
	    });
	                        
		$("#saveBtn").click(function(e) {
			if(!isStrNull($("#title").val())) {
				alert("제목을 입력해주세요");
				$("#contents").focus();
				return false;
			}
			
			if(!isStrNull($("#contents").val())) {
				alert("내용을 입력해주세요");
				$("#contents").focus();
				return false;
			}
			
			fn_comAjax(fn_formToJson($("form")), 'FAQupdate', fn_successSave, fn_errorSave);
		});
		
		function fn_successSave(data) {
			if(data > 0){
				alert("FAQ 수정 완료!");
				opener.parent.location.reload();
				window.close();
			}else{
				fn_errorSave();
			}
		}
		
		function fn_errorSave() {
			alert("FAQ 수정 실패!");
		}
	</script>
</html>