package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;;

public interface MemberDaoI extends BaseDaoI<Member> {
	public List<Member> findMembers();
	
	public void addMember(Member p);
}
