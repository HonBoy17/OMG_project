package org.omg.service;

import java.util.List;

import javax.inject.Inject;

import org.omg.domain.MemberVO;
import org.omg.repository.MemberPersistence;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberPersistence memberPersistence;
	
	@Override
	public void insert(MemberVO mvo) throws Exception {
		memberPersistence.insert(mvo);
	}

	@Override
	public MemberVO idCheck(String userid) throws Exception {
		return  memberPersistence.idCheck(userid);
	}

	@Override
	public MemberVO login(MemberVO mvo) throws Exception {
		return memberPersistence.login(mvo);
	}
	
	@Override
	public MemberVO getMemberInfo(String userid) throws Exception {
		return memberPersistence.getMemberInfo(userid);
	}

	@Override
	public void modify(MemberVO mvo) throws Exception {
		memberPersistence.modify(mvo);
	}

	@Override
	public void delete(MemberVO mvo) throws Exception {
		memberPersistence.delete(mvo);
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return memberPersistence.getMemberList();
	}

}










