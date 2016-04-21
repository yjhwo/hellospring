package com.estsoft.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estsoft.hellospring.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/joinform")
	public String joinform(){
		return "/WEB-INF/views/joinform.jsp";
	}
	
	// /user/join
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVo){
		System.out.println(userVo);
		
		// DAO를 통해서 business작업
		return "redirect:/main";
		// application context 생략
	}
	
	@RequestMapping("/loginform")
	@ResponseBody
	public String loginform(){
		return "UserController.loginform()";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(){
		return "UserController.login()";
	}
}
