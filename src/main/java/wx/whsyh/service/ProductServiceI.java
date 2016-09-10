package wx.whsyh.service;

import java.util.List;

import wx.whsyh.model.Product;

public interface ProductServiceI {
	public List<Product> findProducts();
	
	public void addProduct(Product p);
	
	public void deleteProduct(Integer id);
	
	public List<Product> listByName(String name);
	
	public void updateProduct(Product p);
	
	public Product listById(int id);
}
