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
		this.delete(id);
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

	@Override
	public void deleteMember(Integer id) {
		// TODO Auto-generated method stub
		if(id!=null)
		{
			Session session = this.getSession();
			Query query= session.createQuery("delete from Member where id=?");
			query.setParameter(0, id);
			query.executeUpdate();
		}
	}
	
	@Override
	public void updateMember(Member p) {
		getSession().update(p);
	}

	@Override
	public Member listById(int id) {
		// TODO Auto-generated method stub
		String hql="from Member as p where p.id=?";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		Member member = (Member) query.list().get(0);
		return member;
	}

}
