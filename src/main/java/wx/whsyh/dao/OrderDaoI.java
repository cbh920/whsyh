package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Order;;

public interface OrderDaoI extends BaseDaoI<Order> {
	public List<Order> findOrders();
	
}
