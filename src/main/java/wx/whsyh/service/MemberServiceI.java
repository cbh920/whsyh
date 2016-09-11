package wx.whsyh.service;

import java.util.List;

import wx.basic.util.Page;
import wx.whsyh.model.Member;


public interface MemberServiceI {
	public Page<Member> findMembers(int currentPage,int pageSize);
	
	public void addMember(Member p);
	
	public void deleteMember(Integer id);
	
	public void updateMember(Member p);
	
	public Member listById(int id);
	
	public List<Member> listByName(String name);
	
	public List<Member> listByType(String member_type);
	
	public List<Member> listTypeAndName(String name,String member_type);
}
