package com.estsoft.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	
	// /user/join
	@RequestMapping("/join")
	@ResponseBody
	public String join(){
		return "UserController.join()";
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
