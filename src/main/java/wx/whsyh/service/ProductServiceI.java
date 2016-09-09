package wx.whsyh.service;

import java.util.List;

import wx.whsyh.model.Product;

public interface ProductServiceI {
	public List<Product> findProducts();
	
	public void addProduct(Product p);
}
