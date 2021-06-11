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
										<c:forEach var="notice" items="${result.dtoList}">
											<tr>
												<td class="text-center text-muted">
													<input type="checkbox" name="NoticeChk" value="${notice.ntNum}">
												</td>
												<td class="text-center">${notice.ntNum}</td>
												<td>
													<div class="widget-content p-0" style="text-align: center;">
														<div class="widget-content-left flex2">
															<div class="widget-heading">${notice.ntTitle}</div>
														</div>
													</div>
												</td>	
												<td class="text-center">${notice.ntId}</td>	
												<td class="text-center">${notice.ntCount}</td>	
												<td class="text-center">
													<a href="ADNoticeContents?ntNum=${notice.ntNum}" onclick="window.open(this.href, '_blank', 'width=800px,height=600px,toolbars=no,scrollbars=yes');return false;">
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
					<ul class="pagination">
						<c:if test="${result.prev eq true}">
						    <li>
								<a href='ADNoticeList?page=${result.start - 1 }' >«</a>
							</li>
						</c:if>
						<c:forEach var="page" items="${result.pageList}">
							<li class="${result.page == page ? 'active' : '' }">
								<a href='ADNoticeList?page=${page }' >${page }</a>
							</li>
						</c:forEach>
						<c:if test="${result.next eq true}">
						    <li>
								<a href='ADNoticeList?page=${result.end + 1 }' >»</a>
							</li>
						</c:if>
					</ul>
					<input type="hidden" id="page" name="page" value="${result.page }"/>
					<input type="hidden" id="type" name="type" value="${pageRequestDto.type }"/>
					<input type="hidden" id="keyword" value="${pageRequestDto.keyword }"/>
				</div> 		
			</div>
			<div class="container">
				<div style="min-height: 430px;">
					<br style="clear: both">
					<form id="ADNoticeFrm" name="ADNoticeFrm">
						<div id="inputFrm" class="form-group col-md-12" style="margin-left: -50px;" >
							<div class="col-sm-10" style="padding: 0;">
								<input type="text" class="form-control"  id="ntTitle" name="ntTitle" value="${notice.ntTitle }" style="padding-right: 100px; width: 1180px;" data-saveValChk placeholder="제목">
							</div>
							<br>
							<textarea class="form-control input-sm " id="ntContents" name="ntContents"  maxlength="1000" rows="7" style="width: 1180px;" data-saveValChk placeholder="내용을 입력하세요" >${notice.ntContents }</textarea>
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
				$('#ntTitle').focus();
			}
		}
		
		function fn_insertSuccessCallback(data) {
			(data > 0) ? alert("공지사항 등록 완료!") : alert("공지사항 등록 실패!");
			fn_comAjax($("#page").val(), 'ADNoticeList', fn_attachList, '');
			$('#ntTitle').val('');
			$('#ntContents').val('');
		}
		
		//공지사항 삭제
		$("#delBtn").click(function(){
			var checkedBox = $("input[name=NoticeChk]:checked").length;
			if(checkedBox > 0) {
				if(confirm(checkedBox + "개의 목록을 삭제 하시겠습니까?")) 
					fn_comAjax(fn_formToJson($('#ADNoticeDeleteFrm')), 'ADNoticeDelete', 
						function(data) {
							alert(data.msg);
							fn_comAjax($("#page").val(), 'ADNoticeList', fn_attachList, '');
							$('#allCheck').prop("checked", false);
						}
					,'');
			} else {
				alert("삭제할 목록을 선택 해 주세요.");
			}
		});
		
		function fn_attachList(data) {
			var list = '';
			var dtoList = data.dtoList;
	
			for(var i = 0; i < dtoList.length; i++) {
				list += '<tr>' + '<td class="text-center text-muted">'
				+ '<input type="checkbox" name="NoticeChk" value="' + dtoList[i].ntNum + '">' + '</td>'
				+ '<td class="text-center">' + dtoList[i].ntNum + '</td>'
				+ '<td>'+'<div class="widget-content p-0" style="text-align: center;">'
				+ '<div class="widget-content-left flex2">'
				+ '<div class="widget-heading">' + dtoList[i].ntTitle + '</div>'
				+ '</div>'+'</div>'+'</td>'	
				+ '<td class="text-center">' + dtoList[i].ntId + '</td>'	
				+ '<td class="text-center">' + dtoList[i].ntCount + '</td>'	
				+ '<td class="text-center">'
				+ '<a href="ADNoticeContents?ntNum=' + dtoList[i].ntNum + '" onclick="window.open(this.href, "_blank", "width=800px,height=600px,toolbars=no,scrollbars=yes");return false;">'
				+ '<button type="button" class="btn btn-primary btn-sm">Details</button>'
				+ '</a>'
				+ '</td>'
				+ '</tr>'
			}
			$('#tbody').html(list); 
		}
	</script>
</html>