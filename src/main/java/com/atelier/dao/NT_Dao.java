package com.atelier.dao;

import java.util.List;

import com.atelier.dto.AT_NT_Dto;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.PageDto;

public interface NT_Dao {
	public List<CO_NoticeDto> getADNoticeList(PageDto pageDto);

	public int getADNoticeCount();

	public CO_NoticeDto getADNoticeDetail(Integer ntNum);

	public int ADNoticeInsert(CO_NoticeDto ntdto);

	public int ADNoticeUpdate(CO_NoticeDto ntdto);

	public int ADNoticeDelete(String[] deleteKeyList);
	//공방 공지사항 인터페이스
	public boolean noticeWrite(AT_NT_Dto ntDto);

	public List<AT_NT_Dto> getList(List<AT_NT_Dto> ntList);

	public int getBoardCount();

	public boolean upView(Integer at_nt_num);

	public AT_NT_Dto getContents(Integer at_nt_num);

	public boolean delNoticeContents(Integer at_nt_num);

	public List<AT_NT_Dto> getNtList(String at_nt_id);

}