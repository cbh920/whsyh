package wx.whsyh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wx.whsyh.model.User;
import wx.whsyh.service.UserServiceI;

@Controller
@RequestMapping("/User")
public class UserController {
	
	private UserServiceI UserService;

	public UserServiceI getUserService() {
		return UserService;
	}

	@Autowired
	public void setUserService(UserServiceI UserService) {
		this.UserService = UserService;
	}
	
	@RequestMapping("/login")
	public String jump_login(Model model)
	{
		
		return "/login";
	}
	
	@RequestMapping("/homepage")
	public String jump_homepage(Model model)
	{
		
		return "/homepage";
	}
	
	
	@RequestMapping(value="/login_success",method=RequestMethod.POST)
	public String login(@Valid User p,Model model)
	{
		List<User> user=UserService.login(p);
		String pass2="";
		User user2=null;
		System.out.println(UserService.login(p));
		if(!user.isEmpty()){
			for (User c : user) {  
				user2=c;
	        }
			model.addAttribute("user", user2);
			pass2=user2.getPassword();
			if(pass2.equals(p.getPassword())){
				return "/homepage";
			}
			
		}
		return "redirect:/User/login";
	}
	
}
