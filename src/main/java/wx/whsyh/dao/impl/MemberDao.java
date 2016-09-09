package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.MemberDaoI;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;;

@SuppressWarnings("unchecked")
@Repository("MemberDao")
public class MemberDao extends BaseDao<Member> implements MemberDaoI {

	@Override
	public Member add(Member t) {
		return null;
	}

	@Override
	public void update(Member t) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public Member load(int id) {
		return null;
	}

	@Override
	public List<Member> findMembers() {
		Session session = this.getSession();
		Query query = session.createQuery("from Member");
//		Query query = session.createQuery("from Member  o where o.id=?");
//		query.setString(0, "2");
		return query.list();
//		return this.getSession().createQuery("from Product").list();
	}
	
	@Override
	public void addMember(Member p) {
		// TODO Auto-generated method stub
		super.add(p);
	}


}
