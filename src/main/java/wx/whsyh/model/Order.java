package wx.whsyh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_order")
public class Order {
	private int id;
	private String coding;
	private String money; 
	private String member;
	private String receiver;
	private String payment_method;
	private String send_method;
	private String state;
	private String create_date;
	private List<Product> product;//一个订单对应多个商品
	private Member member_name;//一个订单对应一个会员
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getSend_method() {
		return send_method;
	}
	public void setSend_method(String send_method) {
		this.send_method = send_method;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)  
	@JoinTable(name="t_order_product",joinColumns={@JoinColumn(name="order_id")},inverseJoinColumns={@JoinColumn(name="product_id")})  
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)  
	@JoinColumn(name="member_id")  
	public Member getMember_name() {
		return member_name;
	}
	public void setMember_name(Member member_name) {
		this.member_name = member_name;
	}
	
	public Order(int id, String coding, String money, String member, String receiver,
			String payment_method,String send_method,String state,String create_date) {
		
	
		this.id = id;
		this.coding = coding;
		this.money=money;
		this.member=member;
		this.receiver=receiver;
		this.payment_method=payment_method;
		this.send_method=send_method;
		this.state=state;
		this.create_date = create_date;
	}
	public Order() {
		super();
	}
	
	
	
	
}
