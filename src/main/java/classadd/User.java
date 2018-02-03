package classadd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
public class User extends BaseEntity {
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Enumerated(EnumType.STRING)// ORDINAL -  номерація з енум , STRING - назви з енум повні
	private Gender gender;

	public User(String firstName, String lastName, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", getId()=" + getId()
				+ "]";
	}

	
}
