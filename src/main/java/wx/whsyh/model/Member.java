package wx.whsyh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	
	public Member(int id,String name,String password, 
			String email,String nick_name,String member_garde,String create_date) {
		
	
		this.id = id;
		this.name = name;
		this.password=password;
		this.email=email;
		this.nick_name=nick_name;
		this.member_garde=member_garde;
		this.create_date = create_date;
	}
	public Member() {
		super();
	}
	
}