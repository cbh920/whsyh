package wx.whsyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wx.basic.util.Page;
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
	public Page<Product> findProducts(int currentPage,int pageSize) {
		Page page = new Page();
		int allCount = productDao.getAllCount();
		int offset=page.countOffset(currentPage, pageSize);
		List<Product> list = productDao.findProducts(offset, pageSize);
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allCount);
        page.setList(list);    
        return page;
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

	@Override
	public List<Product> listTypeAndName(String name, String type) {
		return productDao.listTypeAndName(name, type);
	}

	@Override
	public List<Product> listByType(String type) {
		return productDao.listByType(type);
	}

	@Override
	public List<Product> listByWholeName(String name) {
		return productDao.listByWholeName(name);
	}

	@Override
	public List<Product> listByAppId(int id) {
		return productDao.listByAppId(id);
	}
	
	
}
