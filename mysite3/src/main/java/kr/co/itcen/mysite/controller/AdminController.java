package kr.co.itcen.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.itcen.mysite.security.Auth;
import kr.co.itcen.mysite.service.AdminService;
import kr.co.itcen.mysite.vo.GuestBookVo;
import kr.co.itcen.mysite.vo.SiteVo;

@Controller
@RequestMapping("/admin")//예측할수 없게 적어주어야한다
@Auth("ADMIN")
public class AdminController {
	//site라는 테이블을 만들어서 db을 내용을 읽어서 main페이지를 세팅해주어야한다,
	@Autowired
	private AdminService adminService;
	@RequestMapping("")
	public String main(Model model) {
		Long no = 1L;
		SiteVo vo=adminService.get(no);
		model.addAttribute("siteVo",vo);
		return "admin/main";
	}
	@RequestMapping(value="/main/update",method = RequestMethod.POST)
	public String mainupdate(SiteVo vo,@RequestParam(value = "file",required = false) MultipartFile multipartFile){
		String url=adminService.store(multipartFile);
		vo.setProfileURL(url);
		adminService.updatemain(vo);
		return "redirect:/";
	}
	@RequestMapping("/guestbook")
	public String guestbook(Model model) {
		List<GuestBookVo> list = adminService.getList();
		model.addAttribute("list",list);
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
}