package wx.whsyh.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import wx.basic.dao.BaseDao;
import wx.whsyh.dao.ProductDaoI;
import wx.whsyh.model.Product;

@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDao extends BaseDao<Product> implements ProductDaoI {

	@Override
	public Product add(Product p) {
		return null;
	}

	@Override
	public void update(Product t) {

	}

	@Override
	public void delete(int id) {
		this.delete(id);	
	}

	@Override
	public Product load(int id) {
		return null;
	}

	@Override
	public List<Product> findProducts() {
		Session session = this.getSession();
		Query query = session.createQuery("from Product");
		return query.list();
//		return this.getSession().createQuery("from Product").list();
	}

	@Override
	public void addProduct(Product p) {
		super.add(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		if(id!=null)
		{
			Session session = this.getSession();
			Query query= session.createQuery("delete from Product where id=?");
			query.setParameter(0, id);
			query.executeUpdate();
		}
	}

	@Override
	public List<Product> listByName(String name) {
		Session session = this.getSession();
		String hql="from Product as p where p.name like:name";
		Query query= session.createQuery(hql);
		query.setString("name", "%"+name+"%");
		return query.list();
	}

	@Override
	public void updateProduct(Product p) {
		getSession().update(p);
	}

	@Override
	public Product listById(int id) {
		String hql="from Product as p where p.id=?";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		Product product = (Product) query.list().get(0);
		return product;
	}

	@Override
	public List<Product> listTypeAndName(String name, String type) {
		Session session = this.getSession();
		String hql="from Product as p where p.product_type=? and p.name like:name";
		Query query= session.createQuery(hql);
		query.setParameter(0, type);
		query.setParameter("name",name);
		return query.list();
	}

	@Override
	public List<Product> listByType(String type) {
		Session session = this.getSession();
		String hql="from Product as p where p.product_type=?";
		Query query= session.createQuery(hql);
		query.setParameter(0, type);
		return query.list();
	}
	
}
