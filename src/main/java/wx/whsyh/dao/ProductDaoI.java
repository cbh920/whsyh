package wx.whsyh.dao;

import java.util.List;

import wx.basic.dao.BaseDaoI;
import wx.whsyh.model.Product;

public interface ProductDaoI extends BaseDaoI<Product> {
	public List<Product> findProducts(int currentPage,int pageSize);
	
	public void addProduct(Product p);
	
	public void deleteProduct(Integer id);
	
	public List<Product> listByName(String name);
	
	public List<Product> listByWholeName(String name);
	
	public void updateProduct(Product p);
	
	public Product listById(int id);
	
	public List<Product> listByAppId(int id);
	
	public List<Product> listTypeAndName(String name,String type);
	
	public List<Product> listByType(String type);
	
	public int getAllCount();
	
}
