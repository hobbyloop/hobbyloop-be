package hobbyloop.backend.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.coupon.Coupon;
import hobbyloop.backend.domain.coupon.CouponRepository;
import hobbyloop.backend.domain.coupon.CouponStatus;
import hobbyloop.backend.domain.coupon.CouponType;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.userProfile.UserProfile;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {
	private final TicketRepository ticketRepository;
	private final CouponRepository couponRepository;

	private static final int BASIC_REWARD_PERCENT = 10;

	public List<TicketModelDTO> getTicketInfoByCenter(Center center, User user, UserProfile userProfile) {
		List<Ticket> allByCenter = ticketRepository.findAllByCenter(center);
		return allByCenter.stream()
			.map(ticket -> {
				int maxCouponValueOfTicket = getMaxCouponValueOfTicket(ticket, user);
				int basicReward = ticket.getPrice() / BASIC_REWARD_PERCENT;
				int usablePoint = userProfile.getGivenPoint() + userProfile.getChargedPoint();
				return new TicketModelDTO(ticket, maxCouponValueOfTicket, basicReward, usablePoint);
			})
			.collect(Collectors.toList());
	}

	private int getMaxCouponValueOfTicket(Ticket ticket, User user) {
		List<Coupon> allByUser = couponRepository.findAllByUserAndCouponStatus(user, CouponStatus.VALID);
		int maxValue = 0;
		for (Coupon coupon : allByUser) {
			if (coupon.getTicket().getTicketId().equals(ticket.getTicketId())) {
				maxValue = Math.max(maxValue, getValueOfCoupon(coupon, ticket));
			}
		}
		return maxValue;
	}

	private int getValueOfCoupon(Coupon coupon, Ticket ticket) {
		if (coupon.getCouponType().equals(CouponType.FIXED_AMOUNT)) {
			return ticket.getPrice() - coupon.getCouponValue();
		} else {
			return ticket.getPrice() / coupon.getCouponValue();
		}
	}
  
	@Transactional
	public Ticket createTicket(String ticketName, LocalDate ticketStartDate, LocalDate ticketEndDate, int amount,
		int price, int discountRate, Center center) {
		return ticketRepository.save(
			Ticket.builder()
				.ticketName(ticketName)
				.ticketStartDate(ticketStartDate)
				.ticketEndDate(ticketEndDate)
				.amount(amount)
				.price(price)
				.discountRate(discountRate)
				.center(center)
				.build()
		);
	}
}
