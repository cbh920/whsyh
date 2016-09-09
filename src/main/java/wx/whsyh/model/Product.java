package wx.whsyh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_product")
public class Product {
	private int id;
	private String coding;
	private String product_type;
	private String sale_price;
	private String is_putaway;
	private String create_date;
	
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
	public Product(int id, String coding, String product_type,
			String sale_price, String is_putaway, String create_date) {
		super();
		this.id = id;
		this.coding = coding;
		this.product_type = product_type;
		this.sale_price = sale_price;
		this.is_putaway = is_putaway;
		this.create_date = create_date;
	}
	public Product() {
		super();
	}
	
}
