package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.basic.util.Page;
import wx.whsyh.dao.MemberDaoI;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;
import wx.whsyh.service.MemberServiceI;

@Service("memberService")
@Transactional
public class MemberService implements MemberServiceI {

	private MemberDaoI memberDao;
	
	public MemberDaoI getMemberDao() {
		return memberDao;
	}

	@Autowired
	public void setMemberDao(MemberDaoI memberDao) {
		this.memberDao = memberDao;
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@Override
	public Page<Member> findMembers(int currentPage,int pageSize) {
		Page page = new Page();
		int allCount = memberDao.getAllCount();
		int offset=page.countOffset(currentPage, pageSize);
		List<Member> list = memberDao.findMembers(offset, pageSize);
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allCount);
        page.setList(list);    
        return page;
	}
	
	@Override
	public void addMember(Member p) {
		memberDao.addMember(p);
	}
	
	@Override
	public void deleteMember(Integer id) {
		if(id!=null)
		{
			memberDao.deleteMember(id);
		}	
	}
	
	@Override
	public void updateMember(Member p) {
		memberDao.updateMember(p);
	}

	@Override
	public Member listById(int id) {
		// TODO Auto-generated method stub
		return memberDao.listById(id);
	}

	@Override
	public List<Member> listByName(String name) {
		// TODO Auto-generated method stub
		return memberDao.listByName(name);
	}

	@Override
	public List<Member> listByType(String member_type) {
		// TODO Auto-generated method stub
		return memberDao.listByType(member_type);
	}

	@Override
	public List<Member> listTypeAndName(String name, String member_type) {
		// TODO Auto-generated method stub
		return memberDao.listTypeAndName(name, member_type);
	}

	//app
	@Override
	public List<Member> login(String username, String password) {
		return memberDao.login(username, password);
	}

	@Override
	public List<Member> listByWholeName(String name) {
		return memberDao.listByWholeName(name);
	}
}
