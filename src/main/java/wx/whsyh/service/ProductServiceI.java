package wx.whsyh.service;

import java.util.List;

import wx.basic.util.Page;
import wx.whsyh.model.Product;

public interface ProductServiceI {
	public Page<Product> findProducts(int currentPage,int pageSize);
	
	public void addProduct(Product p);
	
	public void deleteProduct(Integer id);
	
	public List<Product> listByName(String name);
	
	public List<Product> listByWholeName(String name);
	
	public void updateProduct(Product p);
	
	public Product listById(int id);
	
	public List<Product> listByAppId(int id);
	
	public List<Product> listTypeAndName(String name,String type);
	
	public List<Product> listByType(String type);
}
