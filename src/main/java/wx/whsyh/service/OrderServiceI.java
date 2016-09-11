package wx.whsyh.service;

import java.util.List;

import wx.basic.util.Page;
import wx.whsyh.model.Order;
import wx.whsyh.model.Product;

public interface OrderServiceI {
	public Page<Product> findOrders(int currentPage,int pageSize);
	
	public void deleteOrder(Integer id);
	
public List<Order> listByName(String name);
	
	public void updateOrder(Order o);
	
	public Order listById(int id);
	
	public List<Order> listTypeAndName(String name,String type);
	
	public List<Order> listByType(String type);
}
