package com.atelier.ad.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atelier.ad.service.AD_Service;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.FT_FAQDto;
import com.atelier.dto.PageDto;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AD_RestController {

	@Autowired
	AD_Service aServ;
	
 	 /* ---------------------------------------------------------------------------------
 	  * 기능: FAQ입력 및 출력 기능
 	  * 작성자: JWJ
 	  * 작성일 : 2019.02.02
 	  -----------------------------------------------------------------------------------*/

	@PostMapping(value = "FAQInsert", produces = "application/json; charset=utf-8")
	public Map<String, List<FT_FAQDto>> FAQInsert(FT_FAQDto faq, Integer pageNum, Integer maxNum) {
		Map<String, List<FT_FAQDto>> faqmap = aServ.FAQInsert(faq,pageNum,maxNum);
		
		return faqmap;
		
	}
}//AD_RestController Class end
