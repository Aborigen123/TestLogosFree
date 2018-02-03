package classadd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_order")
@Getter @Setter
@NoArgsConstructor
public class UserOrder extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany
	private List<Item> items = new ArrayList<>();

	@Column(name = "created_at", columnDefinition="TIMES DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Override
	public String toString() {
		return "UserOrder [createdAt=" + createdAt + ", getId()=" + getId() + "]";
	}
	
	
}
