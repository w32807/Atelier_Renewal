package com.atelier.ad.coNotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atelier.ad.coNotice.service.CoNoticeService;
import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.CoNoticeRequestDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;

@Controller
public class CoNoticeController {
	private CoNoticeService service;
	
	public CoNoticeController(CoNoticeService service) {
		this.service = service;
	} 
	
	@GetMapping("ADNotice")
	public String goADNotice() {
		return "ADNotice";
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 페이징 출력
	 * 작성자: KYH
	 * 작성일 : 2019.02.01
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADNoticeList")
	public String getADNoticeList(PageRequestDto requestDto, Model model) {
		// PageRequestDto가 생성되면서 컨트롤러로 들어오기 때문에, 바인딩 될 값이 없으면 new PageRequestDto와 동일하다.
		model.addAttribute("result", service.getList(requestDto));
		return "/ad/ADNoticeList.tiles";
	}
	
	@PostMapping("ADNoticeList")
	public String getADNoticeAjaxList(PageRequestDto requestDto, Model model) {
		model.addAttribute("result", service.getList(requestDto));
		return "jsonView";
	}
	
	/* ---------------------------------------------------------------------------------
	* 기능: 공지사항 입력
	* 작성자: KYH
	* 작성일 : 2019.02.04
	-----------------------------------------------------------------------------------*/
	@PostMapping(value = "ADNoticeInsert", produces="application/json; charset=utf-8")
	@ResponseBody
	public long ADNoticeInsert(CoNoticeRequestDto dto) {
		return service.insert(dto);
	}
}
