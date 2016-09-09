package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.whsyh.dao.OrderDaoI;
import wx.whsyh.model.Order;
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
	
}
