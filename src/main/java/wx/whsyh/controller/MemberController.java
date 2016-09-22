package wx.whsyh.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import wx.basic.util.JSONUtil;
import wx.basic.util.Page;
import wx.whsyh.model.Member;
import wx.whsyh.model.Product;
import wx.whsyh.service.MemberServiceI;

@Controller
@RequestMapping("/member")
public class MemberController {

	private MemberServiceI memberService;

	public MemberServiceI getMemberService() {
		return memberService;
	}

	@Autowired
	public void setMemberService(MemberServiceI memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/members.do")
	public String list(Model model,HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}

		String page_size = request.getParameter("goods_page");
		if(page_size==null || page_size.equals(""))
		{
			page_size = "10";
		}

		Page page = memberService.findMembers(Integer.valueOf(pageNo), Integer.valueOf(page_size));
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
	public String add(@Valid Member p,Model model,@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request)
	{ 
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String fileName = file.getOriginalFilename();  
		File targetFile = new File(path, fileName);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  

		try {  
			file.transferTo(targetFile);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		p.setCreate_date(df.format(new Date())+"");

		p.setImg_url(request.getContextPath()+"/upload/"+fileName);

		memberService.addMember(p);
		return "redirect:/member/members.do";

	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(HttpServletRequest request,Model model)
	{
		String [] ids = request.getParameterValues("ids");

		for(int i=0;i<ids.length;i++)
		{
			memberService.deleteMember(Integer.valueOf(ids[i]));
		}

		return "redirect:/member/members.do";
	}

	@RequestMapping(value="/updata/{id}")
	public String update(@PathVariable int id,Model model){

		model.addAttribute("p", memberService.listById(id));
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

		Member Member = memberService.listById(id);

		Member.setName(p.getName());
		Member.setPassword(p.getPassword());
		Member.setEmail(p.getEmail());
		Member.setNick_name(p.getNick_name());
		Member.setMember_garde(p.getMember_garde());

		//
		if(fileName!="")
		{
			Member.setImg_url(request.getContextPath()+"/upload/"+fileName);
		}
		memberService.updateMember(Member);
		return "redirect:/member/members.do";
	}
	@RequestMapping(value="/list_name",method=RequestMethod.POST)
	public String listByName(HttpServletRequest request,Model model) throws UnsupportedEncodingException
	{
		String member_type = request.getParameter("member_type");
		String name = request.getParameter("search_text");
		if(member_type.equals("会员等级"))
		{
			model.addAttribute("listname", memberService.listByName(name));
		}
		else if(name.equals(""))
		{
			model.addAttribute("listname", memberService.listByType(member_type));
		}
		else{
			model.addAttribute("listname", memberService.listTypeAndName(name, member_type));
		}
		return "/member_search";
	}

	@RequestMapping(value="/show/{id}")
	public String show(@PathVariable int id,Model model){

		model.addAttribute("show", memberService.listById(id));
		return "/member_show";
	}

	/**
	 * 前台登陆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response){
		String msg = "eroor";
		String username = request.getParameter("username");
		String password = request.getParameter("userpwd");
		try{
			List<Member> members = memberService.login(username, password);
			if (members != null && !members.equals("")) {
				JSONObject json = new JSONObject();
				msg=JSONArray.toJSONString(members).toString();
				System.out.println(msg);
			} else {
				msg = "none";
				System.out.println("查询失败！！！");
			}
			response.setContentType("text/json; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前台注册
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException
	{

		String msg = "eroor";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		Member member = new Member();
		member.setEmail(email);
		member.setName(username);
		member.setPassword(password);
		member.setAddress(address);
		member.setPhone(phone);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		member.setCreate_date(df.format(new Date())+"");
		memberService.addMember(member);
		
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
	
	/**
	 * 前台查询个人信息
	 */
	@RequestMapping(value="/showInfo",method=RequestMethod.POST)
	public void showInfo(HttpServletRequest request,HttpServletResponse response)
	{
		String msg = "error";
		String name = request.getParameter("name");
		try{
			List<Member> member = memberService.listByName(name);
			if (member != null && !member.equals("")) {
				JSONObject json = new JSONObject();
				msg=JSONArray.toJSONString(member).toString();
				System.out.println(msg);
			} else {
				msg = "error";
				System.out.println("查询失败！！！");
			}
			response.setContentType("text/json; charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
