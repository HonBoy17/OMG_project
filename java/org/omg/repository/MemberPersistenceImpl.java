package org.omg.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.omg.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberPersistenceImpl implements MemberPersistence {
	
	@Inject
	private SqlSession sql;
	private static String namespace="org.omg.mappers.member";
	
	@Override
	public void insert(MemberVO mvo) throws Exception {
		sql.insert(namespace+".insert", mvo);
	}

	@Override
	public MemberVO idCheck(String userid) throws Exception {
		return sql.selectOne(namespace+".idCheck", userid); 
	}
	
	@Override
	public MemberVO login(MemberVO mvo) throws Exception {
		return sql.selectOne(namespace+".login", mvo);
	}
	
	@Override
	public MemberVO getMemberInfo(String userid) throws Exception {
		return sql.selectOne(namespace+".view", userid);
	}

	@Override
	public void modify(MemberVO mvo) throws Exception {
		sql.update(namespace+".modify", mvo);
	}

	@Override
	public void delete(MemberVO mvo) throws Exception {
		sql.delete(namespace+".delete", mvo);
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return sql.selectList(namespace+".list");
	}

}










