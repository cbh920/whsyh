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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_product")
public class Product {
	private int id;
	private String coding;
	private String name; 
	private String product_type;
	private String sale_price;
	private String is_putaway;
	private String create_date;
	private String img_url;
	private String stock;
	private String stock_in;
	private String stock_out;
	private String title;
	private String content;
	private List<Order> order;//一个商品对应多个订单
	
	public String getStock_in() {
		return stock_in;
	}
	public void setStock_in(String stock_in) {
		this.stock_in = stock_in;
	}
	public String getStock_out() {
		return stock_out;
	}
	public void setStock_out(String stock_out) {
		this.stock_out = stock_out;
	}
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
	@NotNull(message="商品名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	public String getIs_putaway() {
		return is_putaway;
	}
	public void setIs_putaway(String is_putaway) {
		this.is_putaway = is_putaway;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)  
	@JoinTable(name="t_order_product",joinColumns={@JoinColumn(name="product_id")},inverseJoinColumns={@JoinColumn(name="order_id")}) 
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public Product() {
		super();
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product(int id, String coding, String name, String product_type,
			String sale_price, String is_putaway, String create_date,
			String img_url, String stock, String stock_in, String stock_out,
			String title, String content, List<Order> order) {
		super();
		this.id = id;
		this.coding = coding;
		this.name = name;
		this.product_type = product_type;
		this.sale_price = sale_price;
		this.is_putaway = is_putaway;
		this.create_date = create_date;
		this.img_url = img_url;
		this.stock = stock;
		this.stock_in = stock_in;
		this.stock_out = stock_out;
		this.title = title;
		this.content = content;
		this.order = order;
	}
	
}
