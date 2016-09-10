package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.whsyh.dao.MemberDaoI;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;
import wx.whsyh.service.MemberServiceI;

@Service("MemberService")
@Transactional
public class MemberService implements MemberServiceI {

	private MemberDaoI MemberDao;
	
	public MemberDaoI getMemberDao() {
		return MemberDao;
	}

	@Autowired
	public void setMemberDao(MemberDaoI MemberDao) {
		this.MemberDao = MemberDao;
	}

	@Override
	public List<Member> findMembers() {
		return MemberDao.findMembers();
	}
	
	@Override
	public void addMember(Member p) {
		MemberDao.addMember(p);
	}
	
	@Override
	public void deleteMember(Integer id) {
		if(id!=null)
		{
			MemberDao.deleteMember(id);
		}
		
	}
}
