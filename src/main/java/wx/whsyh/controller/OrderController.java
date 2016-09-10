package wx.whsyh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wx.whsyh.model.Order;
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
}
