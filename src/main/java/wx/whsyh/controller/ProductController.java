package wx.whsyh.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import wx.basic.util.Page;
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
	@RequestMapping("/products.do")
	public String list(Model model,HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		
		String page_size = request.getParameter("page_size");
		if(page_size==null || page_size.equals(""))
		{
			page_size = "10";
		}
		Page page = productService.findProducts(Integer.valueOf(pageNo), Integer.valueOf(page_size));
		request.setAttribute("page", page);
		List<Product> list = page.getList();
		model.addAttribute("datas",list);
		return "/product";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProduct()
	{

		return "/product_add";

	}

	@RequestMapping(value="/add_porduct",method=RequestMethod.POST)
	public String add(@Valid Product p,Model model,@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request)
	{
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String fileName = file.getOriginalFilename();  
		File targetFile = new File(path, fileName);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  

		//保存  
		try {  
			file.transferTo(targetFile);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		p.setCreate_date(df.format(new Date())+"");
		p.setImg_url(request.getContextPath()+"/upload/"+fileName);
		productService.addProduct(p);
		return "redirect:/product/products.do";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			productService.deleteProduct(Integer.valueOf(ids[i]));
		}

		return "redirect:/product/products.do";

	}

	@RequestMapping(value="/list_name",method=RequestMethod.POST)
	public String listByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		String type = request.getParameter("goods");
		String name = request.getParameter("search_text");
		if(type.equals("商品筛选"))
		{
			model.addAttribute("listname", productService.listByName(name));
		}
		else if(name.equals(""))
		{
			model.addAttribute("listname", productService.listByType(type));
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

	@RequestMapping(value="/show/{id}")
	public String show(@PathVariable int id,Model model){

		model.addAttribute("show", productService.listById(id));
		return "/product_show";
	}

	@RequestMapping(value="/updata_product/{id}",method=RequestMethod.POST)
	public String update(@Valid Product p,@PathVariable int id,@RequestParam(value="file",required=false) MultipartFile file,Model model,HttpServletRequest request)
	{
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String fileName = file.getOriginalFilename();  
		File targetFile = new File(path, fileName);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  

		//保存  
		try {  
			file.transferTo(targetFile);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		Product product = productService.listById(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		product.setCreate_date(df.format(new Date())+"");
		product.setCoding(p.getCoding());
		product.setIs_putaway(p.getIs_putaway());
		product.setName(p.getName());
		product.setProduct_type(p.getProduct_type());
		product.setSale_price(p.getSale_price());
		product.setImg_url(request.getContextPath()+"/upload/"+fileName);
		productService.updateProduct(product);
		return "redirect:/product/products.do";
	}
	
	
	@RequestMapping(value="/stock")
	public String jump_stock(Model model,HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		
		String page_size = request.getParameter("page_size");
		if(page_size==null || page_size.equals(""))
		{
			page_size = "10";
		}
		Page page = productService.findProducts(Integer.valueOf(pageNo), Integer.valueOf(page_size));
		request.setAttribute("page", page);
		List<Product> list = page.getList();
		model.addAttribute("stock",list);
		return "/product_stock";
	}
	@RequestMapping(value="/stock_in")
	public String stock_in()
	{

		return "/stock_in";

	}
	@RequestMapping(value="/stock_out")
	public String stock_out()
	{

		return "/stock_out";

	}
	@RequestMapping(value="/stock_search",method=RequestMethod.POST)
	public String stockByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		
		String name = request.getParameter("text");
		
		model.addAttribute("listname", productService.listByName(name));
		
		return "/stock_in";
	}

}
