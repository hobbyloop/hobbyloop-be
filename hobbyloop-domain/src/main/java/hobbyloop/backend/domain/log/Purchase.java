package hobbyloop.backend.domain.log;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.user.User;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "centerId")
	private Center center;

	@ManyToOne
	@JoinColumn(name = "instructorId")
	private Instructor instructor;

	private int price;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

}
