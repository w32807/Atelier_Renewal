package com.atelier.common.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CommonServiceImpl implements CommonService{
	
	@Autowired 
	private HttpSession session;
	
	@Override
	public HttpSession getHttpSession() {
		return this.session;
	}

}
