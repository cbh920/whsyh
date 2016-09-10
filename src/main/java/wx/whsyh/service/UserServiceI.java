package wx.whsyh.service;

import java.util.List;

import wx.whsyh.model.User;
import wx.whsyh.model.Product;

public interface UserServiceI {
	public List<User> findUsers();
	public void addUser(User p);
	public List<User> login(User p);
}
