package hobbyloop.backend.domain.coupon;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Column(nullable = false)
	private String CouponNum;

	private LocalDateTime expireDate;

	@Enumerated(EnumType.STRING)
	private CouponStatus couponStatus;

	@Enumerated(EnumType.STRING)
	private CouponType couponType;

	private int couponValue;
}
