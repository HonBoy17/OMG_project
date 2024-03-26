package org.omg.controller;

import java.util.List;

import javax.inject.Inject;

import org.omg.domain.MemberVO;
import org.omg.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Inject
	private MemberService memberService;
	
	// 회원목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void memberList(Model model) throws Exception {
		List<MemberVO> memberList = memberService.getMemberList();
		model.addAttribute("mList", memberList);
	}

}




















