package com.estsoft.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	
	
	
	// 첫 번째 방법
	@RequestMapping("/view/{no}")
	public ModelAndView view(@PathVariable("no")Long no){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("no",no);
		mav.addObject("name", "최연지");
		mav.addObject("email", "aaa@naver.com");
		mav.setViewName("/WEB-INF/views/view.jsp");

		return mav;
		// /board/view/40
	}
	
	// 두 번째 방법- request setAttribute와 비슷함. 이 방법 사용하길 권장.
	// '모델을 담을 수 있게 모델 객체를 넘겨줘'이런 뜻..
	@RequestMapping("/view2/{no}")
	public String view2(@PathVariable("no")Long no, Model model){
		model.addAttribute("no", no);
		model.addAttribute("name","최연지");
		model.addAttribute("email", "aaa@naver.com");
		 
		return "/WEB-INF/views/view.jsp";
	}

	
	//-----------------------------------------------
	public String insert(@PathVariable("no")Long no){
		System.out.println(no);
		return "redirect:/board/list";
	}
}
