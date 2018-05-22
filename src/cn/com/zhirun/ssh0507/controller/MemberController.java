package cn.com.zhirun.ssh0507.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.com.zhirun.ssh0507.model.Member;
import cn.com.zhirun.ssh0507.service.MemberService;

public class MemberController extends ActionSupport {
	MemberService memberService;
	List<Member> memberList;
	String name;
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String selectMember(){
		memberList = memberService.selectMember(name);
		return SUCCESS;
	}

}
