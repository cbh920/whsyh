package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.whsyh.dao.UserDaoI;
import wx.whsyh.model.User;
import wx.whsyh.model.Product;
import wx.whsyh.service.UserServiceI;

@Service("UserService")
@Transactional
public class UserService implements UserServiceI {

	private UserDaoI UserDao;
	
	public UserDaoI getUserDao() {
		return UserDao;
	}

	@Autowired
	public void setUserDao(UserDaoI UserDao) {
		this.UserDao = UserDao;
	}

	@Override
	public List<User> findUsers() {
		return UserDao.findUsers();
	}
	
	@Override
	public void addUser(User p) {
		UserDao.addUser(p);
	}
	
	@Override
	public List<User> login(User p){
		return UserDao.login(p);
	}
	
}
