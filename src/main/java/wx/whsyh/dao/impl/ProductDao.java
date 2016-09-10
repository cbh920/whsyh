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


}
