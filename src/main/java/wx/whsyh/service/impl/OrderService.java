package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.whsyh.dao.OrderDaoI;
import wx.whsyh.model.Order;
import wx.whsyh.model.Product;
import wx.whsyh.service.OrderServiceI;

@Service("orderService")
@Transactional
public class OrderService implements OrderServiceI {

	private OrderDaoI orderDao;
	
	public OrderDaoI getOrderDao() {
		return orderDao;
	}

	@Autowired
	public void setOrderDao(OrderDaoI orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> findOrders() {
		return orderDao.findOrders();
	}
	
	@Override
	public void deleteOrder(Integer id) {
		if(id!=null)
		{
			orderDao.deleteOrder(id);
		}
		
	}
	
	@Override
	public List<Order> listByName(String name) {
		return orderDao.listByName(name);
	}

	@Override
	public void updateOrder(Order p) {
		orderDao.updateOrder(p);
	}

	@Override
	public Order listById(int id) {
		return orderDao.listById(id);
	}

	@Override
	public List<Order> listTypeAndName(String name, String type) {
		return orderDao.listTypeAndName(name, type);
	}
	
	@Override
	public List<Order> listByType(String type) {
		return orderDao.listByType(type);
	}
	
}
