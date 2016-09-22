package wx.whsyh.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_member")
public class Member {
	private int id;
	private String name;
	private String password; 
	private String email;
	private String nick_name;
	private String member_garde;
	private String create_date;
	private String img_url;
	private String address;
	private String phone;
	private List<Order> order;//一个会员对应多个订单
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMember_garde() {
		return member_garde;
	}
	public void setMember_garde(String member_garde) {
		this.member_garde = member_garde;
	}

	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public Member() {
		super();
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	@OneToMany(mappedBy="member")  
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public Member(int id,String name,String password, 
			String email,String nick_name,String member_garde,String create_date, String img_url,String address,String phone ) {
		
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.email=email;
		this.nick_name=nick_name;
		this.member_garde=member_garde;
		this.create_date = create_date;
		this.img_url = img_url;
		this.address = address;
		this.phone = phone;
	}
	


}
