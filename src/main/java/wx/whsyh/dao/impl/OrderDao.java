package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.OrderDaoI;
import wx.whsyh.model.Order;;

@SuppressWarnings("unchecked")
@Repository("orderDao")
public class OrderDao extends BaseDao<Order> implements OrderDaoI {

	@Override
	public Order add(Order t) {
		return null;
	}

	@Override
	public void update(Order t) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public Order load(int id) {
		return null;
	}

	@Override
	public List<Order> findOrders() {
		Session session = this.getSession();
		Query query = session.createQuery("from Order");
//		Query query = session.createQuery("from Order  o where o.id=?");
//		query.setString(0, "2");
		return query.list();
//		return this.getSession().createQuery("from Product").list();
	}


}
