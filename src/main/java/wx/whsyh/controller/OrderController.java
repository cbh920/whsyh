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

import wx.whsyh.model.Order;
import wx.whsyh.model.Product;
import wx.whsyh.service.OrderServiceI;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private OrderServiceI orderService;

	public OrderServiceI getOrderService() {
		return orderService;
	}

	@Autowired
	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
	}
	@RequestMapping("/orders")
	public String list(Model model)
	{
		model.addAttribute("orders", orderService.findOrders());
		return "/order_manage";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			orderService.deleteOrder(Integer.valueOf(ids[i]));
		}

		return "redirect:/order/orders";

	}
	@RequestMapping(value="/list_name",method=RequestMethod.POST)
	public String listByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		String type = request.getParameter("goods_select");
		String name = request.getParameter("search_text");
		if(type.equals("付款方式"))
		{
			model.addAttribute("listname", orderService.listByName(name));
		}
		else if(name.equals(""))
		{
			model.addAttribute("listname", orderService.listByType(type));
		}
		else{
			model.addAttribute("listname", orderService.listTypeAndName(name, type));
		}
		return "/order_search";
	}

	@RequestMapping(value="/updata/{id}")
	public String update(@PathVariable int id,Model model){
		
		model.addAttribute("o", orderService.listById(id));
		return "/order_updata";
	}
	@RequestMapping(value="/updata_order/{id}",method=RequestMethod.POST)
	public String update(@Valid Order o,@PathVariable int id,Model model)
	{
		Order order = orderService.listById(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		order.setCreate_date(df.format(new Date())+"");
		order.setCoding(o.getCoding());
		order.setMember(o.getMember());
        order.setMoney(o.getMoney());
        order.setPayment_method(o.getPayment_method());
        order.setReceiver(o.getReceiver());
        order.setSend_method(o.getSend_method());
        order.setState(o.getState());
		orderService.updateOrder(order);
		return "redirect:/order/orders";
	}
}
