package wx.whsyh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wx.whsyh.model.Member;
import wx.whsyh.service.MemberServiceI;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private MemberServiceI MemberService;

	public MemberServiceI getMemberService() {
		return MemberService;
	}

	@Autowired
	public void setMemberService(MemberServiceI MemberService) {
		this.MemberService = MemberService;
	}
	@RequestMapping("/members")
	public String list(Model model)
	{
		model.addAttribute("members", MemberService.findMembers());
		return "/usermanager";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addMember()
	{
		return "/user_add";
		
	}
	@RequestMapping(value="/add_member",method=RequestMethod.POST)
	public String add(@Valid Member p,Model model)
	{
		MemberService.addMember(p);
		return "redirect:/member/members";
		
	}
	
}
