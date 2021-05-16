package com.atelier.ad.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atelier.ad.service.AD_Service;
import com.atelier.common.controller.CommonController;
import com.atelier.dto.AD_MaterialDto;
import com.atelier.dto.CM_Dto;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.FT_FAQDto;
import com.atelier.dto.MG_Dto;
import com.atelier.dto.PD_productDto;
import com.atelier.dto.PageDto;


@Controller
public class AD_controller extends CommonController{
	
	@Autowired
	AD_Service aServ;

	@GetMapping("ADNotice")
	public String goADNotice() {
		log.info("goADNotice.run()");
		return "ADNotice";
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 페이징 출력
	 * 작성자: KYH
	 * 작성일 : 2019.02.01
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADNoticeList")
	public ModelAndView getADNoticeList(PageDto pageDto) {
		log.info("getADNoticeList.run()");
		return aServ.getADNoticeList(pageDto);
	}
	
	@PostMapping("ADNoticeList")
	public ModelAndView getADNoticeListWithAjax(PageDto pageDto) {
		log.info("getADNoticeListWithAjax.run()");
		return aServ.getADNoticeListWithAjax(pageDto);
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 공지사항 입력
	* 작성자: KYH
	* 작성일 : 2019.02.04
	-----------------------------------------------------------------------------------*/
	@PostMapping(value = "ADNoticeInsert", produces="application/json; charset=utf-8")
	@ResponseBody
	public int ADNoticeInsert(CO_NoticeDto ntdto) {
		log.info("ADNoticeInsert.run()");
		return aServ.ADNoticeInsert(ntdto);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 상세내용 보기
	 * 작성자: KYH
	 * 작성일 : 2019.02.04
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADNoticeContents")
	public ModelAndView adNoticeContents(Integer ntNum) {
		log.info("goADNoticeContents.run()");
		return aServ.getADNoticeDetail(ntNum);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 수정
	 * 작성자: KYH
	 * 작성일 : 2019.02.05
	 -----------------------------------------------------------------------------------*/
	@PostMapping("ADNoticeUpdate")
	@ResponseBody
	public int adNoticeUpdate(CO_NoticeDto ntdto) {
		log.info("goADNoticeUpdate.run()");
		return aServ.adNoticeUpdate(ntdto);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공지사항 삭제
	 * 작성자: KYH
	 * 작성일 : 2019.02.05
	 -----------------------------------------------------------------------------------*/
	@PostMapping("ADNoticeDelete")
	@ResponseBody
	public ModelAndView adNoticeDelete(@RequestParam(value = "NoticeChk[]") String[] deleteKeyList) {
		log.info("adNoticeDelete.run()");
		return aServ.ADNoticeDelete(deleteKeyList);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 페이징 출력 
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADFAQList")
	public ModelAndView adFAQ(PageDto pageDto) {
		log.info("goADFAQ.run()");
		return aServ.getFAQList(pageDto);
	}
	
	@PostMapping("ADFAQList")
	public ModelAndView getADFAQListWithAjax(PageDto pageDto) {
		log.info("getADFAQListWithAjax.run()");
		return aServ.getFAQListWithAjax(pageDto);
	}
	
	 /* ---------------------------------------------------------------------------------
	 * 기능: FAQ입력 기능
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@PostMapping(value = "FAQInsert", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int FAQInsert(FT_FAQDto faq) {
		log.info("FAQInsert.run()");
		return aServ.FAQInsert(faq);
		
	}
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 상세보기
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADFAQContents")
	public ModelAndView goADFAQContents(FT_FAQDto faq) {
		log.info("goADFAQContents.run()");
		return aServ.getFAQDetail(faq);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 수정
	 * 작성자: JWJ
	 * 작성일 : 2019.02.02
	 -----------------------------------------------------------------------------------*/
	@PostMapping("FAQupdate")
	@ResponseBody
	public int FAQupdate(FT_FAQDto faq) {
		log.info("FAQupdate.run()");
		return aServ.FAQupdate(faq);
	}
	/* ---------------------------------------------------------------------------------
	 * 기능: FAQ 삭제
	 * 작성자: JWJ
	 * 작성일 : 2019.02.03
	 -----------------------------------------------------------------------------------*/
	@PostMapping("delFAQ")
	public ModelAndView delFAQ(@RequestParam(value = "FAQchk[]") String[] deleteKeyList) {
		log.info("delFAQ.run()");
		return aServ.delFAQ(deleteKeyList);
	}

	/* ---------------------------------------------------------------------------------
	 * 기능: 공방회원신청서 화면으로 이동
	 * 작성자: JSG
	 * 작성일 : 2019.02.07
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADATMemberUp")
	public ModelAndView goADATMemberUp() {
		log.info("goADATMemberUp.run()");
		return aServ.getApplicant();
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공방회원신청서 결과 처리
	 * 작성자: JSG
	 * 작성일 : 2019.02.07
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ATMemberUpCheck")
	public ModelAndView atMemberUpCheck(String check, String id) {
		log.info("atMemberUpCheck.run()");
		return aServ.ATMemberCheckProc(check, id);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공방 리스트로 이동
	 * 작성자: JSG
	 * 작성일 : 2019.02.13
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADATList")
	public ModelAndView goADATList() {
		log.info("goADATList.run()");
		return aServ.ADATListProc();
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공방의 상태를 변경
	 * 작성자: JSG
	 * 작성일 : 2019.02.13
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADATListStateProc")
	public ModelAndView adATListStateProc(String id, String state, RedirectAttributes rttr, String check) {
		log.info("adATListStateProc.run()");
		return aServ.ADATListStateProc(id, state, rttr, check);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 공방을 검색 후 ADATListSearch 페이지에 출력
	 * 작성자: JSG
	 * 작성일 : 2019.02.13
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADATListSearch")
	public ModelAndView adATListSearchProc(String searchName) {
		log.info("adATListSearchProc.run()");
		return aServ.ADATListSearchProc(searchName);
	}
	
	
	@GetMapping("ADCompanyInsert")
	public String goADCompanyInsert() {
		log.info("goADCompanyInsert.run()");
		return "ADCompanyInsert";
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 원자재 등록 컨트롤러
	 * 작성자: JSH
	 * 작성일 : 2019.02.07
	 -----------------------------------------------------------------------------------*/
	@PostMapping("MaterialInsert")
	public ModelAndView materialInsert(AD_MaterialDto material, RedirectAttributes rttr) {
		log.info("materialInsert.run()");
		return aServ.MaterialInsert(material, rttr);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 원자재 리스트 출력
	 * 작성자: JSH
	 * 작성일 : 2019.02.07
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADCompany")
	public ModelAndView adCompany(Integer adcPageNum,Integer maxNum) {
		log.info("adCompany.run()");
		return aServ.getADCompanyList(adcPageNum,maxNum);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 원자재 수정 / 기존 데이터 입력
	 * 작성자: JSH
	 * 작성일 : 2019.02.10
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADCompanyFix")
	public ModelAndView adCompanyFix(Integer rmNum) {
		log.info("adCompanyFix.run()");
		return aServ.getADCompanyFix(rmNum);
	}
	
	/* ---------------------------------------------------------------------------------
	 * 기능: 원자재 수정 / 업데이트
	 * 작성자: JSH
	 * 작성일 : 2019.02.10
	 -----------------------------------------------------------------------------------*/
	@PostMapping("MaterialFix")
	public ModelAndView materialFix(AD_MaterialDto material, RedirectAttributes rttr) {
		log.info("materialFix.run()");
		return aServ.MaterialFix(material, rttr);
	}
		
	/* ---------------------------------------------------------------------------------
	 * 기능: 원자재 삭제
	 * 작성자: JSH
	 * 작성일 : 2019.02.10
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADCompanyDel")
	public ModelAndView adCompanyDel(Integer rmNum) {
		log.info("adCompanyDel.run()");
		return aServ.MaterialDel(rmNum);
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 메세지 리스트 출력
	* 작성자: KBH
	* 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
		 -----------------------------------------------------------------------------------*/
	@GetMapping("ADMessage")
	public ModelAndView goADMessage() {
		log.info("goADMessage.run()");
		CM_Dto cmDto = (CM_Dto) session.getAttribute("mb");
		return aServ.goADMessage(cmDto.getCm_id());
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 메세지 상세보기 출력
	* 작성자: KBH
	* 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------*/
	@GetMapping("ADMessageContents")
	public ModelAndView adMessagecon(Integer mgNum) {
		log.info("adMessagecon.run()");
		return aServ.ADMessagecon(mgNum);
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 메세지 상세보기에서 답장 
	* 작성자: KBH
	* 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------*/
	@GetMapping("ADmessageSendBtn")
	public ModelAndView adMessageSendBtn(MG_Dto mDto) {
		log.info("adMessageSendBtn.run()");
		return aServ.MessageSendBtn(mDto);
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 메세지 삭제
	* 작성자: KBH
	* 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------*/
	@GetMapping("delMessage")
	public ModelAndView delMessage(HttpServletRequest hs, RedirectAttributes rttr) {
		log.info("delMessage.run()");
		String[] check = hs.getParameterValues("prod");
		return aServ.delMessage(check, rttr);
	}

	/* ---------------------------------------------------------------------------------
	* 기능: 상품 리스트 전체 출력
	* 작성자: KBH
	* 작성일 : 2020.02.12 / 수정(KBH) 2020.02.13
	 -----------------------------------------------------------------------------------*/
	@GetMapping("ADProdManage")
	public ModelAndView getATProdList() {
		log.info("getATProdList.run()");
		return aServ.getADProdList();
	}

	/* ---------------------------------------------------------------------------------------
	* 기능: 상품내역 삭제 메소드 
	* 작성자: KBH
	* 작성일: 2020.02.12 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------------*/
	@GetMapping("productDelete")
	public ModelAndView productDelete(HttpServletRequest hs, RedirectAttributes rttr) {
		log.info("productDelete.run()");
		String[] check = hs.getParameterValues("prod");
		return aServ.productDelete(check,rttr);
	}

	/* ---------------------------------------------------------------------------------------
	* 기능:  상품내역 수정 메소드 중 상품상세정보 출력메소드
	* 작성자: KBH
	* 작성일: 2020.02.13
		-----------------------------------------------------------------------------------------*/
	@GetMapping("ADProdDetail")
	public ModelAndView adUpdateManager1(Integer pdCode) {
		log.info("adUpdateManager1.run()");
		return aServ.productUpdate1(pdCode);
	}

	/* ---------------------------------------------------------------------------------------
	* 기능:  상품내역 수정 메소드 중 상품상세정보 수정메소드
	* 작성자: KBH
	* 작성일: 2020.02.13
		-----------------------------------------------------------------------------------------*/
	@GetMapping("ProdUpdate")
	public ModelAndView adUpdateManager2(PD_productDto pdDto) {
		log.info("adUpdateManager2.run()");
		return aServ.productUpdate2(pdDto);
	}
	
	/* ---------------------------------------------------------------------------------------
	* 기능:  상품 검색 메소드
	* 작성자: KBH
	* 작성일: 2020.02.13
 	-----------------------------------------------------------------------------------------*/
	@GetMapping("searchProduct")
	public ModelAndView searchProc(String search) {
		log.info("searchProc.run()");
		return aServ.SearchProc(search);
	}
	
	/* ---------------------------------------------------------------------------------------
	* 기능:  마이페이지 관리자에 문의
	* 작성자: KBH
	* 작성일: 2020.02.19
		-----------------------------------------------------------------------------------------*/
	@PostMapping("AdminMessage")
	public ModelAndView adminMessage(MG_Dto mgDto) {
		log.info("adminMessage.run()");
		return aServ.AdminMessage(mgDto);
	}
}//AD_controller Class end












