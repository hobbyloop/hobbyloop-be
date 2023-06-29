package hobbyloop.backend.domain.ticket;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
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

	private int price;

	private int days;

	private int count;

	private int salesAmount;

	private double score;

	private int basicReward;
}
