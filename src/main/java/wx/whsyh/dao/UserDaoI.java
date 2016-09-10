package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.User;

public interface UserDaoI extends BaseDaoI<User> {
	public List<User> findUsers();
	
	public void addUser(User p);
	
	public List<User> login(User p);
}
