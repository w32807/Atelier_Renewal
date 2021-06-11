package com.atelier.ad.coNotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atelier.ad.coNotice.service.CoNoticeService;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.CoNoticeRequestDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.validator.CoNoticeValidator;
import com.atelier.validator.PageValidator;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
//모델 정보 중에서 세션에 담고 싶은 클래스를 선언
// 1. @ModelAttribute를 쓰면 해당 클래스의 앞글자만 소문자로 바꾼 key로 세션에 저장
// 2. Model에 직접 담으면 model에 담은 key로 세션에 저장 
// >> 즉 Model에 담긴 Key가 @SessionAttributes의 key로 저장된다.
// 만약 컨트롤러를 들어올 때, 세션에 해당 키로 가져올 객체가 없으면 오류
@SessionAttributes({"notice"}) 
public class CoNoticeController {
	private CoNoticeService service;
	private CoNoticeValidator coNoticeValidator;
	private PageValidator pageVidator;
	
	@GetMapping("ADNotice")
	public String goADNotice() {
		return "ADNotice";
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 페이징 출력
	 * 작성자: KYH
	 * 작성일 : 2019.02.01.
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADNoticeList")
	public String getADNoticeList(@ModelAttribute PageRequestDto requestDto, Model model, BindingResult bindingResult) {
		this.pageVidator.validate(requestDto, bindingResult); 
		model.addAttribute("notice", new CoNoticeRequestDto());
		model.addAttribute("result", (bindingResult.hasErrors()) ? null : service.getList(requestDto));
		return "/ad/ADNoticeList.tiles";
	}
	
	@PostMapping("ADNoticeList")
	@ResponseBody
	public PageResultDto<CoNoticeResponseDto, CoNoticeEntity> getADNoticeAjaxList(@ModelAttribute PageRequestDto requestDto, Model model, BindingResult bindingResult) {
		this.pageVidator.validate(requestDto, bindingResult); 
		return (bindingResult.hasErrors()) ? null : service.getList(requestDto);
	}
	
	/* ---------------------------------------------------------------------------------
	* 기능: 공지사항 입력
	* 작성자: KYH
	* 작성일 : 2019.02.04
	-----------------------------------------------------------------------------------*/
	@PostMapping(value = "ADNoticeInsert", produces="application/json; charset=utf-8")
	@ResponseBody 
	public long ADNoticeInsert(@ModelAttribute CoNoticeRequestDto notice, BindingResult bindingResult, SessionStatus status) {
		long result = 0L;
		this.coNoticeValidator.validate(notice, bindingResult); // 유효성검사 (만약 컨트롤러 전체 메소드에 적용하고 싶다면 @InitBinder를 사용하자
		if(!bindingResult.hasErrors()) {
			result = service.save(notice);
			status.setComplete(); // 현재 컨트롤러에 의해 세션에 저장된 정보를 모두 제거
		}
		return result;
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 상세내용 보기
	 * 작성자: KYH
	 * 작성일 : 2019.02.04
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADNoticeContents")
	public String adNoticeContents(int ntNum, Model model) {
		model.addAttribute("notice", service.getDetail(ntNum)); 
		return "/ad/ADNoticeContents";
	}

	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 수정
	 * 작성자: KYH
	 * 작성일 : 2019.02.05
	 -----------------------------------------------------------------------------------*/
	@PostMapping(value = "ADNoticeUpdate", produces="application/json; charset=utf-8")
	@ResponseBody
	public long adNoticeUpdate(@ModelAttribute CoNoticeRequestDto notice,  BindingResult bindingResult, SessionStatus status) {
		long result = 0L;
		this.coNoticeValidator.validate(notice, bindingResult);
		if(!bindingResult.hasErrors()) {
			result = service.save(notice);
			status.setComplete(); // 현재 컨트롤러에 의해 세션에 저장된 정보를 모두 제거
		}
		return result;
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 삭제
	 * 작성자: KYH
	 * 작성일 : 2019.02.05
	 -----------------------------------------------------------------------------------*/
	@PostMapping("ADNoticeDelete")
	public String adNoticeDelete(@RequestParam(value = "NoticeChk[]") String[] deleteKeyList, Model model) {
		service.delete(deleteKeyList);
		model.addAttribute("msg",  "공지사항 삭제 완료!" );
		return "jsonView";
	}
}
