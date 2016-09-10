package wx.whsyh.service;

import java.util.List;

import wx.whsyh.model.Order;

public interface OrderServiceI {
	public List<Order> findOrders();
	
	public void deleteOrder(Integer id);
}
