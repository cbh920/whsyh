package wx.whsyh.model;

import javax.persistence.*;
@Entity  
@Table(name="t_permission")
public class Permission {
	private Integer id;  
	private String permissionname;  
	private Role role;//一个权限对应一个角色  

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	public Integer getId() {  
		return id;  
	}  
	public void setId(Integer id) {  
		this.id = id;  
	}  
	public String getPermissionname() {  
		return permissionname;  
	}  
	public void setPermissionname(String permissionname) {  
		this.permissionname = permissionname;  
	} 
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)  
	@JoinColumn(name="role_id")  
	public Role getRole() {  
		return role;  
	}  
	public void setRole(Role role) {  
		this.role = role;  
	}
	public Permission(Integer id, String permissionname, Role role) {
		super();
		this.id = id;
		this.permissionname = permissionname;
		this.role = role;
	}
	public Permission() {
		super();
	}  
	
}
