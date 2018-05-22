package cn.com.zhirun.ssh0507.service;

import java.util.List;

import cn.com.zhirun.ssh0507.dao.MemberDao;
import cn.com.zhirun.ssh0507.model.Member;

public class MemberService {
	
	MemberDao memberDao;
	
	public List<Member> selectMember(String name){
		
		return memberDao.selectMember(name);
		
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
