package com.atelier.ad.faq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.atelier.ad.faq.service.FaqService;
import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.FaqRequestDto;
import com.atelier.dto.responseDto.FaqResponseDto;
import com.atelier.entity.FaqEntity;
import com.atelier.validator.FaqValidator;
import com.atelier.validator.PageValidator;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes({"faq"}) 
public class FaqController {
	
	private final FaqService service;
	private FaqValidator faqValidator;
	private PageValidator pageVidator;
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 페이징 출력 
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADFAQList")
	public String adFAQ(@ModelAttribute PageRequestDto requestDto, Model model, BindingResult bindingResult) {
		this.pageVidator.validate(requestDto, bindingResult); 
		model.addAttribute("faq", new FaqRequestDto());
		model.addAttribute("result", (bindingResult.hasErrors()) ? null : service.getList(requestDto));
		return "/ad/ADFAQ.tiles";
	}
	
	@PostMapping("ADFAQList")
	@ResponseBody
	public PageResultDto<FaqResponseDto, FaqEntity> getADFAQListWithAjax(@ModelAttribute PageRequestDto requestDto, Model model, BindingResult bindingResult) {
		this.pageVidator.validate(requestDto, bindingResult); 
		return (bindingResult.hasErrors()) ? null : service.getList(requestDto);
	}
	
	 /* ---------------------------------------------------------------------------------
	 * 기능: FAQ입력 기능
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@PostMapping(value = "FAQInsert", produces = "application/json; charset=utf-8")
	@ResponseBody
	public long FAQInsert(@ModelAttribute FaqRequestDto faq , BindingResult bindingResult, SessionStatus status) {
		long result = 0L;
		this.faqValidator.validate(faq, bindingResult); // 유효성검사 (만약 컨트롤러 전체 메소드에 적용하고 싶다면 @InitBinder를 사용하자
		if(!bindingResult.hasErrors()) {
			result = service.save(faq);
			status.setComplete(); // 현재 컨트롤러에 의해 세션에 저장된 정보를 모두 제거
		}
		return result;
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 상세보기
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADFAQContents")
	public String goADFAQContents(int ftNum, Model model) {
		model.addAttribute("faq", service.getDetail(ftNum)); 
		return "/ad/ADFAQContents";
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 수정
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@PostMapping("FAQupdate")
	@ResponseBody
	public long FAQupdate(@ModelAttribute FaqRequestDto faq,  BindingResult bindingResult, SessionStatus status) {
		long result = 0L;
		this.faqValidator.validate(faq, bindingResult);
		if(!bindingResult.hasErrors()) {
			result = service.save(faq);
			status.setComplete();
		}
		return result;
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 삭제
	 * 작성자: JWJ
	 * 작성일 : 2019.02.03
	 -----------------------------------------------------------------------------------*/
	@PostMapping("delFAQ")
	public String delFAQ(@RequestParam(value = "FAQchk[]") String[] deleteKeyList, Model model) {
		service.delete(deleteKeyList);
		model.addAttribute("msg",  "FAQ 삭제 완료!" );
		return "jsonView";
	}
}
