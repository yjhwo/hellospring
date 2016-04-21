package com.estsoft.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// POJO
@Controller
public class HelloController {
	// method마다 mapping 1개씩 하는 게 정상
	
	@RequestMapping("/hello")
	public String hello(){
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/main")
	@ResponseBody
	public String main(){
		
		return "main";
	}
	// ResponseBody 붙여준 이유는 Debugging 하기 쉬우라고 그냥...
	// return 보내준 이유는 객체로 보내주기 위해서
}
