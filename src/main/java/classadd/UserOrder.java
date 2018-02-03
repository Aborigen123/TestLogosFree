package classadd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_order")
@Getter @Setter
@NoArgsConstructor
public class UserOrder extends BaseEntity {

	@Column(name = "created_at", columnDefinition="TIMES DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@Override
	public String toString() {
		return "UserOrder [createdAt=" + createdAt + ", getId()=" + getId() + "]";
	}
	
	
}
