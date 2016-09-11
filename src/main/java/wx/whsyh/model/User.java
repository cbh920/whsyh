package wx.whsyh.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String name;
	private String password;
	private String sex;
	private String tel;
	private String address;
	private List<Role> roleList;//一个用户具有多个角色  

	
	public User(int id, String name, String password, String sex, String tel,
			String address, List<Role> roleList) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.roleList = roleList;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@NotNull(message="用户名不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message="密码不能为空")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)  
	@JoinTable(name="t_user_role",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="role_id")}) 
	public List<Role> getRoleList() {
		return roleList;
	}
	 
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}


}
