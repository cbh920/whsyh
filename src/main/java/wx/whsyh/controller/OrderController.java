package wx.whsyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
