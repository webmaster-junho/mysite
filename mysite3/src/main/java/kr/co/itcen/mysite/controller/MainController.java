package kr.co.itcen.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.mysite.service.SiteService;
import kr.co.itcen.mysite.vo.SiteVo;
import kr.co.itcen.mysite.vo.UserVo;

@Controller
public class MainController {
	@Autowired
	private SiteService siteService;
	@RequestMapping({"","/main"})
	public String index(Model model) {
		Long no=1L;
		SiteVo vo = siteService.get(no);
		System.out.println(vo);
		model.addAttribute("siteVo",vo);
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "안녕하세요!~";
	}
	@ResponseBody
	@RequestMapping("/hello2")
	public UserVo hello2() {
		UserVo vo = new UserVo();
		vo.setNo(10L);
		vo.setName("김준호");
		vo.setEmail("xjvmdutl@gmail.com");
		
		return vo;
	}
}
