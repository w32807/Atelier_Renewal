<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<div class="app-main__outer">
		<div class="app-main__inner">
			<div class="row">
				<div class="col-md-12">
					<div class="main-card mb-3 card">
						<div class="card-header">공지사항
							<span>
								<button class="btn-icon btn-icon-only btn btn-outline-danger" id="delBtn" style="margin-left: 1400px; font-weight: bolder;">
									삭제
								</button>
							</span>
							<div class="btn-actions-pane-right"></div>
						</div>
						<div class="table-responsive">
							<form action="ADNoticeDelete" method="post" id="ADNoticeDeleteFrm" name="deleteNoticeFrm">
								<table class="align-middle mb-0 table table-borderless table-striped table-hover">
									<thead>
										<tr>
											<th class="text-center"><input type="checkbox" id="allCheck"></th>
											<th class="text-center" style="width: 100px;">등록번호</th>
											<th class="text-center" style="width: 450px;">제목</th>
											<th class="text-center">작성자</th>
											<th class="text-center">조회수</th>
											<th class="text-center">상세보기</th>
										</tr>
									</thead>
									<tbody id="tbody">
										<c:forEach var="notice" items="${list}">
											<tr>
												<td class="text-center text-muted">
													<input type="checkbox" name="NoticeChk" value="${notice.nt_num}">
												</td>
												<td class="text-center">${notice.nt_num}</td>
												<td>
													<div class="widget-content p-0" style="text-align: center;">
														<div class="widget-content-left flex2">
															<div class="widget-heading">${notice.nt_title}</div>
														</div>
													</div>
												</td>	
												<td class="text-center">${notice.nt_id}</td>	
												<td class="text-center">${notice.nt_count}</td>	
												<td class="text-center">
													<a href="ADNoticeContents?ntNum=${notice.nt_num}" onclick="window.open(this.href, '_blank', 'width=800px,height=600px,toolbars=no,scrollbars=yes');return false;">
														<button type="button" class="btn btn-primary btn-sm">Details</button>
													</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="padding-left: 650px;">
				<div class="container">
					<ul class="pagination">${paging}</ul>
				</div> 		
			</div>
			<div class="container">
				<div style="min-height: 430px;">
					<br style="clear: both">
					<form id="ADNoticeFrm" name="ADNoticeFrm">
						<div id="inputFrm" class="form-group col-md-12" style="margin-left: -50px;" >
							<div class="col-sm-10" style="padding: 0;">
								<input type="text" class="form-control"  id="nt_title" name="nt_title" style="padding-right: 100px; width: 1180px;" data-saveValChk placeholder="제목">
							</div>
							<br>
							<textarea class="form-control input-sm " id="nt_contents" name="nt_contents" maxlength="500" rows="7" style="width: 1180px;" data-saveValChk placeholder="내용을 입력하세요" ></textarea>
						</div>
						<div class="d-block text-center card-footer" style="margin-left: -33px; width: 1180px;">
							<button type="button" class="btn-wide btn btn-info" onclick="noticeInsertAjax();">Save</button>
						</div>
					</form>	
				</div>
			</div>
		</div>
	</div>
		
	<script type="text/javascript">
		function noticeInsertAjax() {
			if(fn_saveValChkOfStr($('[data-saveValChk]'))){
				fn_comAjax(fn_formToJson($("#ADNoticeFrm")), 'ADNoticeInsert'
						, fn_insertSuccessCallback, function() {alert("공지사항 등록 실패!");});
			}else{
				alert("제목 혹은 내용을 확인 해 주세요.");
				$('#nt_title').focus();
			}
		}
		
		function fn_insertSuccessCallback(data) {
			if(data > 0) alert("공지사항 등록 완료!");
			fn_comAjax($("#pageNum").val(), 'ADNoticeList', fn_attachList, '');
			$('#nt_title').val('');
			$('#nt_contents').val('');
		}
		
		//공지사항 삭제
		$("#delBtn").click(function(){
			var checkedBox = $("input[name=NoticeChk]:checked").length;
			if(checkedBox > 0) {
				if(confirm(checkedBox + "개의 목록을 삭제 하시겠습니까?")) 
					fn_comAjax(fn_formToJson($('#ADNoticeDeleteFrm')), 'ADNoticeDelete', 
						function(data) {
							alert(data.msg);
							fn_comAjax($("#pageNum").val(), 'ADNoticeList', fn_attachList, '');
							$('#allCheck').prop("checked", false);
						}
					,'');
			} else {
				alert("삭제할 목록을 선택 해 주세요.");
			}
		});
		
		function fn_attachList(data) {
			var ntlist = '';
	
			for(var i = 0; i < data.list.length; i++) {
				ntlist += '<tr>' + '<td class="text-center text-muted">'
				+ '<input type="checkbox" name="NoticeChk" value="' + data.list[i].nt_num + '">' + '</td>'
				+ '<td class="text-center">' + data.list[i].nt_num + '</td>'
				+ '<td>'+'<div class="widget-content p-0" style="text-align: center;">'
				+ '<div class="widget-content-left flex2">'
				+ '<div class="widget-heading">' + data.list[i].nt_title + '</div>'
				+ '</div>'+'</div>'+'</td>'	
				+ '<td class="text-center">' + data.list[i].nt_id + '</td>'	
				+ '<td class="text-center">' + data.list[i].nt_count + '</td>'	
				+ '<td class="text-center">'
				+ '<a href="ADNoticeContents?ntNum=' + data.list[i].nt_num + '" onclick="window.open(this.href, "_blank", "width=800px,height=600px,toolbars=no,scrollbars=yes");return false;">'
				+ '<button type="button" class="btn btn-primary btn-sm">Details</button>'
				+ '</a>'
				+ '</td>'
				+ '</tr>'
			}
			$('#tbody').html(ntlist); 
		}
	</script>
</html>