package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.whsyh.dao.ProductDaoI;
import wx.whsyh.model.Product;
import wx.whsyh.service.ProductServiceI;

@Service("productService")
@Transactional
public class ProductService implements ProductServiceI {

	private ProductDaoI productDao;
	
	public ProductDaoI getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(ProductDaoI productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findProducts() {
		return productDao.findProducts();
	}

	@Override
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		if(id!=null)
		{
			productDao.deleteProduct(id);
		}
		
	}

	@Override
	public List<Product> listByName(String name) {
		return productDao.listByName(name);
	}

	@Override
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	@Override
	public Product listById(int id) {
		return productDao.listById(id);
	}
	
}
