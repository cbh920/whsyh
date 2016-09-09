package wx.whsyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		p.setCreate_date(df.format(new Date())+"");
		productService.addProduct(p);
		return "redirect:/product/products";
	}

	@SuppressWarnings("unused")
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		//		String idd= Arrays.toString(ids);
		//		model.addAttribute("is", idd);
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			productService.deleteProduct(Integer.valueOf(ids[i]));
		}

		return "redirect:/product/products";

	}

}
