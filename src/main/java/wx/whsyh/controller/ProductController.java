package wx.whsyh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wx.whsyh.model.Product;
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
		model.addAttribute("datas", productService.findProducts());
		return "/product";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProduct()
	{
		return "/product_add";
		
	}
	
	@RequestMapping(value="/add_porduct",method=RequestMethod.POST)
	public String add(@Valid Product p,Model model)
	{
		productService.addProduct(p);
		return "redirect:/product/products";
		
	}
	
}
