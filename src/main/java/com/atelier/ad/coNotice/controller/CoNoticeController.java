package com.atelier.ad.coNotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atelier.ad.coNotice.service.CoNoticeService;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.PageDto;

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
}
