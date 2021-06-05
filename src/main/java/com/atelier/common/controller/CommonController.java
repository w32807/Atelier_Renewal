package com.atelier.common.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CommonController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpSession session;
}
