package hobbyloop.backend.domain.coupon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.user.User;
import lombok.Getter;

@Entity
@Getter
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long couponId;

	@ManyToOne
	private User user;

	@ManyToOne
	private Ticket ticket;

}
