package hobbyloop.backend.domain.ticket;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId")
	private Center center;

	@Enumerated(value = EnumType.STRING)
	private TicketType ticketType;

	private String ticketName;

	private String ticketImageUrl;

	private LocalDate ticketStartDate;

	private LocalDate ticketEndDate;

	private int amount;

	private int price;

	private int discountRate;

	private int days;

	private int count;

	private int salesAmount;

	private double score;

	private int basicReward;
}
