package classadd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(
		callSuper = true,
		exclude = {"description", "price", "amount"})
public class Item extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price", columnDefinition = "decimal(6,2)")
	private BigDecimal price;
	
	@Column(name = "amount")
	private int amount;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "categori_id")
	private Category categori;
	
	
	@ManyToMany 
 	@JoinTable(name = "user_order_item",  
 	joinColumns = @JoinColumn(name = "item_id"), 
 	inverseJoinColumns = @JoinColumn(name = "user_order_id"))
	private List<UserOrder> items = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", price=" + price + ", amount=" + amount
				+ ", getId()=" + getId() + "]";
	}




	public Item(String name, String description, BigDecimal price, int amount) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

	
	
}
