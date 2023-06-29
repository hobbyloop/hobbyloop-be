package hobbyloop.backend.domain.ticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.coupon.Coupon;
import hobbyloop.backend.domain.coupon.CouponRepository;
import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {
	private final TicketRepository ticketRepository;
	private final CouponRepository couponRepository;

	private static final int BASIC_REWARD_PERCENT = 10;

	public List<TicketModelDTO> getTicketInfoByCenter(Center center, User user) {
		List<Ticket> allByCenter = ticketRepository.findAllByCenter(center);
		List<TicketModelDTO> ticketModelDTOS = new ArrayList<>();
		for (Ticket ticket : allByCenter) {
			int maxCouponValueOfTicket = getMaxCouponValueOfTicket(ticket, user);
			int basicReward = ticket.getPrice() / BASIC_REWARD_PERCENT;
			TicketModelDTO ticketModelDTO = new TicketModelDTO(ticket, maxCouponValueOfTicket, basicReward);
			ticketModelDTOS.add(ticketModelDTO);
		}
		return ticketModelDTOS;
	}

	private int getMaxCouponValueOfTicket(Ticket ticket, User user) {
		List<Coupon> allByUser = couponRepository.findAllByUser(user);
		int maxValue = 0;
		for (Coupon coupon : allByUser) {
			if (coupon.getTicket().getTicketId().equals(ticket.getTicketId())) {
				maxValue = Math.max(maxValue, getValueOfCoupon(coupon, ticket));
			}
		}
		return maxValue;
	}

	//TODO 쿠폰 적용 로직 설정
	private int getValueOfCoupon(Coupon coupon, Ticket ticket) {
		return 0;
	}
}
