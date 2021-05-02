package com.atelier.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@Autowired
	protected HttpSession session;
}
