package com.atelier.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
	private int pageNum;
	private int maxNum;
	private String listName;
	
	private final int listCount = 10; //페이지 당 글 갯수
	private final int pageCount = 5; // 그룹 당 페이지 갯수
	// PageDto가 만들어질 때 기본세팅
	public PageDto() {
		this(1, 0, "");
	}
	
	public PageDto(int pageNum, int maxNum, String listName) {
		this.pageNum = pageNum;
		this.maxNum = maxNum;
		this.listName = listName;
	}
	
	public String makeHtmlPaging() {
		int totalPage = (maxNum % listCount > 0 )? maxNum/listCount+1 : maxNum/listCount;
		int currentGroup = (pageNum % pageCount)  > 0 ? pageNum/pageCount + 1 : pageNum/pageCount;
		
		return makeHtml(totalPage,currentGroup);
	}
	
	private String makeHtml(int totalPage, int currentGroup) {
		StringBuffer sb = new StringBuffer();
		int start = (currentGroup * pageCount)- (pageCount - 1);
		int end = (currentGroup * pageCount >= totalPage) ? totalPage : currentGroup * pageCount;
		
		if(start != 1) {
			sb.append("<li>");
			sb.append("<a href='" + listName + "?pageNum=" +(start-1) + "'>");
			sb.append("«");	
		}
		
		for(int i = start; i<=end;i++) {
			if(pageNum != i) {
				sb.append("<li ><a href='" + listName + "?pageNum=" + i + "'>" + i +"</a></li>");
			}
			else {
				sb.append("<li class='active' ><a href='#href' >"+ i +"</a></li>");
				sb.append("<input type='hidden' id='pageNum' value='"+ i +"'>");
			}
		}
			
		if(end != totalPage) {
			sb.append("<li><a href='" + listName + "?pageNum=" +(end+1) + "'>");
			sb.append("»");		
			sb.append("</a></li>");
		}
		return sb.toString();
	}
}
