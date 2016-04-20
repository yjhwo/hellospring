package com.estsoft.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// *****
	@RequestMapping("/list")
	@ResponseBody
	public String list(String kwd, @RequestParam("p")int page){	//p의 값이 page에 들어온다.
	//추천	public String list(@RequestParam("kwd")String keyword, @RequestParam("p")int page){
		System.out.println(page+":"+kwd);
		return "BoardController:list()";
	}
	// /board/list?p=10&kwd=11
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam(value="no", required=true,defaultValue="-1")Long no){
		System.out.println(no);
		return "BoardController:delete()";
	}
	// required를 해주면 no값이 없어도 괜찮다. true하면 값이 반드시 있어야 함.

	@RequestMapping("/view/{no}")
	@ResponseBody
	public String view(@PathVariable("no")Long no){
		System.out.println(no);
		return "BoardController:view()";
	}
	
	//-----------------------------------------------
	public String insert(@PathVariable("no")Long no){
		System.out.println(no);
		return "redirecd:/board/list";
	}
}
