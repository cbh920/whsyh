package wx.whsyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexContrroller {
	@RequestMapping("/jsp")
	public String index()
	{
		return "homepage";
	}
}
