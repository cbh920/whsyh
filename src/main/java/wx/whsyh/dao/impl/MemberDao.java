package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.MemberDaoI;
import wx.whsyh.model.Member;

@SuppressWarnings("unchecked")
@Repository("memberDao")
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
	public List<Member> findMembers(int currentPage,int pageSize) {
		Session session = this.getSession();
		Query query = session.createQuery("from Member");
		query.setFirstResult(currentPage);
		query.setMaxResults(pageSize);
		return query.list();
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

	@Override
	public List<Member> listByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql="from Member as p where p.name like:name";
		Query query= session.createQuery(hql);
		query.setString("name", "%"+name+"%");
		return query.list();
	}

	@Override
	public List<Member> listTypeAndName(String name, String member_type) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql="from Member as p where p.member_garde=? and p.name like:name";
		Query query= session.createQuery(hql);
		query.setParameter(0, member_type);
		query.setParameter("name",name);
		return query.list();
	}

	@Override
	public List<Member> listByType(String member_type) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql="from Member as p where p.member_garde=?";
		Query query= session.createQuery(hql);
		query.setParameter(0, member_type);
		return query.list();
	}

	@Override
	public int getAllCount() {
		int count=((Long) getSession().createQuery( "select count(*) from Member").iterate().next()).intValue();
        return count;
	}

	@Override
	public List<Member> login(String username, String password) {
		String hql = "from Member as m where m.name=? and m.password=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		return query.list();
	}



}
