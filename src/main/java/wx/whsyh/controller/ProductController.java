package wx.whsyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wx.whsyh.service.ProductServiceI;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private ProductServiceI productService;

	public ProductServiceI getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductServiceI productService) {
		this.productService = productService;
	}
	@RequestMapping("/products")
	public String list(Model model)
	{
		System.out.println("hello");
		model.addAttribute("datas", productService.findProducts());
		return "/product";
	}
	
}
