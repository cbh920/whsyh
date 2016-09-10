package wx.whsyh.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			productService.deleteProduct(Integer.valueOf(ids[i]));
		}

		return "redirect:/product/products";

	}
	
	@RequestMapping(value="/list_name",method=RequestMethod.GET)
	public String listByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		String type = new String(request.getParameter("goods").getBytes("ISO-8859-1"),"UTF-8");
		String name = new String(request.getParameter("search_text").getBytes("ISO-8859-1"),"UTF-8");
		if(type.equals("商品筛选"))
		{
			model.addAttribute("listname", productService.listByName(name));
		}
		else{
			model.addAttribute("listname", productService.listTypeAndName(name, type));
		}
		return "/product_search";
	}

	@RequestMapping(value="/updata/{id}")
	public String update(@PathVariable int id,Model model){
		
		model.addAttribute("p", productService.listById(id));
		return "/product_updata";
	}
	@RequestMapping(value="/updata_product/{id}",method=RequestMethod.POST)
	public String update(@Valid Product p,@PathVariable int id,Model model)
	{
		Product product = productService.listById(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		product.setCreate_date(df.format(new Date())+"");
		product.setCoding(p.getCoding());
		product.setIs_putaway(p.getIs_putaway());
		product.setName(p.getName());
		product.setProduct_type(p.getProduct_type());
		product.setSale_price(p.getSale_price());
		productService.updateProduct(product);
		return "redirect:/product/products";
	}
	
}
