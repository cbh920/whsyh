package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.OrderDaoI;
import wx.whsyh.model.Order;
import wx.whsyh.model.Product;

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
		this.delete(id);	
	}

	@Override
	public Order load(int id) {
		return null;
	}

	@Override
	public List<Order> findOrders(int currentPage,int pageSize) {
		Session session = this.getSession();
		Query query = session.createQuery("from Order");
//		Query query = session.createQuery("from Order  o where o.id=?");
		query.setFirstResult(currentPage);
		query.setMaxResults(pageSize);
		return query.list();
//		return this.getSession().createQuery("from Product").list();
	}
	@Override
	public void deleteOrder(Integer id) {
		if(id!=null)
		{
			Session session = this.getSession();
			Query query= session.createQuery("delete from Order where id=?");
			query.setParameter(0, id);
			query.executeUpdate();
		}
	}

	@Override
	public List<Order> listByName(String name) {
		Session session = this.getSession();
		String hql="from Order as o where o.coding like:coding";
		Query query= session.createQuery(hql);
		query.setString("coding", "%"+name+"%");
		return query.list();
	}
	
	
	
	@Override
	public void updateOrder(Order o) {
		getSession().update(o);
	}
	
	@Override
	public Order listById(int id) {
		String hql="from Order as o where o.id=?";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		Order order = (Order)query.list().get(0);
		return order;
	}
	
	@Override
	public List<Order> listTypeAndName(String name, String type) {
		Session session = this.getSession();
		String hql="from Order as o where o.payment_method=? and o.coding like:coding";
		Query query= session.createQuery(hql);
		query.setParameter(0, type);
		query.setParameter("coding",name);
		return query.list();
	}
	
	@Override
	public List<Order> listByType(String type) {
		Session session = this.getSession();
		String hql="from Order as o where o.payment_method=?";
		Query query= session.createQuery(hql);
		query.setParameter(0, type);
		return query.list();
	}
	
	@Override
	public int getAllCount() {
		int count=((Long) getSession().createQuery( "select count(*) from Order").iterate().next()).intValue();
        return count;  
	}
}
