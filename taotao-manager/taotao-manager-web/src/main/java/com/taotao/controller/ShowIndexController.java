package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShowIndexController {
	
	/**
	 * 显示首页的controller
	 * @author 23237
	 *
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/*
	 * 显示其他页面信息
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
}
