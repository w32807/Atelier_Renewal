package com.atelier.ad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atelier.common.service.CommonService;
import com.atelier.dao.AD_Dao;
import com.atelier.dao.AM_Dao;
import com.atelier.dao.AT_Dao;
import com.atelier.dao.CM_Dao;
import com.atelier.dao.MG_Dao;
import com.atelier.dao.NT_Dao;
import com.atelier.dao.PD_Dao;
import com.atelier.dto.AD_MaterialDto;
import com.atelier.dto.AG_Dto;
import com.atelier.dto.AM_Dto;
import com.atelier.dto.AT_Dto;
import com.atelier.dto.CM_Dto;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.FT_FAQDto;
import com.atelier.dto.MG_Dto;
import com.atelier.dto.PD_productDto;
import com.atelier.dto.PageDto;
import com.atelier.util.AD_MaterialPaging;
import com.atelier.util.PD_Paging;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Transactional(value = "mybatisTxManager")
public class AD_Service {
	ModelAndView mav;

	@Autowired
	CommonService commonServ;

	@Autowired
	AD_Dao aDao;
	
	@Autowired
	NT_Dao ntDao;
	
	@Autowired
	AT_Dao atDao;
	
	@Autowired
	CM_Dao cmDao;
	
	@Autowired
	AM_Dao amDao;
	
	@Autowired
	PD_Dao pdDao;
	
	@Autowired
	MG_Dao mDao;
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 페이징 출력
	  * 작성자: KYH
	  * 작성일 : 2019.02.01
	  -----------------------------------------------------------------------------------*/
	@Transactional(value = "mybatisTxManager", readOnly = true)
	public ModelAndView getADNoticeList(PageDto pageDto) {
		mav = new ModelAndView("/ad/ADNoticeList.adminTiles");
		mav.addObject("list", ntDao.getADNoticeList(setPageDto(pageDto, ntDao.getADNoticeCount(), "ADNoticeList")));
		mav.addObject("paging", pageDto.makeHtmlPaging());
		
		return mav;
	}
	
	public ModelAndView getADNoticeListWithAjax(PageDto pageDto) {
		mav = new ModelAndView("jsonView");
		mav.addObject("list", ntDao.getADNoticeList(setPageDto(pageDto, ntDao.getADNoticeCount(), "ADNoticeList")));
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 입력 및 출력
	  * 작성자: KYH
	  * 작성일 : 2019.02.04
	  -----------------------------------------------------------------------------------*/
	public int ADNoticeInsert(CO_NoticeDto ntDto) {
		// 추후 트랜잭션 처리 필요
		// 임시 아이디로 문자열 지정(추후 세션에서 받아오도록 수정하기)
		ntDto.setNt_id("admin");
		return ntDao.ADNoticeInsert(ntDto);
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 상세내용 보기
	  * 작성자: KYH
	  * 작성일 : 2019.02.04
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getADNoticeDetail(Integer ntNum) {
		mav = new ModelAndView("/ad/ADNoticeContents");
		mav.addObject("ntdto", ntDao.getADNoticeDetail(ntNum));
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 수정
	  * 작성자: KYH
	  * 작성일 : 2019.02.05
	  -----------------------------------------------------------------------------------*/
	public int adNoticeUpdate(CO_NoticeDto ntdto) {
		return ntDao.ADNoticeUpdate(ntdto);
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 삭제
	  * 작성자: KYH
	  * 작성일 : 2019.02.05
	  -----------------------------------------------------------------------------------*/
	public ModelAndView ADNoticeDelete(String[] deleteKeyList) {
		mav = new ModelAndView("jsonView");
		int result = ntDao.ADNoticeDelete(deleteKeyList);

		mav.addObject("result", result);
		mav.addObject("msg",  (result > 0) ? "공지사항 삭제 완료!" : "삭제된 데이터가 없습니다.");
		
		return mav;
	}
	
	 /* ---------------------------------------------------------------------------------
	  * 기능: FAQ 페이징 출력
	  * 작성자: JWJ
	  * 작성일 : 2019.02.02
	  -----------------------------------------------------------------------------------*/
	@Transactional(value = "mybatisTxManager", readOnly = true)
	public ModelAndView getFAQList(PageDto pageDto) {
		mav = new ModelAndView("/ad/ADFAQ.adminTiles");
		mav.addObject("list", aDao.getFAQList(setPageDto(pageDto, aDao.getFAQCount(), "ADFAQ")));
		mav.addObject("paging", pageDto.makeHtmlPaging());
		
		return mav;
	}

	public ModelAndView getFAQListWithAjax(PageDto pageDto) {
		mav = new ModelAndView("jsonView");
		mav.addObject("list", aDao.getFAQList(setPageDto(pageDto, aDao.getFAQCount(), "getFAQList")));
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	* 기능: FAQ입력 및 출력(ajax)
	* 작성자: JWJ
	* 작성일 : 2019.02.02
	-----------------------------------------------------------------------------------*/
	public int FAQInsert(FT_FAQDto faq) {
		// 임시 아이디로 문자열 지정(추후 세션에서 받아오도록 수정하기)
		faq.setFt_id("admin");
		return aDao.FAQInsert(faq);
	}

	 /* ---------------------------------------------------------------------------------
	  * 기능: FAQ 상세내용 출력
	  * 작성자: JWJ
	  * 작성일 : 2019.02.02
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getFAQDetail(FT_FAQDto faq) {
		mav = new ModelAndView("ad/ADFAQContents");
		mav.addObject("faq",aDao.getFAQDetail(faq.getFt_num()));
		
		return mav;
	}

	 /* ---------------------------------------------------------------------------------
	  * 기능: FAQ 수정
	  * 작성자: JWJ
	  * 작성일 : 2019.02.02
	  -----------------------------------------------------------------------------------*/
	public int FAQupdate(FT_FAQDto faq) {
		return aDao.FAQupdate(faq);
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: FAQ 삭제
	  * 작성자: JWJ
	  * 작성일 : 2019.02.03
	  -----------------------------------------------------------------------------------*/
	@Transactional(value = "mybatisTxManager")
	public ModelAndView delFAQ(String[] deleteKeyList) {
		mav = new ModelAndView("jsonView");
		int result = aDao.delFAQ(deleteKeyList);

		mav.addObject("result", result);
		mav.addObject("msg",  (result > 0) ? "FAQ 삭제 완료!" : "삭제된 데이터가 없습니다.");
		
		return mav;
	}
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 등록 서비스
	  * 작성자: JSH
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	public ModelAndView MaterialInsert(AD_MaterialDto material, RedirectAttributes rttr) {
		mav = new ModelAndView();
		String view = null;
		log.warn("원자재 등록 서비스 시작");

		try {
				aDao.materialInsert(material);
				view= "redirect:ADCompany";
				rttr.addFlashAttribute("check", "원자재가 등록되었습니다.");
			} catch (Exception e) {
				view = "redirect:ADCompanyInsert";
				rttr.addFlashAttribute("check", "fail");
			}
		mav.setViewName(view);
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 리스트 출력
	  * 작성자: JSH
	  * 작성일 : 2019.02.07
	  * 수정일 : 2019.02.19(리스트 삭제시에도 10개의 리스트씩 나오도록 설정)
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getADCompanyList(Integer adcPageNum,Integer maxNum) {
		log.warn("원자재 리스트 서비스 시작");
		
		mav = new ModelAndView();
		
		int num = (adcPageNum == null) ? 1 : adcPageNum;
		maxNum = aDao.getRMCount();
		
		Map<String, Integer> pageInt = new HashMap<String, Integer>();
		pageInt.put("adcPageNum", num);
		pageInt.put("maxNum", maxNum);
		List<AD_MaterialDto> adcList = aDao.getADCompanyList(pageInt);
		mav.addObject("adcList", adcList);
		mav.addObject("ADCPaging", getADCPaging(num));
		
		mav.setViewName("ADCompany");
		commonServ.getHttpSession().setAttribute("adcPageNum", num);
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 리스트 출력 / 페이징 처리
	  * 작성자: JSH
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	private Object getADCPaging(int num) {
		int maxNum = aDao.getADCompanyCount();
		int listCount = 10;
		int pageCount = 2;
		
		String listName = "ADCompany";
		AD_MaterialPaging AD_MaterialPaging = new AD_MaterialPaging(maxNum, num, listCount, pageCount, listName);
		String pagingHtml = AD_MaterialPaging.makeHtmlPaging();
		
		return pagingHtml;
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: 공방 신청서의 항목을 DB에서 불러와 ADATMemeberUp.jsp에 출력
	  * 작성자: JSG
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getApplicant() {
		mav = new ModelAndView();
		List<AG_Dto> AGList = atDao.getATRegistUserData();
		
		mav.addObject("AGList", AGList);
		mav.setViewName("ADATMemberUp");
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: 신청서 항목에서 수락, 거절 버튼 클릭에 따른 분기 처리 
	  * 작성자: JSG
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	public ModelAndView ATMemberCheckProc(String check, String id) {
		// TODO Auto-generated method stub
		//String s = null;
		mav = new ModelAndView();
		
		// 수락 버튼을 누르면
		if(check.equals("true")) {
			assentATMember(id);
		}
		// 거절 버튼을 누르면
		else {
			DeleteATMember(id);
		}
		System.out.println("fuck");
		mav = getApplicant();
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공방 수락하여 신청자의 정보를 공방회원 테이블(AM)에 저장 후 신청서 테이블(AG)에서 항목 삭제
	  * 작성자: JSG
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	public void assentATMember(String id) {
		CM_Dto cm_Member = cmDao.getMemberInfo(id);
		AG_Dto ag_Member = atDao.getATRegistMember(id);
		AM_Dto am_Member = new AM_Dto();
		AT_Dto at_dto = new AT_Dto();
		
		cm_Member.setCm_state("공방회원");
		
		cmDao.userStateChange(cm_Member);
		
		// AM 테이블에 데이터 삽입
		am_Member.setAm_id(ag_Member.getAg_id());
		am_Member.setAm_name(ag_Member.getAg_at_name());
		am_Member.setAm_phone(ag_Member.getAg_phone());
		am_Member.setAm_addr(cm_Member.getCm_addr());
		am_Member.setAm_sns(ag_Member.getAg_snsaddr());
		am_Member.setAm_cate1(ag_Member.getAg_cate1());
		am_Member.setAm_cate2(ag_Member.getAg_cate2());
		am_Member.setAm_cate3(ag_Member.getAg_cate3());
		
		amDao.insertNewATMember(am_Member);
		
		// AT 테이블에 데이터 삽입
		at_dto.setAt_id(ag_Member.getAg_id());
		at_dto.setAt_name(ag_Member.getAg_at_name());
		at_dto.setAt_phone(ag_Member.getAg_phone());
		at_dto.setAt_addr(cm_Member.getCm_addr());
		at_dto.setAt_snsaddr(ag_Member.getAg_snsaddr());
		at_dto.setAt_cate1(ag_Member.getAg_cate1());
		at_dto.setAt_cate2(ag_Member.getAg_cate2());
		at_dto.setAt_cate3(ag_Member.getAg_cate3());
		at_dto.setAt_logo("default.png");
		atDao.insertATData(at_dto);
		DeleteATMember(id);
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공방신청서(AG) DB에서 항목을 삭제
	  * 작성자: JSG
	  * 작성일 : 2019.02.07
	  -----------------------------------------------------------------------------------*/
	public void DeleteATMember(String id) {
		atDao.deleteAGRequest(id);
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 수정 / 기존 데이터 출력
	  * 작성자: JSH
	  * 작성일 : 2019.02.10
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getADCompanyFix(Integer RM_NUM) {
		mav = new ModelAndView();
		AD_MaterialDto admDto = aDao.getADMaterial(RM_NUM);
		
		mav.addObject("admDto", admDto);
		mav.setViewName("ADCompanyFix");
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 수정 / 업데이트
	  * 작성자: JSH
	  * 작성일 : 2019.02.10
	  -----------------------------------------------------------------------------------*/
	public ModelAndView MaterialFix(AD_MaterialDto material, RedirectAttributes rttr) {
		mav = new ModelAndView();
		String view = null;
		
		log.warn("원자재 등록 서비스 시작");

		try {
				aDao.materialFix(material);
				view= "redirect:ADCompany";
				rttr.addFlashAttribute("check", "원자재가 등록되었습니다.");
			} catch (Exception e) {
				view = "redirect:ADCompanyInsert";
				rttr.addFlashAttribute("check", "fail");
			}
		mav.setViewName(view);
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 원자재 삭제
	  * 작성자: JSH
	  * 작성일 : 2019.02.10
	  -----------------------------------------------------------------------------------*/
	public ModelAndView MaterialDel(Integer RM_NUM) {
		mav = new ModelAndView();
		log.warn("원자재 삭제 서비스 시작");
		aDao.delADMaterial(RM_NUM);
		mav.setViewName("redirect:ADCompany");

		return mav;
	}

	/* ---------------------------------------------------------------------------------
	 * 기능: 메세지 리스트 출력
	 * 작성자: KBH
	 * 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
		  -----------------------------------------------------------------------------------*/
	public ModelAndView goADMessage(String mg_receiver) {
		mav = new ModelAndView();
		String view = null;

		List<MG_Dto> bList = aDao.getADMessageList(mg_receiver);
		mav.addObject("bList", bList);
		mav.setViewName("ADMessage");
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------
	 * 기능: 메세지 상세보기 출력
	 * 작성자: KBH
	 * 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------*/
		public ModelAndView ADMessagecon(Integer mg_num) {
		
		mav = new ModelAndView();
		String view = null;
		
		try {
			MG_Dto mgDto = aDao.getADMessageContents(mg_num);
			mav.addObject("mgDto", mgDto);
			mDao.ChangeCheck(mgDto.getMg_num());
			mav.setViewName("ADMessageContents");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

		/* ---------------------------------------------------------------------------------
		 * 기능: 메세지 상세보기에서 답장 
		 * 작성자: KBH
		 * 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
		-----------------------------------------------------------------------------------*/
		public ModelAndView MessageSendBtn(MG_Dto mDto) {
		  mav = new ModelAndView();
		  String view = null;
		  String mg_receiver = mDto.getMg_sender();
		  log.warn(mDto.getMg_receiver()+","+mDto.getMg_sender());
		  
		  try {
			  aDao.ADSendMessage(mDto);
			  view =  "forward:ADMessage";
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  mav.setViewName(view);
		  
		  return mav; 
	}

	/* ---------------------------------------------------------------------------------
	 * 기능: 메세지 삭제
	 * 작성자: KBH
	 * 작성일 : 2020.02.11 / 수정(KBH) 2020.02.13
	-----------------------------------------------------------------------------------*/
	@Transactional(value = "mybatisTxManager")
	public ModelAndView delMessage(String[] check, RedirectAttributes rttr) {
		mav = new ModelAndView();
		
		for(String hs : check) {
			aDao.delMessage(hs);
		}
		rttr.addFlashAttribute("check","삭제 완료!");
		mav.setViewName("redirect:ADMessage");
		
		return mav;
	}
	

	/* ---------------------------------------------------------------------------------
	 * 기능: 상품 리스트 전체 출력
	 * 작성자: KBH
	 * 작성일 : 2020.02.12 / 수정(KBH) 2020.02.13
	  -----------------------------------------------------------------------------------*/
	public ModelAndView getADProdList() {
		mav = new ModelAndView();
		List<PD_productDto> pd = aDao.getADProdList();
		mav.addObject("pd", pd);
		mav.setViewName("ADProdManage");
		
		return mav;
	}
	
	/*-----------------------------------------------------------------------------
	 *  	기능: 상품삭제 Paging 처리 
	 *  	작성자: KBH 
	 *  	작성일 : 2020.02.12
	 * ----------------------------------------------------------------------------- */
	private Object getADProdPaging(int num) {
		// 전체 글 개수 구하기(from DB)
		int maxNum = pdDao.getATProdListCount();
		int listCount = 10; // 페이지 당 글 개수
		int pageCount = 5; // 그룹 당 페이지 개수
		String listName = "ATProdManage";
		PD_Paging paging = new PD_Paging(maxNum, num, listCount, pageCount, listName);
		String pagingHtml = paging.makeHtmlPaging();

		return pagingHtml;
	}

	/* ---------------------------------------------------------------------------------------
	 * 기능: 상품내역 삭제 메소드 
	 * 작성자: KBH
	 * 작성일: 2020.02.12 / 수정(KBH) 2020.02.13
	 -----------------------------------------------------------------------------------------*/
	public ModelAndView productDelete(String[] check, RedirectAttributes rttr) {
		mav = new ModelAndView();
		
		try {
			for(int i=0; i<check.length; i++ ) {
				aDao.productDelete(check[i]);
			mav.setViewName("redirect:ADProdManage");	
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("error");
		}
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------------
	 * 기능:  상품내역 수정 메소드 중 상품상세정보 출력메소드
	 * 작성자: KBH
	 * 작성일: 2020.02.13
		 -----------------------------------------------------------------------------------------*/
	public ModelAndView productUpdate1(Integer pd_code) {
		mav = new ModelAndView();
		PD_productDto pdDto = aDao.ProductUpdate1(pd_code);
		mav.addObject("pd",pdDto);
		mav.setViewName("ADProdDetail");
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------------
	 * 기능:  상품내역 수정 메소드 중 상품상세정보 수정메소드
	 * 작성자: KBH
	 * 작성일: 2020.02.13
		 -----------------------------------------------------------------------------------------*/
	public ModelAndView productUpdate2(PD_productDto pdDto) {
		mav = new ModelAndView();
		try {
			aDao.ProductUpdate2(pdDto);
				mav.setViewName("redirect:ADProdManage");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: 공방의 전체 리스트를 가져 옴
	  * 작성자: JSG
	  * 작성일 : 2019.02.13
	  -----------------------------------------------------------------------------------*/
	public ModelAndView ADATListProc() {
		mav = new ModelAndView();
		List<AT_Dto>at_list = atDao.getATList();
		
		mav.addObject("at_list", at_list);
		mav.setViewName("ADATList");
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공방의 상태를 활성 / 비활성 으로 변경
	  * 작성자: JSG
	  * 작성일 : 2019.02.13
	-----------------------------------------------------------------------------------*/
	public ModelAndView ADATListStateProc(String id, String state, RedirectAttributes rttr, String check) {
		String view = null;
		AT_Dto at_dto = new AT_Dto();

		if(state.equals("active")) {
			at_dto.setAt_id(id);
			at_dto.setAt_state("활성");
			
			atDao.updateATState(at_dto);
			if(check.equals("true")) {
				mav = ADATListProc();
			}
			else {
				String SearchName = (String)commonServ.getHttpSession().getAttribute("search");
				mav = ADATListSearchProc(SearchName);
			}
			
			rttr.addFlashAttribute("check","해당 공방이 활성화 되었습니다.");
		}
		else {
			at_dto.setAt_id(id);
			at_dto.setAt_state("비활성");
			
			atDao.updateATState(at_dto);
			
			if(check.equals("true")) {
				mav = ADATListProc();
			}
			else {
				String SearchName = (String)commonServ.getHttpSession().getAttribute("search");
				mav = ADATListSearchProc(SearchName);
			}
			rttr.addFlashAttribute("check","해당 공방이 비활성화 되었습니다.");
		}
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------
	  * 기능: 검색된 공방의 리스트를 출력
	  * 작성자: JSG
	  * 작성일 : 2019.02.13
	-----------------------------------------------------------------------------------*/
	public ModelAndView ADATListSearchProc(String searchName) {
		AT_Dto at_dto = new AT_Dto();
		commonServ.getHttpSession().setAttribute("search", searchName);
		at_dto.setAt_name(searchName);
		List<AT_Dto>at_list = atDao.getATListSearch(at_dto);
		mav.addObject("at_list", at_list);
		mav.setViewName("ADATListSearch"); 
		
		return mav;
	}

	/* ---------------------------------------------------------------------------------------
	 * 기능:  상품 검색 메소드
	 * 작성자: KBH
	 * 작성일: 2020.02.13
 	-----------------------------------------------------------------------------------------*/
		public ModelAndView SearchProc(String search) {
		mav = new ModelAndView();
		List<PD_productDto> pd = aDao.SearchProc(search);
		
		mav.addObject("pd",pd);
		mav.setViewName("ADProdManage");
		
		return mav;
	}
	
	public ModelAndView AdminMessage(MG_Dto mgDto) {
		mav = new ModelAndView();
		String view = null;
		try {
			aDao.setADMessage();
		}catch(Exception e) {
			
		}
		
		return mav;
	}
	
	/* ---------------------------------------------------------------------------------
	  * 기능: 공지사항 리스트를 얻어오기 위한 PageDto 셋팅
	  * 작성자: JWJ
	  * 작성일 : 2021.05.09
	  -----------------------------------------------------------------------------------*/
	private PageDto setPageDto(PageDto pageDto, int maxNum, String listName) {
		//pageDto.setMaxNum(ntDao.getADNoticeCount());
		//pageDto.setListName("ADNoticeList");
		pageDto.setMaxNum(maxNum);
		pageDto.setListName(listName.trim());
		return pageDto;
	}
}//AD_Service Class end





