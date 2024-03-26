package org.omg.service;

import java.util.List;

import org.omg.domain.MemberVO;

public interface MemberService {
	
	// MemberController 시작
	public void insert(MemberVO mvo) throws Exception;
	
	public MemberVO idCheck(String userid) throws Exception;
	
	public MemberVO login(MemberVO mvo) throws Exception;
	
	public MemberVO getMemberInfo(String userid) throws Exception;
	
	public void modify(MemberVO mvo) throws Exception;
	
	public void delete(MemberVO mvo) throws Exception;
	
	// AdminController 시작
	public List<MemberVO> getMemberList() throws Exception;	

}










