package wx.whsyh.service;

import java.util.List;

import wx.whsyh.model.Member;
import wx.whsyh.model.Product;

public interface MemberServiceI {
	public List<Member> findMembers();
	
	public void addMember(Member p);
	
	public void deleteMember(Integer id);
	
	public void updateMember(Member p);
	
	public Member listById(int id);
	
	public List<Member> listByName(String name);
	
	public List<Member> listByType(String member_type);
	
	public List<Member> listTypeAndName(String name,String member_type);
}
