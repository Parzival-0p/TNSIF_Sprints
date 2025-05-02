package order.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "table_order")


public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	//variables
	private int orderId;
	private String customerName;
	private String product;
	private int quantity;
	
	
	
	//Default Constructor
	
	public Order() {
		super();
	}

	//Parameterized Constructor

	public Order(int orderId, String customerName, String product, int quantity) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.product = product;
		this.quantity = quantity;
	}

	
	//Getter and Setter
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	//String Representation
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	

}
