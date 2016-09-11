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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import wx.basic.util.Page;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;
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

	@RequestMapping("/members.do")
	public String list(Model model,HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		
		Page page = MemberService.findMembers(Integer.valueOf(pageNo), 10);
		request.setAttribute("page", page);
		List<Member> list = page.getList();
		model.addAttribute("members",list);
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		p.setCreate_date(df.format(new Date())+"");
		
		MemberService.addMember(p);
		return "redirect:/member/members.do";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			MemberService.deleteMember(Integer.valueOf(ids[i]));
		}

		return "redirect:/member/members.do";
	}
	
	@RequestMapping(value="/updata/{id}")
	public String update(@PathVariable int id,Model model){
		
		model.addAttribute("p", MemberService.listById(id));
		return "/member_updata";
	}
	@RequestMapping(value="/updata_member/{id}",method=RequestMethod.POST)
	public String update(@Valid Member p,@PathVariable int id,@RequestParam(value="file",required=false) MultipartFile file,Model model,HttpServletRequest request)
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
		
		Member Member = MemberService.listById(id);
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		Member.setCreate_date(df.format(new Date())+"");
		
		Member.setName(p.getName());
		Member.setPassword(p.getPassword());
		Member.setEmail(p.getEmail());
		Member.setNick_name(p.getNick_name());
		Member.setMember_garde(p.getMember_garde());
		//Member.setCreate_date(p.getCreate_date());
		if(fileName!="")
		{
			Member.setImg_url(request.getContextPath()+"/upload/"+fileName);
		}
		MemberService.updateMember(Member);
		return "redirect:/member/members.do";
	}
	@RequestMapping(value="/list_name",method=RequestMethod.POST)
	public String listByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		String member_type = request.getParameter("member_type");
		String name = request.getParameter("search_text");
		if(member_type.equals("会员等级"))
		{
			model.addAttribute("listname", MemberService.listByName(name));
		}
		else if(name.equals(""))
		{
			model.addAttribute("listname", MemberService.listByType(member_type));
		}
		else{
			model.addAttribute("listname", MemberService.listTypeAndName(name, member_type));
		}
		return "/member_search";
	}
	
	@RequestMapping(value="/show/{id}")
	public String show(@PathVariable int id,Model model){

		model.addAttribute("show", MemberService.listById(id));
		return "/member_show";
	}
}
