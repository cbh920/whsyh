package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Product;

public interface ProductDaoI extends BaseDaoI<Product> {
	public List<Product> findProducts();
	
	public void addProduct(Product p);
	
	public void deleteProduct(Integer id);
}
