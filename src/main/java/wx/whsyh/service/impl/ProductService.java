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
	
}
