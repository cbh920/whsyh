package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Order;
import wx.whsyh.model.Product;

public interface OrderDaoI extends BaseDaoI<Order> {
	public List<Order> findOrders();
	
	public void deleteOrder(Integer id);
	
	public List<Order> listByName(String name);
	
	public void updateOrder(Order o);
	
	public Order listById(int id);
	
	public List<Order> listTypeAndName(String name,String type);
	
	public List<Order> listByType(String type);
}
