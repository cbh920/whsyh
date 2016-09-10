package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.UserDaoI;
import wx.whsyh.model.User;
import wx.whsyh.model.Product;;

@SuppressWarnings("unchecked")
@Repository("UserDao")
public class UserDao extends BaseDao<User> implements UserDaoI {

	@Override
	public User add(User t) {
		return null;
	}

	@Override
	public void update(User t) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public User load(int id) {
		return null;
	}

	@Override
	public List<User> findUsers() {
		Session session = this.getSession();
		Query query = session.createQuery("from User");

		return query.list();

	}
	
	@Override
	public void addUser(User p) {
		// TODO Auto-generated method stub
		super.add(p);
	}
	
	@Override
	public List<User> login(User p){
		String name=p.getName();
		String password=p.getPassword();
		Session session=this.getSession();
		Query query= session.createQuery(" from User where name=?");
		query.setParameter(0, name);
		List<User> user = query.list();


		return user;
	}


}
