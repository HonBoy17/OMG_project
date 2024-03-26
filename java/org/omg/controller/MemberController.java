package org.omg.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.domain.MemberVO;
import org.omg.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	

	// 회원가입 약관 동의 화면 처리
	@RequestMapping(value="/join-term", method=RequestMethod.GET)
	public void joinTerm() throws Exception {}
	
	// 회원가입 데이터 입력 화면 처리
	@RequestMapping(value="/join-insert", method=RequestMethod.GET)
	public void joinForm() throws Exception {}
	
	// 회원가입 데이터(MemberVO) 처리(POST)
	@RequestMapping(value="/join-insert", method=RequestMethod.POST)
	public String joinInsert(MemberVO mvo) throws Exception {
		memberService.insert(mvo);
		
		return "redirect:/member/join-finish";
	}
	
	// 회원가입 완료 화면 처리
	@RequestMapping(value="/join-finish", method=RequestMethod.GET)
	public void joinFinish() throws Exception {}
	
	// 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	public String idCheck(HttpServletRequest request) throws Exception {
		String userid = request.getParameter("userId");
		MemberVO mvo = memberService.idCheck(userid);
        System.out.println(userid);
		String result = null;
		
		if (mvo != null) { result = "duplicate"; }
		
		return result;
	}
	
	// 로그인 화면 처리(GET)
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginForm() throws Exception {}
	
	// 로그인 데이터(MemberVO) 처리(POST)
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO mvo, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		MemberVO dbmvo = memberService.login(mvo);
		HttpSession session = request.getSession();
		
		if (dbmvo == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", dbmvo);
			
		}
		
		return "redirect:/";
	}
	
	// 로그아웃 처리
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:/";
	}
	
	// 마이페이지 화면 처리(GET)
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void mypage(@RequestParam("userid") String userid, Model model) throws Exception {
		MemberVO mvo = memberService.getMemberInfo(userid);
		model.addAttribute("mypage", mvo);
	}
	
	// 정보수정 화면 처리(GET)
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyForm(@RequestParam("userid") String userid, Model model) throws Exception {
		MemberVO mvo = memberService.getMemberInfo(userid);
		model.addAttribute("modify", mvo);
	}
	
	// 정보수정 데이터 처리(POST)
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(MemberVO mvo) throws Exception {
		memberService.modify(mvo);
		
		return "redirect:/member/mypage?userid="+mvo.getUserid();
	}
	
	// 회원삭제 화면 처리(GET)
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public void deleteGet(@RequestParam("userid") String userid, Model model) throws Exception {
		MemberVO mvo = memberService.getMemberInfo(userid);
		model.addAttribute("delete", mvo);
	}
	
	// 회원삭제 데이터 처리(POST)
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deletePost(MemberVO mvo, HttpSession session) throws Exception {
		String userId = mvo.getUserid();
		String userPass = mvo.getPassword();
		MemberVO member = memberService.getMemberInfo(userId);
		String memberPass = member.getPassword(); 
		
		if (userPass.equals(memberPass)) {
			memberService.delete(mvo);
			session.invalidate();
		}
		
		return "redirect:/";
	}

}




















