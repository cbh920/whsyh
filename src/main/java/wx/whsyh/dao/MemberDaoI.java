package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;;

public interface MemberDaoI extends BaseDaoI<Member> {
	public List<Member> findMembers(int currentPage,int pageSize);
	
	public void addMember(Member p);
	
	public void deleteMember(Integer id);
	
	public void updateMember(Member p);

	public Member listById(int id);
	
	public List<Member> listByName(String name);
	
	public List<Member> listByType(String member_type);
	
	public List<Member> listTypeAndName(String name,String type);
	
	public int getAllCount();
	
	//app
	public List<Member> login(String username,String password);
}
